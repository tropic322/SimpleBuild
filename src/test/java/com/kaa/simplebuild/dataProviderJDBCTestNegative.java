/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaa.simplebuild;

import entity.BasementMaterial;
import entity.BasementTemplate;
import entity.BuildingTemplate;
import entity.MainPartMaterial;
import entity.MainPartTemplate;
import entity.RoofMaterial;
import entity.RoofTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 * @author Alexandr
 */
public class DataProviderJDBCTestNegative {
    public DataProviderJDBCTestNegative() {
    }
    
    private static Logger log = LogManager.getLogger(DataProviderJDBCTestNegative.class);
    DataProviderJDBC provider = new DataProviderJDBC();
    
    @Test
    public void TestCreateRoofMaterial() {        
        RoofMaterial obj = new RoofMaterial("test",1.0,1);
        provider.createRoofMaterial(obj);
        assertFalse(provider.createRoofMaterial(obj)==HistoryContent.Status.SUCCESS);
        provider.delRoofMaterial(obj.getId());
    }
    @Test
    public void TestDeleteRoofMaterial() {
        RoofMaterial obj = new RoofMaterial("test",1.0,1);
        provider.createRoofMaterial(obj);
        provider.delRoofMaterial(obj.getId());
        log.info("del " + provider.getRoofMaterialById(obj.getId()));
        assertFalse(provider.delRoofMaterial(obj.getId())==HistoryContent.Status.FAULT);
    }
    @Test
    public void TestUpdateRoofMaterial() {
        RoofMaterial obj1 = new RoofMaterial("test",1.0,1);
        RoofMaterial obj2 = new RoofMaterial(obj1.getId(),"test2",2.0,2);
        log.info("update negative "+ provider.getRoofMaterialById(obj1.getId()));
        assertFalse(provider.updateRoofMaterial(obj2)==HistoryContent.Status.SUCCESS);
    }
    @Test
    public void TestGetByIdRoofMaterial() {       
       RoofMaterial obj1 = new RoofMaterial("test",1.0,1);
       provider.createRoofMaterial(obj1);
       provider.delRoofMaterial(obj1.getId());
       assertFalse(provider.getRoofMaterialById(obj1.getId())!=null);
       
    }
    
    
    
    @Test
    public void TestCreateMainPartMaterial() {
        MainPartMaterial obj = new MainPartMaterial("test",1.0,1);
        provider.createMainPartMaterial(obj);
        assertFalse(provider.createMainPartMaterial(obj)==HistoryContent.Status.SUCCESS);
        provider.delMainPartMaterial(obj.getId());
    }
    @Test
    public void TestDeleteMainPartMaterial() {
        MainPartMaterial obj = new MainPartMaterial("test",1.0,1);
        provider.createMainPartMaterial(obj);
        provider.delMainPartMaterial(obj.getId());
        log.info("del " + provider.getMainPartMaterialById(obj.getId()));
        assertFalse(provider.delMainPartMaterial(obj.getId())==HistoryContent.Status.FAULT);
    }
    @Test
    public void TestUpdateMainPartMaterial() {
       MainPartMaterial obj1 = new MainPartMaterial("test",1.0,1);
       MainPartMaterial obj2 = new MainPartMaterial(obj1.getId(),"test2",2.0,2);
       log.info("update negative "+ provider.getMainPartMaterialById(obj1.getId()));
       assertFalse(provider.updateMainPartMaterial(obj2)==HistoryContent.Status.SUCCESS);
    }
    @Test
    public void TestGetByIdMainPartMaterial() {
       MainPartMaterial obj1 = new MainPartMaterial("test",1.0,1);
       provider.createMainPartMaterial(obj1);
       provider.delMainPartMaterial(obj1.getId());
       assertFalse(provider.getMainPartMaterialById(obj1.getId())!=null);
    }
    
    
    @Test
    public void TestCreateBasementMaterial() {
       
       BasementMaterial obj = new BasementMaterial("test",1.0,1,1);
       provider.createBasementMaterial(obj);
       assertFalse(provider.createBasementMaterial(obj)==HistoryContent.Status.SUCCESS);
       provider.delBasementMaterial(obj.getId());
        
    }
    @Test
    public void TestDeleteBasementMaterial() {
        
        BasementMaterial obj = new BasementMaterial("test",1.0,1,1);
        provider.createBasementMaterial(obj);
        provider.delBasementMaterial(obj.getId());
        log.info("del " + provider.getBasementMaterialById(obj.getId()));
        assertFalse(provider.delBasementMaterial(obj.getId())==HistoryContent.Status.FAULT);
    }
    @Test
    public void TestUpdateBasementMaterial() {
        BasementMaterial obj1 = new BasementMaterial("test",1.0,1,1);
        BasementMaterial obj2 = new BasementMaterial(obj1.getId(),"test2",2.0,2,2);
        log.info("update negative "+ provider.getBasementMaterialById(obj1.getId()));
        assertFalse(provider.updateBasementMaterial(obj2)==HistoryContent.Status.SUCCESS);
    }
    @Test
    public void TestGetByIdBasementMaterial() {
       BasementMaterial obj1 = new BasementMaterial("test",1.0,1,1);
       provider.createBasementMaterial(obj1);
       provider.delBasementMaterial(obj1.getId());
       assertFalse(provider.getBasementMaterialById(obj1.getId())!=null);
    }
    
    
    
