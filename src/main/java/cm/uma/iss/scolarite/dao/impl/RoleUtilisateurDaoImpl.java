/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IRoleUtilisateurDao;
import cm.uma.iss.scolarite.entities.RoleUtilisateur;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;


public class RoleUtilisateurDaoImpl extends GenericDao<RoleUtilisateur, Long> implements IRoleUtilisateurDao {

    @Override
    public RoleUtilisateur findByRoleuser(String roleuser) throws DataAccessException {
       
        return (RoleUtilisateur)getManager().createQuery("select ru from roleUtilisateur ru where ru.roleuser=:roleuser")
                .setParameter(roleuser, "roleuser").getSingleResult();
    }

    
    
}
