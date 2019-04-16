/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.tests;

import cm.uma.iss.scolarite.dao.IFiliereDao;
import cm.uma.iss.scolarite.dao.IOption1Dao;
import cm.uma.iss.scolarite.entities.AnneeAccademique;
import cm.uma.iss.scolarite.entities.ArrondissementOrigine;
import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.DepartementOrigine;
import cm.uma.iss.scolarite.entities.Documents;
import cm.uma.iss.scolarite.entities.Droit_universitaire;
import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.Filiere;
import cm.uma.iss.scolarite.entities.Inscription;
import cm.uma.iss.scolarite.entities.Niveau;
import cm.uma.iss.scolarite.entities.Option1;
import cm.uma.iss.scolarite.entities.Paiement;
import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import cm.uma.iss.scolarite.entities.RetraitRetourDoc;
import cm.uma.iss.scolarite.entities.RoleUtilisateur;
import cm.uma.iss.scolarite.entities.Utilisateur;
import cm.uma.iss.scolarite.services.IAnneeAccademiqueService;
import cm.uma.iss.scolarite.services.IArrondissementOrigineService;
import cm.uma.iss.scolarite.services.ICycleService;
import cm.uma.iss.scolarite.services.IDepartementOrigineService;
import cm.uma.iss.scolarite.services.IDocumentService;
import cm.uma.iss.scolarite.services.IDroit_universitaireService;
import cm.uma.iss.scolarite.services.IEtudiantService;
import cm.uma.iss.scolarite.services.IFiliereService;

import cm.uma.iss.scolarite.services.IInscriptionService;
import cm.uma.iss.scolarite.services.INiveauFiliereService;
import cm.uma.iss.scolarite.services.INiveauService;
import cm.uma.iss.scolarite.services.IOption1Service;
import cm.uma.iss.scolarite.services.IPaiementService;
import cm.uma.iss.scolarite.services.IPaysOrigineService;
import cm.uma.iss.scolarite.services.IPersonneService;
import cm.uma.iss.scolarite.services.IPromotionService;
import cm.uma.iss.scolarite.services.IRegionOrigineService;
import cm.uma.iss.scolarite.services.IRetraitRetourDocService;
import cm.uma.iss.scolarite.services.IRoleUtilisateurService;
import cm.uma.iss.scolarite.services.IUtilisateurService;
import com.douwe.generic.dao.DataAccessException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.swing.text.MaskFormatter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ngnawen
 */
public class Service {

    public static void main(String[] args) throws DataAccessException, ParseException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("springConfig.xml");

        IPaysOrigineService paysOrigineService = (IPaysOrigineService) ctx.getBean("IPaysOrigineService");
        IEtudiantService etudiantService = (IEtudiantService) ctx.getBean("IEtudiantService");
        IPaiementService paiementService = (IPaiementService) (IPaiementService) ctx.getBean("IPaiementService");
        IDroit_universitaireService droit_universitaireService = (IDroit_universitaireService) ctx.getBean("IDroit_universitaireService");
        ICycleService cycleService = (ICycleService) ctx.getBean("ICycleService");
        IFiliereService filiereService = (IFiliereService) ctx.getBean("IFiliereService");
        IInscriptionService inscriptionService = (IInscriptionService) ctx.getBean("IInscriptionService");
        INiveauFiliereService niveauFiliereService = (INiveauFiliereService) ctx.getBean("INiveauFiliereService");
        INiveauService niveauService = (INiveauService) ctx.getBean("INiveauService");
        IOption1Service option1Service = (IOption1Service) ctx.getBean("IOption1Service");
        IPromotionService promotionService = (IPromotionService) ctx.getBean("IPromotionService");
        IUtilisateurService utilisateurService = (IUtilisateurService) ctx.getBean("IUtilisateurService");
        IPersonneService personneService = (IPersonneService) ctx.getBean("IPersonneService");
        IAnneeAccademiqueService anneeAccademiqueService = (IAnneeAccademiqueService) ctx.getBean("IAnneeAccademiqueService");
        IRegionOrigineService regionOrigineService = (IRegionOrigineService) ctx.getBean("IRegionOrigineService");
        IDepartementOrigineService departementOrigineService = (IDepartementOrigineService) ctx.getBean("IDepartementOrigineService");
        IArrondissementOrigineService arrondissementOrigineService = (IArrondissementOrigineService) ctx.getBean("IArrondissementOrigineService");
        IRoleUtilisateurService roleUtilisateurService = (IRoleUtilisateurService) ctx.getBean("IRoleUtilisateurService");
        IDocumentService documentService = (IDocumentService) ctx.getBean("IDocumentService");
        IRetraitRetourDocService retraitRetourDocService = (IRetraitRetourDocService) ctx.getBean("IRetraitRetourDocService");


////        //creation des pays
//        PaysOrigine pays1 = new PaysOrigine("Cameroun");
//        PaysOrigine pays2 = new PaysOrigine("Tchad");
//        PaysOrigine pays3 = new PaysOrigine("irak");
//        paysOrigineService.registerPays(pays1);
//        paysOrigineService.registerPays(pays2);
//        paysOrigineService.registerPays(pays3);