     @Test
    public void TestCreateRoofTemplate() {
       RoofTemplate obj = new RoofTemplate("test",1.0,1,true,true);
       provider.createRoofTemplate(obj);
       assertFalse(provider.createRoofTemplate(obj)==HistoryContent.Status.SUCCESS);
       provider.delRoofTemplate(obj.getId());
    }
    @Test
    public void TestDeleteRoofTemplate() {
        
        RoofTemplate obj = new RoofTemplate("test",1.0,1,true,true);
        provider.createRoofTemplate(obj);
        provider.delRoofTemplate(obj.getId());
        log.info("del " + provider.getRoofTemplateById(obj.getId()));
        assertFalse(provider.delRoofTemplate(obj.getId())==HistoryContent.Status.FAULT);
    }
    @Test
    public void TestUpdateRoofTemplate() {
       
        RoofTemplate obj1 = new RoofTemplate("test",1.0,1,true,true);
        RoofTemplate obj2 = new RoofTemplate(obj1.getId(),"test2",1.0,1,true,true);
        log.info("update negative "+ provider.getRoofTemplateById(obj1.getId()));
        assertFalse(provider.updateRoofTemplate(obj2)==HistoryContent.Status.SUCCESS);
    }
    @Test
    public void TestGetByIdRoofTemplate() {
       
       RoofTemplate obj1 = new RoofTemplate("test",1.0,1,true,true);
       provider.createRoofTemplate(obj1);
       provider.delRoofTemplate(obj1.getId());
       assertFalse(provider.getRoofTemplateById(obj1.getId())!=null);
    }
     
    
    
