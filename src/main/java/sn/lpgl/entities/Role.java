package sn.lpgl.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idR;

    @Column(name = "nomR", length = 200)
    private String nomR;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
