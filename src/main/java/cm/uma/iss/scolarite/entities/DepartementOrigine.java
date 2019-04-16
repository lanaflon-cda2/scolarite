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
@Entity(name="departementOrigine")
public class DepartementOrigine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_departementOrigine")
    private Long id_departementOrigine;
    @Column(name="nom_departementOrigine")
    private String nom_departementOrigine;
    @ManyToOne
    @JoinColumn(name = "id_regionOrigine")
    private RegionOrigine regionOrigine;
    @OneToMany(mappedBy = "departementOrigine")
    private List<Etudiant> etudiantList;
    @OneToMany(mappedBy = "departementOrigine",cascade = CascadeType.ALL)
    private List<ArrondissementOrigine> arrondissementOrigineList;


    public DepartementOrigine() {
    }
    
    //getters and setters
    public Long getId_departementOrigine() {
        return id_departementOrigine;
    }

    public void setId_departementOrigine(Long id_departementOrigine) {
        this.id_departementOrigine = id_departementOrigine;
    }

    public String getNom_departementOrigine() {
        return nom_departementOrigine;
    }

    public void setNom_departementOrigine(String nom_departementOrigine) {
        this.nom_departementOrigine = nom_departementOrigine;
    }

    public RegionOrigine getRegionOrigine() {
        return regionOrigine;
    }

    public void setRegionOrigine(RegionOrigine regionOrigine) {
        this.regionOrigine = regionOrigine;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    public List<ArrondissementOrigine> getArrondissementOrigineList() {
        return arrondissementOrigineList;
    }

    public void setArrondissementOrigineList(List<ArrondissementOrigine> arrondissementOrigineList) {
        this.arrondissementOrigineList = arrondissementOrigineList;
    }

 
    public List<ArrondissementOrigine> getArrondissementOriginesList() {
        return arrondissementOrigineList;
    }

    public void setArrondissementOriginesList(List<ArrondissementOrigine> arrondissementOriginesList) {
        this.arrondissementOrigineList = arrondissementOriginesList;
    }
    
    
    
    

    
}
