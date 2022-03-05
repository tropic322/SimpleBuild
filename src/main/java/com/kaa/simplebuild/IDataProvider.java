package com.kaa.simplebuild;


import utils.Constants;
import com.google.gson.Gson;
import com.kaa.simplebuild.HistoryContent.Status;
import com.mongodb.MongoCommandException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entity.BasementMaterial;
import entity.BasementTemplate;
import entity.BuildingTemplate;
import entity.MainPartMaterial;
import entity.MainPartTemplate;
import entity.RoofMaterial;
import entity.RoofTemplate;
import org.bson.Document;


public interface IDataProvider {
    ///////////CREATE///////////////////////////////////////////////////////////
    /**
     *Создание RoofMaterial 
     * 
     * @param obj - объект класс RoofMaterial
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status createRoofMaterial(RoofMaterial obj);
    /**
     *Создание MainPartMaterial 
     * 
     * @param obj - объект класс MainPartMaterial
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status createMainPartMaterial(MainPartMaterial obj);
    /**
     *Создание BasementMaterial 
     * 
     * @param obj - объект класс MainPartMaterial
     * @return Статус выполнения метода (SUCSESS или FAULT) 
     */
    public Status createBasementMaterial(BasementMaterial obj);
    /**
     *Создание RoofTemplate 
     * 
     * @param obj - объект класс RoofTemplate
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status createRoofTemplate(RoofTemplate obj);
    /**
     *Создание MainPartTemplate 
     * 
     * @param obj - объект класс MainPartTemplate
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status createMainPartTemplate(MainPartTemplate obj);
    /**
     *Создание BasementTemplate 
     * 
     * @param obj - объект класс BasementTemplate
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status createBasementTemplate(BasementTemplate obj);
    /**
     *Создание BuildingTemplate
     * 
     * @param obj - объект класс BuildingTemplate
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status createBuildingTemplate(BuildingTemplate obj);
    ////////////////////GETBYID/////////////////////////////////////////////////
    /**
     *Нахождение RoofMaterial по id 
     * 
     * @param id
     * @return объект класса RoofMaterial
     */
    public RoofMaterial getRoofMaterialById(long id); 
    /**
     *Нахождение MainPartMaterial по id 
     * 
     * @param id
     * @return объект класса MainPartMaterial
     */
    public MainPartMaterial getMainPartMaterialById(long id);
    /**
     *Нахождение BasementMaterial по id 
     * 
     * @param id
     * @return объект класса BasementMaterial
     */
    public BasementMaterial getBasementMaterialById(long id);
    /**
     *Нахождение RoofTemplate по id 
     * 
     * @param id
     * @return объект класса RoofTemplate
     */
    public RoofTemplate getRoofTemplateById(long id);
    /**
     *Нахождение MainPartTemplate по id 
     * 
     * @param id
     * @return объект класса MainPartTemplate
     */
    public MainPartTemplate getMainPartTemplateById(long id);
    /**
     *Нахождение BasementTemplate по id 
     * 
     * @param id
     * @return объект класса BasementTemplate
     */
    public BasementTemplate getBasementTemplateById(long id);
    /**
     *Нахождение BuildingTemplate по id 
     * 
     * @param id
     * @return объект класса BuildingTemplate
     */
    public BuildingTemplate getBuildingTemplateById(long id);
    /////////////////////GET////////////////////////////////////////////////////
    /**
     *получаем список объектов RoofMaterial из datasourse
     * 
     * @return List- RoofMaterial-
     */
    public List<RoofMaterial> getRoofMaterial ();
    /**
     *получаем список объектов MainPartMaterial из datasourse
     * 
     * @return List- MainPartMaterial-
     */
    public List<MainPartMaterial> getMainPartMaterial ();
    /**
     *получаем список объектов BasementMaterial из datasourse
     * 
     * @return List- BasementMaterial-
     */
    public List<BasementMaterial> getBasementMaterial ();
    /**
     *получаем список объектов RoofTemplate из datasourse
     * 
     * @return List- RoofTemplate-
     */
    public List<RoofTemplate> getRoofTemplate ();
    /**
     *получаем список объектов MainPartTemplate из datasourse
     * 
     * @return List- MainPartTemplate-
     */
    public List<MainPartTemplate> getMainPartTemplate ();
    /**
     *получаем список объектов BasementTemplate из datasourse
     * 
     * @return List- BasementTemplate-
     */
    public List<BasementTemplate> getBasementTemplate ();
    /**
     *получаем список объектов BuildingTemplate из datasourse
     * 
     * @return List- BuildingTemplate-
     */
    public List<BuildingTemplate> getBuildingTemplate ();
    ////////////UPDATE//////////////////////////////////////////////////////////
    /**
     *Обновление объекта RoofMaterial 
     * меняется тот объект из datasource,
     * у которого совпадает id с obj из параметров
     * 
     * @param obj RoofMaterial
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status updateRoofMaterial(RoofMaterial obj);
    /**
     *Обновление объекта MainPartMaterial 
     * меняется тот объект из datasource,
     * у которого совпадает id с obj из параметров
     * 
     * @param obj MainPartMaterial
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status updateMainPartMaterial(MainPartMaterial obj);
    /**
     *Обновление объекта BasementMaterial 
     * меняется тот объект из datasource,
     * у которого совпадает id с obj из параметров
     * 
     * @param obj BasementMaterial
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status updateBasementMaterial(BasementMaterial obj);
    /**
     *Обновление объекта RoofTemplate 
     * меняется тот объект из datasource,
     * у которого совпадает id с obj из параметров
     * 
     * @param obj RoofTemplate
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status updateRoofTemplate(RoofTemplate obj);
    /**
     *Обновление объекта MainPartTemplate 
     * меняется тот объект из datasource,
     * у которого совпадает id с obj из параметров
     * 
     * @param obj MainPartTemplate
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status updateMainPartTemplate(MainPartTemplate obj);
    /**
     *Обновление объекта BasementTemplate 
     * меняется тот объект из datasource,
     * у которого совпадает id с obj из параметров
     * 
     * @param obj BasementTemplate
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status updateBasementTemplate(BasementTemplate obj);
    /**
     *Обновление объекта BuildingTemplate 
     * меняется тот объект из datasource,
     * у которого совпадает id с obj из параметров
     * 
     * @param obj BuildingTemplate
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status updateBuildingTemplate(BuildingTemplate obj);
    ////////////DELETE//////////////////////////////////////////////////////////
    /**
     *удаление объекта  RoofMaterial из datasourse
     * 
     * @param id id объекта RoofMaterial для удаления
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status delRoofMaterial(long id);
    /**
     *удаление объекта  RoofMaterial из datasourse
     * 
     * @param id id объекта RoofMaterial для удаления
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status delBasementMaterial(long id);
    /**
     *удаление объекта  MainPartMaterial из datasourse
     * 
     * @param id id объекта MainPartMaterial для удаления
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status delMainPartMaterial(long id);
    /**
     *удаление объекта  MainPartTemplate из datasourse
     * 
     * @param id id объекта MainPartTemplate для удаления
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status delMainPartTemplate(long id);
    /**
     *удаление объекта  RoofTemplate из datasourse
     * 
     * @param id id объекта RoofTemplate для удаления
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status delRoofTemplate(long id);
    /**
     *удаление объекта  BasementTemplate из datasourse
     * 
     * @param id id объекта BasementTemplate для удаления
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status delBasementTemplate(long id);
    /**
     *удаление объекта  BuildingTemplate из datasourse
     * 
     * @param id id объекта BuildingTemplate для удаления
     * @return Статус выполнения метода (SUCSESS или FAULT)
     */
    public Status delBuildingTemplate(long id);
    
    /////////////////////UTILS//////////////////////////////////////////////////
    
    /**
     *метод для сохранения истории операций с объектом класса в MongoDB
     * 
     * @param className имя класса, в котором проводились изменения
     * @param methodName имя метода, в котором проводились изменения
     * @param status Статус операции (SUCSESS или FAULT)
     * @param json json представление объекта
     * @return
     */
    static boolean saveHistory(String className,String methodName, HistoryContent.Status status, String json){ ////
        try (
                MongoClient mongoClient = new MongoClient();){
            MongoDatabase database = mongoClient.getDatabase(Constants.DATABASE_NAME);
            try{
                database.createCollection(Constants.COLLECTION_NAME);
            } catch (MongoCommandException ignored) {}
            String date = new SimpleDateFormat(Constants.MONGO_DATE_PATTERN).format(new Date());
            HistoryContent historyContent = new HistoryContent(className,methodName, date, status, json);
            MongoCollection<Document> collection = database.getCollection(Constants.COLLECTION_NAME);
            collection.insertOne(Document.parse(new Gson().toJson(historyContent)));
        }
        return true;
    }
}
