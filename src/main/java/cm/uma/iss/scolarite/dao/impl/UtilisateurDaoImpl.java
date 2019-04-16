/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IUtilisateurDao;
import cm.uma.iss.scolarite.entities.RoleUtilisateur;
import cm.uma.iss.scolarite.entities.Utilisateur;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;

/**
 *
 * @author ngnawen
 */
public class UtilisateurDaoImpl extends GenericDao<Utilisateur, Long>  implements IUtilisateurDao{

    @Override
    public Utilisateur findUtilisateurByLogin(String username) throws DataAccessException {
        return (Utilisateur) getManager().createQuery("select u from utilisateur u where u.username=:username")
                .setParameter("username", username).getSingleResult();
    }

    @Override
    public Utilisateur findUtilisateurByLoginPwd(String login, String password) throws DataAccessException {
        return (Utilisateur)getManager().createQuery("select user from utilisateur user where user.login=:login AND user.password=:password")
                .setParameter("login", login).setParameter("password", password).getSingleResult();
    }

    @Override
    public Utilisateur findUtilisateurByPwd(String pwd) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RoleUtilisateur findUtilisateurByRole(String username) throws DataAccessException {
      return (RoleUtilisateur) getManager().createQuery("select ru from roleUtilisateur ru, utilisateur u join ru.utilisateur r_u where u.username=:username and r_u.id_utilisateur=u.id_utilisateur")
                .setParameter("username", username).getSingleResult();  
    }
    
}