        //role utilisateur
//        Utilisateur u = new Utilisateur();
//        u.setNom("Utilisateur");
//        u.setUsername("user");
//        u.setPassword("user");
//        u.setEnabled(true);
//        utilisateurService.registerUtilisateur(u);
//
//        RoleUtilisateur r = new RoleUtilisateur();
//        r.setRoleuser("ROLE_USER");
//        r.setUtilisateur(u);
//        roleUtilisateurService.registerRoleUtilisateur(r);
//        Documents doc=new Documents();
//        doc.setType("ct2");
//        documentService.registerDocument(doc);
//        
//        RetraitRetourDoc rrd= new RetraitRetourDoc();
//        rrd.setDateRetrait(new Date());
//        rrd.setDocuementId(Integer.parseInt(doc.getId_document()+""));
//        retraitRetourDocService.registerRetraitRetourDoc(rrd);

//        AnneeAccademique ac=new AnneeAccademique();
//        ac.setDebutAnnee("12/12/2014");
//        ac.setFinAnnee("12/12/2015");
//        anneeAccademiqueService.registerAnnee_accademique(ac);
//        AnneeAccademique ac1=anneeAccademiqueService.findAnneeByAnnee("2015/2017");
//        System.out.println(""+ac1);
//        Filiere f = filiereService.findFiliereByNom("ENERGIES RENOUVELABLES");
//        Niveau n=niveauService.findNiveauByNom("LICENCE I");
//        Cycle c=cycleService.findCycleByNom("LICENCE");
//        List<Inscription> ins = inscriptionService.findInscriptionByFiliereCycleNiveau(f, c, n);
//        for (Inscription inscription : ins) {
//            System.out.println(inscription);
//        }

//        RetraitRetourDoc rd=retraitRetourDocService.findRetraitRetourDoc(1L, 23L,false);
//        System.out.println(""+rd);
//        List<RetraitRetourDoc>  rd=retraitRetourDocService.findRetraitRetourDocAll();
//        for (RetraitRetourDoc retraitRetourDoc : rd) {
//            System.out.println(""+retraitRetourDoc);
//            
//        }

//        List<Filiere> f=filiereService.findAllFiliere();
//        for (Filiere filiere : f) {
//            System.out.println(""+filiere);
//            
//        }
//        
//        List<Document> doc1s=documentService.findDocumentByTypeliste(3L);
//        for (Documents document1 : doc1s) {
//            System.out.println(""+document1);
//        }


////        
//        Filiere filiere = filiereService.findFiliereByNom("ENERGIES RENOUVELABLES");
//        System.out.println(filiere);  
//        Cycle cycle = cycleService.findCycleByNom("MASTER");
//        System.out.println(cycle);  
//        List<Inscription> inscriptions = inscriptionService.findInscriptionByFiliereCycle(filiere, cycle);
//        for (Inscription inscription:inscriptions) {
//            System.out.println(inscription.getEtudiant());          
//        }
//        System.out.println("Nombre "+etatInscription.size());

//        Cycle c=cycleService.findCycleByNom("Master");
//        System.out.println("cycle "+c);
//        Niveau n=niveauService.findNiveauByNom("Master II");
//        System.out.println("niveau "+n);
//        Option1 o=option1Service.findOption1ById(2L);
////        Filiere f=filiereService.findFiliereByNom("Infotel");
//      System.out.println(""+o);
//        List<Inscription> inscriptions=inscriptionService.findInscriptionByOption(o);
//        for (Inscription inscription : inscriptions) {
//            System.out.println(""+inscription);
//            
//        }

//         List<Etudiant> lesm=etudiantService.findListeEtudiantByMatricule();
//        for (Etudiant etudiant : lesm) {
//            System.out.println(""+etudiant);
        //        System.out.println(""+etudiantService.findEtudintById(1L));

