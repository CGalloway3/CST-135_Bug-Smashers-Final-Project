//This is my own work. Chad Galloway
/**  Program: NFL Draft Planner
*    File: Team.java
*    Summary: Offensive player class to be used in NFL Draft Planner application.
*    Author: Chad Galloway 
*    Date: Jan. 20, 2018
**/
package NFL_DraftPlanner_PlayerManager;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Office Computer
 */
public class Team {
    
    // Private fields
    private String teamCity;
    private String teamName;
    
    // Public constructors
    public Team() {
        this.teamCity = "";
        this.teamName = "";
    }
    public Team ( String teamCity, String teamName ) {
        this.teamCity = teamCity;
        this.teamName = teamName;
    }

    // Private field get accessors for public use.
    public String getTeamCity() {
        return teamCity;                
    }
    public String getTeamName() {
        return teamName;
    }
    
    public void setTeamCity (String newValue) {
        this.teamCity = newValue;
    }
    public void setTeamName (String newValue) {
        this.teamName = newValue;
    }
    
    public static ArrayList genereateAllCurrent_NFL_Teams() {
        ArrayList teams = new ArrayList();
        teams.add(new Team("Chicago", "Bears"));
        teams.add(new Team("Arizona", "Cardinals"));
        teams.add(new Team("Green Bay", "Packers"));
        teams.add(new Team("New York", "Giants"));
        teams.add(new Team("Detroit", "Lions"));
        teams.add(new Team("Washington", "Redskins"));
        teams.add(new Team("Philadelphia", "Eagles"));
        teams.add(new Team("Pittsburgh", "Steelers"));
        teams.add(new Team("Los Angeles", "Rams"));
        teams.add(new Team("San Francisco", "49ers"));
        teams.add(new Team("Cleveland", "Browns"));
        teams.add(new Team("Indianapolis", "Colts"));
        teams.add(new Team("Dallas", "Cowboys"));
        teams.add(new Team("Kansas City", "Chiefs"));
        teams.add(new Team("Los Angeles", "Chargers"));
        teams.add(new Team("Denver", "Broncos"));
        teams.add(new Team("New York", "Jets"));
        teams.add(new Team("New England", "Patriots"));
        teams.add(new Team("Oakland", "Raiders"));
        teams.add(new Team("Tennessee", "Titans"));
        teams.add(new Team("Buffalo", "Bills"));
        teams.add(new Team("Minnesota", "Vikings"));
        teams.add(new Team("Atlanta", "Falcons"));
        teams.add(new Team("Miami", "Dolphins"));
        teams.add(new Team("New Orleans", "Saints"));
        teams.add(new Team("Cincinnati", "Bengals"));
        teams.add(new Team("Seattle", "Seahawks"));
        teams.add(new Team("Tampa Bay", "Buccaneers"));
        teams.add(new Team("Carolina", "Panthers"));
        teams.add(new Team("Jacksonville", "Jaguars"));
        teams.add(new Team("Baltimore", "Ravens"));
        teams.add(new Team("Houston", "Texans"));

        teams.sort(Comparator.comparing(Team::getTeamCity));
        return teams;
    }
    
    @Override
    public String toString() {
        return teamCity + " " + teamName;
    }
}
