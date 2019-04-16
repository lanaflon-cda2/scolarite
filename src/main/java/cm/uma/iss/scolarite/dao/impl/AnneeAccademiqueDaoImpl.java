/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IAnneeAccademiqueDao;
import cm.uma.iss.scolarite.entities.AnneeAccademique;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import javax.persistence.Query;

public class AnneeAccademiqueDaoImpl extends GenericDao<AnneeAccademique, Long> implements IAnneeAccademiqueDao {

    @Override
    public AnneeAccademique findAnneeByDebut(String debutAnnee) throws DataAccessException {
        return (AnneeAccademique) getManager().createQuery("select ac from anneeAccademique ac where ac.debutAnnee=:debutAnnee")
                .setParameter("debutAnnee", debutAnnee).getSingleResult();
    }

    @Override
    public AnneeAccademique findAnneeByFin(String finAnnee) throws DataAccessException {
        return (AnneeAccademique) getManager().createQuery("select ac from anneeAccademique ac where ac.finAnnee=:finAnnee")
                .setParameter("debutAnnee", finAnnee).getSingleResult();
    }

    @Override
    public AnneeAccademique findAnneeByDebutFin(String debutAnnee, String finAnnee) throws DataAccessException {
        Query query=getManager().createQuery("select ac from anneeAccademique ac where ac.debutAnnee=:debutAnnee AND ac.finAnnee=:finAnnee");
        query.setParameter("debutAnnee", debutAnnee);
        query.setParameter("finAnnee", finAnnee);
        return (AnneeAccademique) query.getSingleResult() ;
    }

    @Override
    public AnneeAccademique findAnneeByAnnee(String annee) throws DataAccessException {
       return (AnneeAccademique) getManager().createQuery("select ac from anneeAccademique ac where ac.annee=:annee")
                .setParameter("annee", annee).getSingleResult();
    }
}
