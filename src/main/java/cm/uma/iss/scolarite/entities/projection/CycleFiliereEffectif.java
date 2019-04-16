
package cm.uma.iss.scolarite.entities.projection;

import java.io.Serializable;

/**
 *
 * @author ngnawen
 */
public class CycleFiliereEffectif implements Serializable {
   private String cycle;
   
   private String filiere;
   
   private int male;
   
   private int female;
   
   private int total;

    public CycleFiliereEffectif(String cycle, String filiere, int male, int female,int total) {
        this.cycle = cycle;
        this.filiere = filiere;
        this.male = male;
        this.female = female;
        this.total=total;
    }
    
    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        this.female = female;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
   
   
    
}
