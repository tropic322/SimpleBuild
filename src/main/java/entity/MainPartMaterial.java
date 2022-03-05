
package entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Element;

/**
 *
 * @author Alexandr
 */
public class MainPartMaterial extends Material{
    @CsvBindByName
    @CsvBindByPosition(position = 3)
    @Element(name = "SOUND_TRANSMISSION") 
    private double soundTransmission;

    public void setSoundTransmission(double soundTransmission) {
        this.soundTransmission = soundTransmission;
    }

    public double getSoundTransmission() {
        return soundTransmission;
    }
    
    public MainPartMaterial (long id, String name,double price,double soundTransmission)
    {
     super(id,name,price);
     this.soundTransmission=soundTransmission;
    }
    public MainPartMaterial ( String name,double price,double soundTransmission)
    {
     super(name,price);
     this.soundTransmission=soundTransmission;
    }
    public MainPartMaterial(){
        
    }
    @Override
    public String toString() {
        return "MainPartMaterial{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", soundTransmission=" + getSoundTransmission() +"}";
    }
    
}
