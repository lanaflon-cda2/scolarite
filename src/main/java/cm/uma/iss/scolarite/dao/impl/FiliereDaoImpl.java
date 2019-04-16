/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IFiliereDao;
import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.Filiere;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public class FiliereDaoImpl extends GenericDao<Filiere, Long> implements IFiliereDao {

    @Override
    public Filiere findFiliereByNom(String nom) throws DataAccessException {
        return (Filiere) getManager().createQuery("select f from filiere f where f.nom_filiere=:nom ORDER BY f.nom_filiere")
                .setParameter("nom", nom).getSingleResult();
    }

    @Override
    public Filiere findFiliereBySigle(String sigle) throws DataAccessException {
        return (Filiere) getManager().createQuery("select f from filiere f where f.sigle_filiere=:sigle ORDER BY f.nom_filiere")
                .setParameter("nsigle", sigle).getSingleResult(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Filiere> findAllFiliere() throws DataAccessException {
        return  getManager().createQuery("select f from filiere f  ORDER BY f.nom_filiere").getResultList(); //To change body of generated methods, choose Tools | Templates.
    }

}
