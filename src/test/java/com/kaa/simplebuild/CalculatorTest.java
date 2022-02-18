/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kaa.simplebuild;

import com.kaa.simplebuild.HistoryContent.Status;
import entity.BuildingTemplate;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Alexandr
 */
public class CalculatorTest {
    public CalculatorTest() {
        
    }
    @Test
    public void TestInputBuildingTemplate() {       
       assertTrue(clc.InputBuildingTemplate("123","csv")==Status.SUCCESS);
        
    }
    Calculator clc = new Calculator();
    @Test
    public void TestInputHomeArea() {       
       assertTrue(clc.InputHomeArea("100")==Status.SUCCESS);
        
    }
    @Test
    public void TestInputLandArea() {       
       assertTrue(clc.InputLandArea("100")==Status.SUCCESS);
        
    }
    @Test
    public void TestInputHomeTenants() {       
       assertTrue(clc.InputHomeTenants("100")==Status.SUCCESS);
        
    }
    @Test
    public void TestCalculateHomeCost() { 
       clc.setIdCalculatedBuilding(123);
       clc.InputHomeArea("10");
       assertTrue(clc.CalculateHomeCost("csv")>0);
        
    }
    @Test
    public void TestCalculateHomeTax() { 
       clc.InputHomeArea("10");
       assertTrue(clc.CalculateHomeTax()>0);
        
    }
    @Test
    public void TestCalculateLandTax() { 
       clc.InputLandArea("100");
       assertTrue(clc.CalculateLandTax()>0);
        
    }
    @Test
    public void TestCalculateTax() { 
       clc.InputLandArea("100");
       assertTrue(clc.CalculateTax()>0);
        
    }
    @Test
    public void TestCalculateConnectionCost() { 
       
       assertTrue(clc.CalculateConnectionCost()>0);
        
    }
    @Test
    public void TestCalculateCostOfUsing() { 
       clc.InputHomeTenants("3");
       assertTrue(clc.CalculateCostOfUsing()>0);
        
    }
    @Test
    public void TestCalculateAmenitiesСost() { 
       
       assertTrue(clc.CalculateAmenitiesСost()>0);
        
    }
    @Test
    public void TestCalculateOtherExpenses() { 
       clc.InputHomeArea("10");
       assertTrue(clc.CalculateOtherExpenses()>0);
        
    }
}
