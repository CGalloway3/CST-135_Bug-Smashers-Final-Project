//This is my own work. Chad Galloway
/**  Program: NFL Draft Planner
*    File: Offensive_NFL_Player.java
*    Summary: Offensive player class to be used in NFL Draft Planner application.
*    Author: Chad Galloway 
*    Date: Jan. 20, 2018
**/

package NFL_DraftPlanner_Players;

import java.time.LocalDate;

public class Offensive_NFL_Player extends NFL_Player {

    // Private fields
    private int attempts;
    private int completions_Receptions;
    private int yards;
    private String longest;
    private int touchdowns;
    private int turnovers;
    private int firstDowns;
    private int twentyYardsPlus;
    private int fortyYardsPlus;

    // Public constructors
    public Offensive_NFL_Player(String name, LocalDate dob, float height, float weight, String birthPlace, int playersNumber, 
            String positionAbbreviation, String collegeAttended, int yearsExperienceInNFL, int gamesPlayed, int completions, 
            int attempts, int yards, int touchdowns, int turnovers, int firstDowns, String longest, int twentyYardsPlus, int fortyYardsPlus) {
        
        // Call NFL_Player constructor
        super (name, dob, height, weight, birthPlace, playersNumber, positionAbbreviation, collegeAttended, yearsExperienceInNFL, gamesPlayed);
        
        // Set field values
        this.attempts = attempts;
        this.completions_Receptions = completions;
        this.yards = yards;
        this.longest = longest ;
        this.touchdowns = touchdowns;
        this.turnovers = turnovers;
        this.firstDowns = firstDowns;
        this.twentyYardsPlus = twentyYardsPlus;
        this.fortyYardsPlus = fortyYardsPlus;
    }
    public Offensive_NFL_Player() {
        
        // Call default NFL_Player constructor
        super ();
        
        // Initialize default field values
        this.attempts = 0;
        this.completions_Receptions = 0;
        this.yards = 0;
        this.longest = "" ;
        this.touchdowns = 0;
        this.turnovers = 0;
        this.firstDowns = 0;
        this.twentyYardsPlus = 0;
        this.fortyYardsPlus = 0;        
    }
    
    // Private field get accessors for public use
    public int getAttempts() {
        return this.attempts;
    }
    public int getCompletions() {
        
        // Retrun quaterbacks completions
        if ( this.getPlayersPosition().equalsIgnoreCase("QB") ) {
            return this.completions_Receptions;
        }
        else {
            return 0; // Player is not a quarteback and has zero completions
        }
    }
    public int getReceptions() {
        
        // Return recievers receptions
        if ( !this.getPlayersPosition().equalsIgnoreCase("QB") ) {
            return this.completions_Receptions;
        }
        else {
            return 0; // Player is not a reciever and has zero receptions
        }
    }
    public int getYards() {
        return this.yards;
    }
    public String getLongest() {
        return this.longest;
    }
    public int getTouchdowns() {
        return this.touchdowns;
    }
    public int getTurnovers() {
        return this.turnovers;
    }
    public int getFirstDowns() {
        return this.firstDowns;
    }
    public int getTwentyYardsPlus() {
        return this.twentyYardsPlus;
    }
    public int getFortyYardsPlus() {
        return this.fortyYardsPlus;
    }
    
    // Private field set accessors for public use
    public void setAttempts(int newValue) {
        this.attempts = newValue;
    }
    public void setCompletions(int newValue) {
        this.completions_Receptions = newValue;
    }
    public void setReceptions(int newValue) {
        this.completions_Receptions = newValue;
    }
    public void setYards(int newValue) {
        this.yards = newValue;
    }
    public void setLongest(String newValue) {
        this.longest = newValue;
    }
    public void setTouchdowns(int newValue) {
        this.touchdowns = newValue;
    }
    public void setTurnovers(int newValue) {
        this.turnovers = newValue;
    }
    public void setFirstDowns(int newValue) {
        this.firstDowns = newValue;
    }
    public void setTwentyYardsPlus(int newValue) {
        this.twentyYardsPlus = newValue;
    }
    public void setFortyYardsPlus(int newValue) {
        this.fortyYardsPlus = newValue;
    }
    
    // Additional data point get accessors
    public float getAttemptsPerGame() {
        
        // Divide by zero check
        if (this.getGamesPlayed() <= 0 ) {
            return 0; // not a vlaid value for this player return zero
        }
        
        // Default return
        return (float)this.attempts / (float)this.getGamesPlayed();
    }
    public float getCompletionPercentage() {
        
        // Divide by zero && position Quaterback checking
        if( this.attempts > 0 && this.getPlayersPosition().equalsIgnoreCase("QB") ) {
            return (float)this.completions_Receptions / (float)this.attempts;
        }
        else { // not a vlaid value for this player return zero
            return 0;
        }
    }
    public float getAverageYards() {
        
        // Divide by zero check and player is not a Runningback by default if completion_Receptions is greater than zero
        if (this.completions_Receptions > 0 ) {
            return (float)this.yards / (float)this.completions_Receptions;
        }
        // Divide by zero check and calculations for runningbacks
        else if (this.attempts > 0) {
            return (float)this.yards / (float)this.attempts;
        }
        else { // not a valid value for this player return zero
            return 0;            
        }
    }
    public float getYardsPerGame() {
        
        // Divide by zero check
        if ( this.getGamesPlayed() <= 0 ) {
            return 0; // not a vlaid value for this player return zero
        }
        
        // Default return
        return (float)this.yards / (float)this.getGamesPlayed();
    }
    public float getFirstDownPercentage() {
        
        // Divide by zero check and default runningback return
        if ( this.attempts > 0 ){
            return (float)this.firstDowns / (float)this.attempts;
        }
        // Divide by zero check and defaut quaterback and reciever return
        else if ( this.completions_Receptions > 0 ) {
            return (float)this.firstDowns / (float)this.completions_Receptions;
        }
        else {
            return 0; // not a vlaid value for this player return zero
        }
    }

    public String toStringStats() {
        String s = "";
        
        s = "Attempts\t\tCompletions\tReceptions\tYards\tTouchdowns\n     "
            + this.attempts + "\t\t\t" + this.getCompletions()+ "\t\t\t" + this.getReceptions()+ "\t\t" + this.yards+ "\t\t\t" + this.touchdowns;
        return s;
    }
}
