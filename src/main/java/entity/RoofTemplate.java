package entity;

import entity.Template;

/**
 *
 * @author Alexandr
 */
public class RoofTemplate extends Template {

    public RoofTemplate() {
    }

    public RoofTemplate(long id, String name,double PriceMultiplier, int idMaterial) {
        super(id,name,PriceMultiplier,idMaterial);
        
    } 
     public RoofTemplate( String name,double PriceMultiplier, int idMaterial) {
        super(name,PriceMultiplier,idMaterial);
        
    }  
    @Override
    public String toString() {
        return "RoofTemplate{" +
                "id=" + getId() +
                ", name='" + getName() +
                "' , priceMultiplier=" + getPriceMultiplier()+
                ", idMaterial=" + getIdMaterial()+ "}";
    }
    
}
