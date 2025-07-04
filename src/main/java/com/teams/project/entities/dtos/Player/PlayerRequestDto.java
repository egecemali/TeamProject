package com.teams.project.entities.dtos.Player;

import com.teams.project.entities.enums.Region;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlayerRequestDto {
    @NotNull(message = "Player name cannot be null!")

    private String playerName;
    @NotNull(message = "Player surname cannot be null!")
    private String playerSurname;
    @NotNull(message = "Player age cannot be null!")
    private Integer age;
    @NotNull(message = "Player nationality cannot be null ")
    private String nationality;
    private float marketValue;
    @NotNull(message = "Player region cannot be null ")
    private Region region;
    @NotNull(message = "Player team cannot be null.")
    private Integer teamId;
    private Long managerId;


}
