//This is my own work. Chad Galloway
/**  Program: NFL Draft Planner
*    File: NFL_Player.java
*    Summary: Basic functionality abstract class for a NFL Player to be used in NFL Draft Planner application.
*    Author: Chad Galloway 
*    Date: Jan. 20, 2018
**/

package NFL_DraftPlanner_Players;

import java.time.LocalDate;

public abstract class NFL_Player implements Celebrate{

    // Private fields
    private String name;
    private LocalDate dob;
    private float height;
    private float weight;
    private String birthPlace;
    private int playersNumber;
    private String positionAbbreviation;
    private String collegeAttended;
    private int yearsExperienceInNFL;
    private int gamesPlayed;

    // Public Constructors
    public NFL_Player(String name, LocalDate dob, float height, float weight, String birthPlace, int playersNumber, String positionAbbreviation, String collegeAttended, int yearsExperienceInNFL, int gamesPlayed) {
        this.name = name;
        this.dob = dob;
        this.height = height;
        this.weight = weight;
        this.birthPlace = birthPlace;
        this.playersNumber = playersNumber;
        this.positionAbbreviation = positionAbbreviation;
        this.collegeAttended = collegeAttended;
        this.yearsExperienceInNFL = yearsExperienceInNFL;
        this.gamesPlayed = gamesPlayed;
    }
    public NFL_Player() {
        this.name = "";
        this.dob = LocalDate.now();
        this.height = 0f;
        this.weight = 0f;
        this.birthPlace = "";
        this.playersNumber = 0;
        this.positionAbbreviation = "";
        this.collegeAttended = "";
        this.yearsExperienceInNFL = 0;
        this.gamesPlayed = 0;
    }

    // Private field get accessors for public use
    public String getName() {
        return this.name;
    }
    public LocalDate getDOB() {
        return this.dob;
    }
    public float getHeight() {
        return this.height;
    }
    public float getWeight() {
        return this.weight;
    }
    public String getBirthPlace() {
        return this.birthPlace;
    }
    public int getPlayersNumber() {
        return this.playersNumber;
    }
    public String getPlayersPosition() {
        return this.positionAbbreviation;
    }
    public String getCollegeAttended() {
        return this.collegeAttended;
    }
    public int getPlayersExperience() {
        return this.yearsExperienceInNFL;
    }
    public int getGamesPlayed() {
        return this.gamesPlayed;
    }

    // Private field set accessors for public use
    public void setName(String newValue) {
        this.name = newValue;
    }
    public void setDOB(LocalDate newValue) {
        this.dob = newValue;
    }
    public void setHeight(float newValue) {
        this.height = newValue;
    }
    public void setWeight(float newValue) {
        this.weight = newValue;
    }
    public void setBirthPlace(String newValue) {
        this.birthPlace = newValue;
    }
    public void setPlayersNumber(int newValue) {
        this.playersNumber = newValue;
    }
    public void setPlayersPosition(String newValue) {
        this.positionAbbreviation = newValue;
    }
    public void setCollegeAttended(String newValue) {
        this.collegeAttended = newValue;
    }
    public void setPlayersExperience(int newValue) {
        this.yearsExperienceInNFL = newValue;
    }
    public void setGamesPlayed(int newValue) {
        this.gamesPlayed = newValue;
    }

    // Additional data point get accessors
    public int getAge() {
        LocalDate now = LocalDate.now();
        int age = now.getYear() - dob.getYear();
        if (now.getMonthValue() - (dob.getMonthValue()) <= 0 && now.getDayOfMonth() - dob.getDayOfMonth() < 0) {
            age--;
        }
        return age;
    }

    // Interface methods
    @Override
    public String celebration() {
        String s = "";
        
        int caseSwitch = ( (int)Math.random()*10 ) + 1;
        switch (caseSwitch) {
            case 1:
                s = "jumps up and down";
                break;
            case 2:
                s = "yells out loud";
                break;
            case 3:
                s = "screams praise the lord";
                break;
            case 4:
                s = "hugs his mama";
                break;
            case 5:
                s = "kisses his wife";
                break;
            case 6:
                s = "holds up his new jersey";
                break;
            case 7:
                 s = "bows his head and prays";
               break;
            case 8:
                 s = "runs around the room";
               break;
            case 9:
                s = "crys a tear of joy";
                break;
            case 10:
                s = "smiles and nods his head";
                break;
        }
        return s;
    }

    @Override
    public String toString() {
        String s = "";
        s = getName() + "\n#" + getPlayersNumber() + " " + getPlayersPosition() + "\nHeight: " + getHeight() + "in.  Weight: " + getWeight() + "lb.  Age: " + getAge() + "\nBorn: " + getDOB().getMonthValue() + "/" + getDOB().getDayOfMonth() + "/" + getDOB().getYear() + " " + getBirthPlace() + "\nCollege: " + getCollegeAttended() + "\n" + getPlayersExperience() + " Seasons in the NFL.";
        return s;
    }
}
