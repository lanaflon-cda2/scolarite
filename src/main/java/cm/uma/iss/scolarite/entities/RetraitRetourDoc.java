/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author ngnawen
 */
@Entity(name = "retraitRetourDoc")
public class RetraitRetourDoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "etatPreinscription")
    private boolean etatPreinscription;
    @Column(name = "etatInscription")
    private boolean etatInscription;
    @Column(name="dateRetrait")
    //@Temporal(javax.persistence.TemporalType.DATE)
    private String dateRetrait;
    @Column(name="dateRetour")
    //@Temporal(javax.persistence.TemporalType.DATE)
    private String dateRetour;
    @ManyToOne
    @JoinColumn(name="etudiantId")
    private Etudiant etudiant;
    @ManyToOne
    @JoinColumn(name="documentId")
    private Documents documents;

    public RetraitRetourDoc() {
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuements(Documents documents) {
        this.documents = documents;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEtatPreinscription() {
        return etatPreinscription;
    }

    public void setEtatPreinscription(boolean etatPreinscription) {
        this.etatPreinscription = etatPreinscription;
    }

    public boolean isEtatInscription() {
        return etatInscription;
    }

    public void setEtatInscription(boolean etatInscription) {
        this.etatInscription = etatInscription;
    }

    public String getDateRetrait() {
        return dateRetrait;
    }

    public void setDateRetrait(String dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }

    @Override
    public String toString() {
        return "RetraitRetourDoc{" + "id=" + id + ", etatPreinscription=" + etatPreinscription + ", etatInscription=" + etatInscription + ", dateRetrait=" + dateRetrait + ", dateRetour=" + dateRetour + ", etudiant=" + etudiant + ", documents=" + documents + '}';
    }

    

}
