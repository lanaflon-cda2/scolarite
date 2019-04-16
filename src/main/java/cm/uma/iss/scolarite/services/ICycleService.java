/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.Cycle;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface ICycleService {

    public Cycle registerCycle(Cycle cycle) throws DataAccessException;

    public Cycle updateCycle(Cycle cycle) throws DataAccessException;

    public void deleteCycle(Long id_cycle) throws DataAccessException;
    
    public void deleteCycle1(Cycle cycle) throws DataAccessException;

    public Cycle findCycleById(long id_cycle) throws DataAccessException;

    public List<Cycle> findCycleAll() throws DataAccessException;

    public Cycle findCycleByNom(String nom_cycle) throws DataAccessException;
}
