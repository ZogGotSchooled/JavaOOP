package As1_Crops;

public class As1_Crop {

    private String name;
    private double yield;
    private String units;
    private double price;
    private int acres;
    public As1_Crop(String setName, int setYield, String setUnits, double setPrice){
        name = setName;
        yield = setYield;
        units = setUnits;
        price = setPrice;
    }

    public As1_Crop(String setName, int setYield, String setUnits, double setPrice, int setStartingAcres){
        name = setName;
        yield = setYield;
        units = setUnits;
        price = setPrice;
        setAcres(setStartingAcres);
    }

    public void setAcres(int setAcres) {
        this.acres = setAcres;
    }

    public void addAcres(int add){
        setAcres(acres + add);
    }

    public String toString(){
        return name + " " + yield + " " + units + " " + price + " " + acres;
    }

    public void printMe(){
        System.out.println("Crop: "+name + ", Yield per acre: " + yield + "" + units + ", Price per unit: " + price + ", Acres planted: " + acres);
    }

    public String getName() {
        return name;
    }

    public double doHarvest(){
        double harvestTemp =  calculateHarvestValue();
        acres = 0;
        return harvestTemp;
    }

    private double calculateHarvestValue(){
        return price * yield * acres;
    }
}

