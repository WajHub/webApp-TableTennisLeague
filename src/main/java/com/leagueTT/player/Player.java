package com.leagueTT.player;

import com.leagueTT.team.Team;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Check;

import java.util.Date;

@Data
@Entity
@Table(name = "Player")
public class Player {
    @Id
    @Check(constraints = "REGEXP_LIKE(pesel, '^[0-9]{11}')")
    @Column(name="Pesel")
    private String pesel;

    @Column(name = "NameP", nullable = false, length = 255)
    private String name;

    @Column(name = "Surname", nullable = false, length = 255)
    private String surname;

    @Column(name = "DateOfBirth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "Nationallity", nullable = false, length = 255)
    private String nationality;

    @Column(name = "Height", nullable = false)
    private int height;

    @Column(name = "WeightP", nullable = false)
    private int weight;

    @Column(name = "Hand", length = 5)
    private String hand;

    @Column(name = "Blade", length = 255)
    private String blade;

    @Column(name = "ImgURL", nullable = false, length = 511)
    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "IdTeam")
    private Team team;
}
