package com.teams.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "teams")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazy","handler","players"})

public class Team {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;
    @Column(name = "name")
    private String team;
    @Column(name = "stadium")
    private String stadiumName;
    @Column(name = "founded_year")
    private int foundedYear;


    @OneToMany(mappedBy = "team",cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Player> players;



}
