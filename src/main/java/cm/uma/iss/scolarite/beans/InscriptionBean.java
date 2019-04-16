/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.AnneeAccademique;
import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.Documents;
import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.Filiere;
import cm.uma.iss.scolarite.entities.Inscription;
import cm.uma.iss.scolarite.entities.Niveau;
import cm.uma.iss.scolarite.entities.Option1;
import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.entities.Promotion;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import cm.uma.iss.scolarite.entities.RetraitRetourDoc;
import cm.uma.iss.scolarite.services.IAnneeAccademiqueService;
import cm.uma.iss.scolarite.services.ICycleService;
import cm.uma.iss.scolarite.services.IDocumentService;
import cm.uma.iss.scolarite.services.IEtudiantService;
import cm.uma.iss.scolarite.services.IFiliereService;
import cm.uma.iss.scolarite.services.IInscriptionService;
import cm.uma.iss.scolarite.services.INiveauService;
import cm.uma.iss.scolarite.services.IOption1Service;
import cm.uma.iss.scolarite.services.IPaysOrigineService;
import cm.uma.iss.scolarite.services.IRegionOrigineService;
import cm.uma.iss.scolarite.services.IRetraitRetourDocService;
import com.douwe.generic.dao.DataAccessException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
public class InscriptionBean {

    @ManagedProperty(value = "#{IInscriptionService}")
    private IInscriptionService inscriptionService;
    @ManagedProperty(value = "#{IEtudiantService}")
    private IEtudiantService etudiantService;
    @ManagedProperty(value = "#{IFiliereService}")
    private IFiliereService filiereService;
    @ManagedProperty(value = "#{INiveauService}")
    private INiveauService niveauService;
    @ManagedProperty(value = "#{ICycleService}")
    private ICycleService cycleService;
    @ManagedProperty(value = "#{IRetraitRetourDocService}")
    private IRetraitRetourDocService retraitRetourDocService;
    @ManagedProperty(value = "#{IDocumentService}")
    private IDocumentService documentService;
    @ManagedProperty(value = "#{IOption1Service}")
    private IOption1Service option1Service;
    @ManagedProperty(value = "#{IPaysOrigineService}")
    private IPaysOrigineService paysOrigineService;
    @ManagedProperty(value = "#{IRegionOrigineService}")
    private IRegionOrigineService regionOrigineService;
    @ManagedProperty(value = "#{IAnneeAccademiqueService}")
    private IAnneeAccademiqueService anneeAccademiqueService;
    private Inscription inscription = new Inscription();
    private Inscription selectionInscription;
    private Etudiant etudiant = new Etudiant();
    private AnneeAccademique anneeAccademique = new AnneeAccademique();
    private RegionOrigine regionOrigine = new RegionOrigine();
    private PaysOrigine paysOrigine = new PaysOrigine();
    private Cycle cycle = new Cycle();
    private Niveau niveau = new Niveau();
    private Filiere filiere = new Filiere();
    private Option1 option1 = new Option1();
    private Promotion promotion = new Promotion();
    private Documents document = new Documents();
    private RetraitRetourDoc retraitRetourDoc = new RetraitRetourDoc();
    private List<Inscription> listeInscritGeneral = new ArrayList<Inscription>();
    private static List<Inscription> anciensEtudiants = new ArrayList<Inscription>();
    private static List<Inscription> listes = new ArrayList<Inscription>();
    private List<Documents> listeDocument;
    private List<Inscription> inscriptionList;
//    private List<Inscription> etudiantsPaiement= new ArrayList<Inscription>();
    private Integer total = 0;
    private String documentEnretrait = null;
    private String msge;
    private Date date;
    private String titre = "R.A.S";
    private Integer effectif = 0;
    //constructeurs

    public InscriptionBean() {
    }

    public Inscription getSelectionInscription() {
        return selectionInscription;
    }

    public void setSelectionInscription(Inscription selectionInscription) {
        this.selectionInscription = selectionInscription;
    }

    public IAnneeAccademiqueService getAnneeAccademiqueService() {
        return anneeAccademiqueService;
    }

    public void setAnneeAccademiqueService(IAnneeAccademiqueService anneeAccademiqueService) {
        this.anneeAccademiqueService = anneeAccademiqueService;
    }

//    public List<Inscription> getNouveauxEtudiants() {
//        return nouveauxEtudiants;
//    }
//
//    public void setNouveauxEtudiants(List<Inscription> nouveauxEtudiants) {
//        InscriptionBean.nouveauxEtudiants = nouveauxEtudiants;
//    }
    public List<Inscription> getAnciensEtudiants() {
        return anciensEtudiants;
    }

    public void setAnciensEtudiants(List<Inscription> anciensEtudiants) {
        InscriptionBean.anciensEtudiants = anciensEtudiants;
    }

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

    public IOption1Service getOption1Service() {
        return option1Service;
    }

    public void setOption1Service(IOption1Service option1Service) {
        this.option1Service = option1Service;
    }

    public Integer getEffectif() {
        return effectif;
    }

