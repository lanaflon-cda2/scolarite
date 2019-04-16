/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.IDocumentDao;
import cm.uma.iss.scolarite.entities.Documents;
import cm.uma.iss.scolarite.services.IDocumentService;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ngnawen
 */
@Transactional
public class DocumentService implements IDocumentService{
    
    IDocumentDao documentDao;

    public IDocumentDao getDocumentDao() {
        return documentDao;
    }

    public void setDocumentDao(IDocumentDao documentDao) {
        this.documentDao = documentDao;
    }
    
    @Override
    public Documents registerDocument(Documents document) throws DataAccessException {
        
        try {
            document.setType(document.getType().toUpperCase());
            return documentDao.create(document);
        } catch (Exception e) {
            return  null;
        }
    }

    @Override
    public Documents updateDocument(Documents document) throws DataAccessException {
        try {
            return documentDao.update(document);
        } catch (Exception e) {
            return  null;
        }
    }

    @Override
    public void deleteDocument(Long id_docuement) throws DataAccessException {
        try {
            Documents doc =documentDao.findById(id_docuement);
            documentDao.delete(doc);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    @Override
    public Documents findDocumentById(long id_document) throws DataAccessException {
        try {
            return documentDao.findById(id_document);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Documents> findDocumentAll() throws DataAccessException {
        try {
            return documentDao.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Documents findDocumentByType(String type) throws DataAccessException {
        try {
            return documentDao.findDocumentByType(type);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Documents> findDocumentByTypeliste(Long l) throws DataAccessException {
       try {
            return documentDao.findDocumentByTypeliste(l);
        } catch (Exception e) {
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }
    
}
