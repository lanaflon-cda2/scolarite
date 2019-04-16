/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.IPaiementDao;
import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.Paiement;
import cm.uma.iss.scolarite.services.IPaiementService;
import com.douwe.generic.dao.DataAccessException;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ngnawen
 */
@Transactional
public class PaiementServiceImpl implements IPaiementService {

    IPaiementDao paiementDao;

    public IPaiementDao getPaiementDao() {
        return paiementDao;
    }

    public void setPaiementDao(IPaiementDao paiementDao) {
        this.paiementDao = paiementDao;
    }
    

    @Override
    public Paiement registerPaiement(Paiement paiement) throws DataAccessException {
        return paiementDao.create(paiement);
    }

    @Override
    public Paiement updateEPaiement(Paiement paiement) throws DataAccessException {
        return paiementDao.update(paiement);
    }

    @Override
    public Paiement findPaiementById(long id_paiement) throws DataAccessException {
        return paiementDao.findById(id_paiement);
    }

    @Override
    public List<Paiement> getPaiementtByEtudiant(Etudiant etudiant) throws DataAccessException {
        return paiementDao.getPaiementtByEtudiant(etudiant);
    }

    @Override
    public List<Paiement> getPaiementByDate(Date date_paiement) throws DataAccessException {
        return paiementDao.getPaiementByDate(date_paiement);
    }

    @Override
    public void deletePaiement(Long id_inscription) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
