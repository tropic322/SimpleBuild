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
public class MainPartMaterial extends Material{
    
    public MainPartMaterial (long id, String name,double price)
    {
     setId(id);
     setName(name);
     setPrice(price);
    }
    public MainPartMaterial(){
        
    }
    @Override
    public String toString() {
        return "MainPartMaterial{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +"}";
    }
    
}
