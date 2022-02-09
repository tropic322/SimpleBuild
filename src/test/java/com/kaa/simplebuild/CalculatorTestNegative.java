/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaa.simplebuild;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 * @author Alexandr
 */
public class CalculatorTestNegative {
    public CalculatorTestNegative() {
        
    }
    Calculator clc = new Calculator();
    @Test
    public void TestInputHomeArea() {       
       assertFalse(clc.InputHomeArea("aaa")==HistoryContent.Status.SUCCESS);
        
    }
    @Test
    public void TestInputLandArea() {       
       assertFalse(clc.InputLandArea("aaaa")==HistoryContent.Status.SUCCESS);
        
    }
    @Test
    public void TestInputHomeTenants() {       
       assertFalse(clc.InputHomeTenants("aaa")==HistoryContent.Status.SUCCESS);
        
    }
    @Test
    public void TestCalculateHomeCost() { ///пока нельзя так как не настроен ввод id
       clc.setIdCalculatedBuilding(123);
       clc.InputHomeArea("10");
       //assertTrue(clc.CalculateHomeCost("csv")>0);
        
    }
    @Test
    public void TestCalculateHomeTax() { 
       clc.InputHomeArea("aaa");
       assertFalse(clc.CalculateHomeTax()>0);
        
    }
    @Test
    public void TestCalculateLandTax() { 
       clc.InputLandArea("aaa");
       assertFalse(clc.CalculateLandTax()>0);
        
    }
    @Test
    public void TestCalculateTax() { 
       clc.InputLandArea("aaa");
       assertFalse(clc.CalculateTax()>0);
        
    }
    
    @Test
    public void TestCalculateCostOfUsing() { 
       clc.InputHomeTenants("aaa");
       assertFalse(clc.CalculateCostOfUsing()>0);
        
    }
    
    
}
