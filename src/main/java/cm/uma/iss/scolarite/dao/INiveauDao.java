/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.Niveau;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface INiveauDao extends IDao<Niveau, Long> {

    public Niveau findNiveauByNom(String nom) throws DataAccessException;
    
    public List<Niveau> findNiveauByCycle(Cycle cycle)throws DataAccessException;
    
    public List<Niveau> findToutNiveau()throws DataAccessException;
}
