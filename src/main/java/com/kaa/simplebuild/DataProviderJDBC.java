
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
import java.io.IOException;
import static java.lang.Thread.currentThread;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Alexandr
 */
public class DataProviderJDBC implements IDataProvider{
    Connection connection = getConnection();
    public static final Logger logger = LogManager.getLogger(DataProviderJDBC.class);

    public DataProviderJDBC() {
        createTableRoofMaterial();
        createTableMainPartMaterial();
        createTableBasementMaterial();
        createTableRoofTemplate();
        createTablMainPartTemplate();
        createTableBasementTemplate();
        createTablBuildingTemplate();
        if(checkCountRoofMaterial()==0){
            insertTableRoofMaterial();
            insertTableMainPartMaterial();
            insertTableBasementMaterial();
            insertTableRoofTemplate();
            insertTableMainPartTemplate();
            insertTableBasementTemplate();
            insertTableBuildingTemplate();
          
        }
    }

    
    ////////////CREATE//////////////////////////////////////////////////////////
    @Override
    public Status createRoofMaterial(RoofMaterial obj) {
        Status status;
         try {
           
                PreparedStatement ps = connection.prepareStatement(
                        Constants.INSERT_ROOF_MATERIAL);
               
                    ps.setLong(Constants.ROOF_MATERIAL_ID_INDEX, obj.getId());
                    ps.setString(Constants.ROOF_MATERIAL_NAME_INDEX, obj.getName());
                    ps.setDouble(Constants.ROOF_MATERIAL_PRICE_INDEX, obj.getPrice());
                    ps.setInt(Constants.ROOF_MATERIAL_DURABILITY_YEARS_INDEX, obj.getDurabilityYears());
                    ps.executeUpdate();
                logger.info(ps);
                logger.info(connection);
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
         
         IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj)); 
         return status;
        
    }

    
    @Override
    public Status createMainPartMaterial(MainPartMaterial obj) {
        Status status;
         try {
            //check id
            
                
                PreparedStatement ps = connection.prepareStatement(
                        Constants.INSERT_MAIN_PART_MATERIAL);
               
                    ps.setLong(Constants.MAIN_PART_MATERIAL_ID_INDEX, obj.getId());
                    ps.setString(Constants.MAIN_PART_MATERIAL_NAME_INDEX, obj.getName());
                    ps.setDouble(Constants.MAIN_PART_MATERIAL_PRICE_INDEX, obj.getPrice());
                    ps.setDouble(Constants.MAIN_PART_MATERIAL_SOUND_TRANSMISSION_INDEX, obj.getSoundTransmission());
                    ps.executeUpdate();
                
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
             status = Status.FAULT;
            logger.error(e);
        }
         
         IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj)); 
        return status;
    }
    @Override
    public Status createBasementMaterial(BasementMaterial obj) {
         Status status;
         try {
            
                PreparedStatement ps = connection.prepareStatement(
                        Constants.INSERT_BASEMENT_MATERIAL);
               
                    ps.setLong(Constants.BASEMENT_MATERIAL_ID_INDEX, obj.getId());
                    ps.setString(Constants.BASEMENT_MATERIAL_NAME_INDEX, obj.getName());
                    ps.setDouble(Constants.BASEMENT_MATERIAL_PRICE_INDEX, obj.getPrice());
                    ps.setInt(Constants.BASEMENT_MATERIAL_FROST_RESISTANCE_INDEX, obj.getFrostResistance());
                    ps.setInt(Constants.BASEMENT_MATERIAL_WATERPROOF_INDEX, obj.getWaterproof());
                    ps.executeUpdate();
                
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
          
         IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj)); 
        return status;
    }
     @Override
    public Status createMainPartTemplate(MainPartTemplate obj) {
         Status status;
         try {
            //check id
            
                
                PreparedStatement ps = connection.prepareStatement(
                        Constants.INSERT_MAIN_PART_TEMPLATE);
               
                    ps.setLong(Constants.MAIN_PART_TEMPLATE_ID_INDEX, obj.getId());
                    ps.setString(Constants.MAIN_PART_TEMPLATE_NAME_INDEX, obj.getName());
                    ps.setDouble(Constants.MAIN_PART_TEMPLATE_PRICEMULTIPLIER_INDEX, obj.getPriceMultiplier());
                    ps.setLong(Constants.MAIN_PART_TEMPLATE_ID_MATERIAL_INDEX, obj.getIdMaterial());
                    ps.setBoolean(Constants.MAIN_PART_TEMPLATE_VERANDA_INDEX, obj.getVeranda());
                    ps.setInt(Constants.MAIN_PART_TEMPLATE_WINDOWS_INDEX, obj.getWindows());
                    ps.executeUpdate();
                
             status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
        IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
        return status;
    }
    @Override
    public Status createRoofTemplate(RoofTemplate obj) {
        Status status;
         try {
            
                PreparedStatement ps = connection.prepareStatement(
                        Constants.INSERT_ROOF_TEMPLATE);
               
                    ps.setLong(Constants.ROOF_TEMPLATE_ID_INDEX, obj.getId());
                    ps.setString(Constants.ROOF_TEMPLATE_NAME_INDEX, obj.getName());
                    ps.setDouble(Constants.ROOF_TEMPLATE_PRICEMULTIPLIER_INDEX, obj.getPriceMultiplier());
                    ps.setLong(Constants.ROOF_TEMPLATE_ID_MATERIAL_INDEX, obj.getIdMaterial());
                    ps.setBoolean(Constants.ROOF_TEMPLATE_INSULATION_INDEX, obj.getInsulation());
                    ps.setBoolean(Constants.ROOF_TEMPLATE_PIPE_INDEX, obj.getPipe());
                    ps.executeUpdate();
                
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
       IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
       return status;
    }
     @Override
     public Status createBasementTemplate(BasementTemplate obj) {
          Status status;
         try {
            
                PreparedStatement ps = connection.prepareStatement(
                        Constants.INSERT_BASEMENT_TEMPLATE);
               
                    ps.setLong(Constants.BASEMENT_TEMPLATE_ID_INDEX, obj.getId());
                    ps.setString(Constants.BASEMENT_TEMPLATE_NAME_INDEX, obj.getName());
                    ps.setDouble(Constants.BASEMENT_TEMPLATE_PRICEMULTIPLIER_INDEX, obj.getPriceMultiplier());
                    ps.setLong(Constants.BASEMENT_TEMPLATE_ID_MATERIAL_INDEX, obj.getIdMaterial());
                    ps.setBoolean(Constants.BASEMENT_TEMPLATE_CELLAR_INDEX, obj.getCellar());
                    ps.executeUpdate();
                
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
        IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
        return status;
    }
     @Override
    public Status createBuildingTemplate(BuildingTemplate obj) {
        Status status;
         try {
            
                PreparedStatement ps = connection.prepareStatement(
                        Constants.INSERT_BUILDING_TEMPLATE);
               
                    ps.setLong(Constants.BUILDING_TEMPLATE_ID_INDEX, obj.getId());
                    ps.setString(Constants.BUILDING_TEMPLATE_NAME_INDEX, obj.getName());
                    ps.setLong(Constants.BUILDING_TEMPLATE_ID_ROOF_TEMPLATE_INDEX, obj.getIdRoofTemplate());
                    ps.setLong(Constants.BUILDING_TEMPLATE_ID_MAIN_PART_TEMPLATE_INDEX, obj.getIdMainPartTemplate());
                    ps.setLong(Constants.BUILDING_TEMPLATE_ID_BASEMENT_TEMPLATE_INDEX, obj.getIdBasementTemplate());
                    ps.executeUpdate();
                
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
        IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
        return status;
    }
    
    ////////////////////GET/////////////////////////////////////////////////////
    @Override
    public List<RoofMaterial> getRoofMaterial(){
         List<RoofMaterial> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    Constants.SELECT_ROOF_MATERIAL);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                    RoofMaterial obj = new RoofMaterial();
                    obj.setId(result.getLong(Constants.ROOF_MATERIAL_ID));
                    obj.setName(result.getString(Constants.ROOF_MATERIAL_NAME));
                    obj.setPrice(result.getDouble(Constants.ROOF_MATERIAL_PRICE));
                    obj.setDurabilityYears(result.getInt(Constants.ROOF_MATERIAL_DURABILITY_YEARS));
                    list.add(obj);
            }
            result.close();
        } catch (SQLException e) {
            logger.error(e);
        }
    return list;
    }
    @Override
    public List<BasementMaterial> getBasementMaterial(){
         List<BasementMaterial> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    Constants.SELECT_BASEMENT_MATERIAL);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                    BasementMaterial obj = new BasementMaterial();
                    obj.setId(result.getLong(Constants.BASEMENT_MATERIAL_ID));
                    obj.setName(result.getString(Constants.BASEMENT_MATERIAL_NAME));
                    obj.setPrice(result.getDouble(Constants.BASEMENT_MATERIAL_PRICE));
                    obj.setFrostResistance(result.getInt(Constants.BASEMENT_MATERIAL_FROST_RESISTANCE));
                    obj.setWaterproof(result.getInt(Constants.BASEMENT_MATERIAL_WATERPROOF));
                    
                    list.add(obj);
            }
            result.close();
        } catch (SQLException e) {
            logger.error(e);
        }
    return list;
    }
    @Override
    public List<MainPartMaterial> getMainPartMaterial(){
         List<MainPartMaterial> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    Constants.SELECT_MAIN_PART_MATERIAL);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                    MainPartMaterial obj = new MainPartMaterial();
                    obj.setId(result.getLong(Constants.MAIN_PART_MATERIAL_ID));
                    obj.setName(result.getString(Constants.MAIN_PART_MATERIAL_NAME));
                    obj.setPrice(result.getDouble(Constants.MAIN_PART_MATERIAL_PRICE));
                    obj.setSoundTransmission(result.getDouble(Constants.MAIN_PART_MATERIAL_SOUND_TRANSMISSION));
                    list.add(obj);
            }
            result.close();
        } catch (SQLException e) {
            logger.error(e);
        }
    return list;
    }
    @Override
    public List<MainPartTemplate> getMainPartTemplate(){
         List<MainPartTemplate> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    Constants.SELECT_MAIN_PART_TEMPLATE);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                    MainPartTemplate obj = new MainPartTemplate();
                    obj.setId(result.getLong(Constants.MAIN_PART_TEMPLATE_ID));
                    obj.setName(result.getString(Constants.MAIN_PART_TEMPLATE_NAME));
                    obj.setPriceMultiplier(result.getDouble(Constants.MAIN_PART_TEMPLATE_PRICEMULTIPLIER));
                    obj.setIdMaterial(result.getLong(Constants.MAIN_PART_TEMPLATE_ID_MATERIAL_INDEX));
                    obj.setVeranda(result.getBoolean(Constants.MAIN_PART_TEMPLATE_VERANDA_INDEX));
                    obj.setWindows(result.getInt(Constants.MAIN_PART_TEMPLATE_WINDOWS_INDEX));
                    list.add(obj);
            }
            result.close();
        } catch (SQLException e) {
            logger.error(e);
        }
    return list;
    }
    @Override
    public List<BasementTemplate> getBasementTemplate(){
         List<BasementTemplate> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    Constants.SELECT_BASEMENT_TEMPLATE);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                    BasementTemplate obj = new BasementTemplate();
                    obj.setId(result.getLong(Constants.BASEMENT_TEMPLATE_ID));
                    obj.setName(result.getString(Constants.BASEMENT_TEMPLATE_NAME));
                    obj.setPriceMultiplier(result.getDouble(Constants.BASEMENT_TEMPLATE_PRICEMULTIPLIER));
                    obj.setIdMaterial(result.getLong(Constants.BASEMENT_TEMPLATE_ID_MATERIAL_INDEX));
                    obj.setCellar(result.getBoolean(Constants.BASEMENT_TEMPLATE_CELLAR_INDEX));
                    list.add(obj);
            }
            result.close();
        } catch (SQLException e) {
            logger.error(e);
        }
    return list;
    }
    @Override
    public List<RoofTemplate> getRoofTemplate(){
         List<RoofTemplate> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    Constants.SELECT_ROOF_TEMPLATE);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                    RoofTemplate obj = new RoofTemplate();
                    obj.setId(result.getLong(Constants.ROOF_TEMPLATE_ID));
                    obj.setName(result.getString(Constants.ROOF_TEMPLATE_NAME));
                    obj.setPriceMultiplier(result.getDouble(Constants.ROOF_TEMPLATE_PRICEMULTIPLIER));
                    obj.setIdMaterial(result.getLong(Constants.ROOF_TEMPLATE_ID_MATERIAL_INDEX));
                    obj.setInsulation(result.getBoolean(Constants.ROOF_TEMPLATE_INSULATION_INDEX));
                    obj.setPipe(result.getBoolean(Constants.ROOF_TEMPLATE_PIPE_INDEX));
                    list.add(obj);
            }
            result.close();
        } catch (SQLException e) {
            logger.error(e);
        }
    return list;
    }
    @Override
    public List<BuildingTemplate> getBuildingTemplate(){
         List<BuildingTemplate> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    Constants.SELECT_BUILDING_TEMPLATE);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                    BuildingTemplate obj = new BuildingTemplate();
                    obj.setId(result.getLong(Constants.BUILDING_TEMPLATE_ID));
                    obj.setName(result.getString(Constants.BUILDING_TEMPLATE_NAME));
                    obj.setIdRoofTemplate(result.getLong(Constants.BUILDING_TEMPLATE_ID_ROOF_TEMPLATE));
                    obj.setIdMainPartTemplate(result.getLong(Constants.BUILDING_TEMPLATE_ID_MAIN_PART_TEMPLATE));
                    obj.setIdBasementTemplate(result.getLong(Constants.BUILDING_TEMPLATE_ID_BASEMENT_TEMPLATE));
                    list.add(obj);
            }
            result.close();
        } catch (SQLException e) {
            logger.error(e);
        }
    return list;
    }
    ////////////////////////GETBYID/////////////////////////////////////////////
    @Override
    public BuildingTemplate getBuildingTemplateById(long id){
        List<BuildingTemplate> list = getBuildingTemplate();
        List<BuildingTemplate> entity; 
        try {
            entity = list.stream().filter(obj -> obj.getId() == id).collect(Collectors.toList());
            
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
    public RoofMaterial getRoofMaterialById(long id){
        List<RoofMaterial> list = getRoofMaterial();
        List<RoofMaterial> entity; 
        try {
            entity = list.stream().filter(obj -> obj.getId() == id).collect(Collectors.toList());
            logger.debug(entity);
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
    public BasementMaterial getBasementMaterialById(long id){
        List<BasementMaterial> list = getBasementMaterial();
        List<BasementMaterial> entity; 
        try {
            entity = list.stream().filter(obj -> obj.getId() == id).collect(Collectors.toList());
            
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
    public MainPartMaterial getMainPartMaterialById(long id){
        List<MainPartMaterial> list = getMainPartMaterial();
        List<MainPartMaterial> entity; 
        try {
            entity = list.stream().filter(obj -> obj.getId() == id).collect(Collectors.toList());
            
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
    public MainPartTemplate getMainPartTemplateById(long id){
        List<MainPartTemplate> list = getMainPartTemplate();
        List<MainPartTemplate> entity; 
        try {
            entity = list.stream().filter(obj -> obj.getId() == id).collect(Collectors.toList());
            
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
    public BasementTemplate getBasementTemplateById(long id){
        List<BasementTemplate> list = getBasementTemplate();
        List<BasementTemplate> entity; 
        try {
            entity = list.stream().filter(obj -> obj.getId() == id).collect(Collectors.toList());
            
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
    public RoofTemplate getRoofTemplateById(long id){
        List<RoofTemplate> list = getRoofTemplate();
        List<RoofTemplate> entity; 
        try {
            entity = list.stream().filter(obj -> obj.getId() == id).collect(Collectors.toList());
            
            if (entity.isEmpty()){                
                throw new NullObjectException("entity is null");
            }
        } catch (NullObjectException e){
            logger.error(e);
            return null;
        }

        return entity.get(0);
    }
    ////////////////////UPDATE//////////////////////////////////////////////////
    @Override
    public Status updateRoofMaterial (RoofMaterial obj){
        Status status;
        if(getRoofMaterialById(obj.getId())==null)
        {
            status=Status.FAULT;
            return status;
        }
        try {
            
            PreparedStatement ps = connection.prepareStatement(
                        Constants.UPDATE_ROOF_MATERIAL);
               
                    ps.setLong(Constants.ROOF_MATERIAL_ID_INDEX, obj.getId());
                    ps.setString(Constants.ROOF_MATERIAL_NAME_INDEX, obj.getName());
                    ps.setDouble(Constants.ROOF_MATERIAL_PRICE_INDEX, obj.getPrice());
                    ps.setInt(Constants.ROOF_MATERIAL_DURABILITY_YEARS_INDEX, obj.getDurabilityYears());
                    ps.setLong(Constants.ROOF_MATERIAL_ID_UPDATE_INDEX, obj.getId());
                    
                    ps.executeUpdate();
                            
                 status = Status.SUCCESS;
        } catch (SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
        IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
        return status;
    }
    @Override
    public Status updateBasementMaterial (BasementMaterial obj){
         Status status;
         if(getBasementMaterialById(obj.getId())==null)
        {
            status=Status.FAULT;
            return status;
        }
        try {
            PreparedStatement ps = connection.prepareStatement(
                        Constants.UPDATE_BASEMENT_MATERIAL);
               
                    ps.setLong(Constants.BASEMENT_MATERIAL_ID_INDEX, obj.getId());
                    ps.setString(Constants.BASEMENT_MATERIAL_NAME_INDEX, obj.getName());
                    ps.setDouble(Constants.BASEMENT_MATERIAL_PRICE_INDEX, obj.getPrice());
                    ps.setInt(Constants.BASEMENT_MATERIAL_FROST_RESISTANCE_INDEX, obj.getFrostResistance());
                    ps.setInt(Constants.BASEMENT_MATERIAL_WATERPROOF_INDEX, obj.getWaterproof());
                    ps.setLong(Constants.BASEMENT_MATERIAL_ID_UPDATE_INDEX, obj.getId());
                    
                    ps.executeUpdate();
                status = Status.SUCCESS;
            
        } catch (SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
        IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
        return status;
    }
    @Override
    public Status updateMainPartMaterial (MainPartMaterial obj){
        Status status;
        if(getMainPartMaterialById(obj.getId())==null)
        {
            status=Status.FAULT;
            return status;
        }
        try {
            PreparedStatement ps = connection.prepareStatement(
                        Constants.UPDATE_MAIN_PART_MATERIAL);
               
                    ps.setLong(Constants.MAIN_PART_MATERIAL_ID_INDEX, obj.getId());
                    ps.setString(Constants.MAIN_PART_MATERIAL_NAME_INDEX, obj.getName());
                    ps.setDouble(Constants.MAIN_PART_MATERIAL_PRICE_INDEX, obj.getPrice());
                    ps.setDouble(Constants.MAIN_PART_MATERIAL_SOUND_TRANSMISSION_INDEX, obj.getSoundTransmission());
                    ps.setLong(Constants.MAIN_PART_MATERIAL_ID_UPDATE_INDEX, obj.getId());
                    
                    ps.executeUpdate();
                
                status = Status.SUCCESS;
            
        } catch (SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
        IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
        return status;
    }
    @Override
    public Status updateMainPartTemplate (MainPartTemplate obj){
        Status status;
        if(getMainPartTemplateById(obj.getId())==null)
        {
            status=Status.FAULT;
            return status;
        }
        try {
            PreparedStatement ps = connection.prepareStatement(
                        Constants.UPDATE_MAIN_PART_TEMPLATE);
               
                    ps.setLong(Constants.MAIN_PART_TEMPLATE_ID_INDEX, obj.getId());
                    ps.setString(Constants.MAIN_PART_TEMPLATE_NAME_INDEX, obj.getName());
                    ps.setDouble(Constants.MAIN_PART_TEMPLATE_PRICEMULTIPLIER_INDEX, obj.getPriceMultiplier());
                    ps.setLong(Constants.MAIN_PART_TEMPLATE_ID_MATERIAL_INDEX, obj.getIdMaterial());
                    ps.setBoolean(Constants.MAIN_PART_TEMPLATE_VERANDA_INDEX, obj.getVeranda());
                    ps.setInt(Constants.MAIN_PART_TEMPLATE_WINDOWS_INDEX, obj.getWindows());
                    ps.setLong(Constants.MAIN_PART_TEMPLATE_ID_UPDATE_INDEX, obj.getId());
                    
                    ps.executeUpdate();
                status = Status.SUCCESS;
            
        } catch (SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
        IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
        return status;
    }
    @Override
    public Status updateRoofTemplate (RoofTemplate obj){
        Status status;
        if(getRoofTemplateById(obj.getId())==null)
        {
            status=Status.FAULT;
            return status;
        }
        try {
            PreparedStatement ps = connection.prepareStatement(
                        Constants.UPDATE_ROOF_TEMPLATE);
               
                    ps.setLong(Constants.ROOF_TEMPLATE_ID_INDEX, obj.getId());
                    ps.setString(Constants.ROOF_TEMPLATE_NAME_INDEX, obj.getName());
                    ps.setDouble(Constants.ROOF_TEMPLATE_PRICEMULTIPLIER_INDEX, obj.getPriceMultiplier());
                    ps.setLong(Constants.ROOF_TEMPLATE_ID_MATERIAL_INDEX, obj.getIdMaterial());
                    ps.setBoolean(Constants.ROOF_TEMPLATE_INSULATION_INDEX, obj.getInsulation());
                    ps.setBoolean(Constants.ROOF_TEMPLATE_PIPE_INDEX, obj.getPipe());
                    ps.setLong(Constants.ROOF_TEMPLATE_ID_UPDATE_INDEX, obj.getId());
                    
                    
                    ps.executeUpdate();
                
                status = Status.SUCCESS;
            
        } catch (SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
        IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
        return status;
    }
    @Override
    public Status updateBasementTemplate (BasementTemplate obj){
        Status status;
        if(getBasementTemplateById(obj.getId())==null)
        {
            status=Status.FAULT;
            return status;
        }
        try {
            PreparedStatement ps = connection.prepareStatement(
                        Constants.UPDATE_BASEMENT_TEMPLATE);
               
                    ps.setLong(Constants.BASEMENT_TEMPLATE_ID_INDEX, obj.getId());
                    ps.setString(Constants.BASEMENT_TEMPLATE_NAME_INDEX, obj.getName());
                    ps.setDouble(Constants.BASEMENT_TEMPLATE_PRICEMULTIPLIER_INDEX, obj.getPriceMultiplier());
                    ps.setLong(Constants.BASEMENT_TEMPLATE_ID_MATERIAL_INDEX, obj.getIdMaterial());
                    ps.setBoolean(Constants.BASEMENT_TEMPLATE_CELLAR_INDEX, obj.getCellar());
                    ps.setLong(Constants.BASEMENT_TEMPLATE_ID_UPDATE_INDEX, obj.getId());
                    
                    ps.executeUpdate();
                            
            status = Status.SUCCESS;
        } catch (SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
        IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
        return status;
    }
    @Override
    public Status updateBuildingTemplate (BuildingTemplate obj){
        Status status;
        if(getBuildingTemplateById(obj.getId())==null)
        {
            status=Status.FAULT;
            return status;
        }
        try {
            PreparedStatement ps = connection.prepareStatement(
                        Constants.UPDATE_BUILDING_TEMPLATE);
               
                    ps.setLong(Constants.BUILDING_TEMPLATE_ID_INDEX, obj.getId());
                    ps.setString(Constants.BUILDING_TEMPLATE_NAME_INDEX, obj.getName());
                    ps.setLong(Constants.BUILDING_TEMPLATE_ID_ROOF_TEMPLATE_INDEX, obj.getIdRoofTemplate());
                    ps.setLong(Constants.BUILDING_TEMPLATE_ID_MAIN_PART_TEMPLATE_INDEX, obj.getIdMainPartTemplate());
                    ps.setLong(Constants.BUILDING_TEMPLATE_ID_BASEMENT_TEMPLATE_INDEX, obj.getIdBasementTemplate());
                    ps.setLong(Constants.BUILDING_TEMPLATE_ID_UPDATE_INDEX, obj.getId());
                    
                    ps.executeUpdate();
                 
                status = Status.SUCCESS;
            
        } catch (SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
        IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
        return status;
    }
    ////////////DELETE//////////////////////////////////////////////////////////
    @Override
    public Status delRoofMaterial(long id){
        RoofMaterial obj = getRoofMaterialById(id);
        Status status;
         try {
            
                PreparedStatement ps = connection.prepareStatement(
                        Constants.DELETE_ROOF_MATERIAL);
               
                    ps.setLong(Constants.ROOF_MATERIAL_ID_INDEX, id);
                    
                    ps.executeUpdate();
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
         IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
         return status;
    }
    @Override
    public Status delBasementMaterial(long id){
        BasementMaterial obj = getBasementMaterialById(id);
        Status status;
         try {
            //check id
            
                
                PreparedStatement ps = connection.prepareStatement(
                        Constants.DELETE_BASEMENT_MATERIAL);
               
                    ps.setLong(Constants.BASEMENT_MATERIAL_ID_INDEX, id);
                    
                    ps.executeUpdate();
                
             status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
         IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
         return status;
    }
    @Override
    public Status delMainPartMaterial(long id){
        MainPartMaterial obj = getMainPartMaterialById(id);
        Status status;
         try {
            
                PreparedStatement ps = connection.prepareStatement(
                        Constants.DELETE_MAIN_PART_MATERIAL);
               
                    ps.setLong(Constants.MAIN_PART_MATERIAL_ID_INDEX, id);
                    
                    ps.executeUpdate();
                logger.debug(ps);
                logger.debug(connection);
                status = Status.SUCCESS;
             
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
         IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
         return status;
    }
    @Override
    public Status delMainPartTemplate(long id){
        MainPartTemplate obj = getMainPartTemplateById(id);
        Status status;
         try {
            //check id
            
                
                PreparedStatement ps = connection.prepareStatement(
                        Constants.DELETE_MAIN_PART_TEMPLATE);
               
                    ps.setLong(Constants.MAIN_PART_TEMPLATE_ID_INDEX, id);
                    
                    ps.executeUpdate();
                status = Status.SUCCESS;
             
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
         IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
         return status;
    }
    @Override
    public Status delRoofTemplate(long id){
       RoofTemplate obj = getRoofTemplateById(id);
        Status status;
         try {
            
                PreparedStatement ps = connection.prepareStatement(
                        Constants.DELETE_ROOF_TEMPLATE);
               
                    ps.setLong(Constants.ROOF_TEMPLATE_ID_INDEX, id);
                    
                    ps.executeUpdate();
                status = Status.SUCCESS;
             
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
         IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
         return status;
    }
    @Override
    public Status delBasementTemplate(long id){
        
        BasementTemplate obj = getBasementTemplateById(id);
        Status status;
         try {
            
                PreparedStatement ps = connection.prepareStatement(
                        Constants.DELETE_BASEMENT_TEMPLATE);
               
                    ps.setLong(Constants.BASEMENT_TEMPLATE_ID_INDEX, id);
                    
                    ps.executeUpdate();
                status = Status.SUCCESS;
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
         IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
         return status;
    }
    @Override
    public Status delBuildingTemplate(long id){
        
        BasementTemplate obj = getBasementTemplateById(id);
        Status status;
         try {
            
                PreparedStatement ps = connection.prepareStatement(
                        Constants.DELETE_BUILDING_TEMPLATE);
               
                    ps.setLong(Constants.BUILDING_TEMPLATE_ID_INDEX, id);
                    
                    ps.executeUpdate();
                logger.debug(ps);
                
                status = Status.SUCCESS;
             
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
         IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj));
         return status;
    }
    ///////////////////UTILS////////////////////////////////////////////////////
    /*private <T> Status execute(T list, String sql, String method) {
        Status status;
        try {
            if (list == null) {
                list = (T) "";
            }
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.executeUpdate();
            getConnection().close();
            status = Status.SUCCESS;
        } catch (SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
        IDataProvider.saveHistory(getClass().getName(),method, status, new Gson().toJson(list));        
        return status;
    }*/
     private Connection getConnection() {
         
        try {
            Class.forName(ConfigurationUtil.getConfigurationEntry(Constants.DB_DRIVER));
            connection = DriverManager.getConnection(
                    ConfigurationUtil.getConfigurationEntry(Constants.DB_CONNECT),
                    ConfigurationUtil.getConfigurationEntry(Constants.DB_USER),
                    ConfigurationUtil.getConfigurationEntry(Constants.DB_PASS)
            );
            return connection;
        } catch (SQLException | IOException e) {
            logger.error(e);
            return null;
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataProviderJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
     
    
    public final Status createTableRoofMaterial() {
        Status status;
         try {
           
                PreparedStatement ps = connection.prepareStatement(
                        Constants.CREATE_TABLE_ROOF_M);
               
                    
                    ps.executeUpdate();
                logger.info(ps);
                logger.info(connection);
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
         
         
         return status;
        
    }
    public final Status createTableMainPartMaterial() {
        Status status;
         try {
           
                PreparedStatement ps = connection.prepareStatement(
                        Constants.CREATE_TABLE_MAIN_PART_M);
               
                    
                    ps.executeUpdate();
                logger.info(ps);
                logger.info(connection);
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
         
         
         return status;
        
    }
   public final Status createTableBasementMaterial() {
        Status status;
         try {
           
                PreparedStatement ps = connection.prepareStatement(
                        Constants.CREATE_TABLE_BASEMENT_M);
               
                    
                    ps.executeUpdate();
                logger.info(ps);
                logger.info(connection);
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
         
         
         return status;
        
    }
    public final Status createTableRoofTemplate() {
        Status status;
         try {
           
                PreparedStatement ps = connection.prepareStatement(
                        Constants.CREATE_TABLE_ROOF_T);
               
                    
                    ps.executeUpdate();
                logger.info(ps);
                logger.info(connection);
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
         
         
         return status;
        
    }
    public final Status createTableBasementTemplate() {
        Status status;
         try {
           
                PreparedStatement ps = connection.prepareStatement(
                        Constants.CREATE_TABLE_BASEMENT_T);
               
                    
                    ps.executeUpdate();
                logger.info(ps);
                logger.info(connection);
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
         
         
         return status;
        
    }
    public final Status createTablMainPartTemplate() {
        Status status;
         try {
           
                PreparedStatement ps = connection.prepareStatement(
                        Constants.CREATE_TABLE_MAIN_PART_T);
               
                    
                    ps.executeUpdate();
                logger.info(ps);
                logger.info(connection);
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
         
         
         return status;
        
    }
    public final Status createTablBuildingTemplate() {
        Status status;
         try {
           
                PreparedStatement ps = connection.prepareStatement(
                        Constants.CREATE_TABLE_BUILDING_T);
               
                    
                    ps.executeUpdate();
                logger.info(ps);
                logger.info(connection);
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
            status = Status.FAULT;
            logger.error(e);
        }
         
         
         return status;
        
    }
    public final int checkCountRoofMaterial(){
        int count=0;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    Constants.COUNT_ROOF_MATERIAL);
            ResultSet result = ps.executeQuery();
            result.next();
            count =result.getInt(Constants.ROOF_MATERIAL_COUNT_COLUMN);
            result.close();
        } catch (SQLException e) {
            logger.error(e);
        }
        return count;
        
    }
    public Status insertTableRoofMaterial() {
        Status status;
         try {
            
                PreparedStatement ps = connection.prepareStatement(
                        Constants.INSERT_TABLE_ROOF_M);
                    ps.executeUpdate();
                
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
             status = Status.FAULT;
            logger.error(e);
        }
         
        // IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj)); 
        return status;
    }
    public Status insertTableMainPartMaterial() {
        Status status;
         try {
            
                PreparedStatement ps = connection.prepareStatement(
                        Constants.INSERT_TABLE_MAIN_PART_M);
                    ps.executeUpdate();
                
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
             status = Status.FAULT;
            logger.error(e);
        }
         
        // IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj)); 
        return status;
    }
    public Status insertTableBasementMaterial() {
        Status status;
         try {
            
                PreparedStatement ps = connection.prepareStatement(
                        Constants.INSERT_TABLE_BASEMENT_M);
                    ps.executeUpdate();
                
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
             status = Status.FAULT;
            logger.error(e);
        }
         
        // IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj)); 
        return status;
    }
    public Status insertTableRoofTemplate() {
        Status status;
         try {
            
                PreparedStatement ps = connection.prepareStatement(
                        Constants.INSERT_TABLE_ROOF_T);
                    ps.executeUpdate();
                
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
             status = Status.FAULT;
            logger.error(e);
        }
         
        // IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj)); 
        return status;
    }
    public Status insertTableMainPartTemplate() {
        Status status;
         try {
            
                PreparedStatement ps = connection.prepareStatement(
                        Constants.INSERT_TABLE_MAIN_PART_T);
                    ps.executeUpdate();
                
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
             status = Status.FAULT;
            logger.error(e);
        }
         
        // IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj)); 
        return status;
    }
    public Status insertTableBasementTemplate() {
        Status status;
         try {
            
                PreparedStatement ps = connection.prepareStatement(
                        Constants.INSERT_TABLE_BASEMENT_T);
                    ps.executeUpdate();
                
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
             status = Status.FAULT;
            logger.error(e);
        }
         
        // IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj)); 
        return status;
    }
    public Status insertTableBuildingTemplate() {
        Status status;
         try {
            
                PreparedStatement ps = connection.prepareStatement(
                        Constants.INSERT_TABLE_BUILDING_T);
                    ps.executeUpdate();
                
                status = Status.SUCCESS;
            
        } catch (NullPointerException | SQLException e) {
             status = Status.FAULT;
            logger.error(e);
        }
         
        // IDataProvider.saveHistory(getClass().getName(),currentThread().getStackTrace()[1].getMethodName(), status, new Gson().toJson(obj)); 
        return status;
    }
    //Status createRoofMaterial(RoofMaterial obj) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    

    


    

    
    
}
