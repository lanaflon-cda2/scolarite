/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import cm.uma.iss.scolarite.services.IPaysOrigineService;
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
public class RegionOrigineBean {

    @ManagedProperty(value = "#{IRegionOrigineService}")
    private IRegionOrigineService regionOrigineService;
    @ManagedProperty(value = "#{IPaysOrigineService}")
    private IPaysOrigineService paysOrigineService;
    private RegionOrigine regionOrigine = new RegionOrigine();
    private RegionOrigine regionOrigineChoisi;
    private PaysOrigine paysOrigine = new PaysOrigine();
    private List<RegionOrigine> regionOrigineList;
    private String tailleRegion = "0";

    //constructeurs
    public RegionOrigineBean() {
    }

    //getters and setters 
    public IPaysOrigineService getPaysOrigineService() {
        return paysOrigineService;
    }

    public void setPaysOrigineService(IPaysOrigineService paysOrigineService) {
        this.paysOrigineService = paysOrigineService;
    }

    public IRegionOrigineService getRegionOrigineService() {
        return regionOrigineService;
    }

    public void setRegionOrigineService(IRegionOrigineService regionOrigineService) {
        this.regionOrigineService = regionOrigineService;
    }

    public RegionOrigine getRegionOrigine() {
        return regionOrigine;
    }

    public void setRegionOrigine(RegionOrigine regionOrigine) {
        this.regionOrigine = regionOrigine;
    }

    public RegionOrigine getRegionOrigineChoisi() {
        return regionOrigineChoisi;
    }

    public void setRegionOrigineChoisi(RegionOrigine regionOrigineChoisi) {
        this.regionOrigineChoisi = regionOrigineChoisi;
    }

    public PaysOrigine getPaysOrigine() {
        return paysOrigine;
    }

    public void setPaysOrigine(PaysOrigine paysOrigine) {
        this.paysOrigine = paysOrigine;
    }

    public List<RegionOrigine> getRegionOrigineList() {
        try {
            regionOrigineList = new ArrayList<RegionOrigine>();
            regionOrigineList.addAll(regionOrigineService.findRegionTout());
            return regionOrigineList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void setRegionOrigineList(List<RegionOrigine> regionOrigineList) {
        this.regionOrigineList = regionOrigineList;
    }

    public String getTailleRegion() {
        try {
            regionOrigineList = new ArrayList<RegionOrigine>();
            regionOrigineList.addAll(regionOrigineService.findRegionOrigineAll());
            tailleRegion = regionOrigineList.size() + "";
            return tailleRegion;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setTailleRegion(String tailleRegion) {
        this.tailleRegion = tailleRegion;
    }

    /**
     * enregistrement
     */
    public void enregistrer() {
        try {
            String nom_region = regionOrigine.getNom_regionOrigine().toUpperCase();
            String nom_pays = paysOrigine.getNom_pays();
            System.out.println(" region " + nom_region + " pays " + nom_pays);
            if (nom_pays.equalsIgnoreCase("CAMEROUN")) {
                if (nom_region.equalsIgnoreCase("ADAMAOUA") || nom_region.equalsIgnoreCase("CENTRE") || nom_region.equalsIgnoreCase("LITTORAL")
                        || nom_region.equalsIgnoreCase("EST") || nom_region.equalsIgnoreCase("EXTREME-NORD") || nom_region.equalsIgnoreCase("NORD")
                        || nom_region.equalsIgnoreCase("NORD-OUEST") || nom_region.equalsIgnoreCase("OUEST") || nom_region.equalsIgnoreCase("SUD")
                        || nom_region.equalsIgnoreCase("SUD-OUEST")) {
                    RegionOrigine unereOrigine = regionOrigineService.findRegionOrigineByNom(nom_region);
                    if (unereOrigine == null) {
                        regionOrigine.setNom_regionOrigine(nom_region.toUpperCase());
                        regionOrigine.setPaysOrigine(paysOrigineService.getPaysByNom(nom_pays));
                        regionOrigineService.registerRegionOrigine(regionOrigine);
                        FacesMessage msg = new FacesMessage(nom_region + " \nEnregistrée avec succès ");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    } else {
                        FacesMessage msg = new FacesMessage(nom_region +" \nExiste déjaà ");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }
                } else {
                    FacesMessage msg = new FacesMessage(" voici les régions du cameroun:\n ADAMAOUA,CENTRE,LITTORAL,EST\n EXTREME-NORD"
                            + "NORD,NORD-OUEST\nOUEST,SUD,SUD-OUEST");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else {
                RegionOrigine unereOrigine = regionOrigineService.findRegionOrigineByNom(nom_region);
                if (unereOrigine == null) {
                     regionOrigine.setNom_regionOrigine(nom_region.toUpperCase());
                    regionOrigine.setPaysOrigine(paysOrigineService.getPaysByNom(nom_pays));
                    regionOrigineService.registerRegionOrigine(regionOrigine);
                    FacesMessage msg = new FacesMessage(" Enregistrement avec succès ");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    FacesMessage msg = new FacesMessage(" Region existante ");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            }

        } catch (Exception e) {
        }
    }
}
