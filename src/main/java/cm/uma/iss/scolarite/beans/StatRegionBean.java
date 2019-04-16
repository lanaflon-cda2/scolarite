/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.AnneeAccademique;
import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.Filiere;
import cm.uma.iss.scolarite.entities.Inscription;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import cm.uma.iss.scolarite.entities.projection.CycleFiliereRegion;
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
public class StatRegionBean {

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
    private List<CycleFiliereRegion> cycle1EffRegions;
    private List<CycleFiliereRegion> cycle2EffRegions;
    private List<Inscription> inscriptions = new ArrayList<Inscription>();
    private AnneeAccademique anneeAccademique = new AnneeAccademique();
    private int tad = 0;
    private int tce = 0;
    private int ten = 0;
    private int tes = 0;
    private int tlit = 0;
    private int tno = 0;
    private int tnw = 0;
    private int tou = 0;
    private int tsu = 0;
    private int tsw = 0;
    private int tetranger = 0;
    private int ttotaRegion = 0;
    private int tad1 = 0;
    private int tce1 = 0;
    private int ten1 = 0;
    private int tes1 = 0;
    private int tlit1 = 0;
    private int tno1 = 0;
    private int tnw1 = 0;
    private int tou1 = 0;
    private int tsu1 = 0;
    private int tsw1 = 0;
    private int tetranger1 = 0;
    private int ttotaRegion1 = 0;
    private int totalGeneral = 0;

