package cs3220.homework2.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class TeamDto {
    private Integer id;
    private String gender;
    private String color;
    private int minAge;
    private int maxAge;
    private int numberOfPlayers;
    private List<PlayerDto> players;

    public TeamDto(Team team) {
        this.id = team.getId();
        this.gender = team.getGender();
        this.color = team.getUniformColor();
        this.minAge = team.getMinAge();
        this.maxAge = team.getMaxAge();
        this.numberOfPlayers = team.getPlayers().size();
        this.players = team.getPlayers().stream()
                .map(player -> new PlayerDto(player))
                .collect(Collectors.toList());
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public List<PlayerDto> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDto> players) {
        this.players = players;
    }
}
