package cs3220.homework2.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CreateTeamRequest {
    @NotNull(message = "Team Gender is required.")
    private String gender;

    @NotNull(message = "Uniform Color is required.")
    private String color;

    @Min(value = 4, message = "Minimum age must be at least 4.")
    private int minAge;

    @Max(value = 12, message = "Maximum age must be at most 12.")
    private int maxAge;

    // Getters
    public String getGender() {
        return gender;
    }

    public String getColor() {
        return color;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    // Setters
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }
}

