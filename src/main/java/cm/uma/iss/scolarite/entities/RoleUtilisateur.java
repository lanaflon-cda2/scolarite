/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author ngnawen
 */
@Entity(name="roleUtilisateur")
public class RoleUtilisateur implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_roleUtilisateur")
    private Long id_roleUtilisateur;
    @Column(name="roleUser")
    private String roleUser;
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;
    
    //constructeurs
    public RoleUtilisateur() {
        
    }
    
    
    //getters and setters
  

    public Long getId_roleUtilisateur() {
        return id_roleUtilisateur;
    }

    public void setId_roleUtilisateur(Long id_roleUtilisateur) {
        this.id_roleUtilisateur = id_roleUtilisateur;
    }
  

    public String getRoleuser() {
        return roleUser;
    }

    public void setRoleuser(String roleUser) {
        this.roleUser = roleUser;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "RoleUtilisateur{" + "roleUser=" + roleUser + ", utilisateur=" + utilisateur + '}';
    }

    
    
    
    
}