        //Utilisateur u=new Utilisateur();
//        RoleUtilisateur ru=utilisateurService.findUtilisateurByRole("dess");
//        System.out.println(""+ru);

//        AnneeAccademique ac=new AnneeAccademique();
//        ac.setAnnee("2013/2014");
//        anneeAccademiqueService.registerAnnee_accademique(ac);
//        
//        AnneeAccademique ac=anneeAccademiqueService.findAnneeAccademiqueByAnnee("2013/2014");
//        System.out.println(ac);
//        Inscription ins=new Inscription();
//        ins.setAnnee_accademique(ac);
//        inscriptionService.registerInscription(ins);
//        PaysOrigine paysOri=new PaysOrigine();
//        paysOri.setNom_pays("Mali");
//        paysOrigineService.registerPays(paysOri);
//        List<PaysOrigine> lesPaysOrigine=paysOrigineService.findPaysAll();
//        for (PaysOrigine paysOrigine : lesPaysOrigine) {
//            System.out.println(">>>>>>>>>>>>>"+paysOrigine+"<<<<<<<<<<<<<<<<<<");
//            
//        }
//        Filiere f=filiereService.findFiliereByNom("INFOTEL");
//        RegionOrigine r=regionOrigineService.findRegionOrigineByNom("OU");
//        Cycle c=cycleService.findCycleByNom("LICENCE");
//        int i=inscriptionService.findNbreInscriptionByFiliereCycle(f, c);
//        System.out.println(""+i);
//        
//     
//        Documents doc=documentService.findDocumentByType("COUPON PREMIERE TRANCHE");
//        System.out.println(""+doc.getType());
//        List<Etudiant> etudiant=etudiantService.findEtudiantbyDocument(doc);
//        for (Etudiant etudiant1 : etudiant) {
//            System.out.println(""+etudiant1);
//        }
//        Etudiant e=etudiantService.findEtudiantByMatricule("15X233S");
//        Inscription ins=inscriptionService.findInscriptionByEtudiant(e);
//        System.out.println(""+ins.getAnneeAccademique().getAnnee());
//        String an=ins.getAnneeAccademique().getAnnee();
//        System.out.println(""+an.length());
//        String anMat=an.substring(2, 4);
//        System.out.println(""+anMat);
//        int i=1+(int)(3*Math.random());
//        System.out.println(""+i);

//        RoleUtilisateur ru = new RoleUtilisateur();
//        ru=utilisateurService.findUtilisateurByRole("scolarite");
//        System.out.println(""+ru.getRoleuser());
//           AnneeAccademique anneeAccademique=anneeAccademiqueService.findAnneeByAnnee("2014/2015");
//           System.out.println(""+anneeAccademique);
//           Cycle cycle=cycleService.findCycleByNom("MASTER");
//           System.out.println(""+cycle);
//           RegionOrigine ouest = regionOrigineService.findRegionOrigineByNom("OU");
//           System.out.println(""+ouest);
//           List<Filiere> filieres=filiereService.findFiliereAll();
//            for (Filiere filiere1 : filieres) {
//                int ou=inscriptionService.findNbreInscriptionByFiliereRegionCycleAnnee(filiere1, ouest, cycle,anneeAccademique);
//                System.out.println(""+ou);
//            
        //}
//           Filiere f=filiereService.findFiliereByNom("SCIENV");
//           List<Inscription> inscriptions=inscriptionService.findInscriptionByFiliereCycleAnnee(f,cycle, anneeAccademique);
//           for (Inscription inscription : inscriptions) {
//               System.out.println(""+inscription);
//        }
//           System.out.println(""+inscriptions.size());



//        PaysOrigine p=paysOrigineService.getPaysByNom("CAMEROUN");
//        Filiere f=filiereService.findFiliereByNom("SCIENV");
//        Niveau n=niveauService.findNiveauByNom("LICENCE II");
//        int nbre=inscriptionService.findNbreFInscriptionByFiliereNiveauAncienCamer(f, n, p);
//        int nobre1=inscriptionService.findNbreMInscriptionByFiliereNiveauAncienCamer(f, n, p);
//        System.out.println("fille "+nbre+ " Garçon "+nobre1);
//         Etudiant etudiant_bd = etudiantService.findEtudiantByMatricule("09K001S");
//           System.out.println(etudiant_bd + "est l'tudiant correspondant au matricule  ");
        //enregistrement des etudiants
//        Etudiant e=new Etudiant();
//        e.setAdresse_tuteur("79929282");
//        e.setCategorie("regulier");
//        e.setDate_naiss(new Date());
//        e.setEmail("sngnawen@yhaoo.fr");
//        e.setGenre("Masculin");
//        e.setLieu_naiss("maroua");
//        e.setMatricule("12X456S");
//        e.setNom("Ngnawen");
//        e.setPrenom("Samuel vermon");
//        e.setStatut_matri("Celibataire");
//        e.setTelephone("94417164");
//        e.setTuteur("Na maurice");
//        etudiantService.registerEtudiant(e);

//        Inscription ins=new Inscription( null, null, null, null, null, null, null, null, null, null, null, null, null);
//        inscriptionService.registerInscription(ins);
//        Cycle c=cycleService.findCycleById(5L);
//        c.setNom_cycle("Master");
//        cycleService.updateCycle(c);

