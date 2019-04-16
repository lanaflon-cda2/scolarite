/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.Niveau;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface INiveauService {

    public Niveau registerNiveau(Niveau niveau) throws DataAccessException;

    public Niveau updateNiveau(Niveau niveau) throws DataAccessException;

    public void deleteNiveau(Long id_niveau) throws DataAccessException;

    public Niveau findNiveauById(long id_niveau) throws DataAccessException;

    public List<Niveau> findNiveauAll() throws DataAccessException;

    public Niveau findNiveauByNom(String nom) throws DataAccessException;
    
    public List<Niveau> findNiveauByCycle(Cycle cycle)throws DataAccessException;
    
    public List<Niveau> findToutNiveau() throws DataAccessException;
}
