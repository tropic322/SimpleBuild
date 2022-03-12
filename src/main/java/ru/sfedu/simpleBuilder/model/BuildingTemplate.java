
package ru.sfedu.simpleBuilder.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;

/**
 *
 * @author Alexandr
 */
public class BuildingTemplate {
 private static int count = 0; 
 
 @CsvBindByName
 @CsvBindByPosition(position = 0)
 @Element(name = "ID")
 private long id = (System.currentTimeMillis() + count);
 
 @CsvBindByName
 @CsvBindByPosition(position = 1)
 @Element(name = "NAME")
 private String name;
 
 @CsvBindByName
 @CsvBindByPosition(position = 2)
 @Element(name = "IDROOFTEMPLATE")
 private   long idRoofTemplate;
 
 @CsvBindByName
 @CsvBindByPosition(position = 3)
 @Element(name = "IDMAINPARTTEMPLATE")
 private long idMainPartTemplate; 
 
 @CsvBindByName
 @CsvBindByPosition(position = 4)
 @Element(name = "IDBASEMENTTEMPLATE")
 private long idBasementTemplate;
 
 @CsvBindByName
 @CsvBindByPosition(position = 5)
 @Element(name = "IDROOFMATERIAL")
 private long idRoofMaterial;

    
 
 @CsvBindByName
 @CsvBindByPosition(position = 6)
 @Element(name = "IDMAINPARTMATERIAL")
 private long idMainPartMaterial;
 
  @CsvBindByName
 @CsvBindByPosition(position = 7)
 @Element(name = "IDBASEMENTMATERIAL")
 private long idBasementMaterial;
 
public BuildingTemplate(long id, String name,long idRoofTemplate,long idMainPartTemplate ,long idBasementTemplate, long idRoofMaterial,long idMainPartMaterial,long idBasementMaterial){
    this.id=id; 
    this.name=name;
    this.idRoofTemplate=idRoofTemplate;
    this.idMainPartTemplate=idMainPartTemplate;
    this.idBasementTemplate = idBasementTemplate ;
    this.idRoofMaterial =idRoofMaterial;
    this.idMainPartMaterial=idMainPartMaterial;
    this.idBasementMaterial=idBasementMaterial;
}
public BuildingTemplate( String name,long idRoofTemplate,long idMainPartTemplate ,long idBasementTemplate, long idRoofMaterial,long idMainPartMaterial,long idBasementMaterial ){     
     this.name=name;
     this.idRoofTemplate=idRoofTemplate;
     this.idMainPartTemplate=idMainPartTemplate;
     this.idBasementTemplate = idBasementTemplate ;
     this.idRoofMaterial =idRoofMaterial;
    this.idMainPartMaterial=idMainPartMaterial;
    this.idBasementMaterial=idBasementMaterial;
}
    public BuildingTemplate(){}
    public long getId() {
        return id;
    }
    public long getIdRoofMaterial() {
        return idRoofMaterial;
    }

    public void setIdRoofMaterial(long idRoofMaterial) {
        this.idRoofMaterial = idRoofMaterial;
    }

    public long getIdMainPartMaterial() {
        return idMainPartMaterial;
    }

    public void setIdMainPartMaterial(long idMainPartMaterial) {
        this.idMainPartMaterial = idMainPartMaterial;
    }

    public long getIdBasementMaterial() {
        return idBasementMaterial;
    }

    public void setIdBasementMaterial(long idBasementMaterial) {
        this.idBasementMaterial = idBasementMaterial;
    }
    public void setId(long id) {
        this.id = id;
    }
    
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 public long getIdRoofTemplate() {
        return idRoofTemplate;
    }

    public void setIdRoofTemplate(long idRoofTemplate) {
        this.idRoofTemplate = idRoofTemplate;
    }
    
    public long getIdMainPartTemplate() {
        return idMainPartTemplate;
    }

    public void setIdMainPartTemplate(long idMainPartTemplate) {
        this.idMainPartTemplate = idMainPartTemplate;
    }
    
    public long getIdBasementTemplate() {
        return idBasementTemplate;
    }

    public void setIdBasementTemplate(long idBasementTemplate) {
        this.idBasementTemplate = idBasementTemplate;
    }
    
    @Override
    public String toString() {
        return "BuildingTemplate{" +
                "id=" + getId() +
                ", name='" + getName() +
                "' , idRoofTemplate=" + getIdRoofTemplate()+
                ", idMainPartTemplate=" + getIdMainPartTemplate()+ 
                ", idBasementTemplate=" + getIdBasementTemplate()+
                "' , idRoofMaterial=" + getIdRoofMaterial()+
                ", idMainPartMaterial=" + getIdMainPartMaterial()+ 
                ", idBasementMaterial=" + getIdBasementMaterial()+"}";
    }
    
    
}
