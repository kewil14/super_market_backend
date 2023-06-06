package cm.cti.serviceutilisateur.services.impl;

import cm.cti.serviceutilisateur.entities.Role;
import cm.cti.serviceutilisateur.entities.User;
import cm.cti.serviceutilisateur.enums.MessageEnum;
import cm.cti.serviceutilisateur.exception.DAOException;
import cm.cti.serviceutilisateur.exception.FormValidationException;
import cm.cti.serviceutilisateur.repositories.RoleRepository;
import cm.cti.serviceutilisateur.services.RoleIService;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RoleService implements RoleIService {

//    connexion avec son repository de role

    @Autowired
    private RoleRepository repository;

//    afficher tous les roles
    @Override
    public List<Role> getAll() throws DAOException {
        try {
            return repository.findAll();
        }catch (NoResultException e) {
            return new ArrayList<Role>();
        }catch (DAOException e) {
            throw new DAOException(e.getMessage());
        }
    }
//  ajoueter un role
    @Override
    public void add(Role entity) throws DAOException {
        try {
            repository.save(entity);
        }catch (DAOException e) {
            throw new DAOException(e.getMessage());
        }
    }

//    mettre a jours un role
    @Override
    public void update(Role entity) throws DAOException {
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
//  supprimer un role
    @Override
    public void delete(Long id) throws DAOException {
        if(find(id) != null) {
            Role role = find(id);
            try {
                repository.delete(role);
            } catch (DAOException e) {
                throw new DAOException(e.getMessage());
            }
        }else{
            throw  new DAOException(MessageEnum.ERROR_NOT_FOUND_OBJET);
        }
    }

//    rechercher un role par son id
    @Override
    public Role find(Long id) throws DAOException {
        if (id == null) {
            throw new DAOException(MessageEnum.ERROR_NOT_FOUND_OBJET);
        } else {
            try {
                Optional<Role> role = repository.findById(id);
                return role.get();
            } catch (DAOException e) {
                throw new DAOException(e.getMessage());
            } catch (NoSuchElementException e) {
                return null;
            }
        }
    }

    @Override
    public void saveAll(Iterable<Role> iterable) throws DAOException {
        try {
            repository.saveAll(iterable);
        } catch (DAOException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Role findId(Long id) throws FormValidationException {
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
