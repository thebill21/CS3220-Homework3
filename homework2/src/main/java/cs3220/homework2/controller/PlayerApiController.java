package cs3220.homework2.controller;

import cs3220.homework2.model.Player;
import cs3220.homework2.model.PlayerDto;
import cs3220.homework2.repository.PlayerRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerApiController {
    private final PlayerRepository playerService;

    public PlayerApiController(PlayerRepository playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable Integer id, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Optional<Player> player = playerService.findById(id);
        return player.map(this::convertToDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private PlayerDto convertToDto(Player player) {
        // Assuming you have a method or a constructor in PlayerDto to convert from Player
        // Update this method according to your PlayerDto's implementation
        return new PlayerDto(player);
    }
}

