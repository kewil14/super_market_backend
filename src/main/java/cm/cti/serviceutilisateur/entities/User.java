package cm.cti.serviceutilisateur.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYE")
    private Employe employe;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE")
    private List<Role> role;
}
