/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

import cm.uma.iss.scolarite.entities.Filiere;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IFiliereDao extends IDao<Filiere, Long> {

    public Filiere findFiliereByNom(String nom) throws DataAccessException;
    
    public Filiere findFiliereBySigle(String sigle) throws DataAccessException;
    
    public List<Filiere> findAllFiliere() throws  DataAccessException;
}
