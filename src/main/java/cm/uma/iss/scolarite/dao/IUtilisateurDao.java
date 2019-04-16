/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

import cm.uma.iss.scolarite.entities.RoleUtilisateur;
import cm.uma.iss.scolarite.entities.Utilisateur;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;

/**
 *
 * @author ngnawen
 */
public interface IUtilisateurDao extends IDao<Utilisateur, Long> {

    public Utilisateur findUtilisateurByLogin(String login) throws DataAccessException;

    public RoleUtilisateur findUtilisateurByRole(String username) throws DataAccessException;

    public Utilisateur findUtilisateurByPwd(String pwd) throws DataAccessException;

    public Utilisateur findUtilisateurByLoginPwd(String login, String password) throws DataAccessException;
}
