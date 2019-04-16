/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

import cm.uma.iss.scolarite.entities.Option1;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;

/**
 *
 * @author ngnawen
 */
public interface IOption1Dao extends IDao<Option1, Long> {

    public Option1 findOptionbyNom(String nom) throws DataAccessException;
}
