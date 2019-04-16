/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

import cm.uma.iss.scolarite.entities.Documents;
import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.RetraitRetourDoc;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IRetraitRetourDocDao extends IDao<RetraitRetourDoc, Long> {

    public List<Etudiant> findRetraitRetourDocBy(boolean etat) throws DataAccessException;

    public List<Etudiant> findRetraitRetourDocBy(boolean etat, String Date) throws DataAccessException;

    public RetraitRetourDoc findRetraitRetourDoc(Long docuementId, Long etudiantId, boolean etat) throws DataAccessException;
    
    public RetraitRetourDoc findRetraitRetourDoc1( Long docuementId, Long etudiantId, boolean etatInscription) throws DataAccessException;
    
    public List<RetraitRetourDoc> findRetraitRetourDoc2( Documents document) throws DataAccessException;
            
    public RetraitRetourDoc findRetraitDoc(Documents documents, Etudiant etudiant) throws DataAccessException;
    
//    ------les bonnes methodes
    
    public List<RetraitRetourDoc> findRetraitDocument() throws DataAccessException;//methode permettant de faire le retrait d'un docuement par un étudiant
    
    public List<RetraitRetourDoc> findRetraitByDocument(Documents documents)throws DataAccessException;
    
    public List<RetraitRetourDoc> findRetourByDocument(Documents documents)throws DataAccessException;
    
    public List<RetraitRetourDoc> findRetraitRetourByDocument(Documents documents)throws DataAccessException;
    
    public RetraitRetourDoc findRetraitIdDocIdEtu( Long docuementId, Long etudiantId) throws DataAccessException;
}
