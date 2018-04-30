//This is my own work. Chad Galloway
/**  Program: NFL Draft Planner
*    File: Defensive_NFL_Player.java
*    Summary: Defensive player class to be used in NFL Draft Planner application.
*    Author: Chad Galloway 
*    Date: Jan. 20, 2018
**/

package NFL_DraftPlanner_Players;

import java.time.LocalDate;

public class Defensive_NFL_Player extends NFL_Player {

    // Private fields
    private int totalTackles;
    private int assistTackles;
    private float sacks;
    private int safeties;
    private int passDeflections;
    private int Interceptions;
    private int interceptionTouchdowns;
    private int interceptionYards;
    private String longestInterseption;
    private int forcedFumbles;
    private int recoveredFumbles;
    private int fumbleTouchdowns;

    // Public Constructors
    public Defensive_NFL_Player(String name, LocalDate dob, float height, float weight, String birthPlace, int playersNumber, 
            String positionAbbreviation, String collegeAttended, int yearsExperienceInNFL, int gamesPlayed, int totalTackles, 
            int assistTackles, float sacks, int safeties, int passDeflections, int Interceptions, int interceptionTouchdowns, 
            int interceptionYards, String longestInterseption, int forcedFumbles, int recoveredFumbles, int fumbleTouchdowns) {
        
        // Call NFL_Player constructor
        super (name, dob, height, weight, birthPlace, playersNumber, positionAbbreviation, collegeAttended, yearsExperienceInNFL, gamesPlayed);
        
        // Set field values
        this.totalTackles = totalTackles;
        this.assistTackles = assistTackles;
        this.sacks = sacks;
        this.safeties = safeties;
        this.passDeflections = passDeflections;
        this.Interceptions = Interceptions;
        this.interceptionTouchdowns = interceptionTouchdowns;
        this.interceptionYards = interceptionYards;
        this.longestInterseption = longestInterseption;
        this.forcedFumbles = forcedFumbles;
        this.recoveredFumbles = recoveredFumbles;
        this.fumbleTouchdowns = fumbleTouchdowns;

    }
    public Defensive_NFL_Player(){
        
        // Call default NFL_Player constructor
        super();
        
        // Initialize default field values
        this.totalTackles = 0;
        this.assistTackles = 0;
        this.sacks = 0f;
        this.safeties = 0;
        this.passDeflections = 0;
        this.Interceptions = 0;
        this.interceptionTouchdowns = 0;
        this.interceptionYards = 0;
        this.longestInterseption = "";
        this.forcedFumbles = 0;
        this.recoveredFumbles = 0;
        this.fumbleTouchdowns = 0;
    }
   
    // Private field get accessors for public use
    public int getTotalTackles() {
        return this.totalTackles;
    }
    public int getAssistTackles() {
        return this.assistTackles;
    }
    public float getSacks() {
        return this.sacks;
    }
    public int getSafeties() {
        return this.safeties;
    }
    public int getPassDeflections() {
        return this.passDeflections;
    }
    public int getInterceptions() {
        return this.Interceptions;
    }
    public int getInterceptionTouchdowns() {
        return this.interceptionTouchdowns;
    }
    public int getInterceptionYards() {
        return this.interceptionYards;
    }
    public String getLongestInterception() {
        return this.longestInterseption;
    }
    public int getForcedFumbles() {
        return this.forcedFumbles;
    }
    public int getRecoveredFumbles() {
        return this.recoveredFumbles;
    }
    public int getFumbleTouchdowns() {
        return this.fumbleTouchdowns;
    }

    // Private field set accessors for public use
    public void setTotalTackles(int newValue) {
        this.totalTackles = newValue;
    }
    public void setAssistTackles(int newValue) {
        this.assistTackles = newValue;
    }
    public void setSacks(float newValue) {
        this.sacks = newValue;
    }
    public void setSafeties(int newValue) {
        this.safeties = newValue;
    }
    public void setPassDeflections(int newValue) {
        this.passDeflections = newValue;
    }
    public void setInterceptions(int newValue) {
        this.Interceptions = newValue;
    }
    public void setInterceptionTouchdowns(int newValue) {
        this.interceptionTouchdowns = newValue;
    }
    public void setInterceptionYards(int newValue) {
        this.interceptionYards = newValue;
    }
    public void setLongestInterception(String newValue) {
        this.longestInterseption = newValue;
    }
    public void setForcedFumbles(int newValue) {
        this.forcedFumbles = newValue;
    }
    public void setRecoveredFumbles(int newValue) {
        this.recoveredFumbles = newValue;
    }
    public void setFumbleTouchdowns(int newValue) {
        this.fumbleTouchdowns = newValue;
    }

    // Additional data point get accessors
    public int getCombineTackles() {
        return this.totalTackles + this.assistTackles;
    }
    
    public String toStringStats() {
        String s = "";
        
        s = "Tackles\t\tSacks\tInterceptions\tYards\tTouchdowns\n     "
            + this.totalTackles + "\t\t" + this.sacks+ "\t\t\t" + this.Interceptions+ "\t\t" + this.interceptionYards + "\t\t\t" + (this.fumbleTouchdowns + this.interceptionTouchdowns);
        return s;
    }

}
