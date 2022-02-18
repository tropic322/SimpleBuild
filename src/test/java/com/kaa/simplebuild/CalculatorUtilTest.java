/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaa.simplebuild;

import com.kaa.simplebuild.HistoryContent.Status;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import utils.CalculatorUtil;

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
