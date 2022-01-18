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
    
    
        boolean test =false;
        provider.delBasementTemplate(1642359887746L);
        //RoofTemplate obj = new RoofTemplate(2,"222",2.1,2,true,false);
        //provider.updateRoofTemplate(obj);
        //logger.info(provider.getRoofTemplate());
        
        //if(provider.getRoofMaterialById(obj.getId()).equals(obj)){
          //  test = true;
        //} 
       // logger.info(provider.getRoofMaterialById(111));
       /* if (args.length == 0){
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
            case "InputArea":
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
                if(template!=null){
                double homeCost = calculator.CalculateHomeCost(dataProvider);
                System.out.println("Hone cost = " + homeCost);
                logger.info("Method calculateHomeCost completed");
                }
                else{
                    System.out.println("House template not initialized");
                    logger.error("House template not initialized");
                    return;
                }
                break;
            case "ChooseMaterial":
                if (args.length != 4){
                    System.out.println("Invalid number of parameters \n Please enter only 4 parameters \n (dataprovider, method name, template parameter(-r, -m , -b ), id material");
                    logger.error("insufficient number of parameters");
                    return;
                }
                if(template!=null){
                switch (args[2]){
                    case "-r":
                        RoofTemplate rt = dataProvider.getRoofTemplateById(template.getIdRoofTemplate());
                        rt.setIdMaterial(Long.parseLong(args[3], 10));
                        System.out.println("Roof material has been changed");
                        logger.info("Roof material has been changed");
                    break;
                    case "-m":
                        MainPartTemplate mt = dataProvider.getMainPartTemplateById(template.getIdMainPartTemplate());
                        mt.setIdMaterial(Long.parseLong(args[3], 10));
                        System.out.println("Main part material has been changed");
                        logger.info("Main part material has been changed");
                    break;
                    case "-b":
                        BasementTemplate bt = dataProvider.getBasementTemplateById(template.getIdBasementTemplate());
                        bt.setIdMaterial(Long.parseLong(args[3], 10));
                        System.out.println("Basement material has been changed");
                        logger.info("Basement material has been changed");
                    break;
                }
                }else{
                    System.out.println("House template not initialized");
                    logger.error("House template not initialized");
                    return;
                }
                
            break;
            case "CalculateHomeTax":
                
                if (args.length != 2){
                    System.out.println("Invalid number of parameters \n Please enter only 2 parameters \n (dataprovider, method name )");
                    logger.error("insufficient number of parameters");
                    return;
                }
                if(calculator.getHouseArea()!=0){
                
                System.out.println("Home tax = " + calculator.CalculateHomeTax());
                logger.info("Method calculateHomeCost completed");
                }
                else{
                    System.out.println("House area not initialized");
                    logger.error("House area not initialized");
                    return;
                }
                break;
            case "CalculateLandTax":
                
                if (args.length != 3){
                    System.out.println("Invalid number of parameters \n Please enter only 3 parameters \n (dataprovider, method name, land area )");
                    logger.error("insufficient number of parameters");
                    return;
                }
                if(Double.parseDouble(args[2])!=0){
                
                System.out.println("Land tax = " + calculator.CalculateLandTax());
                logger.info("Method CalculateLandTax completed");
                }
                else{
                    System.out.println("Land not initialized");
                    logger.error("House area not initialized");
                    return;
                }
                break;
            case "CalculateConnectionCost":
                if (args.length != 2){
                    System.out.println("Invalid number of parameters \n Please enter only 2 parameters \n (dataprovider, method name )");
                    logger.error("insufficient number of parameters");
                    return;
                }
                calculator.CalculateConnectionCost();
                
                break;
            case "CalculateConnectionOfUsing":
                if (args.length != 3){
                    System.out.println("Invalid number of parameters \n Please enter only 3 parameters \n (dataprovider, method name,  number of residents )");
                    logger.error("insufficient number of parameters");
                    return;
                }
                calculator.CalculateConnectionOfUsing(Integer.parseInt(args[2]));
                
                break;    
        }*/
              
    }
    
    
    
}
