/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao;

import cm.uma.iss.scolarite.entities.Documents;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public interface IDocumentDao extends IDao<Documents, Long> {
    
     public Documents findDocumentByType(String type) throws DataAccessException;
     
     public List<Documents> findDocumentByTypeliste(Long l) throws DataAccessException;
    
}
