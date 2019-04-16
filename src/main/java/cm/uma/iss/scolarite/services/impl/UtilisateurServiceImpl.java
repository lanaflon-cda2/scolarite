/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.IUtilisateurDao;
import cm.uma.iss.scolarite.entities.RoleUtilisateur;
import cm.uma.iss.scolarite.entities.Utilisateur;
import cm.uma.iss.scolarite.services.IUtilisateurService;
import com.douwe.generic.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ngnawen
 */
@Transactional
public class UtilisateurServiceImpl implements IUtilisateurService {

    IUtilisateurDao utilisateurDao;
    
    //getters and setters
    public IUtilisateurDao getUtilisateurDao() {
        return utilisateurDao;
    }

    public void setUtilisateurDao(IUtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }
    

    @Override
    public Utilisateur registerUtilisateur(Utilisateur utilisateur) throws DataAccessException {
        try {
           return utilisateurDao.create(utilisateur);
        } catch (Exception e) {
            return null;
            
        }
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) throws DataAccessException {
        try {
            return utilisateurDao.update(utilisateur);
        } catch (Exception e) {
            return null;
        }
        
    }

    @Override
    public void deleteUtilisateur(Long id_utilisateur) throws DataAccessException {
        try {
            Utilisateur utilisateur=utilisateurDao.findById(id_utilisateur);
            utilisateurDao.delete(utilisateur);
        } catch (Exception e) {
        }
    }

    @Override
    public Utilisateur findUtilisateurById(long id_utilisateur) throws DataAccessException {
        try {
            return utilisateurDao.findById(id_utilisateur);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Utilisateur findUtilisateurByLogin(String login) throws DataAccessException {
        try {
            return utilisateurDao.findUtilisateurByLogin(login);
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public Utilisateur findUtilisateurByLoginPwd(String login, String password) throws DataAccessException {
        try {
            return utilisateurDao.findUtilisateurByLoginPwd(login, password);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Utilisateur findUtilisateurByNom(String nom) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur findUtilisateurByPrenom(String prenom) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur findUtilisateurByEmail(String email) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RoleUtilisateur findUtilisateurByRole(String username) throws DataAccessException {
        try {
            return utilisateurDao.findUtilisateurByRole(username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
