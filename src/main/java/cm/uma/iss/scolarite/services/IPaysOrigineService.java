/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.PaysOrigine;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IPaysOrigineService {

    public PaysOrigine registerPays(PaysOrigine pays) throws DataAccessException;

    public PaysOrigine updatePays(PaysOrigine pays) throws DataAccessException;

    void deletePays(Long id_pays)throws DataAccessException;

    public PaysOrigine findPaysById(long id_pays) throws DataAccessException;
    
    public List<PaysOrigine> findPaysAll() throws DataAccessException;
    
    public PaysOrigine getPaysByNom(String nom_pays) throws DataAccessException;
}