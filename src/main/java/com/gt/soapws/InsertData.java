/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gt.soapws;

import com.gt.soapws.Svc.PaisDeptoSvc;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Erick Sandoval (kerikeden29@gmail.com)
 */
@WebService(serviceName = "InsertData")
public class InsertData {
   
    @Inject
    private PaisDeptoSvc paisDeptoSvc;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "paisdeto")
    public String masterdetail(@WebParam(name = "namep") String namep,@WebParam(name = "codpais") String codpais,@WebParam(name = "departamento") String []departamento) {
        return paisDeptoSvc.Create(namep,codpais,departamento);
    }
}
