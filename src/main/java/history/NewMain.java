package history;




import com.kaa.simplebuild.DataProviderCsv;
import java.net.UnknownHostException;
import com.kaa.simplebuild.Calculator;
import com.kaa.simplebuild.DataProviderJDBC;
import com.kaa.simplebuild.DataProviderXml;
import com.kaa.simplebuild.HistoryContent;
import com.kaa.simplebuild.HistoryContent.Status;
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
import utils.CalculatorUtil;




/**
 *
 * @author Alexandr
 */

public class NewMain {
    private static final Logger logger = LogManager.getLogger(NewMain.class);

    public static void main(String[] args) {
        logger.debug("NewMain()[0]: starting application.........");

        IDataProvider dataProvider;
        BuildingTemplate template = null;
        Calculator calculator = new Calculator();
        DataProviderXml provider = new DataProviderXml();
        DataProviderJDBC provider2 = new DataProviderJDBC();
        CalculatorUtil calculatorUtil = new CalculatorUtil();
        //calculatorUtil.createCalculator(calculator);

        //Calculator calculator1 = calculatorUtil.getCalculator();
        //logger.info(provider2.checkCountRoofMaterial());
        double sumOtherExpenses =0;

        //boolean test =false;
        // provider.delBasementTemplate(1642359887746L);
        //RoofTemplate obj = new RoofTemplate(3,"222",2.1,2,true,false);
        // provider.createRoofTemplate(obj);
        //BuildingTemplate obj = new BuildingTemplate("test",2,1,1);
        //provider2.createBuildingTemplate(obj);
        //provider2.createBuildingTemplate(obj);
        //logger.info(provider.getRoofTemplate());

        //if(provider.getRoofMaterialById(obj.getId()).equals(obj)){
        //  test = true;
        //}
        // logger.info(provider.getRoofMaterialById(111));
            /*
        if (args.length == 0){
            System.out.println("No date provider selected");
            //logger.error("No date provider selected");
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
            //logger.error(" Method not selected \n ");
            return;
        }

        switch (args[1]){
            case "chooseBuildingTemplate":
                if (args.length != 4){
                    System.out.println("Invalid number of parameters \n Please enter only 3 parameters \n (dataprovider, method name, building template id, home area )");
                    logger.info(dataProvider.getBuildingTemplate());
                    //logger.error("Invalid number of parameters");
                    return;
                }
                try{

                    if(dataProvider.getBuildingTemplateById(Long.parseLong(args[2]))!=null){
                        calculator.InputBuildingTemplate(args[2]);
                    }else{
                        System.out.println("Invalid building template id \n Such building template does not exist )");
                       //logger.error("Invalid building template id ");


                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid building template id \n This value cannot be converted to a number )");
                    logger.error(e);
                    return;
                }


                if(calculator.InputHomeArea(args[3])==Status.FAULT){
                    System.out.println("Invalid home area value \n This value cannot be converted to a number )");
                    //logger.error("Invalid home area value");
                    return;
                }
                calculatorUtil.createCalculator(calculator);
                break;

            case "CalculateHomeCost":
                if (args.length != 2){
                    System.out.println("Invalid number of parameters \n Please enter only 2 parameters \n (dataprovider, method name )");
                    //logger.error("Invalid number of parameters");
                    return;
                }
                calculator = calculatorUtil.getCalculator();
                if(calculator.getIdCalculatedBuilding()!=0 || calculator.getHomeArea()!=0){
                    double homeCost = calculator.CalculateHomeCost(dataProvider);
                    System.out.println("Home cost = " + homeCost);
                    //logger.info("Method calculate HomeCost completed");
                    return;
                }
                if(calculator.getIdCalculatedBuilding()==0){
                    System.out.println("House template not initialized");
                    //logger.error("House template not initialized");
                }
                if(calculator.getHomeArea()==0){
                    System.out.println("Area of the house is not entered");
                    //logger.error("Area of the house is not entered");

                }
                break;
            case "ChooseMaterial":
                calculator = calculatorUtil.getCalculator();
                if (args.length != 4){
                    System.out.println("Invalid number of parameters \n Please enter only 4 parameters \n (dataprovider, method name, template parameter(-r, -m , -b ), id material");
                    //logger.error("Invalid number of parameters");
                    return;
                }
                if(calculator.getIdCalculatedBuilding()!=0){
                    long idNewMaterial=0;
                    try{
                        idNewMaterial =Long.parseLong(args[3], 10);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid building template id \n This value cannot be converted to a number )");
                        logger.error(e);
                        return;
                    }
                    template = dataProvider.getBuildingTemplateById(calculator.getIdCalculatedBuilding());

                    switch (args[2]){
                        case "-r":
                            RoofTemplate rt = dataProvider.getRoofTemplateById(template.getIdRoofTemplate());

                            if(dataProvider.getRoofMaterialById(idNewMaterial)!=null)
                            {

                                rt.setIdMaterial(idNewMaterial);

                            }else{
                                System.out.println("Invalid id of material \n Such material does not exist");
                                //logger.error("Invalid id of material");
                                return;
                            }

                            rt.setId(System.currentTimeMillis());

                            dataProvider.createRoofTemplate(rt);

                            template.setIdRoofTemplate(rt.getId());
                            template.setId(System.currentTimeMillis());
                            dataProvider.createBuildingTemplate(template);
                            calculator.setIdCalculatedBuilding(template.getId());
                            calculatorUtil.createCalculator(calculator);
                            System.out.println("Roof material has been changed");
                            //logger.info("Roof material has been changed");
                            break;
                        case "-m":
                            MainPartTemplate mt = dataProvider.getMainPartTemplateById(template.getIdMainPartTemplate());

                            if(dataProvider.getMainPartMaterialById(idNewMaterial)!=null)
                            {
                                mt.setIdMaterial(idNewMaterial);
                            }
                            else{
                                System.out.println("Invalid id of material \n Such material does not exist");
                                //logger.error("Invalid id of material");
                                return;
                            }
                            mt.setId(System.currentTimeMillis());
                            dataProvider.createMainPartTemplate(mt);
                            template.setIdMainPartTemplate(mt.getId());
                            template.setId(System.currentTimeMillis());
                            dataProvider.createBuildingTemplate(template);
                            calculator.setIdCalculatedBuilding(template.getId());
                            calculatorUtil.createCalculator(calculator);
                            System.out.println("Main part material has been changed");
                            //logger.info("Main part material has been changed");
                            break;
                        case "-b":
                            BasementTemplate bt = dataProvider.getBasementTemplateById(template.getIdBasementTemplate());

                            if(dataProvider.getBasementMaterialById(idNewMaterial)!=null)
                            {
                                bt.setIdMaterial(idNewMaterial);
                            }
                            else{
                                System.out.println("Invalid id of material \n Such material does not exist");
                                logger.error("Invalid id of material");
                                return;
                            }
                            bt.setId(System.currentTimeMillis());
                            dataProvider.createBasementTemplate(bt);
                            template.setIdBasementTemplate(bt.getId());
                            template.setId(System.currentTimeMillis());
                            dataProvider.createBuildingTemplate(template);
                            calculator.setIdCalculatedBuilding(template.getId());
                            calculatorUtil.createCalculator(calculator);
                            System.out.println("Basement material has been changed");
                            //logger.info("Basement material has been changed");
                            break;
                        default:
                            logger.error("Error in choosing a template parameter(-r, -m , -b )");

                    }
                }else{
                    System.out.println("House template not initialized");
                   // logger.error("House template not initialized");
                    return;
                }

                break;
            case "InputHomeTenants":
                if (args.length != 3){
                    System.out.println("Invalid number of parameters \n Please enter only 3 parameters \n (dataprovider, method name, number of home tenants");
                    //logger.error("Invalid number of parameters");
                    return;
                }
                calculator = calculatorUtil.getCalculator();
                if(calculator.InputHomeTenants(args[2])==Status.FAULT){
                    System.out.println("Invalid home tenants value \n This value cannot be converted to a number )");
                    //logger.error("Invalid home tenants value");
                    return;
                }
                calculatorUtil.createCalculator(calculator);

                break;
            case "InputLandArea":
                if (args.length != 3){
                    System.out.println("Invalid number of parameters \n Please enter only 3 parameters \n (dataprovider, method name, land size");
                    //logger.error("Invalid number of parameters");
                    return;
                }
                calculator = calculatorUtil.getCalculator();
                if(calculator.InputLandArea(args[2])==Status.FAULT){
                    System.out.println("Invalid land size value \n This value cannot be converted to a number )");
                    //logger.error("Invalid home tenants value");
                    return;
                }
                calculatorUtil.createCalculator(calculator);
                break;

            case "CalculateOtherExpenses":
                if (args.length != 2)
                {
                    System.out.println("Invalid number of parameters \n Please enter only 2 parameters \n (dataprovider, method name");
                    logger.error("Invalid number of parameters");
                    return;
                }
                calculator = calculatorUtil.getCalculator();
                System.out.println("Calculate other expenses cost = " + calculator.CalculateOtherExpenses());
                //logger.info("Calculate other expenses cost was calculated");
                break;
            case "CalculateTax":
                if (args.length != 2)
                {
                    System.out.println("Invalid number of parameters \n Please enter only 2 parameters \n (dataprovider, method name");
                    logger.error("Invalid number of parameters");
                    return;
                }
                calculator = calculatorUtil.getCalculator();
                calculator.CalculateTax();
                //logger.info("Calculate tax calculated");
                break;
            case "CalculateAmenitiesCost":
                if (args.length != 2)
                {
                    System.out.println("Invalid number of parameters \n Please enter only 2 parameters \n (dataprovider, method name");
                    logger.error("Invalid number of parameters");
                    return;
                }
                calculator = calculatorUtil.getCalculator();
                calculator.CalculateAmenitiesСost();
                //logger.info("Calculate amenities cost calculated");
                break;
            default:
                logger.error("Error in choosing a method");
                return;
        }*/




    }

}
