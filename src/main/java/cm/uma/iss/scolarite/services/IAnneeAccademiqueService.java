/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.AnneeAccademique;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IAnneeAccademiqueService {

    public AnneeAccademique registerAnnee_accademique(AnneeAccademique annee_accademique) throws DataAccessException;

    public AnneeAccademique updateAnnee_accademique(AnneeAccademique annee_accademique) throws DataAccessException;

    public void deleteAnnee_accademique(Long id_annee_accademique) throws DataAccessException;
    
    public void deleteAnnee_accademique1(AnneeAccademique annee_accademique) throws DataAccessException;

    public AnneeAccademique findAnnee_accademiqueById(long id_annee_accademique) throws DataAccessException;

    public List<AnneeAccademique> findAnnee_accademiqueAll() throws DataAccessException;

    public AnneeAccademique findAnneeByDebut(String debutAnnee) throws DataAccessException;

    public AnneeAccademique findAnneeByFin(String finAnnee) throws DataAccessException;
    
    public AnneeAccademique findAnneeByDebutFin(String debutAnnee,String finAnnee) throws DataAccessException;
    
    public AnneeAccademique findAnneeByAnnee(String annee) throws DataAccessException;
}
