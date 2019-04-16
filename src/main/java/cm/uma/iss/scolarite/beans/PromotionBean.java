/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.Promotion;
import cm.uma.iss.scolarite.services.IPromotionService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
public class PromotionBean {

    @ManagedProperty(value = "#{IPromotionService}")
    private IPromotionService promotionService;
    private Promotion promotion = new Promotion();
    private List<Promotion> promotionList;
    private Promotion promotionChoisi;

    //constructeurs
    public PromotionBean() {
    }

    //getters and setters
    public Promotion getPromotionChoisi() {
        return promotionChoisi;
    }

    public void setPromotionChoisi(Promotion promotionChoisi) {
        this.promotionChoisi = promotionChoisi;
    }

    public IPromotionService getPromotionService() {
        return promotionService;
    }

    public void setPromotionService(IPromotionService promotionService) {
        this.promotionService = promotionService;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public List<Promotion> getPromotionList() {
        try {
            promotionList = new ArrayList<Promotion>();
            promotionList.addAll(promotionService.findPromotionAll());
            return promotionList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void setPromotionList(List<Promotion> promotionList) {
        this.promotionList = promotionList;
    }
    public int compteur = 0;

    public void enregistrer() {
        String nom_promotion=promotion.getIntitule_promotion();
        try {
            List<Promotion> promotions = new ArrayList<Promotion>();
            promotions = promotionService.findPromotionAll();
            for (Iterator<Promotion> it = promotions.iterator(); it.hasNext();) {
                Promotion promotion1 = it.next();
                if (promotion1.getIntitule_promotion().equals(promotion.getIntitule_promotion())) {
                    compteur++;
                }
            }
            if (compteur != 0) {
                FacesMessage msg = new FacesMessage(nom_promotion + " \n Existe déjà");
                FacesContext.getCurrentInstance().addMessage(null, msg);

            } else {
                promotion.setIntitule_promotion(nom_promotion.toUpperCase());
                promotionService.registerPromotion(promotion);
                FacesMessage msg = new FacesMessage(nom_promotion + " \n Enregistrée avec succès");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
