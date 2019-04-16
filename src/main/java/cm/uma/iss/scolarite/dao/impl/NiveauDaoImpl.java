/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.INiveauDao;
import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.Niveau;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public class NiveauDaoImpl extends GenericDao<Niveau, Long> implements INiveauDao {

    @Override
    public Niveau findNiveauByNom(String nom) throws DataAccessException {
        return (Niveau) getManager().createQuery("select n from niveau n where n.nom_niveau=:nom ORDER BY n.nom_niveau")
                .setParameter("nom", nom).getSingleResult();
    }

    @Override
    public List<Niveau> findNiveauByCycle(Cycle cycle) throws DataAccessException {
        return getManager().createQuery("select c from niveau n where n.cycle=:cycle ORDER BY n.nom_niveau")
                .setParameter("cycle", cycle).getResultList();
    }

    @Override
    public List<Niveau> findToutNiveau() throws DataAccessException {
        return getManager().createQuery("select n from niveau n ORDER BY n.nom_niveau").getResultList();
    }
}
