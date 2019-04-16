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

@Entity(name = "paysOrigine")
public class PaysOrigine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_paysOrigine", nullable = false)
    private Long id_pays;
    @Column(name = "nom_paysOrigine",unique = true)
    private String nom_pays;
    @OneToMany(mappedBy = "paysOrigine" )
    private List<Etudiant> etudiantList;
    @OneToMany(mappedBy = "paysOrigine" ,cascade = CascadeType.ALL)
    private List<RegionOrigine> regionOrigneList;

    // les  constructeurs
    public PaysOrigine() {
    }

    public PaysOrigine(String nom_pays) {
        this.nom_pays = nom_pays;
    }
    


//les getter et setter
    public Long getId_pays() {
        return id_pays;
    }

    public void setId_pays(Long id_pays) {
        this.id_pays = id_pays;
    }

    public String getNom_pays() {
        return nom_pays;
    }

    public void setNom_pays(String nom_pays) {
        this.nom_pays = nom_pays;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }


    public List<RegionOrigine> getRegionOrigneList() {
        return regionOrigneList;
    }

    public void setRegionOrigneList(List<RegionOrigine> regionOrigneList) {
        this.regionOrigneList = regionOrigneList;
    }

    @Override
    public String toString() {
        return "PaysOrigine{" + "id_pays=" + id_pays + ", nom_pays=" + nom_pays + '}';
    }


    
}