package cs3220.homework2.model;

import java.time.Year;
import jakarta.persistence.*;

// Player.java
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String gender;
    private int birthYear;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team; // Assuming Team is another class in your model

//    // Constructor
//    public Player(Long id, String name, String gender, int birthYear, Team team) {
//        this.id = id;
//        this.name = name;
//        this.gender = gender;
//        this.birthYear = birthYear;
//        this.team = team;
//    }

    // Getters and setters
    public int getAge() {
        // Calculate the age based on the current year and the player's birth year
        return Year.now().getValue() - this.birthYear;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public int hashCode() {
        return 31;
    }
}


