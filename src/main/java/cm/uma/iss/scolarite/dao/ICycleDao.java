/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

import cm.uma.iss.scolarite.entities.Cycle;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;

/**
 *
 * @author ngnawen
 */
public interface ICycleDao extends IDao<Cycle, Long> {

    public Cycle findCycleByNom(String nom_cycle) throws DataAccessException;
    
}
