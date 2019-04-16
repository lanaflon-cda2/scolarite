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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author ngnawen
 */
@Entity(name="personne")
@Inheritance(strategy= InheritanceType.JOINED)
public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_personne")
    private Long id_personne;
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

    public Personne() {
    }

    public Personne(String nom, String prenom, String genre, String email, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.email = email;
        this.telephone = telephone;
    }
    
    

    public Long getId_personne() {
        return id_personne;
    }

    public void setId_personne(Long id_personne) {
        this.id_personne = id_personne;
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
    
    
}
