/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.AnneeAccademique;
import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.Filiere;
import cm.uma.iss.scolarite.entities.Inscription;
import cm.uma.iss.scolarite.entities.Niveau;
import cm.uma.iss.scolarite.entities.projection.CycleEffectif;
import cm.uma.iss.scolarite.entities.projection.NiveauEffetif;
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

/**
 *
 * @author ngnawen
 */
@ManagedBean
@SessionScoped
public class StatistiqueBean {

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
    private List<Inscription> inscriptionAnciens = new ArrayList<Inscription>();
    private List<Inscription> inscriptionNouveaux = new ArrayList<Inscription>();
    private List<Inscription> enregistrements = new ArrayList<Inscription>();
    private List<CycleEffectif> cycleEffectifsAnciens;
    private List<CycleEffectif> cycleEffectifsIss;
    private List<CycleEffectif> cycleEffectifsNouveaux;
    private List<NiveauEffetif> niveauEffectifs;
    private AnneeAccademique anneeAccademique = new AnneeAccademique();
    private int totalGeneral = 0;
    private int totalGeneralA = 0;
    private int totalGeneralN = 0;
    private int totalGeneralFille = 0;
    private int totalGeneralGarcon = 0;
    private int totalGeneralFilleA = 0;
    private int totalGeneralGarconA = 0;
    private int totalGeneralFilleN = 0;
    private int totalGeneralGarconN = 0;

    ;
    /**
     * constructeurs
     */
    public StatistiqueBean() {
    }

    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public void setAnneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
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

    public List<Inscription> getInscriptionAnciens() {
        return inscriptionAnciens;
    }

    public void setInscriptionAnciens(List<Inscription> inscriptionAnciens) {
        this.inscriptionAnciens = inscriptionAnciens;
    }

    public List<Inscription> getInscriptionNouveaux() {
        return inscriptionNouveaux;
    }

    public void setInscriptionNouveaux(List<Inscription> inscriptionNouveaux) {
        this.inscriptionNouveaux = inscriptionNouveaux;
    }

    public List<Inscription> getEnregistrements() {
        return enregistrements;
    }

    public void setEnregistrements(List<Inscription> enregistrements) {
        this.enregistrements = enregistrements;
    }

    public List<CycleEffectif> getCycleEffectifsAnciens() {
        return cycleEffectifsAnciens;
    }

    public void setCycleEffectifsAnciens(List<CycleEffectif> cycleEffectifsAnciens) {
        this.cycleEffectifsAnciens = cycleEffectifsAnciens;
    }

    public List<CycleEffectif> getCycleEffectifsIss() {
        return cycleEffectifsIss;
    }

    public void setCycleEffectifsIss(List<CycleEffectif> cycleEffectifsIss) {
        this.cycleEffectifsIss = cycleEffectifsIss;
    }

    public List<CycleEffectif> getCycleEffectifsNouveaux() {
        return cycleEffectifsNouveaux;
    }

    public void setCycleEffectifsNouveaux(List<CycleEffectif> cycleEffectifsNouveaux) {
        this.cycleEffectifsNouveaux = cycleEffectifsNouveaux;
    }

    public int getTotalGeneral() {
        return totalGeneral;
    }

    public void setTotalGeneral(int totalGeneral) {
        this.totalGeneral = totalGeneral;
    }

    public int getTotalGeneralA() {
        return totalGeneralA;
    }

    public void setTotalGeneralA(int totalGeneralA) {
        this.totalGeneralA = totalGeneralA;
    }

    public int getTotalGeneralN() {
        return totalGeneralN;
    }

    public void setTotalGeneralN(int totalGeneralN) {
        this.totalGeneralN = totalGeneralN;
    }

    public int getTotalGeneralFille() {
        return totalGeneralFille;
    }

    public void setTotalGeneralFille(int totalGeneralFille) {
        this.totalGeneralFille = totalGeneralFille;
    }

    public int getTotalGeneralGarcon() {
        return totalGeneralGarcon;
    }

    public void setTotalGeneralGarcon(int totalGeneralGarcon) {
        this.totalGeneralGarcon = totalGeneralGarcon;
    }

    public int getTotalGeneralFilleA() {
        return totalGeneralFilleA;
    }

    public void setTotalGeneralFilleA(int totalGeneralFilleA) {
        this.totalGeneralFilleA = totalGeneralFilleA;
    }

    public int getTotalGeneralGarconA() {
        return totalGeneralGarconA;
    }

    public void setTotalGeneralGarconA(int totalGeneralGarconA) {
        this.totalGeneralGarconA = totalGeneralGarconA;
    }

