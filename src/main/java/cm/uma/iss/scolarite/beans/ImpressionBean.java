/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.AnneeAccademique;
import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.Inscription;
import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.entities.Promotion;
import cm.uma.iss.scolarite.services.IAnneeAccademiqueService;
import cm.uma.iss.scolarite.services.IArrondissementOrigineService;
import cm.uma.iss.scolarite.services.ICycleService;
import cm.uma.iss.scolarite.services.IEtudiantService;
import cm.uma.iss.scolarite.services.IFiliereService;
import cm.uma.iss.scolarite.services.IInscriptionService;
import cm.uma.iss.scolarite.services.INiveauService;
import cm.uma.iss.scolarite.services.IOption1Service;
import cm.uma.iss.scolarite.services.IPaysOrigineService;
import cm.uma.iss.scolarite.services.IPromotionService;
import cm.uma.iss.scolarite.services.IRegionOrigineService;
import com.douwe.generic.dao.DataAccessException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
public class ImpressionBean {

    @ManagedProperty(value = "#{IEtudiantService}")
    private IEtudiantService etudiantService;
    @ManagedProperty(value = "#{IPaysOrigineService}")
    private IPaysOrigineService paysOrigineService;
    @ManagedProperty(value = "#{IInscriptionService}")
    private IInscriptionService inscriptionService;
    @ManagedProperty(value = "#{IRegionOrigineService}")
    private IRegionOrigineService regionOrigineService;
    @ManagedProperty(value = "#{IPromotionService}")
    private IPromotionService promotionService;
    @ManagedProperty(value = "#{IOption1Service}")
    private IOption1Service option1Service;
    @ManagedProperty(value = "#{INiveauService}")
    private INiveauService niveauService;
    @ManagedProperty(value = "#{IFiliereService}")
    private IFiliereService filiereService;
    @ManagedProperty(value = "#{ICycleService}")
    private ICycleService cycleService;
    @ManagedProperty(value = "#{IArrondissementOrigineService}")
    private IArrondissementOrigineService arrondissementOrigineService;
    @ManagedProperty(value = "#{IAnneeAccademiqueService}")
    private IAnneeAccademiqueService anneeAccademiqueService;
    private AnneeAccademique anneeAccademique = new AnneeAccademique();
    private Promotion promotion = new Promotion();
    private Etudiant etudiant = new Etudiant();
    private List<Etudiant> etudiantList = new ArrayList<Etudiant>();
    private int choixPaiement;
    private int choixFiliere;
    private int filiereChoisie;
    private String formatDocument;
    private List<Etudiant> listeEtudiantPayeVisiteMedicale;
    private List<Etudiant> listeEtudiantNonPayeVisiteMedicale;
    private List<Etudiant> listeEtudiantNonpayePreinscription;
    private List<Etudiant> listeEtudiantNonpayeTranche1;
    private List<Etudiant> listeEtudiantNonpayeTranche2;
    private List<Etudiant> listeEtudiantINFOTEL;

    public ImpressionBean() {
    }

    public List<Etudiant> getListeEtudiantINFOTEL() {
        return listeEtudiantINFOTEL;
    }

    public void setListeEtudiantINFOTEL(List<Etudiant> listeEtudiantINFOTEL) {
        this.listeEtudiantINFOTEL = listeEtudiantINFOTEL;
    }

    public int getChoixPaiement() {
        return choixPaiement;
    }

    public void setChoixPaiement(int choixPaiement) {
        this.choixPaiement = choixPaiement;
    }

    public int getChoixFiliere() {
        return choixFiliere;
    }

    public void setChoixFiliere(int choixFiliere) {
        this.choixFiliere = choixFiliere;
    }


    public void setFiliereChoisie(int filiereChoisie) {
        this.filiereChoisie = filiereChoisie;
    }

    public List<Etudiant> getListeEtudiantPayeVisiteMedicale() {
        return listeEtudiantPayeVisiteMedicale;
    }

    public void setListeEtudiantPayeVisiteMedicale(List<Etudiant> listeEtudiantPayeVisiteMedicale) {
        this.listeEtudiantPayeVisiteMedicale = listeEtudiantPayeVisiteMedicale;
    }

