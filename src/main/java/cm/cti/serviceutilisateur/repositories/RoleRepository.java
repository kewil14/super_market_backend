package cm.cti.serviceutilisateur.repositories;

import cm.cti.serviceutilisateur.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
