
package ru.sfedu.simpleBuilder.util;

import com.google.gson.Gson;
import ru.sfedu.simpleBuilder.api.Calculator;
import ru.sfedu.simpleBuilder.util.HistoryContent.Status;
import ru.sfedu.simpleBuilder.api.IDataProvider;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Thread.currentThread;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Alexandr
 */
public class CalculatorUtil {

    public CalculatorUtil() {
    }
    private static final Logger logger = LogManager.getLogger(CalculatorUtil.class);
    
    public Status createCalculator(Calculator obj) {
        Status status = Status.FAULT;
        List<Object> entitylist = new ArrayList<>();        
        
        entitylist.add(obj);
        status = save(entitylist, Constants.CALCULATOR_CSV,currentThread().getStackTrace()[1].getMethodName());
        
        
         return status;
        

    }
    public Calculator getCalculator () {
        List<Calculator> beans = null;
        try {
            beans = (List<Calculator>) new CsvToBeanBuilder<Calculator>(new FileReader(ConfigurationUtil.getConfigurationEntry(Constants.CALCULATOR_CSV)))
                    .withType(Calculator.class).build().parse();
        } catch (FileNotFoundException e) {
            logger.error(e);
        } catch (IOException ex) {
            logger.error(ex);
        }
               
            
        return beans.get(0);
    }
    private <T> Status save(List<T> list, String key, String method){
        
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
    

    private <T> Optional<List<T>> read(Class<?> cls, String key){ 
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
            java.util.logging.Logger.getLogger(CalculatorUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return optionalList;
    }
    
}
