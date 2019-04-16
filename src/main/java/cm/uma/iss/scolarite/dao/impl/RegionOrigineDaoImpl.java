/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IRegionOrigineDao;
import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import java.util.List;


public class RegionOrigineDaoImpl extends GenericDao<RegionOrigine,Long>implements IRegionOrigineDao {

    @Override
    public RegionOrigine findRegionOrigineByNom(String nom) throws DataAccessException {
        return (RegionOrigine) getManager().createQuery("select ro from regionOrigine ro where ro.nom_regionOrigine=:nom ")
                .setParameter("nom", nom).getSingleResult();
    }

    @Override
    public List<RegionOrigine> findRegionByPays(PaysOrigine pays) throws DataAccessException {
        return getManager().createQuery("select ro from regionOrigine ro where ro.paysOrigine=:pays")
                .setParameter("pays", pays).getResultList();
    }

    @Override
    public List<RegionOrigine> findRegionTout() throws DataAccessException {
       return getManager().createQuery("select ro from regionOrigine ro ORDER BY ro.nom_regionOrigine").getResultList();
    }
}
