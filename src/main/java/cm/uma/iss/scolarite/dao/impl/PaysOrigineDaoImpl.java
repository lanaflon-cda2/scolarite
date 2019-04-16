/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IPaysOrigineDao;
import cm.uma.iss.scolarite.entities.PaysOrigine;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;

/**
 *
 * @author ngnawen
 */
public class PaysOrigineDaoImpl extends GenericDao<PaysOrigine, Long> implements IPaysOrigineDao {

    @Override
    public PaysOrigine getPaysByNom(String nom_pays) throws DataAccessException {
       return (PaysOrigine) getManager().createQuery("select p from paysOrigine p where p.nom_pays=:nom ORDER BY p.nom_pays")
               .setParameter("nom", nom_pays).getSingleResult();
    }


}
