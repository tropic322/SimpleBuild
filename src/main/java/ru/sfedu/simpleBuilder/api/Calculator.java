
package ru.sfedu.simpleBuilder.api;

import ru.sfedu.simpleBuilder.util.HistoryContent.Status;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import ru.sfedu.simpleBuilder.model.BasementMaterial;
import ru.sfedu.simpleBuilder.model.BasementTemplate;
import ru.sfedu.simpleBuilder.model.BuildingTemplate;
import ru.sfedu.simpleBuilder.model.MainPartMaterial;
import ru.sfedu.simpleBuilder.model.MainPartTemplate;
import ru.sfedu.simpleBuilder.model.RoofMaterial;
import ru.sfedu.simpleBuilder.model.RoofTemplate;
import org.simpleframework.xml.Element;
import ru.sfedu.simpleBuilder.model.Material;

/**
 *
 * @author Alexandr
 */
public class Calculator {
    //Material m = new BasementMaterial();
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
    
    public Status InputBuildingTemplate(String template, String dataProviderType ) {
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
        try {
            if(dataProvider.getBuildingTemplateById(Long.parseLong(template))!=null ) {
                setIdCalculatedBuilding(Long.parseLong(template));
            }else{
                return Status.FAULT;
            }

        } catch (NumberFormatException e) {
            return Status.FAULT;
        }
        return Status.SUCCESS;
    }

        public Status InputHomeArea(String area){
        try {
            if(Long.parseLong(area)>0) {
            setHomeArea(Double.parseDouble(area));
            }else{
                return Status.FAULT;
            }

        } catch (NumberFormatException e) {
            return Status.FAULT;
        }
        return Status.SUCCESS;
    }
    public Status InputLandArea(String area){
        try {
            if(Long.parseLong(area)>0) {
            setLandArea(Double.parseDouble(area));
            }else{
                return Status.FAULT;
            }

        } catch (NumberFormatException e) {
            return Status.FAULT;
        }
        return Status.SUCCESS;
    }
    public Status InputHomeTenants(String t){
        try {
            if(Long.parseLong(t)>0) {
            setHomeTenants(Integer.parseInt(t));
            }else{
                return Status.FAULT;
            }

        } catch (NumberFormatException e) {
            return Status.FAULT;
        }
        return Status.SUCCESS;
    }
    
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
        
        BuildingTemplate bt = dataProvider.getBuildingTemplateById(idCalculatedBuilding);        

        RoofTemplate roofTemplate =dataProvider.getRoofTemplateById(bt.getIdRoofTemplate());
        RoofMaterial roofMaterial = dataProvider.getRoofMaterialById(bt.getIdRoofMaterial());
        double roofPrice = (homeArea*roofMaterial.getPrice()*roofTemplate.getPriceMultiplier());

        MainPartTemplate mainPartTemplate =dataProvider.getMainPartTemplateById(bt.getIdMainPartTemplate());
        MainPartMaterial mainPartMaterial = dataProvider.getMainPartMaterialById(bt.getIdMainPartMaterial());
        double mainPartPrice = (homeArea*mainPartMaterial.getPrice()*mainPartTemplate.getPriceMultiplier());

        BasementTemplate basementTemplate =dataProvider.getBasementTemplateById(bt.getIdBasementTemplate());
        BasementMaterial basementMaterial = dataProvider.getBasementMaterialById(bt.getIdBasementMaterial());
        double basementPrice = (homeArea*basementMaterial.getPrice()*basementTemplate.getPriceMultiplier());

        return roofPrice+mainPartPrice+basementPrice;
    }
    public double CalculateHomeCost(IDataProvider dp)
    {

        BuildingTemplate bt = dp.getBuildingTemplateById(idCalculatedBuilding);

        RoofTemplate roofTemplate =dp.getRoofTemplateById(bt.getIdRoofTemplate());
        RoofMaterial roofMaterial = dp.getRoofMaterialById(bt.getIdRoofMaterial());
        double roofPrice = (homeArea*roofMaterial.getPrice()*roofTemplate.getPriceMultiplier());

        MainPartTemplate mainPartTemplate =dp.getMainPartTemplateById(bt.getIdMainPartTemplate());
        MainPartMaterial mainPartMaterial = dp.getMainPartMaterialById(bt.getIdMainPartMaterial());
        double mainPartPrice = (homeArea*mainPartMaterial.getPrice()*mainPartTemplate.getPriceMultiplier());

        BasementTemplate basementTemplate =dp.getBasementTemplateById(bt.getIdBasementTemplate());
        BasementMaterial basementMaterial = dp.getBasementMaterialById(bt.getIdBasementMaterial());
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
        System.out.println("Connection cost = " + (costGasConnection+costWaterSupplyConnection+costElectricityGidConnection));
        return costGasConnection+costWaterSupplyConnection+costElectricityGidConnection;
    }

    public double CalculateCostOfUsing() {
        double costForOneResidenr = 10787.3;
        System.out.println("Cost of using = " + getHomeTenants()*costForOneResidenr);
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
