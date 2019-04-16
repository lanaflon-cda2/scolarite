/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.AnneeAccademique;
import cm.uma.iss.scolarite.entities.Filiere;
import cm.uma.iss.scolarite.entities.Inscription;
import cm.uma.iss.scolarite.entities.Niveau;
import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.entities.projection.FiliereNiveauAgeGenre;
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
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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

/**
 *
 * @author ngnawen
 */
@ManagedBean
@SessionScoped
public class StatAgeBean {

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
    private List<Inscription> inscriptions;
    private List<Inscription> inscriptions1;
    private List<Inscription> inscriptions2;
    private List<Inscription> inscriptions3;
    private List<Inscription> inscriptions4;
    private List<FiliereNiveauAgeGenre> niveauAgeGenres;
    private List<FiliereNiveauAgeGenre> niveauAgeGenres1;
    private List<FiliereNiveauAgeGenre> niveauAgeGenres2;
    private List<FiliereNiveauAgeGenre> niveauAgeGenres3;
    private List<FiliereNiveauAgeGenre> niveauAgeGenres4;
    private int tageInf18f = 0;
    private int tageInf18m = 0;
    private int tageInf18t = 0;
    private int tage18f = 0;
    private int tage18m = 0;
    private int tage18t = 0;
    private int tage19f = 0;
    private int tage19m = 0;
    private int tage19t = 0;
    private int tage20m = 0;
    private int tage20f = 0;
    private int tage20t = 0;
    private int tage21m = 0;
    private int tage21f = 0;
    private int tage21t = 0;
    private int tage22m = 0;
    private int tage22f = 0;
    private int tage22t = 0;
    private int tage23m = 0;
    private int tage23f = 0;
    private int tage23t = 0;
    private int tage24m = 0;
    private int tage24f = 0;
    private int tage24t = 0;
    private int tage25m = 0;
    private int tage25f = 0;
    private int tage25t = 0;
    private int tage26m = 0;
    private int tage26f = 0;
    private int tage26t = 0;
    private int tage27m = 0;
    private int tage27f = 0;
    private int tage27t = 0;
    private int tage28m = 0;
    private int tage28f = 0;
    private int tage28t = 0;
    private int tage29m = 0;
    private int tage29f = 0;
    private int tage29t = 0;
    private int tage30m = 0;
    private int tage30f = 0;
    private int tage30t = 0;
    private int tage31m = 0;
    private int tage31f = 0;
    private int tage31t = 0;
    private int tage32m = 0;
    private int tage32f = 0;
    private int tage32t = 0;
    private int tage33m = 0;
    private int tage33f = 0;
    private int tage33t = 0;
    private int tageSup34m = 0;
    private int tageSup34f = 0;
    private int tageSup34t = 0;
    private int ttt = 0;
    private int tetranger = 0;
    private int tageInf18f1 = 0;
    private int tageInf18m1 = 0;
    private int tageInf18t1 = 0;
    private int tage18f1 = 0;
    private int tage18m1 = 0;
    private int tage18t1 = 0;
    private int tage19f1 = 0;
    private int tage19m1 = 0;
    private int tage19t1 = 0;
    private int tage20m1 = 0;
    private int tage20f1 = 0;
    private int tage20t1 = 0;
    private int tage21m1 = 0;
    private int tage21f1 = 0;
    private int tage21t1 = 0;
    private int tage22m1 = 0;
    private int tage22f1 = 0;
    private int tage22t1 = 0;
    private int tage23m1 = 0;
    private int tage23f1 = 0;
    private int tage23t1 = 0;
    private int tage24m1 = 0;
    private int tage24f1 = 0;
    private int tage24t1 = 0;
    private int tage25m1 = 0;
    private int tage25f1 = 0;
    private int tage25t1 = 0;
    private int tage26m1 = 0;
    private int tage26f1 = 0;
    private int tage26t1 = 0;
    private int tage27m1 = 0;
    private int tage27f1 = 0;
    private int tage27t1 = 0;
    private int tage28m1 = 0;
    private int tage28f1 = 0;
    private int tage28t1 = 0;
    private int tage29m1 = 0;
    private int tage29f1 = 0;
    private int tage29t1 = 0;
    private int tage30m1 = 0;
    private int tage30f1 = 0;
    private int tage30t1 = 0;
    private int tage31m1 = 0;
    private int tage31f1 = 0;
    private int tage31t1 = 0;
    private int tage32m1 = 0;
    private int tage32f1 = 0;
    private int tage32t1 = 0;
    private int tage33m1 = 0;
    private int tage33f1 = 0;
    private int tage33t1 = 0;
    private int tageSup34m1 = 0;
    private int tageSup34f1 = 0;
    private int tageSup34t1 = 0;
    private int ttt1 = 0;
    private int tetranger1 = 0;
    private int tageInf18f2 = 0;
    private int tageInf18m2 = 0;
    private int tageInf18t2 = 0;
    private int tage18f2 = 0;
    private int tage18m2 = 0;
    private int tage18t2 = 0;
    private int tage19f2 = 0;
    private int tage19m2 = 0;
    private int tage19t2 = 0;
    private int tage20m2 = 0;
    private int tage20f2 = 0;
    private int tage20t2 = 0;
    private int tage21m2 = 0;
    private int tage21f2 = 0;
    private int tage21t2 = 0;
    private int tage22m2 = 0;
    private int tage22f2 = 0;
    private int tage22t2 = 0;
    private int tage23m2 = 0;
    private int tage23f2 = 0;
    private int tage23t2 = 0;
    private int tage24m2 = 0;
    private int tage24f2 = 0;
    private int tage24t2 = 0;
    private int tage25m2 = 0;
    private int tage25f2 = 0;
    private int tage25t2 = 0;
    private int tage26m2 = 0;
    private int tage26f2 = 0;
    private int tage26t2 = 0;
    private int tage27m2 = 0;
    private int tage27f2 = 0;
    private int tage27t2 = 0;
    private int tage28m2 = 0;
    private int tage28f2 = 0;
    private int tage28t2 = 0;
    private int tage29m2 = 0;
    private int tage29f2 = 0;
    private int tage29t2 = 0;
    private int tage30m2 = 0;
    private int tage30f2 = 0;
    private int tage30t2 = 0;
    private int tage31m2 = 0;
    private int tage31f2 = 0;
    private int tage31t2 = 0;
    private int tage32m2 = 0;
    private int tage32f2 = 0;
    private int tage32t2 = 0;
    private int tage33m2 = 0;
    private int tage33f2 = 0;
    private int tage33t2 = 0;
    private int tageSup34m2 = 0;
    private int tageSup34f2 = 0;
    private int tageSup34t2 = 0;
    private int ttt2 = 0;
    private int tetranger2 = 0;
    private int tageInf18f3 = 0;
    private int tageInf18m3 = 0;
    private int tageInf18t3 = 0;
    private int tage18f3 = 0;
    private int tage18m3 = 0;
    private int tage18t3 = 0;
    private int tage19f3 = 0;
    private int tage19m3 = 0;
    private int tage19t3 = 0;
    private int tage20m3 = 0;
    private int tage20f3 = 0;
    private int tage20t3 = 0;
    private int tage21m3 = 0;
    private int tage21f3 = 0;
    private int tage21t3 = 0;
    private int tage22m3 = 0;
    private int tage22f3 = 0;
    private int tage22t3 = 0;
    private int tage23m3 = 0;
    private int tage23f3 = 0;
    private int tage23t3 = 0;
    private int tage24m3 = 0;
    private int tage24f3 = 0;
    private int tage24t3 = 0;
    private int tage25m3 = 0;
    private int tage25f3 = 0;
    private int tage25t3 = 0;
    private int tage26m3 = 0;
    private int tage26f3 = 0;
    private int tage26t3 = 0;
    private int tage27m3 = 0;
    private int tage27f3 = 0;
    private int tage27t3 = 0;
    private int tage28m3 = 0;
    private int tage28f3 = 0;
    private int tage28t3 = 0;
    private int tage29m3 = 0;
    private int tage29f3 = 0;
    private int tage29t3 = 0;
    private int tage30m3 = 0;
    private int tage30f3 = 0;
    private int tage30t3 = 0;
    private int tage31m3 = 0;
    private int tage31f3 = 0;
    private int tage31t3 = 0;
    private int tage32m3 = 0;
    private int tage32f3 = 0;
    private int tage32t3 = 0;
    private int tage33m3 = 0;
    private int tage33f3 = 0;
    private int tage33t3 = 0;
    private int tageSup34m3 = 0;
    private int tageSup34f3 = 0;
    private int tageSup34t3 = 0;
    private int ttt3 = 0;
    private int tetranger3 = 0;
    private int tageInf18f4 = 0;
    private int tageInf18m4 = 0;
    private int tageInf18t4 = 0;
    private int tage18f4 = 0;
    private int tage18m4 = 0;
    private int tage18t4 = 0;
    private int tage19f4 = 0;
    private int tage19m4 = 0;
    private int tage19t4 = 0;
    private int tage20m4 = 0;
    private int tage20f4 = 0;
    private int tage20t4 = 0;
    private int tage21m4 = 0;
    private int tage21f4 = 0;
    private int tage21t4 = 0;
    private int tage22m4 = 0;
    private int tage22f4 = 0;
    private int tage22t4 = 0;
    private int tage23m4 = 0;
    private int tage23f4 = 0;
    private int tage23t4 = 0;
    private int tage24m4 = 0;
    private int tage24f4 = 0;
    private int tage24t4 = 0;
    private int tage25m4 = 0;
    private int tage25f4 = 0;
    private int tage25t4 = 0;
    private int tage26m4 = 0;
    private int tage26f4 = 0;
    private int tage26t4 = 0;
    private int tage27m4 = 0;
    private int tage27f4 = 0;
    private int tage27t4 = 0;
    private int tage28m4 = 0;
    private int tage28f4 = 0;
    private int tage28t4 = 0;
    private int tage29m4 = 0;
    private int tage29f4 = 0;
    private int tage29t4 = 0;
    private int tage30m4 = 0;
    private int tage30f4 = 0;
    private int tage30t4 = 0;
    private int tage31m4 = 0;
    private int tage31f4 = 0;
    private int tage31t4 = 0;
    private int tage32m4 = 0;
    private int tage32f4 = 0;
    private int tage32t4 = 0;
    private int tage33m4 = 0;
    private int tage33f4 = 0;
    private int tage33t4 = 0;
    private int tageSup34m4 = 0;
    private int tageSup34f4 = 0;
    private int tageSup34t4 = 0;
    private int ttt4 = 0;
    private int tetranger4 = 0;

