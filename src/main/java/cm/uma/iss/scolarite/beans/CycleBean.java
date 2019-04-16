/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.services.ICycleService;
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
import org.primefaces.context.RequestContext;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
public class CycleBean {

    @ManagedProperty(value = "#{ICycleService}")
    private ICycleService cycleService;
    private Cycle cycle = new Cycle();
    private Cycle cycleChoisi;
    private List<Cycle> cycleList;
    private String tailleCycle="0";
    //private String message="";

    //constructeurs
    public CycleBean() {
    }

    //getters and setters
    public Cycle getCycleChoisi() {
        return cycleChoisi;
    }

    public void setCycleChoisi(Cycle cycleChoisi) {
        this.cycleChoisi = cycleChoisi;
    }

    public ICycleService getCycleService() {
        return cycleService;
    }

    public void setCycleService(ICycleService cycleService) {
        this.cycleService = cycleService;
    }

    public Cycle getCycle() {
        return cycle;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    public List<Cycle> getCycleList() {
        try {
            cycleList = new ArrayList<Cycle>();
            cycleList.addAll(cycleService.findCycleAll());
            tailleCycle = cycleList.size() + "";
            return cycleList;
        } catch (Exception e) {
            return null;
        }
    }

    public void setCycleList(List<Cycle> cycleList) {
        this.cycleList = cycleList;
    }

    /**
     * returner le nombre de cycle existant dans la base de données
     *
     * @return
     */
    public String getTailleCycle() {
        try {
            cycleList = new ArrayList<Cycle>();
            cycleList.addAll(cycleService.findCycleAll());
            tailleCycle = cycleList.size() + "";
            return tailleCycle;
        } catch (Exception e) {
            return null;
        }

    }

    public void setTailleCycle(String tailleCycle) {
        this.tailleCycle = tailleCycle;
    }

    
    /**
     * methode permettant de retourner l'identifiant du dernier enregistrement
     *
     * @return
     */
    public Long maxEnreg() {
        Long i = 0L;
        List<Cycle> lesCycles = new ArrayList<Cycle>();
        try {
            lesCycles = cycleService.findCycleAll();
            for (Iterator<Cycle> it = lesCycles.iterator(); it.hasNext();) {
                Cycle cycle1 = it.next();
                if (cycle1.getId_cycle() > i) {
                    i = cycle1.getId_cycle();
                }
            }

        } catch (DataAccessException ex) {
            Logger.getLogger(CycleBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    
    /**
     * methode permettant d'enregistrer un cycle
     */
    public String enregistrer() {
        try {
            String nom_cycle=cycle.getNom_cycle();
            System.out.println(" nom du cycle choisi>>>>>>>>"+cycle.getNom_cycle());   
            Cycle CycleNonChoisi = cycleService.findCycleByNom(cycle.getNom_cycle());
            System.out.println(" Cycle correspondant au nom choisi>>>>>>>>" + CycleNonChoisi);
            if (CycleNonChoisi== null) {
                cycleService.registerCycle(cycle);
               // message="Enregistrement avec succès";
                FacesMessage msg = new FacesMessage(nom_cycle.toUpperCase()+" \nEnregistré avec succès ");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }else{
                //message="Cycle existant";
                 FacesMessage msg = new FacesMessage(nom_cycle.toUpperCase()+" \nExiste dèjà ");
                 FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(CycleBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "cycle";
    }

    /**
     * methode permettant de supprimer un enregistrement
     */
    public void validate() {
//   if(mode.equals("1")) {
//       System.out.println("OK");
//   } else {
        System.out.println("OK");
    RequestContext context = RequestContext.getCurrentInstance();
    context.execute("confirmButton.jq.click();");
   
}
    public String supprimer() {
        System.out.println("id_cycle " + cycle.getId_cycle());
        try {
            cycleService.deleteCycle(cycle.getId_cycle());
        } catch (DataAccessException ex) {
            Logger.getLogger(DocumentBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public void edition() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        try {
            if (cycleChoisi.getId_cycle() != 0L) {
                cycleService.updateCycle(cycleChoisi);
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Mise à jour avec succès "));
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
