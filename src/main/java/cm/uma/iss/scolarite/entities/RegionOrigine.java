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
@Entity(name="regionOrigine")
public class RegionOrigine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_regionOrigne")
    private Long id_regionOrigne;
    @Column(name="nom_regionOrigine")
    private String nom_regionOrigine;
    @ManyToOne
    @JoinColumn(name = "id_paysOrigine")
    private PaysOrigine paysOrigine;
    @OneToMany(mappedBy = "regionOrigine")
    private List<Etudiant> etudiantList;
    @OneToMany(mappedBy = "regionOrigine",cascade = CascadeType.ALL)
    private List<DepartementOrigine> departementOrigineList;

    public RegionOrigine() {
    }
    
    //getters and setters
    public Long getId_regionOrigne() {
        return id_regionOrigne;
    }

    public void setId_regionOrigne(Long id_regionOrigne) {
        this.id_regionOrigne = id_regionOrigne;
    }

    public String getNom_regionOrigine() {
        return nom_regionOrigine;
    }

    public void setNom_regionOrigine(String nom_regionOrigine) {
        this.nom_regionOrigine = nom_regionOrigine;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }
    
    
    public PaysOrigine getPaysOrigine() {
        return paysOrigine;
    }

    public void setPaysOrigine(PaysOrigine paysOrigine) {
        this.paysOrigine = paysOrigine;
    }
    

    public List<DepartementOrigine> getDepartementOrigineList() {
        return departementOrigineList;
    }

    public void setDepartementOrigineList(List<DepartementOrigine> departementOrigineList) {
        this.departementOrigineList = departementOrigineList;
    }

    @Override
    public String toString() {
        return "RegionOrigine{" + "id_regionOrigne=" + id_regionOrigne + ", nom_regionOrigine=" + nom_regionOrigine + ", paysOrigine=" + paysOrigine + '}';
    }
    
  
    
    
}
