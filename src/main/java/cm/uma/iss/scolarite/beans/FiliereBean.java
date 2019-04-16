/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.Filiere;
import cm.uma.iss.scolarite.services.IFiliereService;
import com.douwe.generic.dao.DataAccessException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FiliereBean {

    @ManagedProperty(value = "#{IFiliereService}")
    private IFiliereService filiereService;
    private Filiere filiere = new Filiere();
    private List<Filiere> filiereList;
    private Filiere filiereChoisi;
    private String tailleFiliere = "0";

    //constructeurs
    public FiliereBean() {
    }

    //getters and setters
    public Filiere getFiliereChoisi() {
        return filiereChoisi;
    }

    public void setFiliereChoisi(Filiere filiereChoisi) {
        this.filiereChoisi = filiereChoisi;
    }

    public IFiliereService getFiliereService() {
        return filiereService;
    }

    public void setFiliereService(IFiliereService filiereService) {
        this.filiereService = filiereService;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public List<Filiere> getFiliereList() {
        try {
            filiereList = new ArrayList<Filiere>();
            filiereList.addAll(filiereService.findAllFiliere());
            return filiereList;
        } catch (Exception e) {
            return null;
        }
    }

    public void setFiliereList(List<Filiere> filiereList) {
        this.filiereList = filiereList;
    }

    /**
     * nombre de departement dans la base de données
     *
     * @return
     */
    public String getTailleFiliere() {
        try {
            filiereList = new ArrayList<Filiere>();
            filiereList.addAll(filiereService.findFiliereAll());
            tailleFiliere = filiereList.size() + "";
            return tailleFiliere;
        } catch (Exception e) {
            return null;
        }

    }

    public void setTailleFiliere(String tailleFiliere) {
        this.tailleFiliere = tailleFiliere;
    }

    /**
     * methode d'enregistrement d'une filiere
     */
    public void enregistrer() {
        //String nom_dpt = dpt.getNom_departement().toUpperCase().trim();
        String nom_filiere = filiere.getNom_filiere().toUpperCase();
        //String sigle_filiere = filiere.getSigle_filiere().toUpperCase();
        System.out.println("filiere " + nom_filiere);
        if (nom_filiere.equalsIgnoreCase("INFORMATIQUE ET TELECOMMUNICATIONS")) {
            try {
                Filiere uneFiliere = filiereService.findFiliereByNom(nom_filiere);
                if (uneFiliere == null) {
                    filiere.setNom_filiere(nom_filiere.toUpperCase());
                    //filiere.setSigle_filiere(sigle_filiere.toUpperCase());
                    filiereService.registerFiliere(filiere);
                    FacesMessage msg = new FacesMessage(" Enregistrée avec succès");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    FacesMessage msg = new FacesMessage(nom_filiere.toUpperCase() + " ÉXISTE DÉJÀ");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }

            } catch (DataAccessException ex) {
                Logger.getLogger(FiliereBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void supprimer() {
        System.out.println("id_filiere " + filiere.getId_filiere());
        try {
            filiereService.deleteFiliere(filiere.getId_filiere());
            FacesMessage msg = new FacesMessage(" Suppression avec succès ");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
