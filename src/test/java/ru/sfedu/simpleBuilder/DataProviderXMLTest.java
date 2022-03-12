package ru.sfedu.simpleBuilder;

import ru.sfedu.simpleBuilder.util.HistoryContent.Status;
import ru.sfedu.simpleBuilder.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Test;
import static org.junit.Assert.*;
import ru.sfedu.simpleBuilder.api.DataProviderXml;

/**
 *
 * @author Alexandr
 */
public class DataProviderXMLTest {
    
    public DataProviderXMLTest() {
    }
    
    private static Logger log = LogManager.getLogger(DataProviderXMLTest.class);
    DataProviderXml provider = new DataProviderXml();
    
    @Test
    public void TestCreateRoofMaterial() {
        //boolean test =false;
        RoofMaterial obj = new RoofMaterial("test",1.0,1);
       
        assertTrue(provider.createRoofMaterial(obj)!=Status.FAULT);
        
        log.info("create  " + provider.getRoofMaterialById(obj.getId()));
        provider.delRoofMaterial(obj.getId());
        
    }
    @Test
    public void TestDeleteRoofMaterial() {
        
        RoofMaterial obj = new RoofMaterial("test",1.0,1);
        provider.createRoofMaterial(obj);
        provider.delRoofMaterial(obj.getId());
        
        log.info("del" + provider.getRoofMaterialById(obj.getId()));
        assertTrue(provider.getRoofMaterialById(obj.getId())==null);
    }
    @Test
    public void TestUpdateRoofMaterial() {
       
        RoofMaterial obj1 = new RoofMaterial("test",1.0,1);
        RoofMaterial obj2 = new RoofMaterial(obj1.getId(),"test2",2.0,2);
        provider.createRoofMaterial(obj1);
        provider.updateRoofMaterial(obj2);
        
        log.info("update  "+ provider.getRoofMaterialById(obj1.getId()));
        
        //log.info(test);
        assertTrue(provider.getRoofMaterialById(obj1.getId()).getName().equals(obj2.getName()));
        provider.delRoofMaterial(obj1.getId());
    }
    @Test
    public void TestGetByIdRoofMaterial() {
       
       RoofMaterial obj1 = new RoofMaterial("test",1.0,1);
       provider.createRoofMaterial(obj1);
       assertTrue(provider.getRoofMaterialById(obj1.getId())!=null);
       provider.delRoofMaterial(obj1.getId());
    }
        
    
    @Test
    public void TestCreateMainPartMaterial() {
        //boolean test =false;
        MainPartMaterial obj = new MainPartMaterial("test",1.0,1.0);
       
        assertTrue(provider.createMainPartMaterial(obj)!=Status.FAULT);
        
        log.info("create  " + provider.getMainPartMaterialById(obj.getId()));
        provider.delMainPartMaterial(obj.getId());
        
    }
    @Test
    public void TestDeleteMainPartMaterial() {
        
        MainPartMaterial obj = new MainPartMaterial("test",1.0,1.0);
        provider.createMainPartMaterial(obj);
        provider.delMainPartMaterial(obj.getId());
        
        log.info("del" + provider.getMainPartMaterialById(obj.getId()));
        assertTrue(provider.getMainPartMaterialById(obj.getId())==null);
    }
    @Test
    public void TestUpdateMainPartMaterial() {
       
        MainPartMaterial obj1 = new MainPartMaterial("test",1.0,1.0);
        MainPartMaterial obj2 = new MainPartMaterial(obj1.getId(),"test2",2.0,2);
        provider.createMainPartMaterial(obj1);
        provider.updateMainPartMaterial(obj2);
        
        log.info("update  "+ provider.getMainPartMaterialById(obj1.getId()));
        
        //log.info(test);
        assertTrue(provider.getMainPartMaterialById(obj1.getId()).getName().equals(obj2.getName()));
        provider.delMainPartMaterial(obj1.getId());
    }
    @Test
    public void TestGetByIdMainPartMaterial() {
       
       MainPartMaterial obj1 = new MainPartMaterial("test",1.0,1);
       provider.createMainPartMaterial(obj1);
       assertTrue(provider.getMainPartMaterialById(obj1.getId())!=null);
       provider.delMainPartMaterial(obj1.getId());
    }
    
