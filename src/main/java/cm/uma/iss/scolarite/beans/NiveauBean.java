/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.Niveau;
import cm.uma.iss.scolarite.services.ICycleService;
import cm.uma.iss.scolarite.services.INiveauService;
import com.douwe.generic.dao.DataAccessException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
public class NiveauBean {

    @ManagedProperty(value = "#{INiveauService}")
    private INiveauService niveauService;
    @ManagedProperty(value = "#{ICycleService}")
    private ICycleService cycleService;
    private Niveau niveau = new Niveau();
    private Cycle cycle = new Cycle();
    private List<Niveau> niveauList;
    private Niveau niveauChoisi;
    private String tailleNiveau = "0";
    //constructeurs

    public NiveauBean() {
    }

    public Niveau getNiveauChoisi() {
        return niveauChoisi;
    }

    public void setNiveauChoisi(Niveau niveauChoisi) {
        this.niveauChoisi = niveauChoisi;
    }

    public INiveauService getNiveauService() {
        return niveauService;
    }

    public void setNiveauService(INiveauService niveauService) {
        this.niveauService = niveauService;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Cycle getCycle() {
        return cycle;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    public List<Niveau> getNiveauList() {
        try {
            niveauList = new ArrayList<Niveau>();
            niveauList = niveauService.findToutNiveau();
            return niveauList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getTailleNiveau() {
        try {
            niveauList = new ArrayList<Niveau>();
            niveauList = niveauService.findNiveauAll();
            tailleNiveau = niveauList.size() + "";
            return tailleNiveau;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setTailleNiveau(String tailleNiveau) {
        this.tailleNiveau = tailleNiveau;
    }

    public void setNiveauList(List<Niveau> niveauList) {
        this.niveauList = niveauList;
    }

    public ICycleService getCycleService() {
        return cycleService;
    }

    public void setCycleService(ICycleService cycleService) {
        this.cycleService = cycleService;
    }
    

    public void enregistrer() {
        String nom_cycle = cycle.getNom_cycle();
        String nom_niveau = niveau.getNom_niveau();
        System.out.println("nom cycle " + nom_cycle + " nom niveau " + nom_niveau);
        if (nom_cycle.equals("LICENCE")) {
            if (nom_niveau.equals("LICENCE I") || nom_niveau.equals("LICENCE II") || nom_niveau.equals("LICENCE III")) {
                try {
                    Niveau unNiveau = niveauService.findNiveauByNom(nom_niveau);
                    if (unNiveau == null) {
                        niveau.setCycle(cycleService.findCycleByNom(nom_cycle));//association du niveau au cycle
                        niveauService.registerNiveau(niveau);
                        FacesMessage msg = new FacesMessage(nom_niveau+" Enregistré avec succès");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    } else {
                        FacesMessage msg = new FacesMessage(nom_niveau+" \nExiste déjà");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }

                } catch (DataAccessException ex) {
                    Logger.getLogger(NiveauBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                FacesMessage msg = new FacesMessage(nom_niveau+" et "+nom_niveau+ "incoherents");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        }
        if (nom_cycle.equals("MASTER")) {
            if (nom_niveau.equals("MASTER I") || nom_niveau.equals("MASTER II")) {
                try {
                    Niveau unNiveau = niveauService.findNiveauByNom(nom_niveau);
                    if (unNiveau == null) {
                        niveau.setCycle(cycleService.findCycleByNom(nom_cycle));//association du niveau au cycle
                        niveauService.registerNiveau(niveau);
                        FacesMessage msg = new FacesMessage(nom_niveau+" \n Enregistré avec succès");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    } else {
                        FacesMessage msg = new FacesMessage(nom_niveau+" \n Existe déjà");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }
                } catch (DataAccessException ex) {
                    Logger.getLogger(NiveauBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                FacesMessage msg = new FacesMessage(nom_niveau+" et "+nom_niveau+ "incoherents");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }

    public void supprimer() {
         System.out.println("id_niveau " + niveau.getId_niveau());
        try {
                niveauService.deleteNiveau(niveau.getId_niveau());
                FacesMessage msg = new FacesMessage(" Suppression avec succès ");
                FacesContext.getCurrentInstance().addMessage(null, msg);

        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(" Suppression impossible ");
                FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
//    public String prepareCreate(ActionEvent event) {
//        initializeEmbeddableKey();
//        Niveau newItem;
//        try {
//           // newItem = itemClass.newInstance();
//            this.niveauChoisi = newItem;
//            initializeEmbeddableKey();
//            return newItem;
//        } catch (InstantiationException ex) {
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    public boolean isValidationFailed() {
//        //  return JsfUtil.isValidationFailed();
//        return true;
//    }
}
