/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.NiveauFiliere;
import cm.uma.iss.scolarite.services.INiveauFiliereService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
public class NiveauFiliereBean {
    
    @ManagedProperty(value="INiveauFiliereService")
    private INiveauFiliereService niveauFiliereService;
    private NiveauFiliere niveauFiliere= new NiveauFiliere();
    
    //constructeurs
    public NiveauFiliereBean() {
    }
    
    //getters and setters
    public INiveauFiliereService getNiveauFiliereService() {
        return niveauFiliereService;
    }

    public void setNiveauFiliereService(INiveauFiliereService niveauFiliereService) {
        this.niveauFiliereService = niveauFiliereService;
    }

    public NiveauFiliere getNiveauFiliere() {
        return niveauFiliere;
    }

    public void setNiveauFiliere(NiveauFiliere niveauFiliere) {
        this.niveauFiliere = niveauFiliere;
    }
    
    
    public void enregistrement(){
        try {
            niveauFiliereService.registerNiveauFiliere(niveauFiliere);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
