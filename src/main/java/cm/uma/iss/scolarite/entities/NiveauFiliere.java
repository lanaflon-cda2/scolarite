/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *NiveauFiliere est la classe d'association entre la filiere et le niveau
 * @author ngnawen
 */
@Entity(name = "niveauFiliere")
public class NiveauFiliere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_niveauFiliere;
    //annotations
    @ManyToOne
    @JoinColumn(name = "id_niveau")
    private Niveau niveau;
    @ManyToOne
    @JoinColumn(name = "id_filiere")
    private Filiere filiere;
    
    
    //constructeurs
    public NiveauFiliere() {
    }

    public NiveauFiliere(Niveau niveau, Filiere filiere) {
        this.niveau = niveau;
        this.filiere = filiere;
    }

    
    //getters and setters
    public Long getId() {
        return id_niveauFiliere;
    }

    public void setId(Long id_niveauFiliere) {
        this.id_niveauFiliere =id_niveauFiliere;
    }

    public Long getId_niveauFiliere() {
        return id_niveauFiliere;
    }

    public void setId_niveauFiliere(Long id_niveauFiliere) {
        this.id_niveauFiliere = id_niveauFiliere;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

//    @Override
//    public String toString() {
//        return "NiveauFiliere{" + "id_niveauFiliere=" + id_niveauFiliere + ", niveau=" + niveau + ", filiere=" + filiere + '}';
//    }
    

}
