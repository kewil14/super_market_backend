package cm.cti.serviceutilisateur.repositories;

import cm.cti.serviceutilisateur.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
