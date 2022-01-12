/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


import org.simpleframework.xml.Root;

/**
 *
 * @author Alexandr
 */
@Root( name = "RoofMaterial")
public class RoofMaterial  extends Material  {
    public RoofMaterial (long id, String name,double price)
    {
     super(id,name,price);
    }
    public RoofMaterial (String name,double price)
    {
     super(name,price);
    }
    public RoofMaterial(){
        
    }
    @Override
    public String toString() {
        return "RoofMaterial{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +"}";
    }
    
}
