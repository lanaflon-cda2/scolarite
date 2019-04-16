/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IDroit_universitaireDao;
import cm.uma.iss.scolarite.entities.Droit_universitaire;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;

/**
 *
 * @author ngnawen
 */
public class Droit_universitaireDaoImpl extends GenericDao<Droit_universitaire, Long> implements IDroit_universitaireDao {

    @Override
    public Droit_universitaire getDroitUniversitairetByNature(String nature_droit_universitaire) throws DataAccessException {
        return (Droit_universitaire) getManager().createQuery("select du from Droit_universitaire du where du.nature_droit_universitaire=:nature_droit_universitaire")
                .setParameter("nature_droit_universitaire", nature_droit_universitaire).getSingleResult();
    }
}
