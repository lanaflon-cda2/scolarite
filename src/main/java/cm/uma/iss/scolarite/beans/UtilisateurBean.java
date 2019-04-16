/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.Utilisateur;
import cm.uma.iss.scolarite.services.IUtilisateurService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
public class UtilisateurBean {

    @ManagedProperty(value = "#{IUtilisateurService}")
    private IUtilisateurService utilisateurService;
    private Utilisateur utilisateur = new Utilisateur();

    //constucteurs
    public UtilisateurBean() {
    }

    //getters and setters
    public IUtilisateurService getUtilisateurService() {
        return utilisateurService;
    }

    public void setUtilisateurService(IUtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
