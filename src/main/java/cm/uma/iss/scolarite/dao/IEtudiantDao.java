/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

import cm.uma.iss.scolarite.entities.Documents;
import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.Inscription;
import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import cm.uma.iss.scolarite.entities.projection.EtudiantRetraitRetour;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IEtudiantDao extends IDao<Etudiant, Long> {

    public Etudiant findEtudiantByMatricule(String matricule) throws DataAccessException;

    public List<Etudiant> findEtudiantByNom(String nom) throws DataAccessException;

    public List<Etudiant> findEtudiantByPrenom(String prenom) throws DataAccessException;

    public List<Etudiant> findEtudiantByGenre(String genre) throws DataAccessException;

    public Etudiant findEtudiantByGenre1(String genre) throws DataAccessException;

    public List<Etudiant> findEtudiantByDateNaissance(String date_naiss) throws DataAccessException;

    public List<Etudiant> findEtudiantByLieuNaissance(String Lieu_naiss) throws DataAccessException;

    public List<Etudiant> findEtudiantByCategorie(String type_etudiant) throws DataAccessException;

    public List<Etudiant> findEtudiantByObservation(String observation) throws DataAccessException;

    public List<Etudiant> findEtudiantByInscription(Inscription inscription) throws DataAccessException;

    public List<Etudiant> findEtudiantByPays(PaysOrigine pays) throws DataAccessException;

    public List<Etudiant> findEtudiantByRegion(RegionOrigine region) throws DataAccessException;
    
    public List<Etudiant> findEtudiantbyDocument(Documents document) throws DataAccessException;
    
    public List<Etudiant> findEtudiantbyDocument1(Documents document) throws DataAccessException;
}
