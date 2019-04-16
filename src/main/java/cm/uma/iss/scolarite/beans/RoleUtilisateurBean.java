/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.RoleUtilisateur;
import cm.uma.iss.scolarite.services.IRoleUtilisateurService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
public class RoleUtilisateurBean {
    @ManagedProperty(value = "#{IRoleUtilisateurService}")
    private IRoleUtilisateurService roleUtilisateurService;
    private RoleUtilisateur roleUtilisateur=new RoleUtilisateur();
    
    //constructeur
    public RoleUtilisateurBean() {
    }
    
    //getters and setters
    public IRoleUtilisateurService getRoleUtilisateurService() {
        return roleUtilisateurService;
    }

    public void setRoleUtilisateurService(IRoleUtilisateurService roleUtilisateurService) {
        this.roleUtilisateurService = roleUtilisateurService;
    }

    public RoleUtilisateur getRoleUtilisateur() {
        return roleUtilisateur;
    }

    public void setRoleUtilisateur(RoleUtilisateur roleUtilisateur) {
        this.roleUtilisateur = roleUtilisateur;
    }
    
    //connexion
//    public String connexion() {
//       try {
//           String username=roleUtilisateur.
//           String login = utilisateur.getLogin();
//          String pwd = utilisateur.getPassword();
//           String role=utilisateurService.findUtilisateurByLoginPwd(login, pwd).getRole_utilisateur();
//          System.out.println("Login : " + login + "  pwd: " + pwd+ "  Role de la base: "+role);
//          return "admin";
//       } catch (Exception e) {
//           //e.printStackTrace();
//            System.out.println("login et mot de passe incorrect");
//           return "erreur";
//        }
//       
//
//    }
    
}
