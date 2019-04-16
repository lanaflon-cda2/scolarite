/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.INiveauFiliereDao;
import cm.uma.iss.scolarite.entities.NiveauFiliere;
import cm.uma.iss.scolarite.services.INiveauFiliereService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author ngnawen
 */

@Transactional
public class NiveauFiliereServiceImpl implements INiveauFiliereService {
    
    INiveauFiliereDao niveauFiliereDao;

    public INiveauFiliereDao getNiveauFiliereDao() {
        return niveauFiliereDao;
    }

    public void setNiveauFiliereDao(INiveauFiliereDao niveauFiliereDao) {
        this.niveauFiliereDao = niveauFiliereDao;
    }
    
    

    @Override
    public NiveauFiliere registerNiveauFiliere(NiveauFiliere niveauFiliere) throws DataAccessException {
        try {
            return niveauFiliereDao.create(niveauFiliere);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public NiveauFiliere updateNiveauFiliere(NiveauFiliere niveauFiliere) throws DataAccessException {
        try {
            return niveauFiliereDao.update(niveauFiliere);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public NiveauFiliere findNiveauFiliereById(long id_niveauFiliere) throws DataAccessException {
        try {
            return niveauFiliereDao.findById(id_niveauFiliere);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public List<NiveauFiliere> findNiveauFiliereAll() throws DataAccessException {
        try {
            return niveauFiliereDao.findAll();
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public void deleteNiveauFiliere(Long id_inscription) throws DataAccessException {
        try {
            NiveauFiliere niveauFiliere=niveauFiliereDao.findById(id_inscription);
            niveauFiliereDao.delete(niveauFiliere);
        } catch (Exception e) {
            
        }
    }
    
}
