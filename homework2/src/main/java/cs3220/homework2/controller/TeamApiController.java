package cs3220.homework2.controller;

import cs3220.homework2.model.CreateTeamRequest;
import cs3220.homework2.model.CreatePlayerRequest;
import cs3220.homework2.model.Player;
import cs3220.homework2.model.Team;
import cs3220.homework2.model.TeamDto;
import cs3220.homework2.repository.PlayerRepository;
import cs3220.homework2.repository.TeamRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@CrossOrigin(origins = "http://localhost:8080") // Adjust the port if your client is served from another port
@RequestMapping("/api/teams")
public class TeamApiController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    // Get all teams
    @RequestMapping
    public List<TeamDto> getAllTeams(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(team -> new TeamDto(team)).collect(Collectors.toList());
//        return ResponseEntity.ok().headers(response.getHeaderNames())
//                .body(teams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeamById(@PathVariable Integer id) {
        Team team = teamRepository.findById(id)
                .orElse(null);
        if (team == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Team not found");
        }
        return ResponseEntity.ok(team);
    }

    // Create a new team
    @PostMapping
    public ResponseEntity<?> createTeam(@RequestBody @Valid CreateTeamRequest createTeamRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            bindingResult.getFieldErrors().forEach(fieldError ->
                    errorMsg.append(fieldError.getField() + " " + fieldError.getDefaultMessage() + "; ")
            );
            return ResponseEntity.badRequest().body(errorMsg.toString());
        }

        Team team = new Team(); // Assuming you have a default constructor
        team.setGender(createTeamRequest.getGender());
        team.setUniformColor(createTeamRequest.getColor());
        team.setMinAge(createTeamRequest.getMinAge());
        team.setMaxAge(createTeamRequest.getMaxAge());

        Team savedTeam = teamRepository.save(team);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeam);
    }

    @CrossOrigin(origins = "http://localhost:8080") // Adjust or remove origins if needed
    @PostMapping("/{teamId}/players/{playerId}")
    @Transactional
    public ResponseEntity<?> addPlayerToTeam(@PathVariable Integer teamId,
                                             @PathVariable Integer playerId,
                                             @RequestBody CreatePlayerRequest createPlayerRequest) {
        try {
            // Fetch the team
            Team team = teamRepository.findById(teamId)
                    .orElseThrow(() -> new NoSuchElementException("Team not found"));

            // Fetch the player by ID
            Player player = playerRepository.findById(playerId)
                    .orElseThrow(() -> new NoSuchElementException("Player not found"));

            // Check if the player is already assigned to a team
//            if (player.getTeam() != null) {
//                if (player.getTeam().getId().equals(teamId)) {
//                    playerRepository.save(player);
//                    return ResponseEntity.badRequest().body("Player is already on this team.");
//                }
//            }

            // Assign the player to the team
//            team.getPlayers().add(player);
            player.setTeam(team);
            player.setName(createPlayerRequest.getName());
            player.setGender(createPlayerRequest.getGender());
            player.setBirthYear(createPlayerRequest.getBirthYear());
            playerRepository.save(player);
            teamRepository.save(team);

            return ResponseEntity.ok(team);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }


}

