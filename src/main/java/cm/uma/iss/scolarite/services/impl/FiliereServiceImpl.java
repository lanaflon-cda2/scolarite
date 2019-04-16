/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.IFiliereDao;
import cm.uma.iss.scolarite.entities.Filiere;
import cm.uma.iss.scolarite.services.IFiliereService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author ngnawen
 */


@Transactional
public class FiliereServiceImpl implements IFiliereService {
   
    IFiliereDao filiereDao;

    public IFiliereDao getFiliereDao() {
        return filiereDao;
    }

    public void setFiliereDao(IFiliereDao filiereDao) {
        this.filiereDao = filiereDao;
    }
    

    @Override
    public Filiere registerFiliere(Filiere filiere) throws DataAccessException {
        try {
            return filiereDao.create(filiere);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public Filiere updateFiliere(Filiere filiere) throws DataAccessException {
        try {
            return filiereDao.update(filiere);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public Filiere findFiliereById(long id_filiere) throws DataAccessException {
        try {
            return filiereDao.findById(id_filiere);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public List<Filiere> findFiliereAll() throws DataAccessException {
        try {
            return filiereDao.findAll();
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public void deleteFiliere(Long id_etudiant) throws DataAccessException {
        try {
            Filiere filiere=filiereDao.findById(id_etudiant);
            filiereDao.delete(filiere);
        } catch (Exception e) {
            
        }
    }

    @Override
    public Filiere findFiliereByNom(String nom) throws DataAccessException {
        try {
            return filiereDao.findFiliereByNom(nom);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public Filiere findFiliereBySigle(String sigle) throws DataAccessException {
         try {
            return filiereDao.findFiliereBySigle(sigle);
        } catch (Exception e) {
            
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Filiere> findAllFiliere() throws DataAccessException {
       try {
            return filiereDao.findAllFiliere();
        } catch (Exception e) {
            
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    
}
