/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

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
import com.douwe.generic.dao.IDao;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IInscriptionDao extends IDao<Inscription, Long> {

    public List<Inscription> findInscriptionByDate_inscription(String date) throws DataAccessException;

    public List<Inscription> findInscriptionByDEtudiant(Etudiant etudiant) throws DataAccessException;

    public List<Inscription> findInscriptionTout() throws DataAccessException;

    public Inscription findInscriptionByEtudiant(Etudiant etudiant) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliere(Filiere filiere) throws DataAccessException;

    public List<Inscription> findInscriptionByPays(PaysOrigine pays) throws DataAccessException;

    public List<Inscription> findInscriptionByRegion(RegionOrigine region) throws DataAccessException;

    public List<Inscription> findInscriptionByNiveau(Niveau niveau) throws DataAccessException;

    public List<Inscription> findInscriptionByNiveauAnnee(Niveau niveau, AnneeAccademique anneeAccademique) throws DataAccessException;

    public List<Inscription> findInscriptionByOption(Option1 option1) throws DataAccessException;

    public List<Inscription> findInscriptionByAnneAccademique(AnneeAccademique anneeAccademique) throws DataAccessException;

    public List<Inscription> findInscriptionByCycle(Cycle cycle) throws DataAccessException;

    public int findNbreInscriptionByCycle(Cycle cycle) throws DataAccessException;

    public List<Inscription> findInscriptionByGenre(String genre) throws DataAccessException;

    public List<Inscription> findInscriptionByCycleNiveau(Cycle cycle, Niveau niveau) throws DataAccessException;

    public List<Inscription> findInscriptionByNiveauFiliere(Niveau niveau, Filiere filiere) throws DataAccessException;

    public List<Inscription> findInscriptionByCycleNiveauFiliere(Cycle cycle, Niveau niveau, Filiere filiere) throws DataAccessException;

    public List<Inscription> findInscriptionByCycleNiveauFiliereOption(Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1) throws DataAccessException;

    public List<Inscription> findInscriptionByNiveauOption(Niveau niveau, Option1 option1) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereCycle(Filiere filiere, Cycle cycle) throws DataAccessException;

    public int findNbreInscriptionByFiliereCycle(Filiere filiere, Cycle cycle) throws DataAccessException;

    //public List<Inscription> findInscriptionByFiliereCycleAnnee(Filiere filiere, Cycle cycle,AnneeAccademique anneeAccademique) throws DataAccessException;
    public int findNbreInscriptionByFiliereCycleAncien(Filiere filiere, Cycle cycle) throws DataAccessException;

    public List<Inscription> findInscriptionByListe(List<Filiere> filieres, Cycle cycle) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereCycleNiveau(Filiere filiere, Cycle cycle, Niveau niveau) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereCycleNiveauNouveau(Filiere filiere, Cycle cycle, Niveau niveau) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereCycleFiliereGenre(Cycle cycle, Filiere filiere, String genre) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereRegion(Filiere filiere, RegionOrigine region) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereRegionCycle(Filiere filiere, RegionOrigine region, Cycle cycle) throws DataAccessException;

    public int findNbreInscriptionByFiliereRegionCycle(Filiere filiere, RegionOrigine region, Cycle cycle) throws DataAccessException;

    public int findNbreInscriptionByFiliereRegionCycleAnnee(Filiere filiere, RegionOrigine region, Cycle cycle, AnneeAccademique anneeAccademique) throws DataAccessException;

    public int findNbreInscriptionByFiliereRegionCycleAncien(Filiere filiere, RegionOrigine region, Cycle cycle) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereNiveauNouveau(Filiere filiere, Niveau niveau) throws DataAccessException;

    public List<Inscription> findInscriptionByCycleNiveauNouveau(Cycle cycle, Niveau niveau) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereCycleNouveau(Filiere filiere, Cycle cycle) throws DataAccessException;

    public List<Inscription> findInscriptionByNiveauNouveau(Niveau niveau) throws DataAccessException;

    public List<Inscription> findInscriptionByCycleNouveau(Cycle cycle) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereNouveau(Filiere filiere) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereCycleNiveauAncien(Filiere filiere, Cycle cycle, Niveau niveau) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereAncien(Filiere filiere) throws DataAccessException;

    public List<Inscription> findInscriptionByCycleAncien(Cycle cycle) throws DataAccessException;

    public List<Inscription> findInscriptionByCycleAnnee(Cycle cycle, AnneeAccademique anneeAccademique) throws DataAccessException;

    public List<Inscription> findInscriptionByNiveauAncien(Niveau niveau) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereCycleAncien(Filiere filiere, Cycle cycle) throws DataAccessException;

    public List<Inscription> findInscriptionByCycleNiveauAncien(Cycle cycle, Niveau niveau) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereNiveauAncien(Filiere filiere, Niveau niveau) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereNiveauAnnee(Filiere filiere, Niveau niveau, AnneeAccademique anneeAccademique) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereNiveauAncienCamer(Filiere filiere, Niveau niveau, PaysOrigine paysOrigine) throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereNiveauAnnee(Filiere filiere, Niveau niveau, PaysOrigine paysOrigine, AnneeAccademique anneeAccademique) throws DataAccessException;

    public int findNbreFInscriptionByFiliereNiveauAncienCamer(Filiere filiere, Niveau niveau, PaysOrigine paysOrigine) throws DataAccessException;

    public int findNbreMInscriptionByFiliereNiveauAncienCamer(Filiere filiere, Niveau niveau, PaysOrigine paysOrigine) throws DataAccessException;

    public List<Inscription> findInscriptionAllNouveaux() throws DataAccessException;

    public List<Inscription> findInscriptionByFiliereCycleAnnee(Filiere filiere, Cycle cycle, AnneeAccademique anneeAccademique) throws DataAccessException;

    public List<Inscription> findInscriptionByAnneeAcademiqueCycle(AnneeAccademique anneeAccademique, Cycle cycle) throws DataAccessException;

    public List<Inscription> findInscriptionByAnneeAcademiqueNiveau(AnneeAccademique anneeAccademique, Niveau niveau) throws DataAccessException;

    public List<Inscription> findInscriptionByAnneeAcademiqueFiliere(AnneeAccademique anneeAccademique, Filiere filiere) throws DataAccessException;

    public List<Inscription> findInscriptionByAnneeAcademiqueOption(AnneeAccademique anneeAccademique, Option1 option1) throws DataAccessException;

    public List<Inscription> findInscriptionByAnneeAcademiquePaysOrigine(AnneeAccademique anneeAccademique, PaysOrigine paysOrigine) throws DataAccessException;

    public List<Inscription> findInscriptionByAnneeAcademiqueRegionOrigine(AnneeAccademique anneeAccademique, RegionOrigine regionOrigine) throws DataAccessException;

    public List<Inscription> findInscriptionByAnneeAcademiqueGenre(AnneeAccademique anneeAccademique, String genre) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveau(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleFiliere(AnneeAccademique anneeAccademique, Cycle cycle, Filiere filiere) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleOption(AnneeAccademique anneeAccademique, Cycle cycle, Option1 option1) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCyclePaysOrigine(AnneeAccademique anneeAccademique, Cycle cycle, PaysOrigine paysOrigine) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleRegionOrigine(AnneeAccademique anneeAccademique, Cycle cycle, RegionOrigine regionOrigine) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleGenre(AnneeAccademique anneeAccademique, Cycle cycle, String genre) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliere(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau,Filiere filiere) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauOption(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau,Option1 option1) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauPaysOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, PaysOrigine paysOrigine) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauRegionOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau,RegionOrigine regionOrigine) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauGenre(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau,String genre) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOption(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau,Filiere filiere,Option1 option1) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFilierePaysOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau,Filiere filiere,PaysOrigine paysOrigine) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereRegionOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau,Filiere filiere,RegionOrigine regionOrigine) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereGenre(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau,Filiere filiere, String genre) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau,Filiere filiere,Option1 option1,PaysOrigine paysOrigine) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionRegionOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau,Filiere filiere,Option1 option1,RegionOrigine regionOrigine) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionGenre(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau,Filiere filiere,Option1 option1,String genre) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigineRegionOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau,Filiere filiere,Option1 option1,PaysOrigine paysOrigine,RegionOrigine regionOrigine) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigineGenre(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau,Filiere filiere,Option1 option1,PaysOrigine paysOrigine,String genre) throws DataAccessException;
    
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigineRegionOrigineGenre(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau,Filiere filiere,Option1 option1,PaysOrigine paysOrigine,RegionOrigine regionOrigine, String genre) throws DataAccessException;
}
