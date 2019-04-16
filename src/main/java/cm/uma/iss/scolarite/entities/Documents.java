/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.entities;

import com.itextpdf.text.Rectangle;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author ngnawen
 */
@Entity(name = "document")
public class Documents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_document;
    @Column(name = "type", unique = true)
    private String type;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "documents")
    private List<RetraitRetourDoc> retraitRetourDocs;
//    @ManyToMany( mappedBy = "documentList")
//    private List<Etudiant> etudiantList;
//    @ManyToMany(mappedBy = "documents",cascade = CascadeType.ALL)
//    private List<Etudiant> etudiants;

    public Documents() {
    }

    public List<RetraitRetourDoc> getRetraitRetourDocs() {
        return retraitRetourDocs;
    }

    public void setRetraitRetourDocs(List<RetraitRetourDoc> retraitRetourDocs) {
        this.retraitRetourDocs = retraitRetourDocs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Long getId_document() {
        return id_document;
    }

    public void setId_document(Long id_document) {
        this.id_document = id_document;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    

    @Override
    public String toString() {
        return "Document{" + "id_document=" + id_document + ", type=" + type + ", description=" + description + '}';
    }
}
