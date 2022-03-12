
package ru.sfedu.simpleBuilder.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;

/**
 *
 * @author Alexandr
 */
public class BasementTemplate extends Template {
    @CsvBindByName
    @CsvBindByPosition(position = 4)
    @Element(name = "CELLAR")
    private boolean cellar;

    public void setCellar(boolean cellar) {
        this.cellar = cellar;
    }

    public boolean getCellar() {
        return cellar;
    }
    
    
    public BasementTemplate(long id, String name,double PriceMultiplier, boolean cellar) {
        //super(id,name,PriceMultiplier,idMaterial);
        super(id,name,PriceMultiplier);
        this.cellar = cellar;
    }  
    public BasementTemplate( String name,double PriceMultiplier, boolean cellar) {
       // super(name,PriceMultiplier,idMaterial);
       super(name,PriceMultiplier);
       this.cellar = cellar;
    }
    public BasementTemplate( ) {
        
    }
    @Override
    public String toString() {
        return "BasementTemplate{" +
                "id=" + getId() +
                ", name='" + getName() +
                "' , priceMultiplier=" + getPriceMultiplier()+                 
                ", cellar=" + getCellar()+"}";
    }
   
}
