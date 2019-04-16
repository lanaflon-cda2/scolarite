/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.IRegionOrigineDao;
import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import cm.uma.iss.scolarite.services.IRegionOrigineService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class RegionOrigineServiceImpl implements IRegionOrigineService {
    
    IRegionOrigineDao regionOrigineDao;

    public IRegionOrigineDao getRegionOrigineDao() {
        return regionOrigineDao;
    }

    public void setRegionOrigineDao(IRegionOrigineDao regionOrigineDao) {
        this.regionOrigineDao = regionOrigineDao;
    }

    @Override
    public RegionOrigine registerRegionOrigine(RegionOrigine region) throws DataAccessException {
        try {
            return regionOrigineDao.create(region);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public RegionOrigine updateRegionOrigine(RegionOrigine region) throws DataAccessException {
        try {
            return regionOrigineDao.update(region);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public void deleteRegionOrigine(Long id_region) throws DataAccessException {
        try {
            RegionOrigine regionOrigine=regionOrigineDao.findById(id_region);
            regionOrigineDao.delete(regionOrigine);
        } catch (Exception e) {
            
        }
    }

    @Override
    public RegionOrigine findRegionOrigineById(long id_region) throws DataAccessException {
        try {
            return regionOrigineDao.findById(id_region);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public List<RegionOrigine> findRegionOrigineAll() throws DataAccessException {
        try {
            return regionOrigineDao.findAll();
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public RegionOrigine findRegionOrigineByNom(String nom) throws DataAccessException {
        try {
            return regionOrigineDao.findRegionOrigineByNom(nom);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public List<RegionOrigine> findRegionByPays(PaysOrigine pays) throws DataAccessException {
        try {
            return regionOrigineDao.findRegionByPays(pays);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public List<RegionOrigine> findRegionTout() throws DataAccessException {
    try {
            return regionOrigineDao.findRegionTout();
        } catch (Exception e) {
            
            return null;
        }
}
}

