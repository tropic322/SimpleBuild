package history;




import com.kaa.simplebuild.DataProviderCsv;
import java.net.UnknownHostException;
import com.kaa.simplebuild.Calculator;
import com.kaa.simplebuild.DataProviderJDBC;
import com.kaa.simplebuild.DataProviderXml;
import com.kaa.simplebuild.IDataProvider;
import entity.BasementMaterial;
import entity.BasementTemplate;

import entity.BuildingTemplate;
import entity.MainPartMaterial;
import entity.MainPartTemplate;
import entity.RoofMaterial;
import entity.RoofTemplate;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;





/**
 *
 * @author Alexandr
 */

public class NewMain {
private static final Logger logger = LogManager.getLogger(NewMain.class);
    static DataProviderCsv dpc;    

    
    
    public static void main(String[] args) {
        logger.debug("NewMain()[0]: starting application.........");
        
        IDataProvider dataProvider;
        BuildingTemplate template = null;
        Calculator calculator = new Calculator();
        DataProviderJDBC provider = new DataProviderJDBC();
        double sumOtherExpenses =0;
    
        //boolean test =false;
       // provider.delBasementTemplate(1642359887746L);
        //RoofTemplate obj = new RoofTemplate(2,"222",2.1,2,true,false);
        //provider.updateRoofTemplate(obj);
        //logger.info(provider.getRoofTemplate());
        
        //if(provider.getRoofMaterialById(obj.getId()).equals(obj)){
          //  test = true;
        //} 
       // logger.info(provider.getRoofMaterialById(111));
       
        if (args.length == 0){
            System.out.println("No date provider selected");
            logger.error("No date provider selected");
            return;
        }
        switch (args[0]){
            
            case "csv":
                dataProvider = new DataProviderCsv();
                break;
                
            case "xml":
                dataProvider = new DataProviderXml();
                break;
            case "jdbc":
                dataProvider = new DataProviderJDBC();
                break;
            default:
                logger.error("Error in choosing a date provider");
                return;
        }
        if (args.length == 1){
            System.out.println("Executable method name not entered \n Please enter method name");
            logger.error(" Method not selected \n ");
            return;
        }
        //добавить отображение BT и среднюю стоимость за кв метр
        switch (args[1]){
            case "chooseBuildingTemplate":
                if (args.length != 3){
                     System.out.println("Invalid number of parameters \n Please enter only 3 parameters \n (dataprovider, method name, building template id )");
                     logger.info(dataProvider.getBuildingTemplate());
                     logger.error("Invalid number of parameters");
                     return;
                }
                long id = Long.parseLong(args[2], 10);
                template = dataProvider.getBuildingTemplateById(id);
                
                 break;
            case "InputArea"://это не должно быть так
                if (args.length != 3){
                    System.out.println("Invalid number of parameters \n Please enter only 3 parameters \n (dataprovider, method name, home area )");
                    logger.error("insufficient number of parameters");
                    return;
                }
                try {
                    calculator.setHouseArea(Double.parseDouble(args[2]));
            
                } catch (NumberFormatException e) {
                    logger.error(e);
                }
                
                break;
            case "CalculateHomeCost":
                if (args.length != 2){
                    System.out.println("Invalid number of parameters \n Please enter only 2 parameters \n (dataprovider, method name )");
                    logger.error("insufficient number of parameters");
                    return;
                }
                if(template!=null && calculator.getHouseArea()!=0){
                double homeCost = calculator.CalculateHomeCost(dataProvider);
                System.out.println("Home cost = " + homeCost);
                logger.info("Method calculate HomeCost completed");
                return;
                }
                if(template==null){
                    System.out.println("House template not initialized");
                    logger.error("House template not initialized");
                    
                }
                if(calculator.getHouseArea()==0){
                    System.out.println("Area of the house is not entered");
                    logger.error("Area of the house is not entered");
                    
                }
                break;
            case "ChooseMaterial":
                if (args.length != 4){
                    System.out.println("Invalid number of parameters \n Please enter only 4 parameters \n (dataprovider, method name, template parameter(-r, -m , -b ), id material");
                    logger.error("insufficient number of parameters");
                    return;
                }
                if(template!=null){
                long idNewMaterial;
                switch (args[2]){
                    case "-r":
                        RoofTemplate rt = dataProvider.getRoofTemplateById(template.getIdRoofTemplate());
                        idNewMaterial =Long.parseLong(args[3], 10);
                        if(dataProvider.getRoofMaterialById(idNewMaterial)!=null)
                        {
                            rt.setIdMaterial(idNewMaterial);
                        }
                        else{
                           System.out.println("Invalid id of material \n Such material does not exist");
                            logger.error("Invalid id of material"); 
                            return;
                        }
                        
                        System.out.println("Roof material has been changed");
                        logger.info("Roof material has been changed");
                    break;
                    case "-m":
                        MainPartTemplate mt = dataProvider.getMainPartTemplateById(template.getIdMainPartTemplate());                        
                        idNewMaterial =Long.parseLong(args[3], 10);
                        
                        if(dataProvider.getMainPartMaterialById(idNewMaterial)!=null)
                        {
                            mt.setIdMaterial(idNewMaterial);
                        }
                        else{
                           System.out.println("Invalid id of material \n Such material does not exist");
                            logger.error("Invalid id of material"); 
                            return;
                        }                        
                        System.out.println("Main part material has been changed");
                        logger.info("Main part material has been changed");
                    break;
                    case "-b":
                        BasementTemplate bt = dataProvider.getBasementTemplateById(template.getIdBasementTemplate());
                        idNewMaterial =Long.parseLong(args[3], 10);
                        
                        if(dataProvider.getBasementMaterialById(idNewMaterial)!=null)
                        {
                            bt.setIdMaterial(idNewMaterial);
                        }
                        else{
                           System.out.println("Invalid id of material \n Such material does not exist");
                            logger.error("Invalid id of material"); 
                            return;
                        }
                        System.out.println("Basement material has been changed");
                        logger.info("Basement material has been changed");
                    break;
                    default:
                        logger.error("Error in choosing a template parameter(-r, -m , -b )");
                    
                }
                }else{
                    System.out.println("House template not initialized");
                    logger.error("House template not initialized");
                    return;
                }
                
            break;
            
            case "CalculateOtherExpenses":
                switch(args.length){
                    case (2):
                    if(calculator.getHouseArea()!=0){                
                        System.out.println("Home tax = " + calculator.CalculateHomeTax());
                        sumOtherExpenses = calculator.CalculateHomeTax();
                        System.out.println("Some of other expenses = " + sumOtherExpenses);
                        logger.info("Method CalculateOtherExpenses completed");                
                        
                    }else{
                        System.out.println("House area not initialized");
                        logger.error("House area not initialized");                    
                        }
                    break;
                    
                    case (3):
                        if(args[2].equals("-c")){
                            if(calculator.getHouseArea()!=0){                
                                System.out.println("Home tax = " + calculator.CalculateHomeTax());
                                sumOtherExpenses = calculator.CalculateHomeTax();
                                System.out.println("Connection cost = " + calculator.CalculateConnectionCost());
                                sumOtherExpenses =calculator.CalculateConnectionCost();
                                System.out.println("Some of other expenses = " + sumOtherExpenses);
                                logger.info("Method CalculateOtherExpenses completed");
                                sumOtherExpenses=0;
                            }else{
                                System.out.println("House area not initialized");
                                logger.error("House area not initialized");                    
                                }
                            
                        }else{
                            System.out.println("Error in choosing a  parameter");
                            logger.error("Error in choosing a  parameter");  
                        }
                        break;
                    case (4):
                        switch(args[2]){
                        case("-l"):
                            if(calculator.getHouseArea()!=0){                
                                System.out.println("Home tax = " + calculator.CalculateHomeTax());
                                sumOtherExpenses = calculator.CalculateHomeTax();
                                System.out.println("Land tax = " + calculator.CalculateLandTax(Double.parseDouble(args[3])));
                                sumOtherExpenses =calculator.CalculateLandTax(Double.parseDouble(args[3]));
                                System.out.println("Some of other expenses = " + sumOtherExpenses);
                                logger.info("Method CalculateOtherExpenses completed");
                                sumOtherExpenses=0;
                            }else{
                                System.out.println("House area not initialized");
                                logger.error("House area not initialized");                    
                            }
                         break;
                         case("-cu"):
                             if(calculator.getHouseArea()!=0){                
                                System.out.println("Home tax = " + calculator.CalculateHomeTax());
                                sumOtherExpenses = calculator.CalculateHomeTax();
                                System.out.println("Connection cost = " + calculator.CalculateConnectionCost());
                                sumOtherExpenses =calculator.CalculateConnectionCost();
                                System.out.println("Cost of using = " + calculator.CalculateConnectionOfUsing(Integer.parseInt(args[3])));
                                sumOtherExpenses =calculator.CalculateConnectionOfUsing(Integer.parseInt(args[3]));
                                System.out.println("Some of other expenses = " + sumOtherExpenses);
                                logger.info("Method CalculateOtherExpenses completed");
                                sumOtherExpenses=0;
                            }else{
                                System.out.println("House area not initialized");
                                logger.error("House area not initialized");                    
                            }
                         break;
                         default:
                            System.out.println("Error in choosing a  parameter");
                            logger.error("Error in choosing a  parameter");
                            return;
                        }
                        case (5):
                            if(args[2].equals("-l") && args[4].equals("-c")){
                                if(calculator.getHouseArea()!=0){                
                                    System.out.println("Home tax = " + calculator.CalculateHomeTax());
                                    sumOtherExpenses = calculator.CalculateHomeTax();
                                    System.out.println("Land tax = " + calculator.CalculateLandTax(Double.parseDouble(args[3])));
                                    sumOtherExpenses =calculator.CalculateLandTax(Double.parseDouble(args[3]));
                                    System.out.println("Connection cost = " + calculator.CalculateConnectionCost());
                                    sumOtherExpenses =calculator.CalculateConnectionCost();
                                
                                    System.out.println("Some of other expenses = " + sumOtherExpenses);
                                    logger.info("Method CalculateOtherExpenses completed");
                                    sumOtherExpenses=0;
                                }else{
                                    System.out.println("House area not initialized");
                                    logger.error("House area not initialized");                    
                                }
                            }else{
                                System.out.println("Error in choosing a  parameter");
                                logger.error("Error in choosing a  parameter");                    
                            }
                        break;
                        case (6):
                            if(args[2].equals("-l") && args[4].equals("-cu")){
                                if(calculator.getHouseArea()!=0){                
                                    System.out.println("Home tax = " + calculator.CalculateHomeTax());
                                    sumOtherExpenses = calculator.CalculateHomeTax();
                                    System.out.println("Land tax = " + calculator.CalculateLandTax(Double.parseDouble(args[3])));
                                    sumOtherExpenses =calculator.CalculateLandTax(Double.parseDouble(args[3]));
                                    System.out.println("Connection cost = " + calculator.CalculateConnectionCost());
                                    sumOtherExpenses =calculator.CalculateConnectionCost();
                                    System.out.println("Cost of using = " + calculator.CalculateConnectionOfUsing(Integer.parseInt(args[5])));
                                    sumOtherExpenses =calculator.CalculateConnectionOfUsing(Integer.parseInt(args[5]));
                                
                                    System.out.println("Some of other expenses = " + sumOtherExpenses);
                                    logger.info("Method CalculateOtherExpenses completed");
                                    sumOtherExpenses=0;
                                }else{
                                    System.out.println("House area not initialized");
                                    logger.error("House area not initialized");                    
                                }
                            }else{
                                System.out.println("Error in choosing a  parameter");
                                logger.error("Error in choosing a  parameter");                    
                            }
                        break;
                        }
                    break;
                    
                }
                
                
            
    
    }
    
}
