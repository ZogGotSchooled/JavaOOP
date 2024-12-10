package As3_Teams;

import java.io.*;
import java.util.ArrayList;

public class As3_League {
    static ArrayList<As3_Team> allTeams;
    public static void run(){
        allTeams = new ArrayList<As3_Team>();
        loadFile("data/BattleSnacksLeague.csv", allTeams);
        teamFromName(allTeams, "Mewsicians").addPlayer(new As3_Player("Quandale Dingle", 1111, 11, 12));
        teamFromName(allTeams, "Mewsicians").addPlayer(new As3_Player("Mog Master", 1112, 3, 6));
        teamFromName(allTeams, "Mewsicians").addPlayer(new As3_Player("El Bozo", 1113, 3, 7));
        teamFromName(allTeams, "Mewsicians").addPlayer(new As3_Player("Sigmous Squid", 1114, 2, 11));
        teamFromName(allTeams, "Mewsicians").addPlayer(new As3_Player("Costco Gai", 1115, 1, 8));

        teamFromName(allTeams, "vog.snax").addPlayer(new As3_Player("zevobanskidani", 3284, 12, 12));
        teamFromName(allTeams, "vog.snax").addPlayer(new As3_Player("custard.inc", 2356, 13, 16));
        teamFromName(allTeams, "vog.snax").addPlayer(new As3_Player("treefrog134", 2334, 8, 16));
        teamFromName(allTeams, "vog.snax").addPlayer(new As3_Player("TuesdayTuesday", 2395, 9, 18));
        teamFromName(allTeams, "vog.snax").addPlayer(new As3_Player("Soyhhfnf", 2334, 10, 14));

        teamFromName(allTeams, "AAAs").addPlayer(new As3_Player("Peter Porker", 2396, 3, 3));
        teamFromName(allTeams, "AAAs").addPlayer(new As3_Player("Massive Meatball Man", 2253, 4, 3));
        teamFromName(allTeams, "AAAs").addPlayer(new As3_Player("Beef Boss", 2238, 6, 6));
        teamFromName(allTeams, "AAAs").addPlayer(new As3_Player("Hammifer Gravy", 2854, 3, 5));
        teamFromName(allTeams, "AAAs").addPlayer(new As3_Player("Sir Linguini", 2385, 2, 7));

        teamFromName(allTeams, "Thugs").addPlayer(new As3_Player("Squidward T.", 2227, 2, 3));

        teamFromName(allTeams, "Snobs").addPlayer(new As3_Player("Edgar Moni", 9476, 2, 8));
        teamFromName(allTeams, "Dragons").addPlayer(new As3_Player("Deis Nhutts", 7355, 6, 9));
        teamFromName(allTeams, "Huddlers").addPlayer(new As3_Player("Witchus tiht", 2227, 8, 6));
        teamFromName(allTeams, "Chests").addPlayer(new As3_Player("Y$", 3847, 2, 6));
        teamFromName(allTeams, "Zaddies").addPlayer(new As3_Player("Drizzy Drake", 2439, 9, 8));
        teamFromName(allTeams, "Thugs").addPlayer(new As3_Player("Squidward T.", 9060, 4, 7));
        teamFromName(allTeams, "Tweakers").addPlayer(new As3_Player("Twitch E.", 5758, 7, 9));

        printAllTeams();

        while(true) {

            System.out.println("1 - Print List of Teams\n2 - Find the Highest Aura\n3 - View Division\n4 - Sort by Ranking\n5 - Sort by Funding\n6 - Invest\n7 - Print all players  \n8 - Update Snack Score of player \n9 - Print total stats of all teams \n10 - Save and exit");

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
            if(choice == 7)
            {
                System.out.println("Print Players on team");
                System.out.println("Input team nickname..");
                String inputTeam = Library.input.nextLine();

                As3_Team team = teamFromName(allTeams, inputTeam);
                team.printTeamAndPlayers();
            }
            if(choice == 8)
            {
                System.out.println("Update player snack scores");
                System.out.println("Input player name to score snack point..");
                String inputPlayer = Library.input.nextLine();
                As3_Player foundPlayer = globalPlayerNameSearch(allTeams, inputPlayer);
                if(foundPlayer != null) {
                    foundPlayer.devourOneSnack();
                    System.out.println("Found player: "+foundPlayer.name+"!");
                    System.out.println("Adding 1 point to the snacks devoured tracker. Printing stats...");
                    System.out.println(foundPlayer);
                }
                else {
                    System.out.println("Did not find player "+inputPlayer+ ", :(");
                }
            }
            if(choice == 9){
                System.out.println("Printing total stats for all teams.");
                for (As3_Team team : allTeams){
                    team.printTotalStats();
                }
            }

            if (choice == 10) {
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

    static As3_Player globalPlayerNameSearch(ArrayList<As3_Team> list, String playername){
        for(As3_Team team : list){
            As3_Player player =team.searchForPlayer(playername);
            if(player != null){
                return player;
            }
        }
        return null;
    }

    static void printAllPlayers(ArrayList<As3_Team> list){
        for(As3_Team temp : list){
            temp.printTeamAndPlayers();
        }
    }

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
                if(arr.get(j).getFunding() > arr.get(lowestIndex).getFunding()){
//                    System.out.println(arr.get(j).getRanking() + " vs lowestIndex " + arr.get(lowestIndex).getRanking());
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
