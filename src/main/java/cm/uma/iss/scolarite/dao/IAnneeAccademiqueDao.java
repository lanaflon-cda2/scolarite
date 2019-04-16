/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

import cm.uma.iss.scolarite.entities.AnneeAccademique;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;

/**
 *
 * @author ngnawen
 */
public interface IAnneeAccademiqueDao extends IDao<AnneeAccademique, Long> {

    public AnneeAccademique findAnneeByDebut(String debutAnnee) throws DataAccessException;

    public AnneeAccademique findAnneeByFin(String finAnnee) throws DataAccessException;
    
     public AnneeAccademique findAnneeByDebutFin(String debutAnnee,String finAnnee) throws DataAccessException;
     
     public AnneeAccademique findAnneeByAnnee(String annee) throws DataAccessException;
}
