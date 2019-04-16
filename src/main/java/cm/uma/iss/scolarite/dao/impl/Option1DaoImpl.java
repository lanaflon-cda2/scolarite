/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IOption1Dao;
import cm.uma.iss.scolarite.entities.Option1;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;

/**
 *
 * @author ngnawen
 */
public class Option1DaoImpl extends GenericDao<Option1, Long> implements IOption1Dao{

    @Override
    public Option1 findOptionbyNom(String nom) throws DataAccessException {
       return (Option1) getManager().createQuery("select op from option1 op where op.nom_option1=:nom")
               .setParameter("nom", nom).getSingleResult();
    }
    
}
