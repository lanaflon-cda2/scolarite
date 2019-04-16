/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.Filiere;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IFiliereService {

    public Filiere registerFiliere(Filiere filiere) throws DataAccessException;

    public Filiere updateFiliere(Filiere filiere) throws DataAccessException;

    public void deleteFiliere(Long id_filiere) throws DataAccessException;

    public Filiere findFiliereById(long id_filiere) throws DataAccessException;

    public List<Filiere> findFiliereAll() throws DataAccessException;

    public Filiere findFiliereByNom(String nom) throws DataAccessException;
    
    public Filiere findFiliereBySigle(String sigle) throws DataAccessException;
    
    public List<Filiere> findAllFiliere() throws DataAccessException;
    
}
