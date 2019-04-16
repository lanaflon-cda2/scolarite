/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.AnneeAccademique;
import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.Filiere;
import cm.uma.iss.scolarite.entities.Inscription;
import cm.uma.iss.scolarite.entities.Niveau;
import cm.uma.iss.scolarite.entities.Option1;
import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.entities.Promotion;
import cm.uma.iss.scolarite.entities.RegionOrigine;
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
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
public class ImportationBean {

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
    private boolean skip;
    private String anneeAcc = null;
    private static String anneeAccSelect;

    public ImportationBean() {
    }

    //getters and setters
    public String getAnneeAccSelect() {
        return anneeAccSelect;
    }

    public void setAnneeAccSelect(String anneeAccSelect) {
        ImportationBean.anneeAccSelect = anneeAccSelect;
    }

    public String getAnneeAcc() {
        System.out.println(anneeAcc);
        return anneeAcc;
    }

    public void setAnneeAcc(String anneeAcc) {
        this.anneeAcc = anneeAcc;
    }

    public boolean isSkip() {
        System.out.println("" + anneeAcc);
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
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

    public IPaysOrigineService getOrigineService() {
        return paysOrigineService;
    }

    public void setOrigineService(IPaysOrigineService paysOrigineService) {
        this.paysOrigineService = paysOrigineService;
    }

    public IEtudiantService getEtudiantService() {
        return etudiantService;
    }

    public void setEtudiantService(IEtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    public String onFlowProcess(FlowEvent event) {
//        if (skip) {
//            skip = false;   //reset in case user goes back  
//            return anneeAcc;
//        } else {
        ImportationBean.anneeAccSelect = anneeAccademique.getAnnee();
        System.out.println("pour " + anneeAccSelect);
        return event.getNewStep();
        //}
    }

    /**
     * Importation des futurs étudiants cette methode permet de lire les données
     * dans un fichier Excel
     *
     * @param event
     * @throws ParseException
     * @throws DataAccessException
     */
    public void handleFileUpload(FileUploadEvent event) throws ParseException, DataAccessException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        int compteur_importation = 0;
        int compteur_mis_a_jour = 0;
        String mat_etud = null;
        Etudiant etudiantRecup = new Etudiant();
        PaysOrigine paysOrigineRecup = new PaysOrigine();
        RegionOrigine regionOrigineRecup = new RegionOrigine();
        Cycle cycleRecup = new Cycle();
        Niveau niveauRecup = new Niveau();
        Filiere filiereRecup = new Filiere();
        Option1 option1Recup = new Option1();
        if (event.getFile() == null) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le fichier est vide", ""));
        }

        InputStream file;
        HSSFWorkbook workbook = null;
        try {
            file = event.getFile().getInputstream();
            workbook = new HSSFWorkbook(file);
        } catch (IOException e) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur lors de la lecture du fichier" + e, ""));
        }

        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            System.out.println("Ligne numero: " + row.getRowNum());
            if (row.getRowNum() == 0) {
                continue;
            }

