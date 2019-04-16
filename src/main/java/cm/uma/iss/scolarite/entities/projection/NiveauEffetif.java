/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.entities.projection;

import java.io.Serializable;

/**
 *
 * @author ngnawen
 */
public class NiveauEffetif implements Serializable{
    
    private String niveau;
    private int male;
    private int femele;
    private int total;

    public NiveauEffetif(String niveau, int male, int femele, int total) {
        this.niveau = niveau;
        this.male = male;
        this.femele = femele;
        this.total = total;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getFemele() {
        return femele;
    }

    public void setFemele(int femele) {
        this.femele = femele;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
}
