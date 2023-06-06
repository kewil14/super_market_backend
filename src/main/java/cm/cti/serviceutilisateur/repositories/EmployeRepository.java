package cm.cti.serviceutilisateur.repositories;

import cm.cti.serviceutilisateur.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
