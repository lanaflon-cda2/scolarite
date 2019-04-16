/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

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
import cm.uma.iss.scolarite.services.IInscriptionService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ngnawen
 */
@Transactional
public class InscriptionServiceImpl implements IInscriptionService {

    IInscriptionDao inscriptionDao;

    public IInscriptionDao getInscriptionDao() {
        return inscriptionDao;
    }

    public void setInscriptionDao(IInscriptionDao inscriptionDao) {
        this.inscriptionDao = inscriptionDao;
    }

    @Override
    public Inscription registerInscription(Inscription inscription) throws DataAccessException {
        try {
            return inscriptionDao.create(inscription);
        } catch (Exception e) {

            return null;
        }
    }

    @Override
    public Inscription updateInscription(Inscription inscription) throws DataAccessException {
        try {
            return inscriptionDao.update(inscription);
        } catch (Exception e) {

            return null;
        }
    }

    @Override
    public Inscription findInscriptionById(long id_inscription) throws DataAccessException {
        try {
            return inscriptionDao.findById(id_inscription);
        } catch (Exception e) {

            return null;
        }
    }

    @Override
    public List<Inscription> findInscriptionAll() throws DataAccessException {
        try {
            return inscriptionDao.findAll();
        } catch (Exception e) {

            return null;
        }
    }

    @Override
    public void deleteInscription(Long id_inscription) throws DataAccessException {
        try {
            Inscription inscription = inscriptionDao.findById(id_inscription);
            inscriptionDao.delete(inscription);
        } catch (Exception e) {
        }
    }

