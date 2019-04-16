/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.NiveauFiliere;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface INiveauFiliereService {

    public NiveauFiliere registerNiveauFiliere(NiveauFiliere niveauFiliere) throws DataAccessException;

    public NiveauFiliere updateNiveauFiliere(NiveauFiliere niveauFiliere) throws DataAccessException;

    public void deleteNiveauFiliere(Long id_niveauFiliere) throws DataAccessException;

    public NiveauFiliere findNiveauFiliereById(long id_niveauFiliere) throws DataAccessException;

    public List<NiveauFiliere> findNiveauFiliereAll() throws DataAccessException;
}
