/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.AnneeAccademique;
import cm.uma.iss.scolarite.entities.ArrondissementOrigine;
import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.DepartementOrigine;
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
import cm.uma.iss.scolarite.services.ICycleService;
import cm.uma.iss.scolarite.services.IDocumentService;
import cm.uma.iss.scolarite.services.IEtudiantService;
import cm.uma.iss.scolarite.services.IFiliereService;
import cm.uma.iss.scolarite.services.IInscriptionService;
import cm.uma.iss.scolarite.services.INiveauService;
import cm.uma.iss.scolarite.services.IRetraitRetourDocService;
import com.douwe.generic.dao.DataAccessException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ngnawen
 */
//@ViewScoped
@ManagedBean
@RequestScoped
public class EtudiantBean {

    /**
     * Creates a new instance of EtudiantBean
     *
     */
    //declaration des IServices et des entities
    @ManagedProperty(value = "#{IRetraitRetourDocService}")
    private IRetraitRetourDocService retraitRetourDocService;
    @ManagedProperty(value = "#{IEtudiantService}")
    private IEtudiantService etudiantService;
    @ManagedProperty(value = "#{IInscriptionService}")
    private IInscriptionService inscriptionService;
    @ManagedProperty(value = "#{IDocumentService}")
    private IDocumentService documentService;
    @ManagedProperty(value = "#{IFiliereService}")
    private IFiliereService filiereService;
    @ManagedProperty(value = "#{INiveauService}")
    private INiveauService niveauService;
    @ManagedProperty(value = "#{ICycleService}")
    private ICycleService cycleService;
    private Etudiant etudiant = new Etudiant();
    private Inscription inscription = new Inscription();
    private AnneeAccademique anneeAccademique = new AnneeAccademique();
    private RegionOrigine regionOrigine = new RegionOrigine();
    private DepartementOrigine departementOrigine = new DepartementOrigine();
    private ArrondissementOrigine arrondissementOrigine = new ArrondissementOrigine();
    private PaysOrigine paysOrigine = new PaysOrigine();
    private Cycle cycle = new Cycle();
    private Niveau niveau = new Niveau();
    private Filiere filiere = new Filiere();
    private Option1 option1 = new Option1();
    private Promotion promotion = new Promotion();
    private Etudiant etudiantChoisi;
    private List<Etudiant> etudiantList = new ArrayList<Etudiant>();
    private boolean skip;
    Date date = Calendar.getInstance().getTime();
    private String documentChoisi;
    private String formatDocument;
    private String tailleEtudiant = "0";
    private Date dateNaissRecuperee = null;
    private Etudiant etudiantSelectionner;
    private String typeDoc = null;
    private Integer total = 0;
    private static List<Etudiant> listes;//liste en fonction des retrait et retour des coupons de paiement
    private static List<RetraitRetourDoc> listeRetraitRetoursDoc;

