/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IRetraitRetourDocDao;
import cm.uma.iss.scolarite.entities.Documents;
import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.RetraitRetourDoc;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ngnawen
 */
public class RetraitRetourDocDaoImpl extends GenericDao<RetraitRetourDoc, Long> implements IRetraitRetourDocDao {

    @Override
    public List<Etudiant> findRetraitRetourDocBy(boolean etatPreinscription) throws DataAccessException {
        return getManager().createQuery("select e from etudiant e,retraitRetourDoc r where e.id_etudiant=r.etudiantId AND r.etatPreinscription=:etatPreinscription")
                .setParameter("etatPreinscription", etatPreinscription).getResultList();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> findRetraitRetourDocBy(boolean etat, String Date) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RetraitRetourDoc findRetraitRetourDoc( Long docuementId, Long etudiantId, boolean etatPreinscription) throws DataAccessException {
        Query query=getManager().createQuery("select rd from retraitRetourDoc rd where rd.docuementId=:docuementId AND rd.etudiantId=:etudiantId AND rd.etatPreinscription=:etatPreinscription");
        query.setParameter("docuementId", docuementId);
        query.setParameter("etudiantId", etudiantId);
        query.setParameter("etatPreinscription", etatPreinscription);
        return (RetraitRetourDoc) query.getSingleResult();
    }

    @Override
    public RetraitRetourDoc findRetraitRetourDoc1( Long docuementId, Long etudiantId, boolean etatInscription) throws DataAccessException {
        Query query=getManager().createQuery("select rd from retraitRetourDoc rd where rd.docuementId=:docuementId AND rd.etudiantId=:etudiantId AND rd.etatInscription=:etatInscription");
        query.setParameter("docuementId", docuementId);
        query.setParameter("etudiantId", etudiantId);
        query.setParameter("etatInscription", etatInscription);
        return (RetraitRetourDoc) query.getSingleResult();
    }
    
    @Override
    public RetraitRetourDoc findRetraitDoc(Documents documents, Etudiant etudiant) throws DataAccessException {
      Query query=getManager().createQuery("select rd from retraitRetourDoc rd where rd.documents=:documents AND rd.etudiant=:etudiant");
        query.setParameter("documents", documents);
        query.setParameter("etudiant", etudiant);
        return  (RetraitRetourDoc) query.getSingleResult();
    }

    @Override
    public List<RetraitRetourDoc> findRetraitRetourDoc2(Documents document) throws DataAccessException {
        Query query=getManager().createQuery("select e.matricule,e.nom,rd.dateRetrait from etudiant e,retraitRetourDoc rd,document d where rd.docuementId=: AND rd.etudiantId=:etudiantId");
        query.setParameter("documents", document);
       return  query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RetraitRetourDoc> findRetraitByDocument(Documents documents) throws DataAccessException {
        Query query=getManager().createQuery("select rrd from retraitRetourDoc rrd,document d where rrd.dateRetrait <>''AND rrd.dateRetour=null  AND d=:documents ORDER BY rrd.etudiant.nom");
        query.setParameter("documents", documents);
       return  query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RetraitRetourDoc> findRetourByDocument(Documents documents) throws DataAccessException {
        Query query=getManager().createQuery("select rrd from retraitRetourDoc rrd,document d where rrd.dateRetour <>'' AND d=:documents ORDER BY rrd.etudiant.nom");
        query.setParameter("documents", documents);
       return  query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RetraitRetourDoc> findRetraitRetourByDocument(Documents documents) throws DataAccessException {
        Query query=getManager().createQuery("select rrd from retraitRetourDoc rrd,document d where rrd.dateRetrait<>'' AND rrd.dateRetour <>'' AND d=:documents ORDER BY rrd.etudiant.nom");
        query.setParameter("documents", documents);
       return  query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RetraitRetourDoc> findRetraitDocument() throws DataAccessException {
        Query query=getManager().createQuery("select rd from retraitRetourDoc rd");
//        query.setParameter("documentId",documentId);
//        query.setParameter("etudiantId", etudiantId);
        return  query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public RetraitRetourDoc findRetraitIdDocIdEtu( Long documentId, Long etudiantId) throws DataAccessException {
        Query query=getManager().createQuery("select rd from retraitRetourDoc rd where rd.documents.id_document=:documentId AND rd.etudiant.id_etudiant=:etudiantId");
        query.setParameter("documentId", documentId);
        query.setParameter("etudiantId", etudiantId);
        return (RetraitRetourDoc) query.getSingleResult();
    }


   

    
}
