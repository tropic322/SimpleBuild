/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.Template;

/**
 *
 * @author Alexandr
 */
public class MainPartTemplate extends Template {
    public MainPartTemplate(long id, String name,double PriceMultiplier, int idMaterial) {
        super(id,name,PriceMultiplier,idMaterial);
    }  
    public MainPartTemplate(String name,double PriceMultiplier, int idMaterial) {
        super(name,PriceMultiplier,idMaterial);
    }

    public MainPartTemplate() {
    }
    @Override
    public String toString() {
        return "MainPartTemplate{" +
                "id=" + getId() +
                ", name='" + getName() +
                "' , priceMultiplier=" + getPriceMultiplier()+
                ", idMaterial=" + getIdMaterial()+ "}";
    }
}
