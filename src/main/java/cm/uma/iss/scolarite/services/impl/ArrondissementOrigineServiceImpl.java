/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.IArrondissementOrigineDao;
import cm.uma.iss.scolarite.entities.ArrondissementOrigine;
import cm.uma.iss.scolarite.entities.DepartementOrigine;
import cm.uma.iss.scolarite.services.IArrondissementOrigineService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ArrondissementOrigineServiceImpl implements IArrondissementOrigineService {
   
    IArrondissementOrigineDao arrondissementOrigineDao;

    public IArrondissementOrigineDao getArrondissementOrigineDao() {
        return arrondissementOrigineDao;
    }

    public void setArrondissementOrigineDao(IArrondissementOrigineDao arrondissementOrigineDao) {
        this.arrondissementOrigineDao = arrondissementOrigineDao;
    }
    
    

    @Override
    public ArrondissementOrigine registerArrondissementOrigine(ArrondissementOrigine arrondissement) throws DataAccessException {
        try {
            return arrondissementOrigineDao.create(arrondissement);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrondissementOrigine updateArrondissementOrigine(ArrondissementOrigine arrondissement) throws DataAccessException {
        try {
            return arrondissementOrigineDao.update(arrondissement);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteArrondissementOrigine(Long id_arrondissement) throws DataAccessException {
        try {
            ArrondissementOrigine arrondissementOrigine=arrondissementOrigineDao.findById(id_arrondissement);
            arrondissementOrigineDao.delete(arrondissementOrigine);
        } catch (Exception e) {
        }
    }

    @Override
    public ArrondissementOrigine findArrondissementOrigineById(long id_arrondissement) throws DataAccessException {
        try {
            return arrondissementOrigineDao.findById(id_arrondissement);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ArrondissementOrigine> findArrondissementOrigineAll() throws DataAccessException {
        try {
            return arrondissementOrigineDao.findAll();
        } catch (Exception e) {
            return null;
            
        }
    }

    @Override
    public ArrondissementOrigine findArrondissementOrigineByNom(String nom) throws DataAccessException {
        try {
            return arrondissementOrigineDao.findArrondissementOrigineByNom(nom);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ArrondissementOrigine> findArrondissementOrigneByDepartement(DepartementOrigine DepartementOrigine) throws DataAccessException {
        try {
            return arrondissementOrigineDao.findArrondissementOrigneByDepartement(DepartementOrigine);
        } catch (Exception e) {
            return null;
        }
    }
    
}
