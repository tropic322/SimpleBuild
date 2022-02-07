package com.kaa.simplebuild;

import utils.NullObjectException;
import utils.Constants;
import utils.ConfigurationUtil;
import entity.BasementMaterial;
import entity.BasementTemplate;
import entity.BuildingTemplate;
import entity.RoofMaterial;
import entity.MainPartTemplate;
import entity.MainPartMaterial;
import entity.RoofTemplate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.kaa.simplebuild.HistoryContent.Status;
import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import com.opencsv.exceptions.*;
  
import java.io.*;  
import static java.lang.Thread.currentThread;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.stream.Collectors;  


public class DataProviderCsv implements IDataProvider{ 

    private static final Logger logger = LogManager.getLogger(DataProviderCsv.class);
    
    ///////////////CREATE///////////////////////////////////////////////////////
    @Override
    public Status createRoofMaterial(RoofMaterial obj) {
        Status status = Status.FAULT;
        List<Object> entitylist = new ArrayList<>();
        if(read(obj.getClass(),Constants.ROOF_MATERIAL_CSV).isPresent()){
            entitylist = read(obj.getClass(), Constants.ROOF_MATERIAL_CSV).get();
        }
        if(getRoofMaterialById(obj.getId())==null){
        entitylist.add(obj);
        status = save(entitylist, Constants.ROOF_MATERIAL_CSV,currentThread().getStackTrace()[1].getMethodName());
        
        }
         return status;
        

    }
    @Override
    public Status createMainPartMaterial(MainPartMaterial obj) {
        Status status = Status.FAULT;
        List<Object> entitylist = new ArrayList<>();
        if(read(obj.getClass(),Constants.MAIN_PART_MATERIAL_CSV).isPresent()){
            entitylist = read(obj.getClass(), Constants.MAIN_PART_MATERIAL_CSV).get();
        }
        if(getMainPartMaterialById(obj.getId())==null){
        entitylist.add(obj);
        status = save(entitylist, Constants.MAIN_PART_MATERIAL_CSV,currentThread().getStackTrace()[1].getMethodName());
        }
        return status;
        //IDataProvider.saveHistory(getClass().getName(), historyContentStatus, new Gson().toJson(obj));

    }
    @Override
    public Status createBasementMaterial(BasementMaterial obj) {
        Status status = Status.FAULT;
        List<Object> entitylist = new ArrayList<>();
        if(read(obj.getClass(),Constants.BASEMENT_MATERIAL_CSV).isPresent()){
            entitylist = read(obj.getClass(), Constants.BASEMENT_MATERIAL_CSV).get();
        }
        if(getBasementMaterialById(obj.getId())==null){
        entitylist.add(obj);
        status = save(entitylist, Constants.BASEMENT_MATERIAL_CSV,currentThread().getStackTrace()[1].getMethodName());
        }
        return status;
        

    }
    @Override
    public Status createRoofTemplate(RoofTemplate obj) {
        Status status = Status.FAULT;
        List<Object> entitylist = new ArrayList<>();
        if(read(obj.getClass(),Constants.ROOF_TEMPLATE_CSV).isPresent()){
            entitylist = read(obj.getClass(), Constants.ROOF_TEMPLATE_CSV).get();
        }
        if(getRoofTemplateById(obj.getId())==null){
        entitylist.add(obj);
        status = save(entitylist, Constants.ROOF_TEMPLATE_CSV,currentThread().getStackTrace()[1].getMethodName());
        }
        return status;
        

    }
    @Override
    public Status createMainPartTemplate(MainPartTemplate obj) {
        Status status = Status.FAULT;
        List<Object> entitylist = new ArrayList<>();
        if(read(obj.getClass(),Constants.MAIN_PART_TEMPLATE_CSV).isPresent()){
            entitylist = read(obj.getClass(), Constants.MAIN_PART_TEMPLATE_CSV).get();
        }
        if(getMainPartTemplateById(obj.getId())==null){
        entitylist.add(obj);
        status = save(entitylist, Constants.MAIN_PART_TEMPLATE_CSV,currentThread().getStackTrace()[1].getMethodName());
        }
        return status;
        

    }
    @Override
    public Status createBasementTemplate(BasementTemplate obj) {
        Status status = Status.FAULT;
        List<Object> entitylist = new ArrayList<>();
        if(read(obj.getClass(),Constants.BASEMENT_TEMPLATE_CSV).isPresent()){
            entitylist = read(obj.getClass(), Constants.BASEMENT_TEMPLATE_CSV).get();
        }
        if(getBasementTemplateById(obj.getId())==null){
        entitylist.add(obj);
        status = save(entitylist, Constants.BASEMENT_TEMPLATE_CSV,currentThread().getStackTrace()[1].getMethodName());
        }
        return status;
        

    }
    @Override
    public Status createBuildingTemplate(BuildingTemplate obj) {
        Status status = Status.FAULT;
        List<Object> entitylist = new ArrayList<>();
        if(read(obj.getClass(),Constants.BUILDING_TEMPLATE_CSV).isPresent()){
            entitylist = read(obj.getClass(), Constants.BUILDING_TEMPLATE_CSV).get();
        }
        if(getBuildingTemplateById(obj.getId())==null){
        entitylist.add(obj);
        status = save(entitylist, Constants.BUILDING_TEMPLATE_CSV,currentThread().getStackTrace()[1].getMethodName());
        }
        return status;
        

    }
    //////////////GETBYID///////////////////////////////////////////////////////
    @Override
    public RoofMaterial getRoofMaterialById(long id) {
        
        List<RoofMaterial> entities = getRoofMaterial();
        List<RoofMaterial> entity;
        try {
            entity = entities.stream().filter(obj -> obj.getId() == id).collect(Collectors.toList());
            
            if (entity.isEmpty()){                
                throw new NullObjectException("entity is null");
            }
        } catch (NullObjectException e){
            logger.error(e);
            return null;
        }

        return entity.get(0);
    }
    @Override
    public MainPartMaterial getMainPartMaterialById(long id) {
        
        List<MainPartMaterial> entities = getMainPartMaterial();
        List<MainPartMaterial> entity;
        try {
            entity = entities.stream().filter(obj -> obj.getId() == id).collect(Collectors.toList());
            
            if (entity.isEmpty()){                
                throw new NullObjectException("entity is null");
            }
        } catch (NullObjectException e){
            logger.error(e);
            return null;
        }

        return entity.get(0);
    }
    @Override
    public BasementMaterial getBasementMaterialById(long id) {
        
        List<BasementMaterial> entities = getBasementMaterial();
        List<BasementMaterial> entity;
        try {
            entity = entities.stream().filter(obj -> obj.getId() == id).collect(Collectors.toList());
            
            if (entity.isEmpty()){                
                throw new NullObjectException("entity is null");
            }
        } catch (NullObjectException e){
            logger.error(e);
            return null;
        }

        return entity.get(0);
    }
    @Override
    public RoofTemplate getRoofTemplateById(long id) {
        
        List<RoofTemplate> entities = getRoofTemplate();
        List<RoofTemplate> entity;
        try {
            entity = entities.stream().filter(obj -> obj.getId() == id).collect(Collectors.toList());
            
            if (entity.isEmpty()){                
                throw new NullObjectException("entity is null");
            }
        } catch (NullObjectException e){
            logger.error(e);
            return null;
        }

        return entity.get(0);
    }
    @Override
    public MainPartTemplate getMainPartTemplateById(long id) {
        
        List<MainPartTemplate> entities = getMainPartTemplate();
        List<MainPartTemplate> entity;
        try {
            entity = entities.stream().filter(obj -> obj.getId() == id).collect(Collectors.toList());
            
            if (entity.isEmpty()){                
                throw new NullObjectException("entity is null");
            }
        } catch (NullObjectException e){
            logger.error(e);
            return null;
        }

        return entity.get(0);
    }
    @Override
    public BasementTemplate getBasementTemplateById(long id) {
        
        List<BasementTemplate> entities = getBasementTemplate();
        List<BasementTemplate> entity;
        try {
            entity = entities.stream().filter(obj -> obj.getId() == id).collect(Collectors.toList());
            
            if (entity.isEmpty()){                
                throw new NullObjectException("entity is null");
            }
        } catch (NullObjectException e){
            logger.error(e);
            return null;
        }

        return entity.get(0);
    }
    @Override
    public BuildingTemplate getBuildingTemplateById(long id) {
        
        List<BuildingTemplate> entities = getBuildingTemplate();
        List<BuildingTemplate> entity;
        try {
            entity = entities.stream().filter(obj -> obj.getId() == id).collect(Collectors.toList());
            
            if (entity.isEmpty()){                
                throw new NullObjectException("entity is null");
            }
        } catch (NullObjectException e){
            logger.error(e);
            return null;
        }

        return entity.get(0);
    }
    //////////////////////////GET///////////////////////////////////////////////
    @Override
    public List<RoofMaterial> getRoofMaterial () {
        List<RoofMaterial> beans = null;
        try {
            beans = (List<RoofMaterial>) new CsvToBeanBuilder<RoofMaterial>(new FileReader(ConfigurationUtil.getConfigurationEntry(Constants.ROOF_MATERIAL_CSV)))
                    .withType(RoofMaterial.class).build().parse();
        } catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DataProviderCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return beans;
    }
    @Override
    public List<MainPartMaterial> getMainPartMaterial () {
        List<MainPartMaterial> beans = null;
        try {
            beans = (List<MainPartMaterial>) new CsvToBeanBuilder<MainPartMaterial>(new FileReader(ConfigurationUtil.getConfigurationEntry(Constants.MAIN_PART_MATERIAL_CSV)))
                    .withType(MainPartMaterial.class).build().parse();
        } catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DataProviderCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return beans;
    }
    @Override
    public List<BasementMaterial> getBasementMaterial () {
        List<BasementMaterial> beans = null;
        try {
            beans = (List<BasementMaterial>) new CsvToBeanBuilder<BasementMaterial>(new FileReader(ConfigurationUtil.getConfigurationEntry(Constants.BASEMENT_MATERIAL_CSV)))
                    .withType(BasementMaterial.class).build().parse();
        } catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DataProviderCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return beans;
    }
    @Override
    public List<RoofTemplate> getRoofTemplate () {
        List<RoofTemplate> beans = null;
        try {
            beans = (List<RoofTemplate>) new CsvToBeanBuilder<RoofTemplate>(new FileReader(ConfigurationUtil.getConfigurationEntry(Constants.ROOF_TEMPLATE_CSV)))
                    .withType(RoofTemplate.class).build().parse();
        } catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException ex) {
            logger.error(ex);
        }
        return beans;
    }
    @Override
    public List<MainPartTemplate> getMainPartTemplate () {
        List<MainPartTemplate> beans = null;
        try {
            beans = (List<MainPartTemplate>) new CsvToBeanBuilder<MainPartTemplate>(new FileReader(ConfigurationUtil.getConfigurationEntry(Constants.MAIN_PART_TEMPLATE_CSV)))
                    .withType(MainPartTemplate.class).build().parse();
        } catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException ex) {
            logger.error(ex);
        }
        return beans;
    }
    @Override
    public List<BasementTemplate> getBasementTemplate () {
        List<BasementTemplate> beans = null;
        try {
            beans = (List<BasementTemplate>) new CsvToBeanBuilder<BasementTemplate>(new FileReader(ConfigurationUtil.getConfigurationEntry(Constants.BASEMENT_TEMPLATE_CSV)))
                    .withType(BasementTemplate.class).build().parse();
        } catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException ex) {
            logger.error(ex);
        }
        return beans;
    }
    @Override
    public List<BuildingTemplate> getBuildingTemplate () {
        List<BuildingTemplate> beans = null;
        try {
            beans = (List<BuildingTemplate>) new CsvToBeanBuilder<BuildingTemplate>(new FileReader(ConfigurationUtil.getConfigurationEntry(Constants.BUILDING_TEMPLATE_CSV)))
                    .withType(BuildingTemplate.class).build().parse();
        } catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException ex) {
            logger.error(ex);
        }
        return beans;
    }
    ////////////UPDATE//////////////////////////////////////////////////////////
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
    ////////////////////////////////////DELETE/////////////////////////////////////     
    @Override
    public Status delRoofMaterial(long id)  {
       List<RoofMaterial> entities = getRoofMaterial();        
              
        entities.removeIf(entity -> (entity.getId() == id));        
        return save(entities,Constants.ROOF_MATERIAL_CSV,currentThread().getStackTrace()[1].getMethodName());
        
    }
    @Override
    public Status delBasementMaterial(long id)  {
      List<BasementMaterial> entities = getBasementMaterial();        
        //if(getBasementMaterialById(id)!=null){ 
        //BasementMaterial obj = getBasementMaterialById(id);    
        entities.removeIf(entity -> (entity.getId() == id)); 
         return save(entities,Constants.BASEMENT_MATERIAL_CSV,currentThread().getStackTrace()[1].getMethodName());
        
        //}
    }
    @Override
    public Status delMainPartMaterial(long id)  {
       List<MainPartMaterial> entities = getMainPartMaterial();        
              
        entities.removeIf(entity -> (entity.getId() == id));        
        return save(entities,Constants.MAIN_PART_MATERIAL_CSV,currentThread().getStackTrace()[1].getMethodName());
        
    }
    @Override
    public Status delMainPartTemplate(long id)  {
       List<MainPartTemplate> entities = getMainPartTemplate();        
              
        entities.removeIf(entity -> (entity.getId() == id));        
       return  save(entities,Constants.MAIN_PART_TEMPLATE_CSV,currentThread().getStackTrace()[1].getMethodName());
    }
    @Override
    public Status delRoofTemplate(long id)  {
       List<RoofTemplate> entities = getRoofTemplate();        
              
        entities.removeIf(entity -> (entity.getId() == id));        
        return save(entities,Constants.ROOF_TEMPLATE_CSV,currentThread().getStackTrace()[1].getMethodName());
    }
    @Override
    public Status delBasementTemplate(long id)  {
       List<BasementTemplate> entities = getBasementTemplate();        
              
        entities.removeIf(entity -> (entity.getId() == id));        
        return save(entities,Constants.BASEMENT_TEMPLATE_CSV,currentThread().getStackTrace()[1].getMethodName());
    }
    @Override
    public Status delBuildingTemplate(long id)  {
       List<BuildingTemplate> entities = getBuildingTemplate();        
              
        entities.removeIf(entity -> (entity.getId() == id));        
        return save(entities,Constants.BUILDING_TEMPLATE_CSV,currentThread().getStackTrace()[1].getMethodName());
    }
    //////////////////UTILS/////////////////////////////////////////////////////
    
    public <T> Status save(List<T> list, String key, String method){
        
        Status status;
        try {
            try (CSVWriter csvWriter = new CSVWriter(new FileWriter(ConfigurationUtil.getConfigurationEntry(key)))) {
                StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(csvWriter).build();
                beanToCsv.write(list);
            }
            status = Status.SUCCESS;
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            logger.error(e);
            status = Status.FAULT;
            
        }
        finally{
                    
        }
         
        IDataProvider.saveHistory(getClass().getName(),method, status, new Gson().toJson(list));
        return status;
    }  
    

    public <T> Optional<List<T>> read(Class<?> cls, String key){ 
        Optional<List<T>> optionalList = null; 
        try {
        List<T> list;
        File file;
        logger.info(ConfigurationUtil.getConfigurationEntry(key));
            file = new File(ConfigurationUtil.getConfigurationEntry(key)); //
        
               
                   
        if (file.length() != 0){
            try {
                list = new CsvToBeanBuilder<T>(new FileReader(ConfigurationUtil.getConfigurationEntry(key))).withType((Class<? extends T>) cls).build().parse();
                
                optionalList = Optional.of(list);
            } catch (FileNotFoundException e) {
                logger.error(e);
                optionalList = Optional.empty();
            }
        } else{
            logger.info("File empty");
            optionalList = Optional.empty();
        }
        
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DataProviderCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return optionalList;
    }

public DataProviderCsv() {
         
    }
}
