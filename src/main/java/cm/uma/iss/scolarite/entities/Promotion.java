/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author ngnawen
 */
@Entity(name = "promotion")
public class Promotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_promotion;
    @Column(name = "intitule_promotion",unique = true)
    private String intitule_promotion;
    @OneToMany(mappedBy = "promotion")
    private List<Inscription> InscriptionList;
    
    //constructeurs
    public Promotion() {
    }

    public Promotion(String intitule_promotion) {
        this.intitule_promotion = intitule_promotion;
    }
    
    public Long getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(Long id_promotion) {
        this.id_promotion = id_promotion;
    }

    public String getIntitule_promotion() {
        return intitule_promotion;
    }

    public void setIntitule_promotion(String intitule_promotion) {
        this.intitule_promotion = intitule_promotion;
    }

    public List<Inscription> getInscriptionList() {
        return InscriptionList;
    }

    public void setInscriptionList(List<Inscription> InscriptionList) {
        this.InscriptionList = InscriptionList;
    }
    
    
    
}
