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
import javax.persistence.Table;

@Entity
@Table(name = "droit_universitaire")
public class Droit_universitaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_droit_universitaire")
    private Long id_droit_universitaire;
    @Column(name = "nature_droit_universitaire")
    private String nature_droit_universitaire;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "droit_universitaire")
    private List<Paiement> paiementList;

    //les constructeurs
    public Droit_universitaire() {
    }

    public Long getId_droit_universitaire() {
        return id_droit_universitaire;
    }

    public void setId_droit_universitaire(Long id_droit_universitaire) {
        this.id_droit_universitaire = id_droit_universitaire;
    }

    public String getNature_droit_universitaire() {
        return nature_droit_universitaire;
    }

    public void setNature_droit_universitaire(String nature_droit_universitaire) {
        this.nature_droit_universitaire = nature_droit_universitaire;
    }

    public List<Paiement> getPaiementList() {
        return paiementList;
    }

    public void setPaiementList(List<Paiement> paiementList) {
        this.paiementList = paiementList;
    }

    @Override
    public String toString() {
        return "Droit_universitaire{" + "id_droit_universitaire=" + id_droit_universitaire + ", nature_droit_universitaire=" + nature_droit_universitaire + ", paiementList=" + paiementList + '}';
    }


}