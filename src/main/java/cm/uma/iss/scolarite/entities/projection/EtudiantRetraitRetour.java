/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.entities.projection;

import java.util.Date;

/**
 *
 * @author ngnawen
 */
public class EtudiantRetraitRetour {
    
    private String matricule;
    private String nom_etudiant;
    private Date dateRetrait;
    private Date dateRetour;
    private String type_document;

    public EtudiantRetraitRetour() {
    }

    public EtudiantRetraitRetour(String matricule, String nom_etudiant, Date dateRetrait, Date dateRetour, String type_document) {
        this.matricule = matricule;
        this.nom_etudiant = nom_etudiant;
        this.dateRetrait = dateRetrait;
        this.dateRetour = dateRetour;
        this.type_document = type_document;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom_etudiant() {
        return nom_etudiant;
    }

    public void setNom_etudiant(String nom_etudiant) {
        this.nom_etudiant = nom_etudiant;
    }

    public Date getDateRetrait() {
        return dateRetrait;
    }

    public void setDateRetrait(Date dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public String getType_document() {
        return type_document;
    }

    public void setType_document(String type_document) {
        this.type_document = type_document;
    }
    
    
    
    
}
