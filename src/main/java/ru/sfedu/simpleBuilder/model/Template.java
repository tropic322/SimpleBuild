package ru.sfedu.simpleBuilder.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;

/**
 *
 * @author Alexandr
 */
public abstract class Template {

    public Template(long id, String name, double PriceMultiplier) {
        this.id=id;
        this.name = name;
        this.PriceMultiplier = PriceMultiplier;
        //this.idMaterial = idMaterial;
    }
    public Template(String name, double PriceMultiplier) {        
        this.name = name;
        this.PriceMultiplier = PriceMultiplier;
        //this.idMaterial = idMaterial;
    }

    public Template() {
    }
     private static int count = 0;
    
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
    @Element(name = "PRICEMULTIPLIER")
    private double PriceMultiplier;
    
    /*@CsvBindByName
    @CsvBindByPosition(position = 3)
    @Element(name = "IDMATERIAL")
    private long idMaterial;*/
    
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
    
    public double getPriceMultiplier() {
        return PriceMultiplier;
    }
    
    public void setPriceMultiplier(double PriceMultiplier) {
        this.PriceMultiplier = PriceMultiplier;
    }
    
    /*public long getIdMaterial() {
        return idMaterial;
    }
    
    public void setIdMaterial(long idMaterial) {
        this.idMaterial = idMaterial;
    } */
    
    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", name='" + name + '\'' + "}";
    }
    
}
