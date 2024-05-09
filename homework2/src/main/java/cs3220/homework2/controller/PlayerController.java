package cs3220.homework2.controller;

import cs3220.homework2.model.Player;
import cs3220.homework2.model.Team;
import cs3220.homework2.repository.PlayerRepository;
import cs3220.homework2.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private final PlayerRepository playerRepository;
    @Autowired
    private final TeamRepository teamRepository;

    public PlayerController(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @RequestMapping("/players")
    public String showPlayers(Model model) {
        model.addAttribute("players", playerRepository.findAll());
        return "players";
    }

    @GetMapping("/players/new")
    public String showNewPlayerForm(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("birthYears", IntStream.rangeClosed(Year.now().getValue() - 12, Year.now().getValue() - 4).toArray());
        return "newPlayer";
    }

    @PostMapping("/players/add")
    public String addPlayer(Player player) {
        Player newPlayer = playerRepository.save(player);
        return "redirect:/players";
    }

    @GetMapping("/players/edit/{id}")
    public String showEditPlayerForm(@PathVariable Integer id, Model model) {
        Player player = playerRepository.findById(id).orElse(null);
        model.addAttribute("birthYears", IntStream.rangeClosed(Year.now().getValue() - 12, Year.now().getValue() - 4).toArray());

        if (player != null) {
            // Calculate player's current age
            int currentYear = Year.now().getValue();
            int playerAge = currentYear - player.getBirthYear();

            // Filter eligible teams based on player's gender and age
            List<Team> eligibleTeams = teamRepository.findAll().stream()
                    .filter(team -> team.getGender().equalsIgnoreCase(player.getGender()))
                    .filter(team -> playerAge >= team.getMinAge() && playerAge <= team.getMaxAge())
                    .collect(Collectors.toList());

            model.addAttribute("player", player);
            model.addAttribute("teams", eligibleTeams);
            return "editPlayer";
        } else {
            return "redirect:/players";
        }
    }

    @PostMapping("/players/edit")
    public String editPlayer(@RequestParam Integer id, @RequestParam String name, @RequestParam String gender, @RequestParam int birthYear, @RequestParam Integer team, Model model) {
        Player player = playerRepository.findById(id).orElse(null);
        if (player != null) {
            player.setName(name);
            player.setGender(gender);
            player.setBirthYear(birthYear);

            Team assignedTeam;
            if(team == -1){
                assignedTeam = null;
            } else {
                assignedTeam = teamRepository.findById(team).orElse(null);
            };

            if (assignedTeam != null) {
                // Update the old team's player count if the team is changed
                updateTeamPlayerCount();
                player.setTeam(assignedTeam);
                // Update the new team's player count
                updateTeamPlayerCount();
            }
            else {
                player.setTeam(null);
                updateTeamPlayerCount();
            }

            // Assuming there's a method to update a player in your repository
            playerRepository.save(player);

            return "redirect:/players";
        } else {
            return "redirect:/players/edit/" + id;
        }
    }

    private void updateTeamPlayerCount() {
        List<Team> teams = teamRepository.findAll();
        teams.forEach(team -> {
            int playerCount = playerRepository.findAll().stream()
                    .filter(player -> player.getTeam() != null && player.getTeam().getId().equals(team.getId()))
                    .toList().size();
            team.setNumberOfPlayers(playerCount);
            teamRepository.save(team); // Save the updated player count to the database
        });
    }
}
