package As3_Teams;

public class As3_Team {
//    Nickname	City	Division	Aura	Ranking	Funding (millions)

    String nickname;
    String city;
    String division;
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
        return nickname + " " + city  + " " + division  + " " + aura  + " " + ranking  + " " + funding;
    }
}
