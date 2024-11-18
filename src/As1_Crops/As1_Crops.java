package As1_Crops;

public class As1_Crops {


    public class Crop{
        private String name;
        private double yield;
        private String units;
        private double price;
        private int acres;
        public Crop(String setName, int setYield, String setUnits, double setPrice){
            name = setName;
            yield = setYield;
            units = setUnits;
            price = setPrice;
        }

        public void setAcres(int setAcres) {
            this.acres = setAcres;
        }

        public String toString(){
            return name + " " + yield + " " + units + " " + price + " " + acres;
        }
    }
}

