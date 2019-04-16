/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.IRoleUtilisateurDao;
import cm.uma.iss.scolarite.entities.RoleUtilisateur;
import cm.uma.iss.scolarite.services.IRoleUtilisateurService;
import com.douwe.generic.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class RoleUtilisateurServiceImpl implements IRoleUtilisateurService {
    
    IRoleUtilisateurDao roleUtilisateurDao;
    
    public IRoleUtilisateurDao getRoleUtilisateurDao() {
        return roleUtilisateurDao;
    }

    public void setRoleUtilisateurDao(IRoleUtilisateurDao roleUtilisateurDao) {
        this.roleUtilisateurDao = roleUtilisateurDao;
    }
    
    
    
    @Override
    public RoleUtilisateur registerRoleUtilisateur(RoleUtilisateur roleUtilisateurr) throws DataAccessException {
        try {
            return roleUtilisateurDao.create(roleUtilisateurr);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public RoleUtilisateur updateRoleUtilisateur(RoleUtilisateur roleUtilisateurr) throws DataAccessException {
        try {
            return roleUtilisateurDao.update(roleUtilisateurr);
        } catch (Exception e) {
            
            return null;
                    
        }
    }

    @Override
    public void deleteRoleUtilisateur(Long id_roleUtilisateurr) throws DataAccessException {
        try {
            RoleUtilisateur ruti=roleUtilisateurDao.findById(id_roleUtilisateurr);
            roleUtilisateurDao.delete(ruti);
        } catch (Exception e) {
            
        }
    }

    @Override
    public RoleUtilisateur findRoleUtilisateurById(long id_roleUtilisateurr) throws DataAccessException {
        
        try {
            return roleUtilisateurDao.findById(id_roleUtilisateurr);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public RoleUtilisateur findByRoleuser(String roleuser) throws DataAccessException {
        try {
            return roleUtilisateurDao.findByRoleuser(roleuser);
        } catch (Exception e) {
            
            return null;
        }
    }
    
}
