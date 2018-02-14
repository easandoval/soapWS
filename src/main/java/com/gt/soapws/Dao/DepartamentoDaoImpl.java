/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gt.soapws.Dao;

import com.gt.soapws.model.Departamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
@Stateless
public class DepartamentoDaoImpl implements DepartamentoDao{
    
    @PersistenceContext(unitName = "com.gt_soapWs_war_WS")
    private EntityManager em;
    @Override
    public Departamento create(Departamento newd) {
        
        em.persist(newd);
        em.flush();
        return newd;
        
    }

}
