/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.tests;

import cm.uma.iss.scolarite.dao.IAnneeAccademiqueDao;
import cm.uma.iss.scolarite.dao.IArrondissementOrigineDao;
import cm.uma.iss.scolarite.dao.ICycleDao;
import cm.uma.iss.scolarite.dao.IDepartementOrigineDao;
import cm.uma.iss.scolarite.dao.IDocumentDao;
import cm.uma.iss.scolarite.dao.IDroit_universitaireDao;
import cm.uma.iss.scolarite.dao.IEtudiantDao;
import cm.uma.iss.scolarite.dao.IFiliereDao;
import cm.uma.iss.scolarite.dao.IInscriptionDao;
import cm.uma.iss.scolarite.dao.INiveauDao;
import cm.uma.iss.scolarite.dao.INiveauFiliereDao;
import cm.uma.iss.scolarite.dao.IOption1Dao;
import cm.uma.iss.scolarite.dao.IPaiementDao;
import cm.uma.iss.scolarite.dao.IPaysOrigineDao;
import cm.uma.iss.scolarite.dao.IPersonneDao;
import cm.uma.iss.scolarite.dao.IPromotionDao;
import cm.uma.iss.scolarite.dao.IRegionOrigineDao;
import cm.uma.iss.scolarite.dao.IRetraitRetourDocDao;
import cm.uma.iss.scolarite.dao.IRoleUtilisateurDao;
import cm.uma.iss.scolarite.dao.IUtilisateurDao;
import cm.uma.iss.scolarite.dao.impl.AnneeAccademiqueDaoImpl;
import cm.uma.iss.scolarite.dao.impl.ArrondissementOrigineDaoImpl;
import cm.uma.iss.scolarite.dao.impl.CycleDaoImpl;
import cm.uma.iss.scolarite.dao.impl.DepartementOrigineDaoImpl;
import cm.uma.iss.scolarite.dao.impl.DocumentDaoImpl;
import cm.uma.iss.scolarite.dao.impl.Droit_universitaireDaoImpl;
import cm.uma.iss.scolarite.dao.impl.EtudiantDaoImpl;
import cm.uma.iss.scolarite.dao.impl.FiliereDaoImpl;
import cm.uma.iss.scolarite.dao.impl.InscriptionDaoImpl;
import cm.uma.iss.scolarite.dao.impl.NIveauFiliereDaoImpl;
import cm.uma.iss.scolarite.dao.impl.NiveauDaoImpl;
import cm.uma.iss.scolarite.dao.impl.Option1DaoImpl;
import cm.uma.iss.scolarite.dao.impl.PaiementDaoImpl;
import cm.uma.iss.scolarite.dao.impl.PaysOrigineDaoImpl;
import cm.uma.iss.scolarite.dao.impl.PersonneDaoImpl;
import cm.uma.iss.scolarite.dao.impl.PromotionDaoImpl;
import cm.uma.iss.scolarite.dao.impl.RegionOrigineDaoImpl;
import cm.uma.iss.scolarite.dao.impl.RetraitRetourDocDaoImpl;
import cm.uma.iss.scolarite.dao.impl.RoleUtilisateurDaoImpl;
import cm.uma.iss.scolarite.dao.impl.UtilisateurDaoImpl;
import cm.uma.iss.scolarite.entities.AnneeAccademique;
import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.Documents;
import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.Filiere;
import cm.uma.iss.scolarite.entities.Inscription;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import cm.uma.iss.scolarite.entities.RetraitRetourDoc;
import cm.uma.iss.scolarite.entities.RoleUtilisateur;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author ngnawen
 */
public class Dao {

    //declaration ducontexte de persistence
    private static EntityManagerFactory emf;
    private static EntityManager em;
    //Declaration des interface Dao
    private static IPaysOrigineDao paysOrigineDao;
    private static IPaiementDao paiementDao;
    private static IEtudiantDao etudiantDao;
    private static ICycleDao cycleDao;
    private static INiveauFiliereDao niveauFiliereDao;
    private static IFiliereDao filiereDao;
    private static IInscriptionDao inscriptionDao;
    private static INiveauDao niveauDao;
    private static IPromotionDao promotionDao;
    private static IDroit_universitaireDao droit_universitaireDao;
    private static IOption1Dao option1Dao;
    private static IUtilisateurDao utilisateurDao;
    private static IPersonneDao personneDao;
    private static IAnneeAccademiqueDao annee_accademiqueDao;
    private static IArrondissementOrigineDao arrondissementOrigineDao;
    private static IDepartementOrigineDao departementOrigineDao;
    private static IRegionOrigineDao regionOrigineDao;
    private static IRoleUtilisateurDao roleUtilisateurDao;
    private static IDocumentDao documentDao;
    private static IRetraitRetourDocDao retraitRetourDocDao;

