/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.RoleUtilisateur;
import com.douwe.generic.dao.DataAccessException;

/**
 *
 * @author ngnawen
 */
public interface IRoleUtilisateurService {

    public RoleUtilisateur registerRoleUtilisateur(RoleUtilisateur roleUtilisateurr) throws DataAccessException;

    public RoleUtilisateur updateRoleUtilisateur(RoleUtilisateur roleUtilisateurr) throws DataAccessException;

    void deleteRoleUtilisateur(Long id_roleUtilisateurr) throws DataAccessException;

    public RoleUtilisateur findRoleUtilisateurById(long id_roleUtilisateurr) throws DataAccessException;

    public RoleUtilisateur findByRoleuser(String roleuser) throws DataAccessException;
}