    public int getTotalGeneralFilleN() {
        return totalGeneralFilleN;
    }

    public void setTotalGeneralFilleN(int totalGeneralFilleN) {
        this.totalGeneralFilleN = totalGeneralFilleN;
    }

    public int getTotalGeneralGarconN() {
        return totalGeneralGarconN;
    }

    public void setTotalGeneralGarconN(int totalGeneralGarconN) {
        this.totalGeneralGarconN = totalGeneralGarconN;
    }

    public List<NiveauEffetif> getNiveauEffectifs() {
        return niveauEffectifs;
    }

    public void setNiveauEffectifs(List<NiveauEffetif> niveauEffectifs) {
        this.niveauEffectifs = niveauEffectifs;
    }

    /**
     * cette methode permet de recupérer tous les cycle et toutes les filieres
     * dans la bd et retourner la liste des incriptions correspondantes aux
     * cycles et filieres
     *
     * cette methode est tres interresssante
     */
//    @PostConstruct
//    public void statFiliereCycle() {
//        System.out.println("test");
//        try {
//            effectifs = new ArrayList<CycleFiliereEffectif>();
//            List<Cycle> cycles = cycleService.findCycleAll();
//            for (Cycle cycle : cycles) {
//                List<Filiere> filieres = filiereService.findAllFiliere();
//                for (Filiere filiere1 : filieres) {
//                    inscriptions = inscriptionService.findInscriptionByFiliereCycle(filiere1, cycle);
//                    int garcon = 0;
//                    int fille = 0;
//                    int total = 0;
//                    for (Inscription in : inscriptions) {
//                        if (in.getEtudiant().getGenre().equals("M")) {
//                            garcon++;
//                        } else {
//                            fille++;
//                        }
//                        total++;
//                    }
//                    effectifs.add(new CycleFiliereEffectif(cycle.getNom_cycle(), filiere1.getNom_filiere(), garcon, fille, total));
//                }
//            }
//        } catch (DataAccessException ex) {
//            Logger.getLogger(StatistiqueBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    // @PostConstruct
    public void statCycle() {
        System.out.println("Stat cycle");
        String annee = anneeAccademique.getAnnee();
        System.out.println(" " + annee);
            try {
                AnneeAccademique an = anneeAccademiqueService.findAnneeByAnnee(annee);
                cycleEffectifsAnciens = new ArrayList<CycleEffectif>();
                niveauEffectifs = new ArrayList<NiveauEffetif>();
                totalGeneralFilleA = 0;
                totalGeneralGarconA = 0;
                totalGeneralA = 0;
                totalGeneralFille= 0;
                totalGeneralGarcon = 0;
                totalGeneral = 0;
                List<Cycle> cycles = cycleService.findCycleAll();
                for (Cycle cycle : cycles) {
                    inscriptionAnciens = inscriptionService.findInscriptionByCycleAnnee(cycle, an);
                    //inscriptionAnciens = inscriptionService.findInscriptionByCycleAncien(cycle);
                    //inscriptionNouveaux=inscriptionService.findInscriptionByCycleNouveau(cycle);
                    //enregistrements=inscriptionService.findInscriptionByCycle(cycle);
                    int garconA = 0;
                    int filleA = 0;
                    int totalA = 0;
                    for (Inscription in : inscriptionAnciens) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            garconA++;
                        } else {
                            filleA++;
                        }
                        totalA++;
                    }

                    totalGeneralFilleA = totalGeneralFilleA + filleA;
                    totalGeneralGarconA = totalGeneralGarconA + garconA;
                    totalGeneralA = totalGeneralGarconA + totalGeneralFilleA;
                    cycleEffectifsAnciens.add(new CycleEffectif(cycle.getNom_cycle(), garconA, filleA, totalA));
                }
                List<Niveau> niveaux = niveauService.findToutNiveau();
                for (Niveau niveau : niveaux) {
                    inscriptionAnciens = inscriptionService.findInscriptionByNiveauAnnee(niveau,an);
                    int garcon = 0;
                    int fille = 0;
                    int total = 0;

                    for (Inscription in : inscriptionAnciens) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            garcon++;
                        } else {
                            fille++;
                        }
                        total++;
                    }
                    totalGeneralFille = totalGeneralFille + fille;
                    totalGeneralGarcon = totalGeneralGarcon + garcon;
                    totalGeneral = totalGeneralGarcon + totalGeneralFille;
                    niveauEffectifs.add(new NiveauEffetif(niveau.getNom_niveau(), garcon, fille, total));

                }


            } catch (DataAccessException ex) {
                Logger.getLogger(StatistiqueBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    
}
