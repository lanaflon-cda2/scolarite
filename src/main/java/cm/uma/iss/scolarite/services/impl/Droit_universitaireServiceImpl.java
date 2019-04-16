/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.IDroit_universitaireDao;
import cm.uma.iss.scolarite.entities.Droit_universitaire;
import cm.uma.iss.scolarite.services.IDroit_universitaireService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ngnawen
 */
@Transactional
public class Droit_universitaireServiceImpl implements IDroit_universitaireService {

    IDroit_universitaireDao droit_universitaireDao;

    public IDroit_universitaireDao getDroit_universitaireDao() {
        return droit_universitaireDao;
    }

    public void setDroit_universitaireDao(IDroit_universitaireDao droit_universitaireDao) {
        this.droit_universitaireDao = droit_universitaireDao;
    }

    @Override
    public Droit_universitaire registerDroit_universitaire(Droit_universitaire droit_universitaire) throws DataAccessException {
        return droit_universitaireDao.create(droit_universitaire);
    }

    @Override
    public Droit_universitaire updateDroit_universitaire(Droit_universitaire droit_universitaire) throws DataAccessException {
        return droit_universitaireDao.update(droit_universitaire);
    }


    @Override
    public Droit_universitaire findDroit_UniversiataireById(long id_droit_universitaire) throws DataAccessException {
        return droit_universitaireDao.findById(id_droit_universitaire);
    }

    @Override
    public List<Droit_universitaire> findDroit_UniversiataireByAll() throws DataAccessException {
        return droit_universitaireDao.findAll();
    }

    @Override
    public Droit_universitaire getDroitUniversitairetByNature(String nature_droit_universitaire) throws DataAccessException {
        return droit_universitaireDao.getDroitUniversitairetByNature(nature_droit_universitaire);
    }

    @Override
    public void deleteDroit_universitaire(Long id_cycle) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
