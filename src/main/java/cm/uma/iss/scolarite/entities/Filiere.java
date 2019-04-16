/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
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
@Entity(name = "filiere")
public class Filiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_filiere;
    @Column(name = "nom_filiere",unique = true, nullable = true)
    private String nom_filiere;
    @Column(name = "sigle_filiere",unique = true, nullable = true)
    private String sigle_filiere;
    @OneToMany(mappedBy = "filiere", cascade = {CascadeType.ALL})
    private List<NiveauFiliere> niveauFiliereList;
    @OneToMany(mappedBy = "filiere" ,cascade = CascadeType.ALL)
    private List<Option1> optionList;
    @OneToMany(mappedBy = "filiere")
    private List<Inscription> inscriptionList;
    //les annotations many-to-one
    //contructeurs
    public Filiere() {
    }

    public Filiere(String nom_filiere, String abreviation_filiere) {
        this.nom_filiere = nom_filiere;
    }
    

    //getters and setters
    
    public String getSigle_filiere() {
        return sigle_filiere;
    }

    public void setSigle_filiere(String sigle_filiere) {
        this.sigle_filiere = sigle_filiere;
    }
    
    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }
    public Long getId_filiere() {
        return id_filiere;
    }

    public void setId_filiere(Long id_filiere) {
        this.id_filiere = id_filiere;
    }

    public String getNom_filiere() {
        return nom_filiere;
    }

    public void setNom_filiere(String nom_filiere) {
        this.nom_filiere = nom_filiere;
    }
    public List<NiveauFiliere> getNiveauFiliereList() {
        return niveauFiliereList;
    }

    public void setNiveauFiliereList(List<NiveauFiliere> niveauFiliereList) {
        this.niveauFiliereList = niveauFiliereList;
    }

    public List<Option1> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option1> optionList) {
        this.optionList = optionList;
    }

    @Override
    public String toString() {
        return "Filiere{" + "id_filiere=" + id_filiere + ", nom_filiere=" + nom_filiere + '}';
    }
    
    

}
