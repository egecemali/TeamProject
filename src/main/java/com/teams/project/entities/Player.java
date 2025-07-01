package com.teams.project.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.teams.project.entities.enums.Region;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString(exclude = "team")
@Entity
@Table(name = "players")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazy","handler","playerinfo"})


public class Player {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;
    @Column(name = "name")
    private String playerName;
    @Column(name = "surname")
    private String playerSurname;
    @Column(name = "age")
    private int age;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "market_value")
    private int marketValue;
    private Region region;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "teamId")
    @JsonBackReference
    private Team team;
    @OneToMany(mappedBy = "player",fetch = FetchType.LAZY)
    private List<PlayerInfo> playerInfos;

}
