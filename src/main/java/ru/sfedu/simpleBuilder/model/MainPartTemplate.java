
package ru.sfedu.simpleBuilder.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;

/**
 *
 * @author Alexandr
 */
public class MainPartTemplate extends Template {
    
    @CsvBindByName
    @CsvBindByPosition(position = 4)
    @Element(name = "VERANDA")
    private boolean veranda;
    
    @CsvBindByName
    @CsvBindByPosition(position = 5)
    @Element(name = "WINDOWS")
    private int windows; 

    public void setVeranda(boolean veranda) {
        this.veranda = veranda;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public boolean getVeranda() {
        return veranda;
    }

    public int getWindows() {
        return windows;
    }
    public MainPartTemplate(long id, String name,double PriceMultiplier,boolean veranda,int windows) {
        //super(id,name,PriceMultiplier,idMaterial);
        super(id,name,PriceMultiplier);
        this.veranda = veranda;
        this.windows = windows;
    }  
    public MainPartTemplate(String name,double PriceMultiplier, boolean veranda,int windows) {
        //super(name,PriceMultiplier,idMaterial);
        super(name,PriceMultiplier);
        this.veranda = veranda;
        this.windows = windows;
    }

    public MainPartTemplate() {
    }
    @Override
    public String toString() {
        return "MainPartTemplate{" +
                "id=" + getId() +
                ", name='" + getName() +
                "' , priceMultiplier=" + getPriceMultiplier()+
                 "}";
    }
}
