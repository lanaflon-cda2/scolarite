/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.Droit_universitaire;
import cm.uma.iss.scolarite.services.IDroit_universitaireService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
public class Droit_universitaireBean {
    
    @ManagedProperty(value="IDroit_universitaireService")
    private IDroit_universitaireService droit_universitaaireService;
    private Droit_universitaire droit_universitaire=new Droit_universitaire();
    
    //constructeurs
    public Droit_universitaireBean() {
    }
    
    //getters and setters
    public IDroit_universitaireService getDroit_universitaaireService() {
        return droit_universitaaireService;
    }

    public void setDroit_universitaaireService(IDroit_universitaireService droit_universitaaireService) {
        this.droit_universitaaireService = droit_universitaaireService;
    }

    public Droit_universitaire getDroit_universitaire() {
        return droit_universitaire;
    }

    public void setDroit_universitaire(Droit_universitaire droit_universitaire) {
        this.droit_universitaire = droit_universitaire;
    }
    
    
    public void enregistrement(){
        try {
            droit_universitaaireService.registerDroit_universitaire(droit_universitaire);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}