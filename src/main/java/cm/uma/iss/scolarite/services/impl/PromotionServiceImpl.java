/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.IPromotionDao;
import cm.uma.iss.scolarite.entities.Promotion;
import cm.uma.iss.scolarite.services.IPromotionService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author ngnawen
 */
@Transactional
public class PromotionServiceImpl implements IPromotionService {

    IPromotionDao promotionDao;

    public IPromotionDao getPromotionDao() {
        return promotionDao;
    }

    public void setPromotionDao(IPromotionDao promotionDao) {
        this.promotionDao = promotionDao;
    }

    @Override
    public Promotion registerPromotion(Promotion promotion) throws DataAccessException {
        try {
            return promotionDao.create(promotion);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public Promotion updatePromotion(Promotion promotion) throws DataAccessException {
        try {
            return promotionDao.update(promotion);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public Promotion findPromotionById(long id_promotion) throws DataAccessException {
        try {
            return promotionDao.findById(id_promotion);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public List<Promotion> findPromotionAll() throws DataAccessException {
        try {
            return promotionDao.findAll();
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public void deletePromotion(Long id_inscription) throws DataAccessException {
        try {
            Promotion promotion = promotionDao.findById(id_inscription);
            promotionDao.delete(null);
        } catch (Exception e) {
            
        }
    }

    @Override
    public Promotion findPromotionByIntitule(String intitule) throws DataAccessException {
        try {
            return promotionDao.findPromotionByIntitule(intitule);
        } catch (Exception e) {
            return null;
        }
    }
}
