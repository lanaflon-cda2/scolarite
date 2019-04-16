/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

import cm.uma.iss.scolarite.entities.DepartementOrigine;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IDepartementOrigineDao extends IDao<DepartementOrigine, Long> {
    
    public DepartementOrigine findDepartementOrigineByNom(String nom)throws DataAccessException;
    
    public List<DepartementOrigine> findDepartementOrigineByRegion(RegionOrigine regionOrigine)throws DataAccessException;
    
    
}
