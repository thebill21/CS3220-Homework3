package cs3220.homework2.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Team.java
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uniformColor;
    private String gender;
    private int minAge;
    private int maxAge;
    private int numberOfPlayers;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players = new ArrayList<>(); // Initialize to prevent null
//    // Constructor
//    public Team(Long id, String uniformColor, String gender, int minAge, int maxAge) {
//        this.id = id;
//        this.uniformColor = uniformColor;
//        this.gender = gender;
//        this.minAge = minAge;
//        this.maxAge = maxAge;
//    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniformColor() {
        return uniformColor;
    }

    public void setUniformColor(String uniformColor) {
        this.uniformColor = uniformColor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    @Override
    public int hashCode() {
        return 31;
    }
}

