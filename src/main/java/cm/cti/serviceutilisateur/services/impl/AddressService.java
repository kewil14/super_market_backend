package cm.cti.serviceutilisateur.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import cm.cti.serviceutilisateur.entities.Address;
import cm.cti.serviceutilisateur.enums.MessageEnum;
import cm.cti.serviceutilisateur.exception.DAOException;
import cm.cti.serviceutilisateur.exception.FormValidationException;
import cm.cti.serviceutilisateur.repositories.AddressRepository;
import cm.cti.serviceutilisateur.services.AdressIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.persistence.NoResultException;

@Service
public class AddressService implements AdressIService {

	@Autowired
	private AddressRepository repository;
	
	@Override
	public List<Address> getAll() throws DAOException {
		try {
			return repository.findAll();
		}catch (NoResultException e) {
			return new ArrayList<Address>();
		}catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void add(Address entity) throws DAOException {
		try {
			repository.save(entity);
		}catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void update(Address entity) throws DAOException {
		if( find(entity.getId()) !=null) {
			try {
				repository.save(entity);
			}catch (DAOException e) {
				throw new DAOException(e.getMessage());
			}
		}else {
			throw new DAOException(MessageEnum.ERROR_NOT_FOUND_OBJET) ;
		}
	}

	@Override
	public void delete(Long id) throws DAOException {
		if( find(id) !=null) {
			Address ctr = find(id);
			try {
				repository.delete(ctr);
			}catch (DAOException e) {
				throw new DAOException(e.getMessage());
			}
		}else {
			throw new DAOException(MessageEnum.ERROR_NOT_FOUND_OBJET);
		}
	}

	@Override
	public Address find(Long id) throws DAOException {
		if(id ==null) {
			throw new DAOException(MessageEnum.ERROR_NOT_FOUND_OBJET);
		}else {
			try {
				Optional<Address> address = repository.findById(id);
				return address.get();
			} catch (DAOException e) {
				throw new DAOException(e.getMessage());
			}catch (NoSuchElementException e) {
				return null;
			}
		}
	}

	@Override
	public void saveAll(Iterable<Address> iterable) throws DAOException {
		try {
			repository.saveAll(iterable);
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Address findId(Long id) throws FormValidationException {
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
