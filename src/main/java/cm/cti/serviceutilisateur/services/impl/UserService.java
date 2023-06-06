package cm.cti.serviceutilisateur.services.impl;


import cm.cti.serviceutilisateur.entities.Address;
import cm.cti.serviceutilisateur.entities.User;
import cm.cti.serviceutilisateur.enums.MessageEnum;
import cm.cti.serviceutilisateur.exception.DAOException;
import cm.cti.serviceutilisateur.exception.FormValidationException;
import cm.cti.serviceutilisateur.repositories.UserRepository;
import cm.cti.serviceutilisateur.services.UserIService;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService implements UserIService {
    @Autowired
    private UserRepository repository;

//    recuperer tous les user du system
    @Override
    public List<User> getAll() throws DAOException {
        try {
            return repository.findAll();
        }catch (NoResultException e) {
            return new ArrayList<User>();
        }catch (DAOException e) {
            throw new DAOException(e.getMessage());
        }
    }

//    ajouter un user dans le systeme
    @Override
    public void add(User entity) throws DAOException {
        try {
             repository.save(entity);
        }catch (DAOException e) {
            throw new DAOException(e.getMessage());
        }
    }

//    mettre a jour les informations d'un user dans le systeme
    @Override
    public void update(User entity) throws DAOException {
        if(find(entity.getId()) != null) {
            try {
                repository.save(entity);
            } catch (DAOException e) {
                throw new DAOException(e.getMessage());
            }
        }else{
            throw  new DAOException(MessageEnum.ERROR_NOT_FOUND_OBJET);
        }
    }

//    supprimer un user du systeme
    @Override
    public void delete(Long id) throws DAOException {
        if(find(id) != null) {
            User usr = find(id);
            try {
                repository.delete(usr);
            } catch (DAOException e) {
                throw new DAOException(e.getMessage());
            }
        }else{
            throw  new DAOException(MessageEnum.ERROR_NOT_FOUND_OBJET);
        }
    }
//rechercher un user par son id
    @Override
    public User find(Long id) throws DAOException {
        if (id == null) {
            throw new DAOException(MessageEnum.ERROR_NOT_FOUND_OBJET);
        } else {
            try {
                Optional<User> usr = repository.findById(id);
                return usr.get();
            } catch (DAOException e) {
                throw new DAOException(e.getMessage());
            } catch (NoSuchElementException e) {
                return null;
            }
        }
    }
// enregistrer +sieurs elts daans le systeme
    @Override 
    public void saveAll(Iterable<User> iterable) throws DAOException {
        try {
            repository.saveAll(iterable);
        } catch (DAOException e) {
            throw new DAOException(e.getMessage());
        }
    }
// rechercher ....
    @Override
    public User findId(Long id) throws FormValidationException {
        if(id != null) {
            if(find(id) != null) {
                return find(id);
            } else {
                throw new FormValidationException(MessageEnum.ERROR_NOT_FOUND_OBJET);
            }
        } else {
            throw new FormValidationException(MessageEnum.DAO_EXCEPTION);
        }
    }
}
