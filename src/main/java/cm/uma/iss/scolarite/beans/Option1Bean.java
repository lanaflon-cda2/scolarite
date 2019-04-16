/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.Filiere;
import cm.uma.iss.scolarite.entities.Option1;
import cm.uma.iss.scolarite.services.IFiliereService;
import cm.uma.iss.scolarite.services.IOption1Service;
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

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
public class Option1Bean {

    @ManagedProperty(value = "#{IOption1Service}")
    private IOption1Service option1Service;
    @ManagedProperty(value = "#{IFiliereService}")
    private IFiliereService filiereService;
    private Option1 option1 = new Option1();
    private Option1 option1Choisi;
    private Filiere filiere = new Filiere();
    private List<Option1> option1List;
    private String tailleOption = "0";

    //constructeurs
    public Option1Bean() {
    }

    //getters and setters
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

    public Option1 getOption1Choisi() {
        return option1Choisi;
    }

    public void setOption1Choisi(Option1 option1Choisi) {
        this.option1Choisi = option1Choisi;
    }

    public IOption1Service getOption1Service() {
        return option1Service;
    }

    public void setOption1Service(IOption1Service option1Service) {
        this.option1Service = option1Service;
    }

    public Option1 getOption1() {
        return option1;
    }

    public void setOption1(Option1 option1) {
        this.option1 = option1;
    }

