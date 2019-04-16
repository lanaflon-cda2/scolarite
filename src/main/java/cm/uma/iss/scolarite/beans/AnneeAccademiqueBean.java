/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.AnneeAccademique;
import cm.uma.iss.scolarite.services.IAnneeAccademiqueService;
import com.douwe.generic.dao.DataAccessException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AnneeAccademiqueBean {

    @ManagedProperty(value = "#{IAnneeAccademiqueService}")
    private IAnneeAccademiqueService anneeAccademiqueService;
    private AnneeAccademique anneeAccademique = new AnneeAccademique();
    private AnneeAccademique anneeAccademiqueChoisi;
    private List<AnneeAccademique> anneeAccList;
    private Date debutAnneeAcc = null;
    private Date finAnneeAcc = null;
    private String anneAcc = null;

    public AnneeAccademiqueBean() {
    }

    public String getAnneAcc() {
        return anneAcc;
    }

    public void setAnneAcc(String anneAcc) {
        this.anneAcc = anneAcc;
    }

    public Date getDebutAnneeAcc() {
        return debutAnneeAcc;
    }

    public void setDebutAnneeAcc(Date debutAnneeAcc) {
        this.debutAnneeAcc = debutAnneeAcc;
    }

    public Date getFinAnneeAcc() {
        return finAnneeAcc;
    }

    public void setFinAnneeAcc(Date finAnneeAcc) {
        this.finAnneeAcc = finAnneeAcc;
    }

    public IAnneeAccademiqueService getAnneeAccademiqueService() {
        return anneeAccademiqueService;
    }

    public void setAnneeAccademiqueService(IAnneeAccademiqueService anneeAccademiqueService) {
        this.anneeAccademiqueService = anneeAccademiqueService;
    }

    public AnneeAccademique getAnneeAccademiqueChoisi() {
        return anneeAccademiqueChoisi;
    }

    public void setAnneeAccademiqueChoisi(AnneeAccademique anneeAccademiqueChoisi) {
        this.anneeAccademiqueChoisi = anneeAccademiqueChoisi;
    }

    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public void setAnneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
    }

    public List<AnneeAccademique> getAnneeAccList() {
        try {
            anneeAccList = anneeAccademiqueService.findAnnee_accademiqueAll();
            return anneeAccList;
        } catch (Exception e) {
            return null;
        }
    }

    public void setAnneeAccList(List<AnneeAccademique> anneeAccList) {
        this.anneeAccList = anneeAccList;
    }

    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }
    public int compteur = 0;

    public String enregistrement() {
        try {
            String motif = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(motif);
            String dAnneeAcc = "" + simpleDateFormat.format(debutAnneeAcc);
            String fAnneeAcc = "" + simpleDateFormat.format(finAnneeAcc);
            System.out.println("debut année " + dAnneeAcc + " fin année " + fAnneeAcc);
            String annee1 = dAnneeAcc.substring(6);
            String annee2 = fAnneeAcc.substring(6);
            System.out.println("année1: " + annee1 + " année2: " + annee2);
            int a1 = Integer.parseInt(annee1);
            int a2 = Integer.parseInt(annee2);
            System.out.println("a1: " + a1 + " a2: " + a2);
            if ((!debutAnneeAcc.before(finAnneeAcc)) || (a1 == a2) ||(a1 >a2)||((a2-a1)!=1)) {
                FacesMessage msg = new FacesMessage("Année accadémique erronée");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
//                AnneeAccademique unDebutAnnee = anneeAccademiqueService.findAnneeByDebut(dAnneeAcc);
//                AnneeAccademique uneFinAnnee = anneeAccademiqueService.findAnneeByFin(fAnneeAcc);
//                AnneeAccademique uneAnnee = anneeAccademiqueService.findAnneeByDebutFin(dAnneeAcc, fAnneeAcc);
                String anneeAcca=annee1+"/"+annee2.trim();
                AnneeAccademique annee = anneeAccademiqueService.findAnneeByAnnee(anneeAcca);
                if ((annee == null)) {
                    anneeAccademique.setDebutAnnee(dAnneeAcc);
                    anneeAccademique.setFinAnnee(fAnneeAcc);
                    anneeAccademique.setAnnee(anneeAcca);
                    anneeAccademiqueService.registerAnnee_accademique(anneeAccademique);
                    FacesMessage msg = new FacesMessage("Enregistrement avec succès");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    FacesMessage msg = new FacesMessage("Année accadémique existante");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "annee";
    }
    
     public String supprimer() {
        System.out.println("id_anneeAccademique " + anneeAccademique.getId_anneeAccademique());
        try {
            anneeAccademiqueService.deleteAnnee_accademique(anneeAccademique.getId_anneeAccademique());
        } catch (DataAccessException ex) {
            Logger.getLogger(AnneeAccademiqueBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
}
