/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import java.io.Serializable;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *
 * @author Alexandr
 */
@Root(name = "Material")
public abstract class Material implements Serializable {
    private static int count = 0; 

    public Material(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Material(String name, double price) {        
        this.name = name;
        this.price = price;
    }
    public Material(){
    }
    
    @CsvBindByName
    @CsvBindByPosition(position = 0)
    @Element(name = "ID")
    private long id = (System.currentTimeMillis() + count);
    
    @CsvBindByName
    @CsvBindByPosition(position = 1)
    @Element(name = "NAME")
    private String name;
    
    @CsvBindByName
    @CsvBindByPosition(position = 2)
    @Element(name = "PRICE")
    private double price;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price + "}";
    }
    
    
    
}

