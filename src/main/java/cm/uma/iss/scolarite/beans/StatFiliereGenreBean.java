/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.AnneeAccademique;
import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.Filiere;
import cm.uma.iss.scolarite.entities.Inscription;
import cm.uma.iss.scolarite.entities.projection.CycleFiliereEffectif;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@SessionScoped
public class StatFiliereGenreBean {

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
    Filiere filiere = new Filiere();
    private List<CycleFiliereEffectif> effectifs;
    private int listeChoisie;
    private List<Inscription> inscriptions = new ArrayList<Inscription>();
    private Inscription insc = new Inscription();
    private static List<Inscription> listeInscriptions = new ArrayList<Inscription>();
    private List<CycleFiliereEffectif> cycle1Effectifs;
    private List<CycleFiliereEffectif> cycle2Effectifs;
    private AnneeAccademique anneeAccademique=new AnneeAccademique();
    private Integer totalcycle1 = 0;
    private Integer totalcycle2 = 0;
    private Integer totalGeneral = 0;
    private Integer totalGarconCycle1 = 0;
    private Integer totalFilleCycle1 = 0;
    private Integer totalGarconCycle2 = 0;
    private Integer totalFilleCycle2 = 0;

    /**
     * constructeurs
     */
    public StatFiliereGenreBean() {
    }

    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public void setAnneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
    }

    public Integer getTotalGarconCycle1() {
        return totalGarconCycle1;
    }

    public void setTotalGarconCycle1(Integer totalGarconCycle1) {
        this.totalGarconCycle1 = totalGarconCycle1;
    }

    public Integer getTotalFilleCycle1() {
        return totalFilleCycle1;
    }

    public void setTotalFilleCycle1(Integer totalFilleCycle1) {
        this.totalFilleCycle1 = totalFilleCycle1;
    }

    public Integer getTotalGarconCycle2() {
        return totalGarconCycle2;
    }

    public void setTotalGarconCycle2(Integer totalGarconCycle2) {
        this.totalGarconCycle2 = totalGarconCycle2;
    }

    public Integer getTotalFilleCycle2() {
        return totalFilleCycle2;
    }

    public void setTotalFilleCycle2(Integer totalFilleCycle2) {
        this.totalFilleCycle2 = totalFilleCycle2;
    }

    public Integer getTotalGeneral() {
        return totalGeneral;
    }

    public void setTotalGeneral(Integer totalGeneral) {
        this.totalGeneral = totalGeneral;
    }

    public Integer getTotalcycle2() {
        return totalcycle2;
    }

    public void setTotalcycle2(Integer totalcycle2) {
        this.totalcycle2 = totalcycle2;
    }

    public Integer getTotalcycle1() {
        return totalcycle1;
    }

    public void setTotalcycle1(Integer totalcycle1) {
        this.totalcycle1 = totalcycle1;
    }

    public List<CycleFiliereEffectif> getCycle1Effectifs() {
        return cycle1Effectifs;
    }

    public void setCycle1Effectifs(List<CycleFiliereEffectif> cycle1Effectifs) {
        this.cycle1Effectifs = cycle1Effectifs;
    }

    public List<CycleFiliereEffectif> getCycle2Effectifs() {
        return cycle2Effectifs;
    }

    public void setCycle2Effectiifs(List<CycleFiliereEffectif> cycle2Effectifs) {
        this.cycle2Effectifs = cycle2Effectifs;
    }

    public List<CycleFiliereEffectif> getEffectifs() {
        return effectifs;
    }

    public void setEffectifs(List<CycleFiliereEffectif> effectifs) {
        this.effectifs = effectifs;
    }

    public List<Inscription> getListeInscriptions() {
        return listeInscriptions;
    }

    public void setListeInscriptions(List<Inscription> listeInscriptions) {
        StatFiliereGenreBean.listeInscriptions = listeInscriptions;
    }

    public Inscription getInsc() {
        return insc;
    }

    public void setInsc(Inscription insc) {
        this.insc = insc;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    /**
     * getters and setters
     *
     * @return
     */
    public int getListeChoisie() {
        return listeChoisie;
    }

    public void setListeChoisie(int listeChoisie) {
        this.listeChoisie = listeChoisie;
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

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

   // @PostConstruct
    public void statFiliereCycle1Et2() {
        System.out.println("Statistique par filière et genre");
        String annee = anneeAccademique.getAnnee();
        System.out.println(""+annee);
        try {
            AnneeAccademique an = anneeAccademiqueService.findAnneeByAnnee(annee);
            cycle1Effectifs = new ArrayList<CycleFiliereEffectif>();
            cycle2Effectifs = new ArrayList<CycleFiliereEffectif>();
            totalGarconCycle1=0;
            totalFilleCycle1=0;
            totalcycle1 = 0;
            totalGarconCycle2=0;
            totalFilleCycle2=0;
            totalcycle2 = 0;
            totalGeneral=0;
            Cycle cycle1 = cycleService.findCycleByNom("Licence");
            List<Filiere> filieres1 = filiereService.findAllFiliere();
            for (Filiere filiere1 : filieres1) {
                inscriptions = inscriptionService.findInscriptionByFiliereCycleAnnee(filiere1, cycle1,an);
                int garcon = 0;
                int fille = 0;
                int total = 0;
                for (Inscription in : inscriptions) {
                    if (in.getEtudiant().getGenre().equals("M")) {
                        garcon++;
                    } else {
                        fille++;
                    }
                    total++;
                }
                totalGarconCycle1 = totalGarconCycle1 + garcon;
                totalFilleCycle1 = totalFilleCycle1 + fille;
                totalcycle1 = totalGarconCycle1 + totalFilleCycle1;
                cycle1Effectifs.add(new CycleFiliereEffectif(cycle1.getNom_cycle(), filiere1.getNom_filiere(), garcon, fille, total));
            }
            //totalcycle1 = inscriptionService.findInscriptionByCycle(cycle1).size();
            Cycle cycle2 = cycleService.findCycleByNom("Master");
            List<Filiere> filieres2 = filiereService.findAllFiliere();
            for (Filiere filiere1 : filieres2) {
                inscriptions = inscriptionService.findInscriptionByFiliereCycleAnnee(filiere1, cycle2,an);
                int garcon = 0;
                int fille = 0;
                int total = 0;
                for (Inscription in : inscriptions) {
                    if (in.getEtudiant().getGenre().equals("M")) {
                        garcon++;
                    } else {
                        fille++;
                    }
                    total++;
                }
                totalGarconCycle2 = totalGarconCycle2 + garcon;
                totalFilleCycle2 = totalFilleCycle2 + fille;
                cycle2Effectifs.add(new CycleFiliereEffectif(cycle2.getNom_cycle(), filiere1.getNom_filiere(), garcon, fille, total));
                //totalcycle2 = inscriptionService.findInscriptionByCycle(cycle2).size();
                totalcycle2 = totalGarconCycle2 + totalFilleCycle2;
                
            }
            totalGeneral = totalcycle1 + totalcycle2;
        } catch (DataAccessException ex) {
            Logger.getLogger(StatFiliereGenreBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void postProcessXLS(Object document) {
       HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);

        HSSFCellStyle cellStyle = wb.createCellStyle();
//        cellStyle.setFillForegroundColor(HSSFColor.AQUA.index);
//        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        

        for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
            HSSFCell cell = header.getCell(i);

            cell.setCellStyle(cellStyle);
        }
    }
}
