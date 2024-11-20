package As1_Crops;
import java.util.ArrayList;

public class As1_Main {

    public void run(){
        ArrayList<As1_Crop> allCrops = new ArrayList<As1_Crop>();
        allCrops.add(new As1_Crop("Canola", 1000, "bu", 13.42));
        allCrops.add(new As1_Crop("Lychees", 5250, "pounds", 5.99));
        allCrops.add(new As1_Crop("Eggplant", 2000, "", 5.99));

    }
}
