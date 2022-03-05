
package entity;


import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *
 * @author Alexandr
 */
@Root( name = "RoofMaterial")
public class RoofMaterial  extends Material  {
    @CsvBindByName
    @CsvBindByPosition(position = 3)
    @Element(name = "DURABILITY_YEARS")    
    private int durabilityYears;

   
    public void setDurabilityYears(int durabilityYears) {
        this.durabilityYears = durabilityYears;
    }

    public int getDurabilityYears() {
        return durabilityYears;
    }
    public RoofMaterial (long id, String name,double price,int durabilityYears)
    {
     super(id,name,price);
     this.durabilityYears =durabilityYears;
    }
    public RoofMaterial (String name,double price,int durabilityYears)
    {
     super(name,price);
     this.durabilityYears =durabilityYears;
    }
    public RoofMaterial(){
        
    }
    @Override
    public String toString() {
        return "RoofMaterial{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", durabilityYears=" + getDurabilityYears() +"}";
    }
    
}
