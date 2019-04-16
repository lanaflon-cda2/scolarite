/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author ngnawen
 */
@Entity(name = "option1")
public class Option1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_option1;
    @Column(name = "nom_option1",unique = true, nullable = false)
    private String nom_option1;
//    @Column(name = "abreviation_option1")
//    private String abreviation_option1;
    @ManyToOne
    @JoinColumn(name = "id_filiere")
    private Filiere filiere;
    @OneToMany(mappedBy = "option1")
    private List<Inscription> inscriptionList;
    //les annotations many-to-one

    //constructeurs
    public Option1() {
    }

    public Option1(String nom_option1, Filiere filiere) {
        this.nom_option1 = nom_option1;
        this.filiere = filiere;
    }

    //getters and setters
    public Long getId_option1() {
        return id_option1;
    }

    public void setId_option1(Long id_option1) {
        this.id_option1 = id_option1;
    }

    public String getNom_option1() {
        return nom_option1;
    }

    public void setNom_option1(String nom_option1) {
        this.nom_option1 = nom_option1;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    @Override
    public String toString() {
        return "Option1{" + "id_option1=" + id_option1 + ", nom_option1=" + nom_option1 + ", filiere=" + filiere + '}';
    }
    
    
}
