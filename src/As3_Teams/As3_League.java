package As3_Teams;

import java.io.*;
import java.util.ArrayList;

public class As3_League {
    static ArrayList<As3_Team> allTeams;
    public static void run(){
        allTeams = new ArrayList<As3_Team>();
        loadFile("data/BattleSnacksLeague.csv", allTeams);
        teamFromName(allTeams, "Mewsicians").addPlayer(new As3_Player("Quandale Dingle", 4545, 3, 12));

        printAllTeams();

        while(true) {

            System.out.println("1 - Print List of Teams\n2 - Find the Highest Aura\n3 - View Division\n4 - Sort by Ranking\n5 - Sort by Funding\n6 - Invest\n7 - Exit and Save");

            // int choice = 2;//to be removed
            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                System.out.println("Print List of Teams");
                printAllTeams();
            }
            if (choice == 2) {
                System.out.println("Find the Highest Aura");
                int highestAuraIndex = findHighestAura(allTeams);
                System.out.println("Highest aura team: "+allTeams.get(highestAuraIndex).nickname + " with aura power of "+allTeams.get(highestAuraIndex).getAura());
            }
            if (choice == 3) {
                System.out.println("View Division");
                String division = Library.input.nextLine();
                printAllInDivision(division);
            }
            if(choice == 4){
                System.out.println("Sort by Ranking");
                sortByRanking(allTeams);
                printAllTeams();
            }
            if(choice == 5){
                System.out.println("Sort by Funding");
                sortByFunding(allTeams);
                printAllTeams();
            }
            if(choice == 6){
                System.out.println("Invest in what team (nickname)?");
                String searchFor = Library.input.nextLine();

                int foundIndex = searchByName(allTeams,searchFor);

                if (foundIndex == -1){
                    System.out.println("Invalid team nickname.");
                }
                else {
                    System.out.println("invest how much in "+allTeams.get(foundIndex).nickname+"?");
                    double investAmount = Library.input.nextDouble();
                    Library.input.nextLine();
                    allTeams.get(foundIndex).addFunding(investAmount);
                }
            }
            if (choice == 7) {
                System.out.println("Exit and save");
                saveFile("data/BattleSnacksLeague.csv", allTeams);
                break;
            }
        }//while

        System.out.println("Good bye");


    }

//    Print List of Teams
//    Find averages OR Find the Highest/Lowest (programmer's choice)
//    View Division
//    Sort by __?__
//    Update Stats
//    Exit and Save


    static As3_Team teamFromName(ArrayList<As3_Team> list, String name){
        for(int i = 0; i < list.size(); i++){
            if(name.equalsIgnoreCase((list.get(i)).getNickname())){
                return allTeams.get(i);
            }
        }
        System.out.println("!!! no team with name "+name+" !!!");
        return null;
    }

    public static int searchByName(ArrayList<As3_Team> list, String searchTerm){
        for(int i = 0; i < list.size(); i++){
            if(searchTerm.equalsIgnoreCase((list.get(i)).getNickname())){
                return i;
            }
        }
        return -1;
    }

    public static void printAllInDivision(String division){
        System.out.println("Printing all teams in division: "+division);
        for (As3_Team team:
             allTeams) {
            if(team.getDivision().equalsIgnoreCase(division)){
                System.out.println(team);
            }
        }
    }


    public static int findHighestAura(ArrayList<As3_Team> allTeams){
        int bestAura = 0;
        for(int i = 0; i < allTeams.size(); i++){
            if(allTeams.get(i).getAura() > allTeams.get(bestAura).aura){
                bestAura = i;
            }
        }
        return bestAura;
    }

    public static void sortByRanking(ArrayList<As3_Team> arr){
        for(int i=0; i<arr.size()-1; i++){
            int lowestIndex = i;
            for(int j=i+1; j<arr.size(); j++){
                if(arr.get(j).getRanking() < arr.get(lowestIndex).getRanking()){
                    System.out.println(arr.get(j).getRanking() + " vs lowestIndex " + arr.get(lowestIndex).getRanking());
                    lowestIndex = j;
                }
            }
            //swap the data
            As3_Team temp = arr.get(i);
            arr.set(i, arr.get(lowestIndex));
            arr.set(lowestIndex, temp);

        }
    }

    public static void sortByFunding(ArrayList<As3_Team> arr){
        for(int i=0; i<arr.size()-1; i++){
            int lowestIndex = i;
            for(int j=i+1; j<arr.size(); j++){
                if(arr.get(j).getFunding() < arr.get(lowestIndex).getFunding()){
                    System.out.println(arr.get(j).getRanking() + " vs lowestIndex " + arr.get(lowestIndex).getRanking());
                    lowestIndex = j;
                }
            }
            //swap the data
            As3_Team temp = arr.get(i);
            arr.set(i, arr.get(lowestIndex));
            arr.set(lowestIndex, temp);

        }
    }

    public static void printAllTeams(){
        for(As3_Team team : allTeams){
            System.out.println(team);
        }
    }

    public static void loadFile(String filename, ArrayList<As3_Team> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");

                list.add( new As3_Team(  tempArray[0],tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]), Double.parseDouble(tempArray[5])   ));
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile

    public static void saveFile(String filename, ArrayList <As3_Team> tempList ) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {
//the next lines are customized for whatever data you are getting.
                String toSave ="";
                toSave = tempList.get(i).getNickname();  //assumes getter method are used for private variables
                toSave +="," + tempList.get(i).getCity();
                toSave += "," + tempList.get(i).getDivision();
                toSave +="," + tempList.get(i).getAura();
                toSave +="," + tempList.get(i).getRanking();
                toSave +="," + tempList.get(i).getFunding();

//The above 6 lines could be replaced by a call to a carefully made toString() function

                file.println(toSave);

            }
            file.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile

}
