/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.ICycleDao;
import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.services.ICycleService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author ngnawen
 */

@Transactional
public class CycleServiceImpl implements ICycleService {
    
    ICycleDao cycleDao;

    public ICycleDao getCycleDao() {
        return cycleDao;
    }

    public void setCycleDao(ICycleDao cycleDao) {
        this.cycleDao = cycleDao;
    }
    
    

    @Override
    public Cycle registerCycle(Cycle cycle) throws DataAccessException {
        try {
            return cycleDao.create(cycle);
        } catch (Exception e) {
            return  null;
        }
    }

    @Override
    public Cycle updateCycle(Cycle cycle) throws DataAccessException {
        try {
             return cycleDao.update(cycle);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteCycle(Long id_cycle) throws DataAccessException {
        try {
            Cycle cycle=cycleDao.findById(id_cycle);
            cycleDao.delete(cycle);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    @Override
    public Cycle findCycleById(long id_cycle) throws DataAccessException {
        try {
            return cycleDao.findById(id_cycle);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Cycle> findCycleAll() throws DataAccessException {
        try {
            return cycleDao.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Cycle findCycleByNom(String nom_cycle) throws DataAccessException {
        try {
            return cycleDao.findCycleByNom(nom_cycle);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteCycle1(Cycle cycle) throws DataAccessException {
        try {
            cycleDao.delete(cycle);
        } catch (Exception e) {
        }
    }
    
}
