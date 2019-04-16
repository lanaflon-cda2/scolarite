/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.IAnneeAccademiqueDao;
import cm.uma.iss.scolarite.entities.AnneeAccademique;
import cm.uma.iss.scolarite.services.IAnneeAccademiqueService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AnneeAccademiqueServiceImpl implements IAnneeAccademiqueService {
    
    IAnneeAccademiqueDao anneeAccademiqueDao;

    public IAnneeAccademiqueDao getAnneeAccademiqueDao() {
        return anneeAccademiqueDao;
    }

    public void setAnneeAccademiqueDao(IAnneeAccademiqueDao anneeAccademiqueDao) {
        this.anneeAccademiqueDao = anneeAccademiqueDao;
    }
    
    
    

    @Override
    public AnneeAccademique registerAnnee_accademique(AnneeAccademique annee_accademique) throws DataAccessException {
        try {
            return anneeAccademiqueDao.create(annee_accademique);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public AnneeAccademique updateAnnee_accademique(AnneeAccademique annee_accademique) throws DataAccessException {
        try {
            return anneeAccademiqueDao.update(annee_accademique);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteAnnee_accademique1(AnneeAccademique annee_accademique) throws DataAccessException {
        try {
            
            anneeAccademiqueDao.delete(annee_accademique);
        } catch (Exception e) {
        }
    }

    @Override
    public AnneeAccademique findAnnee_accademiqueById(long id_annee_accademique) throws DataAccessException {
        try {
            return anneeAccademiqueDao.findById(id_annee_accademique);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<AnneeAccademique> findAnnee_accademiqueAll() throws DataAccessException {
        try {
            return anneeAccademiqueDao.findAll();
        } catch (Exception e) {
            return null;
        }
    }

//    @Override
//    public void deleteAnnee_accademique(Long id_annee_accademique) throws DataAccessException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public AnneeAccademique findAnneeByDebut(String debutAnnee) throws DataAccessException {
        try {
            return anneeAccademiqueDao.findAnneeByDebut(debutAnnee);
        } catch (Exception e) {
            return null;
        }
            
    }
    
    @Override
    public AnneeAccademique findAnneeByFin(String finAnnee) throws DataAccessException {
        try {
            return anneeAccademiqueDao.findAnneeByFin(finAnnee);
        } catch (Exception e) {
            return null;
        }
            
    }

    @Override
    public AnneeAccademique findAnneeByDebutFin(String debutAnnee, String finAnnee) throws DataAccessException {
        try {
            return anneeAccademiqueDao.findAnneeByDebutFin(debutAnnee, finAnnee);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public AnneeAccademique findAnneeByAnnee(String annee) throws DataAccessException {
        try {
            return anneeAccademiqueDao.findAnneeByAnnee(annee);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteAnnee_accademique(Long id_annee_accademique) throws DataAccessException {
        try {
            AnneeAccademique annAcc=anneeAccademiqueDao.findById(id_annee_accademique);
            anneeAccademiqueDao.delete(annAcc);
        } catch (Exception e) {
        }
    }
    
}
