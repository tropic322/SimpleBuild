/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaa.simplebuild;

import com.kaa.simplebuild.HistoryContent.Status;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import entity.BasementMaterial;
import entity.BasementTemplate;
import entity.BuildingTemplate;
import entity.MainPartMaterial;
import entity.MainPartTemplate;
import entity.RoofMaterial;
import entity.RoofTemplate;
import org.simpleframework.xml.Element;
import utils.CalculatorUtil;
//import history.NewMain.dataProvider;
/**
 *
 * @author Alexandr
 */
public class Calculator {
    @CsvBindByName
    @CsvBindByPosition(position = 0)
    @Element(name = "BUILDING_ID")
    private long idCalculatedBuilding=0;
    @CsvBindByName
    @CsvBindByPosition(position = 1)
    @Element(name = "HOME_AREA")
    private double homeArea =0;
    @CsvBindByName
    @CsvBindByPosition(position = 2)
    @Element(name = "HOME_TENANTS")
    private int homeTenants=0;
    @CsvBindByName
    @CsvBindByPosition(position = 3)
    @Element(name = "SUM")
    private double sumOtherExpenses=0;
    @CsvBindByName
    @CsvBindByPosition(position = 4)
    @Element(name = "LAND_AREA")
    private double landArea=0;

    

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    public double getLandArea() {
        return landArea;
    }
    public Calculator() 
    {
        
    }
    public Calculator(long id,double homeArea,int homeTenants,double sumOtherExpenses,double landArea)
    {    
        this.idCalculatedBuilding = id;
        this.homeArea = homeArea;
        this.homeTenants = homeTenants;
        this.landArea = landArea;
        this.sumOtherExpenses=sumOtherExpenses;
        
    }
    
    
    
    public Calculator(Calculator obj)
    {    
        this.idCalculatedBuilding = obj.getIdCalculatedBuilding();
        this.homeArea = obj.getHomeArea();
        this.homeTenants = obj.getHomeTenants();
        this.landArea = obj.getLandArea();
        this.sumOtherExpenses=obj.getSumOtherExpenses();
        
    }
    
    public void setSumOtherExpenses(double sumOtherExpenses) {
        this.sumOtherExpenses = sumOtherExpenses;
    }

    public double getSumOtherExpenses() {
        return sumOtherExpenses;
    }
    public void setHomeTenants(int homeTenants) {
        this.homeTenants = homeTenants;
    }

    public int getHomeTenants() {
        return homeTenants;
    }
    
    public double getHomeArea() {
    return homeArea;
    }

    public void setHomeArea(double houseArea) {
    this.homeArea = houseArea;
    }
    public void setIdCalculatedBuilding(long idCalculatedBuilding) {
        this.idCalculatedBuilding = idCalculatedBuilding;
    }

    public long getIdCalculatedBuilding() {
        return idCalculatedBuilding;
    }
    
