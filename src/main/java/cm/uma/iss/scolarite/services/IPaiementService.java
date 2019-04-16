/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.Paiement;
import com.douwe.generic.dao.DataAccessException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IPaiementService {

    public Paiement registerPaiement(Paiement paiement) throws DataAccessException;

    public Paiement updateEPaiement(Paiement paiement) throws DataAccessException;

    public void deletePaiement(Long id_paiement) throws DataAccessException;

    public Paiement findPaiementById(long id_paiement) throws DataAccessException;
    public List<Paiement> getPaiementtByEtudiant(Etudiant etudiant) throws DataAccessException;

    public List<Paiement> getPaiementByDate(Date date_paiement) throws DataAccessException;
}
