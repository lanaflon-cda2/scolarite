/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.IDepartementOrigineDao;
import cm.uma.iss.scolarite.entities.DepartementOrigine;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import cm.uma.iss.scolarite.services.IDepartementOrigineService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DepartementOrigineServiceImpl implements IDepartementOrigineService {

    IDepartementOrigineDao departementOrigineDao;

    public IDepartementOrigineDao getDepartementOrigineDao() {
        return departementOrigineDao;
    }

    public void setDepartementOrigineDao(IDepartementOrigineDao departementOrigineDao) {
        this.departementOrigineDao = departementOrigineDao;
    }

    @Override
    public DepartementOrigine registerDepartementOrigine(DepartementOrigine departement) throws DataAccessException {
        try {
            return departementOrigineDao.create(departement);
        } catch (Exception e) {

            return null;
        }
    }

    @Override
    public DepartementOrigine updateDepartementOrigine(DepartementOrigine departement) throws DataAccessException {
        try {
            return departementOrigineDao.update(departement);
        } catch (Exception e) {

            return null;
        }
    }

    @Override
    public void deleteDepartementOrigine(Long id_departement) throws DataAccessException {
        try {
            DepartementOrigine departementOrigine = departementOrigineDao.findById(id_departement);
            departementOrigineDao.delete(departementOrigine);
        } catch (Exception e) {
        }
    }

    @Override
    public DepartementOrigine findDepartementOrigineById(long id_departement) throws DataAccessException {
        try {
            return departementOrigineDao.findById(id_departement);
        } catch (Exception e) {

            return null;
        }
    }

    @Override
    public List<DepartementOrigine> findDepartementOrigineAll() throws DataAccessException {
        try {
            return departementOrigineDao.findAll();
        } catch (Exception e) {

            return null;
        }
    }

    @Override
    public DepartementOrigine findDepartementOrigineByNom(String nom) throws DataAccessException {
        try {
            return departementOrigineDao.findDepartementOrigineByNom(nom);
        } catch (Exception e) {

            return null;
        }
    }

    @Override
    public List<DepartementOrigine> findDepartementOrigineByRegion(RegionOrigine regionOrigine) throws DataAccessException {
        try {
            return departementOrigineDao.findDepartementOrigineByRegion(regionOrigine);
        } catch (Exception e) {
            return null;
        }
    }
}