    public StatAgeBean() {
    }

    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public void setAnneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
    }

    public int getTageInf18f() {
        return tageInf18f;
    }

    public void setTageInf18f(int tageInf18f) {
        this.tageInf18f = tageInf18f;
    }

    public int getTageInf18m() {
        return tageInf18m;
    }

    public void setTageInf18m(int tageInf18m) {
        this.tageInf18m = tageInf18m;
    }

    public int getTageInf18t() {
        return tageInf18t;
    }

    public void setTageInf18t(int tageInf18t) {
        this.tageInf18t = tageInf18t;
    }

    public int getTage18f() {
        return tage18f;
    }

    public void setTage18f(int tage18f) {
        this.tage18f = tage18f;
    }

    public int getTage18m() {
        return tage18m;
    }

    public void setTage18m(int tage18m) {
        this.tage18m = tage18m;
    }

    public int getTage18t() {
        return tage18t;
    }

    public void setTage18t(int tage18t) {
        this.tage18t = tage18t;
    }

    public int getTage19f() {
        return tage19f;
    }

    public void setTage19f(int tage19f) {
        this.tage19f = tage19f;
    }

    public int getTage19m() {
        return tage19m;
    }

    public void setTage19m(int tage19m) {
        this.tage19m = tage19m;
    }

    public int getTage19t() {
        return tage19t;
    }

    public void setTage19t(int tage19t) {
        this.tage19t = tage19t;
    }

    public int getTage20m() {
        return tage20m;
    }

    public void setTage20m(int tage20m) {
        this.tage20m = tage20m;
    }

    public int getTage20f() {
        return tage20f;
    }

    public void setTage20f(int tage20f) {
        this.tage20f = tage20f;
    }

    public int getTage20t() {
        return tage20t;
    }

    public void setTage20t(int tage20t) {
        this.tage20t = tage20t;
    }

    public int getTage21m() {
        return tage21m;
    }

    public void setTage21m(int tage21m) {
        this.tage21m = tage21m;
    }

    public int getTage21f() {
        return tage21f;
    }

    public void setTage21f(int tage21f) {
        this.tage21f = tage21f;
    }

    public int getTage21t() {
        return tage21t;
    }

    public void setTage21t(int tage21t) {
        this.tage21t = tage21t;
    }

    public int getTage22m() {
        return tage22m;
    }

    public void setTage22m(int tage22m) {
        this.tage22m = tage22m;
    }

    public int getTage22f() {
        return tage22f;
    }

    public void setTage22f(int tage22f) {
        this.tage22f = tage22f;
    }

    public int getTage22t() {
        return tage22t;
    }

    public void setTage22t(int tage22t) {
        this.tage22t = tage22t;
    }

    public int getTage23m() {
        return tage23m;
    }

    public void setTage23m(int tage23m) {
        this.tage23m = tage23m;
    }

    public int getTage23f() {
        return tage23f;
    }

    public void setTage23f(int tage23f) {
        this.tage23f = tage23f;
    }

    public int getTage23t() {
        return tage23t;
    }

    public void setTage23t(int tage23t) {
        this.tage23t = tage23t;
    }

    public int getTage24m() {
        return tage24m;
    }

    public void setTage24m(int tage24m) {
        this.tage24m = tage24m;
    }

    public int getTage24f() {
        return tage24f;
    }

    public void setTage24f(int tage24f) {
        this.tage24f = tage24f;
    }

    public int getTage24t() {
        return tage24t;
    }

    public void setTage24t(int tage24t) {
        this.tage24t = tage24t;
    }

    public int getTage25m() {
        return tage25m;
    }

    public void setTage25m(int tage25m) {
        this.tage25m = tage25m;
    }

    public int getTage25f() {
        return tage25f;
    }

    public void setTage25f(int tage25f) {
        this.tage25f = tage25f;
    }

    public int getTage25t() {
        return tage25t;
    }

    public void setTage25t(int tage25t) {
        this.tage25t = tage25t;
    }

    public int getTage26m() {
        return tage26m;
    }

    public void setTage26m(int tage26m) {
        this.tage26m = tage26m;
    }

    public int getTage26f() {
        return tage26f;
    }

    public void setTage26f(int tage26f) {
        this.tage26f = tage26f;
    }

    public int getTage26t() {
        return tage26t;
    }

    public void setTage26t(int tage26t) {
        this.tage26t = tage26t;
    }

    public int getTage27m() {
        return tage27m;
    }

    public void setTage27m(int tage27m) {
        this.tage27m = tage27m;
    }

    public int getTage27f() {
        return tage27f;
    }

    public void setTage27f(int tage27f) {
        this.tage27f = tage27f;
    }

    public int getTage27t() {
        return tage27t;
    }

    public void setTage27t(int tage27t) {
        this.tage27t = tage27t;
    }

    public int getTage28m() {
        return tage28m;
    }

    public void setTage28m(int tage28m) {
        this.tage28m = tage28m;
    }

    public int getTage28f() {
        return tage28f;
    }

    public void setTage28f(int tage28f) {
        this.tage28f = tage28f;
    }

    public int getTage28t() {
        return tage28t;
    }

    public void setTage28t(int tage28t) {
        this.tage28t = tage28t;
    }

    public int getTage29m() {
        return tage29m;
    }

    public void setTage29m(int tage29m) {
        this.tage29m = tage29m;
    }

    public int getTage29f() {
        return tage29f;
    }

    public void setTage29f(int tage29f) {
        this.tage29f = tage29f;
    }

    public int getTage29t() {
        return tage29t;
    }

    public void setTage29t(int tage29t) {
        this.tage29t = tage29t;
    }

    public int getTage30m() {
        return tage30m;
    }

    public void setTage30m(int tage30m) {
        this.tage30m = tage30m;
    }

    public int getTage30f() {
        return tage30f;
    }

    public void setTage30f(int tage30f) {
        this.tage30f = tage30f;
    }

    public int getTage30t() {
        return tage30t;
    }

    public void setTage30t(int tage30t) {
        this.tage30t = tage30t;
    }

    public int getTage31m() {
        return tage31m;
    }

    public void setTage31m(int tage31m) {
        this.tage31m = tage31m;
    }

    public int getTage31f() {
        return tage31f;
    }

    public void setTage31f(int tage31f) {
        this.tage31f = tage31f;
    }

    public int getTage31t() {
        return tage31t;
    }

    public void setTage31t(int tage31t) {
        this.tage31t = tage31t;
    }

    public int getTage32m() {
        return tage32m;
    }

    public void setTage32m(int tage32m) {
        this.tage32m = tage32m;
    }

    public int getTage32f() {
        return tage32f;
    }

    public void setTage32f(int tage32f) {
        this.tage32f = tage32f;
    }

    public int getTage32t() {
        return tage32t;
    }

    public void setTage32t(int tage32t) {
        this.tage32t = tage32t;
    }

    public int getTage33m() {
        return tage33m;
    }

    public void setTage33m(int tage33m) {
        this.tage33m = tage33m;
    }

    public int getTage33f() {
        return tage33f;
    }

    public void setTage33f(int tage33f) {
        this.tage33f = tage33f;
    }

    public int getTage33t() {
        return tage33t;
    }

    public void setTage33t(int tage33t) {
        this.tage33t = tage33t;
    }

    public int getTageSup34m() {
        return tageSup34m;
    }

    public void setTageSup34m(int tageSup34m) {
        this.tageSup34m = tageSup34m;
    }

    public int getTageSup34f() {
        return tageSup34f;
    }

    public void setTageSup34f(int tageSup34f) {
        this.tageSup34f = tageSup34f;
    }

    public int getTageSup34t() {
        return tageSup34t;
    }

    public void setTageSup34t(int tageSup34t) {
        this.tageSup34t = tageSup34t;
    }

    public int getTtt() {
        return ttt;
    }

    public void setTtt(int ttt) {
        this.ttt = ttt;
    }

    public int getTetranger() {
        return tetranger;
    }

    public void setTetranger(int tetranger) {
        this.tetranger = tetranger;
    }

    public int getTageInf18f3() {
        return tageInf18f3;
    }

    public void setTageInf18f3(int tageInf18f3) {
        this.tageInf18f3 = tageInf18f3;
    }

    public int getTageInf18m3() {
        return tageInf18m3;
    }

    public void setTageInf18m3(int tageInf18m3) {
        this.tageInf18m3 = tageInf18m3;
    }

    public int getTageInf18t3() {
        return tageInf18t3;
    }

    public void setTageInf18t3(int tageInf18t3) {
        this.tageInf18t3 = tageInf18t3;
    }

    public int getTage18f3() {
        return tage18f3;
    }

    public void setTage18f3(int tage18f3) {
        this.tage18f3 = tage18f3;
    }

    public int getTage18m3() {
        return tage18m3;
    }

    public void setTage18m3(int tage18m3) {
        this.tage18m3 = tage18m3;
    }

    public int getTage18t3() {
        return tage18t3;
    }

    public void setTage18t3(int tage18t3) {
        this.tage18t3 = tage18t3;
    }

    public int getTage19f3() {
        return tage19f3;
    }

    public void setTage19f3(int tage19f3) {
        this.tage19f3 = tage19f3;
    }

    public int getTage19m3() {
        return tage19m3;
    }

    public void setTage19m3(int tage19m3) {
        this.tage19m3 = tage19m3;
    }

    public int getTage19t3() {
        return tage19t3;
    }

    public void setTage19t3(int tage19t3) {
        this.tage19t3 = tage19t3;
    }

    public int getTage20m3() {
        return tage20m3;
    }

    public void setTage20m3(int tage20m3) {
        this.tage20m3 = tage20m3;
    }

    public int getTage20f3() {
        return tage20f3;
    }

    public void setTage20f3(int tage20f3) {
        this.tage20f3 = tage20f3;
    }

    public int getTage20t3() {
        return tage20t3;
    }

    public void setTage20t3(int tage20t3) {
        this.tage20t3 = tage20t3;
    }

    public int getTage21m3() {
        return tage21m3;
    }

    public void setTage21m3(int tage21m3) {
        this.tage21m3 = tage21m3;
    }

    public int getTage21f3() {
        return tage21f3;
    }

    public void setTage21f3(int tage21f3) {
        this.tage21f3 = tage21f3;
    }

    public int getTage21t3() {
        return tage21t3;
    }

    public void setTage21t3(int tage21t3) {
        this.tage21t3 = tage21t3;
    }

    public int getTage22m3() {
        return tage22m3;
    }

    public void setTage22m3(int tage22m3) {
        this.tage22m3 = tage22m3;
    }

    public int getTage22f3() {
        return tage22f3;
    }

    public void setTage22f3(int tage22f3) {
        this.tage22f3 = tage22f3;
    }

    public int getTage22t3() {
        return tage22t3;
    }

    public void setTage22t3(int tage22t3) {
        this.tage22t3 = tage22t3;
    }

    public int getTage23m3() {
        return tage23m3;
    }

    public void setTage23m3(int tage23m3) {
        this.tage23m3 = tage23m3;
    }

    public int getTage23f3() {
        return tage23f3;
    }

    public void setTage23f3(int tage23f3) {
        this.tage23f3 = tage23f3;
    }

    public int getTage23t3() {
        return tage23t3;
    }

    public void setTage23t3(int tage23t3) {
        this.tage23t3 = tage23t3;
    }

    public int getTage24m3() {
        return tage24m3;
    }

    public void setTage24m3(int tage24m3) {
        this.tage24m3 = tage24m3;
    }

    public int getTage24f3() {
        return tage24f3;
    }

    public void setTage24f3(int tage24f3) {
        this.tage24f3 = tage24f3;
    }

    public int getTage24t3() {
        return tage24t3;
    }

    public void setTage24t3(int tage24t3) {
        this.tage24t3 = tage24t3;
    }

    public int getTage25m3() {
        return tage25m3;
    }

    public void setTage25m3(int tage25m3) {
        this.tage25m3 = tage25m3;
    }

    public int getTage25f3() {
        return tage25f3;
    }

    public void setTage25f3(int tage25f3) {
        this.tage25f3 = tage25f3;
    }

    public int getTage25t3() {
        return tage25t3;
    }

    public void setTage25t3(int tage25t3) {
        this.tage25t3 = tage25t3;
    }

    public int getTage26m3() {
        return tage26m3;
    }

    public void setTage26m3(int tage26m3) {
        this.tage26m3 = tage26m3;
    }

    public int getTage26f3() {
        return tage26f3;
    }

    public void setTage26f3(int tage26f3) {
        this.tage26f3 = tage26f3;
    }

    public int getTage26t3() {
        return tage26t3;
    }

    public void setTage26t3(int tage26t3) {
        this.tage26t3 = tage26t3;
    }

    public int getTage27m3() {
        return tage27m3;
    }

    public void setTage27m3(int tage27m3) {
        this.tage27m3 = tage27m3;
    }

    public int getTage27f3() {
        return tage27f3;
    }

    public void setTage27f3(int tage27f3) {
        this.tage27f3 = tage27f3;
    }

    public int getTage27t3() {
        return tage27t3;
    }

    public void setTage27t3(int tage27t3) {
        this.tage27t3 = tage27t3;
    }

    public int getTage28m3() {
        return tage28m3;
    }

    public void setTage28m3(int tage28m3) {
        this.tage28m3 = tage28m3;
    }

    public int getTage28f3() {
        return tage28f3;
    }

    public void setTage28f3(int tage28f3) {
        this.tage28f3 = tage28f3;
    }

    public int getTage28t3() {
        return tage28t3;
    }

    public void setTage28t3(int tage28t3) {
        this.tage28t3 = tage28t3;
    }

    public int getTage29m3() {
        return tage29m3;
    }

    public void setTage29m3(int tage29m3) {
        this.tage29m3 = tage29m3;
    }

    public int getTage29f3() {
        return tage29f3;
    }

    public void setTage29f3(int tage29f3) {
        this.tage29f3 = tage29f3;
    }

    public int getTage29t3() {
        return tage29t3;
    }

    public void setTage29t3(int tage29t3) {
        this.tage29t3 = tage29t3;
    }

    public int getTage30m3() {
        return tage30m3;
    }

    public void setTage30m3(int tage30m3) {
        this.tage30m3 = tage30m3;
    }

    public int getTage30f3() {
        return tage30f3;
    }

    public void setTage30f3(int tage30f3) {
        this.tage30f3 = tage30f3;
    }

    public int getTage30t3() {
        return tage30t3;
    }

    public void setTage30t3(int tage30t3) {
        this.tage30t3 = tage30t3;
    }

    public int getTage31m3() {
        return tage31m3;
    }

    public void setTage31m3(int tage31m3) {
        this.tage31m3 = tage31m3;
    }

    public int getTage31f3() {
        return tage31f3;
    }

    public void setTage31f3(int tage31f3) {
        this.tage31f3 = tage31f3;
    }

    public int getTage31t3() {
        return tage31t3;
    }

    public void setTage31t3(int tage31t3) {
        this.tage31t3 = tage31t3;
    }

    public int getTage32m3() {
        return tage32m3;
    }

    public void setTage32m3(int tage32m3) {
        this.tage32m3 = tage32m3;
    }

    public int getTage32f3() {
        return tage32f3;
    }

    public void setTage32f3(int tage32f3) {
        this.tage32f3 = tage32f3;
    }

    public int getTage32t3() {
        return tage32t3;
    }

    public void setTage32t3(int tage32t3) {
        this.tage32t3 = tage32t3;
    }

    public int getTage33m3() {
        return tage33m3;
    }

    public void setTage33m3(int tage33m3) {
        this.tage33m3 = tage33m3;
    }

    public int getTage33f3() {
        return tage33f3;
    }

    public void setTage33f3(int tage33f3) {
        this.tage33f3 = tage33f3;
    }

    public int getTage33t3() {
        return tage33t3;
    }

    public void setTage33t3(int tage33t3) {
        this.tage33t3 = tage33t3;
    }

    public int getTageSup34m3() {
        return tageSup34m3;
    }

    public void setTageSup34m3(int tageSup34m3) {
        this.tageSup34m3 = tageSup34m3;
    }

    public int getTageSup34f3() {
        return tageSup34f3;
    }

    public void setTageSup34f3(int tageSup34f3) {
        this.tageSup34f3 = tageSup34f3;
    }

    public int getTageSup34t3() {
        return tageSup34t3;
    }

    public void setTageSup34t3(int tageSup34t3) {
        this.tageSup34t3 = tageSup34t3;
    }

    public int getTtt3() {
        return ttt3;
    }

    public void setTtt3(int ttt3) {
        this.ttt3 = ttt3;
    }

    public int getTetranger3() {
        return tetranger3;
    }

    public void setTetranger3(int tetranger3) {
        this.tetranger3 = tetranger3;
    }

    public int getTageInf18f4() {
        return tageInf18f4;
    }

    public void setTageInf18f4(int tageInf18f4) {
        this.tageInf18f4 = tageInf18f4;
    }

    public int getTageInf18m4() {
        return tageInf18m4;
    }

    public void setTageInf18m4(int tageInf18m4) {
        this.tageInf18m4 = tageInf18m4;
    }

    public int getTageInf18t4() {
        return tageInf18t4;
    }

    public void setTageInf18t4(int tageInf18t4) {
        this.tageInf18t4 = tageInf18t4;
    }

    public int getTage18f4() {
        return tage18f4;
    }

    public void setTage18f4(int tage18f4) {
        this.tage18f4 = tage18f4;
    }

    public int getTage18m4() {
        return tage18m4;
    }

    public void setTage18m4(int tage18m4) {
        this.tage18m4 = tage18m4;
    }

    public int getTage18t4() {
        return tage18t4;
    }

    public void setTage18t4(int tage18t4) {
        this.tage18t4 = tage18t4;
    }

    public int getTage19f4() {
        return tage19f4;
    }

    public void setTage19f4(int tage19f4) {
        this.tage19f4 = tage19f4;
    }

    public int getTage19m4() {
        return tage19m4;
    }

    public void setTage19m4(int tage19m4) {
        this.tage19m4 = tage19m4;
    }

    public int getTage19t4() {
        return tage19t4;
    }

    public void setTage19t4(int tage19t4) {
        this.tage19t4 = tage19t4;
    }

    public int getTage20m4() {
        return tage20m4;
    }

    public void setTage20m4(int tage20m4) {
        this.tage20m4 = tage20m4;
    }

    public int getTage20f4() {
        return tage20f4;
    }

    public void setTage20f4(int tage20f4) {
        this.tage20f4 = tage20f4;
    }

    public int getTage20t4() {
        return tage20t4;
    }

    public void setTage20t4(int tage20t4) {
        this.tage20t4 = tage20t4;
    }

    public int getTage21m4() {
        return tage21m4;
    }

    public void setTage21m4(int tage21m4) {
        this.tage21m4 = tage21m4;
    }

    public int getTage21f4() {
        return tage21f4;
    }

    public void setTage21f4(int tage21f4) {
        this.tage21f4 = tage21f4;
    }

    public int getTage21t4() {
        return tage21t4;
    }

    public void setTage21t4(int tage21t4) {
        this.tage21t4 = tage21t4;
    }

    public int getTage22m4() {
        return tage22m4;
    }

    public void setTage22m4(int tage22m4) {
        this.tage22m4 = tage22m4;
    }

    public int getTage22f4() {
        return tage22f4;
    }

    public void setTage22f4(int tage22f4) {
        this.tage22f4 = tage22f4;
    }

    public int getTage22t4() {
        return tage22t4;
    }

    public void setTage22t4(int tage22t4) {
        this.tage22t4 = tage22t4;
    }

    public int getTage23m4() {
        return tage23m4;
    }

    public void setTage23m4(int tage23m4) {
        this.tage23m4 = tage23m4;
    }

    public int getTage23f4() {
        return tage23f4;
    }

    public void setTage23f4(int tage23f4) {
        this.tage23f4 = tage23f4;
    }

    public int getTage23t4() {
        return tage23t4;
    }

    public void setTage23t4(int tage23t4) {
        this.tage23t4 = tage23t4;
    }

    public int getTage24m4() {
        return tage24m4;
    }

    public void setTage24m4(int tage24m4) {
        this.tage24m4 = tage24m4;
    }

    public int getTage24f4() {
        return tage24f4;
    }

    public void setTage24f4(int tage24f4) {
        this.tage24f4 = tage24f4;
    }

    public int getTage24t4() {
        return tage24t4;
    }

    public void setTage24t4(int tage24t4) {
        this.tage24t4 = tage24t4;
    }

    public int getTage25m4() {
        return tage25m4;
    }

    public void setTage25m4(int tage25m4) {
        this.tage25m4 = tage25m4;
    }

    public int getTage25f4() {
        return tage25f4;
    }

    public void setTage25f4(int tage25f4) {
        this.tage25f4 = tage25f4;
    }

    public int getTage25t4() {
        return tage25t4;
    }

    public void setTage25t4(int tage25t4) {
        this.tage25t4 = tage25t4;
    }

    public int getTage26m4() {
        return tage26m4;
    }

    public void setTage26m4(int tage26m4) {
        this.tage26m4 = tage26m4;
    }

    public int getTage26f4() {
        return tage26f4;
    }

    public void setTage26f4(int tage26f4) {
        this.tage26f4 = tage26f4;
    }

    public int getTage26t4() {
        return tage26t4;
    }

    public void setTage26t4(int tage26t4) {
        this.tage26t4 = tage26t4;
    }

    public int getTage27m4() {
        return tage27m4;
    }

    public void setTage27m4(int tage27m4) {
        this.tage27m4 = tage27m4;
    }

    public int getTage27f4() {
        return tage27f4;
    }

    public void setTage27f4(int tage27f4) {
        this.tage27f4 = tage27f4;
    }

    public int getTage27t4() {
        return tage27t4;
    }

    public void setTage27t4(int tage27t4) {
        this.tage27t4 = tage27t4;
    }

    public int getTage28m4() {
        return tage28m4;
    }

    public void setTage28m4(int tage28m4) {
        this.tage28m4 = tage28m4;
    }

    public int getTage28f4() {
        return tage28f4;
    }

    public void setTage28f4(int tage28f4) {
        this.tage28f4 = tage28f4;
    }

    public int getTage28t4() {
        return tage28t4;
    }

    public void setTage28t4(int tage28t4) {
        this.tage28t4 = tage28t4;
    }

    public int getTage29m4() {
        return tage29m4;
    }

    public void setTage29m4(int tage29m4) {
        this.tage29m4 = tage29m4;
    }

    public int getTage29f4() {
        return tage29f4;
    }

    public void setTage29f4(int tage29f4) {
        this.tage29f4 = tage29f4;
    }

    public int getTage29t4() {
        return tage29t4;
    }

    public void setTage29t4(int tage29t4) {
        this.tage29t4 = tage29t4;
    }

    public int getTage30m4() {
        return tage30m4;
    }

    public void setTage30m4(int tage30m4) {
        this.tage30m4 = tage30m4;
    }

    public int getTage30f4() {
        return tage30f4;
    }

    public void setTage30f4(int tage30f4) {
        this.tage30f4 = tage30f4;
    }

    public int getTage30t4() {
        return tage30t4;
    }

    public void setTage30t4(int tage30t4) {
        this.tage30t4 = tage30t4;
    }

    public int getTage31m4() {
        return tage31m4;
    }

    public void setTage31m4(int tage31m4) {
        this.tage31m4 = tage31m4;
    }

    public int getTage31f4() {
        return tage31f4;
    }

    public void setTage31f4(int tage31f4) {
        this.tage31f4 = tage31f4;
    }

    public int getTage31t4() {
        return tage31t4;
    }

    public void setTage31t4(int tage31t4) {
        this.tage31t4 = tage31t4;
    }

    public int getTage32m4() {
        return tage32m4;
    }

    public void setTage32m4(int tage32m4) {
        this.tage32m4 = tage32m4;
    }

    public int getTage32f4() {
        return tage32f4;
    }

    public void setTage32f4(int tage32f4) {
        this.tage32f4 = tage32f4;
    }

    public int getTage32t4() {
        return tage32t4;
    }

    public void setTage32t4(int tage32t4) {
        this.tage32t4 = tage32t4;
    }

    public int getTage33m4() {
        return tage33m4;
    }

    public void setTage33m4(int tage33m4) {
        this.tage33m4 = tage33m4;
    }

    public int getTage33f4() {
        return tage33f4;
    }

    public void setTage33f4(int tage33f4) {
        this.tage33f4 = tage33f4;
    }

    public int getTage33t4() {
        return tage33t4;
    }

    public void setTage33t4(int tage33t4) {
        this.tage33t4 = tage33t4;
    }

    public int getTageSup34m4() {
        return tageSup34m4;
    }

    public void setTageSup34m4(int tageSup34m4) {
        this.tageSup34m4 = tageSup34m4;
    }

    public int getTageSup34f4() {
        return tageSup34f4;
    }

    public void setTageSup34f4(int tageSup34f4) {
        this.tageSup34f4 = tageSup34f4;
    }

    public int getTageSup34t4() {
        return tageSup34t4;
    }

    public void setTageSup34t4(int tageSup34t4) {
        this.tageSup34t4 = tageSup34t4;
    }

    public int getTtt4() {
        return ttt4;
    }

    public void setTtt4(int ttt4) {
        this.ttt4 = ttt4;
    }

    public int getTetranger4() {
        return tetranger4;
    }

    public void setTetranger4(int tetranger4) {
        this.tetranger4 = tetranger4;
    }

    public int getTageInf18f2() {
        return tageInf18f2;
    }

    public void setTageInf18f2(int tageInf18f2) {
        this.tageInf18f2 = tageInf18f2;
    }

    public int getTageInf18m2() {
        return tageInf18m2;
    }

    public void setTageInf18m2(int tageInf18m2) {
        this.tageInf18m2 = tageInf18m2;
    }

    public int getTageInf18t2() {
        return tageInf18t2;
    }

    public void setTageInf18t2(int tageInf18t2) {
        this.tageInf18t2 = tageInf18t2;
    }

    public int getTage18f2() {
        return tage18f2;
    }

    public void setTage18f2(int tage18f2) {
        this.tage18f2 = tage18f2;
    }

    public int getTage18m2() {
        return tage18m2;
    }

    public void setTage18m2(int tage18m2) {
        this.tage18m2 = tage18m2;
    }

    public int getTage18t2() {
        return tage18t2;
    }

    public void setTage18t2(int tage18t2) {
        this.tage18t2 = tage18t2;
    }

    public int getTage19f2() {
        return tage19f2;
    }

    public void setTage19f2(int tage19f2) {
        this.tage19f2 = tage19f2;
    }

    public int getTage19m2() {
        return tage19m2;
    }

    public void setTage19m2(int tage19m2) {
        this.tage19m2 = tage19m2;
    }

    public int getTage19t2() {
        return tage19t2;
    }

    public void setTage19t2(int tage19t2) {
        this.tage19t2 = tage19t2;
    }

    public int getTage20m2() {
        return tage20m2;
    }

    public void setTage20m2(int tage20m2) {
        this.tage20m2 = tage20m2;
    }

    public int getTage20f2() {
        return tage20f2;
    }

    public void setTage20f2(int tage20f2) {
        this.tage20f2 = tage20f2;
    }

    public int getTage20t2() {
        return tage20t2;
    }

    public void setTage20t2(int tage20t2) {
        this.tage20t2 = tage20t2;
    }

    public int getTage21m2() {
        return tage21m2;
    }

    public void setTage21m2(int tage21m2) {
        this.tage21m2 = tage21m2;
    }

    public int getTage21f2() {
        return tage21f2;
    }

    public void setTage21f2(int tage21f2) {
        this.tage21f2 = tage21f2;
    }

    public int getTage21t2() {
        return tage21t2;
    }

    public void setTage21t2(int tage21t2) {
        this.tage21t2 = tage21t2;
    }

    public int getTage22m2() {
        return tage22m2;
    }

    public void setTage22m2(int tage22m2) {
        this.tage22m2 = tage22m2;
    }

    public int getTage22f2() {
        return tage22f2;
    }

    public void setTage22f2(int tage22f2) {
        this.tage22f2 = tage22f2;
    }

    public int getTage22t2() {
        return tage22t2;
    }

    public void setTage22t2(int tage22t2) {
        this.tage22t2 = tage22t2;
    }

    public int getTage23m2() {
        return tage23m2;
    }

    public void setTage23m2(int tage23m2) {
        this.tage23m2 = tage23m2;
    }

    public int getTage23f2() {
        return tage23f2;
    }

    public void setTage23f2(int tage23f2) {
        this.tage23f2 = tage23f2;
    }

    public int getTage23t2() {
        return tage23t2;
    }

    public void setTage23t2(int tage23t2) {
        this.tage23t2 = tage23t2;
    }

    public int getTage24m2() {
        return tage24m2;
    }

    public void setTage24m2(int tage24m2) {
        this.tage24m2 = tage24m2;
    }

    public int getTage24f2() {
        return tage24f2;
    }

    public void setTage24f2(int tage24f2) {
        this.tage24f2 = tage24f2;
    }

    public int getTage24t2() {
        return tage24t2;
    }

    public void setTage24t2(int tage24t2) {
        this.tage24t2 = tage24t2;
    }

    public int getTage25m2() {
        return tage25m2;
    }

    public void setTage25m2(int tage25m2) {
        this.tage25m2 = tage25m2;
    }

    public int getTage25f2() {
        return tage25f2;
    }

    public void setTage25f2(int tage25f2) {
        this.tage25f2 = tage25f2;
    }

    public int getTage25t2() {
        return tage25t2;
    }

    public void setTage25t2(int tage25t2) {
        this.tage25t2 = tage25t2;
    }

    public int getTage26m2() {
        return tage26m2;
    }

    public void setTage26m2(int tage26m2) {
        this.tage26m2 = tage26m2;
    }

    public int getTage26f2() {
        return tage26f2;
    }

    public void setTage26f2(int tage26f2) {
        this.tage26f2 = tage26f2;
    }

    public int getTage26t2() {
        return tage26t2;
    }

    public void setTage26t2(int tage26t2) {
        this.tage26t2 = tage26t2;
    }

    public int getTage27m2() {
        return tage27m2;
    }

    public void setTage27m2(int tage27m2) {
        this.tage27m2 = tage27m2;
    }

    public int getTage27f2() {
        return tage27f2;
    }

    public void setTage27f2(int tage27f2) {
        this.tage27f2 = tage27f2;
    }

    public int getTage27t2() {
        return tage27t2;
    }

    public void setTage27t2(int tage27t2) {
        this.tage27t2 = tage27t2;
    }

    public int getTage28m2() {
        return tage28m2;
    }

    public void setTage28m2(int tage28m2) {
        this.tage28m2 = tage28m2;
    }

    public int getTage28f2() {
        return tage28f2;
    }

    public void setTage28f2(int tage28f2) {
        this.tage28f2 = tage28f2;
    }

    public int getTage28t2() {
        return tage28t2;
    }

    public void setTage28t2(int tage28t2) {
        this.tage28t2 = tage28t2;
    }

    public int getTage29m2() {
        return tage29m2;
    }

    public void setTage29m2(int tage29m2) {
        this.tage29m2 = tage29m2;
    }

    public int getTage29f2() {
        return tage29f2;
    }

    public void setTage29f2(int tage29f2) {
        this.tage29f2 = tage29f2;
    }

    public int getTage29t2() {
        return tage29t2;
    }

    public void setTage29t2(int tage29t2) {
        this.tage29t2 = tage29t2;
    }

    public int getTage30m2() {
        return tage30m2;
    }

    public void setTage30m2(int tage30m2) {
        this.tage30m2 = tage30m2;
    }

    public int getTage30f2() {
        return tage30f2;
    }

    public void setTage30f2(int tage30f2) {
        this.tage30f2 = tage30f2;
    }

    public int getTage30t2() {
        return tage30t2;
    }

    public void setTage30t2(int tage30t2) {
        this.tage30t2 = tage30t2;
    }

    public int getTage31m2() {
        return tage31m2;
    }

    public void setTage31m2(int tage31m2) {
        this.tage31m2 = tage31m2;
    }

    public int getTage31f2() {
        return tage31f2;
    }

    public void setTage31f2(int tage31f2) {
        this.tage31f2 = tage31f2;
    }

    public int getTage31t2() {
        return tage31t2;
    }

    public void setTage31t2(int tage31t2) {
        this.tage31t2 = tage31t2;
    }

    public int getTage32m2() {
        return tage32m2;
    }

    public void setTage32m2(int tage32m2) {
        this.tage32m2 = tage32m2;
    }

    public int getTage32f2() {
        return tage32f2;
    }

    public void setTage32f2(int tage32f2) {
        this.tage32f2 = tage32f2;
    }

    public int getTage32t2() {
        return tage32t2;
    }

    public void setTage32t2(int tage32t2) {
        this.tage32t2 = tage32t2;
    }

    public int getTage33m2() {
        return tage33m2;
    }

    public void setTage33m2(int tage33m2) {
        this.tage33m2 = tage33m2;
    }

    public int getTage33f2() {
        return tage33f2;
    }

    public void setTage33f2(int tage33f2) {
        this.tage33f2 = tage33f2;
    }

    public int getTage33t2() {
        return tage33t2;
    }

    public void setTage33t2(int tage33t2) {
        this.tage33t2 = tage33t2;
    }

    public int getTageSup34m2() {
        return tageSup34m2;
    }

    public void setTageSup34m2(int tageSup34m2) {
        this.tageSup34m2 = tageSup34m2;
    }

    public int getTageSup34f2() {
        return tageSup34f2;
    }

    public void setTageSup34f2(int tageSup34f2) {
        this.tageSup34f2 = tageSup34f2;
    }

    public int getTageSup34t2() {
        return tageSup34t2;
    }

    public void setTageSup34t2(int tageSup34t2) {
        this.tageSup34t2 = tageSup34t2;
    }

    public int getTtt2() {
        return ttt2;
    }

    public void setTtt2(int ttt2) {
        this.ttt2 = ttt2;
    }

    public int getTetranger2() {
        return tetranger2;
    }

    public void setTetranger2(int tetranger2) {
        this.tetranger2 = tetranger2;
    }

    public int getTageInf18f1() {
        return tageInf18f1;
    }

    public void setTageInf18f1(int tageInf18f1) {
        this.tageInf18f1 = tageInf18f1;
    }

    public int getTageInf18m1() {
        return tageInf18m1;
    }

    public void setTageInf18m1(int tageInf18m1) {
        this.tageInf18m1 = tageInf18m1;
    }

    public int getTageInf18t1() {
        return tageInf18t1;
    }

    public void setTageInf18t1(int tageInf18t1) {
        this.tageInf18t1 = tageInf18t1;
    }

    public int getTage18f1() {
        return tage18f1;
    }

    public void setTage18f1(int tage18f1) {
        this.tage18f1 = tage18f1;
    }

    public int getTage18m1() {
        return tage18m1;
    }

    public void setTage18m1(int tage18m1) {
        this.tage18m1 = tage18m1;
    }

    public int getTage18t1() {
        return tage18t1;
    }

    public void setTage18t1(int tage18t1) {
        this.tage18t1 = tage18t1;
    }

    public int getTage19f1() {
        return tage19f1;
    }

    public void setTage19f1(int tage19f1) {
        this.tage19f1 = tage19f1;
    }

    public int getTage19m1() {
        return tage19m1;
    }

    public void setTage19m1(int tage19m1) {
        this.tage19m1 = tage19m1;
    }

    public int getTage19t1() {
        return tage19t1;
    }

    public void setTage19t1(int tage19t1) {
        this.tage19t1 = tage19t1;
    }

    public int getTage20m1() {
        return tage20m1;
    }

    public void setTage20m1(int tage20m1) {
        this.tage20m1 = tage20m1;
    }

    public int getTage20f1() {
        return tage20f1;
    }

    public void setTage20f1(int tage20f1) {
        this.tage20f1 = tage20f1;
    }

    public int getTage20t1() {
        return tage20t1;
    }

    public void setTage20t1(int tage20t1) {
        this.tage20t1 = tage20t1;
    }

    public int getTage21m1() {
        return tage21m1;
    }

    public void setTage21m1(int tage21m1) {
        this.tage21m1 = tage21m1;
    }

    public int getTage21f1() {
        return tage21f1;
    }

    public void setTage21f1(int tage21f1) {
        this.tage21f1 = tage21f1;
    }

    public int getTage21t1() {
        return tage21t1;
    }

    public void setTage21t1(int tage21t1) {
        this.tage21t1 = tage21t1;
    }

    public int getTage22m1() {
        return tage22m1;
    }

    public void setTage22m1(int tage22m1) {
        this.tage22m1 = tage22m1;
    }

    public int getTage22f1() {
        return tage22f1;
    }

    public void setTage22f1(int tage22f1) {
        this.tage22f1 = tage22f1;
    }

    public int getTage22t1() {
        return tage22t1;
    }

    public void setTage22t1(int tage22t1) {
        this.tage22t1 = tage22t1;
    }

    public int getTage23m1() {
        return tage23m1;
    }

    public void setTage23m1(int tage23m1) {
        this.tage23m1 = tage23m1;
    }

    public int getTage23f1() {
        return tage23f1;
    }

    public void setTage23f1(int tage23f1) {
        this.tage23f1 = tage23f1;
    }

    public int getTage23t1() {
        return tage23t1;
    }

    public void setTage23t1(int tage23t1) {
        this.tage23t1 = tage23t1;
    }

    public int getTage24m1() {
        return tage24m1;
    }

    public void setTage24m1(int tage24m1) {
        this.tage24m1 = tage24m1;
    }

    public int getTage24f1() {
        return tage24f1;
    }

    public void setTage24f1(int tage24f1) {
        this.tage24f1 = tage24f1;
    }

    public int getTage24t1() {
        return tage24t1;
    }

    public void setTage24t1(int tage24t1) {
        this.tage24t1 = tage24t1;
    }

    public int getTage25m1() {
        return tage25m1;
    }

    public void setTage25m1(int tage25m1) {
        this.tage25m1 = tage25m1;
    }

    public int getTage25f1() {
        return tage25f1;
    }

    public void setTage25f1(int tage25f1) {
        this.tage25f1 = tage25f1;
    }

    public int getTage25t1() {
        return tage25t1;
    }

    public void setTage25t1(int tage25t1) {
        this.tage25t1 = tage25t1;
    }

    public int getTage26m1() {
        return tage26m1;
    }

    public void setTage26m1(int tage26m1) {
        this.tage26m1 = tage26m1;
    }

    public int getTage26f1() {
        return tage26f1;
    }

    public void setTage26f1(int tage26f1) {
        this.tage26f1 = tage26f1;
    }

    public int getTage26t1() {
        return tage26t1;
    }

    public void setTage26t1(int tage26t1) {
        this.tage26t1 = tage26t1;
    }

    public int getTage27m1() {
        return tage27m1;
    }

    public void setTage27m1(int tage27m1) {
        this.tage27m1 = tage27m1;
    }

    public int getTage27f1() {
        return tage27f1;
    }

    public void setTage27f1(int tage27f1) {
        this.tage27f1 = tage27f1;
    }

    public int getTage27t1() {
        return tage27t1;
    }

    public void setTage27t1(int tage27t1) {
        this.tage27t1 = tage27t1;
    }

    public int getTage28m1() {
        return tage28m1;
    }

    public void setTage28m1(int tage28m1) {
        this.tage28m1 = tage28m1;
    }

    public int getTage28f1() {
        return tage28f1;
    }

    public void setTage28f1(int tage28f1) {
        this.tage28f1 = tage28f1;
    }

    public int getTage28t1() {
        return tage28t1;
    }

    public void setTage28t1(int tage28t1) {
        this.tage28t1 = tage28t1;
    }

    public int getTage29m1() {
        return tage29m1;
    }

    public void setTage29m1(int tage29m1) {
        this.tage29m1 = tage29m1;
    }

    public int getTage29f1() {
        return tage29f1;
    }

    public void setTage29f1(int tage29f1) {
        this.tage29f1 = tage29f1;
    }

    public int getTage29t1() {
        return tage29t1;
    }

    public void setTage29t1(int tage29t1) {
        this.tage29t1 = tage29t1;
    }

    public int getTage30m1() {
        return tage30m1;
    }

    public void setTage30m1(int tage30m1) {
        this.tage30m1 = tage30m1;
    }

    public int getTage30f1() {
        return tage30f1;
    }

    public void setTage30f1(int tage30f1) {
        this.tage30f1 = tage30f1;
    }

    public int getTage30t1() {
        return tage30t1;
    }

    public void setTage30t1(int tage30t1) {
        this.tage30t1 = tage30t1;
    }

    public int getTage31m1() {
        return tage31m1;
    }

    public void setTage31m1(int tage31m1) {
        this.tage31m1 = tage31m1;
    }

    public int getTage31f1() {
        return tage31f1;
    }

    public void setTage31f1(int tage31f1) {
        this.tage31f1 = tage31f1;
    }

    public int getTage31t1() {
        return tage31t1;
    }

    public void setTage31t1(int tage31t1) {
        this.tage31t1 = tage31t1;
    }

    public int getTage32m1() {
        return tage32m1;
    }

    public void setTage32m1(int tage32m1) {
        this.tage32m1 = tage32m1;
    }

    public int getTage32f1() {
        return tage32f1;
    }

    public void setTage32f1(int tage32f1) {
        this.tage32f1 = tage32f1;
    }

    public int getTage32t1() {
        return tage32t1;
    }

    public void setTage32t1(int tage32t1) {
        this.tage32t1 = tage32t1;
    }

    public int getTage33m1() {
        return tage33m1;
    }

    public void setTage33m1(int tage33m1) {
        this.tage33m1 = tage33m1;
    }

    public int getTage33f1() {
        return tage33f1;
    }

    public void setTage33f1(int tage33f1) {
        this.tage33f1 = tage33f1;
    }

    public int getTage33t1() {
        return tage33t1;
    }

    public void setTage33t1(int tage33t1) {
        this.tage33t1 = tage33t1;
    }

    public int getTageSup34m1() {
        return tageSup34m1;
    }

    public void setTageSup34m1(int tageSup34m1) {
        this.tageSup34m1 = tageSup34m1;
    }

    public int getTageSup34f1() {
        return tageSup34f1;
    }

    public void setTageSup34f1(int tageSup34f1) {
        this.tageSup34f1 = tageSup34f1;
    }

    public int getTageSup34t1() {
        return tageSup34t1;
    }

    public void setTageSup34t1(int tageSup34t1) {
        this.tageSup34t1 = tageSup34t1;
    }

    public int getTtt1() {
        return ttt1;
    }

    public void setTtt1(int ttt1) {
        this.ttt1 = ttt1;
    }

    public int getTetranger1() {
        return tetranger1;
    }

    public void setTetranger1(int tetranger1) {
        this.tetranger1 = tetranger1;
    }

    public List<FiliereNiveauAgeGenre> getNiveauAgeGenres1() {
        return niveauAgeGenres1;
    }

    public void setNiveauAgeGenres1(List<FiliereNiveauAgeGenre> niveauAgeGenres1) {
        this.niveauAgeGenres1 = niveauAgeGenres1;
    }

    public List<FiliereNiveauAgeGenre> getNiveauAgeGenres2() {
        return niveauAgeGenres2;
    }

    public void setNiveauAgeGenres2(List<FiliereNiveauAgeGenre> niveauAgeGenres2) {
        this.niveauAgeGenres2 = niveauAgeGenres2;
    }

    public List<FiliereNiveauAgeGenre> getNiveauAgeGenres3() {
        return niveauAgeGenres3;
    }

    public void setNiveauAgeGenres3(List<FiliereNiveauAgeGenre> niveauAgeGenres3) {
        this.niveauAgeGenres3 = niveauAgeGenres3;
    }

    public List<FiliereNiveauAgeGenre> getNiveauAgeGenres4() {
        return niveauAgeGenres4;
    }

    public void setNiveauAgeGenres4(List<FiliereNiveauAgeGenre> niveauAgeGenres4) {
        this.niveauAgeGenres4 = niveauAgeGenres4;
    }

    public List<Inscription> getInscriptions1() {
        return inscriptions1;
    }

    public void setInscriptions1(List<Inscription> inscriptions1) {
        this.inscriptions1 = inscriptions1;
    }

    public List<Inscription> getInscriptions2() {
        return inscriptions2;
    }

    public void setInscriptions2(List<Inscription> inscriptions2) {
        this.inscriptions2 = inscriptions2;
    }

    public List<Inscription> getInscriptions3() {
        return inscriptions3;
    }

    public void setInscriptions3(List<Inscription> inscriptions3) {
        this.inscriptions3 = inscriptions3;
    }

    public List<Inscription> getInscriptions4() {
        return inscriptions4;
    }

    public void setInscriptions4(List<Inscription> inscriptions4) {
        this.inscriptions4 = inscriptions4;
    }

    public List<FiliereNiveauAgeGenre> getNiveauAgeGenres() {
        return niveauAgeGenres;
    }

    public void setNiveauAgeGenres(List<FiliereNiveauAgeGenre> niveauAgeGenres) {
        this.niveauAgeGenres = niveauAgeGenres;
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

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    //@PostConstruct
    public void statAge() {
        System.out.println("Statistique par tage");
        String annee = anneeAccademique.getAnnee();
        System.out.println(" " + annee);
        try {
            Calendar date = Calendar.getInstance();
            int anneeActuelle = date.get(Calendar.YEAR);
            AnneeAccademique anAc = anneeAccademiqueService.findAnneeByAnnee(annee);
            System.out.println("" + anAc);
            Niveau niveau1 = niveauService.findNiveauByNom("LICENCE I");
            Niveau niveau2 = niveauService.findNiveauByNom("LICENCE II");
            Niveau niveau3 = niveauService.findNiveauByNom("LICENCE III");
            Niveau niveau4 = niveauService.findNiveauByNom("MASTER I");
            Niveau niveau5 = niveauService.findNiveauByNom("MASTER II");
            PaysOrigine p = paysOrigineService.getPaysByNom("CAMEROUN");
//            System.out.println("+++++++++++++++++++les niveaux et le pays+++++++++++++++++++++++");
//            System.out.println("Licence I :" + niveau1);
//            System.out.println("Licence II :" + niveau2);
//            System.out.println("Licence III :" + niveau3);
//            System.out.println("Master I :" + niveau4);
//            System.out.println("Master II :" + niveau5);
//            System.out.println("Cameroun :" + p);
            niveauAgeGenres = new ArrayList<FiliereNiveauAgeGenre>();
            niveauAgeGenres1 = new ArrayList<FiliereNiveauAgeGenre>();
            niveauAgeGenres2 = new ArrayList<FiliereNiveauAgeGenre>();
            niveauAgeGenres3 = new ArrayList<FiliereNiveauAgeGenre>();
            niveauAgeGenres4 = new ArrayList<FiliereNiveauAgeGenre>();

            //Initialiation des totaux
            tageInf18f = 0;
            tageInf18m = 0;
            tageInf18t = 0;
            tage18f = 0;
            tage18m = 0;
            tage18t = 0;
            tage19f = 0;
            tage19m = 0;
            tage19t = 0;
            tage20m = 0;
            tage20f = 0;
            tage20t = 0;
            tage21m = 0;
            tage21f = 0;
            tage21t = 0;
            tage22m = 0;
            tage22f = 0;
            tage22t = 0;
            tage23m = 0;
            tage23f = 0;
            tage23t = 0;
            tage24m = 0;
            tage24f = 0;
            tage24t = 0;
            tage25m = 0;
            tage25f = 0;
            tage25t = 0;
            tage26m = 0;
            tage26f = 0;
            tage26t = 0;
            tage27m = 0;
            tage27f = 0;
            tage27t = 0;
            tage28m = 0;
            tage28f = 0;
            tage28t = 0;
            tage29m = 0;
            tage29f = 0;
            tage29t = 0;
            tage30m = 0;
            tage30f = 0;
            tage30t = 0;
            tage31m = 0;
            tage31f = 0;
            tage31t = 0;
            tage32m = 0;
            tage32f = 0;
            tage32t = 0;
            tage33m = 0;
            tage33f = 0;
            tage33t = 0;
            tageSup34m = 0;
            tageSup34f = 0;
            tageSup34t = 0;
            ttt = 0;
            tetranger = 0;

            tageInf18f1 = 0;
            tageInf18m1 = 0;
            tageInf18t1 = 0;
            tage18f1 = 0;
            tage18m1 = 0;
            tage18t1 = 0;
            tage19f1 = 0;
            tage19m1 = 0;
            tage19t1 = 0;
            tage20m1 = 0;
            tage20f1 = 0;
            tage20t1 = 0;
            tage21m1 = 0;
            tage21f1 = 0;
            tage21t1 = 0;
            tage22m1 = 0;
            tage22f1 = 0;
            tage22t1 = 0;
            tage23m1 = 0;
            tage23f1 = 0;
            tage23t1 = 0;
            tage24m1 = 0;
            tage24f1 = 0;
            tage24t1 = 0;
            tage25m1 = 0;
            tage25f1 = 0;
            tage25t1 = 0;
            tage26m1 = 0;
            tage26f1 = 0;
            tage26t1 = 0;
            tage27m1 = 0;
            tage27f1 = 0;
            tage27t1 = 0;
            tage28m1 = 0;
            tage28f1 = 0;
            tage28t1 = 0;
            tage29m1 = 0;
            tage29f1 = 0;
            tage29t1 = 0;
            tage30m1 = 0;
            tage30f1 = 0;
            tage30t1 = 0;
            tage31m1 = 0;
            tage31f1 = 0;
            tage31t1 = 0;
            tage32m1 = 0;
            tage32f1 = 0;
            tage32t1 = 0;
            tage33m1 = 0;
            tage33f1 = 0;
            tage33t1 = 0;
            tageSup34m1 = 0;
            tageSup34f1 = 0;
            tageSup34t1 = 0;
            ttt1 = 0;
            tetranger1 = 0;

            tageInf18f2 = 0;
            tageInf18m2 = 0;
            tageInf18t2 = 0;
            tage18f2 = 0;
            tage18m2 = 0;
            tage18t2 = 0;
            tage19f2 = 0;
            tage19m2 = 0;
            tage19t2 = 0;
            tage20m2 = 0;
            tage20f2 = 0;
            tage20t2 = 0;
            tage21m2 = 0;
            tage21f2 = 0;
            tage21t2 = 0;
            tage22m2 = 0;
            tage22f2 = 0;
            tage22t2 = 0;
            tage23m2 = 0;
            tage23f2 = 0;
            tage23t2 = 0;
            tage24m2 = 0;
            tage24f2 = 0;
            tage24t2 = 0;
            tage25m2 = 0;
            tage25f2 = 0;
            tage25t2 = 0;
            tage26m2 = 0;
            tage26f2 = 0;
            tage26t2 = 0;
            tage27m2 = 0;
            tage27f2 = 0;
            tage27t2 = 0;
            tage28m2 = 0;
            tage28f2 = 0;
            tage28t2 = 0;
            tage29m2 = 0;
            tage29f2 = 0;
            tage29t2 = 0;
            tage30m2 = 0;
            tage30f2 = 0;
            tage30t2 = 0;
            tage31m2 = 0;
            tage31f2 = 0;
            tage31t2 = 0;
            tage32m2 = 0;
            tage32f2 = 0;
            tage32t2 = 0;
            tage33m2 = 0;
            tage33f2 = 0;
            tage33t2 = 0;
            tageSup34m2 = 0;
            tageSup34f2 = 0;
            tageSup34t2 = 0;
            ttt2 = 0;
            tetranger2 = 0;

            tageInf18f3 = 0;
            tageInf18m3 = 0;
            tageInf18t3 = 0;
            tage18f3 = 0;
            tage18m3 = 0;
            tage18t3 = 0;
            tage19f3 = 0;
            tage19m3 = 0;
            tage19t3 = 0;
            tage20m3 = 0;
            tage20f3 = 0;
            tage20t3 = 0;
            tage21m3 = 0;
            tage21f3 = 0;
            tage21t3 = 0;
            tage22m3 = 0;
            tage22f3 = 0;
            tage22t3 = 0;
            tage23m3 = 0;
            tage23f3 = 0;
            tage23t3 = 0;
            tage24m3 = 0;
            tage24f3 = 0;
            tage24t3 = 0;
            tage25m3 = 0;
            tage25f3 = 0;
            tage25t3 = 0;
            tage26m3 = 0;
            tage26f3 = 0;
            tage26t3 = 0;
            tage27m3 = 0;
            tage27f3 = 0;
            tage27t3 = 0;
            tage28m3 = 0;
            tage28f3 = 0;
            tage28t3 = 0;
            tage29m3 = 0;
            tage29f3 = 0;
            tage29t3 = 0;
            tage30m3 = 0;
            tage30f3 = 0;
            tage30t3 = 0;
            tage31m3 = 0;
            tage31f3 = 0;
            tage31t3 = 0;
            tage32m3 = 0;
            tage32f3 = 0;
            tage32t3 = 0;
            tage33m3 = 0;
            tage33f3 = 0;
            tage33t3 = 0;
            tageSup34m3 = 0;
            tageSup34f3 = 0;
            tageSup34t3 = 0;
            ttt3 = 0;
            tetranger3 = 0;

            tageInf18f4 = 0;
            tageInf18m4 = 0;
            tageInf18t4 = 0;
            tage18f4 = 0;
            tage18m4 = 0;
            tage18t4 = 0;
            tage19f4 = 0;
            tage19m4 = 0;
            tage19t4 = 0;
            tage20m4 = 0;
            tage20f4 = 0;
            tage20t4 = 0;
            tage21m4 = 0;
            tage21f4 = 0;
            tage21t4 = 0;
            tage22m4 = 0;
            tage22f4 = 0;
            tage22t4 = 0;
            tage23m4 = 0;
            tage23f4 = 0;
            tage23t4 = 0;
            tage24m4 = 0;
            tage24f4 = 0;
            tage24t4 = 0;
            tage25m4 = 0;
            tage25f4 = 0;
            tage25t4 = 0;
            tage26m4 = 0;
            tage26f4 = 0;
            tage26t4 = 0;
            tage27m4 = 0;
            tage27f4 = 0;
            tage27t4 = 0;
            tage28m4 = 0;
            tage28f4 = 0;
            tage28t4 = 0;
            tage29m4 = 0;
            tage29f4 = 0;
            tage29t4 = 0;
            tage30m4 = 0;
            tage30f4 = 0;
            tage30t4 = 0;
            tage31m4 = 0;
            tage31f4 = 0;
            tage31t4 = 0;
            tage32m4 = 0;
            tage32f4 = 0;
            tage32t4 = 0;
            tage33m4 = 0;
            tage33f4 = 0;
            tage33t4 = 0;
            tageSup34m4 = 0;
            tageSup34f4 = 0;
            tageSup34t4 = 0;
            ttt4 = 0;
            tetranger4 = 0;

            List<Filiere> filieres1 = filiereService.findAllFiliere();
            for (Filiere filiere1 : filieres1) {
                inscriptions = inscriptionService.findInscriptionByFiliereNiveauAnnee(filiere1, niveau1, p, anAc);
                inscriptions1 = inscriptionService.findInscriptionByFiliereNiveauAnnee(filiere1, niveau2, p, anAc);
                inscriptions2 = inscriptionService.findInscriptionByFiliereNiveauAnnee(filiere1, niveau3, p, anAc);
                inscriptions3 = inscriptionService.findInscriptionByFiliereNiveauAnnee(filiere1, niveau4, p, anAc);
                inscriptions4 = inscriptionService.findInscriptionByFiliereNiveauAnnee(filiere1, niveau5, p, anAc);

                int ageInf18f = 0;
                int ageInf18m = 0;
                int ageInf18t = 0;
                int age18f = 0;
                int age18m = 0;
                int age18t = 0;
                int age19f = 0;
                int age19m = 0;
                int age19t = 0;
                int age20m = 0;
                int age20f = 0;
                int age20t = 0;
                int age21m = 0;
                int age21f = 0;
                int age21t = 0;
                int age22m = 0;
                int age22f = 0;
                int age22t = 0;
                int age23m = 0;
                int age23f = 0;
                int age23t = 0;
                int age24m = 0;
                int age24f = 0;
                int age24t = 0;
                int age25m = 0;
                int age25f = 0;
                int age25t = 0;
                int age26m = 0;
                int age26f = 0;
                int age26t = 0;
                int age27m = 0;
                int age27f = 0;
                int age27t = 0;
                int age28m = 0;
                int age28f = 0;
                int age28t = 0;
                int age29m = 0;
                int age29f = 0;
                int age29t = 0;
                int age30m = 0;
                int age30f = 0;
                int age30t = 0;
                int age31m = 0;
                int age31f = 0;
                int age31t = 0;
                int age32m = 0;
                int age32f = 0;
                int age32t = 0;
                int age33m = 0;
                int age33f = 0;
                int age33t = 0;
                int ageSup34m = 0;
                int ageSup34f = 0;
                int ageSup34t = 0;
                int tt = 0;
                int etranger = 0;

                int ageInf18f1 = 0;
                int ageInf18m1 = 0;
                int ageInf18t1 = 0;
                int age18f1 = 0;
                int age18m1 = 0;
                int age18t1 = 0;
                int age19f1 = 0;
                int age19m1 = 0;
                int age19t1 = 0;
                int age20m1 = 0;
                int age20f1 = 0;
                int age20t1 = 0;
                int age21m1 = 0;
                int age21f1 = 0;
                int age21t1 = 0;
                int age22m1 = 0;
                int age22f1 = 0;
                int age22t1 = 0;
                int age23m1 = 0;
                int age23f1 = 0;
                int age23t1 = 0;
                int age24m1 = 0;
                int age24f1 = 0;
                int age24t1 = 0;
                int age25m1 = 0;
                int age25f1 = 0;
                int age25t1 = 0;
                int age26m1 = 0;
                int age26f1 = 0;
                int age26t1 = 0;
                int age27m1 = 0;
                int age27f1 = 0;
                int age27t1 = 0;
                int age28m1 = 0;
                int age28f1 = 0;
                int age28t1 = 0;
                int age29m1 = 0;
                int age29f1 = 0;
                int age29t1 = 0;
                int age30m1 = 0;
                int age30f1 = 0;
                int age30t1 = 0;
                int age31m1 = 0;
                int age31f1 = 0;
                int age31t1 = 0;
                int age32m1 = 0;
                int age32f1 = 0;
                int age32t1 = 0;
                int age33m1 = 0;
                int age33f1 = 0;
                int age33t1 = 0;
                int ageSup34m1 = 0;
                int ageSup34f1 = 0;
                int ageSup34t1 = 0;
                int tt1 = 0;
                int etranger1 = 0;

                int ageInf18f2 = 0;
                int ageInf18m2 = 0;
                int ageInf18t2 = 0;
                int age18f2 = 0;
                int age18m2 = 0;
                int age18t2 = 0;
                int age19f2 = 0;
                int age19m2 = 0;
                int age19t2 = 0;
                int age20m2 = 0;
                int age20f2 = 0;
                int age20t2 = 0;
                int age21m2 = 0;
                int age21f2 = 0;
                int age21t2 = 0;
                int age22m2 = 0;
                int age22f2 = 0;
                int age22t2 = 0;
                int age23m2 = 0;
                int age23f2 = 0;
                int age23t2 = 0;
                int age24m2 = 0;
                int age24f2 = 0;
                int age24t2 = 0;
                int age25m2 = 0;
                int age25f2 = 0;
                int age25t2 = 0;
                int age26m2 = 0;
                int age26f2 = 0;
                int age26t2 = 0;
                int age27m2 = 0;
                int age27f2 = 0;
                int age27t2 = 0;
                int age28m2 = 0;
                int age28f2 = 0;
                int age28t2 = 0;
                int age29m2 = 0;
                int age29f2 = 0;
                int age29t2 = 0;
                int age30m2 = 0;
                int age30f2 = 0;
                int age30t2 = 0;
                int age31m2 = 0;
                int age31f2 = 0;
                int age31t2 = 0;
                int age32m2 = 0;
                int age32f2 = 0;
                int age32t2 = 0;
                int age33m2 = 0;
                int age33f2 = 0;
                int age33t2 = 0;
                int ageSup34m2 = 0;
                int ageSup34f2 = 0;
                int ageSup34t2 = 0;
                int tt2 = 0;
                int etranger2 = 0;

                int ageInf18f3 = 0;
                int ageInf18m3 = 0;
                int ageInf18t3 = 0;
                int age18f3 = 0;
                int age18m3 = 0;
                int age18t3 = 0;
                int age19f3 = 0;
                int age19m3 = 0;
                int age19t3 = 0;
                int age20m3 = 0;
                int age20f3 = 0;
                int age20t3 = 0;
                int age21m3 = 0;
                int age21f3 = 0;
                int age21t3 = 0;
                int age22m3 = 0;
                int age22f3 = 0;
                int age22t3 = 0;
                int age23m3 = 0;
                int age23f3 = 0;
                int age23t3 = 0;
                int age24m3 = 0;
                int age24f3 = 0;
                int age24t3 = 0;
                int age25m3 = 0;
                int age25f3 = 0;
                int age25t3 = 0;
                int age26m3 = 0;
                int age26f3 = 0;
                int age26t3 = 0;
                int age27m3 = 0;
                int age27f3 = 0;
                int age27t3 = 0;
                int age28m3 = 0;
                int age28f3 = 0;
                int age28t3 = 0;
                int age29m3 = 0;
                int age29f3 = 0;
                int age29t3 = 0;
                int age30m3 = 0;
                int age30f3 = 0;
                int age30t3 = 0;
                int age31m3 = 0;
                int age31f3 = 0;
                int age31t3 = 0;
                int age32m3 = 0;
                int age32f3 = 0;
                int age32t3 = 0;
                int age33m3 = 0;
                int age33f3 = 0;
                int age33t3 = 0;
                int ageSup34m3 = 0;
                int ageSup34f3 = 0;
                int ageSup34t3 = 0;
                int tt3 = 0;
                int etranger3 = 0;

                int ageInf18f4 = 0;
                int ageInf18m4 = 0;
                int ageInf18t4 = 0;
                int age18f4 = 0;
                int age18m4 = 0;
                int age18t4 = 0;
                int age19f4 = 0;
                int age19m4 = 0;
                int age19t4 = 0;
                int age20m4 = 0;
                int age20f4 = 0;
                int age20t4 = 0;
                int age21m4 = 0;
                int age21f4 = 0;
                int age21t4 = 0;
                int age22m4 = 0;
                int age22f4 = 0;
                int age22t4 = 0;
                int age23m4 = 0;
                int age23f4 = 0;
                int age23t4 = 0;
                int age24m4 = 0;
                int age24f4 = 0;
                int age24t4 = 0;
                int age25m4 = 0;
                int age25f4 = 0;
                int age25t4 = 0;
                int age26m4 = 0;
                int age26f4 = 0;
                int age26t4 = 0;
                int age27m4 = 0;
                int age27f4 = 0;
                int age27t4 = 0;
                int age28m4 = 0;
                int age28f4 = 0;
                int age28t4 = 0;
                int age29m4 = 0;
                int age29f4 = 0;
                int age29t4 = 0;
                int age30m4 = 0;
                int age30f4 = 0;
                int age30t4 = 0;
                int age31m4 = 0;
                int age31f4 = 0;
                int age31t4 = 0;
                int age32m4 = 0;
                int age32f4 = 0;
                int age32t4 = 0;
                int age33m4 = 0;
                int age33f4 = 0;
                int age33t4 = 0;
                int ageSup34m4 = 0;
                int ageSup34f4 = 0;
                int ageSup34t4 = 0;
                int tt4 = 0;
                int etranger4 = 0;
                //pour le niveau 1
                for (Inscription in : inscriptions) {
                    String an = in.getEtudiant().getDate_naiss().substring(6);
                    /// System.out.println(in4.getEtudiant().getMatricule() + " " + in4.getEtudiant().getDate_naiss() + "  " + in.getEtudiant().getNom());
                    int anneeNaiss = Integer.parseInt(an);
                    //System.out.println("" + anneeNaiss);
                    int ageEtudiant = anneeActuelle - anneeNaiss;
                    if (ageEtudiant < 18) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            ageInf18m++;
                        } else {
                            ageInf18f++;
                        }

                    } else if (ageEtudiant == 18) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            age18m++;
                        } else {
                            age18f++;
                        }

                    } else if (ageEtudiant == 19) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            age19m++;
                        } else {
                            age19f++;
                        }

                    } else if (ageEtudiant == 20) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            age20m++;
                        } else {
                            age20f++;
                        }

                    } else if (ageEtudiant == 21) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            age21m++;
                        } else {
                            age21f++;
                        }

                    } else if (ageEtudiant == 22) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            age22m++;
                        } else {
                            age22f++;
                        }

                    } else if (ageEtudiant == 23) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            age23m++;
                        } else {
                            age23f++;
                        }
                    } else if (ageEtudiant == 24) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            age24m++;
                        } else {
                            age24f++;
                        }

                    } else if (ageEtudiant == 25) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            age25m++;
                        } else {
                            age25f++;
                        }

                    } else if (ageEtudiant == 26) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            age26m++;
                        } else {
                            age26f++;
                        }

                    } else if (ageEtudiant == 27) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            age27m++;
                        } else {
                            age27f++;
                        }

                    } else if (ageEtudiant == 28) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            age28m++;
                        } else {
                            age28f++;
                        }

                    } else if (ageEtudiant == 29) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            age29m++;
                        } else {
                            age29f++;
                        }

                    } else if (ageEtudiant == 30) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            age30m++;
                        } else {
                            age30f++;
                        }

                    } else if (ageEtudiant == 31) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            age31m++;
                        } else {
                            age31f++;
                        }

                    } else if (ageEtudiant == 32) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            age32m++;
                        } else {
                            age32f++;
                        }

                    } else if (ageEtudiant == 33) {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            age33m++;
                        } else {
                            age33f++;
                        }

                    } else {
                        if (in.getEtudiant().getGenre().equals("M")) {
                            ageSup34m++;
                        } else {
                            ageSup34f++;
                        }

                    }

                }
                ageInf18t = ageInf18f + ageInf18m;
                age18t = age18f + age18m;
                age19t = age19f + age19m;
                age20t = age20f + age20m;
                age21t = age21f + age21m;
                age22t = age22f + age22m;
                age23t = age23f + age23m;
                age24t = age24f + age24m;
                age25t = age25f + age25m;
                age26t = age26f + age26m;
                age27t = age27f + age27m;
                age28t = age28f + age28m;
                age29t = age29f + age29m;
                age30t = age30f + age30m;
                age31t = age31f + age31m;
                age32t = age32f + age32m;
                age33t = age33f + age33m;
                ageSup34t = ageSup34f + ageSup34m;
                tt = ageInf18t + age18t + age19t + age20t + age21t + age22t + age23t + age24t + age25t + age26t + age27t + age28t + age29t + age30t + age31t + age32t + age33t + ageSup34t;
                etranger = inscriptionService.findInscriptionByFiliereNiveauAnnee(filiere1, niveau1,anAc).size() - inscriptions.size();
                niveauAgeGenres.add(new FiliereNiveauAgeGenre(filiere1.getNom_filiere(), niveau1.getNom_niveau(), ageInf18f, ageInf18m, ageInf18t, age18f, age18m, age18t, age19f, age19m, age19t, age20m, age20f, age20t, age21m, age21f, age21t, age22m, age22f, age22t, age23m, age23f, age23t, age24m, age24f, age24t, age25m, age25f, age25t, age26m, age26f, age26t, age27m, age27f, age27t, age28m, age28f, age28t, age29m, age29f, age29t, age30m, age30f, age30t, age31m, age31f, age31t, age32m, age32f, age32t, age33m, age33f, age33t, ageSup34m, ageSup34f, ageSup34t, tt, etranger));

                //pour les inscription au niveau 2
                for (Inscription in1 : inscriptions1) {
                    String an1 = in1.getEtudiant().getDate_naiss().substring(6);
                    /// System.out.println(in.getEtudiant().getMatricule() + " " + in.getEtudiant().getDate_naiss() + "  " + in.getEtudiant().getNom());
                    int anneeNaiss1 = Integer.parseInt(an1);
                    //System.out.println("" + anneeNaiss);
                    int ageEtudiant1 = anneeActuelle - anneeNaiss1;
                    if (ageEtudiant1 < 18) {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            //ageInf18m++;
                            ageInf18m1++;
                        } else {
                            //ageInf18f++;
                            ageInf18f1++;
                        }

                    } else if (ageEtudiant1 == 18) {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            //age18m++;
                            age18m1++;
                        } else {
                            // age18f++;
                            age18f1++;
                        }

                    } else if (ageEtudiant1 == 19) {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            //age19m++;
                            age19m1++;
                        } else {
                            //age19f++;
                            age19f1++;
                        }

                    } else if (ageEtudiant1 == 20) {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            // age20m++;
                            age20m1++;
                        } else {
                            //age20f++;
                            age20f1++;
                        }

                    } else if (ageEtudiant1 == 21) {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            //age21m++;
                            age21m1++;
                        } else {
                            //age21f++;
                            age21f1++;
                        }

                    } else if (ageEtudiant1 == 22) {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            // age22m++;
                            age22m1++;
                        } else {
                            //age22f++;
                            age22f1++;
                        }

                    } else if (ageEtudiant1 == 23) {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            //age23m++;
                            age23m1++;
                        } else {
                            // age23f++;
                            age23f1++;
                        }
                    } else if (ageEtudiant1 == 24) {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            // age24m++;
                            age24m1++;
                        } else {
                            // age24f++;
                            age24f1++;
                        }

                    } else if (ageEtudiant1 == 25) {
                        if (in1.getEtudiant().getGenre().equals("M")) {

                            age25m1++;
                        } else {
                            //age25f++;
                            age25f1++;
                        }

                    } else if (ageEtudiant1 == 26) {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            //ageInf18m++;
                            age26m1++;
                        } else {
                            //age26f++;
                            age26f1++;
                        }

                    } else if (ageEtudiant1 == 27) {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            //age27m++;
                            age27m1++;
                        } else {
                            //age27f++;
                            age27f1++;
                        }

                    } else if (ageEtudiant1 == 28) {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            //age28m++;
                            age28m1++;
                        } else {
                            // age28f++;
                            age28f1++;
                        }

                    } else if (ageEtudiant1 == 29) {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            // age29m++;
                            age29m1++;
                        } else {
                            // age29f++;
                            age29f1++;
                        }

                    } else if (ageEtudiant1 == 30) {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            //age30m++;
                            age30m1++;
                        } else {
                            ///age30f++;
                            age30f1++;
                        }

                    } else if (ageEtudiant1 == 31) {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            // age31m++;
                            age31m1++;
                        } else {
                            // age31f++;
                            age31f1++;
                        }

                    } else if (ageEtudiant1 == 32) {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            //age32m++;
                            age32m1++;
                        } else {
                            //age32f++;
                            age32f1++;
                        }

                    } else if (ageEtudiant1 == 33) {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            //age33m++;
                            age33m1++;
                        } else {
                            //age33f++;
                            age33f1++;
                        }

                    } else {
                        if (in1.getEtudiant().getGenre().equals("M")) {
                            //ageSup34m++;
                            ageSup34m1++;
                        } else {
                            //ageSup34f++;
                            ageSup34f1++;
                        }

                    }

                }
                ageInf18t1 = ageInf18f1 + ageInf18m1;
                age18t1 = age18f1 + age18m1;
                age19t1 = age19f1 + age19m1;
                age20t1 = age20f1 + age20m1;
                age21t1 = age21f1 + age21m1;
                age22t1 = age22f1 + age22m1;
                age23t1 = age23f1 + age23m1;
                age24t1 = age24f1 + age24m1;
                age25t1 = age25f1 + age25m1;
                age26t1 = age26f1 + age26m1;
                age27t1 = age27f1 + age27m1;
                age28t1 = age28f1 + age28m1;
                age29t1 = age29f1 + age29m1;
                age30t1 = age30f1 + age30m1;
                age31t1 = age31f1 + age31m1;
                age32t1 = age32f1 + age32m1;
                age33t1 = age33f1 + age33m1;
                ageSup34t1 = ageSup34f1 + ageSup34m1;
                tt1 = ageInf18t1 + age18t1 + age19t1 + age20t1 + age21t1 + age22t1 + age23t1 + age24t1 + age25t1 + age26t1 + age27t1 + age28t1 + age29t1 + age30t1 + age31t1 + age32t1 + age33t1 + ageSup34t1;
                etranger1 = inscriptionService.findInscriptionByFiliereNiveauAnnee(filiere1, niveau2,anAc).size() - inscriptions1.size();

                niveauAgeGenres1.add(new FiliereNiveauAgeGenre(filiere1.getNom_filiere(), niveau2.getNom_niveau(), ageInf18f1, ageInf18m1, ageInf18t1, age18f1, age18m1, age18t1, age19f1, age19m1, age19t1, age20m1, age20f1, age20t1, age21m1, age21f1, age21t1, age22m1, age22f1, age22t1, age23m1, age23f1, age23t1, age24m1, age24f1, age24t1, age25m1, age25f1, age25t1, age26m1, age26f1, age26t1, age27m1, age27f1, age27t1, age28m1, age28f1, age28t1, age29m1, age29f1, age29t1, age30m1, age30f1, age30t1, age31m1, age31f1, age31t1, age32m1, age32f1, age32t1, age33m1, age33f1, age33t1, ageSup34m1, ageSup34f1, ageSup34t1, tt1, etranger1));
                //pour niveau3
                for (Inscription in2 : inscriptions2) {
                    String an = in2.getEtudiant().getDate_naiss().substring(6);
                    /// System.out.println(in.getEtudiant().getMatricule() + " " + in.getEtudiant().getDate_naiss() + "  " + in.getEtudiant().getNom());
                    int anneeNaiss = Integer.parseInt(an);
                    //System.out.println("" + anneeNaiss);
                    int ageEtudiant = anneeActuelle - anneeNaiss;
                    if (ageEtudiant < 18) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            ageInf18m2++;
                        } else {
                            ageInf18f2++;
                        }

                    } else if (ageEtudiant == 18) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            age18m2++;
                        } else {
                            age18f2++;
                        }

                    } else if (ageEtudiant == 19) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            age19m2++;
                        } else {
                            age19f2++;
                        }

                    } else if (ageEtudiant == 20) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            age20m2++;
                        } else {
                            age20f2++;
                        }

                    } else if (ageEtudiant == 21) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            age21m2++;
                        } else {
                            age21f2++;
                        }

                    } else if (ageEtudiant == 22) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            age22m2++;
                        } else {
                            age22f2++;
                        }

                    } else if (ageEtudiant == 23) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            age23m2++;
                        } else {
                            age23f2++;
                        }
                    } else if (ageEtudiant == 24) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            age24m2++;
                        } else {
                            age24f2++;
                        }

                    } else if (ageEtudiant == 25) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            age25m2++;
                        } else {
                            age25f2++;
                        }

                    } else if (ageEtudiant == 26) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            age26m2++;
                        } else {
                            age26f2++;
                        }

                    } else if (ageEtudiant == 27) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            age27m2++;
                        } else {
                            age27f2++;
                        }

                    } else if (ageEtudiant == 28) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            age28m2++;
                        } else {
                            age28f2++;
                        }

                    } else if (ageEtudiant == 29) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            age29m2++;
                        } else {
                            age29f2++;
                        }

                    } else if (ageEtudiant == 30) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            age30m2++;
                        } else {
                            age30f2++;
                        }

                    } else if (ageEtudiant == 31) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            age31m2++;
                        } else {
                            age31f2++;
                        }

                    } else if (ageEtudiant == 32) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            age32m2++;
                        } else {
                            age32f2++;
                        }

                    } else if (ageEtudiant == 33) {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            age33m2++;
                        } else {
                            age33f2++;
                        }

                    } else {
                        if (in2.getEtudiant().getGenre().equals("M")) {
                            ageSup34m2++;
                        } else {
                            ageSup34f2++;
                        }

                    }

                }
                ageInf18t2 = ageInf18f2 + ageInf18m2;
                age18t2 = age18f2 + age18m2;
                age19t2 = age19f2 + age19m2;
                age20t2 = age20f2 + age20m2;
                age21t2 = age21f2 + age21m2;
                age22t2 = age22f2 + age22m2;
                age23t2 = age23f2 + age23m2;
                age24t2 = age24f2 + age24m2;
                age25t2 = age25f2 + age25m2;
                age26t2 = age26f2 + age26m2;
                age27t2 = age27f2 + age27m2;
                age28t2 = age28f2 + age28m2;
                age29t2 = age29f2 + age29m2;
                age30t2 = age30f2 + age30m2;
                age31t2 = age31f2 + age31m2;
                age32t2 = age32f2 + age32m2;
                age33t2 = age33f2 + age33m2;
                ageSup34t2 = ageSup34f2 + ageSup34m2;
                tt2 = ageInf18t2 + age18t2 + age19t2 + age20t2 + age21t2 + age22t2 + age23t2 + age24t2 + age25t2 + age26t2 + age27t2 + age28t2 + age29t2 + age30t2 + age31t2 + age32t2 + age33t2 + ageSup34t2;
                etranger2 = inscriptionService.findInscriptionByFiliereNiveauAnnee(filiere1, niveau3,anAc).size() - inscriptions2.size();
                niveauAgeGenres2.add(new FiliereNiveauAgeGenre(filiere1.getNom_filiere(), niveau3.getNom_niveau(), ageInf18f2, ageInf18m2, ageInf18t2, age18f2, age18m2, age18t2, age19f2, age19m2, age19t2, age20m2, age20f2, age20t2, age21m2, age21f2, age21t2, age22m2, age22f2, age22t2, age23m2, age23f2, age23t2, age24m2, age24f2, age24t2, age25m2, age25f2, age25t2, age26m2, age26f2, age26t2, age27m2, age27f2, age27t2, age28m2, age28f2, age28t2, age29m2, age29f2, age29t2, age30m2, age30f2, age30t2, age31m2, age31f2, age31t2, age32m2, age32f2, age32t2, age33m2, age33f2, age33t2, ageSup34m2, ageSup34f2, ageSup34t2, tt2, etranger2));

                //pour niveau4
                for (Inscription in3 : inscriptions3) {
                    String an = in3.getEtudiant().getDate_naiss().substring(6);
                    /// System.out.println(in.getEtudiant().getMatricule() + " " + in.getEtudiant().getDate_naiss() + "  " + in.getEtudiant().getNom());
                    int anneeNaiss = Integer.parseInt(an);
                    //System.out.println("" + anneeNaiss);
                    int ageEtudiant = anneeActuelle - anneeNaiss;
                    if (ageEtudiant < 18) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            ageInf18m3++;
                        } else {
                            ageInf18f3++;
                        }

                    } else if (ageEtudiant == 18) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            age18m3++;
                        } else {
                            age18f3++;
                        }

                    } else if (ageEtudiant == 19) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            age19m3++;
                        } else {
                            age19f3++;
                        }

                    } else if (ageEtudiant == 20) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            age20m3++;
                        } else {
                            age20f3++;
                        }

                    } else if (ageEtudiant == 21) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            age21m3++;
                        } else {
                            age21f3++;
                        }

                    } else if (ageEtudiant == 22) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            age22m3++;
                        } else {
                            age22f3++;
                        }

                    } else if (ageEtudiant == 23) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            age23m3++;
                        } else {
                            age23f3++;
                        }
                    } else if (ageEtudiant == 24) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            age24m3++;
                        } else {
                            age24f3++;
                        }

                    } else if (ageEtudiant == 25) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            age25m3++;
                        } else {
                            age25f3++;
                        }

                    } else if (ageEtudiant == 26) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            age26m3++;
                        } else {
                            age26f3++;
                        }

                    } else if (ageEtudiant == 27) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            age27m3++;
                        } else {
                            age27f3++;
                        }

                    } else if (ageEtudiant == 28) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            age28m3++;
                        } else {
                            age28f3++;
                        }

                    } else if (ageEtudiant == 29) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            age29m3++;
                        } else {
                            age29f3++;
                        }

                    } else if (ageEtudiant == 30) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            age30m3++;
                        } else {
                            age30f3++;
                        }

                    } else if (ageEtudiant == 31) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            age31m3++;
                        } else {
                            age31f3++;
                        }

                    } else if (ageEtudiant == 32) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            age32m3++;
                        } else {
                            age32f3++;
                        }

                    } else if (ageEtudiant == 33) {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            age33m3++;
                        } else {
                            age33f3++;
                        }

                    } else {
                        if (in3.getEtudiant().getGenre().equals("M")) {
                            ageSup34m3++;
                        } else {
                            ageSup34f3++;
                        }

                    }

                }
                ageInf18t3 = ageInf18f3 + ageInf18m3;
                age18t3 = age18f3 + age18m3;
                age19t3 = age19f3 + age19m3;
                age20t3 = age20f3 + age20m3;
                age21t3 = age21f3 + age21m3;
                age22t3 = age22f3 + age22m3;
                age23t3 = age23f3 + age23m3;
                age24t3 = age24f3 + age24m3;
                age25t3 = age25f3 + age25m3;
                age26t3 = age26f3 + age26m3;
                age27t3 = age27f3 + age27m3;
                age28t3 = age28f3 + age28m3;
                age29t3 = age29f3 + age29m3;
                age30t3 = age30f3 + age30m3;
                age31t3 = age31f3 + age31m3;
                age32t3 = age32f3 + age32m3;
                age33t3 = age33f3 + age33m3;
                ageSup34t3 = ageSup34f3 + ageSup34m3;
                tt3 = ageInf18t3 + age18t3 + age19t3 + age20t3 + age21t3 + age22t3 + age23t3 + age24t3 + age25t3 + age26t3 + age27t3 + age28t3 + age29t3 + age30t3 + age31t3 + age32t3 + age33t3 + ageSup34t3;
                etranger3 = inscriptionService.findInscriptionByFiliereNiveauAnnee(filiere1, niveau4,anAc).size() - inscriptions3.size();
                niveauAgeGenres3.add(new FiliereNiveauAgeGenre(filiere1.getNom_filiere(), niveau4.getNom_niveau(), ageInf18f3, ageInf18m3, ageInf18t3, age18f3, age18m3, age18t3, age19f3, age19m3, age19t3, age20m3, age20f3, age20t3, age21m3, age21f3, age21t3, age22m3, age22f3, age22t3, age23m3, age23f3, age23t3, age24m3, age24f3, age24t3, age25m3, age25f3, age25t, age26m3, age26f3, age26t3, age27m3, age27f3, age27t3, age28m3, age28f3, age28t3, age29m3, age29f3, age29t3, age30m3, age30f3, age30t3, age31m3, age31f3, age31t3, age32m3, age32f3, age32t3, age33m3, age33f3, age33t3, ageSup34m3, ageSup34f3, ageSup34t3, tt3, etranger3));


                //pour niveau 5
                for (Inscription in4 : inscriptions4) {
                    String an = in4.getEtudiant().getDate_naiss().substring(6);
                    /// System.out.println(in.getEtudiant().getMatricule() + " " + in.getEtudiant().getDate_naiss() + "  " + in.getEtudiant().getNom());
                    int anneeNaiss = Integer.parseInt(an);
                    //System.out.println("" + anneeNaiss);
                    int ageEtudiant = anneeActuelle - anneeNaiss;
                    if (ageEtudiant < 18) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            ageInf18m4++;
                        } else {
                            ageInf18f4++;
                        }

                    } else if (ageEtudiant == 18) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            age18m4++;
                        } else {
                            age18f4++;
                        }

                    } else if (ageEtudiant == 19) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            age19m4++;
                        } else {
                            age19f4++;
                        }

                    } else if (ageEtudiant == 20) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            age20m4++;
                        } else {
                            age20f4++;
                        }

                    } else if (ageEtudiant == 21) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            age21m4++;
                        } else {
                            age21f4++;
                        }

                    } else if (ageEtudiant == 22) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            age22m4++;
                        } else {
                            age22f4++;
                        }

                    } else if (ageEtudiant == 23) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            age23m4++;
                        } else {
                            age23f4++;
                        }
                    } else if (ageEtudiant == 24) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            age24m4++;
                        } else {
                            age24f4++;
                        }

                    } else if (ageEtudiant == 25) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            age25m4++;
                        } else {
                            age25f4++;
                        }

                    } else if (ageEtudiant == 26) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            age26m4++;
                        } else {
                            age26f4++;
                        }

                    } else if (ageEtudiant == 27) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            age27m4++;
                        } else {
                            age27f4++;
                        }

                    } else if (ageEtudiant == 28) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            age28m4++;
                        } else {
                            age28f4++;
                        }

                    } else if (ageEtudiant == 29) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            age29m4++;
                        } else {
                            age29f4++;
                        }

                    } else if (ageEtudiant == 30) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            age30m4++;
                        } else {
                            age30f4++;
                        }

                    } else if (ageEtudiant == 31) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            age31m4++;
                        } else {
                            age31f4++;
                        }

                    } else if (ageEtudiant == 32) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            age32m4++;
                        } else {
                            age32f4++;
                        }

                    } else if (ageEtudiant == 33) {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            age33m4++;
                        } else {
                            age33f4++;
                        }

                    } else {
                        if (in4.getEtudiant().getGenre().equals("M")) {
                            ageSup34m4++;
                        } else {
                            ageSup34f4++;
                        }

                    }
                }

                //somme des filles des garçons
                ageInf18t4 = ageInf18f4 + ageInf18m4;
                age18t4 = age18f4 + age18m4;
                age19t4 = age19f4 + age19m4;
                age20t4 = age20f4 + age20m4;
                age21t4 = age21f4 + age21m4;
                age22t4 = age22f4 + age22m4;
                age23t4 = age23f4 + age23m4;
                age24t4 = age24f4 + age24m4;
                age25t4 = age25f4 + age25m4;
                age26t4 = age26f4 + age26m4;
                age27t4 = age27f4 + age27m4;
                age28t4 = age28f4 + age28m4;
                age29t4 = age29f4 + age29m4;
                age30t4 = age30f4 + age30m4;
                age31t4 = age31f4 + age31m4;
                age32t4 = age32f4 + age32m4;
                age33t4 = age33f4 + age33m4;
                ageSup34t4 = ageSup34f4 + ageSup34m4;
                tt4 = ageInf18t4 + age18t4 + age19t4 + age20t4 + age21t4 + age22t4 + age23t4 + age24t4 + age25t4 + age26t4 + age27t4 + age28t4 + age29t4 + age30t4 + age31t4 + age32t4 + age33t4 + ageSup34t4;
                etranger4 = inscriptionService.findInscriptionByFiliereNiveauAnnee(filiere1, niveau5,anAc).size() - inscriptions4.size();
                // System.out.println(filiere1.getNom_filiere() + " " + niveau5.getNom_niveau() + " effectif>>>>>>>>> " + etranger4);
                niveauAgeGenres4.add(new FiliereNiveauAgeGenre(filiere1.getNom_filiere(), niveau5.getNom_niveau(), ageInf18f4, ageInf18m4, ageInf18t4, age18f4, age18m4, age18t4, age19f4, age19m4, age19t4, age20m4, age20f4, age20t4, age21m4, age21f4, age21t4, age22m4, age22f4, age22t4, age23m4, age23f4, age23t4, age24m4, age24f4, age24t4, age25m4, age25f4, age25t4, age26m4, age26f4, age26t4, age27m4, age27f4, age27t4, age28m4, age28f4, age28t4, age29m4, age29f4, age29t4, age30m4, age30f4, age30t4, age31m4, age31f4, age31t4, age32m4, age32f4, age32t4, age33m4, age33f4, age33t4, ageSup34m4, ageSup34f4, ageSup34t4, tt4, etranger4));

                //les totaux
                tageInf18f = tageInf18f + ageInf18f;
                tageInf18m = tageInf18m + ageInf18m;
                tageInf18t = tageInf18t + ageInf18t;
                tage18f = tage18f + age18f;
                tage18m = tage18m + age18m;
                tage18t = tage18t + age18t;
                tage19f = tage19f + age19f;
                tage19m = tage18t + age19m;
                tage19t = tage19t + age19t;
                tage20m = tage20m + age20m;
                tage20f = tage20f + age20f;
                tage20t = tage20t + age20t;
                tage21m = tage21m + age21m;
                tage21f = tage21f + age21f;
                tage21t = tage21t + age21t;
                tage22m = tage22m + age22m;
                tage22f = tage22f + age22f;
                tage22t = tage22t + age22t;
                tage23m = tage23m + age23m;
                tage23f = tage23f + age23f;
                tage23t = tage23t + age23t;
                tage24m = tage24m + age24m;
                tage24f = tage24f + age24f;
                tage24t = tage24t + age24t;
                tage25m = tage25m + age25m;
                tage25f = tage25f + age25f;
                tage25t = tage25t + age25t;
                tage26m = tage26m + age26m;
                tage26f = tage26f + age26f;
                tage26t = tage26t + age26t;
                tage27m = tage27m + age27m;
                tage27f = tage27f + age27f;
                tage27t = tage27t + age27t;
                tage28m = tage28m + age28m;
                tage28f = tage18t + age28f;
                tage28t = tage28t + age28t;
                tage29m = tage29m + age29m;
                tage29f = tage29f + age29f;
                tage29t = tage29t + age29t;
                tage30m = tage30m + age30m;
                tage30f = tage30f + age30f;
                tage30t = tage30t + age30t;
                tage31m = tage31m + age31m;
                tage31f = tage31f + age31f;
                tage31t = tage31t + age31t;
                tage32m = tage32m + age32m;
                tage32f = tage32f + age32f;
                tage32t = tage32t + age32t;
                tage33m = tage18t + age33m;
                tage33f = tage18t + age33f;
                tage33t = tage18t + age33t;
                tageSup34m = tageSup34m + ageSup34m;
                tageSup34f = tageSup34f + ageSup34f;
                tageSup34t = tageSup34t + ageSup34t;
                ttt = ttt + tt;
                tetranger = tetranger + etranger;

                tageInf18f1 = tageInf18f1 + ageInf18f1;
                tageInf18m1 = tageInf18m1 + ageInf18m1;
                tageInf18t1 = tageInf18t1 + ageInf18t1;
                tage18f1 = tage18f1 + age18f1;
                tage18m1 = tage18m1 + age18m1;
                tage18t1 = tage18t1 + age18t1;
                tage19f1 = tage19f1 + age19f1;
                tage19m1 = tage19m1 + age19m1;
                tage19t1 = tage19t1 + age19t1;
                tage20m1 = tage20m1 + age20m1;
                tage20f1 = tage20f1 + age20f1;
                tage20t1 = tage20t1 + age20t1;
                tage21m1 = tage21m1 + age21m1;
                tage21f1 = tage21f1 + age21f1;
                tage21t1 = tage21t1 + age21t1;
                tage22m1 = tage22m1 + age22m1;
                tage22f1 = tage22f1 + age22f1;
                tage22t1 = tage22t1 + age22t1;
                tage23m1 = tage23m1 + age23m1;
                tage23f1 = tage23f1 + age23f1;
                tage23t1 = tage23t1 + age23t1;
                tage24m1 = tage24m1 + age24m1;
                tage24f1 = tage24f1 + age24f1;
                tage24t1 = tage24t1 + age24t1;
                tage25m1 = tage25m1 + age25m1;
                tage25f1 = tage25f1 + age25f1;
                tage25t1 = tage25t1 + age25t1;
                tage26m1 = tage26m1 + age26m1;
                tage26f1 = tage26f1 + age26f1;
                tage26t1 = tage26t1 + age26t1;
                tage27m1 = tage27m1 + age27m1;
                tage27f1 = tage27f1 + age27f1;
                tage27t1 = tage27t1 + age27t1;
                tage28m1 = tage28m1 + age28m1;
                tage28f1 = tage18t1 + age28f1;
                tage28t1 = tage28t1 + age28t1;
                tage29m1 = tage29m1 + age29m1;
                tage29f1 = tage29f1 + age29f1;
                tage29t1 = tage29t1 + age29t1;
                tage30m1 = tage30m1 + age30m1;
                tage30f1 = tage30f1 + age30f1;
                tage30t1 = tage30t1 + age30t1;
                tage31m1 = tage31m1 + age31m1;
                tage31f1 = tage31f1 + age31f1;
                tage31t1 = tage31t1 + age31t1;
                tage32m1 = tage32m1 + age32m1;
                tage32f1 = tage32f1 + age32f1;
                tage32t1 = tage32t1 + age32t1;
                tage33m1 = tage18t1 + age33m1;
                tage33f1 = tage18t1 + age33f1;
                tage33t1 = tage18t1 + age33t1;
                tageSup34m1 = tageSup34m1 + ageSup34m1;
                tageSup34f1 = tageSup34f1 + ageSup34f1;
                tageSup34t1 = tageSup34t1 + ageSup34t1;
                ttt1 = ttt1 + tt1;
                tetranger1 = tetranger1 + etranger1;

                tageInf18f2 = tageInf18f2 + ageInf18f2;
                tageInf18m2 = tageInf18m2 + ageInf18m2;
                tageInf18t2 = tageInf18t2 + ageInf18t2;
                tage18f2 = tage18f2 + age18f2;
                tage18m2 = tage18m2 + age18m2;
                tage18t2 = tage18t2 + age18t2;
                tage19f2 = tage19f2 + age19f2;
                tage19m2 = tage18t2 + age19m2;
                tage19t2 = tage19t2 + age19t2;
                tage20m2 = tage20m2 + age20m2;
                tage20f2 = tage20f2 + age20f2;
                tage20t2 = tage20t2 + age20t2;
                tage21m2 = tage21m2 + age21m2;
                tage21f2 = tage21f2 + age21f2;
                tage21t2 = tage21t2 + age21t2;
                tage22m2 = tage22m2 + age22m2;
                tage22f2 = tage22f2 + age22f2;
                tage22t2 = tage22t2 + age22t2;
                tage23m2 = tage23m2 + age23m2;
                tage23f2 = tage23f2 + age23f2;
                tage23t2 = tage23t2 + age23t2;
                tage24m2 = tage24m2 + age24m2;
                tage24f2 = tage24f2 + age24f2;
                tage24t2 = tage24t2 + age24t2;
                tage25m2 = tage25m2 + age25m2;
                tage25f2 = tage25f2 + age25f2;
                tage25t2 = tage25t2 + age25t2;
                tage26m2 = tage26m2 + age26m2;
                tage26f2 = tage26f2 + age26f2;
                tage26t2 = tage26t2 + age26t2;
                tage27m2 = tage27m2 + age27m2;
                tage27f2 = tage27f2 + age27f2;
                tage27t2 = tage27t2 + age27t2;
                tage28m2 = tage28m2 + age28m2;
                tage28f2 = tage18t2 + age28f2;
                tage28t2 = tage28t2 + age28t2;
                tage29m2 = tage29m2 + age29m2;
                tage29f2 = tage29f2 + age29f2;
                tage29t2 = tage29t2 + age29t2;
                tage30m2 = tage30m2 + age30m2;
                tage30f2 = tage30f2 + age30f2;
                tage30t2 = tage30t2 + age30t2;
                tage31m2 = tage31m2 + age31m2;
                tage31f2 = tage31f2 + age31f2;
                tage31t2 = tage31t2 + age31t2;
                tage32m2 = tage32m2 + age32m2;
                tage32f2 = tage32f2 + age32f2;
                tage32t2 = tage32t2 + age32t2;
                tage33m2 = tage33m2 + age33m2;
                tage33f2 = tage33f2 + age33f2;
                tage33t2 = tage33t2 + age33t2;
                tageSup34m2 = tageSup34m2 + ageSup34m2;
                tageSup34f2 = tageSup34f2 + ageSup34f2;
                tageSup34t2 = tageSup34t2 + ageSup34t2;
                ttt2 = ttt2 + tt2;
                tetranger2 = tetranger2 + etranger2;

                tageInf18f3 = tageInf18f3 + ageInf18f3;
                tageInf18m3 = tageInf18m3 + ageInf18m3;
                tageInf18t3 = tageInf18t3 + ageInf18t3;
                tage18f3 = tage18f3 + age18f3;
                tage18m3 = tage18m3 + age18m3;
                tage18t3 = tage18t3 + age18t3;
                tage19f3 = tage19m3 + age19m3;
                tage19m3 = tage19f3 + age19f3;
                tage19t3 = tage19t3 + age19t3;
                tage20m3 = tage20m3 + age20m3;
                tage20f3 = tage20f3 + age20f3;
                tage20t3 = tage20t3 + age20t3;
                tage21m3 = tage21m3 + age21m3;
                tage21f3 = tage21f3 + age21f3;
                tage21t3 = tage21t3 + age21t3;
                tage22m3 = tage22m3 + age22m3;
                tage22f3 = tage22f3 + age22f3;
                tage22t3 = tage22t3 + age22t3;
                tage23m3 = tage23m3 + age23m3;
                tage23f3 = tage23f3 + age23f3;
                tage23t3 = tage23t3 + age23t3;
                tage24m3 = tage24m3 + age24m3;
                tage24f3 = tage24f3 + age24f3;
                tage24t3 = tage24t3 + age24t3;
                tage25m3 = tage25m3 + age25m3;
                tage25f3 = tage25f3 + age25f3;
                tage25t3 = tage25t3 + age25t3;
                tage26m3 = tage26m3 + age26m3;
                tage26f3 = tage26f3 + age26f3;
                tage26t3 = tage26t3 + age26t3;
                tage27m3 = tage27m3 + age27m3;
                tage27f3 = tage27f3 + age27f3;
                tage27t3 = tage27t3 + age27t3;
                tage28m3 = tage28m3 + age28m3;
                tage28f3 = tage18t3 + age28f3;
                tage28t3 = tage28t3 + age28t3;
                tage29m3 = tage29m3 + age29m3;
                tage29f3 = tage29f3 + age29f3;
                tage29t3 = tage29t3 + age29t3;
                tage30m3 = tage30m3 + age30m3;
                tage30f3 = tage30f3 + age30f3;
                tage30t3 = tage30t3 + age30t3;
                tage31m3 = tage31m3 + age31m3;
                tage31f3 = tage31f3 + age31f3;
                tage31t3 = tage31t3 + age31t3;
                tage32m3 = tage32m3 + age32m3;
                tage32f3 = tage32f3 + age32f3;
                tage32t3 = tage32t3 + age32t3;
                tage33m3 = tage18t3 + age33m3;
                tage33f3 = tage18t3 + age33f3;
                tage33t3 = tage18t3 + age33t3;
                tageSup34m3 = tageSup34m3 + ageSup34m3;
                tageSup34f3 = tageSup34f3 + ageSup34f3;
                tageSup34t3 = tageSup34t3 + ageSup34t3;
                ttt3 = ttt3 + tt3;
                tetranger3 = tetranger3 + etranger3;

                tageInf18f4 = tageInf18f4 + ageInf18f4;
                tageInf18m4 = tageInf18m4 + ageInf18m4;
                tageInf18t4 = tageInf18t4 + ageInf18t4;
                tage18f4 = tage18f4 + age18f4;
                tage18m4 = tage18m4 + age18m4;
                tage18t4 = tage18t4 + age18t4;
                tage19f4 = tage19f4 + age19f4;
                tage19m4 = tage18t4 + age19m4;
                tage19t4 = tage19t4 + age19t4;
                tage20m4 = tage20m4 + age20m4;
                tage20f4 = tage20f4 + age20f4;
                tage20t4 = tage20t4 + age20t4;
                tage21m4 = tage21m4 + age21m4;
                tage21f4 = tage21f4 + age21f4;
                tage21t4 = tage21t4 + age21t4;
                tage22m4 = tage22m4 + age22m4;
                tage22f4 = tage22f4 + age22f4;
                tage22t4 = tage22t4 + age22t4;
                tage23m4 = tage23m4 + age23m4;
                tage23f4 = tage23f4 + age23f4;
                tage23t4 = tage23t4 + age23t4;
                tage24m4 = tage24m4 + age24m4;
                tage24f4 = tage24f4 + age24f4;
                tage24t4 = tage24t4 + age24t4;
                tage25m4 = tage25m4 + age25m4;
                tage25f4 = tage25f4 + age25f4;
                tage25t4 = tage25t4 + age25t4;
                tage26m4 = tage26m4 + age26m4;
                tage26f4 = tage26f4 + age26f4;
                tage26t4 = tage26t4 + age26t4;
                tage27m4 = tage27m4 + age27m4;
                tage27f4 = tage27f4 + age27f4;
                tage27t4 = tage27t4 + age27t4;
                tage28m4 = tage28m4 + age28m4;
                tage28f4 = tage18t4 + age28f4;
                tage28t4 = tage28t4 + age28t4;
                tage29m4 = tage29m4 + age29m4;
                tage29f4 = tage29f4 + age29f4;
                tage29t4 = tage29t4 + age29t4;
                tage30m4 = tage30m4 + age30m4;
                tage30f4 = tage30f4 + age30f4;
                tage30t4 = tage30t4 + age30t4;
                tage31m4 = tage31m4 + age31m4;
                tage31f4 = tage31f4 + age31f4;
                tage31t4 = tage31t4 + age31t4;
                tage32m4 = tage32m4 + age32m4;
                tage32f4 = tage32f4 + age32f4;
                tage32t4 = tage32t4 + age32t4;
                tage33m4 = tage18t4 + age33m4;
                tage33f4 = tage18t4 + age33f4;
                tage33t4 = tage18t4 + age33t4;
                tageSup34m4 = tageSup34m4 + ageSup34m4;
                tageSup34f4 = tageSup34f4 + ageSup34f4;
                tageSup34t4 = tageSup34t4 + ageSup34t4;
                ttt4 = ttt4 + tt4;
                tetranger4 = tetranger4 + etranger4;
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(StatTrancheAgeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);

        HSSFCellStyle cellStyle = wb.createCellStyle();
        // cellStyle.setFillForegroundColor(HSSFColor.AQUA.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);


        for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
            HSSFCell cell = header.getCell(i);
            //cell.setCellValue(i);
            //cell.getNumericCellValue();
            cell.setCellStyle(cellStyle);
        }
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A0);
    }
}
