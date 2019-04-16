/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.PaysOrigine;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ngnawen
 */
public interface IRegionOrigineService {

    public RegionOrigine registerRegionOrigine(RegionOrigine region) throws DataAccessException;

    public RegionOrigine updateRegionOrigine(RegionOrigine region) throws DataAccessException;

    public void deleteRegionOrigine(Long id_region) throws DataAccessException;

    public RegionOrigine findRegionOrigineById(long id_region) throws DataAccessException;

    public List<RegionOrigine> findRegionOrigineAll() throws DataAccessException;

    public RegionOrigine findRegionOrigineByNom(String nom) throws DataAccessException;

    public List<RegionOrigine> findRegionByPays(PaysOrigine pays) throws DataAccessException;
    
    public List<RegionOrigine> findRegionTout() throws DataAccessException;
}