    @Test
    public void TestCreateBasementMaterial() {
        //boolean test =false;
        BasementMaterial obj = new BasementMaterial("test",1.0,1,1);
       
        assertTrue(provider.createBasementMaterial(obj)!=Status.FAULT);
        
        log.info("create  " + provider.getBasementMaterialById(obj.getId()));
        provider.delBasementMaterial(obj.getId());
        
    }
    @Test
    public void TestDeleteBasementMaterial() {
        
        BasementMaterial obj = new BasementMaterial("test",1.0,1,1);
        provider.createBasementMaterial(obj);
        provider.delBasementMaterial(obj.getId());
        
        log.info("del" + provider.getBasementMaterialById(obj.getId()));
        assertTrue(provider.getBasementMaterialById(obj.getId())==null);
    }
    @Test
    public void TestUpdateBasementMaterial() {
       
        BasementMaterial obj1 = new BasementMaterial("test",1.0,1,1);
        BasementMaterial obj2 = new BasementMaterial(obj1.getId(),"test2",2.0,2,2);
        provider.createBasementMaterial(obj1);
        provider.updateBasementMaterial(obj2);
        
        log.info("update  "+ provider.getBasementMaterialById(obj1.getId()));
        
        //log.info(test);
        assertTrue(provider.getBasementMaterialById(obj1.getId()).getName().equals(obj2.getName()));
        provider.delBasementMaterial(obj1.getId());
    }
    @Test
    public void TestGetByIdBasementMaterial() {
       
       BasementMaterial obj1 = new BasementMaterial("test",1.0,1,1);
       provider.createBasementMaterial(obj1);
       assertTrue(provider.getBasementMaterialById(obj1.getId())!=null);
       provider.delBasementMaterial(obj1.getId());
    }
    
     @Test
    public void TestCreateRoofTemplate() {
        //boolean test =false;
        RoofTemplate obj = new RoofTemplate("test",1.0,true,true);
       
        assertTrue(provider.createRoofTemplate(obj)!=Status.FAULT);
        
        log.info("create  " + provider.getRoofTemplateById(obj.getId()));
        provider.delRoofTemplate(obj.getId());
        
    }
    @Test
    public void TestDeleteRoofTemplate() {
        
        RoofTemplate obj = new RoofTemplate("test",1.0,true,true);
        provider.createRoofTemplate(obj);
        provider.delRoofTemplate(obj.getId());
        
        log.info("del" + provider.getRoofTemplateById(obj.getId()));
        assertTrue(provider.getRoofTemplateById(obj.getId())==null);
    }
    @Test
    public void TestUpdateRoofTemplate() {
       
        RoofTemplate obj1 = new RoofTemplate("test",1.0,true,true);
        RoofTemplate obj2 = new RoofTemplate(obj1.getId(),"test2",1.0,true,true);
        provider.createRoofTemplate(obj1);
        provider.updateRoofTemplate(obj2);
        
        log.info("update  "+ provider.getRoofTemplateById(obj1.getId()));
        
        //log.info(test);
        assertTrue(provider.getRoofTemplateById(obj1.getId()).getName().equals(obj2.getName()));
        provider.delRoofTemplate(obj1.getId());
    }
    @Test
    public void TestGetByIdRoofTemplate() {
       
       RoofTemplate obj1 = new RoofTemplate("test",1.0,true,true);
       provider.createRoofTemplate(obj1);
       assertTrue(provider.getRoofTemplateById(obj1.getId())!=null);
       provider.delRoofTemplate(obj1.getId());
    }
    
    @Test
    public void TestCreateMainPartTemplate() {
        //boolean test =false;
        MainPartTemplate obj = new MainPartTemplate("test",1.0,true,2);
       
        assertTrue(provider.createMainPartTemplate(obj)!=Status.FAULT);
        
        log.info("create  " + provider.getMainPartTemplateById(obj.getId()));
        provider.delMainPartTemplate(obj.getId());
        
    }
    @Test
    public void TestDeleteMainPartTemplate() {
        
        MainPartTemplate obj = new MainPartTemplate("test",1.0,true,1);
        provider.createMainPartTemplate(obj);
        provider.delMainPartTemplate(obj.getId());
        
        log.info("del" + provider.getMainPartTemplateById(obj.getId()));
        assertTrue(provider.getMainPartTemplateById(obj.getId())==null);
    }
    @Test
    public void TestUpdateMainPartTemplate() {
       
        MainPartTemplate obj1 = new MainPartTemplate("test",1.0,true,1);
        MainPartTemplate obj2 = new MainPartTemplate(obj1.getId(),"test2",2.2,true,2);
        provider.createMainPartTemplate(obj1);
        provider.updateMainPartTemplate(obj2);
        
        log.info("update  "+ provider.getMainPartTemplateById(obj1.getId()));
        
        //log.info(test);
        assertTrue(provider.getMainPartTemplateById(obj1.getId()).getName().equals(obj2.getName()));
        provider.delMainPartTemplate(obj1.getId());
    }
    @Test
    public void TestGetByIdMainPartTemplate() {
       
       MainPartTemplate obj1 = new MainPartTemplate("test",1.0,true,2);
       provider.createMainPartTemplate(obj1);
       assertTrue(provider.getMainPartTemplateById(obj1.getId())!=null);
       provider.delMainPartTemplate(obj1.getId());
    }
    
