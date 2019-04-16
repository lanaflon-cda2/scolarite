/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.Documents;
import cm.uma.iss.scolarite.services.IDocumentService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ngnawen
 */
@ManagedBean
@RequestScoped
public class DocumentBeans {

    @ManagedProperty(value = "#{IDocumentService}")
    private IDocumentService documentService;
    private List<Documents> listeDocument;
    private Documents document = new Documents();
    private Documents documentChoisi;
    // modèle
  private List<Documents > documents;

    public DocumentBeans() {
    }
 
    public Documents getDocumentChoisi() {
        return documentChoisi;
    }

    public void setDocumentChoisi(Documents documentChoisi) {
        this.documentChoisi = documentChoisi;
    }

    public IDocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(IDocumentService documentService) {
        this.documentService = documentService;
    }

    public List<Documents> getListeDocument() throws DataAccessException {
        listeDocument = documentService.findDocumentAll();
        return listeDocument;
    }

    public void setListeDocument(List<Documents> listeDocument) {
        this.listeDocument = listeDocument;
    }

    public Documents getDocument() {
        return document;
    }

    public void setDocument(Documents document) {
        this.document = document;
    }

    public void enregistrer() throws DataAccessException {
        System.out.println("" + document.getType());
        Documents doc = documentService.findDocumentByType(document.getType());
        if (doc == null) {
            documentService.registerDocument(document);
            FacesMessage msg = new FacesMessage("ENREGISTREMENT AVEC SUCCÈS");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("DOCUMENT EXISTANT");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void suprimerDocument() {
        try {
            // on enlève la personne choisie
            
            documentService.deleteDocument(documentChoisi.getId_document());
        } catch (DataAccessException ex) {
            Logger.getLogger(DocumentBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
    public String supprimer() {
        System.out.println("id_document " + document.getId_document());
        try {
            documentService.deleteDocument(document.getId_document());
        } catch (DataAccessException ex) {
            Logger.getLogger(DocumentBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public void onEdit(RowEditEvent event) { 
        try {
           Documents doc=(Documents) event.getObject();
            System.out.println("avant: "+doc);
            System.out.println("id_doc "+doc.getId_document());
            doc.setDescription(doc.getDescription());
            doc.setType(doc.getType());
            Documents d=documentService.findDocumentById(doc.getId_document());
            d.setType(doc.getType());
            d.setDescription(doc.getDescription());
            documentService.updateDocument(d);
            System.out.println("Apres : "+d);
            FacesMessage msg = new FacesMessage("MODIFICATION AVEC SUCCÈS");  
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (DataAccessException ex) {
            Logger.getLogger(DocumentBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
      
    public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("ANNULATION AVEC SUCCÈS");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
}
