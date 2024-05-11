package cs3220.homework2.model;

public class PlayerDto {
    private Integer id;
    private String name;
    private String gender;
    private Integer birthYear;
    public Integer teamId;

    // Constructor to initialize from a Player object
    public PlayerDto(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.gender = player.getGender();
        this.birthYear = player.getBirthYear();
        this.teamId = player.getTeam().getId();
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setGender (String gender){
        this.gender = gender;
    }
}