    @Test
    public void TestCreateMainPartTemplate() {       
       MainPartTemplate obj = new MainPartTemplate("test",1.0,1,true,2);
       provider.createMainPartTemplate(obj);
       assertFalse(provider.createMainPartTemplate(obj)==HistoryContent.Status.SUCCESS);
       provider.delMainPartTemplate(obj.getId());
        
    }
    @Test
    public void TestDeleteMainPartTemplate() {
        
        MainPartTemplate obj = new MainPartTemplate("test",1.0,1,true,1);
        provider.createMainPartTemplate(obj);
        provider.delMainPartTemplate(obj.getId());
        log.info("del " + provider.getMainPartTemplateById(obj.getId()));
        assertFalse(provider.delMainPartTemplate(obj.getId())==HistoryContent.Status.FAULT);
    }
    @Test
    public void TestUpdateMainPartTemplate() {
       
        MainPartTemplate obj1 = new MainPartTemplate("test",1.0,1,true,1);
        MainPartTemplate obj2 = new MainPartTemplate(obj1.getId(),"test2",2.2,2,true,2);
        log.info("update negative "+ provider.getMainPartTemplateById(obj1.getId()));
        assertFalse(provider.updateMainPartTemplate(obj2)==HistoryContent.Status.SUCCESS);
    }
    @Test
    public void TestGetByIdMainPartTemplate() {
       
       MainPartTemplate obj1 = new MainPartTemplate("test",1.0,1,true,2);
       provider.createMainPartTemplate(obj1);
       provider.delMainPartTemplate(obj1.getId());
       assertFalse(provider.getMainPartTemplateById(obj1.getId())!=null);
    }
    
    
    @Test
    public void TestCreateBasementTemplate() {
        
       BasementTemplate obj = new BasementTemplate("test",1.0,1,true);
       provider.createBasementTemplate(obj);
       assertFalse(provider.createBasementTemplate(obj)==HistoryContent.Status.SUCCESS);
       provider.delBasementTemplate(obj.getId());
        
    }
    @Test
    public void TestDeleteBasementTemplate() {
        
        BasementTemplate obj = new BasementTemplate("test",1.0,1,true);
        provider.createBasementTemplate(obj);
        provider.delBasementTemplate(obj.getId());
        log.info("del " + provider.getBasementTemplateById(obj.getId()));
        assertFalse(provider.delBasementTemplate(obj.getId())==HistoryContent.Status.FAULT);
    }
    @Test
    public void TestUpdateBasementTemplate() {
        BasementTemplate obj1 = new BasementTemplate("test",1.0,1,true);
        BasementTemplate obj2 = new BasementTemplate(obj1.getId(),"test2",2.2,2,true);
        log.info("update negative "+ provider.getBasementTemplateById(obj1.getId()));
        assertFalse(provider.updateBasementTemplate(obj2)==HistoryContent.Status.SUCCESS);
    }
    @Test
    public void TestGetByIdBasementTemplate() {
       BasementTemplate obj1 = new BasementTemplate("test",1.0,1,true);
       provider.createBasementTemplate(obj1);
       provider.delBasementTemplate(obj1.getId());
       assertFalse(provider.getBasementTemplateById(obj1.getId())!=null);
    }
    
    
    @Test
    public void TestCreateBuildingTemplate() {       
       BuildingTemplate obj = new BuildingTemplate("test",2,1,1);
       provider.createBuildingTemplate(obj);
       assertFalse(provider.createBuildingTemplate(obj)==HistoryContent.Status.SUCCESS);
       provider.delBuildingTemplate(obj.getId());
        
    }
    @Test
    public void TestDeleteBuildingTemplate() {
        
        BuildingTemplate obj = new BuildingTemplate("test",2,1,1);
        provider.createBuildingTemplate(obj);
        provider.delBuildingTemplate(obj.getId());
        log.info("del " + provider.getBuildingTemplateById(obj.getId()));
        assertFalse(provider.delBuildingTemplate(obj.getId())==HistoryContent.Status.FAULT);
    }
    @Test
    public void TestUpdateBuildingTemplate() {
       
        BuildingTemplate obj1 = new BuildingTemplate("test1",2,1,1);
        BuildingTemplate obj2 = new BuildingTemplate(obj1.getId(),"test2",2,1,1);
        log.info("update negative "+ provider.getBuildingTemplateById(obj1.getId()));
        assertFalse(provider.updateBuildingTemplate(obj2)==HistoryContent.Status.SUCCESS);
    }
    @Test
    public void TestGetByIdBuildingTemplate() {
       
       BuildingTemplate obj1 = new BuildingTemplate("test",2,1,1);
       provider.createBuildingTemplate(obj1);
       provider.delBuildingTemplate(obj1.getId());
       assertFalse(provider.getBuildingTemplateById(obj1.getId())!=null);
    }
}
