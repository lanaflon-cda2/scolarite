/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;


import cm.uma.iss.scolarite.entities.Droit_universitaire;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;

/**
 *
 * @author ngnawen
 */
public interface IDroit_universitaireDao extends IDao<Droit_universitaire, Long> {

    public Droit_universitaire getDroitUniversitairetByNature(String nature_droit_universitaire) throws DataAccessException;
}
