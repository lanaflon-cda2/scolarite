/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IEtudiantDao;
import cm.uma.iss.scolarite.entities.Documents;
import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.Inscription;
import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import cm.uma.iss.scolarite.entities.projection.EtudiantRetraitRetour;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public class EtudiantDaoImpl extends GenericDao<Etudiant, Long> implements IEtudiantDao {

    @Override
    public List<Etudiant> findEtudiantByDateNaissance(String date_naiss) throws DataAccessException {
        return getManager().createQuery("select e from etudiant e where e.date_naiss_etudiant=:date_naiss")
                .setParameter("nom", date_naiss).getResultList();
    }

    @Override
    public List<Etudiant> findEtudiantByLieuNaissance(String lieu_naiss) throws DataAccessException {
        return getManager().createQuery("select e from etudiant e where e.lieu_naiss_etudiant=:lieu_naiss")
                .setParameter("nom", lieu_naiss).getResultList();

    }

    @Override
    public List<Etudiant> findEtudiantByPays(PaysOrigine paysOrigine) throws DataAccessException {
        return getManager().createQuery("select e from etudiant e where e.paysOrigine=:paysOrigine")
                .setParameter("paysOrigine", paysOrigine).getResultList();
    }

    @Override
    public Etudiant findEtudiantByMatricule(String matricule) throws DataAccessException {
        return (Etudiant) getManager().createQuery("select e from etudiant e where e.matricule=:matricule")
                .setParameter("matricule", matricule).getSingleResult();
    }

    @Override
    public List<Etudiant> findEtudiantByGenre(String genre) throws DataAccessException {
        return getManager().createQuery("select e from etudiant e where e.genre=:genre")
                .setParameter("genre", genre).getResultList();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> findEtudiantByCategorie(String type_etudiant) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> findEtudiantByObservation(String observation) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> findEtudiantByInscription(Inscription inscription) throws DataAccessException {
        return getManager().createQuery("select e from etudiant e,inscription i where inscription=:inscription e.id_etudiant=i.etudiant.id_etudiant")
                .setParameter("inscription", inscription).getResultList();
    }

    @Override
    public List<Etudiant> findEtudiantByRegion(RegionOrigine regionOrigine) throws DataAccessException {
        return getManager().createQuery("select e from etudiant e where e.regionOrigine=:regionOrigine")
                .setParameter("regionOrigine", regionOrigine).getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> findEtudiantByNom(String nom) throws DataAccessException {
        return getManager().createQuery("select e from etudiant e where e.nom=:nom")
                .setParameter("nom", nom).getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> findEtudiantByPrenom(String prenom) throws DataAccessException {
        return getManager().createQuery("select e from etudiant e where e.prenom=:prenom")
                .setParameter("prenom", prenom).getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Etudiant findEtudiantByGenre1(String genre) throws DataAccessException {
        return (Etudiant) getManager().createQuery("select e from etudiant e where e.genre=:genre ORDER BY e.nom")
                .setParameter("genre", genre).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> findEtudiantbyDocument(Documents document) throws DataAccessException {
      return getManager().createQuery("select e from etudiant e,document d, retraitRetourDoc rrd where e.id_etudiant=rrd.etudiantId AND d.id_document=rrd.docuementId AND rrd.dateRetrait <>'' AND d=:document ORDER BY e.nom")
                .setParameter("document", document).getResultList(); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public List<Etudiant> findEtudiantbyDocument1(Documents document) throws DataAccessException {
      return getManager().createQuery("select e from etudiant e,document d, retraitRetourDoc rrd where e.id_etudiant=rrd.etudiantId AND d.id_document=rrd.docuementId AND rrd.dateRetour <>''AND rrd.dateRetrait <>'' AND d=:document ORDER BY e.nom")
                .setParameter("document", document).getResultList(); //To change body of generated methods, choose Tools | Templates.
    }



}
