/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.services.IPaysOrigineService;
import com.douwe.generic.dao.DataAccessException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
@ViewScoped
public class PaysOrigineBean {

    /**
     * Creates a new instance of PaysOrigineBean
     */
    @ManagedProperty(value = "#{IPaysOrigineService}")
    private IPaysOrigineService paysOrigineService;
    private PaysOrigine pays = new PaysOrigine();
    private PaysOrigine paysChoisi;
    private List<PaysOrigine> paysList;
    private String taillePays = "0";

    //Constructeurs
    public PaysOrigineBean() {
    }

    //getters and setters
    public IPaysOrigineService getPaysOrigineService() {
        return paysOrigineService;
    }

    public void setPaysOrigineService(IPaysOrigineService paysOrigineService) {
        this.paysOrigineService = paysOrigineService;
    }

    public PaysOrigine getPays() {
        return pays;
    }

    public void setPays(PaysOrigine pays) {
        this.pays = pays;
    }

    public PaysOrigine getPaysChoisi() {
        return paysChoisi;
    }

    public void setPaysChoisi(PaysOrigine paysChoisi) {
        this.paysChoisi = paysChoisi;
    }

    public List<PaysOrigine> getPaysList() {
        try {
            paysList = new ArrayList<PaysOrigine>();
            paysList.addAll(paysOrigineService.findPaysAll());
            return paysList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setPaysList(List<PaysOrigine> paysList) {
        this.paysList = paysList;
    }

    public String getTaillePays() {
        try {
            paysList = new ArrayList<PaysOrigine>();
            paysList.addAll(paysOrigineService.findPaysAll());
            taillePays = paysList.size() + "";
            return taillePays;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setTaillePays(String taillePays) {
        this.taillePays = taillePays;
    }

    /**
     * methode d'enregistrement
     */
    public void enregistrer() {
        try {
            String nom_pays = pays.getNom_pays();
            System.out.println("nom du pays " + nom_pays);
            PaysOrigine unpayOrigine = paysOrigineService.getPaysByNom(nom_pays);
            if (unpayOrigine == null) {
                pays.setNom_pays(nom_pays.toUpperCase());
                paysOrigineService.registerPays(pays);
                        FacesMessage msg = new FacesMessage(nom_pays +" \n Enregistré avec succès");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                FacesMessage msg = new FacesMessage(nom_pays + " \n Existe déjà");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void edition() {
        try {
            paysOrigineService.updatePays(paysChoisi);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Update called", "updated by user"));
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void supprimer() {
        try {
            if (paysChoisi.getId_pays() != null) {
                paysOrigineService.deletePays(paysChoisi.getId_pays());
                FacesMessage msg = new FacesMessage(" Suppression avec succès ");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
