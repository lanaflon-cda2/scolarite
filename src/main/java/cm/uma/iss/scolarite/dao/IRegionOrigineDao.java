/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IRegionOrigineDao extends IDao<RegionOrigine, Long> {
    
   public RegionOrigine findRegionOrigineByNom(String nom)throws DataAccessException; 
   
   public List<RegionOrigine> findRegionByPays(PaysOrigine pays)throws DataAccessException;
   
   public List<RegionOrigine> findRegionTout()throws DataAccessException;
}
