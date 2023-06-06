package cm.cti.serviceutilisateur.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="ADDRESS")
@ToString
public class Address extends User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private Long id;

        @Column(name="EMAIL")
        private String email;

        @Column(name="NUMBER", nullable = false, columnDefinition ="")
        private Long number;

        @Column(name="VILLE")
        private String ville;

        @Column(name="PAYS")
        private String pays;

        @Column(name="REGION")
        private String region;

        @Column(name="DEPARTMENT")
        private String departement;

        @Column(name="POSTAL")
        private String postal;

        @Column(name="QUARTIER")
        private String quartier;
}
