/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.Droit_universitaire;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IDroit_universitaireService {

    public Droit_universitaire registerDroit_universitaire(Droit_universitaire droit_universitaire) throws DataAccessException;

    public Droit_universitaire updateDroit_universitaire(Droit_universitaire droit_universitaire) throws DataAccessException;

    public void deleteDroit_universitaire(Long id_droit_universitaire)throws DataAccessException;

    public Droit_universitaire findDroit_UniversiataireById(long id_droit_universitaire) throws DataAccessException;

    public List<Droit_universitaire> findDroit_UniversiataireByAll() throws DataAccessException;

    public Droit_universitaire getDroitUniversitairetByNature(String nature_droit_universitaire) throws DataAccessException;
}
