/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaa.simplebuild;

import entity.BasementMaterial;
import entity.BasementTemplate;
import entity.BuildingTemplate;
import entity.MainPartMaterial;
import entity.MainPartTemplate;
import entity.RoofMaterial;
import entity.RoofTemplate;
/**
 *
 * @author Alexandr
 */
public class Calculator {
    private long idCalculatedBuilding;
private double houseArea =0;


    public Calculator() {
    }
    public Calculator(long idCalculatedBuilding,double houseArea) {
        this.idCalculatedBuilding = idCalculatedBuilding;
        this.houseArea=houseArea;
        
    }
    public double getHouseArea() {
    return houseArea;
    }

    public void setHouseArea(double houseArea) {
    this.houseArea = houseArea;
    }

    

    public void setIdCalculatedBuilding(long idCalculatedBuilding) {
        this.idCalculatedBuilding = idCalculatedBuilding;
    }

    public long getIdCalculatedBuilding() {
        return idCalculatedBuilding;
    }
    
    public double CalculateHomeCost(IDataProvider dp)//Да, это колхоз, но к сожалению у меня уже нет времени переделать 
    {
        BuildingTemplate bt = dp.getBuildingTemplateById(idCalculatedBuilding);
        
        RoofTemplate roofTemplate =dp.getRoofTemplateById(bt.getIdRoofTemplate());
        RoofMaterial roofMaterial = dp.getRoofMaterialById(roofTemplate.getIdMaterial());
        double roofPrice = (houseArea*roofMaterial.getPrice()*roofTemplate.getPriceMultiplier());
        
        MainPartTemplate mainPartTemplate =dp.getMainPartTemplateById(bt.getIdMainPartTemplate());
        MainPartMaterial mainPartMaterial = dp.getMainPartMaterialById(mainPartTemplate.getIdMaterial());
        double mainPartPrice = (houseArea*mainPartMaterial.getPrice()*mainPartTemplate.getPriceMultiplier());
        
        BasementTemplate basementTemplate =dp.getBasementTemplateById(bt.getIdBasementTemplate());
        BasementMaterial basementMaterial = dp.getBasementMaterialById(basementTemplate.getIdMaterial());
        double basementPrice = (houseArea*basementMaterial.getPrice()*basementTemplate.getPriceMultiplier());
        
        return roofPrice+mainPartPrice+basementPrice;
    }
    public double CalculateHomeTax() 
    {        
        int tax = 10;
        return houseArea*tax;
    }
    public double CalculateLandTax(double landArea) 
    {
        
        double tax = 1.5;
        return landArea*tax;
    }
    
    public int CalculateConnectionCost() 
    {
        int costGasConnection = 1500;
        int costWaterSupplyConnection = 3000;
        int costElectricityGidConnection = 1800;
        return costGasConnection+costWaterSupplyConnection+costElectricityGidConnection;
    }

    public double CalculateConnectionOfUsing(int parseInt) {
        double costForOneResidenr = 10787.3;
        return parseInt*costForOneResidenr;
    }
}
