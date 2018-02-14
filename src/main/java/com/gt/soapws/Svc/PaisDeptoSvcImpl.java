/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gt.soapws.Svc;

import com.gt.soapws.Dao.DepartamentoDao;
import com.gt.soapws.Dao.PaisDao;
import com.gt.soapws.model.Departamento;
import com.gt.soapws.model.Pais;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * 
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
@RequestScoped
public class PaisDeptoSvcImpl implements PaisDeptoSvc{
    
    @Inject
    PaisDao paisDao;
    
    @Inject
    DepartamentoDao departamentoDao;

    @Override
    public String Create(String namep,String codigop,String[]departamentos) {
        if (!namep.equalsIgnoreCase("")) {
            Pais newp = new Pais();
            newp.setNombre(namep);
            newp.setCodigo(codigop);
            Pais tem = paisDao.create(newp);
            int cont=0;
            if (tem != null) {
                for(String namedepto: departamentos){
                    Departamento newdp = new Departamento();
                    newdp.setIdpais(new Pais(tem.getId()));
                    newdp.setNombre(namedepto);
                    departamentoDao.create(newdp);
                    cont++;
                }
                if(cont==departamentos.length){
                    return "El pais y sus departamentos se crearion con exito";
                }else{
                    return "Error al crear los departamentos";
                }

            } else {
                return "Error al crear al pais";
            }
        } else {
            return "Debe de ingresar un nombre de pais";
        }
        
    }

}
