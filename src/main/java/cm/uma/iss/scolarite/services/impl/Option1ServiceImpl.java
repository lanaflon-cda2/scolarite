/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.uma.iss.scolarite.services.impl;

import cm.uma.iss.scolarite.dao.IOption1Dao;
import cm.uma.iss.scolarite.entities.Option1;
import cm.uma.iss.scolarite.services.IOption1Service;
import com.douwe.generic.dao.DataAccessException;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author ngnawen
 */
@Transactional
public class Option1ServiceImpl implements IOption1Service {

    IOption1Dao option1Dao;

    public IOption1Dao getOption1Dao() {
        return option1Dao;
    }

    public void setOption1Dao(IOption1Dao option1Dao) {
        this.option1Dao = option1Dao;
    }

    @Override
    public Option1 registerOption1(Option1 option1) throws DataAccessException {
        try {
            return option1Dao.create(option1);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public Option1 updateOption1(Option1 option1) throws DataAccessException {
        try {
            return option1Dao.update(option1);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public Option1 findOption1ById(long id_option1) throws DataAccessException {
        try {
            return option1Dao.findById(id_option1);
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public List<Option1> findOption1All() throws DataAccessException {
        try {
            return option1Dao.findAll();
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public void deleteOption1(Long id_option1) throws DataAccessException {
        try {
            Option1 option1 = option1Dao.findById(id_option1);
            option1Dao.delete(option1);
        } catch (Exception e) {
            
        }
    }

    @Override
    public Option1 findOptionbyNom(String nom) throws DataAccessException {
        try {
            return option1Dao.findOptionbyNom(nom);
        } catch (Exception e) {
            
            return null;
        }
    }

}
