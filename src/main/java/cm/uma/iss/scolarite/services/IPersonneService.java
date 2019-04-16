/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.Personne;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IPersonneService {

    public Personne registerPersonne(Personne personne) throws DataAccessException;

    public Personne updatePersonne(Personne personne) throws DataAccessException;

    public void deletePersonne(Long id_personne) throws DataAccessException;

    public void deletePersonne(Personne personne) throws DataAccessException;

    public Personne findPersonneById(long id_personne) throws DataAccessException;

    public List<Personne> findPersonneAll() throws DataAccessException;

    public List<Personne> findPersonneByNom(String nom) throws DataAccessException;

    public List<Personne> findPersonneByPrenom(String prenom) throws DataAccessException;

    public List<Personne> findPersonneByEmail(String email) throws DataAccessException;

    public List<Personne> findPersonneByTelephone(String telephone) throws DataAccessException;
}
