/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services;

import cm.uma.iss.scolarite.entities.Cycle;
import cm.uma.iss.scolarite.entities.Documents;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IDocumentService {

    public Documents registerDocument(Documents document) throws DataAccessException;

    public Documents updateDocument(Documents document) throws DataAccessException;

    public void deleteDocument(Long id_docuement) throws DataAccessException;
    
     public Documents findDocumentById(long id_document) throws DataAccessException;

    public List<Documents> findDocumentAll() throws DataAccessException;
    
    public Documents findDocumentByType(String type) throws DataAccessException;
    
    public List<Documents> findDocumentByTypeliste(Long l) throws DataAccessException;
}