    @Override
    public List<Inscription> findInscriptionByDate_inscription(String date) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByDate_inscription(date);
        } catch (Exception e) {

            return null;
        }
    }

    @Override
    public List<Inscription> findInscriptionByDEtudiant(Etudiant etudiant) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByDEtudiant(etudiant);
        } catch (Exception e) {

            return null;
        }
    }

    @Override
    public List<Inscription> findInscriptionByFiliere(Filiere filiere) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliere(filiere);
        } catch (Exception e) {

            return null;
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByNiveau(Niveau niveau) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByNiveau(niveau);
        } catch (Exception e) {

            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByOption(Option1 option) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByOption(option);
        } catch (Exception e) {

            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneAccademique(AnneeAccademique anneeAccademique) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneAccademique(anneeAccademique);
        } catch (Exception e) {

            return null;
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycle(Cycle cycle) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByCycle(cycle);
        } catch (Exception e) {

            return null;
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Inscription findInscriptionByEtudiant(Etudiant etudiant) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByEtudiant(etudiant);
        } catch (Exception e) {

            return null;
        }
    }//To change body of generated methods, choose Tools | Templates.

    @Override
    public List<Inscription> findInscriptionByFiliereCycle(Filiere filiere, Cycle cycle) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereCycle(filiere, cycle);
        } catch (Exception e) {

            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereCycleNiveau(Filiere filiere, Cycle cycle, Niveau niveau) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereCycleNiveau(filiere, cycle, niveau);
        } catch (Exception e) {

            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionTout() throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionTout();
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereCycleNiveauNouveau(Filiere filiere, Cycle cycle, Niveau niveau) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereCycleNiveauNouveau(filiere, cycle, niveau);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByPays(PaysOrigine pays) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByPays(pays);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByRegion(RegionOrigine region) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByRegion(region);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycleNiveau(Cycle cycle, Niveau niveau) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByCycleNiveau(cycle, niveau);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycleNiveauFiliere(Cycle cycle, Niveau niveau, Filiere filiere) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByCycleNiveauFiliere(cycle, niveau, filiere);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycleNiveauFiliereOption(Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByCycleNiveauFiliereOption(cycle, niveau, filiere, option1);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByGenre(String genre) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByGenre(genre);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByNiveauFiliere(Niveau niveau, Filiere filiere) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByNiveauFiliere(niveau, filiere);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByNiveauOption(Niveau niveau, Option1 option1) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByNiveauOption(niveau, option1);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereCycleFiliereGenre(Cycle cycle, Filiere filiere, String genre) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereCycleFiliereGenre(cycle, filiere, genre);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereRegion(Filiere filiere, RegionOrigine region) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereRegion(filiere, region);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereRegionCycle(Filiere filiere, RegionOrigine region, Cycle cycle) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereRegionCycle(filiere, region, cycle);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findNbreInscriptionByFiliereRegionCycle(Filiere filiere, RegionOrigine region, Cycle cycle) throws DataAccessException {
        try {
            return inscriptionDao.findNbreInscriptionByFiliereRegionCycle(filiere, region, cycle);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int findNbreInscriptionByCycle(Cycle cycle) throws DataAccessException {
        try {
            return inscriptionDao.findNbreInscriptionByCycle(cycle);
        } catch (Exception e) {

            return 0;
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findNbreInscriptionByFiliereCycle(Filiere filiere, Cycle cycle) throws DataAccessException {
        try {
            return inscriptionDao.findNbreInscriptionByFiliereCycle(filiere, cycle);
        } catch (Exception e) {

            return 0;
        }
    }

    @Override
    public List<Inscription> findInscriptionByFiliereNiveauNouveau(Filiere filiere, Niveau niveau) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereNiveauNouveau(filiere, niveau);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycleNiveauNouveau(Cycle cycle, Niveau niveau) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByCycleNiveau(cycle, niveau);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereCycleNouveau(Filiere filiere, Cycle cycle) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereCycleNouveau(filiere, cycle);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByNiveauNouveau(Niveau niveau) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByNiveauNouveau(niveau);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycleNouveau(Cycle cycle) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByCycleNouveau(cycle);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereNouveau(Filiere filiere) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereNouveau(filiere);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereCycleNiveauAncien(Filiere filiere, Cycle cycle, Niveau niveau) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereCycleNiveauAncien(filiere, cycle, niveau);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereAncien(Filiere filiere) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereAncien(filiere);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycleAncien(Cycle cycle) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByCycleAncien(cycle);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByNiveauAncien(Niveau niveau) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByNiveauAncien(niveau);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereCycleAncien(Filiere filiere, Cycle cycle) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereCycleAncien(filiere, cycle);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycleNiveauAncien(Cycle cycle, Niveau niveau) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByCycleNiveauAncien(cycle, niveau);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereNiveauAncien(Filiere filiere, Niveau niveau) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereNiveauAncien(filiere, niveau);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findNbreInscriptionByFiliereRegionCycleAncien(Filiere filiere, RegionOrigine regionOrigine, Cycle cycle) throws DataAccessException {
        try {
            return inscriptionDao.findNbreInscriptionByFiliereRegionCycleAncien(filiere, regionOrigine, cycle);
        } catch (Exception e) {
            return 0;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findNbreInscriptionByFiliereCycleAncien(Filiere filiere, Cycle cycle) throws DataAccessException {
        try {
            return inscriptionDao.findNbreInscriptionByFiliereCycleAncien(filiere, cycle);
        } catch (Exception e) {
            return 0;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereNiveauAncienCamer(Filiere filiere, Niveau niveau, PaysOrigine paysOrigine) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereNiveauAncienCamer(filiere, niveau, paysOrigine);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findNbreFInscriptionByFiliereNiveauAncienCamer(Filiere filiere, Niveau niveau, PaysOrigine paysOrigine) throws DataAccessException {
        try {
            return inscriptionDao.findNbreFInscriptionByFiliereNiveauAncienCamer(filiere, niveau, paysOrigine);
        } catch (Exception e) {
            return 0;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findNbreMInscriptionByFiliereNiveauAncienCamer(Filiere filiere, Niveau niveau, PaysOrigine paysOrigine) throws DataAccessException {
        try {
            return inscriptionDao.findNbreMInscriptionByFiliereNiveauAncienCamer(filiere, niveau, paysOrigine);
        } catch (Exception e) {
            return 0;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionAllNouveaux() throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionAllNouveaux();
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByCycleAnnee(Cycle cycle, AnneeAccademique anneeAccademique) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByCycleAnnee(cycle, anneeAccademique);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByNiveauAnnee(Niveau niveau, AnneeAccademique anneeAccademique) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByNiveauAnnee(niveau, anneeAccademique);
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereCycleAnnee(Filiere filiere, Cycle cycle, AnneeAccademique anneeAccademique) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereCycleAnnee(filiere, cycle, anneeAccademique);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findNbreInscriptionByFiliereRegionCycleAnnee(Filiere filiere, RegionOrigine regionOrigine, Cycle cycle, AnneeAccademique anneeAccademique) throws DataAccessException {
        try {
            return inscriptionDao.findNbreInscriptionByFiliereRegionCycleAnnee(filiere, regionOrigine, cycle, anneeAccademique);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<Inscription> findInscriptionByFiliereNiveauAnnee(Filiere filiere, Niveau niveau, PaysOrigine paysOrigine, AnneeAccademique anneeAccademique) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereNiveauAnnee(filiere, niveau, paysOrigine, anneeAccademique);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByFiliereNiveauAnnee(Filiere filiere, Niveau niveau, AnneeAccademique anneeAccademique) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByFiliereNiveauAnnee(filiere, niveau, anneeAccademique);
        } catch (Exception e) {
            return null;
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycle(AnneeAccademique anneeAccademique, Cycle cycle) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycle(anneeAccademique, cycle);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueNiveau(AnneeAccademique anneeAccademique, Niveau niveau) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueNiveau(anneeAccademique, niveau);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueFiliere(AnneeAccademique anneeAccademique, Filiere filiere) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueFiliere(anneeAccademique, filiere);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueOption(AnneeAccademique anneeAccademique, Option1 option1) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueOption(anneeAccademique, option1);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiquePaysOrigine(AnneeAccademique anneeAccademique, PaysOrigine paysOrigine) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiquePaysOrigine(anneeAccademique, paysOrigine);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueRegionOrigine(AnneeAccademique anneeAccademique, RegionOrigine regionOrigine) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueRegionOrigine(anneeAccademique, regionOrigine);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueGenre(AnneeAccademique anneeAccademique, String genre) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueGenre(anneeAccademique, genre);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveau(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleNiveau(anneeAccademique, cycle, niveau);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleFiliere(AnneeAccademique anneeAccademique, Cycle cycle, Filiere filiere) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleFiliere(anneeAccademique, cycle, filiere);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleOption(AnneeAccademique anneeAccademique, Cycle cycle, Option1 option1) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleOption(anneeAccademique, cycle, option1);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCyclePaysOrigine(AnneeAccademique anneeAccademique, Cycle cycle, PaysOrigine paysOrigine) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCyclePaysOrigine(anneeAccademique, cycle, paysOrigine);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleRegionOrigine(AnneeAccademique anneeAccademique, Cycle cycle, RegionOrigine regionOrigine) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleRegionOrigine(anneeAccademique, cycle, regionOrigine);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleGenre(AnneeAccademique anneeAccademique, Cycle cycle, String genre) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleGenre(anneeAccademique, cycle, genre);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliere(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleNiveauFiliere(anneeAccademique, cycle, niveau, filiere);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauOption(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Option1 option1) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleNiveauOption(anneeAccademique, cycle, niveau, option1);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauPaysOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, PaysOrigine paysOrigine) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleNiveauPaysOrigine(anneeAccademique, cycle, niveau, paysOrigine);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauRegionOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, RegionOrigine regionOrigine) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleNiveauRegionOrigine(anneeAccademique, cycle, niveau, regionOrigine);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauGenre(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, String genre) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleNiveauGenre(anneeAccademique, cycle, niveau, genre);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOption(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleNiveauFiliereOption(anneeAccademique, cycle, niveau, filiere, option1);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFilierePaysOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, PaysOrigine paysOrigine) throws DataAccessException {
     try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleNiveauFilierePaysOrigine(anneeAccademique, cycle, niveau, filiere, paysOrigine);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereRegionOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, RegionOrigine regionOrigine) throws DataAccessException {
      try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleNiveauFiliereRegionOrigine(anneeAccademique, cycle, niveau, filiere, regionOrigine);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereGenre(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, String genre) throws DataAccessException {
     try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleNiveauFiliereGenre(anneeAccademique, cycle, niveau, filiere, genre);
        } catch (Exception e) {
            return null;
        }  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1, PaysOrigine paysOrigine) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigine(anneeAccademique, cycle, niveau, filiere, option1,paysOrigine);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionRegionOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1, RegionOrigine regionOrigine) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionRegionOrigine(anneeAccademique, cycle, niveau, filiere, option1,regionOrigine);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionGenre(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1, String genre) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionGenre(anneeAccademique, cycle, niveau, filiere, option1,genre);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigineRegionOrigine(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1, PaysOrigine paysOrigine, RegionOrigine regionOrigine) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigineRegionOrigine(anneeAccademique, cycle, niveau, filiere, option1,paysOrigine,regionOrigine);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigineGenre(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1, PaysOrigine paysOrigine, String genre) throws DataAccessException {
        try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigineGenre(anneeAccademique, cycle, niveau, filiere, option1,paysOrigine,genre);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inscription> findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigineRegionOrigineGenre(AnneeAccademique anneeAccademique, Cycle cycle, Niveau niveau, Filiere filiere, Option1 option1, PaysOrigine paysOrigine, RegionOrigine regionOrigine, String genre) throws DataAccessException {
     try {
            return inscriptionDao.findInscriptionByAnneeAcademiqueCycleNiveauFiliereOptionPaysOrigineRegionOrigineGenre(anneeAccademique, cycle, niveau, filiere, option1,paysOrigine,regionOrigine,genre);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }
}