    @Test
    public void TestCreateBasementTemplate() {
        //boolean test =false;
        BasementTemplate obj = new BasementTemplate("test",1.0,true);
       
        assertTrue(provider.createBasementTemplate(obj)!=Status.FAULT);
        
        log.info("create  " + provider.getBasementTemplateById(obj.getId()));
        provider.delBasementTemplate(obj.getId());
        
    }
    @Test
    public void TestDeleteBasementTemplate() {
        
        BasementTemplate obj = new BasementTemplate("test",1.0,true);
        provider.createBasementTemplate(obj);
        provider.delBasementTemplate(obj.getId());
        
        log.info("del" + provider.getBasementTemplateById(obj.getId()));
        assertTrue(provider.getBasementTemplateById(obj.getId())==null);
    }
    @Test
    public void TestUpdateBasementTemplate() {
       
        BasementTemplate obj1 = new BasementTemplate("test",1.0,true);
        BasementTemplate obj2 = new BasementTemplate(obj1.getId(),"test2",2.2,true);
        provider.createBasementTemplate(obj1);
        provider.updateBasementTemplate(obj2);
        
        log.info("update  "+ provider.getBasementTemplateById(obj1.getId()));
        
        //log.info(test);
        assertTrue(provider.getBasementTemplateById(obj1.getId()).getName().equals(obj2.getName()));
        provider.delBasementTemplate(obj1.getId());
    }
    @Test
    public void TestGetByIdBasementTemplate() {
       
       BasementTemplate obj1 = new BasementTemplate("test",1.0,true);
       provider.createBasementTemplate(obj1);
       assertTrue(provider.getBasementTemplateById(obj1.getId())!=null);
       provider.delBasementTemplate(obj1.getId());
    }
    
    @Test
    public void TestCreateBuildingTemplate() {
        //boolean test =false;
        BuildingTemplate obj = new BuildingTemplate("test",2,1,1,1,1,1);
       
        assertTrue(provider.createBuildingTemplate(obj)!=Status.FAULT);
        
        log.info("create  " + provider.getBuildingTemplateById(obj.getId()));
        provider.delBuildingTemplate(obj.getId());
        
    }
    @Test
    public void TestDeleteBuildingTemplate() {
        
        BuildingTemplate obj = new BuildingTemplate("test",2,1,1,1,1,1);
        provider.createBuildingTemplate(obj);
        provider.delBuildingTemplate(obj.getId());
        
        log.info("del" + provider.getBuildingTemplateById(obj.getId()));
        assertTrue(provider.getBuildingTemplateById(obj.getId())==null);
    }
    @Test
    public void TestUpdateBuildingTemplate() {
       
        BuildingTemplate obj1 = new BuildingTemplate("test1",2,1,1,1,1,1);
        BuildingTemplate obj2 = new BuildingTemplate(obj1.getId(),"test2",2,1,1,1,1,1);
        provider.createBuildingTemplate(obj1);
        provider.updateBuildingTemplate(obj2);
        
        log.info("update  "+ provider.getBuildingTemplateById(obj1.getId()));
        
        //log.info(test);
        assertTrue(provider.getBuildingTemplateById(obj1.getId()).getName().equals(obj2.getName()));
        provider.delBuildingTemplate(obj1.getId());
    }
    @Test
    public void TestGetByIdBuildingTemplate() {
       
       BuildingTemplate obj1 = new BuildingTemplate("test",2,1,1,1,1,1);
       provider.createBuildingTemplate(obj1);
       assertTrue(provider.getBuildingTemplateById(obj1.getId())!=null);
       provider.delBuildingTemplate(obj1.getId());
    }
    
    
}
