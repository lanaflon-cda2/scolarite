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
import javax.persistence.OneToMany;

/**
 *
 * @author ngnawen
 */
@Entity(name = "anneeAccademique")
public class AnneeAccademique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_anneeAccademique;
    @Column(name = "debutAnnee")
    private String debutAnnee;
    @Column(name = "finAnnee")
    private String finAnnee;
    @Column(name = "annee")
    private String annee;
//    @Column(name = "finAnnee", nullable = false)
//    private String finAnnee;
    @OneToMany(mappedBy = "anneeAccademique")
    private List<Inscription> inscriptionList;
    
    //constructeurs
    public AnneeAccademique() {
    }

    //getters and setters
    
    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }
    
    public Long getId_anneeAccademique() {
        return id_anneeAccademique;
    }

    public void setId_anneeAccademique(Long id_anneeAccademique) {
        this.id_anneeAccademique = id_anneeAccademique;
    }

    public String getDebutAnnee() {
        return debutAnnee;
    }

    public void setDebutAnnee(String debutAnnee) {
        this.debutAnnee = debutAnnee;
    }

    public String getFinAnnee() {
        return finAnnee;
    }

    public void setFinAnnee(String finAnnee) {
        this.finAnnee = finAnnee;
    }
   
    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    @Override
    public String toString() {
        return "AnneeAccademique{" + "id_anneeAccademique=" + id_anneeAccademique + ", debutAnnee=" + debutAnnee + ", finAnnee=" + finAnnee + ", annee=" + annee + '}';
    }

    

  
    
    
    
}
