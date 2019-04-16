/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IArrondissementOrigineDao;
import cm.uma.iss.scolarite.entities.ArrondissementOrigine;
import cm.uma.iss.scolarite.entities.DepartementOrigine;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import java.util.List;


public class ArrondissementOrigineDaoImpl extends GenericDao<ArrondissementOrigine, Long>implements IArrondissementOrigineDao {

    @Override
    public ArrondissementOrigine findArrondissementOrigineByNom(String nom) throws DataAccessException {
        return (ArrondissementOrigine)getManager().createQuery("select ao from arrondissementOrigine ao where ao.nom_arrondissementOrigine=:nom")
                .setParameter("nom", nom).getSingleResult();
    }

    @Override
    public List<ArrondissementOrigine> findArrondissementOrigneByDepartement(DepartementOrigine Departement) throws DataAccessException {
        return getManager().createQuery("select ao from arrondissementOrigine ao where ao.departementOrigine=:departement")
                .setParameter("departement", Departement).getResultList();
    }
    
}
