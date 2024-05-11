package cs3220.homework2.controller;

import cs3220.homework2.model.Player;
import cs3220.homework2.model.Team;
import cs3220.homework2.repository.TeamRepository;
import cs3220.homework2.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Controller
public class TeamController {
    @Autowired
    private final TeamRepository teamRepository;
    @Autowired
    private final PlayerRepository playerRepository;

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

    public TeamController(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @RequestMapping("/teams")
    public String listTeams(Model model) {
//        teams.forEach(team -> {
//            int playerCount = playerRepository.findAll().stream()
//                    .filter(player -> player.getTeam() != null && player.getTeam().getId().equals(team.getId()))
//                    .toList().size();
//            team.setNumberOfPlayers(playerCount);
//            teamRepository.save(team); // Save the updated player count to the database
//        });
        updateTeamPlayerCount();
        model.addAttribute("teams", teamRepository.findAll());
        return "listTeams";
    }

    @RequestMapping("/teams/{id}/roster")
    public String viewRoster(@PathVariable("id") Integer id, Model model) {
        Team team = teamRepository.findById(id).orElse(null);
        updateTeamPlayerCount();
        if (team != null) {
            List<Player> players = playerRepository.findAll().stream()
                    .filter(player -> player.getTeam() != null && player.getTeam().getId().equals(team.getId()))
                    .collect(Collectors.toList());

            model.addAttribute("team", team);
            model.addAttribute("players", players);
            return "viewRoster"; // Ensure you have a viewRoster.ftlh template
        } else {
            return "redirect:/teams";
        }
    }

    @RequestMapping("/teams/new")
    public String showAddTeamForm() {
        return "newTeam";
    }

    @PostMapping("/teams/add")
    public String addTeam(Team team) {
        Team newTeam = teamRepository.save(team);
        return "redirect:/teams";
    }

}