    //private static final Logger logger = Logger.getLogger(EtudiantBean.class.getName());
    // les constructeurs
    public EtudiantBean() {
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public IFiliereService getFiliereService() {
        return filiereService;
    }

    public void setFiliereService(IFiliereService filiereService) {
        this.filiereService = filiereService;
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

    public String getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }

    //getters and setters
    public IDocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(IDocumentService documentService) {
        this.documentService = documentService;
    }

    public List<Etudiant> getListes() {
        // listes=new ArrayList<Etudiant>();
        return listes;
    }

    public void setListes(List<Etudiant> listes) {
        EtudiantBean.listes = listes;
    }

    public List<RetraitRetourDoc> getListeRetraitRetoursDoc() {
        return listeRetraitRetoursDoc;
    }

    public void setListeRetraitRetoursDoc(List<RetraitRetourDoc> listeRetraitRetoursDoc) {
        EtudiantBean.listeRetraitRetoursDoc = listeRetraitRetoursDoc;
    }
    
    

    public Etudiant getEtudiantSelectionner() {
        return etudiantSelectionner;
    }

    public void setEtudiantSelectionner(Etudiant etudiantSelectionner) {
        this.etudiantSelectionner = etudiantSelectionner;
    }

    public Date getDateNaissRecuperee() {
        return dateNaissRecuperee;
    }

    public void setDateNaissRecuperee(Date dateNaissRecuperee) {
        this.dateNaissRecuperee = dateNaissRecuperee;
    }

    public String getDocumentChoisi() {
        return documentChoisi;
    }

    public void setDocumentChoisi(String documentChoisi) {
        this.documentChoisi = documentChoisi;
    }

    public String getFormatDocument() {
        return formatDocument;
    }

    public void setFormatDocument(String formatDocument) {
        this.formatDocument = formatDocument;
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

    public DepartementOrigine getDepartementOrigine() {
        return departementOrigine;
    }

    public void setDepartementOrigine(DepartementOrigine departementOrigine) {
        this.departementOrigine = departementOrigine;
    }

    public ArrondissementOrigine getArrondissementOrigine() {
        return arrondissementOrigine;
    }

    public void setArrondissementOrigine(ArrondissementOrigine arrondissementOrigine) {
        this.arrondissementOrigine = arrondissementOrigine;
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

    public Etudiant getEtudiantChoisi() {
        return etudiantChoisi;
    }

    public void setEtudiantChoisi(Etudiant etudiantChoisi) {
        this.etudiantChoisi = etudiantChoisi;
    }

    public IEtudiantService getEtudiantService() {
        return etudiantService;
    }

    public void setEtudiantService(IEtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public List<Etudiant> getEtudiantList() {
        try {
            etudiantList = new ArrayList<Etudiant>();
            etudiantList.addAll(etudiantService.findAllEtudiant());
            return etudiantList;
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @return
     */
    public String getTailleEtudiant() {
        try {
            etudiantList = new ArrayList<Etudiant>();
            etudiantList.addAll(etudiantService.findAllEtudiant());
            tailleEtudiant = etudiantList.size() + "";
            return tailleEtudiant;
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    public void setTailleEtudiant(String tailleEtudiant) {
        this.tailleEtudiant = tailleEtudiant;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public IInscriptionService getInscriptionService() {
        return inscriptionService;
    }

    public void setInscriptionService(IInscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public IRetraitRetourDocService getRetraitRetourDocService() {
        return retraitRetourDocService;
    }

    public void setRetraitRetourDocService(IRetraitRetourDocService retraitRetourDocService) {
        this.retraitRetourDocService = retraitRetourDocService;
    }

    
    
    /**
     * methodes d'enregistrement d'un etudiant
     */
    public void enregistrer() throws DataAccessException {
        try {
            String nom_etudiant = etudiant.getNom();
            String motif = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(motif);
            String date_naiss = "" + simpleDateFormat.format(dateNaissRecuperee);
            System.out.println(date_naiss);
            etudiant.setDate_naiss(date_naiss);
            etudiant.setNom(etudiant.getNom().toUpperCase() + " " + etudiant.getPrenom().toUpperCase());
            etudiantService.registerEtudiant(etudiant);
            inscription.setAnneeAccademique(anneeAccademique);
            inscription.setCycle(cycle);
            inscription.setEtudiant(etudiant);
            inscription.setFiliere(filiere);
            inscription.setNiveau(niveau);
            inscription.setOption1(option1);
            inscription.setDate_inscription("" + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()));
            inscriptionService.registerInscription(inscription);
            FacesMessage msg = new FacesMessage(nom_etudiant.toUpperCase() + " \nEnregistré avec succès");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            //e.printStackTrace();
        }

    }

    public void supprimer() {

        try {
            if (etudiantChoisi.getId_etudiant() != null) {
                etudiantService.deleteEtudiant(etudiantChoisi.getId_etudiant());
                FacesMessage msg = new FacesMessage(" Suppression avec succès ");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
            }

        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back  
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public void editRowListner(RowEditEvent rowEditEvent) {
        try {
            Etudiant updatedEtudiant = (Etudiant) rowEditEvent.getObject();
            etudiantService.updateEtudiant(updatedEtudiant);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Update called", "updated by user"));
        } catch (Exception ex) {
            ex.getMessage();
        }

    }
    // @PostConstruct
    
    
/**
 * affichage du controle des retraits etpons retours des coupons
 */
    public void affichageListeistePaiement() {
        System.out.println("type document==========>" + getTypeDoc());
//        System.out.println("cycle " + cycle.getNom_cycle());
//        System.out.println("Niveau " + niveau.getNom_niveau());
//        System.out.println("filiere " + filiere.getNom_filiere());
        try {
            if (typeDoc.equals("0")) {
                listeRetraitRetoursDoc = new ArrayList<RetraitRetourDoc>();
                total = listes.size();
                System.out.println(".............Rien...............");
            } else if (typeDoc.equals("cvm1")) {
//                retrait du coupon de visite médicale
                Documents doc = documentService.findDocumentByType("COUPON VISITE MEDICALE");
                System.out.println("Document=========> "+doc);
                listeRetraitRetoursDoc = retraitRetourDocService.findRetraitByDocument(doc);
                total = listeRetraitRetoursDoc.size();
                System.out.println("Retrait coupon de visite médicale");
            } else if (typeDoc.equals("cp1")) {
//                retrait du coupon de préinscription
                Documents doc = documentService.findDocumentByType("COUPON PREINSCRIPTION");
                listeRetraitRetoursDoc = retraitRetourDocService.findRetraitByDocument(doc);
                total = listeRetraitRetoursDoc.size();
                System.out.println("Retrait coupon de préinscription");
            } else if (typeDoc.equals("cvm-cp1")) {
//                retrait du coupon de visite médicale et de préincription
                System.out.println("Retrait coupon de visite medicale et de préinscription");
            } else if (typeDoc.equals("ct11")) {
                Documents doc = documentService.findDocumentByType("COUPON PREMIERE TRANCHE");
                listeRetraitRetoursDoc = retraitRetourDocService.findRetraitByDocument(doc);
                total = listeRetraitRetoursDoc.size();
                System.out.println("Retrait coupon de premeiere tranche");
            } else if (typeDoc.equals("ct21")) {
                Documents doc = documentService.findDocumentByType("COUPON DEUXIEME TRANCHE");
                listeRetraitRetoursDoc = retraitRetourDocService.findRetraitByDocument(doc);
                total = listeRetraitRetoursDoc.size();
                System.out.println("Retrait coupon de deuxieme tranche");
            } else if (typeDoc.equals("ct1-ct21")) {
                System.out.println("Retrait coupon de premiere et de deuxieme tranche");
                
            } else if (typeDoc.equals("cvm2")) {
//                Retour du coupon de visite médicale
                Documents doc1 = documentService.findDocumentByType("COUPON VISITE MEDICALE");
                System.out.println("Document=========>"+doc1);
                listeRetraitRetoursDoc = retraitRetourDocService.findRetourByDocument(doc1);
                total = listeRetraitRetoursDoc.size();
                System.out.println("Retour coupon de visite médicale");
            } else if (typeDoc.equals("cp2")) {
                Documents doc1 = documentService.findDocumentByType("COUPON VISITE MEDICALE");
                listeRetraitRetoursDoc = retraitRetourDocService.findRetourByDocument(doc1);
                total = listeRetraitRetoursDoc.size();
                System.out.println("Retour coupon de préinscription");
            } else if (typeDoc.equals("cvm-cp2")) {
                Documents doc = documentService.findDocumentByType("COUPON VISITE MEDICALE");
                listes = etudiantService.findEtudiantbyDocument(doc);
                total = listes.size();
                System.out.println("Retour  coupon de visite médicale et de préinscription");
            } else if (typeDoc.equals("ct12")) {
                Documents doc2 = documentService.findDocumentByType("COUPON VISITE MEDICALE");
                listeRetraitRetoursDoc = retraitRetourDocService.findRetourByDocument(doc2);
                total = listeRetraitRetoursDoc.size();
                System.out.println("Retour  coupon de premiere tranche");
            } else if (typeDoc.equals("ct22")) {
                Documents doc3 = documentService.findDocumentByType("COUPON VISITE MEDICALE");
                listeRetraitRetoursDoc = retraitRetourDocService.findRetourByDocument(doc3);
                total = listeRetraitRetoursDoc.size();
                System.out.println("Retour  coupon de deuxieme tranche");
            } else if (typeDoc.equals("ct1-ct22")) {
                Documents doc4 = documentService.findDocumentByType("COUPON VISITE MEDICALE");
                listeRetraitRetoursDoc = retraitRetourDocService.findRetourByDocument(doc4);
                total = listeRetraitRetoursDoc.size();
                System.out.println("Retour coupon premiere et deuxieme tranche");
            } else {
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(EtudiantBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        CellStyle style = wb.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
        for (Row row : sheet) {
            for (Cell cell : row) {
                cell.setCellValue(cell.getStringCellValue().toUpperCase());
                cell.setCellStyle(style);
            }
        }
    }
//    public void init() throws JRException {
//        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(etudiantList);
//        jasperPrint = JasperFillManager.fillReport("/home/ngnawen/listeEtudiant.jasper", new HashMap(), beanCollectionDataSource);
//
//    }
//
//    public void pdf(ActionEvent actionEvent) throws JRException, IOException {
//        init();
//        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        httpServletResponse.addHeader("content-disposition", "attachment;filename=listeEtudiant.pdf");
//        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
//        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
////        facesContext.responseComplete();
////        facesContext.renderResponse();
//    }
}