    public Status InputHomeArea(String area){
        try {
            setHomeArea(Double.parseDouble(area));            
            
        } catch (NumberFormatException e) {
            return Status.FAULT;
        }
        return Status.SUCCESS;
    }
    public Status InputLandArea(String area){
        try {
            setLandArea(Double.parseDouble(area));            
            
        } catch (NumberFormatException e) {
            return Status.FAULT;
        }
        return Status.SUCCESS;
    }
    public Status InputHomeTenants(String t){
        try {
            setHomeTenants(Integer.parseInt(t));            
            
        } catch (NumberFormatException e) {
            return Status.FAULT;
        }
        return Status.SUCCESS;
    }
    //InputBuildingTemplate
    public double CalculateHomeCost(String dataProviderType)
    {
        
        IDataProvider dataProvider=null;
        switch (dataProviderType){
            case "csv":
                dataProvider = new DataProviderCsv();
                break;
            case "xml":
                dataProvider = new DataProviderXml();
                break;
            case "jdbc":
                dataProvider = new DataProviderJDBC();
                break;
        }
        //dataProvider;
        BuildingTemplate bt = dataProvider.getBuildingTemplateById(idCalculatedBuilding);
        //проверка на null и логирование 
        
        RoofTemplate roofTemplate =dataProvider.getRoofTemplateById(bt.getIdRoofTemplate());
        RoofMaterial roofMaterial = dataProvider.getRoofMaterialById(roofTemplate.getIdMaterial());
        double roofPrice = (homeArea*roofMaterial.getPrice()*roofTemplate.getPriceMultiplier());
        
        MainPartTemplate mainPartTemplate =dataProvider.getMainPartTemplateById(bt.getIdMainPartTemplate());
        MainPartMaterial mainPartMaterial = dataProvider.getMainPartMaterialById(mainPartTemplate.getIdMaterial());
        double mainPartPrice = (homeArea*mainPartMaterial.getPrice()*mainPartTemplate.getPriceMultiplier());
        
        BasementTemplate basementTemplate =dataProvider.getBasementTemplateById(bt.getIdBasementTemplate());
        BasementMaterial basementMaterial = dataProvider.getBasementMaterialById(basementTemplate.getIdMaterial());
        double basementPrice = (homeArea*basementMaterial.getPrice()*basementTemplate.getPriceMultiplier());
        
        return roofPrice+mainPartPrice+basementPrice;
    }
    public double CalculateHomeCost(IDataProvider dp)
    {   
        
        BuildingTemplate bt = dp.getBuildingTemplateById(idCalculatedBuilding);
        
        RoofTemplate roofTemplate =dp.getRoofTemplateById(bt.getIdRoofTemplate());
        RoofMaterial roofMaterial = dp.getRoofMaterialById(roofTemplate.getIdMaterial());
        double roofPrice = (homeArea*roofMaterial.getPrice()*roofTemplate.getPriceMultiplier());
        
        MainPartTemplate mainPartTemplate =dp.getMainPartTemplateById(bt.getIdMainPartTemplate());
        MainPartMaterial mainPartMaterial = dp.getMainPartMaterialById(mainPartTemplate.getIdMaterial());
        double mainPartPrice = (homeArea*mainPartMaterial.getPrice()*mainPartTemplate.getPriceMultiplier());
        
        BasementTemplate basementTemplate =dp.getBasementTemplateById(bt.getIdBasementTemplate());
        BasementMaterial basementMaterial = dp.getBasementMaterialById(basementTemplate.getIdMaterial());
        double basementPrice = (homeArea*basementMaterial.getPrice()*basementTemplate.getPriceMultiplier());
        
        return roofPrice+mainPartPrice+basementPrice;
    }
    public double CalculateHomeTax() 
    {   
        
        int tax = 10;
        System.out.println("Home tax = " + homeArea*tax);
        return homeArea*tax;
    }
    
    public double CalculateLandTax() 
    {
        
        double tax = 1.5;
        System.out.println("Land tax = " + landArea*tax);
        return landArea*tax;
    }
    public double CalculateTax() 
    {        
        double sumTax = CalculateHomeTax();
        if(getLandArea()!=0 )
            sumTax =sumTax+ CalculateLandTax();
        System.out.println("Sum of tax = " + sumTax);
        return sumTax;
    }
    public int CalculateConnectionCost() 
    {
        int costGasConnection = 1500;
        int costWaterSupplyConnection = 3000;
        int costElectricityGidConnection = 1800;
        System.out.println("Connection cost = " + costGasConnection+costWaterSupplyConnection+costElectricityGidConnection);
        return costGasConnection+costWaterSupplyConnection+costElectricityGidConnection;
    }

    public double CalculateCostOfUsing() {
        double costForOneResidenr = 10787.3;
        System.out.println("Connection cost = " + getHomeTenants()*costForOneResidenr);
        return getHomeTenants()*costForOneResidenr;
    }
    public double CalculateAmenitiesСost(){
        double sum = CalculateConnectionCost();
        if(getHomeTenants()!=0)        
            sum = sum+ CalculateCostOfUsing();
        
        System.out.println("Amenities cost = " + sum);
        return sum;
    }
    public double CalculateOtherExpenses(){
        sumOtherExpenses =0;
        sumOtherExpenses = CalculateAmenitiesСost()+CalculateTax();
        
        return sumOtherExpenses;
    }
    @Override
    public String toString() {
        return "Calculator{" + "idCalculatedBuilding=" + idCalculatedBuilding + ", homeArea=" + homeArea + ", homeTenants=" + homeTenants + ", sumOtherExpenses=" + sumOtherExpenses + ", landArea=" + landArea + '}';
    }
}
