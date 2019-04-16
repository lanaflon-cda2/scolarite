/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.Paiement;
import cm.uma.iss.scolarite.services.IPaiementService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
public class PaiementBean {
    
    @ManagedProperty(value="IPaiementService")
    private IPaiementService paiementService;
    private Paiement paiement=new Paiement();
    
    //constructeurs
    public PaiementBean() {
    }

    //getters and setters
    public IPaiementService getPaiementService() {
        return paiementService;
    }

    public void setPaiementService(IPaiementService paiementService) {
        this.paiementService = paiementService;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }
    
    public void enregistement()
    {
        try {
            paiementService.registerPaiement(paiement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
