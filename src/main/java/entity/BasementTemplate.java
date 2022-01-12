/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Alexandr
 */
public class BasementTemplate extends Template {
    enum Season { WINTER, SPRING, SUMMER, AUTUMN };//////
    
    public BasementTemplate(long id, String name,double PriceMultiplier, int idMaterial) {
        super(id,name,PriceMultiplier,idMaterial);
    }  
    public BasementTemplate( String name,double PriceMultiplier, int idMaterial) {
        super(name,PriceMultiplier,idMaterial);
    }
    public BasementTemplate( ) {
        
    }
    @Override
    public String toString() {
        return "BasementTemplate{" +
                "id=" + getId() +
                ", name='" + getName() +
                "' , priceMultiplier=" + getPriceMultiplier()+
                ", idMaterial=" + getIdMaterial()+ "}";
    }
   
}