    public static void main(String[] args) throws DataAccessException {

        // Contexte de persistance
        emf = Persistence.createEntityManagerFactory("scolaritePU");

        // on récupère un EntityManager à partir de l'EntityManagerFactory précédent
        em = emf.createEntityManager();

        //creation des instences des implementations Dao ie DaoImpl
        paysOrigineDao = new PaysOrigineDaoImpl();
        paiementDao = new PaiementDaoImpl();
        etudiantDao = new EtudiantDaoImpl();
        cycleDao = new CycleDaoImpl();
        niveauFiliereDao = new NIveauFiliereDaoImpl();
        filiereDao = new FiliereDaoImpl();
        inscriptionDao = new InscriptionDaoImpl();
        niveauDao = new NiveauDaoImpl();
        promotionDao = new PromotionDaoImpl();
        droit_universitaireDao = new Droit_universitaireDaoImpl();
        option1Dao = new Option1DaoImpl();
        utilisateurDao = new UtilisateurDaoImpl();
        personneDao = new PersonneDaoImpl();
        annee_accademiqueDao = new AnneeAccademiqueDaoImpl();
        arrondissementOrigineDao = new ArrondissementOrigineDaoImpl();
        departementOrigineDao = new DepartementOrigineDaoImpl();
        regionOrigineDao = new RegionOrigineDaoImpl();
        roleUtilisateurDao = new RoleUtilisateurDaoImpl();
        documentDao = new DocumentDaoImpl();
        retraitRetourDocDao = new RetraitRetourDocDaoImpl();

        ((GenericDao) paysOrigineDao).setManager(em);
        ((GenericDao) etudiantDao).setManager(em);
        ((GenericDao) paiementDao).setManager(em);
        ((GenericDao) cycleDao).setManager(em);
        ((GenericDao) niveauFiliereDao).setManager(em);
        ((GenericDao) filiereDao).setManager(em);
        ((GenericDao) inscriptionDao).setManager(em);
        ((GenericDao) niveauDao).setManager(em);
        ((GenericDao) promotionDao).setManager(em);
        ((GenericDao) droit_universitaireDao).setManager(em);
        ((GenericDao) option1Dao).setManager(em);
        ((GenericDao) utilisateurDao).setManager(em);
        ((GenericDao) personneDao).setManager(em);
        ((GenericDao) annee_accademiqueDao).setManager(em);
        ((GenericDao) arrondissementOrigineDao).setManager(em);
        ((GenericDao) departementOrigineDao).setManager(em);
        ((GenericDao) regionOrigineDao).setManager(em);
        ((GenericDao) roleUtilisateurDao).setManager(em);
        ((GenericDao) documentDao).setManager(em);
        ((GenericDao) retraitRetourDocDao).setManager(em);




        // début transaction
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //creation des pays
//        PaysOrigine pays = new PaysOrigine();
//        pays.setNom_pays("Maroc");
//        paysOrigineDao.create(pays);

//        AnneeAccademique ac = new AnneeAccademique();
//        ac.setAnnee("2013-2014");
//        annee_accademiqueDao.create(ac);
//        AnneeAccademique ac =annee_accademiqueDao.findAnneeAccademiqueByAnnee("2013/2014");
//        System.out.println(ac);
        //creation des utilisateurs
//        Utilisateur utilisateur = new Utilisateur();
//        utilisateur.setEmail("pitou@yahoo.fr");
//        utilisateur.setGenre("masculin");
//        utilisateur.setLogin("pitou");
//        utilisateur.setNom("pitou");
//        utilisateur.setPassword("pitou");
//        utilisateur.setPrenom("pitou");
//        utilisateur.setRole_utilisateur("agentScolarite1");
//        utilisateur.setTelephone("88888888");
//        utilisateurDao.create(utilisateur);
//       
//        Etudiant etudiant=etudiantDao.findById(1L);
//        List<Inscription> inscription=inscriptionDao.findInscriptionByDEtudiant(etudiant);
//        for (Inscription inscription1 : inscription) {
//            System.out.println(inscription1.getEtudiant());
//            
//        }
//        Cycle c=cycleDao.findById(1L);
//        List<Filiere> f=filiereDao.findAll();
//         List<Inscription> inscriptions=inscriptionDao.findInscriptionByListe(f, c);
//        for (Inscription inscription1 : inscriptions) {
//            System.out.println(inscription1.getFiliere());
////            
//        }
//        List<Document> docs=documentDao.findAll();
//        for (Documents document : docs) {
//            System.out.println(""+document);
//        }
//        List<Document> doc1s=documentDao.findDocumentByTypeliste(3L);
//        for (Documents document1 : doc1s) {
//            System.out.println(""+document1);
//        }

//        Filiere f=filiereDao.findFiliereByNom("INFOTEL");
//        RegionOrigine r=regionOrigineDao.findRegionOrigineByNom("OU");
//        Cycle c=cycleDao.findCycleByNom("LICENCE");
//        int i=inscriptionDao.findNbreInscriptionByFiliereRegionCycle(f, r, c);
//        System.out.println(""+i);

//        Documents doc=documentDao.findDocumentByType("COUPON PREMIERE TRANCHE");
//        System.out.println(""+doc.getType());
//        List<Etudiant> etudiant=etudiantDao.findEtudiantbyDocument(doc);
//        for (Etudiant etudiant1 : etudiant) {
//            System.out.println(""+etudiant1);
//        }
//        
//        RoleUtilisateur ru = new RoleUtilisateur();
//        ru = utilisateurDao.findUtilisateurByRole("scolarite");
//        System.out.println("" + ru.getRoleuser());
//        
//        Filiere filiere = filiereDao.findFiliereByNom("ENERGIES RENOUVELABLES");
//        //ù Cycle cycle=cycleDao.findCycleByNom("LICENCE");
//        List<Inscription> inscriptions = inscriptionDao.findInscriptionByFiliere(filiere);
//        for (Inscription inscription1 : inscriptions) {
//            System.out.println(inscription1.getEtudiant());
//            
//        }
//        Documents d=new Documents();
//        d.setType("cp");
//        documentDao.create(d);
//        PaysOrigine p=new PaysOrigine();
//        p.setNom_pays("mali");
//        paysOrigineDao.create(p);

//        Etudiant e=new Etudiant();
//        e.setDate_naiss("11/11/2000");
//        e.setMatricule("12X450S");
//        e.setLieu_naiss("Maroua");
//        e.setNom("toto");
//        e.setPrenom("tata");
//        e.setPaysOrigine(paysOrigineDao.getPaysByNom("mali"));
////        etudiantDao.create(e);
//        Etudiant e=etudiantDao.findEtudiantByMatricule("12X456S");
//        //Etudiant e1=etudiantDao.findEtudiantByMatricule("12X450S");
//        
//        RetraitRetourDoc r=new RetraitRetourDoc();
//        r.getEtudiantId();
//        r.setDateRetour(new Date());
//        r.setEtat(true);
//        //r.setDocuementId(Integer.parseInt(1L+""));
//       // r.setEtudiantId(Integer.parseInt(e.getId_etudiant()+""));
//        retraitRetourDocDao.update(r);
//        List<Etudiant> etudiants=retraitRetourDocDao.findRetraitRetourDocBy(false);
//        for (Etudiant etudiant : etudiants) {
//            
//            System.out.println(""+etudiant);
//            
//        }
//        List<RetraitRetourDoc> rd=retraitRetourDocDao.findAll();
//        for (RetraitRetourDoc retraitRetourDoc : rd) {
//            System.out.println(""+retraitRetourDoc);
//            
//        }
//        RetraitRetourDoc rd=retraitRetourDocDao.findRetraitRetourDoc(1L, 23L,true);
//        System.out.println(""+rd);

//        List<Etudiant> listeEtudiant=etudiantDao.findEtudiantByInscription(inscription);
//        for (Etudiant etudiant : listeEtudiant) {
//            System.out.println(etudiant);
//            findInscriptionByEtatPreinscription
//        }
//        //role utilisateur
//        RoleUtilisateur ru=new RoleUtilisateur();
//        ru.setRoleuser("admin");
//        ru.setUtilisateur(utilisateur);
//        roleUtilisateurDao.create(ru);
//        Utilisateur utilisateur1 = new Utilisateur();
//        utilisateur1.setEmail("junior@yahoo.fr");
//        utilisateur1.setGenre("masculin");
//        utilisateur1.setLogin("junior");
//        utilisateur1.setNom("jounior");
//        utilisateur1.setPassword("junior");
//        utilisateur1.setPrenom("junior");
//        utilisateur1.setRole_utilisateur("agentScolorite2");
//        utilisateur1.setTelephone("99999999");
//        utilisateurDao.create(utilisateur1);
//        Cycle c=cycleDao.findCycleByNom("MASTER");
//        Filiere f=filiereDao.findFiliereByNom("INFOTEL");
//        Niveau n=niveauDao.findNiveauByNom("MASTER II");
//        Option1 o=option1Dao.findById(2l);
//        PaysOrigine po=paysOrigineDao.findById(2L);
//        List<Inscription> inscriptions=inscriptionDao.findInscriptionByPays(po);
//        for (Inscription inscription : inscriptions) {
//            System.out.println(""+inscription);
//        }
//        AnneeAccademique anneeAccademique = annee_accademiqueDao.findAnneeByAnnee("2014/2015");
//        System.out.println("" + anneeAccademique);
//        Cycle cycle = cycleDao.findCycleByNom("MASTER");
//        System.out.println("" + cycle);
//        RegionOrigine ouest = regionOrigineDao.findRegionOrigineByNom("OU");
//        System.out.println("" + ouest);
//        List<Filiere> filieres = filiereDao.findAll();
//        for (Filiere filiere1 : filieres) {
//            int ou = inscriptionDao.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, ouest, cycle, anneeAccademique);
//            System.out.println("" + ou);
//
//        }
        Documents d = documentDao.findById(1L);
        Etudiant e = etudiantDao.findById(12L);
        System.out.println("" + d);
        System.out.println("" + e);
        RetraitRetourDoc r = new RetraitRetourDoc();
        r.setDateRetrait("" + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()));
        r.setEtatPreinscription(true);
        r.setDocuements(d);
        r.setEtudiant(e);
        System.out.println("Document: "+r.getDocuments()+" Etudiant: "+r.getEtudiant());
        RetraitRetourDoc rd = retraitRetourDocDao.findRetraitDoc(r.getDocuments(), r.getEtudiant());
        if (r.getEtudiant() == rd.getEtudiant()) {
            System.out.println("Enregistrement exitant");
        } else {
            retraitRetourDocDao.create(r);
            System.out.println("" + r);
            System.out.println("Enregistrement avec succès");
        }
//       // System.out.println(""+r);
//            RetraitRetourDoc retraitDocument=retraitRetourDocDao.findRetraitDoc(d, e);
//            System.out.println("retraitDocuement===>  "+retraitDocument);
//        System.out.println(""+retraitDocument.getEtudiant().getMatricule()+" : "
//                + ""+retraitDocument.getEtudiant().getNom()+"====>"
//                + ""+retraitDocument.getDocuments().getType());
//        if (retraitDocument==null) {
//            retraitDocument.setDateRetrait("" + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()));
//            retraitDocument.setEtatPreinscription(false);
//            retraitRetourDocDao.create(retraitDocument);
//            System.out.println("Enregistrement avec succès");
//        } else {
//            System.out.println("echec d'enregistrement");    
//        }
//
//        

//        int etat = 0;
//        for (RetraitRetourDoc retraitRetourDoc : rrd) {
//            //System.out.println("Document==> " + retraitRetourDoc.getDocuments().getId_document() + "  Etudiant==> " + retraitRetourDoc.getEtudiant().getId_etudiant());
//            if (e.getId_etudiant() == retraitRetourDoc.getEtudiant().getId_etudiant() && d.getId_document() == retraitRetourDoc.getDocuments().getId_document()) {
//                etat = 1;
//            }
//        }
//        if (etat == 1) {
//            //System.out.println("retrait dèjà éffectué");
//        } else {
//           // System.out.println("retrait non éffectué");
//        }
//        Documents d=documentDao.findById(1L);
//        System.out.println(""+d);
//        List<RetraitRetourDoc> retraitRetourDocs=retraitRetourDocDao.findRetraitByDocument(d);
//        for (RetraitRetourDoc retraitRetourDoc : retraitRetourDocs) {
//            System.out.println(retraitRetourDoc.getEtudiant().getMatricule()+" "+retraitRetourDoc.getEtudiant().getNom()+" "+retraitRetourDoc.getDateRetrait());
//        }
//        System.out.println("----------------------------------------------------------------------------");
//        List<RetraitRetourDoc> retraitRetourDocs1=retraitRetourDocDao.findRetourByDocument(d);
//        for (RetraitRetourDoc retraitRetourDoc : retraitRetourDocs1) {
//            System.out.println(retraitRetourDoc.getEtudiant().getMatricule()+" "+retraitRetourDoc.getEtudiant().getNom()+" "+retraitRetourDoc.getDateRetour());
//        }
//        
//        System.out.println("----------------------------------------------------------------------------");
//        List<RetraitRetourDoc> retraitRetourDocs2=retraitRetourDocDao.findRetraitRetourByDocument(d);
//        for (RetraitRetourDoc retraitRetourDoc : retraitRetourDocs2) {
//            System.out.println(retraitRetourDoc.getEtudiant().getMatricule()+" "+retraitRetourDoc.getEtudiant().getNom()+" "+retraitRetourDoc.getDateRetrait()+" "+retraitRetourDoc.getDateRetour());
//        }

// fin transaction
        tx.commit();
// fin EntityManager
        em.close();
// fin EntityMangerFactory
        emf.close();


    }
}
