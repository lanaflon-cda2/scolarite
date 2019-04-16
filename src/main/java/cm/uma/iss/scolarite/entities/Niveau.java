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
@Entity(name = "niveau")
public class Niveau implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_niveau;
    @Column(name = "nom_niveau",unique = true, nullable = false)
    private String nom_niveau;
//    @Column(name = "abrevition_niveau")
//    private String abreviation_niveau;
    @OneToMany(mappedBy = "niveau", cascade = {CascadeType.REMOVE})
    private List<NiveauFiliere> niveauFiliereList;
    @OneToMany(mappedBy = "niveau")
    private List<Inscription> inscriptionList;
    //les annotations many-to-one
    @ManyToOne
    @JoinColumn(name = "id_cycle")
    private Cycle cycle;

    // constructeurs
    public Niveau() {
    }

    public Niveau(String nom_niveau) {
        this.nom_niveau = nom_niveau;
    }

    public Niveau(String nom_niveau,Cycle cycle) {
        this.nom_niveau = nom_niveau;
        this.cycle = cycle;
    }

    //getters and setters
    public Long getId_niveau() {
        return id_niveau;
    }

    public void setId_niveau(Long id_niveau) {
        this.id_niveau = id_niveau;
    }

    public String getNom_niveau() {
        return nom_niveau;
    }

    public void setNom_niveau(String nom_niveau) {
        this.nom_niveau = nom_niveau;
    }

    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }


    public Cycle getCycle() {
        return cycle;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    public List<NiveauFiliere> getNiveauFiliereList() {
        return niveauFiliereList;
    }

    public void setNiveauFiliereList(List<NiveauFiliere> niveauFiliereList) {
        this.niveauFiliereList = niveauFiliereList;
    }

    @Override
    public String toString() {
        return "Niveau{" + "id_niveau=" + id_niveau + ", nom_niveau=" + nom_niveau + ", cycle=" + cycle + '}';
    }
    
    
    
}
