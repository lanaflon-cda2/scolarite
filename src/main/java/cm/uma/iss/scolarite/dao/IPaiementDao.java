/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.Paiement;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IPaiementDao extends IDao<Paiement, Long> {

    public List<Paiement> getPaiementtByEtudiant(Etudiant etudiant) throws DataAccessException;

    public List<Paiement> getPaiementByDate(Date date_paiement) throws DataAccessException;
}
