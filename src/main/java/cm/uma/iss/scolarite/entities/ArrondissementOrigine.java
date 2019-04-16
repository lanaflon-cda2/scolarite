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
@Entity(name = "arrondissementOrigine")
public class ArrondissementOrigine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_arrondissementOrigine")
    private Long id_arrondissementOrigine;
    @Column(name = "nom_arrondissementOrigine")
    private String nom_arrondissementOrigine;
    @ManyToOne
    @JoinColumn(name = "id_departementOrigine")
    private DepartementOrigine departementOrigine;
    @OneToMany(mappedBy = "arrondissementOrigine")
    private List<Etudiant> etudiantList;

    public ArrondissementOrigine() {
    }

    //getters and setters
    public Long getId_arrondissementOrigine() {
        return id_arrondissementOrigine;
    }

    public void setId_arrondissementOrigine(Long id_arrondissementOrigine) {
        this.id_arrondissementOrigine = id_arrondissementOrigine;
    }

    public String getNom_arrondissementOrigine() {
        return nom_arrondissementOrigine;
    }

    public void setNom_arrondissementOrigine(String nom_arrondissementOrigine) {
        this.nom_arrondissementOrigine = nom_arrondissementOrigine;
    }

    public DepartementOrigine getDepartementOrigine() {
        return departementOrigine;
    }

    public void setDepartementOrigine(DepartementOrigine departementOrigine) {
        this.departementOrigine = departementOrigine;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }
}
