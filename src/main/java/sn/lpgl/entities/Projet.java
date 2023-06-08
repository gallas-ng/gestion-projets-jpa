package sn.lpgl.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "projet_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idP;
    @Column(name = "description", unique = true)
    private String description;
    @Column(name = "budeget", columnDefinition = "double default 255000.15")
    private double budget;
    @Column(name = "duree", columnDefinition = "integer default 1")
    private int duree;
    @Column(name = "etat", columnDefinition = "boolean default false")
    private boolean etat;

    @ManyToOne
    @JoinColumn(name = "porteur")
    private User user;

}
