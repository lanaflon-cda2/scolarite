/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.Documents;
import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.RetraitRetourDoc;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IRetraitRetourDocService {

    public RetraitRetourDoc registerRetraitRetourDoc(RetraitRetourDoc retraitRetourDoc) throws DataAccessException;

    public RetraitRetourDoc updateRetraitRetourDoc(RetraitRetourDoc retraitRetourDoc) throws DataAccessException;

    public void deleteRetraitRetourDoc(Long id_retraitRetourDoc) throws DataAccessException;

    public RetraitRetourDoc findRetraitRetourDocById(long id_retraitRetourDoc) throws DataAccessException;

    public List<RetraitRetourDoc> findRetraitRetourDocAll() throws DataAccessException;

    public RetraitRetourDoc findRetraitRetourDoc(Long docuementId, Long etudiantId, boolean etat) throws DataAccessException;

    public RetraitRetourDoc findRetraitDoc(Documents documents, Etudiant etudiant) throws DataAccessException;

    public RetraitRetourDoc findRetraitRetourDoc1(Long docuementId, Long etudiantId, boolean etatInscription) throws DataAccessException;

//    ------les bonnes methodes
    public List<RetraitRetourDoc> findRetraitDocument() throws DataAccessException;
    
    public List<RetraitRetourDoc> findRetraitByDocument(Documents documents) throws DataAccessException;

    public List<RetraitRetourDoc> findRetourByDocument(Documents documents) throws DataAccessException;

    public List<RetraitRetourDoc> findRetraitRetourByDocument(Documents documents) throws DataAccessException;
}
