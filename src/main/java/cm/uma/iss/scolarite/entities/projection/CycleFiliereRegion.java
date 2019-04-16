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
public class CycleFiliereRegion implements Serializable {

    private String cycle;
    private String filiere;
    private int ad;
    private int ce;
    private int en;
    private int es;
    private int lit;
    private int no;
    private int nw;
    private int ou;
    private int su;
    private int sw;
    private int totaRegion;
    private int etranger;

    public CycleFiliereRegion(String cycle, String filiere, int ad, int ce, int en, int es, int lit, int no, int nw, int ou, int su, int sw, int totaRegion, int etranger) {
        this.cycle = cycle;
        this.filiere = filiere;
        this.ad = ad;
        this.ce = ce;
        this.en = en;
        this.es = es;
        this.lit = lit;
        this.no = no;
        this.nw = nw;
        this.ou = ou;
        this.su = su;
        this.sw = sw;
        this.totaRegion = totaRegion;
        this.etranger = etranger;
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

    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public int getCe() {
        return ce;
    }

    public void setCe(int ce) {
        this.ce = ce;
    }

    public int getEn() {
        return en;
    }

    public void setEn(int en) {
        this.en = en;
    }

    public int getEs() {
        return es;
    }

    public void setEs(int es) {
        this.es = es;
    }

    public int getLit() {
        return lit;
    }

    public void setLt(int lit) {
        this.lit = lit;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNw() {
        return nw;
    }

    public void setNw(int nw) {
        this.nw = nw;
    }

    public int getOu() {
        return ou;
    }

    public void setOu(int ou) {
        this.ou = ou;
    }

    public int getSu() {
        return su;
    }

    public void setSu(int su) {
        this.su = su;
    }

    public int getSw() {
        return sw;
    }

    public void setSw(int sw) {
        this.sw = sw;
    }

    public int getEtranger() {
        return etranger;
    }

    public void setEtranger(int etranger) {
        this.etranger = etranger;
    }

    public int getTotaRegion() {
        return totaRegion;
    }

    public void setTotaRegion(int totaRegion) {
        this.totaRegion = totaRegion;
    }
    
    
}
