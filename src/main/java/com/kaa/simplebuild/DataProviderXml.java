
package com.kaa.simplebuild;

import utils.NullObjectException;
import utils.Constants;
import utils.ConfigurationUtil;
import com.google.gson.Gson;
import com.kaa.simplebuild.HistoryContent.Status;
import entity.BasementMaterial;
import entity.BasementTemplate;
import entity.BuildingTemplate;
import entity.MainPartMaterial;
import entity.MainPartTemplate;
import entity.RoofMaterial;
import entity.RoofTemplate;
import java.io.FileReader;
import java.io.FileWriter;
import static java.lang.Thread.currentThread;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 *
 * @author Alexandr
 */
public class DataProviderXml implements IDataProvider{
    private static final Logger logger = LogManager.getLogger(DataProviderXml.class);
   
    ////////////CREATE//////////////////////////////////////////////////////////

    
    @Override
    public Status createRoofMaterial(RoofMaterial obj) {
        Status status = Status.FAULT;
        List<RoofMaterial> data = read(RoofMaterial.class,Constants.ROOF_MATERIAL_XML);
        data.add(obj);
        if(getRoofMaterialById(obj.getId())==null){
        data.add(obj);
        status = save(data,Constants.ROOF_MATERIAL_XML,currentThread().getStackTrace()[1].getMethodName());
        }
        return status;
        
        
    }
    @Override
    public Status createMainPartMaterial(MainPartMaterial obj) {
        Status status = Status.FAULT;
        List<MainPartMaterial> data = read(MainPartMaterial.class,Constants.MAIN_PART_MATERIAL_XML);
        if(getMainPartMaterialById(obj.getId())==null){
        data.add(obj);
        status = save(data,Constants.MAIN_PART_MATERIAL_XML,currentThread().getStackTrace()[1].getMethodName());
        }
        return status;
        
    }
    @Override
    public Status createBasementMaterial(BasementMaterial obj) {
        Status status = Status.FAULT;
        List<BasementMaterial> data = read(BasementMaterial.class,Constants.BASEMENT_MATERIAL_XML);
        if(getBasementMaterialById(obj.getId())==null){
        data.add(obj);
        status = save(data,Constants.BASEMENT_MATERIAL_XML,currentThread().getStackTrace()[1].getMethodName());
        }
        return status;
    }
    @Override
    public Status createBasementTemplate(BasementTemplate obj) {
        Status status = Status.FAULT;
        List<BasementTemplate> data = read(BasementTemplate.class,Constants.BASEMENT_TEMPLATE_XML);
        if(getBasementTemplateById(obj.getId())==null){
        data.add(obj);
        status = save(data,Constants.BASEMENT_TEMPLATE_XML,currentThread().getStackTrace()[1].getMethodName());
        }
        return status;
    }
    @Override
    public Status createMainPartTemplate(MainPartTemplate obj) {
        Status status = Status.FAULT;
        List<MainPartTemplate> data = read(MainPartTemplate.class,Constants.MAIN_PART_TEMPLATE_XML);
        if(getMainPartTemplateById(obj.getId())==null){
        data.add(obj);
        status = save(data,Constants.MAIN_PART_TEMPLATE_XML,currentThread().getStackTrace()[1].getMethodName());
        }
        return status;
    }
    @Override
    public Status createRoofTemplate(RoofTemplate obj) {
        Status status = Status.FAULT;
        List<RoofTemplate> data = read(RoofTemplate.class,Constants.ROOF_TEMPLATE_XML);
        if(getRoofTemplateById(obj.getId())==null){
        data.add(obj);
        status = save(data,Constants.ROOF_TEMPLATE_XML,currentThread().getStackTrace()[1].getMethodName());
        }
        return status;
    }
    @Override
    public Status createBuildingTemplate(BuildingTemplate obj) {
        Status status = Status.FAULT;
        List<BuildingTemplate> data = read(BuildingTemplate.class,Constants.BUILDING_TEMPLATE_XML);
        if(getBuildingTemplateById(obj.getId())==null){
        data.add(obj);
        status = save(data,Constants.BUILDING_TEMPLATE_XML,currentThread().getStackTrace()[1].getMethodName());
        }
        return status;
    }
    ////////////////////GETBYID/////////////////////////////////////////////////

    
    @Override
    public RoofMaterial getRoofMaterialById(long id) {
        List<RoofMaterial> data = read(RoofMaterial.class,Constants.ROOF_MATERIAL_XML);
        Stream<RoofMaterial> streamData = data.stream();
        List<RoofMaterial> result = null;
        try {
            result = streamData.filter((obj -> obj.getId() == id))
                    .collect(Collectors.toList());
            if (result.isEmpty()) throw new NullObjectException("bean not found");
        } catch (NullObjectException e) {
            
            return null;
        }
        return result.get(0);
    }
    @Override
    public MainPartMaterial getMainPartMaterialById(long id) {
        List<MainPartMaterial> data = read(MainPartMaterial.class,Constants.MAIN_PART_MATERIAL_XML);
        Stream<MainPartMaterial> streamData = data.stream();
        List<MainPartMaterial> result = null;
        try {
            result = streamData.filter((obj -> obj.getId() == id))
                    .collect(Collectors.toList());
            if (result.isEmpty()) throw new NullObjectException("bean not found");
        } catch (NullObjectException e) {
            
            return null;
        }
        return result.get(0);
    }
    @Override
    public BasementMaterial getBasementMaterialById(long id) {
        List<BasementMaterial> data = read(BasementMaterial.class,Constants.BASEMENT_MATERIAL_XML);
        Stream<BasementMaterial> streamData = data.stream();
        List<BasementMaterial> result = null;
        try {
            result = streamData.filter((obj -> obj.getId() == id))
                    .collect(Collectors.toList());
            if (result.isEmpty()) throw new NullObjectException("bean not found");
        } catch (NullObjectException e) {
            
            return null;
        }
        return result.get(0);
    }
    @Override
    public BasementTemplate getBasementTemplateById(long id) {
        List<BasementTemplate> data = read(BasementTemplate.class,Constants.BASEMENT_TEMPLATE_XML);
        Stream<BasementTemplate> streamData = data.stream();
        List<BasementTemplate> result = null;
        try {
            result = streamData.filter((obj -> obj.getId() == id))
                    .collect(Collectors.toList());
            if (result.isEmpty()) throw new NullObjectException("bean not found");
        } catch (NullObjectException e) {
            
            return null;
        }
        return result.get(0);
    }
    @Override
    public MainPartTemplate getMainPartTemplateById(long id) {
        List<MainPartTemplate> data = read(MainPartTemplate.class,Constants.MAIN_PART_TEMPLATE_XML);
        Stream<MainPartTemplate> streamData = data.stream();
        List<MainPartTemplate> result = null;
        try {
            result = streamData.filter((obj -> obj.getId() == id))
                    .collect(Collectors.toList());
            if (result.isEmpty()) throw new NullObjectException("bean not found");
        } catch (NullObjectException e) {
            
            return null;
        }
        return result.get(0);
    }
    @Override
    public RoofTemplate getRoofTemplateById(long id) {
        List<RoofTemplate> data = read(RoofTemplate.class,Constants.ROOF_TEMPLATE_XML);
        Stream<RoofTemplate> streamData = data.stream();
        List<RoofTemplate> result = null;
        try {
            result = streamData.filter((obj -> obj.getId() == id))
                    .collect(Collectors.toList());
            if (result.isEmpty()) throw new NullObjectException("bean not found");
        } catch (NullObjectException e) {
            
            return null;
        }
        return result.get(0);
    }
    @Override
    public BuildingTemplate getBuildingTemplateById(long id) {
        List<BuildingTemplate> data = read(BuildingTemplate.class,Constants.BUILDING_TEMPLATE_XML);
        Stream<BuildingTemplate> streamData = data.stream();
        //logger.error(e);
        List<BuildingTemplate> result = null;
        try {
            result = streamData.filter((obj -> obj.getId() == id))
                    .collect(Collectors.toList());
            if (result.isEmpty()) throw new NullObjectException("bean not found");
        } catch (NullObjectException e) {
            logger.error(e);
            return null;
        }
        return result.get(0);
    }
    //////////////////////////GET///////////////////////////////////////////////

    
    @Override
    public List<RoofMaterial> getRoofMaterial () {
        List<RoofMaterial> data = read(RoofMaterial.class,Constants.ROOF_MATERIAL_XML);
         return data;
    }
    @Override
    public List<MainPartMaterial> getMainPartMaterial () {
        List<MainPartMaterial> data = read(MainPartMaterial.class,Constants.MAIN_PART_MATERIAL_XML);
         return data;
    }
    @Override
    public List<BasementMaterial> getBasementMaterial () {
        List<BasementMaterial> data = read(BasementMaterial.class,Constants.BASEMENT_MATERIAL_XML);
         return data;
    }
    @Override
    public List<BasementTemplate> getBasementTemplate () {
        List<BasementTemplate> data = read(BasementTemplate.class,Constants.BASEMENT_TEMPLATE_XML);
         return data;
    }
    @Override
     public List<MainPartTemplate> getMainPartTemplate () {
        List<MainPartTemplate> data = read(MainPartTemplate.class,Constants.MAIN_PART_TEMPLATE_XML);
         return data;
    }
    @Override
     public List<RoofTemplate> getRoofTemplate () {
        List<RoofTemplate> data = read(RoofTemplate.class,Constants.ROOF_TEMPLATE_XML);
         return data;
    }
    @Override
     public List<BuildingTemplate> getBuildingTemplate () {
        List<BuildingTemplate> data = read(BuildingTemplate.class,Constants.BUILDING_TEMPLATE_XML);
         return data;
    }
     ///////////////DELETE//////////////////////////////////////////////////////

    
    @Override
     public Status delRoofMaterial(long id) {
        //RoofMaterial beanToRemove = getRoofMaterialById(id);
        //if (beanToRemove == null) return false;
        List<RoofMaterial> list = read(RoofMaterial.class,Constants.ROOF_MATERIAL_XML);
        list.removeIf(bean -> bean.getId()==id);
        return save(list,Constants.ROOF_MATERIAL_XML,currentThread().getStackTrace()[1].getMethodName());
    }
    @Override
     public Status delMainPartMaterial(long id) {
        List<MainPartMaterial> list = read(MainPartMaterial.class,Constants.MAIN_PART_MATERIAL_XML);
        list.removeIf(bean -> bean.getId()==id);
        return save(list,Constants.MAIN_PART_MATERIAL_XML,currentThread().getStackTrace()[1].getMethodName());
        
    }
    @Override
     public Status delBasementMaterial(long id) {
        List<BasementMaterial> list = read(BasementMaterial.class,Constants.BASEMENT_MATERIAL_XML);
        list.removeIf(bean -> bean.getId()==id);
        return save(list,Constants.BASEMENT_MATERIAL_XML,currentThread().getStackTrace()[1].getMethodName());
        
    }
    @Override
     public Status delBasementTemplate(long id) {
        List<BasementTemplate> list = read(BasementTemplate.class,Constants.BASEMENT_TEMPLATE_XML);
        list.removeIf(bean -> bean.getId()==id);
        return save(list,Constants.BASEMENT_TEMPLATE_XML,currentThread().getStackTrace()[1].getMethodName());
        
    }
    @Override
     public Status delMainPartTemplate(long id) {
        List<MainPartTemplate> list = read(MainPartTemplate.class,Constants.MAIN_PART_TEMPLATE_XML);
        list.removeIf(bean -> bean.getId()==id);
        return save(list,Constants.MAIN_PART_TEMPLATE_XML,currentThread().getStackTrace()[1].getMethodName());
        
    }
    @Override
     public Status delRoofTemplate(long id) {
        List<RoofTemplate> list = read(RoofTemplate.class,Constants.ROOF_TEMPLATE_XML);
        list.removeIf(bean -> bean.getId()==id);
        return save(list,Constants.ROOF_TEMPLATE_XML,currentThread().getStackTrace()[1].getMethodName());
        
    }
    @Override
     public Status delBuildingTemplate(long id) {
        List<BuildingTemplate> list = read(BuildingTemplate.class,Constants.BUILDING_TEMPLATE_XML);
        list.removeIf(bean -> bean.getId()==id);
        return save(list,Constants.BUILDING_TEMPLATE_XML,currentThread().getStackTrace()[1].getMethodName());
    }
    ///////////UPDATE///////////////////////////////////////////////////////////

    
    @Override
   public Status updateRoofMaterial(RoofMaterial obj) {
        
       RoofMaterial en = getRoofMaterialById(obj.getId());
        
        if (en == null){
            logger.error("Entity is null");
            return Status.FAULT;
        }
        if(delRoofMaterial(obj.getId())==Status.SUCCESS)
        {
        return createRoofMaterial(obj);
        }
        return Status.FAULT;
        
    }
    @Override
   public Status updateMainPartMaterial(MainPartMaterial obj) {
        
       MainPartMaterial en = getMainPartMaterialById(obj.getId());
        
        if (en == null){
            logger.error("Entity is null");
            return Status.FAULT;
        }
        if(delMainPartMaterial(obj.getId())==Status.SUCCESS)
        {
        return createMainPartMaterial(obj);
        }
        return Status.FAULT;
        
    }
    @Override
   public Status updateBasementMaterial(BasementMaterial obj) {
        
       BasementMaterial en = getBasementMaterialById(obj.getId());
        
        if (en == null){
            logger.error("Entity is null");
            return Status.FAULT;
        }
        if(delBasementMaterial(obj.getId())==Status.SUCCESS)
        {
        return createBasementMaterial(obj);
        }
        return Status.FAULT;
        
    }
    @Override
   public Status updateBasementTemplate(BasementTemplate obj) {
        
       BasementTemplate en = getBasementTemplateById(obj.getId());
        
        if (en == null){
            logger.error("Entity is null");
            return Status.FAULT;
        }
        if(delBasementTemplate(obj.getId())==Status.SUCCESS)
        {
        return createBasementTemplate(obj);
        }
        return Status.FAULT;
        
    }
    @Override
   public Status updateMainPartTemplate(MainPartTemplate obj) {
        
       MainPartTemplate en = getMainPartTemplateById(obj.getId());
        
        if (en == null){
            logger.error("Entity is null");
            return Status.FAULT;
        }
        if(delMainPartTemplate(obj.getId())==Status.SUCCESS)
        {
        return createMainPartTemplate(obj);
        }
        return Status.FAULT;
        
    }
    @Override
   public Status updateRoofTemplate(RoofTemplate obj) {
        
       RoofTemplate en = getRoofTemplateById(obj.getId());
        
        if (en == null){
            logger.error("Entity is null");
            return Status.FAULT;
        }
        if(delRoofTemplate(obj.getId())==Status.SUCCESS)
        {
        return createRoofTemplate(obj);
        }
        return Status.FAULT;
        
    }
    @Override
   public Status updateBuildingTemplate(BuildingTemplate obj) {
        
       BuildingTemplate en = getBuildingTemplateById(obj.getId());
        
        if (en == null){
            logger.error("Entity is null");
            return Status.FAULT;
        }
        if( delBuildingTemplate(obj.getId())==Status.SUCCESS)
        {
        return createBuildingTemplate(obj);
        }
        return Status.FAULT;
        
    }
   //////////////UTILS//////////////////////////////////////////////////////////
   
     public <T> List<T> read( Class<T> c, String key) {
         
        try {
            String path =ConfigurationUtil.getConfigurationEntry(key);
            XmlWrap<T> container;
            try (FileReader fileReader = new FileReader(path)) {
                Serializer serializer = new Persister();
                container = serializer.read(XmlWrap.class, fileReader);
            }

            if (container.getList() == null) {
                return new ArrayList<>();
            } else {
                return container.getList();
            }
        } catch (Exception e) {
            logger.error(e);
           
            return new ArrayList<>();
        }
    }
     public <T>  Status save( List<T> list, String key, String method) {        
        Status status;
        try {
            String path =ConfigurationUtil.getConfigurationEntry(key);
            FileWriter fileWriter = new FileWriter(path);
            Serializer serializer = new Persister();
            serializer.write(new XmlWrap<T>(list), fileWriter);
            status = Status.SUCCESS;
        } catch (Exception e ) {            
            status = Status.FAULT;
            logger.error(e);
        }
        IDataProvider.saveHistory(getClass().getName(),method, status, new Gson().toJson(list));
        return status;
    }
}
