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
@Entity(name = "inscription")
public class Inscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_inscription;
    @Column(name = "date_inscription")
    // @Temporal(javax.persistence.TemporalType.DATE)
    private String date_inscription;
    //annotation many-to-one
    @ManyToOne
    @JoinColumn(name = "id_etudiant")
    private Etudiant etudiant;
    @ManyToOne
    @JoinColumn(name = "id_filiere")
    private Filiere filiere;
    @ManyToOne
    @JoinColumn(name = "id_option")
    private Option1 option1;
    @ManyToOne
    @JoinColumn(name = "id_niveau")
    private Niveau niveau;
    @ManyToOne
    @JoinColumn(name = "id_anneeAccademique")
    private AnneeAccademique anneeAccademique;
    @ManyToOne
    @JoinColumn(name = "id_cycle")
    private Cycle cycle;
    @ManyToOne
    @JoinColumn(name = "id_promotion")
    private Promotion promotion;

    //constructeurs

    public Inscription() {
    }

    /**
     * getters et setters
     */
    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Long getId_inscription() {
        return id_inscription;
    }

    public void setId_inscription(Long id_inscription) {
        this.id_inscription = id_inscription;
    }

    public String getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(String date_inscription) {
        this.date_inscription = date_inscription;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Option1 getOption1() {
        return option1;
    }

    public void setOption1(Option1 option1) {
        this.option1 = option1;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public void setAnneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
    }

    public Cycle getCycle() {
        return cycle;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    @Override
    public String toString() {
        return "Inscription{" + "id_inscription=" + id_inscription + ", date_inscription=" + date_inscription + ", etudiant=" + etudiant + ", filiere=" + filiere + ", option1=" + option1 + ", niveau=" + niveau + ", annee_accademique=" + anneeAccademique + ", cycle=" + cycle + ", promotion=" + promotion + '}';
    }
}
