/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaa.simplebuild;

import entity.RoofMaterial;
import com.kaa.simplebuild.DataProviderJDBC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexandr
 */
public class DataProviderJDBCTest {
    
    public DataProviderJDBCTest() {
    }
    
    private static Logger log = LogManager.getLogger(DataProviderJDBCTest.class);
    DataProviderJDBC provider = new DataProviderJDBC();
    
   /* @Test
    public void TestCreateAndGetByIdRM() {
        boolean test =false;
        RoofMaterial obj = new RoofMaterial("111",111);
       provider.createRoofMaterial(obj);
        if(provider.getRoofMaterialById(obj.getId())!=null){
            test = true;
        } 
        log.info("create  " + provider.getRoofMaterialById(obj.getId()));
        assertTrue(test);
    }
    @Test
    public void TestDeleteRM() {
        boolean test =false;
        RoofMaterial obj = new RoofMaterial("111",111);
        provider.createRoofMaterial(obj);
        provider.delRoofMaterial(obj.getId());
        if(provider.getRoofMaterialById(obj.getId())==null){
            test = true;
        } 
        log.info("del" + provider.getRoofMaterialById(obj.getId()));
        assertTrue(test);
    }
    @Test
    public void TestUpdateRM() {
        boolean test =false;
        RoofMaterial obj1 = new RoofMaterial("111",111);
        RoofMaterial obj2 = new RoofMaterial(obj1.getId(),"222",222);
         provider.createRoofMaterial(obj1);
       provider.updateRoofMaterial(obj2);
        if(provider.getRoofMaterialById(obj1.getId()).getName()==obj2.getName()){
            test = true;
        } 
        log.info("update  "+ provider.getRoofMaterialById(obj1.getId()));
        provider.delRoofMaterial(obj1.getId());
        //log.info(test);
        assertTrue(test);
    }*/
    
}
