/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IPromotionDao;
import cm.uma.iss.scolarite.entities.Promotion;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;

/**
 *
 * @author ngnawen
 */
public class PromotionDaoImpl extends GenericDao<Promotion, Long>  implements IPromotionDao{

    @Override
    public Promotion findPromotionByIntitule(String intitule) throws DataAccessException {
        return (Promotion) getManager().createQuery("select promo from promotion promo where promo.intitule_promotion=:intitule")
                .setParameter("intitule", intitule).getSingleResult();
    }
    
}
