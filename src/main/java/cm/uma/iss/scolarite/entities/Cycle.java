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
import javax.persistence.OneToMany;

/**
 *
 * @author ngnawen
 */
@Entity(name = "cycle")
public class Cycle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cycle;
    @Column(name = "nom_cycle",unique = true, nullable = false)
    private String nom_cycle;
    @OneToMany(mappedBy="cycle" , cascade = CascadeType.ALL)
    private List<Niveau> niveauList;
    @OneToMany(mappedBy = "cycle")
    private List<Inscription> inscriptionList;
    //les annotations many-to-one

    //constructeurs
    public Cycle() {
    }

    public Cycle(String nom_cycle) {
        this.nom_cycle = nom_cycle;
    }

    //getters and setters
    
    public Long getId_cycle() {
        return id_cycle;
    }

    public void setId_cycle(Long id_cycle) {
        this.id_cycle = id_cycle;
    }

    public List<Niveau> getNiveauList() {
        return niveauList;
    }

    public void setNiveauList(List<Niveau> niveauList) {
        this.niveauList = niveauList;
    }

    public String getNom_cycle() {
        return nom_cycle;
    }

    public void setNom_cycle(String nom_cycle) {
        this.nom_cycle = nom_cycle;
    }

    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    @Override
    public String toString() {
        return "Cycle{" + "id_cycle=" + id_cycle + ", nom_cycle=" + nom_cycle + '}';
    }
    
    

}
