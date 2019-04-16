/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.AnneeAccademique;
import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.Filiere;
import cm.uma.iss.scolarite.entities.Inscription;
import cm.uma.iss.scolarite.entities.projection.CycleFiliereAge;
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
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@SessionScoped
public class StatTrancheAgeBean {

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
    private Filiere filiere = new Filiere();
    private AnneeAccademique anneeAccademique = new AnneeAccademique();
    private List<CycleFiliereAge> cycle1EffAges;
    private List<CycleFiliereAge> cycle2EffAges;
    private List<Inscription> inscriptions;
    private List<Inscription> inscriptions1;
    private int tage1520 = 0;
    private int tage2025 = 0;
    private int tage2530 = 0;
    private int tage3035 = 0;
    private int tage35Plus = 0;
    private int ttotal = 0;
    private int tage15201 = 0;
    private int tage20251 = 0;
    private int tage25301 = 0;
    private int tage30351 = 0;
    private int tage35Plus1 = 0;
    private int ttotal1 = 0;
    private int totalGeneral = 0;

    public StatTrancheAgeBean() {
    }

    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public void setAnneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
    }

    public int getTotalGeneral() {
        return totalGeneral;
    }

    public void setTotalGeneral(int totalGeneral) {
        this.totalGeneral = totalGeneral;
    }

    public int getTage15201() {
        return tage15201;
    }

    public void setTage15201(int tage15201) {
        this.tage15201 = tage15201;
    }

    public int getTage20251() {
        return tage20251;
    }

    public void setTage20251(int tage20251) {
        this.tage20251 = tage20251;
    }

    public int getTage25301() {
        return tage25301;
    }

    public void setTage25301(int tage25301) {
        this.tage25301 = tage25301;
    }

    public int getTage30351() {
        return tage30351;
    }

    public void setTage30351(int tage30351) {
        this.tage30351 = tage30351;
    }

    public int getTage35Plus1() {
        return tage35Plus1;
    }

    public void setTage35Plus1(int tage35Plus1) {
        this.tage35Plus1 = tage35Plus1;
    }

    public int getTtotal1() {
        return ttotal1;
    }

    public void setTtotal1(int ttotal1) {
        this.ttotal1 = ttotal1;
    }

    public List<Inscription> getInscriptions1() {
        return inscriptions1;
    }

    public void setInscriptions1(List<Inscription> inscriptions1) {
        this.inscriptions1 = inscriptions1;
    }

    public int getTage1520() {
        return tage1520;
    }

    public void setTage1520(int tage1520) {
        this.tage1520 = tage1520;
    }

    public int getTage2025() {
        return tage2025;
    }

    public void setTage2025(int tage2025) {
        this.tage2025 = tage2025;
    }

    public int getTage2530() {
        return tage2530;
    }

    public void setTage2530(int tage2530) {
        this.tage2530 = tage2530;
    }

    public int getTage3035() {
        return tage3035;
    }

    public void setTage3035(int tage3035) {
        this.tage3035 = tage3035;
    }

    public int getTage35Plus() {
        return tage35Plus;
    }

    public void setTage35Plus(int tage35Plus) {
        this.tage35Plus = tage35Plus;
    }

    public int getTtotal() {
        return ttotal;
    }

    public void setTtotal(int ttotal) {
        this.ttotal = ttotal;
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

    public List<CycleFiliereAge> getCycle1EffAges() {
        return cycle1EffAges;
    }

    public void setCycle1EffAges(List<CycleFiliereAge> cycle1EffAges) {
        this.cycle1EffAges = cycle1EffAges;
    }

    public List<CycleFiliereAge> getCycle2EffAges() {
        return cycle2EffAges;
    }

    public void setCycle2EffAges(List<CycleFiliereAge> cycle2EffAges) {
        this.cycle2EffAges = cycle2EffAges;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    //@PostConstruct
    public void statFiliereAge() {
        System.out.println("Statistique par filière et tranche d'age");
        String annee = anneeAccademique.getAnnee();
        System.out.println(" " + annee);
        try {
            AnneeAccademique anAc = anneeAccademiqueService.findAnneeByAnnee(annee);
            Calendar date = Calendar.getInstance();
            cycle1EffAges = new ArrayList<CycleFiliereAge>();
            cycle2EffAges = new ArrayList<CycleFiliereAge>();
            tage1520 = 0;
            tage2025 = 0;
            tage2530 = 0;
            tage3035 = 0;
            tage35Plus = 0;
            ttotal = 0;
            tage15201 = 0;
            tage20251 = 0;
            tage25301 = 0;
            tage30351 = 0;
            tage35Plus1 = 0;
            ttotal1 = 0;
            totalGeneral =0;
            Cycle cycle1 = cycleService.findCycleByNom("LICENCE");
            Cycle cycle2 = cycleService.findCycleByNom("MASTER");
            List<Filiere> filieres1 = filiereService.findAllFiliere();
            for (Filiere filiere1 : filieres1) {
                inscriptions = inscriptionService.findInscriptionByFiliereCycleAnnee(filiere1, cycle1, anAc);
                inscriptions1 = inscriptionService.findInscriptionByFiliereCycleAnnee(filiere1, cycle2, anAc);
                int age1520 = 0;
                int age2025 = 0;
                int age2530 = 0;
                int age3035 = 0;
                int age35Plus = 0;
                int total = 0;
                int age15201 = 0;
                int age20251 = 0;
                int age25301 = 0;
                int age30351 = 0;
                int age35Plus1 = 0;
                int total1 = 0;
                int anneeActuelle = date.get(Calendar.YEAR);
                for (Inscription in : inscriptions) {
                    String an = in.getEtudiant().getDate_naiss().substring(6);
                    //System.out.println(in.getEtudiant().getMatricule() + " " + in.getEtudiant().getDate_naiss() + "  " + in.getEtudiant().getNom());
                    int anneeNaiss = Integer.parseInt(an);
                    //System.out.println("" + anneeNaiss);
                    int ageEtudiant = anneeActuelle - anneeNaiss;
                    if (ageEtudiant == 15 || ageEtudiant == 16 || ageEtudiant == 17 || ageEtudiant == 18 || ageEtudiant == 19) {
                        age1520++;
                    } else if (ageEtudiant == 20 || ageEtudiant == 21 || ageEtudiant == 22 || ageEtudiant == 23 || ageEtudiant == 24) {
                        age2025++;
                    } else if (ageEtudiant == 25 || ageEtudiant == 26 || ageEtudiant == 27 || ageEtudiant == 28 || ageEtudiant == 29) {
                        age2530++;
                    } else if (ageEtudiant == 30 || ageEtudiant == 31 || ageEtudiant == 32 || ageEtudiant == 33 || ageEtudiant == 34) {
                        age3035++;
                    } else {
                        age35Plus++;
                    }
                    total = age1520 + age2025 + age2530 + age3035 + age35Plus;

                }
                tage1520 = tage1520 + age1520;
                tage2025 = tage2025 + age2025;
                tage2530 = tage2530 + age2530;
                tage3035 = tage3035 + age3035;
                tage35Plus = tage35Plus + age35Plus;
                ttotal = tage1520 + tage2025 + tage2530 + tage3035 + tage35Plus;
                for (Inscription in1 : inscriptions1) {
                    String an = in1.getEtudiant().getDate_naiss().substring(6);
                    int anneeNaiss = Integer.parseInt(an);
                    //System.out.println("" + anneeNaiss);
                    int ageEtudiant = anneeActuelle - anneeNaiss;
                    if (ageEtudiant == 15 || ageEtudiant == 16 || ageEtudiant == 17 || ageEtudiant == 18 || ageEtudiant == 19) {
                        age15201++;
                    } else if (ageEtudiant == 20 || ageEtudiant == 21 || ageEtudiant == 22 || ageEtudiant == 23 || ageEtudiant == 24) {
                        age20251++;
                    } else if (ageEtudiant == 25 || ageEtudiant == 26 || ageEtudiant == 27 || ageEtudiant == 28 || ageEtudiant == 29) {
                        age25301++;
                    } else if (ageEtudiant == 30 || ageEtudiant == 31 || ageEtudiant == 32 || ageEtudiant == 33 || ageEtudiant == 34) {
                        age30351++;
                    } else {
                        age35Plus1++;
                    }
                    total1 = age15201 + age20251 + age25301 + age30351 + age35Plus1;

                }
                tage15201 = tage15201 + age15201;
                tage20251 = tage20251 + age20251;
                tage25301 = tage25301 + age25301;
                tage30351 = tage30351 + age30351;
                tage35Plus1 = tage35Plus1 + age35Plus1;
                ttotal1 = tage15201 + tage20251 + tage25301 + tage30351 + tage35Plus1;
                cycle1EffAges.add(new CycleFiliereAge(cycle1.getNom_cycle(), filiere1.getNom_filiere(), age1520, age2025, age2530, age3035, age35Plus, total));
                cycle2EffAges.add(new CycleFiliereAge(cycle2.getNom_cycle(), filiere1.getNom_filiere(), age15201, age20251, age25301, age30351, age35Plus1, total1));
                totalGeneral = ttotal + ttotal1;
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(StatTrancheAgeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
