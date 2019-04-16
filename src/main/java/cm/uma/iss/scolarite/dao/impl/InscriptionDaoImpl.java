/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IInscriptionDao;
import cm.uma.iss.scolarite.entities.AnneeAccademique;
import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.Etudiant;
import cm.uma.iss.scolarite.entities.Filiere;
import cm.uma.iss.scolarite.entities.Inscription;
import cm.uma.iss.scolarite.entities.Niveau;
import cm.uma.iss.scolarite.entities.Option1;
import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author ngnawen
 */
public class InscriptionDaoImpl extends GenericDao<Inscription, Long> implements IInscriptionDao {

    @Override
    public List<Inscription> findInscriptionByDate_inscription(String date) throws DataAccessException {
        return getManager().createQuery("select i from inscription i where i.date_inscription=:date")
                .setParameter("date", date).getResultList();
    }

    @Override
    public List<Inscription> findInscriptionByDEtudiant(Etudiant etudiant) throws DataAccessException {
        return getManager().createQuery("select i from inscription i where i.etudiant=:etudiant")
                .setParameter("etudiant", etudiant).getResultList();
    }

    @Override
    public List<Inscription> findInscriptionByFiliere(Filiere filiere) throws DataAccessException {
        return getManager().createQuery("select i from inscription i where i.filiere=:filiere")
                .setParameter("filiere", filiere).getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByNiveau(Niveau niveau) throws DataAccessException {
        return getManager().createQuery("select i from inscription i where i.niveau=:niveau")
                .setParameter("niveau", niveau).getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByOption(Option1 option1) throws DataAccessException {
        return getManager().createQuery("select i from inscription i where i.option1=:option1 ORDER BY i.etudiant.nom")
                .setParameter("option1", option1).getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneAccademique(AnneeAccademique anneeAccademique) throws DataAccessException {
        return getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique ORDER BY i.anneeAccademique.annee")
                .setParameter("anneeAccademique", anneeAccademique).getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycle(Cycle cycle) throws DataAccessException {
        return getManager().createQuery("select i from inscription i where i.cycle=:cycle ORDER BY i.etudiant.nom")
                .setParameter("cycle", cycle).getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Inscription findInscriptionByEtudiant(Etudiant etudiant) throws DataAccessException {
        return (Inscription) getManager().createQuery("select i from inscription i where i.etudiant=:etudiant")
                .setParameter("etudiant", etudiant).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereCycle(Filiere filiere, Cycle cycle) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere and i.cycle=:cycle");
        query.setParameter("filiere", filiere);
        query.setParameter("cycle", cycle);
        return query.getResultList();
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereCycleNiveau(Filiere filiere, Cycle cycle, Niveau niveau) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.cycle=:cycle AND i.niveau=:niveau AND i.etudiant.matricule NOT LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByListe(List<Filiere> filieres, Cycle cycle) throws DataAccessException {
        Query query = null;
        for (Filiere filiere : filieres) {
            query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.cycle=:cycle ORDER BY i.etudiant.nom");
            query.setParameter("cycle", cycle);
            query.setParameter("filiere", filiere);
            query.getResultList();
        }
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionTout() throws DataAccessException {
        return getManager().createQuery("select i from inscription i ORDER BY i.etudiant.nom").getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereCycleNiveauNouveau(Filiere filiere, Cycle cycle, Niveau niveau) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.cycle=:cycle AND i.niveau=:niveau AND i.etudiant.matricule LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereNouveau(Filiere filiere) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.etudiant.matricule LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycleNouveau(Cycle cycle) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where  i.cycle=:cycle AND i.etudiant.matricule LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("cycle", cycle);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByNiveauNouveau(Niveau niveau) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.niveau=:niveau AND i.etudiant.matricule LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("niveau", niveau);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereCycleNouveau(Filiere filiere, Cycle cycle) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.cycle=:cycle AND i.etudiant.matricule LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("cycle", cycle);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycleNiveauNouveau(Cycle cycle, Niveau niveau) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.cycle=:cycle AND i.niveau=:niveau AND i.etudiant.matricule LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereNiveauNouveau(Filiere filiere, Niveau niveau) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.niveau=:niveau AND i.etudiant.matricule LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("niveau", niveau);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereCycleNiveauAncien(Filiere filiere, Cycle cycle, Niveau niveau) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.cycle=:cycle AND i.niveau=:niveau AND i.etudiant.matricule NOT LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereAncien(Filiere filiere) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.etudiant.matricule NOT LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycleAncien(Cycle cycle) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where  i.cycle=:cycle AND i.etudiant.matricule NOT LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("cycle", cycle);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByNiveauAncien(Niveau niveau) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.niveau=:niveau AND i.etudiant.matricule NOT LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("niveau", niveau);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereCycleAncien(Filiere filiere, Cycle cycle) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.cycle=:cycle AND i.etudiant.matricule NOT LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("cycle", cycle);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycleNiveauAncien(Cycle cycle, Niveau niveau) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.cycle=:cycle AND i.niveau=:niveau AND i.etudiant.matricule NOT LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereNiveauAncien(Filiere filiere, Niveau niveau) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.niveau=:niveau AND i.etudiant.matricule NOT LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("niveau", niveau);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycleNiveau(Cycle cycle, Niveau niveau) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.cycle=:cycle AND i.niveau=:niveau ORDER BY i.etudiant.nom");
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycleNiveauFiliere(Cycle cycle, Niveau niveau, Filiere filiere) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.cycle=:cycle AND i.niveau=:niveau AND i.filiere=:filiere ORDER BY i.etudiant.nom");
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("filiere", filiere);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycleNiveauFiliereOption(Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where  i.cycle=:cycle AND i.niveau=:niveau AND i.filiere=:filiere AND i.option1=:option1 ORDER BY i.etudiant.nom");
        query.setParameter("cyclce", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("filiere", filiere);
        query.setParameter("option1", option1);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByPays(PaysOrigine paysOrigine) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where  i.etudiant.paysOrigine=:paysOrigine ORDER BY i.etudiant.nom");
        query.setParameter("paysOrigine", paysOrigine);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByRegion(RegionOrigine region) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where  i.etudiant.regionOrigine=:region ORDER BY i.etudiant.nom");
        query.setParameter("region", region);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByGenre(String genre) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where  i.etudiant.genre=:genre ORDER BY i.etudiant.nom");
        query.setParameter("genre", genre);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByNiveauFiliere(Niveau niveau, Filiere filiere) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where  i.niveau=:niveau AND i.filiere=:filiere ORDER BY i.etudiant.nom");
        query.setParameter("niveau", niveau);
        query.setParameter("filiere", filiere);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByNiveauOption(Niveau niveau, Option1 option1) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.niveau=:niveau AND i.option1=:option1 ORDER BY i.etudiant.nom");
        query.setParameter("niveau", niveau);
        query.setParameter("option1", option1);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereCycleFiliereGenre(Cycle cycle, Filiere filiere, String genre) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where  i.cycle=:cycle AND i.filiere=:filiere AND i.etudiant.genre=:genre ORDER BY i.etudiant.nom");
        query.setParameter("cyclce", cycle);
        query.setParameter("filiere", filiere);
        query.setParameter("genre", genre);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereRegion(Filiere filiere, RegionOrigine regionOrigine) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.etudiant.regionOrigine=:regionOrigine ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("regionOrigine", regionOrigine);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereRegionCycle(Filiere filiere, RegionOrigine regionOrigine, Cycle cycle) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.etudiant.regionOrigine=:regionOrigine AND i.cycle=:cycle ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("regionOrigine", regionOrigine);
        query.setParameter("cycle", cycle);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findNbreInscriptionByFiliereRegionCycle(Filiere filiere, RegionOrigine regionOrigine, Cycle cycle) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.etudiant.regionOrigine=:regionOrigine AND i.cycle=:cycle ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("regionOrigine", regionOrigine);
        query.setParameter("cycle", cycle);
        return query.getResultList().size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findNbreInscriptionByCycle(Cycle cycle) throws DataAccessException {
        return getManager().createQuery("select i from inscription i where i.cycle=:cycle")
                .setParameter("cycle", cycle).getResultList().size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findNbreInscriptionByFiliereCycle(Filiere filiere, Cycle cycle) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere and i.cycle=:cycle");
        query.setParameter("filiere", filiere);
        query.setParameter("cycle", cycle);
        return query.getResultList().size();
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findNbreInscriptionByFiliereRegionCycleAncien(Filiere filiere, RegionOrigine regionOrigine, Cycle cycle) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.etudiant.regionOrigine=:regionOrigine AND i.cycle=:cycle AND i.etudiant.matricule NOT LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("regionOrigine", regionOrigine);
        query.setParameter("cycle", cycle);
        return query.getResultList().size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findNbreInscriptionByFiliereCycleAncien(Filiere filiere, Cycle cycle) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.cycle=:cycle AND i.etudiant.matricule NOT LIKE '##%'");
        query.setParameter("filiere", filiere);
        query.setParameter("cycle", cycle);
        return query.getResultList().size();
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereNiveauAncienCamer(Filiere filiere, Niveau niveau, PaysOrigine paysOrigine) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.niveau=:niveau AND i.etudiant.paysOrigine=:paysOrigine AND i.etudiant.matricule NOT LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("niveau", niveau);
        query.setParameter("paysOrigine", paysOrigine);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findNbreFInscriptionByFiliereNiveauAncienCamer(Filiere filiere, Niveau niveau, PaysOrigine paysOrigine) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.niveau=:niveau AND i.etudiant.paysOrigine=:paysOrigine AND i.etudiant.genre='F' AND i.etudiant.matricule NOT LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("niveau", niveau);
        query.setParameter("paysOrigine", paysOrigine);
        return query.getResultList().size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findNbreMInscriptionByFiliereNiveauAncienCamer(Filiere filiere, Niveau niveau, PaysOrigine paysOrigine) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.niveau=:niveau AND i.etudiant.paysOrigine=:paysOrigine AND i.etudiant.genre='M' AND i.etudiant.matricule NOT LIKE '##%' ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("niveau", niveau);
        query.setParameter("paysOrigine", paysOrigine);
        return query.getResultList().size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionAllNouveaux() throws DataAccessException {
        return getManager().createQuery("select i from inscription i where i.etudiant.matricule LIKE '##%' ORDER BY i.etudiant.nom").getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycleAnnee(Cycle cycle, AnneeAccademique anneeAccademique) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle ORDER BY i.etudiant.nom");
        query.setParameter("cycle", cycle);
        query.setParameter("anneeAccademique", anneeAccademique);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByNiveauAnnee(Niveau niveau, AnneeAccademique anneeAccademique) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.niveau=:niveau ORDER BY i.etudiant.nom");
        query.setParameter("niveau", niveau);
        query.setParameter("anneeAccademique", anneeAccademique);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereCycleAnnee(Filiere filiere, Cycle cycle, AnneeAccademique anneeAccademique) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.cycle=:cycle AND i.anneeAccademique=:anneeAccademique ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("cycle", cycle);
        query.setParameter("anneeAccademique", anneeAccademique);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findNbreInscriptionByFiliereRegionCycleAnnee(Filiere filiere, RegionOrigine regionOrigine, Cycle cycle, AnneeAccademique anneeAccademique) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.etudiant.regionOrigine=:regionOrigine AND i.cycle=:cycle AND i.anneeAccademique=:anneeAccademique ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("regionOrigine", regionOrigine);
        query.setParameter("cycle", cycle);
        query.setParameter("anneeAccademique", anneeAccademique);
        return query.getResultList().size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereNiveauAnnee(Filiere filiere, Niveau niveau, PaysOrigine paysOrigine, AnneeAccademique anneeAccademique) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.niveau=:niveau AND i.etudiant.paysOrigine=:paysOrigine AND i.anneeAccademique=:anneeAccademique ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("niveau", niveau);
        query.setParameter("paysOrigine", paysOrigine);
        query.setParameter("anneeAccademique", anneeAccademique);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereNiveauAnnee(Filiere filiere, Niveau niveau, AnneeAccademique anneeAccademique) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.filiere=:filiere AND i.niveau=:niveau AND i.anneeAccademique=:anneeAccademique ORDER BY i.etudiant.nom");
        query.setParameter("filiere", filiere);
        query.setParameter("niveau", niveau);
        query.setParameter("anneeAccademique", anneeAccademique);
        return query.getResultList();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycle(AnneeAccademique anneeAccademique, Cycle cycle) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueNiveau(AnneeAccademique anneeAccademique, Niveau niveau) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.niveau=:niveau ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("niveau", niveau);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueFiliere(AnneeAccademique anneeAccademique, Filiere filiere) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.filiere=:filiere ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("filiere", filiere);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueOption(AnneeAccademique anneeAccademique, Option1 option1) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.option1=:option1 ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("option1", option1);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiquePaysOrigine(AnneeAccademique anneeAccademique, PaysOrigine paysOrigine) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.etudiant.paysOrigine=:paysOrigine ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("paysOrigine", paysOrigine);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueRegionOrigine(AnneeAccademique anneeAccademique, RegionOrigine regionOrigine) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.etudiant.regionOrigine=:regionOrigine ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("regionOrigine", regionOrigine);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueGenre(AnneeAccademique anneeAccademique, String genre) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.etudiant.genre=:genre ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("genre", genre);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveau(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.niveau=:niveau ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleFiliere(AnneeAccademique anneeAccademique, Cycle cycle, Filiere filiere) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.filiere=:filiere ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("filiere", filiere);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleOption(AnneeAccademique anneeAccademique, Cycle cycle, Option1 option1) throws DataAccessException {
       Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.option1=:option1 ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("option1", option1);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCyclePaysOrigine(AnneeAccademique anneeAccademique, Cycle cycle, PaysOrigine paysOrigine) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.etudiant.paysOrigine=:paysOrigine ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("paysOrigine", paysOrigine);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleRegionOrigine(AnneeAccademique anneeAccademique, Cycle cycle, RegionOrigine regionOrigine) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.etudiant.regionOrigine=:regionOrigine ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("regionOrigine", regionOrigine);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleGenre(AnneeAccademique anneeAccademique, Cycle cycle, String genre) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.etudiant.genre=:genre ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("genre", genre);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliere(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.niveau=:niveau AND i.filiere=:filiere ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("filiere", filiere);
        return query.getResultList();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauOption(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Option1 option1) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.niveau=:niveau AND i.option1=:option1 ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("option1", option1);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauPaysOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, PaysOrigine paysOrigine) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.niveau=:niveau AND i.etudiant.paysOrigine=:paysOrigine ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("paysOrigine", paysOrigine);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauRegionOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, RegionOrigine regionOrigine) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.niveau=:niveau AND i.etudiant.regionOrigine=:regionOrigine ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("regionOrigine", regionOrigine);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauGenre(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, String genre) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.niveau=:niveau AND i.etudiant.genre=:genre ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("genre", genre);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOption(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.niveau=:niveau AND i.filiere=:filiere AND i.option1=:option1 ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("filiere", filiere);
        query.setParameter("option1", option1);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFilierePaysOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, PaysOrigine paysOrigine) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.niveau=:niveau AND i.filiere=:filiere AND i.etudiant.paysOrigine=:paysOrigine ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("filiere", filiere);
        query.setParameter("paysOrigine", paysOrigine);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereRegionOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, RegionOrigine regionOrigine) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.niveau=:niveau AND i.filiere=:filiere AND i.etudiant.regionOrigine=:regionOrigine ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("filiere", filiere);
        query.setParameter("regionOrigine", regionOrigine);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereGenre(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, String genre) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.niveau=:niveau AND i.filiere=:filiere AND i.etudiant.genre=:genre ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("filiere", filiere);
        query.setParameter("genre", genre);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1, PaysOrigine paysOrigine) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.niveau=:niveau AND i.filiere=:filiere AND i.option1=:option1 AND i.etudiant.paysOrigine=:paysOrigine ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("filiere", filiere);
        query.setParameter("option1", option1);
        query.setParameter("paysOrigine", paysOrigine);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionRegionOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1, RegionOrigine regionOrigine) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.niveau=:niveau AND i.filiere=:filiere AND i.option1=:option1 AND i.etudiant.regionOrigine=:regionOrigine ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("filiere", filiere);
        query.setParameter("option1", option1);
        query.setParameter("regionOrigine", regionOrigine);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionGenre(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1, String genre) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.niveau=:niveau AND i.filiere=:filiere AND i.option1=:option1 AND i.etudiant.genre=:genre ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("filiere", filiere);
        query.setParameter("option1", option1);
        query.setParameter("genre", genre);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigineRegionOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1, PaysOrigine paysOrigine, RegionOrigine regionOrigine) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.niveau=:niveau AND i.filiere=:filiere AND i.option1=:option1 AND i.etudiant.paysOrigine=:paysOrigine AND i.etudiant.regionOrigine=:regionOrigine ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("filiere", filiere);
        query.setParameter("option1", option1);
        query.setParameter("paysOrigine", paysOrigine);
        query.setParameter("regionOrigine", regionOrigine);
        return query.getResultList();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigineGenre(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1, PaysOrigine paysOrigine, String genre) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.niveau=:niveau AND i.filiere=:filiere AND i.option1=:option1 AND i.etudiant.paysOrigine=:paysOrigine AND i.etudiant.genre=:genre ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("filiere", filiere);
        query.setParameter("option1", option1);
        query.setParameter("paysOrigine", paysOrigine);
        query.setParameter("genre", genre);
        return query.getResultList();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigineRegionOrigineGenre(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1, PaysOrigine paysOrigine, RegionOrigine regionOrigine, String genre) throws DataAccessException {
        Query query = getManager().createQuery("select i from inscription i where i.anneeAccademique=:anneeAccademique AND i.cycle=:cycle AND i.niveau=:niveau AND i.filiere=:filiere AND i.option1=:option1 AND i.etudiant.paysOrigine=:paysOrigine AND i.etudiant.regionOrigine=:regionOrigine AND i.etudiant.genre=:genre ORDER BY i.etudiant.nom");
        query.setParameter("anneeAccademique", anneeAccademique);
        query.setParameter("cycle", cycle);
        query.setParameter("niveau", niveau);
        query.setParameter("filiere", filiere);
        query.setParameter("option1", option1);
        query.setParameter("paysOrigine", paysOrigine);
        query.setParameter("regionOrigine", regionOrigine);
        query.setParameter("genre", genre);
        return query.getResultList(); //To change body of generated methods, choose Tools | Templates.
    }
}
