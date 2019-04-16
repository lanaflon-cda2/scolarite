/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.Promotion;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IPromotionService {

    public Promotion registerPromotion(Promotion promotion) throws DataAccessException;

    public Promotion updatePromotion(Promotion promotion) throws DataAccessException;

    public void deletePromotion(Long id_promotion) throws DataAccessException;

    public Promotion findPromotionById(long id_promotion) throws DataAccessException;
    
    public Promotion findPromotionByIntitule(String intitule) throws DataAccessException;

    public List<Promotion> findPromotionAll() throws DataAccessException;
}
