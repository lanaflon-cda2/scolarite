/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.IPersonneDao;
import cm.uma.iss.scolarite.entities.Personne;
import cm.uma.iss.scolarite.services.IPersonneService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PersonneServiceImpl implements IPersonneService {

    IPersonneDao personneDao;

    public IPersonneDao getPersonneDao() {
        return personneDao;
    }

    public void setPersonneDao(IPersonneDao personneDao) {
        this.personneDao = personneDao;
    }

    @Override
    public Personne registerPersonne(Personne personne) throws DataAccessException {
        try {
            return personneDao.create(personne);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Personne updatePersonne(Personne personne) throws DataAccessException {
        try {
            return personneDao.update(personne);
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public void deletePersonne(Long id_personne) throws DataAccessException {

        try {
            personneDao.delete(null);
        } catch (Exception e) {
        }
    }

    @Override
    public void deletePersonne(Personne personne) throws DataAccessException {
        try {
            personneDao.delete(personne);
        } catch (Exception e) {
        }
    }

    @Override
    public Personne findPersonneById(long id_personne) throws DataAccessException {
        try {
            return personneDao.findById(id_personne);
        } catch (Exception e) {
            return null;
            
        }
    }

    @Override
    public List<Personne> findPersonneAll() throws DataAccessException {
        try {
            return personneDao.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Personne> findPersonneByNom(String nom) throws DataAccessException {
        try {
            return personneDao.findPersonneByNom(nom);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Personne> findPersonneByPrenom(String prenom) throws DataAccessException {
        try {
            return personneDao.findPersonneByPrenom(prenom);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Personne> findPersonneByEmail(String email) throws DataAccessException {
        try {
            return personneDao.findPersonneByEmail(email);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Personne> findPersonneByTelephone(String telephone) throws DataAccessException {
        try {
            return personneDao.findPersonneByTelephone(telephone);
        } catch (Exception e) {
            return null;
        }
    }
}
