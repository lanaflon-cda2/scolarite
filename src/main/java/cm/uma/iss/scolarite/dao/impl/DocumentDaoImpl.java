/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.dao.impl;

import cm.uma.iss.scolarite.dao.IDocumentDao;
import cm.uma.iss.scolarite.entities.Documents;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import java.util.List;

/**
 *
 * @author ngnawen
 */
public class DocumentDaoImpl extends GenericDao<Documents, Long> implements IDocumentDao{

    @Override
    public Documents findDocumentByType(String type) throws DataAccessException {
        return (Documents) getManager().createQuery("select d from document d where d.type=:type")
                .setParameter("type", type).getSingleResult();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Documents> findDocumentByTypeliste(Long l) throws DataAccessException {
        return getManager().createQuery("select d from document d where d.id_document <>:l")
                .setParameter("l", l).getResultList(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