    public List<Option1> getOption1List() {
        try {
            option1List = new ArrayList<Option1>();
            option1List.addAll(option1Service.findOption1All());
            return option1List;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getTailleOption() {
        try {
            option1List = new ArrayList<Option1>();
            option1List.addAll(option1Service.findOption1All());
            tailleOption = option1List.size() + "";
            return tailleOption;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setTailleOption(String tailleOption) {
        this.tailleOption = tailleOption;
    }

    public void setOption1List(List<Option1> option1List) {
        this.option1List = option1List;
    }

    /**
     * enregistrer option
     */
    public void enregistrer() {
        String nom_filiere = filiere.getNom_filiere();
        String nom_option = option1.getNom_option1();
        System.out.println(" nom de l'option " + nom_option + " filiere correspondante " + nom_filiere);
        try {
            if (nom_filiere.equalsIgnoreCase("INFORMATIQUE ET TELECOMMUNICATIONS")) {
                if (nom_option.equalsIgnoreCase("CRYPTOGRAPHIE") || nom_option.equalsIgnoreCase("TELECOMMUNICATIONS") || nom_option.equalsIgnoreCase("GENIE LOGICIEL") || nom_option.equalsIgnoreCase("RESEAUX")) {
                    Option1 uneOption = option1Service.findOptionbyNom(nom_option);
                    if (uneOption == null) {
                        option1.setFiliere(filiereService.findFiliereByNom(nom_filiere));
                        option1.setNom_option1(nom_option.toUpperCase());
                        option1Service.registerOption1(option1);
                        FacesMessage msg = new FacesMessage(nom_option +" \n Enregistrée avec succès");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    } else {
                        FacesMessage msg = new FacesMessage(nom_option +" \n Existe déjà");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }

                } else {
                    FacesMessage msg = new FacesMessage(nom_filiere+ " et"+nom_option+"  incoherantes");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }

            } else if (nom_filiere.equalsIgnoreCase("AGRICULTURE,ELEVAGE ET PRODUITS DERIVES")) {
                if (nom_option.equalsIgnoreCase("PRODUCTION VEGETALE") || nom_option.equalsIgnoreCase("PRODUCTION ANNIMALE") || nom_option.equalsIgnoreCase("AGRO-ALIMENTAIRE") || nom_option.equalsIgnoreCase("ECONOMIE ET MANAGEMENT")) {
                    Option1 uneOption = option1Service.findOptionbyNom(nom_option);
                    if (uneOption == null) {
                        option1.setFiliere(filiereService.findFiliereByNom(nom_filiere));
                        option1.setNom_option1(nom_option.toUpperCase());
                        option1Service.registerOption1(option1);
                        FacesMessage msg = new FacesMessage(nom_option +" \nEnregistrée avec succès");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    } else {
                        FacesMessage msg = new FacesMessage(nom_option +" \nExiste déjà");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }

                } else {
                    FacesMessage msg = new FacesMessage(nom_filiere+ " et"+nom_option+"  incoherantes");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else if (nom_filiere.equalsIgnoreCase("BEAUX ARTS ET SCIENCES DU PATRIMOINE")) {
                if (nom_option.equalsIgnoreCase("BEAUX ARTS") || nom_option.equalsIgnoreCase("SCIENCES DU PATRIMOINE")) {
                    Option1 uneOption = option1Service.findOptionbyNom(nom_option);
                    if (uneOption == null) {
                        option1.setFiliere(filiereService.findFiliereByNom(nom_filiere));
                        option1.setNom_option1(nom_option.toUpperCase());
                        option1Service.registerOption1(option1);
                        FacesMessage msg = new FacesMessage(nom_option +" \nEnregistrée avec succès");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    } else {
                        FacesMessage msg = new FacesMessage(nom_option +" \nExiste déjà");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }

                } else {
                    FacesMessage msg = new FacesMessage(nom_filiere+ " et"+nom_option+"  incoherantes");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else if (nom_filiere.equalsIgnoreCase("CLIMATOLOGIE, HYDRAULOGIE ET PEDOLOGIE")) {
                if (nom_option.equalsIgnoreCase("/")) {
                    Option1 uneOption = option1Service.findOptionbyNom(nom_option);
                    if (uneOption == null) {
                        option1.setFiliere(filiereService.findFiliereByNom(nom_filiere));
                        option1.setNom_option1(nom_option.toUpperCase());
                        option1Service.registerOption1(option1);
                        FacesMessage msg = new FacesMessage(nom_option +" \nEnregistrée avec succès");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    } else {
                        FacesMessage msg = new FacesMessage(nom_option +" \nExiste déjà");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }

                } else {
                    FacesMessage msg = new FacesMessage(nom_filiere+ " et"+nom_option+"  incoherantes");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else if (nom_filiere.equalsIgnoreCase("ENERGIES RENOUVELABLES")) {
                if (nom_option.equalsIgnoreCase("/")) {
                    Option1 uneOption = option1Service.findOptionbyNom(nom_option);
                    if (uneOption == null) {
                        option1.setFiliere(filiereService.findFiliereByNom(nom_filiere));
                        option1.setNom_option1(nom_option.toUpperCase());
                        option1Service.registerOption1(option1);
                        FacesMessage msg = new FacesMessage(nom_option +" \nEnregistrée avec succès");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    } else {
                        FacesMessage msg = new FacesMessage(nom_option +" \nExiste déjà");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }

                } else {
                   FacesMessage msg = new FacesMessage(nom_filiere+ " et"+nom_option+"  incoherantes");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else if (nom_filiere.equalsIgnoreCase("GENIE TEXTILE ET CUIR")) {
                if (nom_option.equalsIgnoreCase("/")) {
                    Option1 uneOption = option1Service.findOptionbyNom(nom_option);
                    if (uneOption == null) {
                        option1.setFiliere(filiereService.findFiliereByNom(nom_filiere));
                        option1.setNom_option1(nom_option.toUpperCase());
                        option1Service.registerOption1(option1);
                        FacesMessage msg = new FacesMessage(nom_option +" \nEnregistrée avec succès");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    } else {
                        FacesMessage msg = new FacesMessage(nom_option +" \nExiste déjà");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }

                } else {
                   FacesMessage msg = new FacesMessage(nom_filiere+ " et"+nom_option+"  incoherantes");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else if (nom_filiere.equalsIgnoreCase("HYDRAULIQUE ET MAITRISE DES EAUX")) {
                if (nom_option.equalsIgnoreCase("GENIE SANITAIRE") || nom_option.equalsIgnoreCase("HYDROLIQUE")) {
                    Option1 uneOption = option1Service.findOptionbyNom(nom_option);
                    if (uneOption == null) {
                        option1.setFiliere(filiereService.findFiliereByNom(nom_filiere));
                        option1.setNom_option1(nom_option.toUpperCase());
                        option1Service.registerOption1(option1);
                        FacesMessage msg = new FacesMessage(nom_option +" \nEnregistrée avec succès");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    } else {
                        FacesMessage msg = new FacesMessage(nom_option +" \nExiste déjà");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }

                } else {
                    FacesMessage msg = new FacesMessage(nom_filiere+ " et"+nom_option+"  incoherantes");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else if (nom_filiere.equalsIgnoreCase("SCIENCES ENVIRONNEMENTALES")) {
                if (nom_option.equalsIgnoreCase("DECHETS ET POLLUTION") || nom_option.equalsIgnoreCase("DESERTIFICATION ET RESSOURCES NATURELLES")) {
                    Option1 uneOption = option1Service.findOptionbyNom(nom_option);
                    if (uneOption == null) {
                        option1.setFiliere(filiereService.findFiliereByNom(nom_filiere));
                        option1.setNom_option1(nom_option.toUpperCase());
                        option1Service.registerOption1(option1);
                        FacesMessage msg = new FacesMessage(nom_option +" \nEnregistrée avec succès");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    } else {
                        FacesMessage msg = new FacesMessage(nom_option +" \nExiste déjà");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }

                } else {
                    FacesMessage msg = new FacesMessage(nom_filiere+ " et"+nom_option+"  incoherantes");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else if (nom_filiere.equalsIgnoreCase("SCIENCES SOCIALES POUR LE DEVELOPPEMENT")) {
                if (nom_option.equalsIgnoreCase("/")) {
                    Option1 uneOption = option1Service.findOptionbyNom(nom_option);
                    if (uneOption == null) {
                        option1.setFiliere(filiereService.findFiliereByNom(nom_filiere));
                        option1.setNom_option1(nom_option.toUpperCase());
                        option1Service.registerOption1(option1);
                        FacesMessage msg = new FacesMessage(nom_option +" \nEnregistrée avec succès");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    } else {
                        FacesMessage msg = new FacesMessage(nom_option +" \nExiste déjà");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }

                } else {
                    FacesMessage msg = new FacesMessage(nom_filiere+ " et"+nom_option+"  incoherantes");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else if (nom_filiere.equalsIgnoreCase("TRAITEMENT DES MATERIAUX, ARCHITECTURE ET HABITAT")) {
                if (nom_option.equalsIgnoreCase("TRAITEMENT DES MATERIAUX") || nom_option.equalsIgnoreCase("ARCHITECTURE ET HABITAT") || nom_option.equalsIgnoreCase("AGRO-ALIMENTAIRE") || nom_option.equalsIgnoreCase("ECONOMIE ET MANAGEMENT")) {
                    Option1 uneOption = option1Service.findOptionbyNom(nom_option);
                    if (uneOption == null) {
                        option1.setFiliere(filiereService.findFiliereByNom(nom_filiere));
                        option1.setNom_option1(nom_option.toUpperCase());
                        option1Service.registerOption1(option1);
                        FacesMessage msg = new FacesMessage(nom_option +" \nEnregistrée avec succès");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    } else {
                        FacesMessage msg = new FacesMessage(nom_option +" \nExiste déjà");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }

                } else {
                    FacesMessage msg = new FacesMessage(nom_filiere+ " et"+nom_option+"  incoherantes");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else {
                if (nom_option.equalsIgnoreCase("/")) {
                    Option1 uneOption = option1Service.findOptionbyNom(nom_option);
                    if (uneOption == null) {
                        option1.setFiliere(filiereService.findFiliereByNom(nom_filiere));
                        option1.setNom_option1(nom_option.toUpperCase());
                        option1Service.registerOption1(option1);
                        FacesMessage msg = new FacesMessage(nom_option +" \n Enregistrée avec succès");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    } else {
                        FacesMessage msg = new FacesMessage(nom_option +" \n Existe déjà");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }

                } else {
                    FacesMessage msg = new FacesMessage(nom_filiere+ " et"+nom_option+"  incoherantes");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            }


        } catch (DataAccessException ex) {
            Logger.getLogger(Option1Bean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void supprimer() {
        System.out.println("id_option "+option1.getId_option1());
        try {
                option1Service.deleteOption1(option1Choisi.getId_option1());
                FacesMessage msg = new FacesMessage(" Suppression avec succès ");
                FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
