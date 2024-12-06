package As3_Teams;

import java.util.ArrayList;

public class As3_Team {
//    Nickname	City	Division	Aura	Ranking	Funding (millions)


    ArrayList<As3_Player> players;


    String nickname;
    String city;
    String division;


    public void addPlayer(As3_Player player){
        players.add(player);
    }

    public int getAura() {
        return aura;
    }

    int aura;
    int ranking;
    Double funding; // millions of CAD

    public As3_Team(String setNickname, String setCity, String setDivision, int setAura, int setRanking, double setFunding){
        nickname =setNickname;
        city = setCity;
        division = setDivision;
        aura = setAura;
        ranking = setRanking;
        funding = setFunding;
    }

    public String toString(){
        return "Nickname : " + nickname + " City: " + city  + " Division: " + division  + " Aura: " + aura  + " Ranking: " + ranking  + " Funding: " + funding;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCity() {
        return city;
    }

    public int getRanking() {
        return ranking;
    }

    public Double getFunding() {
        return funding;
    }

    public void addFunding(double add){
        setFunding(funding + add);
    }

    private void setFunding(double set){
        funding = set;
    }

    public String getDivision() {
        return division;
    }

}
