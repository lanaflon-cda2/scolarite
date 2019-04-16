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
public class CycleFiliereAge implements Serializable{
    
    private String cycle;
    private String filiere;
    private int age1520;
    private int age2025;
    private int age2530;
    private int age3035;
    private int age35Plus;
    private int total;

    public CycleFiliereAge(String cycle, String filiere, int age1520, int age2025, int age2530, int age3035, int age35Plus, int total) {
        this.cycle = cycle;
        this.filiere = filiere;
        this.age1520 = age1520;
        this.age2025 = age2025;
        this.age2530 = age2530;
        this.age3035 = age3035;
        this.age35Plus = age35Plus;
        this.total = total;
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

    public int getAge1520() {
        return age1520;
    }

    public void setAge1520(int age1520) {
        this.age1520 = age1520;
    }

    public int getAge2025() {
        return age2025;
    }

    public void setAge2025(int age2025) {
        this.age2025 = age2025;
    }

    public int getAge2530() {
        return age2530;
    }

    public void setAge2530(int age2530) {
        this.age2530 = age2530;
    }

    public int getAge3035() {
        return age3035;
    }

    public void setAge3035(int age3035) {
        this.age3035 = age3035;
    }

    public int getAge35Plus() {
        return age35Plus;
    }

    public void setAge35Plus(int age35Plus) {
        this.age35Plus = age35Plus;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
    
}
