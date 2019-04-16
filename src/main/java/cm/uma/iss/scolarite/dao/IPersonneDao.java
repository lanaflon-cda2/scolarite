/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

import cm.uma.iss.scolarite.entities.Personne;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IPersonneDao extends IDao<Personne, Long> {

    public List<Personne> findPersonneByNom(String nom) throws DataAccessException;

    public List<Personne> findPersonneByPrenom(String prenom) throws DataAccessException;
    
    public  List<Personne> findPersonneByEmail(String email) throws  DataAccessException;
    
    public  List<Personne> findPersonneByTelephone(String telephone) throws  DataAccessException;
}
