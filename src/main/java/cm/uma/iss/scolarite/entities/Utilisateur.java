package cm.uma.iss.scolarite.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "utilisateur")
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_utilisateur")
    private Long id_utilisateur;
    @Column(name = "nom", nullable = true)
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "genre")
    private String genre;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "enabled", nullable = false)
    private boolean enabled;
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<RoleUtilisateur> roleUtilisateurList;

    //constructeurs
    public Utilisateur() {
    }

    //getters and setters
    public Long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<RoleUtilisateur> getRoleUtilisateurList() {
        return roleUtilisateurList;
    }

    public void setRoleUtilisateurList(List<RoleUtilisateur> roleUtilisateurList) {
        this.roleUtilisateurList = roleUtilisateurList;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id_utilisateur=" + id_utilisateur + ", nom=" + nom + ", prenom=" + prenom + ", genre=" + genre + ", email=" + email + ", telephone=" + telephone + ", username=" + username + ", password=" + password + ", enabled=" + enabled + '}';
    }

}