            Iterator<Cell> cellIterator = row.cellIterator();
            Etudiant etudiant = new Etudiant();
            Inscription inscription = new Inscription();
            String nom_pays = null;
            String nom_filiere = null;
            String nom_cycle = null;
            String nom_region = null;
            String nom_departement = null;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                System.out.println("colonne numero: " + cell.getColumnIndex() + "  " + cell);
                switch (cell.getColumnIndex()) {
                    case 0:
                        etudiantRecup.setNumero((int) cell.getNumericCellValue());
                        etudiant.setNumero((int) cell.getNumericCellValue());
                        break;
                    case 1:
                        String matricule = cell.getStringCellValue();
                        if (matricule.toCharArray().length == 0) {
                            etudiantRecup.setMatricule("####" + row.getRowNum());
                            etudiant.setMatricule("####" + row.getRowNum());
                        } else {
                        etudiantRecup.setMatricule(matricule);
                        etudiant.setMatricule(cell.getStringCellValue());
                        }
                        break;
                    case 2:
                        etudiantRecup.setNom(cell.getStringCellValue().toUpperCase());
                        etudiant.setNom(cell.getStringCellValue().toUpperCase());
                        break;
                    case 3:
                        String date_naiss = null;
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:
                                date_naiss = cell.getStringCellValue();
                                etudiantRecup.setDate_naiss(cell.getStringCellValue());
                                etudiant.setDate_naiss(cell.getStringCellValue());
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    String motif = "dd/MM/yyyy";
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(motif);
                                    date_naiss = "" + simpleDateFormat.format(cell.getDateCellValue());
                                    etudiantRecup.setDate_naiss(date_naiss);
                                    etudiant.setDate_naiss(date_naiss);
                                }
                                break;
                            default:
                        }
                        break;
                    case 4:
                        String lieu_naiss = cell.getStringCellValue().toUpperCase();
                        etudiantRecup.setLieu_naiss(lieu_naiss);
                        etudiant.setLieu_naiss(lieu_naiss);
                        break;
                    case 5:
                        String genre = cell.getStringCellValue().toUpperCase();
                        etudiantRecup.setGenre(genre);
                        etudiant.setGenre(genre);
                        break;
                    case 6:
                        PaysOrigine paysOrigine = new PaysOrigine();
                        String pays = cell.getStringCellValue();
                        nom_pays = pays;
                        paysOrigineRecup.setNom_pays(cell.getStringCellValue().toUpperCase());
                        PaysOrigine paysOrigine1 = paysOrigineService.getPaysByNom(pays);
                        if (paysOrigine1 == null) {
                            paysOrigine.setNom_pays(pays.toUpperCase());
                            paysOrigineService.registerPays(paysOrigine);
                        } else {
                            paysOrigine1.setNom_pays(paysOrigineRecup.getNom_pays());
                            paysOrigineService.updatePays(paysOrigine1);

                        }
                        etudiant.setPaysOrigine(paysOrigineService.getPaysByNom(pays));
                        break;
                    case 7:
                        RegionOrigine regionOrigine = new RegionOrigine();
                        String region = cell.getStringCellValue();
                        regionOrigineRecup.setNom_regionOrigine(cell.getStringCellValue().toUpperCase());
                        RegionOrigine regionOrigine1 = regionOrigineService.findRegionOrigineByNom(cell.getStringCellValue());
                        if (regionOrigine1 == null) {
                            regionOrigine.setNom_regionOrigine(region.toUpperCase());
                            regionOrigine.setPaysOrigine(paysOrigineService.getPaysByNom(nom_pays));
                            regionOrigineService.registerRegionOrigine(regionOrigine);
                        } else {
                            regionOrigine1.setNom_regionOrigine(regionOrigineRecup.getNom_regionOrigine());
                            regionOrigineService.updateRegionOrigine(regionOrigine1);

                        }
                        etudiant.setRegionOrigine(regionOrigineService.findRegionOrigineByNom(cell.getStringCellValue()));
                        break;
                    case 8:
                        Filiere filiere = new Filiere();
                        String filiere1 = cell.getStringCellValue().toUpperCase();
                        nom_filiere = filiere1;
                        filiereRecup.setNom_filiere(cell.getStringCellValue().toUpperCase());
                        Filiere filiere2 = filiereService.findFiliereByNom(cell.getStringCellValue());
                        if (filiere2 == null) {
                            filiere.setNom_filiere(filiere1);
                            filiere.setSigle_filiere(filiere1);
                            filiereService.registerFiliere(filiere);
                        } else {
                            filiere2.setNom_filiere(filiereRecup.getNom_filiere().toUpperCase());
                            filiereService.updateFiliere(filiere2);
                        }
                        //filiereService.registerFiliere(filiere);
                        inscription.setFiliere(filiereService.findFiliereByNom(filiere1));
                        break;
                    case 9:
                        Niveau niveau = new Niveau();
                        Cycle cycle = new Cycle();
                        String cycle1;
                        String niveau1 = cell.getStringCellValue();
                        niveauRecup.setNom_niveau(cell.getStringCellValue().toUpperCase());
                        niveau.setCycle(cycleService.findCycleByNom(nom_cycle));
                        String premierCaratere = niveau1.charAt(0) + "";
                        System.out.println("/////////////" + premierCaratere + "////////////////////");
                        if (premierCaratere.equalsIgnoreCase("l")) {
                            cycle1 = premierCaratere.concat("icence");
                            System.out.println(">>>>>>>" + cycle1);
                        } else if (premierCaratere.equalsIgnoreCase("m")) {
                            cycle1 = premierCaratere.concat("aster");
                            System.out.println(">>>>>>>" + cycle1);
                        } else {
                            cycle1 = premierCaratere.concat("RAS");
                            System.out.println("RAS=======>> " + cycle1);
                        }
                        cycleRecup.setNom_cycle(cycle1.toUpperCase());
                        Cycle cycle2 = cycleService.findCycleByNom(cycle1);
                        if (cycle2 == null) {
                            cycle.setNom_cycle(cycle1.toUpperCase());
                            cycleService.registerCycle(cycle);

                        } else {
                            cycle2.setNom_cycle(cycleRecup.getNom_cycle());
                            cycleService.updateCycle(cycle2);

                        }

                        Niveau niveau2 = niveauService.findNiveauByNom(cell.getStringCellValue());
                        if (niveau2 == null) {
                            //cycleService.registerCycle(cycle);
                            niveau.setCycle(cycleService.findCycleByNom(cycle1));
                            niveau.setNom_niveau(niveau1.toUpperCase());
                            niveauService.registerNiveau(niveau);
                        } else {
                            niveau2.setNom_niveau(niveauRecup.getNom_niveau());
                            niveauService.updateNiveau(niveau2);
                        }
                        inscription.setCycle(cycleService.findCycleByNom(cycle1));
                        inscription.setNiveau(niveauService.findNiveauByNom(niveau1));
                        break;
                    case 10:
                        Option1 option1 = new Option1();
                        String option11 = cell.getStringCellValue();
                        option1Recup.setNom_option1(cell.getStringCellValue().toUpperCase());
                        option1.setFiliere(filiereService.findFiliereByNom(nom_filiere));
                        Option1 option2 = option1Service.findOptionbyNom(cell.getStringCellValue());
                        if (option2 == null) {
                            option1.setNom_option1(option11.toUpperCase());
                            option1Service.registerOption1(option1);

                        } else {
                            option2.setNom_option1(option1Recup.getNom_option1().toUpperCase());
                            option1Service.updateOption1(option2);
                        }
                        inscription.setOption1(option1Service.findOptionbyNom(option11));
                        break;
                    case 11:
                        String observation = cell.getStringCellValue();
                        etudiantRecup.setObservation(observation.toUpperCase());
                        etudiant.setObservation(observation.toUpperCase());
                        break;
                }

            }
            System.out.println(etudiantRecup.getMatricule() + " matricule etudiantRecuperé " + etudiantRecup.getNom() + " Nom etudiantRecuperé");
            Etudiant etudiant_bd = etudiantService.findEtudiantByMatricule(etudiantRecup.getMatricule());
            System.out.println(etudiant_bd + "est l'tudiant correspondant au matricule  " + mat_etud);
            Inscription inscription_bd = inscriptionService.findInscriptionByEtudiant(etudiant_bd);
            System.out.println(inscription_bd + " correspondante au matricule  " + mat_etud);
            if (etudiant_bd == null) {
                try {
                    etudiantService.registerEtudiant(etudiant);
                    inscription.setEtudiant(etudiant);
                    System.out.println("annéé acc selectionnée: " + ImportationBean.anneeAccSelect);
                    inscription.setAnneeAccademique(anneeAccademiqueService.findAnneeByAnnee(ImportationBean.anneeAccSelect));
                    inscription.setDate_inscription("" + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()));
                    inscriptionService.registerInscription(inscription);
                } catch (DataAccessException ex) {
                    ex.printStackTrace();
                }
                compteur_importation++;
            } else {
                etudiant_bd.setNumero(etudiantRecup.getNumero());
                etudiant_bd.setNom(etudiantRecup.getNom());
                etudiant_bd.setPrenom(etudiantRecup.getPrenom());
                etudiant_bd.setDate_naiss(etudiantRecup.getDate_naiss());
                etudiant_bd.setLieu_naiss(etudiantRecup.getLieu_naiss());
                etudiant_bd.setGenre(etudiantRecup.getGenre());
                etudiant_bd.setEmail(etudiantRecup.getEmail());
                etudiant_bd.setObservation(etudiantRecup.getObservation());
                etudiant_bd.setStatut_matri(etudiantRecup.getStatut_matri());
                etudiant_bd.setTelephone(etudiantRecup.getTelephone());
                etudiant_bd.setTuteur(etudiantRecup.getTuteur());
                etudiant_bd.setRegionOrigine(regionOrigineService.findRegionOrigineByNom(regionOrigineRecup.getNom_regionOrigine()));
                etudiant_bd.setPaysOrigine(paysOrigineService.getPaysByNom(paysOrigineRecup.getNom_pays()));
                etudiantService.updateEtudiant(etudiant_bd);
                inscription_bd.setAnneeAccademique(anneeAccademiqueService.findAnneeByAnnee(ImportationBean.anneeAccSelect));
                inscription_bd.setCycle(cycleService.findCycleByNom(cycleRecup.getNom_cycle()));
                inscription_bd.setNiveau(niveauService.findNiveauByNom(niveauRecup.getNom_niveau()));
                //inscription_bd.setFiliere(filiereService.findFiliereByNom(filiereRecup.getNom_filiere()));
                inscription_bd.setOption1(option1Service.findOptionbyNom(option1Recup.getNom_option1()));
                inscriptionService.updateInscription(inscription_bd);
                compteur_mis_a_jour++;
            }

        }
        if ((compteur_mis_a_jour != 0) && (compteur_importation != 0)) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "" + compteur_importation + " etudiant(s) importé(s) et " + compteur_mis_a_jour + " etudiant(s) mis à jour", ""));
        } else if (compteur_mis_a_jour != 0) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "" + compteur_mis_a_jour + " etudiant(s) mis à jour", ""));
        } else {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "" + compteur_importation + " etudiant(s) importé(s)", ""));
        }

    }

}
