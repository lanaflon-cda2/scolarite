/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.ArrondissementOrigine;
import cm.uma.iss.scolarite.entities.DepartementOrigine;
import cm.uma.iss.scolarite.services.IArrondissementOrigineService;
import cm.uma.iss.scolarite.services.IDepartementOrigineService;
import com.douwe.generic.dao.DataAccessException;
import java.lang.reflect.Array;
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
import javax.swing.JOptionPane;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
public class ArrondissementOrigineBean {

    @ManagedProperty(value = "#{IArrondissementOrigineService}")
    private IArrondissementOrigineService arrondissementOrigineService;
    @ManagedProperty(value = "#{IDepartementOrigineService}")
    private IDepartementOrigineService departementOrigineService;
    private ArrondissementOrigine arrondissementOrigine = new ArrondissementOrigine();
    private DepartementOrigine departementOrigine = new DepartementOrigine();
    private List<ArrondissementOrigine> arrondissementOrigineList;
    private ArrondissementOrigine arrondissementOrigineChoisi;

    public ArrondissementOrigineBean() {
    }

    /**
     * getters et setters
     *
     * @return
     */
    public IDepartementOrigineService getDepartementOrigineService() {
        return departementOrigineService;
    }

    public void setDepartementOrigineService(IDepartementOrigineService departementOrigineService) {
        this.departementOrigineService = departementOrigineService;
    }

    public IArrondissementOrigineService getArrondissementOrigineService() {
        return arrondissementOrigineService;
    }

    public void setArrondissementOrigineService(IArrondissementOrigineService arrondissementOrigineService) {
        this.arrondissementOrigineService = arrondissementOrigineService;
    }

    public ArrondissementOrigine getArrondissementOrigine() {
        return arrondissementOrigine;
    }

    public void setArrondissementOrigine(ArrondissementOrigine arrondissementOrigine) {
        this.arrondissementOrigine = arrondissementOrigine;
    }

    public DepartementOrigine getDepartementOrigine() {
        return departementOrigine;
    }

    public void setDepartementOrigine(DepartementOrigine departementOrigine) {
        this.departementOrigine = departementOrigine;
    }

    public List<ArrondissementOrigine> getArrondissementOrigineList() {
        try {
            arrondissementOrigineList = new ArrayList<ArrondissementOrigine>();
            arrondissementOrigineList.addAll(arrondissementOrigineService.findArrondissementOrigineAll());
            return arrondissementOrigineList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void setArrondissementOrigineList(List<ArrondissementOrigine> arrondissementOrigineList) {
        this.arrondissementOrigineList = arrondissementOrigineList;
    }

    public ArrondissementOrigine getArrondissementOrigineChoisi() {
        return arrondissementOrigineChoisi;
    }

    public void setArrondissementOrigineChoisi(ArrondissementOrigine arrondissementOrigineChoisi) {
        this.arrondissementOrigineChoisi = arrondissementOrigineChoisi;
    }
    public int compteur = 0;

    public void enregistrer() {
        String nom_arron = arrondissementOrigine.getNom_arrondissementOrigine();
        String nom_dpt = departementOrigine.getNom_departementOrigine();
        System.out.println(" departement " + nom_dpt + " arrondissement " + nom_arron);
        try {
            ArrondissementOrigine unArrondissementOrigine = arrondissementOrigineService.findArrondissementOrigineByNom(nom_arron);
            if (unArrondissementOrigine == null) {
                arrondissementOrigine.setNom_arrondissementOrigine(nom_arron.toUpperCase());
                arrondissementOrigine.setDepartementOrigine(departementOrigineService.findDepartementOrigineByNom(nom_dpt));
                arrondissementOrigineService.registerArrondissementOrigine(arrondissementOrigine);
                FacesMessage msg = new FacesMessage(nom_arron + " Enregistré avec succès ");
                FacesContext.getCurrentInstance().addMessage(null, msg);

            } else {
                FacesMessage msg = new FacesMessage(nom_arron+" Existe déjà ");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
            
        } catch (DataAccessException ex) {
            Logger.getLogger(ArrondissementOrigineBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
