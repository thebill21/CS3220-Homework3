package cs3220.homework2.model;

import jakarta.validation.constraints.NotNull;

public class CreatePlayerRequest {
    @NotNull(message = "Player Gender is required.")
    private String gender;

    @NotNull(message = "Player Name is required.")
    private String name;

    @NotNull(message = "Player Birth Year is required.")
    private Integer birthYear;

    // Getters
    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    // Setters
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }
}