    public List<Etudiant> getListeEtudiantNonPayeVisiteMedicale() {
        return listeEtudiantNonPayeVisiteMedicale;
    }

    public void setListeEtudiantNonPayeVisiteMedicale(List<Etudiant> listeEtudiantNonPayeVisiteMedicale) {
        this.listeEtudiantNonPayeVisiteMedicale = listeEtudiantNonPayeVisiteMedicale;
    }

    public List<Etudiant> getListeEtudiantNonpayePreinscription() {
        return listeEtudiantNonpayePreinscription;
    }

    public void setListeEtudiantNonpayePreinscription(List<Etudiant> listeEtudiantNonpayePreinscription) {
        this.listeEtudiantNonpayePreinscription = listeEtudiantNonpayePreinscription;
    }

    public List<Etudiant> getListeEtudiantNonpayeTranche1() {
        return listeEtudiantNonpayeTranche1;
    }

    public void setListeEtudiantNonpayeTranche1(List<Etudiant> listeEtudiantNonpayeTranche1) {
        this.listeEtudiantNonpayeTranche1 = listeEtudiantNonpayeTranche1;
    }

    public List<Etudiant> getListeEtudiantNonpayeTranche2() {
        return listeEtudiantNonpayeTranche2;
    }

    public void setListeEtudiantNonpayeTranche2(List<Etudiant> listeEtudiantNonpayeTranche2) {
        this.listeEtudiantNonpayeTranche2 = listeEtudiantNonpayeTranche2;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    public String getFormatDocument() {
        return formatDocument;
    }

    public void setFormatDocument(String formatDocument) {
        this.formatDocument = formatDocument;
    }


    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public IEtudiantService getEtudiantService() {
        return etudiantService;
    }

    public void setEtudiantService(IEtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    public IPaysOrigineService getPaysOrigineService() {
        return paysOrigineService;
    }

    public void setPaysOrigineService(IPaysOrigineService paysOrigineService) {
        this.paysOrigineService = paysOrigineService;
    }

    public IInscriptionService getInscriptionService() {
        return inscriptionService;
    }

    public void setInscriptionService(IInscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    public IRegionOrigineService getRegionOrigineService() {
        return regionOrigineService;
    }

    public void setRegionOrigineService(IRegionOrigineService regionOrigineService) {
        this.regionOrigineService = regionOrigineService;
    }

    public IPromotionService getPromotionService() {
        return promotionService;
    }

    public void setPromotionService(IPromotionService promotionService) {
        this.promotionService = promotionService;
    }

    public IOption1Service getOption1Service() {
        return option1Service;
    }

    public void setOption1Service(IOption1Service option1Service) {
        this.option1Service = option1Service;
    }

    public INiveauService getNiveauService() {
        return niveauService;
    }

    public void setNiveauService(INiveauService niveauService) {
        this.niveauService = niveauService;
    }

    public IFiliereService getFiliereService() {
        return filiereService;
    }

    public void setFiliereService(IFiliereService filiereService) {
        this.filiereService = filiereService;
    }

    public ICycleService getCycleService() {
        return cycleService;
    }

    public void setCycleService(ICycleService cycleService) {
        this.cycleService = cycleService;
    }

    public IArrondissementOrigineService getArrondissementOrigineService() {
        return arrondissementOrigineService;
    }

    public void setArrondissementOrigineService(IArrondissementOrigineService arrondissementOrigineService) {
        this.arrondissementOrigineService = arrondissementOrigineService;
    }

    public IAnneeAccademiqueService getAnneeAccademiqueService() {
        return anneeAccademiqueService;
    }

    public void setAnneeAccademiqueService(IAnneeAccademiqueService anneeAccademiqueService) {
        this.anneeAccademiqueService = anneeAccademiqueService;
    }

    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public void setAnneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public void pdfPaiement() throws IOException, JRException, DataAccessException {
        System.out.println("Document et format pour le paiement");
        System.out.println("document :" + getChoixPaiement()+ " format :" + getFormatDocument());
        List<Inscription> etudiants;
        JRBeanCollectionDataSource beanCollectionDataSource;
        String reportPath;
        JasperPrint jasperPrint;
        HttpServletResponse httpServletResponse;
        ServletOutputStream servletOutputStream;
        switch (choixPaiement) {

            case 0:
                break;
            case 1:
                etudiantList = etudiantService.findAllEtudiant();
                beanCollectionDataSource = new JRBeanCollectionDataSource(etudiantList);
                reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ireport/listeEtudiant.jasper");
                jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
                httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                httpServletResponse.addHeader("Content-disposition", "attachment; filename=listeEtudiant" + getFormatDocument());
                servletOutputStream = httpServletResponse.getOutputStream();
                JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
                FacesContext.getCurrentInstance().responseComplete();
                break;
            case 2:
                etudiants = new ArrayList<Inscription>();
               // etudiants = inscriptionService.findInscriptionByEtatVisiteMedicale("OUI");
                listeEtudiantPayeVisiteMedicale = new ArrayList<Etudiant>();
                for (Inscription inscription1 : etudiants) {
                    listeEtudiantPayeVisiteMedicale.add(inscription1.getEtudiant());
                    System.out.println(inscription1.getEtudiant());
                }
                beanCollectionDataSource = new JRBeanCollectionDataSource(listeEtudiantPayeVisiteMedicale);
                reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ireport/listeEtudiantPayeVisiteMedicale.jasper");
                jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
                httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                httpServletResponse.addHeader("Content-disposition", "attachment; filename=listeEtudiantPayeVisiteMedicale" + getFormatDocument());
                servletOutputStream = httpServletResponse.getOutputStream();
                JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
                FacesContext.getCurrentInstance().responseComplete();
                break;
            case 3:
                etudiants = new ArrayList<Inscription>();
               // etudiants = inscriptionService.findInscriptionByEtatVisiteMedicale("NON");
                listeEtudiantNonPayeVisiteMedicale = new ArrayList<Etudiant>();
                for (Inscription inscription1 : etudiants) {
                    listeEtudiantNonPayeVisiteMedicale.add(inscription1.getEtudiant());
                    System.out.println(inscription1.getEtudiant());
                }
                beanCollectionDataSource = new JRBeanCollectionDataSource(listeEtudiantNonPayeVisiteMedicale);
                reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ireport/listeEtudiantNonPayeVisiteMedicale.jasper");
                jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
                httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                httpServletResponse.addHeader("Content-disposition", "attachment; filename=listeEtudiantNonPayeVisiteMedicale" + getFormatDocument());
                servletOutputStream = httpServletResponse.getOutputStream();
                JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
                FacesContext.getCurrentInstance().responseComplete();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 700:
                


        }

    }

    public void pdfFiliere() throws IOException, JRException, DataAccessException {
        System.out.println(" Documet et format pour la filiere");
        System.out.println("document :" + getChoixFiliere()+ " format :" + getFormatDocument());
        List<Inscription> etudiants;
        JRBeanCollectionDataSource beanCollectionDataSource;
        String reportPath;
        JasperPrint jasperPrint;
        HttpServletResponse httpServletResponse;
        ServletOutputStream servletOutputStream;
        switch (choixFiliere) {

            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                etudiants = new ArrayList<Inscription>();
                etudiants = inscriptionService.findInscriptionByFiliere(filiereService.findFiliereById(5L));
                listeEtudiantINFOTEL = new ArrayList<Etudiant>();
                for (Inscription inscription1 : etudiants) {
                    listeEtudiantINFOTEL.add(inscription1.getEtudiant());
                    System.out.println(inscription1.getEtudiant());
                }
                beanCollectionDataSource = new JRBeanCollectionDataSource(listeEtudiantINFOTEL);
                reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/ireport/listeEtudiantINFOTEL.jasper");
                jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
                httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                httpServletResponse.addHeader("Content-disposition", "attachment; filename=listeEtudiantINFOTEL" + getFormatDocument());
                servletOutputStream = httpServletResponse.getOutputStream();
                JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
                FacesContext.getCurrentInstance().responseComplete();
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;


        }

    }
}
