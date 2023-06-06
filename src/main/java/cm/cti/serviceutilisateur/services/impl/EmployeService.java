package cm.cti.serviceutilisateur.services.impl;

import cm.cti.serviceutilisateur.entities.Address;
import cm.cti.serviceutilisateur.entities.Employe;
import cm.cti.serviceutilisateur.enums.MessageEnum;
import cm.cti.serviceutilisateur.exception.DAOException;
import cm.cti.serviceutilisateur.exception.FormValidationException;
import cm.cti.serviceutilisateur.repositories.EmployeRepository;
import cm.cti.serviceutilisateur.services.EmployeIService;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeService implements EmployeIService {
    
//    connexion au repository associe
    @Autowired
    private EmployeRepository repository;
    
    @Override
    public List<Employe> getAll() throws DAOException {
        try {
            return repository.findAll();
        }catch (NoResultException e) {
            return new ArrayList<Employe>();
        }catch (DAOException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public void add(Employe entity) throws DAOException {
        try {
            repository.save(entity);
        }catch (NoResultException e) {
            new ArrayList<Employe>();
        }catch (DAOException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public void update(Employe entity) throws DAOException {
        try {
            repository.save(entity);
        }catch (NoResultException e) {
            new ArrayList<Employe>();
        }catch (DAOException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) throws DAOException {
        if( find(id) !=null) {
            Employe ctr = find(id);
            try {
                repository.delete(ctr);
            }catch (DAOException e) {
                throw new DAOException(e.getMessage());
            }
        }else {
            throw new DAOException(MessageEnum.ERROR_NOT_FOUND_OBJET);
        }
    }
//continuer a partir d ici ..............
    @Override
    public Employe find(Long aLong) throws DAOException {
        return null;
    }

    @Override
    public void saveAll(Iterable<Employe> iterable) throws DAOException {

    }

    @Override
    public Employe findId(Long id) throws FormValidationException {
        return null;
    }
}
