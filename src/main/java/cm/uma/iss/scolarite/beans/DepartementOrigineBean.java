/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.DepartementOrigine;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import cm.uma.iss.scolarite.services.IDepartementOrigineService;
import cm.uma.iss.scolarite.services.IRegionOrigineService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
public class DepartementOrigineBean {

    @ManagedProperty(value = "#{IDepartementOrigineService}")
    private IDepartementOrigineService departementOrigineService;
    @ManagedProperty(value = "#{IRegionOrigineService}")
    private IRegionOrigineService regionOrigineService;
    private DepartementOrigine departementOrigine = new DepartementOrigine();
    private DepartementOrigine departrmOrigineChoisi;
    private RegionOrigine regionOrigine = new RegionOrigine();
    private List<DepartementOrigine> departementOrigineList;

    //constructeurs
    public DepartementOrigineBean() {
    }

    //getters and setters
    public IRegionOrigineService getRegionOrigineService() {
        return regionOrigineService;
    }

    public void setRegionOrigineService(IRegionOrigineService regionOrigineService) {
        this.regionOrigineService = regionOrigineService;
    }

    public IDepartementOrigineService getDepartementOrigineService() {
        return departementOrigineService;
    }

    public void setDepartementOrigineService(IDepartementOrigineService departementOrigineService) {
        this.departementOrigineService = departementOrigineService;
    }

    public RegionOrigine getRegionOrigine() {
        return regionOrigine;
    }

    public void setRegionOrigine(RegionOrigine regionOrigine) {
        this.regionOrigine = regionOrigine;
    }

    public DepartementOrigine getDepartementOrigine() {
        return departementOrigine;
    }

    public void setDepartementOrigine(DepartementOrigine departementOrigine) {
        this.departementOrigine = departementOrigine;
    }

    public DepartementOrigine getDepartrmOrigineChoisi() {
        return departrmOrigineChoisi;
    }

    public void setDepartrmOrigineChoisi(DepartementOrigine departrmOrigineChoisi) {
        this.departrmOrigineChoisi = departrmOrigineChoisi;
    }

    public List<DepartementOrigine> getDepartementOrigineList() {
        try {
            departementOrigineList = new ArrayList<DepartementOrigine>();
            departementOrigineList.addAll(departementOrigineService.findDepartementOrigineAll());
            return departementOrigineList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void setDepartementOrigineList(List<DepartementOrigine> departementOrigineList) {
        this.departementOrigineList = departementOrigineList;
    }

    /**
     * enregistrement
     */
    public void enregistrer() {
        try {
            String nom_region = regionOrigine.getNom_regionOrigine();
            String nom_departement = departementOrigine.getNom_departementOrigine();
            System.out.println(" region " + nom_region + " departement " + nom_departement);
            if (nom_region.equalsIgnoreCase("ADAMAOUA")) {
                FacesMessage msg = new FacesMessage(" En cours d'implementation");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else if (nom_region.equalsIgnoreCase("CENTRE")) {
                FacesMessage msg = new FacesMessage(" En cours d'implementation");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else if (nom_region.equalsIgnoreCase("EST")) {
                FacesMessage msg = new FacesMessage(" En cours d'implementation");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else if (nom_region.equalsIgnoreCase("OUEST")) {
                if (nom_departement.equalsIgnoreCase("NOUN") || nom_departement.equalsIgnoreCase("MIFI")
                        || nom_departement.equalsIgnoreCase("BOUDA") || nom_departement.equalsIgnoreCase("BANDJOUN")
                        || nom_departement.equalsIgnoreCase("HAUT-KAM") || nom_departement.equalsIgnoreCase("NDE")
                        || nom_departement.equalsIgnoreCase("MENOUA") || nom_departement.equalsIgnoreCase("HAUT-PLATEAU")) {
                    DepartementOrigine unDepartementOrigine = departementOrigineService.findDepartementOrigineByNom(nom_departement);
                    if (unDepartementOrigine == null) {
                        departementOrigine.setNom_departementOrigine(nom_departement.toUpperCase());
                        departementOrigine.setRegionOrigine(regionOrigineService.findRegionOrigineByNom(nom_region));
                        departementOrigineService.registerDepartementOrigine(departementOrigine);
                        FacesMessage msg = new FacesMessage(nom_departement.toUpperCase() + " \nEnregistré avec succès");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    } else {
                        FacesMessage msg = new FacesMessage(nom_departement.toUpperCase() + " \nExiste déjà");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }

                } else {
                    FacesMessage msg = new FacesMessage(nom_departement.toUpperCase() + "\n n'est pas dans \n" + nom_region.toUpperCase());
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else if (nom_region.equalsIgnoreCase("NORD")) {
                FacesMessage msg = new FacesMessage(" En cours d'implementation");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else if (nom_region.equalsIgnoreCase("EXTREME-NORD")) {
                FacesMessage msg = new FacesMessage(" En cours d'implementation");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else if (nom_region.equalsIgnoreCase("NORD-OUEST")) {
                FacesMessage msg = new FacesMessage(" En cours d'implementation");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else if (nom_region.equalsIgnoreCase("SUD")) {
                FacesMessage msg = new FacesMessage(" En cours d'implementation");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else if (nom_region.equalsIgnoreCase("SUD-OUEST")) {
                FacesMessage msg = new FacesMessage(" En cours d'implementation");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else if (nom_region.equalsIgnoreCase("LITTORAL")) {
                FacesMessage msg = new FacesMessage(" En cours d'implementation");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
               DepartementOrigine unDepartementOrigine = departementOrigineService.findDepartementOrigineByNom(nom_departement);
                    if (unDepartementOrigine == null) {
                        departementOrigine.setNom_departementOrigine(nom_departement.toUpperCase());
                        departementOrigine.setRegionOrigine(regionOrigineService.findRegionOrigineByNom(nom_region));
                        departementOrigineService.registerDepartementOrigine(departementOrigine);
                        FacesMessage msg = new FacesMessage(nom_departement.toUpperCase() + " ENREGISTRÉ AVEC SUCCÈS");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    } else {
                        FacesMessage msg = new FacesMessage(nom_departement.toUpperCase() + " EXISTE DÉJÀ");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }
            }


//            List<DepartementOrigine> dptOrigines = new ArrayList<DepartementOrigine>();
//            dptOrigines = departementOrigineService.findDepartementOrigineAll();
//            if (regionOrigine.getId_regionOrigne() != 0) {
//                for (Iterator<DepartementOrigine> it = dptOrigines.iterator(); it.hasNext();) {
//                    DepartementOrigine departementOrigine1 = it.next();
//                    if (departementOrigine1.getNom_departementOrigine().equals(departementOrigine.getNom_departementOrigine())) {
//                        compteur++;
//                    }
//
//                }
//                if (compteur != 0) {
//                    FacesMessage msg = new FacesMessage(" departement d'origine existant");
//                    FacesContext.getCurrentInstance().addMessage(null, msg);
//                } else {
//                    departementOrigine.setRegionOrigine(regionOrigine);
//                    departementOrigineService.registerDepartementOrigine(departementOrigine);
//                    FacesMessage msg = new FacesMessage(" Enregistrement avec succès ");
//                    FacesContext.getCurrentInstance().addMessage(null, msg);
//                }
//
//            }else{
//                FacesMessage msg = new FacesMessage(" Selectionner une region ");
//                    FacesContext.getCurrentInstance().addMessage(null, msg);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
