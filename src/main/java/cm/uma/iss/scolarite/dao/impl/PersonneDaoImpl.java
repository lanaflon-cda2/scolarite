/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IPersonneDao;
import cm.uma.iss.scolarite.entities.Personne;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import java.util.List;

public class PersonneDaoImpl extends GenericDao<Personne, Long> implements IPersonneDao {

    @Override
    public List<Personne> findPersonneByNom(String nom) throws DataAccessException {
        return getManager().createQuery("select p from personne p where p.nom=:nom")
                .setParameter("nom", nom).getResultList();
    }

    @Override
    public List<Personne> findPersonneByPrenom(String prenom) throws DataAccessException {
         return getManager().createQuery("select p from personne p where p.prenom=:preom")
                .setParameter("prenom", prenom).getResultList();
}

    @Override
    public  List<Personne> findPersonneByEmail(String email) throws DataAccessException {
        return getManager().createQuery("select p from personne p where p.email=:email")
                .setParameter("email", email).getResultList();
    }

    @Override
    public  List<Personne> findPersonneByTelephone(String telephone) throws DataAccessException {
        return getManager().createQuery("select p from personne p where p.telephone=:telephone")
                .setParameter("telephone", telephone).getResultList();
    }
}
