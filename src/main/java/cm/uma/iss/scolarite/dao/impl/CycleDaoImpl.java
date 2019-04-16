/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.ICycleDao;
import cm.uma.iss.scolarite.entities.Cycle;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;

/**
 *
 * @author ngnawen
 */
public class CycleDaoImpl extends GenericDao<Cycle, Long> implements ICycleDao{

    @Override
    public Cycle findCycleByNom(String nom) throws DataAccessException {
               return (Cycle)getManager().createQuery("select c from cycle c where c.nom_cycle=:nom")
               .setParameter("nom", nom).getSingleResult();
    }
}
