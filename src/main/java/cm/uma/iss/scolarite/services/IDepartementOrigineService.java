/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.DepartementOrigine;
import cm.uma.iss.scolarite.entities.RegionOrigine;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ngnawen
 */
public interface IDepartementOrigineService {
    
    public DepartementOrigine registerDepartementOrigine(DepartementOrigine departement) throws DataAccessException;

    public DepartementOrigine updateDepartementOrigine(DepartementOrigine departement) throws DataAccessException;

    public void deleteDepartementOrigine(Long id_departement) throws DataAccessException;

    public DepartementOrigine findDepartementOrigineById(long id_departement) throws DataAccessException;

    public List<DepartementOrigine> findDepartementOrigineAll() throws DataAccessException;
    
    public DepartementOrigine findDepartementOrigineByNom(String nom)throws DataAccessException;
    
    public List<DepartementOrigine> findDepartementOrigineByRegion(RegionOrigine regionOrigine)throws DataAccessException;
    
    
    
}
