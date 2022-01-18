/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaa.simplebuild;

import com.kaa.simplebuild.DataProviderJDBC;
import com.kaa.simplebuild.HistoryContent.Status;
import entity.RoofMaterial;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Alexandr
 */
public class DataProviderJDBCTestt {
     private static Logger log = LogManager.getLogger(DataProviderJDBCTestt.class);
    IDataProvider provider;
    @Test
    public void TestCreateAndGetByIdRM() {
        //boolean test =false;
        RoofMaterial obj = new RoofMaterial(1L,"test",1.0,1);
       provider.createRoofMaterial(obj);
        
        log.info("create  " + provider.getRoofMaterialById(obj.getId()));
        assertTrue(provider.getRoofMaterialById(obj.getId())!=null);
    }
    @Test
    public void TestDeleteRM() {
        boolean test =false;
        double d = 1.0;
        RoofMaterial obj = new RoofMaterial("test",d,1);
        provider.createRoofMaterial(obj);
        provider.delRoofMaterial(obj.getId());
        if(provider.getRoofMaterialById(obj.getId())==null){
            test = true;
        } 
        log.info("del" + provider.getRoofMaterialById(obj.getId()));
        assertTrue(test);
    }
    
}
