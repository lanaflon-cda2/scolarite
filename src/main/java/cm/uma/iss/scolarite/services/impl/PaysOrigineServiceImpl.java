/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.IPaysOrigineDao;
import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.services.IPaysOrigineService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ngnawen
 */
@Transactional
public class PaysOrigineServiceImpl implements IPaysOrigineService {

    IPaysOrigineDao paysOrigineDao;

    public IPaysOrigineDao getPaysOrigineDao() {
        return paysOrigineDao;
    }

    public void setPaysOrigineDao(IPaysOrigineDao paysOrigineDao) {
        this.paysOrigineDao = paysOrigineDao;
    }


    @Override
    public PaysOrigine registerPays(PaysOrigine pays) throws DataAccessException {
        try {
            return paysOrigineDao.create(pays);
        } catch (Exception e) {
            
            return null;
        }

    }

    @Override
    public PaysOrigine updatePays(PaysOrigine pays) throws DataAccessException {
        try {
            return paysOrigineDao.update(pays);
        } catch (Exception e) {
            
            return null;
        }

    }

//    @Override
//    public void deletePays(Long id_pays) throws DataAccessException {
//        try {
//            PaysOrigine pays=paysOrigineDao.findById(Long.MIN_VALUE);
//            paysOrigineDao.delete(pays);
//        } catch (Exception e) {
//        }
//        
//    }
    @Override
    public PaysOrigine findPaysById(long id_pays) throws DataAccessException {
        try {
            return paysOrigineDao.findById(id_pays);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public List<PaysOrigine> findPaysAll() throws DataAccessException {
        try {
            return paysOrigineDao.findAll();
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public void deletePays(Long id_pays) throws DataAccessException {
        try {
            PaysOrigine pays = paysOrigineDao.findById(id_pays);
            paysOrigineDao.delete(pays);
        } catch (Exception e) {
            
        }

    }

    @Override
    public PaysOrigine getPaysByNom(String nom_pays) throws DataAccessException {
        try {
            return paysOrigineDao.getPaysByNom(nom_pays);
        } catch (Exception e) {
            
            return null;
        }
    }
}
