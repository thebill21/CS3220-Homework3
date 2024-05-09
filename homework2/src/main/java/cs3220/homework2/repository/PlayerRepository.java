package cs3220.homework2.repository;

// PlayerRepository.java
import cs3220.homework2.model.Player;
import cs3220.homework2.model.Team;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer>{
    //Object find Team by ID
    List<Player> findByTeamId(Integer id);
}