    public void setEffectif(Integer effectif) {
        this.effectif = effectif;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<Inscription> getListes() {
        return listes;
    }

    public void setListes(List<Inscription> listes) {
        InscriptionBean.listes = listes;
    }

    public List<Inscription> getListeInscritGeneral() throws DataAccessException {
        listeInscritGeneral = inscriptionService.findInscriptionTout();
        return listeInscritGeneral;
    }

    public void setListeInscritGeneral(List<Inscription> listeInscritGeneral) {
        this.listeInscritGeneral = listeInscritGeneral;
    }

    public List<Documents> getListeDocument() throws DataAccessException {
        listeDocument = new ArrayList<Documents>();
        listeDocument = documentService.findDocumentAll();
        return listeDocument;
    }

    public void setListeDocument(List<Documents> listeDocument) {
        this.listeDocument = listeDocument;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Inscription> getInscriptionList() throws DataAccessException {
        inscriptionList = inscriptionService.findInscriptionAll();
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    public String getMsge() {
        return msge;
    }

    public void setMsge(String msge) {
        this.msge = msge;
    }

    public String getDocumentEnretrait() {
        return documentEnretrait;
    }

    public void setDocumentEnretrait(String documentEnretrait) {
        this.documentEnretrait = documentEnretrait;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public IDocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(IDocumentService documentService) {
        this.documentService = documentService;
    }

    public Documents getDocument() {
        return document;
    }

    public void setDocument(Documents document) {
        this.document = document;
    }

    public IRetraitRetourDocService getRetraitRetourDocService() {
        return retraitRetourDocService;
    }

    public void setRetraitRetourDocService(IRetraitRetourDocService retraitRetourDocService) {
        this.retraitRetourDocService = retraitRetourDocService;
    }

    public INiveauService getNiveauService() {
        return niveauService;
    }

    public void setNiveauService(INiveauService niveauService) {
        this.niveauService = niveauService;
    }

    public ICycleService getCycleService() {
        return cycleService;
    }

    public void setCycleService(ICycleService cycleService) {
        this.cycleService = cycleService;
    }

    //getters and setters
    public IFiliereService getFiliereService() {
        return filiereService;
    }

    public void setFiliereService(IFiliereService filiereService) {
        this.filiereService = filiereService;
    }

    public RetraitRetourDoc getRetraitRetourDoc() {
        return retraitRetourDoc;
    }

    public void setRetraitRetourDoc(RetraitRetourDoc retraitRetourDoc) {
        this.retraitRetourDoc = retraitRetourDoc;
    }

    public IInscriptionService getInscriptionService() {
        return inscriptionService;
    }

    public void setInscriptionService(IInscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    public IEtudiantService getEtudiantService() {
        return etudiantService;
    }

    public void setEtudiantService(IEtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public void setAnneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
    }

    public RegionOrigine getRegionOrigine() {
        return regionOrigine;
    }

    public void setRegionOrigine(RegionOrigine regionOrigine) {
        this.regionOrigine = regionOrigine;
    }

    public PaysOrigine getPaysOrigine() {
        return paysOrigine;
    }

    public void setPaysOrigine(PaysOrigine paysOrigine) {
        this.paysOrigine = paysOrigine;
    }

    public Cycle getCycle() {
        return cycle;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Option1 getOption1() {
        return option1;
    }

    public void setOption1(Option1 option1) {
        this.option1 = option1;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public void onEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Edited", ((Inscription) event.getObject()).getEtudiant().getNom());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Cancelled", ((Inscription) event.getObject()).getEtudiant().getMatricule());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void initialiserListe() {
        listes = new ArrayList<Inscription>();
        effectif = listes.size();
        total = 0;
    }

    /**
     *
     * méthode de filtrage des étudiants par année
     * académique,cycle,niveau,filière,option,pays,région et sexe
     */
    public List<Inscription> afficherListe() {
        System.out.println("année accademique " + anneeAccademique.getAnnee());
        System.out.println("cycle " + cycle.getNom_cycle());
        System.out.println("Niveau " + niveau.getNom_niveau());
        System.out.println("filiere " + filiere.getNom_filiere());
        System.out.println("option " + option1.getNom_option1());
        System.out.println("pays " + paysOrigine.getNom_pays());
        System.out.println("region " + regionOrigine.getNom_regionOrigine());
        System.out.println("sexe " + etudiant.getGenre());

        try {
            if (anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                System.out.println("Aucune selection");
                listes = new ArrayList<Inscription>();
                effectif = listes.size();
                titre = " " + "R.A.S";

            } else if (!anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                System.out.println("Selection éffectuée: " + anneeAccademique.getAnnee());
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                System.out.println("" + aa);
                listes = inscriptionService.findInscriptionByAnneAccademique(aa);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee();
//               for (Inscription inscription1 : listes) {
//                  System.out.println("" + inscription1);
//                }

            } else if (anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                System.out.println("Selection éffectuée: " + cycle.getNom_cycle());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                System.out.println("" + c);
                listes = inscriptionService.findInscriptionByCycle(c);
                titre = "LISTE DES ETUDIANTS DE: " + cycle.getNom_cycle().toUpperCase();
//               for (Inscription inscription1 : listes) {
//                   System.out.println("" + inscription1);
//                }

            } else if (anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                System.out.println("Selection éffectuée: " + niveau.getNom_niveau());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                System.out.println("" + n);
                listes = inscriptionService.findInscriptionByNiveau(n);
                titre = "LISTE DES ETUDIANTS DE: " + niveau.getNom_niveau().toUpperCase();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                System.out.println("Selection éffectuée: " + filiere.getNom_filiere());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                System.out.println("" + f);
                listes = inscriptionService.findInscriptionByFiliere(f);
                titre = "LISTE DES ETUDIANTS DE: " + filiere.getNom_filiere().toUpperCase();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && !option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                System.out.println("Selection éffectuée: " + option1.getNom_option1());
                Option1 o = option1Service.findOptionbyNom(option1.getNom_option1());
                System.out.println("" + o);
                listes = inscriptionService.findInscriptionByOption(o);
                titre = "LISTE DES ETUDIANTS DE: " + option1.getNom_option1().toUpperCase();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && !paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                System.out.println("Selection éffectuée: " + paysOrigine.getNom_pays());
                PaysOrigine p = paysOrigineService.getPaysByNom(paysOrigine.getNom_pays());
                System.out.println("" + p);
                listes = inscriptionService.findInscriptionByPays(p);
                titre = "LISTE DES ETUDIANTS DU: " + paysOrigine.getNom_pays().toUpperCase();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && !regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                System.out.println("Selection éffectuée: " + regionOrigine.getNom_regionOrigine());
                RegionOrigine r = regionOrigineService.findRegionOrigineByNom(regionOrigine.getNom_regionOrigine());
                System.out.println("" + r);
                listes = inscriptionService.findInscriptionByRegion(r);
                titre = "LISTE DES ETUDIANTS DE: " + regionOrigine.getNom_regionOrigine().toUpperCase();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && !etudiant.getGenre().equals("7")) {
                System.out.println("Selection éffectuée: " + etudiant.getGenre());
                listes = inscriptionService.findInscriptionByGenre(etudiant.getGenre());
                if (etudiant.getGenre().equals("F")) {
                    titre = "Liste des étudiants de sexe feminin";
                } else {
                    titre = "Liste des étudiants de sexe masculin";
                }

//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycle(aa, c);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueNiveau(aa, n);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + niveau.getNom_niveau();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueFiliere(aa, f);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + filiere.getNom_filiere();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && !option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Option1 o = option1Service.findOptionbyNom(option1.getNom_option1());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueOption(aa, o);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + option1.getNom_option1();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && !paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                PaysOrigine p = paysOrigineService.getPaysByNom(paysOrigine.getNom_pays());
                listes = inscriptionService.findInscriptionByAnneeAcademiquePaysOrigine(aa, p);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + paysOrigine.getNom_pays();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && !etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueGenre(aa, etudiant.getGenre());
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + etudiant.getGenre();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveau(aa, c, n);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + niveau.getNom_niveau();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleFiliere(aa, c, f);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + filiere.getNom_filiere();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && !option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Option1 o = option1Service.findOptionbyNom(option1.getNom_option1());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleOption(aa, c, o);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + option1.getNom_option1();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && !paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                PaysOrigine p = paysOrigineService.getPaysByNom(paysOrigine.getNom_pays());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCyclePaysOrigine(aa, c, p);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + paysOrigine.getNom_pays();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && !regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                RegionOrigine r = regionOrigineService.findRegionOrigineByNom(regionOrigine.getNom_regionOrigine());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleRegionOrigine(aa, c, r);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + regionOrigine.getNom_regionOrigine();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && !etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleGenre(aa, c, etudiant.getGenre());
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + etudiant.getGenre();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveauFiliere(aa, c, n, f);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + niveau.getNom_niveau() + ">>" + filiere.getNom_filiere();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && !option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                Option1 o = option1Service.findOptionbyNom(option1.getNom_option1());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveauOption(aa, c, n, o);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + niveau.getNom_niveau() + ">>" + option1.getNom_option1();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && !paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                PaysOrigine p = paysOrigineService.getPaysByNom(paysOrigine.getNom_pays());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveauPaysOrigine(aa, c, n, p);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + niveau.getNom_niveau() + ">>" + paysOrigine.getNom_pays();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && !regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                RegionOrigine r = regionOrigineService.findRegionOrigineByNom(regionOrigine.getNom_regionOrigine());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveauRegionOrigine(aa, c, n, r);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + niveau.getNom_niveau() + ">>" + regionOrigine.getNom_regionOrigine();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && !etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveauGenre(aa, c, n, etudiant.getGenre());
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + niveau.getNom_niveau() + ">>" + etudiant.getGenre();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && !option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                Option1 o = option1Service.findOptionbyNom(option1.getNom_option1());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveauFiliereOption(aa, c, n, f, o);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + niveau.getNom_niveau() + ">>" + filiere.getNom_filiere() + ">>" + option1.getNom_option1();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && !paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                PaysOrigine p = paysOrigineService.getPaysByNom(paysOrigine.getNom_pays());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveauFilierePaysOrigine(aa, c, n, f, p);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + niveau.getNom_niveau() + ">>" + filiere.getNom_filiere() + ">>" + paysOrigine.getNom_pays();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && !regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                Option1 o = option1Service.findOptionbyNom(option1.getNom_option1());
                RegionOrigine r = regionOrigineService.findRegionOrigineByNom(regionOrigine.getNom_regionOrigine());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveauFiliereRegionOrigine(aa, c, n, f, r);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + niveau.getNom_niveau() + ">>" + filiere.getNom_filiere() + ">>" + regionOrigine.getNom_regionOrigine();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && !etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveauFiliereGenre(aa, c, n, f, etudiant.getGenre());
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + niveau.getNom_niveau() + ">>" + filiere.getNom_filiere() + ">>" + etudiant.getGenre();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && !option1.getNom_option1().equals("4") && !paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                Option1 o = option1Service.findOptionbyNom(option1.getNom_option1());
                PaysOrigine p = paysOrigineService.getPaysByNom(paysOrigine.getNom_pays());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigine(aa, c, n, f, o, p);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + niveau.getNom_niveau() + ">>" + filiere.getNom_filiere() + ">>" + option1.getNom_option1() + ">>" + paysOrigine.getNom_pays();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && !option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && !regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                Option1 o = option1Service.findOptionbyNom(option1.getNom_option1());
                RegionOrigine r = regionOrigineService.findRegionOrigineByNom(regionOrigine.getNom_regionOrigine());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionRegionOrigine(aa, c, n, f, o, r);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + niveau.getNom_niveau() + ">>" + filiere.getNom_filiere() + ">>" + option1.getNom_option1() + ">>" + regionOrigine.getNom_regionOrigine();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && !option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && !etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                Option1 o = option1Service.findOptionbyNom(option1.getNom_option1());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionGenre(aa, c, n, f, o, etudiant.getGenre());
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + niveau.getNom_niveau() + ">>" + filiere.getNom_filiere() + ">>" + option1.getNom_option1() + ">>" + etudiant.getGenre();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && !option1.getNom_option1().equals("4") && !paysOrigine.getNom_pays().equals("5") && !regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                Option1 o = option1Service.findOptionbyNom(option1.getNom_option1());
                PaysOrigine p = paysOrigineService.getPaysByNom(paysOrigine.getNom_pays());
                RegionOrigine r = regionOrigineService.findRegionOrigineByNom(regionOrigine.getNom_regionOrigine());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigineRegionOrigine(aa, c, n, f, o, p, r);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + niveau.getNom_niveau() + ">>" + filiere.getNom_filiere() + ">>" + option1.getNom_option1() + ">>" + paysOrigine.getNom_pays() + ">>" + regionOrigine.getNom_regionOrigine();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && !option1.getNom_option1().equals("4") && !paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && !etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                Option1 o = option1Service.findOptionbyNom(option1.getNom_option1());
                PaysOrigine p = paysOrigineService.getPaysByNom(paysOrigine.getNom_pays());
                //RegionOrigine r = regionOrigineService.findRegionOrigineByNom(regionOrigine.getNom_regionOrigine());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigineGenre(aa, c, n, f, o, p, etudiant.getGenre());
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + niveau.getNom_niveau() + ">>" + filiere.getNom_filiere() + ">>" + option1.getNom_option1() + ">>" + paysOrigine.getNom_pays() + ">>" + etudiant.getGenre();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && !option1.getNom_option1().equals("4") && !paysOrigine.getNom_pays().equals("5") && !regionOrigine.getNom_regionOrigine().equals("6") && !etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                Option1 o = option1Service.findOptionbyNom(option1.getNom_option1());
                PaysOrigine p = paysOrigineService.getPaysByNom(paysOrigine.getNom_pays());
                RegionOrigine r = regionOrigineService.findRegionOrigineByNom(regionOrigine.getNom_regionOrigine());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigineRegionOrigineGenre(aa, c, n, f, o, p, r, etudiant.getGenre());
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + cycle.getNom_cycle() + ">>" + niveau.getNom_niveau() + ">>" + filiere.getNom_filiere() + ">>" + option1.getNom_option1() + ">>" + paysOrigine.getNom_pays() + ">>" + regionOrigine.getNom_regionOrigine() + ">>" + etudiant.getGenre();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (!anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && !regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                RegionOrigine r = regionOrigineService.findRegionOrigineByNom(regionOrigine.getNom_regionOrigine());
                listes = inscriptionService.findInscriptionByAnneeAcademiqueRegionOrigine(aa, r);
                titre = "LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee().toUpperCase() + ">>" + regionOrigine.getNom_regionOrigine();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                System.out.println("Selection éffectuée: " + cycle.getNom_cycle() + " et " + niveau.getNom_niveau());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                System.out.println("" + c);
                System.out.println("" + n);
                listes = inscriptionService.findInscriptionByCycleNiveau(c, n);
                titre = ">>" + cycle.getNom_cycle() + " >>" + niveau.getNom_niveau();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                System.out.println("Selection éffectuée: " + niveau.getNom_niveau() + " et " + filiere.getNom_filiere());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                listes = inscriptionService.findInscriptionByNiveauFiliere(n, f);
                titre = "LISTE DES ETUDIANTS DE:: " + niveau.getNom_niveau() + " >>" + filiere.getNom_filiere();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1)
//                }
            } else if (anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && !option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                System.out.println("Selection éffectuée: " + niveau.getNom_niveau() + " et " + option1.getNom_option1());
                Option1 o = option1Service.findOptionbyNom(option1.getNom_option1());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                listes = inscriptionService.findInscriptionByNiveauOption(n, o);
                titre = "Liste des étudiants de: " + niveau.getNom_niveau() + " >>" + option1.getNom_option1();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                System.out.println("Selection éffectuée: " + niveau.getNom_niveau() + " et " + option1.getNom_option1());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                listes = inscriptionService.findInscriptionByCycleNiveauFiliere(c, n, f);
                titre = "Liste des étudiants de: " + cycle.getNom_cycle() + " >>" + niveau.getNom_niveau() + " >>" + filiere.getNom_filiere();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else if (anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && !option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                System.out.println("Selection éffectuée: " + niveau.getNom_niveau() + " et " + option1.getNom_option1());
                Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                Option1 o = option1Service.findOptionbyNom(option1.getNom_option1());
                listes = inscriptionService.findInscriptionByCycleNiveauFiliereOption(c, n, f, o);
                titre = "Liste des étudiants de: " + cycle.getNom_cycle() + " >>" + niveau.getNom_niveau() + " >>" + filiere.getNom_filiere() + " >>" + option1.getNom_option1();
//                for (Inscription inscription1 : listes) {
//                    System.out.println("" + inscription1);
//                }
            } else {
                System.out.println("Aucune selection");
                listes = new ArrayList<Inscription>();
                effectif = listes.size();
                titre = " " + "R.A.S";
            }
            effectif = listes.size();


        } catch (DataAccessException ex) {
            Logger.getLogger(InscriptionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listes;
    }
    /**
     * méthode pdf() elle permet d'imprimer les listes des étudiants
     */
    List<Inscription> listeImprimer;
    List<Etudiant> etudiantImprimer = new ArrayList<Etudiant>();
    JRBeanCollectionDataSource beanCollectionDataSource;
    String reportPath;
    JasperPrint jasperPrint;
    HttpServletResponse httpServletResponse;
    ServletOutputStream servletOutputStream;

    public void pdf() throws JRException, IOException {
        int t = listes.size();
        System.out.println("" + t);
        if (t != 0) {
            try {
                if (anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                    System.out.println("Aucune selection");
                    titre = ">>" + "R.A.S";

                } else if (!anneeAccademique.getAnnee().equals("0") && cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                    System.out.println("Selection éffectuée: " + anneeAccademique.getAnnee());
                    AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                    // Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                    listeImprimer = inscriptionService.findInscriptionByAnneAccademique(aa);
                    beanCollectionDataSource = new JRBeanCollectionDataSource(etudiantImprimer);
                    reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ireport/listeEtudiantsParAnneeAcademique.jasper");
                    jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
                    httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                    httpServletResponse.addHeader("Content-disposition", "attachment; filename=listeEtudiantsParAnneeAcademique" + "pdf");
                    servletOutputStream = httpServletResponse.getOutputStream();
                    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
                    FacesContext.getCurrentInstance().responseComplete();
                    // titre = "IMPRESSION DE LA LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee();

                } else if (!anneeAccademique.getAnnee().equals("0") && !cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                    AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee(anneeAccademique.getAnnee());
                    Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                    //Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                    listeImprimer = inscriptionService.findInscriptionByAnneeAcademiqueCycle(aa, c);
                    beanCollectionDataSource = new JRBeanCollectionDataSource(etudiantImprimer);
                    reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ireport/listeEtudiantsParAnneeAcademiqueCycle.jasper");
                    jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
                    httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                    httpServletResponse.addHeader("Content-disposition", "attachment; filename=listeEtudiantsParAnneeAcademiqueCycle" + "pdf");
                    servletOutputStream = httpServletResponse.getOutputStream();
                    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
                    FacesContext.getCurrentInstance().responseComplete();
                    //titre = "IMPRESSION DE LA LISTE DES ETUDIANTS DE: " + anneeAccademique.getAnnee();
                } else if (cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                    System.out.println("Selection éffectuée: " + filiere.getNom_filiere());
                    Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                    listeImprimer = inscriptionService.findInscriptionByFiliere(f);
                    for (Inscription inscription1 : listeImprimer) {
                        etudiantImprimer.add(inscription1.getEtudiant());
                    }
                    beanCollectionDataSource = new JRBeanCollectionDataSource(etudiantImprimer);
                    reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ireport/listeEtudiant.jasper");
                    jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
                    httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                    httpServletResponse.addHeader("Content-disposition", "attachment; filename=listeEtudiant" + "pdf");
                    servletOutputStream = httpServletResponse.getOutputStream();
                    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
                    FacesContext.getCurrentInstance().responseComplete();
                    titre = ">>" + filiere.getNom_filiere();
                } else if (cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && !option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                    System.out.println("Selection éffectuée: " + option1.getNom_option1());
                    Option1 o = option1Service.findOptionbyNom(option1.getNom_option1());
                    listeImprimer = inscriptionService.findInscriptionByOption(o);
                    for (Inscription inscription1 : listeImprimer) {
                        etudiantImprimer.add(inscription1.getEtudiant());
                    }
                    beanCollectionDataSource = new JRBeanCollectionDataSource(etudiantImprimer);
                    reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ireport/listeEtudiant.jasper");
                    jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
                    httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                    httpServletResponse.addHeader("Content-disposition", "attachment; filename=listeEtudiant" + "pdf");
                    servletOutputStream = httpServletResponse.getOutputStream();
                    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
                    FacesContext.getCurrentInstance().responseComplete();
                    titre = ">>" + option1.getNom_option1();
                } else if (cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && !paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                    System.out.println("Selection éffectuée: " + paysOrigine.getNom_pays());
                    PaysOrigine p = paysOrigineService.getPaysByNom(paysOrigine.getNom_pays());
                    listeImprimer = inscriptionService.findInscriptionByPays(p);
                    for (Inscription inscription1 : listeImprimer) {
                        etudiantImprimer.add(inscription1.getEtudiant());
                    }
                    beanCollectionDataSource = new JRBeanCollectionDataSource(etudiantImprimer);
                    reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ireport/listeEtudiant.jasper");
                    jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
                    httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                    httpServletResponse.addHeader("Content-disposition", "attachment; filename=listeEtudiant" + "pdf");
                    servletOutputStream = httpServletResponse.getOutputStream();
                    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
                    FacesContext.getCurrentInstance().responseComplete();
                    titre = ">>" + paysOrigine.getNom_pays();
                } else if (cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && !regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                    System.out.println("Selection éffectuée: " + regionOrigine.getNom_regionOrigine());
                    RegionOrigine r = regionOrigineService.findRegionOrigineByNom(regionOrigine.getNom_regionOrigine());
                    listeImprimer = inscriptionService.findInscriptionByRegion(r);
                    for (Inscription inscription1 : listeImprimer) {
                        etudiantImprimer.add(inscription1.getEtudiant());
                    }
                    beanCollectionDataSource = new JRBeanCollectionDataSource(etudiantImprimer);
                    reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ireport/listeEtudiant.jasper");
                    jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
                    httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                    httpServletResponse.addHeader("Content-disposition", "attachment; filename=listeEtudiant" + "pdf");
                    servletOutputStream = httpServletResponse.getOutputStream();
                    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
                    FacesContext.getCurrentInstance().responseComplete();
                    titre = ">>" + regionOrigine.getNom_regionOrigine();
                } else if (cycle.getNom_cycle().equals("1") && niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && !etudiant.getGenre().equals("7")) {
                    System.out.println("Selection éffectuée: " + etudiant.getGenre());
                    listeImprimer = inscriptionService.findInscriptionByGenre(etudiant.getGenre());
                    for (Inscription inscription1 : listeImprimer) {
                        etudiantImprimer.add(inscription1.getEtudiant());
                    }
                    beanCollectionDataSource = new JRBeanCollectionDataSource(etudiantImprimer);
                    reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ireport/listeEtudiant.jasper");
                    jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
                    httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                    httpServletResponse.addHeader("Content-disposition", "attachment; filename=listeEtudiant" + "pdf");
                    servletOutputStream = httpServletResponse.getOutputStream();
                    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
                    FacesContext.getCurrentInstance().responseComplete();
                    titre = ">>" + etudiant.getGenre();

                } else if (!cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                    System.out.println("Selection éffectuée: " + cycle.getNom_cycle() + " et " + niveau.getNom_niveau());
                    Cycle c = cycleService.findCycleByNom(cycle.getNom_cycle());
                    Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                    System.out.println("" + c);
                    System.out.println("" + n);
                    listeImprimer = inscriptionService.findInscriptionByCycleNiveau(c, n);
                    for (Inscription inscription1 : listeImprimer) {
                        etudiantImprimer.add(inscription1.getEtudiant());
                    }
                    beanCollectionDataSource = new JRBeanCollectionDataSource(etudiantImprimer);
                    reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ireport/listeEtudiant.jasper");
                    jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
                    httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                    httpServletResponse.addHeader("Content-disposition", "attachment; filename=listeEtudiant" + "pdf");
                    servletOutputStream = httpServletResponse.getOutputStream();
                    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
                    FacesContext.getCurrentInstance().responseComplete();
                    titre = ">>" + cycle.getNom_cycle() + " >>" + niveau.getNom_niveau();

                } else if (cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && !filiere.getNom_filiere().equals("3") && option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                    System.out.println("Selection éffectuée: " + niveau.getNom_niveau() + " et " + filiere.getNom_filiere());
                    Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
                    Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                    listeImprimer = inscriptionService.findInscriptionByNiveauFiliere(n, f);
                    for (Inscription inscription1 : listeImprimer) {
                        etudiantImprimer.add(inscription1.getEtudiant());
                    }
                    beanCollectionDataSource = new JRBeanCollectionDataSource(etudiantImprimer);
                    reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ireport/listeEtudiant.jasper");
                    jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
                    httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                    httpServletResponse.addHeader("Content-disposition", "attachment; filename=listeEtudiant" + "pdf");
                    servletOutputStream = httpServletResponse.getOutputStream();
                    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
                    FacesContext.getCurrentInstance().responseComplete();
                    titre = ">>" + niveau.getNom_niveau() + " >>" + filiere.getNom_filiere();

                } else if (cycle.getNom_cycle().equals("1") && !niveau.getNom_niveau().equals("2") && filiere.getNom_filiere().equals("3") && !option1.getNom_option1().equals("4") && paysOrigine.getNom_pays().equals("5") && regionOrigine.getNom_regionOrigine().equals("6") && etudiant.getGenre().equals("7")) {
                    System.out.println("Selection éffectuée: " + niveau.getNom_niveau() + " et " + option1.getNom_option1());
                    Option1 o = option1Service.findOptionbyNom(option1.getNom_option1());
                    Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
                    listeImprimer = inscriptionService.findInscriptionByNiveauOption(n, o);
                    for (Inscription inscription1 : listeImprimer) {
                        etudiantImprimer.add(inscription1.getEtudiant());
                    }
                    beanCollectionDataSource = new JRBeanCollectionDataSource(etudiantImprimer);
                    reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ireport/listeEtudiant.jasper");
                    jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
                    httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                    httpServletResponse.addHeader("Content-disposition", "attachment; filename=listeEtudiant" + "pdf");
                    servletOutputStream = httpServletResponse.getOutputStream();
                    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
                    FacesContext.getCurrentInstance().responseComplete();
                    titre = ">>" + niveau.getNom_niveau() + " >>" + option1.getNom_option1();

                } else {
                    System.out.println("Aucune selection");
                }

            } catch (DataAccessException ex) {
                Logger.getLogger(InscriptionBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
        }


    }

    public void initialiserRetraitAnciensEtudiants() {
        System.out.println("Initialisation");
        anciensEtudiants = new ArrayList<Inscription>();
        total = anciensEtudiants.size();
    }

    /**
     * cette methode permet de filtrer les anciens étudiants suivant les
     * critères tels que:cycle, niveau et filière retrait des coupons des
     * anciens étudiants
     *
     * @return
     * @throws DataAccessException
     */
    public void filtrerRetraitRetourDocumentAcademique() throws DataAccessException {
        // System.out.println(" " + cycle.getNom_cycle());
        System.out.println(" " + niveau.getNom_niveau());
        System.out.println(" " + filiere.getNom_filiere());
        if (niveau.getNom_niveau().equals("1") && filiere.getNom_filiere().equals("2")) {
            anciensEtudiants = new ArrayList<Inscription>();
        } else if (!niveau.getNom_niveau().equals("1") && filiere.getNom_filiere().equals("2")) {
            Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
            anciensEtudiants = inscriptionService.findInscriptionByNiveauAncien(n);
            //total = lanciensEtudiants.size();
        } else if (!niveau.getNom_niveau().equals("1") && !filiere.getNom_filiere().equals("2")) {
            Filiere f = filiereService.findFiliereByNom(filiere.getNom_filiere());
            Niveau n = niveauService.findNiveauByNom(niveau.getNom_niveau());
            anciensEtudiants = inscriptionService.findInscriptionByFiliereNiveauAncien(f, n);
            //total = anciensEtudiants.size();
        } else {
            anciensEtudiants = new ArrayList<Inscription>();
        }
        total = anciensEtudiants.size();
    }

    /**
     * validation des retraits des documents academiques
     */
    public void validerRetraitDocumentAcademique() {
        try {
            // Niveau n = niveauService.findNiveauById(niveau.getId_niveau());
            Documents d = documentService.findDocumentById(Integer.parseInt(document.getId_document() + ""));
            Etudiant e = etudiantService.findEtudintById(etudiant.getId_etudiant());
            System.out.println("id_etudiant======> " + etudiant.getId_etudiant() + " id_doc===========>" + d.getId_document());
            retraitRetourDoc.setDateRetrait("" + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()));
            retraitRetourDoc.setDocuements(document);
            retraitRetourDoc.setEtudiant(etudiant);
            retraitRetourDoc.setEtatPreinscription(false);
            //retraitRetourDocService.registerRetraitRetourDoc(retraitRetourDoc);
            FacesMessage msg = new FacesMessage("RETRAIT DU  " + d.getType() + " AVEC SUCCÈS  PAR " + e.getMatricule());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            // System.out.println(etudiant.getMatricule() + "  " + etudiant.getNom() + "======> " + d.getType());
//            documentEnretrait = d.getType();
//            int etat = 0;
//            List<RetraitRetourDoc> listeRetraitRetour = retraitRetourDocService.findRetraitDocument();
//            for (RetraitRetourDoc retraitRetourDoc1 : listeRetraitRetour) {
//               // System.out.println("Document==> " + retraitRetourDoc1.getDocuments().getId_document() + "  Etudiant==> " + retraitRetourDoc1.getEtudiant().getId_etudiant());
//                if (e.getId_etudiant() == retraitRetourDoc1.getEtudiant().getId_etudiant() && d.getId_document() == retraitRetourDoc1.getDocuments().getId_document()) {
//                    etat = 1;
//                }
//            }
//            if (etat == 0) {
//                retraitRetourDoc.setDateRetrait("" + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()));
//                retraitRetourDoc.setDocuements(document);
//                retraitRetourDoc.setEtudiant(etudiant);
//                retraitRetourDoc.setEtatPreinscription(false);
//                retraitRetourDocService.registerRetraitRetourDoc(retraitRetourDoc);
//                FacesMessage msg = new FacesMessage("RETRAIT DU  " + d.getType() + " AVEC SUCCÈS  PAR " + e.getMatricule());
//                FacesContext.getCurrentInstance().addMessage(null, msg);
//            } else {
//                System.out.println(d.getType() + " DÉJÀ RÉTIRÉ");
//                FacesMessage msg = new FacesMessage(d.getType() + " DÉJÀ RÉTIRÉ PAR:" + e.getMatricule());
//                FacesContext.getCurrentInstance().addMessage(null, msg);
//            }


//            if (documentEnretrait.equals("COUPON VISITE MEDICALE")) {
//                List<RetraitRetourDoc> unRD = retraitRetourDocService.findRetraitDocument();
//                System.out.println("" + unRD);
//                if (unRD == null) {
//                    retraitRetourDoc.setDateRetrait(new Date());
//                    retraitRetourDoc.setDocuements(document);
//                    retraitRetourDoc.setEtudiant(etudiant);
//                    retraitRetourDoc.setEtatPreinscription(false);
//                    retraitRetourDocService.registerRetraitRetourDoc(retraitRetourDoc);
//                    FacesMessage msg = new FacesMessage("RETRAIT DU  " + doc.getType() + " AVEC SUCCÈS  PAR " + etudiant1.getMatricule());
//                    FacesContext.getCurrentInstance().addMessage(null, msg);
//                } else {
//                    System.out.println(doc.getType() + " DÉJÀ RÉTIRÉ");
//                    FacesMessage msg = new FacesMessage(doc.getType() + " DÉJÀ RÉTIRÉ PAR:" + etudiant1.getMatricule());
//                    FacesContext.getCurrentInstance().addMessage(null, msg);
//                }
//
//            } else if (documentEnretrait.equals("COUPON PREMIERE TRANCHE") || documentEnretrait.equals("COUPON DEUXIEME TRANCHE")) {
//                Documents doc1 = documentService.findDocumentByType("COUPON VISITE MEDICALE");
//                System.out.println("id_etudiant " + etudiant.getId_etudiant() + " id_docCvm  " + doc1.getId_document());
//                RetraitRetourDoc rrdCvm = retraitRetourDocService.findRetraitRetourDoc(doc1.getId_document(), etudiant.getId_etudiant(), true);
//                //System.out.println(""+unRD);
//                if (rrdCvm != null) {
//                    RetraitRetourDoc unRD = retraitRetourDocService.findRetraitDoc(document, etudiant);
//                    if (unRD == null) {
//                        retraitRetourDoc.setDateRetrait(new Date());
////                        retraitRetourDoc.setDocuementId(doc.getId_document());
////                        retraitRetourDoc.setEtudiantId(etudiant.getId_etudiant());
//                        retraitRetourDocService.registerRetraitRetourDoc(retraitRetourDoc);
//                        FacesMessage msg = new FacesMessage("RETRAIT AVEC SUCCÈS DU " + doc.getType() + " PAR " + etudiant1.getMatricule());
//                        FacesContext.getCurrentInstance().addMessage(null, msg);
//                    } else {
//                        System.out.println(doc.getType() + " DÉJÀ RÉTIRÉ");
//                        FacesMessage msg = new FacesMessage(doc.getType() + " DÉJÀ RÉTIRÉ PAR:" + etudiant1.getMatricule());
//                        FacesContext.getCurrentInstance().addMessage(null, msg);
//                    }
//
//                } else {
//                    //JOptionPane.showConfirmDialog(null, "Attention");
//                    System.out.println("Pas de préinscription");
//                    FacesMessage msg = new FacesMessage(etudiant1.getMatricule() + "  :RETOURNE D'ABORD LE COUPON DE VISITE MEDICALE");
//                    FacesContext.getCurrentInstance().addMessage(null, msg);
//                }
//            } else if (documentEnretrait.equals("CERTIFICAT DE SCOLARITE") || documentEnretrait.equals("CARTE D'ETUDIANT")) {
//                Documents doc1 = documentService.findDocumentByType("COUPON PREMIERE TRANCHE");
//                Documents doc2 = documentService.findDocumentByType("COUPON DEUXIEME TRANCHE");
//                RetraitRetourDoc rrdCt1 = retraitRetourDocService.findRetraitRetourDoc1(doc1.getId_document(), etudiant.getId_etudiant(), true);
//                RetraitRetourDoc rrdCt2 = retraitRetourDocService.findRetraitRetourDoc1(doc2.getId_document(), etudiant.getId_etudiant(), true);
//                if (rrdCt1 != null && rrdCt2 != null) {
//                    RetraitRetourDoc unRD = retraitRetourDocService.findRetraitDoc(document, etudiant);
//                    if (unRD == null) {
//                        retraitRetourDoc.setDateRetrait(new Date());
//                        retraitRetourDoc.setDateRetour(new Date());
//                        retraitRetourDoc.setEtatPreinscription(true);
//                        retraitRetourDoc.setEtatInscription(true);
////                        retraitRetourDoc.setDocuementId(doc.getId_document());
////                        retraitRetourDoc.setEtudiantId(etudiant.getId_etudiant());
//                        retraitRetourDocService.registerRetraitRetourDoc(retraitRetourDoc);
//                        FacesMessage msg = new FacesMessage("RETRAIT AVEC SUCCÈS DU " + doc.getType() + " PAR " + etudiant1.getMatricule());
//                        FacesContext.getCurrentInstance().addMessage(null, msg);
//                    } else {
//                        System.out.println(doc.getType() + " DÉJÀ RÉTIRÉ");
//                        FacesMessage msg = new FacesMessage(doc.getType() + " DÉJÀ RÉTIRÉ PAR:" + etudiant1.getMatricule());
//                        FacesContext.getCurrentInstance().addMessage(null, msg);
//                    }
//                } else {
//                    FacesMessage msg = new FacesMessage(etudiant1.getMatricule() + " : RETOUNEZ D'ABORD LES COUPONS DE 1ère et 2nd TRANCHE");
//                    FacesContext.getCurrentInstance().addMessage(null, msg);
//                }
//            } else {
//                FacesMessage msg = new FacesMessage("ERREUR");
//                FacesContext.getCurrentInstance().addMessage(null, msg);
//            }



        } catch (DataAccessException ex) {
            Logger.getLogger(InscriptionBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void annulerRetour() {
        try {
            Documents doc = documentService.findDocumentById(Integer.parseInt(document.getId_document() + ""));
            documentEnretrait = doc.getType();
            System.out.println("id_etudiant " + etudiant.getId_etudiant() + " id_doc  " + doc.getId_document());
            if (etudiant.getId_etudiant() == null) {
                msge = "SVP! VALIDER LE RETRAIT A NOUVEAU";
                FacesMessage msg = new FacesMessage("SVP!VALIDER LE RETOUR");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                RetraitRetourDoc unRD = retraitRetourDocService.findRetraitRetourDoc(doc.getId_document(), etudiant.getId_etudiant(), true);
                //System.out.println(""+unRD);
                if (unRD != null) {
                    System.out.println("Existe " + unRD);
                    unRD.setDateRetour(null);
                    unRD.setEtatPreinscription(false);
                    retraitRetourDocService.updateRetraitRetourDoc(unRD);
                    msge = "ANNULATION AVEC SUCCÈS";
                    FacesMessage msg = new FacesMessage("ANNULATION AVEC SUCCÈS");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    System.out.println("IMPOSSIBLE" + unRD);
                    msge = "IMPOSSIBLE";
                    FacesMessage msg = new FacesMessage("IMPOSSIBLE");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            }

        } catch (DataAccessException ex) {
            Logger.getLogger(InscriptionBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}