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
public class BasementMaterial extends Material {

    public BasementMaterial(long id, String name,double price)
    {
     setId(id);
     setName(name);
     setPrice(price);
    }
    public BasementMaterial()
    {
     
    }
    @Override
    public String toString() {
        return "BasementMaterial{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() + "}";
    }
    
}
