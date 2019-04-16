/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

import cm.uma.iss.scolarite.entities.PaysOrigine;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;

/**
 *
 * @author ngnawen
 */
public interface IPaysOrigineDao extends IDao<PaysOrigine, Long> {

    public PaysOrigine getPaysByNom(String nom_pays) throws DataAccessException;
}