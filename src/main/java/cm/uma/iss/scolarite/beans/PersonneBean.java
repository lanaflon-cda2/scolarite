/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.Personne;
import cm.uma.iss.scolarite.services.IPersonneService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
public class PersonneBean {

    @ManagedProperty(value="#{IPersonneService}")
    private IPersonneService personneService;
    private Personne personne=new Personne();
    private List<Personne> personneList;
    
    public PersonneBean() {
    }

    public IPersonneService getPersonneService() {
        return personneService;
    }

    public void setPersonneService(IPersonneService personneService) {
        this.personneService = personneService;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public List<Personne> getPersonneList() {
        try {
            personneList=personneService.findPersonneAll();
            return personneList;
        } catch (Exception e) {
            return null;
        }
    }

    public void setPersonneList(List<Personne> personneList) {
        this.personneList = personneList;
    }
    
    public void enregistrer(){
        try {
            personneService.registerPersonne(personne);
        } catch (DataAccessException ex) {
            Logger.getLogger(PersonneBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
