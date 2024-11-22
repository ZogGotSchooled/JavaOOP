package As1_Crops;
import Examples.Ex3_Client;

import java.util.ArrayList;

public class As1_Main {

    public static void run(){
        ArrayList<As1_Crop> allCrops = new ArrayList<As1_Crop>();
        allCrops.add(new As1_Crop("Canola", 1000, "bu", 13.42));
        allCrops.add(new As1_Crop("Lychees", 5250, "pounds", 5.99));
        allCrops.add(new As1_Crop("Eggplant", 2000, "plants", 2.57));
        allCrops.add(new As1_Crop("Pineapple",  15900, "plants", 4.94));
        allCrops.add(new As1_Crop("Mangoes",  7, "tons", 8200));

        allCrops.get(0).setAcres(200);
        allCrops.get(1).setAcres(400);
        allCrops.get(2).setAcres(100);
        allCrops.get(3).setAcres(50);
        allCrops.get(4).setAcres(250);

        while(true) {

            System.out.println("Press 1 to Print farm summary\nPress 2 to Search & harvest a crop\nPress 3 to Get total revenue\nPress 4 to Plant a crop\nPress 5 to exit");

            // int choice = 2;//to be removed
            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                System.out.println("Print farm summary");
                for(As1_Crop cropTemp : allCrops){
                    cropTemp.printMe();
                }
            }
            if (choice == 2) {
                System.out.println("Search & harvest a crop");
                String searchFor = Library.input.nextLine();
                int foundIndex = searchByName(allCrops, searchFor);
                System.out.println("Found the crop:");
                double harvestVal = allCrops.get(foundIndex).doHarvest();
                System.out.println("Harvest value: $"+harvestVal);


            }
            if (choice == 3) {
                System.out.println("Get total revenue");
            }
            if(choice == 4){
                System.out.println("Plant a crop");
            }
            if (choice == 5) {
                break;
            }
            System.out.println();

        }//while

        System.out.println("Good bye");





    }


    public static int searchByName(ArrayList list, String searchTerm){
        for(int i = 0; i < list.size(); i++){
            if(searchTerm.equalsIgnoreCase(((As1_Crop)list.get(i)).getName())){
                return i;
            }
        }
        return -1;
    }
}
