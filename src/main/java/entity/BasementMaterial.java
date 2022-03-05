
package entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;

/**
 *
 * @author Alexandr
 */
public class BasementMaterial extends Material {
    
    @CsvBindByName
    @CsvBindByPosition(position = 3)
    @Element(name = "FROST_RESISTANCE")
    private int frostResistance;
    
    @CsvBindByName
    @CsvBindByPosition(position = 4)
    @Element(name = "WATERPROOF")
    private int waterproof;
    
    public void setFrostResistance(int frostResistance) {
        this.frostResistance = frostResistance;
    }

    public void setWaterproof(int waterproof) {
        this.waterproof = waterproof;
    }

    public int getFrostResistance() {
        return frostResistance;
    }

    public int getWaterproof() {
        return waterproof;
    }
    public BasementMaterial(long id, String name,double price,int frostResistance,int waterproof)
    {
     super(id,name,price);
     this.frostResistance=frostResistance;
     this.waterproof=waterproof;
    }
    public BasementMaterial( String name,double price,int frostResistance,int waterproof)
    {
     super(name,price);
     this.frostResistance=frostResistance;
     this.waterproof=waterproof;
    }
    public BasementMaterial()
    {
     
    }
    @Override
    public String toString() {
        return "BasementMaterial{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() + 
                ", frostResistance=" + getFrostResistance() +
                ", waterproof=" + getWaterproof() +"}";
    }
    
}
