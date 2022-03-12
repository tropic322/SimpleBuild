package ru.sfedu.simpleBuilder;

import ru.sfedu.simpleBuilder.util.HistoryContent.Status;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import ru.sfedu.simpleBuilder.api.Calculator;
import ru.sfedu.simpleBuilder.util.CalculatorUtil;

/**
 *
 * @author Alexandr
 */
public class CalculatorUtilTest {
    CalculatorUtil clc = new CalculatorUtil();
    
    @Test
    public void TestGetCalculator() {       
       assertTrue(clc.getCalculator()!=null);
        
    }
    @Test
    public void TestCreateCalculator() {  
        Calculator calculator = new Calculator();
        calculator = clc.getCalculator();
       assertTrue(clc.createCalculator(calculator)==Status.SUCCESS);
        
    }
}
