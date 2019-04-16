/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

import cm.uma.iss.scolarite.entities.RoleUtilisateur;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;

/**
 *
 * @author ngnawen
 */
public interface  IRoleUtilisateurDao extends IDao<RoleUtilisateur, Long>{
    
    public RoleUtilisateur findByRoleuser(String roleuser) throws DataAccessException;
    
}
