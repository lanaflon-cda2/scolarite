/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.ArrondissementOrigine;
import cm.uma.iss.scolarite.entities.DepartementOrigine;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IArrondissementOrigineService {

    public ArrondissementOrigine registerArrondissementOrigine(ArrondissementOrigine arrondissement) throws DataAccessException;

    public ArrondissementOrigine updateArrondissementOrigine(ArrondissementOrigine arrondissement) throws DataAccessException;

    public void deleteArrondissementOrigine(Long id_arrondissement) throws DataAccessException;

    public ArrondissementOrigine findArrondissementOrigineById(long id_arrondissement) throws DataAccessException;

    public List<ArrondissementOrigine> findArrondissementOrigineAll() throws DataAccessException;

    public ArrondissementOrigine findArrondissementOrigineByNom(String nom) throws DataAccessException;

    public List<ArrondissementOrigine> findArrondissementOrigneByDepartement(DepartementOrigine DepartementOrigine)
            throws DataAccessException;
}
