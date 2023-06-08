package sn.lpgl.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.*;

@Entity
@Table(name = "user_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idU;
    @Column(name = "nom", length = 200)
    private String nom;
    @Column(name = "prenom", length = 200)
    private String prenom;
    @Column(name = "email", length = 200, unique = true)
    private String email;
    @Column(name = "password", length = 200)
    private String  password;

    @OneToMany(mappedBy = "user")
    private List<Projet> projets;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "otaku",
            joinColumns = { @JoinColumn(name = "idU") },
            inverseJoinColumns = { @JoinColumn(name = "idR") }
    )
    Set<Role> roles = new HashSet<>();
}