        //creation des utilisateurs
//        Utilisateur utilisateur1 = new Utilisateur();
//        utilisateur1.setEmail("nanou@yahoo.fr");
//        utilisateur1.setGenre("masculin");
//        utilisateur1.setLogin("nanou");
//        utilisateur1.setNom("nanou");
//        utilisateur1.setPassword("nanou");
//        utilisateur1.setPrenom("nanou");
//        utilisateur1.setRole_utilisateur("agentScolorite3");
//        utilisateur1.setTelephone("99999999");
//        utilisateurService.registerUtilisateur(utilisateur1);
//
//        Utilisateur utilisateur = new Utilisateur();
//        utilisateur.setEmail("ngnawen@yahoo.fr");
//        utilisateur.setGenre("masculin");
//        utilisateur.setLogin("admin");
//        utilisateur.setNom("ngnawen");
//        utilisateur.setPassword("admin");
//        utilisateur.setPrenom("samuel vermon");
//        utilisateur.setRole_utilisateur("admin");
//        utilisateur.setTelephone("79929282");
//        utilisateurService.registerUtilisateur(utilisateur);

        //Cycle c1=cycleService.findCycleById(1L);
        // cycleService.deleteCycle(3L);
//        Documents d=documentService.findDocumentById(1l);
//       List<RetraitRetourDoc> retraitRetourDocs=retraitRetourDocService.findRetraitByDocument(d);
//        for (RetraitRetourDoc retraitRetourDoc : retraitRetourDocs) {
//            System.out.println(""+retraitRetourDoc.getEtudiant().getMatricule()+" "+retraitRetourDoc.getEtudiant().getNom()+" "+retraitRetourDoc.getDateRetrait());
//        }
//        System.out.println("-------------------------------------------------------");
//        List<RetraitRetourDoc> retraitRetourDocs1=retraitRetourDocService.findRetourByDocument(d);
//        for (RetraitRetourDoc retraitRetourDoc : retraitRetourDocs1) {
//            System.out.println(""+retraitRetourDoc.getEtudiant().getMatricule()+" "+retraitRetourDoc.getEtudiant().getNom()+" "+retraitRetourDoc.getDateRetour());
//        }
//        
//        System.out.println("-------------------------------------------------------");
//        List<RetraitRetourDoc> retraitRetourDocs2=retraitRetourDocService.findRetraitRetourByDocument(d);
//        for (RetraitRetourDoc retraitRetourDoc : retraitRetourDocs2) {
//            System.out.println(""+retraitRetourDoc.getEtudiant().getMatricule()+" "+retraitRetourDoc.getEtudiant().getNom()+" "+retraitRetourDoc.getDateRetrait()+" "+retraitRetourDoc.getDateRetour());
//        }
//        AnneeAccademique aa=anneeAccademiqueService.findAnneeByAnnee("2012/2013");
//        List<Inscription> inscriptions=inscriptionService.findInscriptionByAnneAccademique(aa);
//        for (Inscription inscription : inscriptions) {
//            System.out.println(""+inscription);
//        }
        AnneeAccademique aa = anneeAccademiqueService.findAnneeByAnnee("2012/2013");
        Cycle cycle = cycleService.findCycleByNom("MASTER");
        Niveau niveau = niveauService.findNiveauByNom("Master II");
        Filiere filiere = filiereService.findFiliereByNom("INFOTEL");
        Option1 option1 = option1Service.findOptionbyNom("R.A.S");
        PaysOrigine paysOrigine = paysOrigineService.getPaysByNom("CAMEROUN");
        RegionOrigine regionOrigine = regionOrigineService.findRegionOrigineByNom("OU");
        Etudiant etudiant=new Etudiant();
        List<Inscription> inscriptions = inscriptionService.findInscriptionByAnneeAcademiqueCycleNiveau(aa, cycle,niveau);
        for (Inscription inscription : inscriptions) {
            System.out.println("" + inscription);
        }
        List<Inscription> inscriptions1 = inscriptionService.findInscriptionByAnneeAcademiqueNiveau(aa, niveau);
//        for (Inscription inscription : inscriptions1) {
//            System.out.println("" + inscription);
//        }
        List<Inscription> inscriptions2 = inscriptionService.findInscriptionByAnneeAcademiqueFiliere(aa, filiere);
//        for (Inscription inscription : inscriptions2) {
//            System.out.println("" + inscription);
//        }
        List<Inscription> inscriptions3 = inscriptionService.findInscriptionByAnneeAcademiqueOption(aa, option1);
//        for (Inscription inscription : inscriptions3) {
//            System.out.println("" + inscription);
//        }
        List<Inscription> inscriptions4 = inscriptionService.findInscriptionByAnneeAcademiquePaysOrigine(aa, paysOrigine);
//        for (Inscription inscription : inscriptions4) {
//            System.out.println("" + inscription);
//        }
        List<Inscription> inscriptions5 = inscriptionService.findInscriptionByAnneeAcademiqueRegionOrigine(aa, regionOrigine);
//        for (Inscription inscription : inscriptions5) {
//            System.out.println("" + inscription);
//        }
        List<Inscription> inscriptions6 = inscriptionService.findInscriptionByAnneeAcademiqueGenre(aa, "M");
//        for (Inscription inscription : inscriptions6) {
//            System.out.println("" + inscription);
//        }
    }
}
