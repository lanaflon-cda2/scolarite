/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.Option1;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IOption1Service {

    public Option1 registerOption1(Option1 option1) throws DataAccessException;

    public Option1 updateOption1(Option1 option1) throws DataAccessException;

    public void deleteOption1(Long id_option1) throws DataAccessException;

    public Option1 findOption1ById(long id_option1) throws DataAccessException;

    public List<Option1> findOption1All() throws DataAccessException;
    
    public Option1 findOptionbyNom(String nom) throws DataAccessException;
}
