/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IDepartementOrigineDao;
import cm.uma.iss.scolarite.entities.DepartementOrigine;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import java.util.List;


public class DepartementOrigineDaoImpl extends GenericDao<DepartementOrigine,Long> implements IDepartementOrigineDao {

    @Override
    public DepartementOrigine findDepartementOrigineByNom(String nom) throws DataAccessException {
        return (DepartementOrigine)getManager().createQuery("select do from departementOrigine do where do.nom_departementOrigine=:nom")
                .setParameter("nom", nom).getSingleResult();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DepartementOrigine> findDepartementOrigineByRegion(RegionOrigine regionOrigine) throws DataAccessException {
        return getManager().createQuery("select do from departementOrigine do where do.regionOrigine=:regionOrigine")
                .setParameter("regionnOrigine", regionOrigine).getResultList();
    }
    
}
