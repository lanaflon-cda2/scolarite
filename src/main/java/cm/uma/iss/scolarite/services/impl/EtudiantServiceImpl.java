/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.IEtudiantDao;
import cm.uma.iss.scolarite.entities.Documents;
import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.Inscription;
import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import cm.uma.iss.scolarite.services.IEtudiantService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ngnawen
 */
@Transactional
public class EtudiantServiceImpl implements IEtudiantService {

    //les interfaces dao
    IEtudiantDao etudiantDao;

    //getters and setters
    public IEtudiantDao getEtudiantDao() {
        return etudiantDao;
    }

    public void setEtudiantDao(IEtudiantDao etudiantDao) {
        this.etudiantDao = etudiantDao;
    }

// implementation des interfaces du service
    @Override
    public Etudiant registerEtudiant(Etudiant etudiant) {
        try {
            return etudiantDao.create(etudiant); 
        } catch (Exception e) {
            
            return null;
        }

    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) throws DataAccessException {
        try {
            return etudiantDao.update(etudiant);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteEtudiant(Long id_etudiant) throws DataAccessException {
        try {
            Etudiant etudiant=etudiantDao.findById(id_etudiant);
            etudiantDao.delete(etudiant);
        } catch (Exception e) {
            
        }

    }

    @Override
    public Etudiant findEtudintById(long id) throws DataAccessException {
        try {
            return etudiantDao.findById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Etudiant findEtudiantByMatricule(String matricule) throws DataAccessException {
        try {
            return etudiantDao.findEtudiantByMatricule(matricule);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Etudiant> findAllEtudiant() throws DataAccessException {
        try {
            return etudiantDao.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Etudiant> findEtudiantByDateNaissance(String date_naiss) throws DataAccessException {
        try {
            return etudiantDao.findEtudiantByDateNaissance(date_naiss);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Etudiant> findEtudiantByLieuNaissance(String Lieu_naiss) throws DataAccessException {
        try {
            return etudiantDao.findEtudiantByLieuNaissance(Lieu_naiss);
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public List<Etudiant> findEtudiantByNom(String nom) throws DataAccessException {
        try {
            return etudiantDao.findEtudiantByNom(nom);
        } catch (Exception e) {
            return null;
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> findEtudiantByPrenom(String prenom) throws DataAccessException {
        try {
            return etudiantDao.findEtudiantByPrenom(prenom);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> findEtudiantBySexe(String genre) throws DataAccessException {
        try {
            return etudiantDao.findEtudiantByGenre(genre);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> findEtudiantByType(String type_etudiant) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> findEtudiantByObservation(String observation) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Etudiant> findEtudiantByInscription(Inscription inscription) throws DataAccessException {
        try {
            return etudiantDao.findEtudiantByInscription(inscription);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public List<Etudiant> findEtudiantByPays(PaysOrigine pays) throws DataAccessException {
        try {
            return etudiantDao.findEtudiantByPays(pays);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Etudiant> findEtudiantByRegion(RegionOrigine regionOrigine) throws DataAccessException {
        try {
            return etudiantDao.findEtudiantByRegion(regionOrigine);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Etudiant findEtudiantByGenre1(String genre) throws DataAccessException {
    try {
            return etudiantDao.findEtudiantByGenre1(genre);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Etudiant> findEtudiantbyDocument(Documents document) throws DataAccessException {
        try {
            return etudiantDao.findEtudiantbyDocument(document);
        } catch (Exception e) {
            return null;
        }
    }
    
     @Override
    public List<Etudiant> findEtudiantbyDocument1(Documents document) throws DataAccessException {
        try {
            return etudiantDao.findEtudiantbyDocument1(document);
        } catch (Exception e) {
            return null;
        }
    }
}