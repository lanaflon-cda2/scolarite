/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.RoleUtilisateur;
import cm.uma.iss.scolarite.entities.Utilisateur;
import com.douwe.generic.dao.DataAccessException;

/**
 *
 * @author ngnawen
 */
public interface IUtilisateurService {

    public Utilisateur registerUtilisateur(Utilisateur utilisateur) throws DataAccessException;

    public Utilisateur updateUtilisateur(Utilisateur utilisateur) throws DataAccessException;

    void deleteUtilisateur(Long id_utilisateur) throws DataAccessException;

    public Utilisateur findUtilisateurById(long id_utilisateur) throws DataAccessException;

    public Utilisateur findUtilisateurByLogin(String login) throws DataAccessException;

    public Utilisateur findUtilisateurByNom(String nom) throws DataAccessException;

    public Utilisateur findUtilisateurByPrenom(String prenom) throws DataAccessException;

    public Utilisateur findUtilisateurByEmail(String email) throws DataAccessException;

    public Utilisateur findUtilisateurByLoginPwd(String login, String password) throws DataAccessException;
    
     public RoleUtilisateur findUtilisateurByRole(String username) throws DataAccessException;
}
