package ru.sfedu.simpleBuilder.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;

/**
 *
 * @author Alexandr
 */
public class RoofTemplate extends Template {
    @CsvBindByName
    @CsvBindByPosition(position = 4)
    @Element(name = "INSULATION")
    private boolean insulation;    
    
    @CsvBindByName
    @CsvBindByPosition(position = 5)
    @Element(name = "PIPE")
    private boolean pipe;

    public RoofTemplate() {
    }

    public RoofTemplate(long id, String name,double PriceMultiplier, boolean insulation,boolean pipe) {
        super(id,name,PriceMultiplier);
        this.insulation=insulation;
        this.pipe=pipe;
        
    } 
     public RoofTemplate( String name,double PriceMultiplier, boolean insulation,boolean pipe) {
        super(name,PriceMultiplier);
        this.insulation=insulation;
        this.pipe=pipe;
        
    } 
     public void setInsulation(boolean insulation) {
        this.insulation = insulation;
    }

    public void setPipe(boolean pipe) {
        this.pipe = pipe;
    }

    public boolean getInsulation() {
        return insulation;
    }

    public boolean getPipe() {
        return pipe;
    }
    @Override
    public String toString() {
        return "RoofTemplate{" +
                "id=" + getId() +
                ", name='" + getName() +
                "' , priceMultiplier=" + getPriceMultiplier()+
                                
                ", insulation=" + getInsulation()+
                ", pipe=" + getPipe()+"}";
    }
    
}
