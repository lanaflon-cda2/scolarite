/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.INiveauDao;
import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.Niveau;
import cm.uma.iss.scolarite.services.INiveauService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author ngnawen
 */

@Transactional
public class NiveauServiceImpl implements INiveauService {
    
    INiveauDao niveauDao;
    
    //getters and setters  

    public INiveauDao getNiveauDao() {
        return niveauDao;
    }

    public void setNiveauDao(INiveauDao niveauDao) {
        this.niveauDao = niveauDao;
    }
    
    

    @Override
    public Niveau registerNiveau(Niveau niveau) throws DataAccessException {
        try {
            return niveauDao.create(niveau);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public Niveau updateNiveau(Niveau niveau) throws DataAccessException {
        try {
            return niveauDao.update(niveau);
        } catch (Exception e) {
            
            return null;
        }
    }


    @Override
    public Niveau findNiveauById(long id_niveau) throws DataAccessException {
        try {
            return niveauDao.findById(id_niveau);
        } catch (Exception e) {
            
            return null;
        }
           
    }

    @Override
    public List<Niveau> findNiveauAll() throws DataAccessException {
        try {
            return niveauDao.findAll();
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public void deleteNiveau(Long id_niveau) throws DataAccessException {
        try {
            Niveau niveau=niveauDao.findById(id_niveau);
            niveauDao.delete(niveau);
        } catch (Exception e) {
            
        }
    }

    @Override
    public Niveau findNiveauByNom(String nom) throws DataAccessException {
        try {
            return niveauDao.findNiveauByNom(nom);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public List<Niveau> findNiveauByCycle(Cycle cycle) throws DataAccessException {
        try {
            return niveauDao.findNiveauByCycle(cycle);
        } catch (Exception e) {
            
            return null;
        }

    }

    @Override
    public List<Niveau> findToutNiveau() throws DataAccessException {
        try {
            return niveauDao.findToutNiveau();
        } catch (Exception e) {
            
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }
    
}
