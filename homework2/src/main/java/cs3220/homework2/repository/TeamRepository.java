package cs3220.homework2.repository;

// TeamRepository.java

import cs3220.homework2.model.Player;
import cs3220.homework2.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer>{
    // Custom database queries can be defined here
}