    public StatRegionBean() {
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

    public int getTad1() {
        return tad1;
    }

    public void setTad1(int tad1) {
        this.tad1 = tad1;
    }

    public int getTce1() {
        return tce1;
    }

    public void setTce1(int tce1) {
        this.tce1 = tce1;
    }

    public int getTen1() {
        return ten1;
    }

    public void setTen1(int ten1) {
        this.ten1 = ten1;
    }

    public int getTes1() {
        return tes1;
    }

    public void setTes1(int tes1) {
        this.tes1 = tes1;
    }

    public int getTlit1() {
        return tlit1;
    }

    public void setTlit1(int tlit1) {
        this.tlit1 = tlit1;
    }

    public int getTno1() {
        return tno1;
    }

    public void setTno1(int tno1) {
        this.tno1 = tno1;
    }

    public int getTnw1() {
        return tnw1;
    }

    public void setTnw1(int tnw1) {
        this.tnw1 = tnw1;
    }

    public int getTou1() {
        return tou1;
    }

    public void setTou1(int tou1) {
        this.tou1 = tou1;
    }

    public int getTsu1() {
        return tsu1;
    }

    public void setTsu1(int tsu1) {
        this.tsu1 = tsu1;
    }

    public int getTsw1() {
        return tsw1;
    }

    public void setTsw1(int tsw1) {
        this.tsw1 = tsw1;
    }

    public int getTetranger1() {
        return tetranger1;
    }

    public void setTetranger1(int tetranger1) {
        this.tetranger1 = tetranger1;
    }

    public int getTtotaRegion1() {
        return ttotaRegion1;
    }

    public void setTtotaRegion1(int ttotaRegion1) {
        this.ttotaRegion1 = ttotaRegion1;
    }

    public int getTad() {
        return tad;
    }

    public void setTad(int tad) {
        this.tad = tad;
    }

    public int getTce() {
        return tce;
    }

    public void setTce(int tce) {
        this.tce = tce;
    }

    public int getTen() {
        return ten;
    }

    public void setTen(int ten) {
        this.ten = ten;
    }

    public int getTes() {
        return tes;
    }

    public void setTes(int tes) {
        this.tes = tes;
    }

    public int getTlit() {
        return tlit;
    }

    public void setTlit(int tlit) {
        this.tlit = tlit;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public int getTnw() {
        return tnw;
    }

    public void setTnw(int tnw) {
        this.tnw = tnw;
    }

    public int getTou() {
        return tou;
    }

    public void setTou(int tou) {
        this.tou = tou;
    }

    public int getTsu() {
        return tsu;
    }

    public void setTsu(int tsu) {
        this.tsu = tsu;
    }

    public int getTsw() {
        return tsw;
    }

    public void setTsw(int tsw) {
        this.tsw = tsw;
    }

    public int getTetranger() {
        return tetranger;
    }

    public void setTetranger(int tetranger) {
        this.tetranger = tetranger;
    }

    public int getTtotaRegion() {
        return ttotaRegion;
    }

    public void setTtotaRegion(int ttotaRegion) {
        this.ttotaRegion = ttotaRegion;
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

    public List<CycleFiliereRegion> getCycle1EffRegions() {
        return cycle1EffRegions;
    }

    public void setCycle1EffRegions(List<CycleFiliereRegion> cycle1EffRegions) {
        this.cycle1EffRegions = cycle1EffRegions;
    }

    public List<CycleFiliereRegion> getCycle2EffRegions() {
        return cycle2EffRegions;
    }

    public void setCycle2EffRegions(List<CycleFiliereRegion> cycle2EffRegions) {
        this.cycle2EffRegions = cycle2EffRegions;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    //PostConstruct
    public void statRegion() {
        System.out.println("Region ");
        String annee = anneeAccademique.getAnnee();
        System.out.println(" " + annee);
        try {
            cycle1EffRegions = new ArrayList<CycleFiliereRegion>();
            cycle2EffRegions = new ArrayList<CycleFiliereRegion>();
            Cycle cycle1 = cycleService.findCycleByNom("LICENCE");
            Cycle cycle2 = cycleService.findCycleByNom("MASTER");
            AnneeAccademique anAc = anneeAccademiqueService.findAnneeByAnnee(annee);
            System.out.println(""+anAc);
            //System.out.println(""+cycle1);
            RegionOrigine adamaoua = regionOrigineService.findRegionOrigineByNom("AD");
            // System.out.println(""+adamaoua);
            RegionOrigine centre = regionOrigineService.findRegionOrigineByNom("CE");
            // System.out.println(""+centre);
            RegionOrigine extremeNord = regionOrigineService.findRegionOrigineByNom("EN");
            // System.out.println(""+extremeNord);
            RegionOrigine est = regionOrigineService.findRegionOrigineByNom("ES");
            //System.out.println(""+est);
            RegionOrigine littoral = regionOrigineService.findRegionOrigineByNom("LT");
            //System.out.println(""+littoral);
            RegionOrigine nord = regionOrigineService.findRegionOrigineByNom("NO");
            //System.out.println(""+nord);
            RegionOrigine nordOuest = regionOrigineService.findRegionOrigineByNom("NW");
            //System.out.println(""+nordOuest);
            RegionOrigine ouest = regionOrigineService.findRegionOrigineByNom("OU");
            //System.out.println(""+ouest);
            RegionOrigine sud = regionOrigineService.findRegionOrigineByNom("SU");
            // System.out.println(""+sud);
            RegionOrigine sudOuest = regionOrigineService.findRegionOrigineByNom("SW");
            //System.out.println(""+sudOuest);
            tad = 0;
            tce = 0;
            ten = 0;
            tes = 0;
            tetranger = 0;
            tlit = 0;
            tno = 0;
            tnw = 0;
            tou = 0;
            tsu = 0;
            tsw = 0;
            ttotaRegion = 0;
            tad1 = 0;
            tce1 = 0;
            ten1 = 0;
            tes1 = 0;
            tetranger1 = 0;
            tlit1 = 0;
            tno1 = 0;
            tnw1 = 0;
            tou1 = 0;
            tsu1 = 0;
            tsw1 = 0;
            ttotaRegion1 = 0;
            List<Filiere> filieres = filiereService.findAllFiliere();
            int totalInscritCycleFiliere = 0;
            int ad = 0;
            int ce = 0;
            int en = 0;
            int es = 0;
            int lit = 0;
            int no = 0;
            int nw = 0;
            int ou = 0;
            int su = 0;
            int sw = 0;
            int etranger = 0;
            int totaRegion = 0;
            System.out.println("Statistique du cycle LICENCE");
            for (Filiere filiere1 : filieres) {
                ad = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, adamaoua, cycle1,anAc);
                ce = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, centre, cycle1,anAc);
                en = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, extremeNord, cycle1,anAc);
                es = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, est, cycle1,anAc);
                lit = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, littoral, cycle1,anAc);
                no = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, nord, cycle1,anAc);
                nw = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, nordOuest, cycle1,anAc);
                ou = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, ouest, cycle1,anAc);
                su = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, sud, cycle1,anAc);
                sw = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, sudOuest, cycle1,anAc);
                totalInscritCycleFiliere = inscriptionService.findInscriptionByFiliereCycleAnnee(filiere1,cycle1,anAc).size();
                totaRegion = ad + ce + en + es + lit + no + nw + ou + su + sw;
                etranger = totalInscritCycleFiliere - totaRegion;
                tad = tad + ad;
                tce = tce + ce;
                ten = ten + en;
                tes = tes + es;
                tetranger = tetranger + etranger;
                tlit = tlit + lit;
                tno = tno + no;
                tnw = tnw + nw;
                tou = tou + ou;
                tsu = tsu + su;
                tsw = tsw + sw;
                ttotaRegion = ttotaRegion + totaRegion;
                System.out.println(filiere1.getNom_filiere() + ": ad= " + ad + " ce= " + ce + " en= " + en + " es= " + es + " lt= " + lit + " no= " + no + " nw= " + nw + " ou= " + ou + " su= " + su + " sw= " + sw + " Total= " + totaRegion);
                cycle1EffRegions.add(new CycleFiliereRegion(cycle1.getNom_cycle(), filiere1.getNom_filiere(), ad, ce, en, es, lit, no, nw, ou, su, sw, totaRegion, etranger));

            }
            int totalInscritCycleFiliere1 = 0;
            int ad1 = 0;
            int ce1 = 0;
            int en1 = 0;
            int es1 = 0;
            int lit1 = 0;
            int no1 = 0;
            int nw1 = 0;
            int ou1 = 0;
            int su1 = 0;
            int sw1 = 0;
            int etranger1 = 0;
            int totaRegion1 = 0;
            System.out.println("statistique du cycle Master");
            for (Filiere filiere1 : filieres) {
                ad1 = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, adamaoua, cycle2,anAc);
                ce1 = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, centre, cycle2,anAc);
                en1 = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, extremeNord, cycle2,anAc);
                es1 = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, est, cycle2,anAc);
                lit1 = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, littoral, cycle2,anAc);
                no1 = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, nord, cycle2,anAc);
                nw1 = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, nordOuest, cycle2,anAc);
                ou1 = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, ouest, cycle2,anAc);
                su1 = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, sud, cycle2,anAc);
                sw1 = inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, sudOuest, cycle2,anAc);
                totalInscritCycleFiliere1 = inscriptionService.findInscriptionByFiliereCycleAnnee(filiere1,cycle2,anAc).size();
                totaRegion1 = ad1 + ce1 + en1 + es1 + lit1 + no1 + nw1 + ou1 + su1 + sw1;
                etranger1 = totalInscritCycleFiliere1 - totaRegion1;
                tad1 = tad1 + ad1;
                tce1 = tce1 + ce1;
                ten1 = ten1 + en1;
                tes1 = tes1 + es1;
                tetranger1 = tetranger1 + etranger1;
                tlit1 = tlit1 + lit1;
                tno1 = tno1 + no1;
                tnw1 = tnw1 + nw1;
                tou1 = tou1 + ou1;
                tsu1 = tsu1 + su1;
                tsw1 = tsw1 + sw1;
                ttotaRegion1 = ttotaRegion1 + totaRegion1;
                System.out.println(filiere1.getNom_filiere() + ": ad= " + ad1 + " ce= " + ce1 + " en= " + en1 + " es= " + es1 + " lt= " + lit1 + " no= " + no1 + " nw= " + nw1 + " ou= " + ou1 + " su= " + su1 + " sw= " + sw1 + " Total= " + totaRegion1);
                cycle2EffRegions.add(new CycleFiliereRegion(cycle2.getNom_cycle(), filiere1.getNom_filiere(), ad1, ce1, en1, es1, lit1, no1, nw1, ou1, su1, sw1, totaRegion1, etranger1));
                totalGeneral = ttotaRegion + ttotaRegion1 + tetranger + tetranger1;

            }
        } catch (DataAccessException ex) {
            Logger.getLogger(StatistiqueBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
