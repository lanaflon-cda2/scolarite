/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.IRetraitRetourDocDao;
import cm.uma.iss.scolarite.entities.Documents;
import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.RetraitRetourDoc;
import cm.uma.iss.scolarite.services.IRetraitRetourDocService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ngnawen
 */
@Transactional
public class RetraitRetourDocService implements IRetraitRetourDocService {

    IRetraitRetourDocDao retraitRetourDocDao;

    public IRetraitRetourDocDao getRetraitRetourDocDao() {
        return retraitRetourDocDao;
    }

    public void setRetraitRetourDocDao(IRetraitRetourDocDao retraitRetourDocDao) {
        this.retraitRetourDocDao = retraitRetourDocDao;
    }

    @Override
    public RetraitRetourDoc registerRetraitRetourDoc(RetraitRetourDoc retraitRetourDoc) throws DataAccessException {
        try {
            return retraitRetourDocDao.create(retraitRetourDoc);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public RetraitRetourDoc updateRetraitRetourDoc(RetraitRetourDoc retraitRetourDoc) throws DataAccessException {
        try {
            return retraitRetourDocDao.update(retraitRetourDoc);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteRetraitRetourDoc(Long id_retraitRetourDoc) throws DataAccessException {
        try {
            RetraitRetourDoc rrd = retraitRetourDocDao.findById(id_retraitRetourDoc);
            retraitRetourDocDao.delete(rrd);
        } catch (Exception e) {
        }
    }

    @Override
    public RetraitRetourDoc findRetraitRetourDoc(Long docuementId, Long etudiantId, boolean etat) throws DataAccessException {
        try {
            return retraitRetourDocDao.findRetraitRetourDoc(docuementId, etudiantId, etat);
        } catch (Exception e) {
            return null;

        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RetraitRetourDoc findRetraitRetourDocById(long id_retraitRetourDoc) throws DataAccessException {
        try {
            return retraitRetourDocDao.findById(id_retraitRetourDoc);
        } catch (Exception e) {
            return null;

        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RetraitRetourDoc> findRetraitRetourDocAll() throws DataAccessException {
        try {
            return retraitRetourDocDao.findAll();
        } catch (Exception e) {
            return null;

        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RetraitRetourDoc findRetraitDoc(Documents documents, Etudiant etudiant) throws DataAccessException {
        try {
          //  return retraitRetourDocDao.findRetraitDoc(docuementId, etudiantId);
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public RetraitRetourDoc findRetraitRetourDoc1(Long docuementId, Long etudiantId, boolean etatInscription) throws DataAccessException {
        try {
            return retraitRetourDocDao.findRetraitRetourDoc1(docuementId, etudiantId, etatInscription);
        } catch (Exception e) {
            return null;

        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RetraitRetourDoc> findRetraitByDocument(Documents documents) throws DataAccessException {
        try {
            return retraitRetourDocDao.findRetraitByDocument(documents);
        } catch (Exception e) {
            return null;

        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RetraitRetourDoc> findRetourByDocument(Documents documents) throws DataAccessException {
         try {
            return retraitRetourDocDao.findRetourByDocument(documents);
        } catch (Exception e) {
            return null;

        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RetraitRetourDoc> findRetraitRetourByDocument(Documents documents) throws DataAccessException {
         try {
            return retraitRetourDocDao.findRetraitRetourByDocument(documents);
        } catch (Exception e) {
            return null;

        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RetraitRetourDoc> findRetraitDocument() throws DataAccessException {
        try {
            return retraitRetourDocDao.findRetraitDocument();
        } catch (Exception e) {
            return null;

        } //To change body of generated methods, choose Tools | Templates.
    }
}
