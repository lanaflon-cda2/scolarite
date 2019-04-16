package cm.uma.iss.scolarite.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity(name="paiement")
public class Paiement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_paiement")
    private Long id_paiement;
    @Column(name="date_paiement")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_paiement;
    //annotations many-to-one
    @ManyToOne
    @JoinColumn(name = "id_droit_universitaire")
    private Droit_universitaire droit_universitaire;
    @ManyToOne
    @JoinColumn(name = "id_etudiant")
    private Etudiant etudiant;

    public Long getId_paiement() {
        return id_paiement;
    }

    public void setId_paiement(Long id_paiement) {
        this.id_paiement = id_paiement;
    }

    public Date getDate_paiement() {
        return date_paiement;
    }

    public void setDate_paiement(Date date_paiement) {
        this.date_paiement = date_paiement;
    }

    public Droit_universitaire getDroit_universitaire() {
        return droit_universitaire;
    }

    public void setDroit_universitaire(Droit_universitaire droit_universitaire) {
        this.droit_universitaire = droit_universitaire;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

//    @Override
//    public String toString() {
//        return "Paiement{" + "id_paiement=" + id_paiement + ", date_paiement=" + date_paiement + ", droit_universitaire=" + droit_universitaire + ", etudiant=" + etudiant + '}';
//    }
//    
}