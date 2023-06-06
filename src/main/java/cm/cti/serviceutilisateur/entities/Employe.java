package cm.cti.serviceutilisateur.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="EMPLOYE")

public class Employe extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    @Column(name ="NAME", length = 300)
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "SEXE")
    private String sexe;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ADDRESS")
    private Address address;
}

