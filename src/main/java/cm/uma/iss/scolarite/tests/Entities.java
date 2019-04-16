/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.tests;

import cm.uma.iss.scolarite.entities.Documents;
import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.entities.RetraitRetourDoc;
import cm.uma.iss.scolarite.entities.RoleUtilisateur;
import cm.uma.iss.scolarite.entities.Utilisateur;
import java.text.DateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * cette classe permet de tester la couche de persistence
 *
 * @author ngnawen
 */
public class Entities {

    public static void main(String[] args) {
// Contexte de persistance
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scolaritePU");
        EntityManager em = null;
// on récupère un EntityManager à partir de l'EntityManagerFactory précédent
        em = emf.createEntityManager();
// début transaction
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //création des pays
//        PaysOrigine p1 = new PaysOrigine();
//        p1.setNom_pays("Cameroun");
//        em.persist(p1);
        Documents d=new Documents();
        d.setType("ce");
        em.persist(d);
        
        RetraitRetourDoc r=new RetraitRetourDoc();
        r.setDateRetrait("" + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()));
//        r.setDocuementId(d.getId_document());
        em.persist(r);

        //creation des utilisateurs
//        Utilisateur utilisateur = new Utilisateur();
//        utilisateur.setEmail("ngnawen@yahoo.fr1");
//        utilisateur.setGenre("masculin1");
//        utilisateur.setLogin("admin1");
//        utilisateur.setNom("ngnawen1");
//        utilisateur.setPassword("admin1");
//        utilisateur.setPrenom("samuel vermon1");
//        utilisateur.setRole_utilisateur("admin1");
//        utilisateur.setTelephone("79929282X");
//        em.persist(utilisateur);
//        
//        //role utilisateur
//        RoleUtilisateur ru=new RoleUtilisateur();
//        ru.setRoleuser("toto");
//        ru.setUtilisateur(utilisateur);
//        em.persist(ru);
        
        // fin transaction
        tx.commit();
// fin EntityManager
        em.close();
// fin EntityMangerFactory
        emf.close();


    }
}
