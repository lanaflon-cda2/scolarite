/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IPaiementDao;
import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.Paiement;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public class PaiementDaoImpl extends GenericDao<Paiement, Long> implements IPaiementDao{

    /**
     *
     * @param etudiant
     * @return la liste des paiements d'un etudaint
     * @throws DataAccessException
     */
    @Override
    public List<Paiement> getPaiementtByEtudiant(Etudiant etudiant) throws DataAccessException {
//        return getManager().createQuery("select p from Paiement p join p.etudiant e where e.id_etudiant=idEtudiant")
//                .setParameter("idEtudiant", etudiant.getId_etudiant()).getResultList();
        return null;

    }

    /**
     *
     * @param date_paiement
     * @return la liste des paiement d'une date precise
     * @throws DataAccessException
     */
    @Override
    public List<Paiement> getPaiementByDate(Date date_paiement) throws DataAccessException {
        return getManager().createQuery("select p from Paiement p where p.date_paiement=:datePaiement")
                .setParameter("datePaiement", date_paiement).getResultList();
    }
}
