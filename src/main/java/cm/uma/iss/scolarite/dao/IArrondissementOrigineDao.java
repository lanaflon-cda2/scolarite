/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

import cm.uma.iss.scolarite.entities.ArrondissementOrigine;
import cm.uma.iss.scolarite.entities.DepartementOrigine;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IArrondissementOrigineDao extends IDao<ArrondissementOrigine,Long> {

public ArrondissementOrigine findArrondissementOrigineByNom(String nom)throws DataAccessException;

public List<ArrondissementOrigine> findArrondissementOrigneByDepartement(DepartementOrigine DepartementOrigine)
        throws DataAccessException;
    
}
