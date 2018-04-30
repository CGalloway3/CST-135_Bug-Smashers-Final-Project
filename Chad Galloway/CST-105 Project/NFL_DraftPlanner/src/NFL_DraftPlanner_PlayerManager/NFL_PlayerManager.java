//This is my own work. Chad Galloway
/**  Program: NFL Draft Planner
*    File: NFL_PlayerManager.java
*    Summary: Player manager class to be used in NFL Draft Planner application.
*    Author: Chad Galloway 
*    Date: Jan. 20, 2018
**/

package NFL_DraftPlanner_PlayerManager;

import NFL_DraftPlanner_Players.Defensive_NFL_Player;
import NFL_DraftPlanner_Players.Offensive_NFL_Player;
import NFL_DraftPlanner_Players.NFL_Player;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;

public class NFL_PlayerManager {

    // Private fields
    private ArrayList avaliblePlayers = new ArrayList();
    private ArrayList selectedPlayers = new ArrayList();
    private ArrayList filteredOutActivePlayers = new ArrayList();
    private ArrayList filteredOutSelectedPlayers = new ArrayList();

    // Public Constructors
    public NFL_PlayerManager(NFL_Player... players) {
        for (int i = 0; i < players.length; i++) {
            this.avaliblePlayers.add(players[i]);
        }
    }
    public NFL_PlayerManager() {
    } 

    // Private field accessors for public use
    public ArrayList getAvaliblePlayers(){
        return avaliblePlayers;
    }
    public ArrayList getSelectedPlayers() {
        return selectedPlayers;
    }

    // Public Boolean Tests
    public Boolean isSelectedPlayersFiltered() {
        if ( filteredOutSelectedPlayers.size() >  0 ) return true;
        else return false;
    }
    public Boolean isAvaliblePlayersFiltered() {
        if ( filteredOutActivePlayers.size() >  0 ) return true;
        else return false;
        
    }
    
    // Public methods
    public void loadPlayers() {
        
        // Top 10 Quaterbacks
        Offensive_NFL_Player QB1 = new Offensive_NFL_Player("Tom Brady",            LocalDate.of(1977, 8, 3),  76, 225, "San Mateo, CA",       12,  "QB", "Michigan",              18, 16, 385, 581, 4577, 32, 8,  230,"64T",  62, 10);
        Offensive_NFL_Player QB2 = new Offensive_NFL_Player("Philip Rivers",        LocalDate.of(1981, 12, 8), 77, 228, "Decatur, AL",         17,  "QB", "North Carolina State",  14, 16, 360, 575, 4515, 28, 10, 216,"75T",  61, 12);
        Offensive_NFL_Player QB3 = new Offensive_NFL_Player("Matthew Stafford",     LocalDate.of(1988, 2, 7),  75, 220, "Tampa, FL",           9,   "QB", "Georgia",               9,  16, 371, 565, 4446, 29, 10, 209,"71T",  61, 16);
        Offensive_NFL_Player QB4 = new Offensive_NFL_Player("Drew Brees",           LocalDate.of(1979, 1, 15), 72, 209, "Auatin, Tx",          9,   "QB", "Purdue",                17, 16, 386, 536, 4334, 23, 8,  201,"54T",  72, 11);
        Offensive_NFL_Player QB5 = new Offensive_NFL_Player("Ben Roethlisberger",   LocalDate.of(1982, 3, 2),  77, 240, "Lima, OH",            7,   "QB", "Miami (Ohio)",          14, 15, 360, 561, 4251, 28, 14, 207,"97T",  52, 14);
        Offensive_NFL_Player QB6 = new Offensive_NFL_Player("Matt Ryan",            LocalDate.of(1985, 5, 17), 76, 217, "Exton,PA",            2,   "QB", "Boston College",        10, 16, 342, 529, 4095, 20, 12, 199,"88T",  54, 8);
        Offensive_NFL_Player QB7 = new Offensive_NFL_Player("Kirk Cousins",         LocalDate.of(1988, 8, 19), 75, 202, "Barrington, IL",      8,   "QB", "Michigan State",        6,  16, 347, 540, 4093, 27, 13, 191,"74",   59, 9);
        Offensive_NFL_Player QB8 = new Offensive_NFL_Player("Alex Smith",           LocalDate.of(1984, 5, 7),  76, 217, "Seatle, WA",          11,  "QB", "Utah",                  13, 15, 341, 505, 4042, 26, 5,  184,"79T",  52, 13);
        Offensive_NFL_Player QB9 = new Offensive_NFL_Player("Russell Wilson",       LocalDate.of(1988, 11, 29),71, 215, "Cincinnati, OH",      3,   "QB", "Wisconsin",             6,  16, 339, 553, 3983, 34, 11, 183,"74T",  58, 12);
        Offensive_NFL_Player QB10 = new Offensive_NFL_Player("Jared Goff",          LocalDate.of(1994, 10, 14),76, 223, "San Rafael, CA",      16,  "QB", "California",            2,  15, 296, 477, 3804, 28, 7,  176,"94T",  54, 12);

        // Top 10 Runningbacks
        Offensive_NFL_Player RB1 = new Offensive_NFL_Player("Ezekiel Elliott",      LocalDate.of(1995, 7, 22), 72, 228, "Alton, IL",           21,  "RB", "Ohio State",            2,  10, 0,  242, 963,  7,   1,  55, "30",   5,  0);
        Offensive_NFL_Player RB2 = new Offensive_NFL_Player("Dalvin Cook",          LocalDate.of(1995, 8, 10), 70, 210, "Opa Locka, FL",       33,  "RB", "Florida State",         0,  4,  0,  74,  354,  2,   1,  15, "33",   4,  0);	
        Offensive_NFL_Player RB3 = new Offensive_NFL_Player("Todd Gurley",          LocalDate.of(1994, 8, 3),  73, 227, "Baltimore, MD",       30,  "RB", "Georgia",               3,  15, 0,  279, 1305, 13,  5,  66, "57T",  8,  1);	
        Offensive_NFL_Player RB4 = new Offensive_NFL_Player("Le'Veon Bell",         LocalDate.of(1992, 2, 18), 73, 225, "Columbus, OH",        26,  "RB", "Michigan State",        5,  15, 0,  321, 1291, 9,   2,  74, "27",   3,  0);	
        Offensive_NFL_Player RB5 = new Offensive_NFL_Player("Kareem Hunt",          LocalDate.of(1995, 8, 6),  70, 216, "Elyria, OH",          27,  "RB", "Toledo",                0,  16, 0,  272, 1327, 8,   1,  60, "69T",  12, 3);	
        Offensive_NFL_Player RB6 = new Offensive_NFL_Player("Leonard Fournette",    LocalDate.of(1995, 1, 18), 72, 228, "New Orleans, LA",     27,  "RB", "LSU",                   0,  13, 0,  268, 1040, 9,   2,  46, "90T",  4,  2);	
        Offensive_NFL_Player RB7 = new Offensive_NFL_Player("Adrian Peterson",      LocalDate.of(1985, 3, 21), 73, 220, "Palistine, TX",       23,  "RB", "Oklahoma",              11, 6,  0,  129, 448,  2,   3,  15, "27T",  2,  0);	
        Offensive_NFL_Player RB8 = new Offensive_NFL_Player("LeSean McCoy",         LocalDate.of(1988, 7, 12), 71, 210, "Harrisburg, PA",      25,  "RB", "Pittsburg",             9,  16, 0,  287, 1138, 6,   3,  55, "48T",  12, 1);	
        Offensive_NFL_Player RB9 = new Offensive_NFL_Player("Mark Ingram",          LocalDate.of(1989, 12, 21),69, 215, "Hackensack< NJ",      22,  "RB", "Alabama",               7,  16, 0,  230, 1124, 12,  2,  50, "72",   11, 3);	
        Offensive_NFL_Player RB10 = new Offensive_NFL_Player("Jordan Howard",       LocalDate.of(1994, 11, 2), 72, 224, "Fairfield, AL",       24,  "RB", "Indiana",               2,  16, 0,  276, 1122, 9,   1,  61, "53",   5,  3);	        

        // Top 10 Wide Recievers
        Offensive_NFL_Player WR1 = new Offensive_NFL_Player("Jarvis Landry",        LocalDate.of(1992, 11, 28),71, 208, "Metaire, LA",        14, "WR", "LSU",                     4,  16, 112, 0,  987,   9,  3,  60, "49",   6,  1);
        Offensive_NFL_Player WR2 = new Offensive_NFL_Player("Larry Fitzgerald",     LocalDate.of(1983, 8, 31), 75, 218, "Minneapolis, MN",    11, "WR", "Pittsburg",               14, 16, 109, 0,  1156,  6,  1,  66, "37",   16, 0);
        Offensive_NFL_Player WR3 = new Offensive_NFL_Player("Michael Thomas",       LocalDate.of(1993, 3, 3),  75, 212, "Los Angeles, CA",    13, "WR", "Ohio Atate",              2,  16, 104, 0,  1245,  5,  0,  70, "43",   22, 1);
        Offensive_NFL_Player WR4 = new Offensive_NFL_Player("Keenan Allen",         LocalDate.of(1992, 4, 27), 74, 211, "Greensboro, NC",     13, "WR", "California",              5,  16, 102, 0,  1393,  6,  1,  74, "51",   18, 4);
        Offensive_NFL_Player WR5 = new Offensive_NFL_Player("Antonio Brown",        LocalDate.of(1988, 7, 10), 70, 181, "Miami, FL",          84, "WR", "Central Michigan",        8,  14, 101, 0,  1533,  9,  3,  71, "57",   27, 7);
        Offensive_NFL_Player WR6 = new Offensive_NFL_Player("DeAndre Hopkins",      LocalDate.of(1992, 6, 6),  73, 210, "Central, SC",        10, "WR", "Clemson",                 5,  15, 96,  0,  1378,  13, 1,  69, "72T",  24, 2);
        Offensive_NFL_Player WR7 = new Offensive_NFL_Player("Golden Tate",          LocalDate.of(1988, 8, 2),  70, 197, "Nashville, TN",      15, "WR", "Notre Dame",              8,  16, 92,  0,  1003,  5,  1,  44, "71T",  10, 3);
        Offensive_NFL_Player WR8 = new Offensive_NFL_Player("Adam Thielen",         LocalDate.of(1990, 8, 22), 74, 200, "Detroit Lakes, MN",  19, "WR", "Minnesota State",         4,  16, 91,  0,  1276,  4,  3,  59, "65T",  20, 5);
        Offensive_NFL_Player WR9 = new Offensive_NFL_Player("Julio Jones",          LocalDate.of(1989, 2, 3),  75, 220, "Foley, AL",          11, "WR", "Alabama",                 7,  16, 88,  0,  1444,  3,  0,  67, "53",   23, 4);
        Offensive_NFL_Player WR10 = new Offensive_NFL_Player("Demaryius Thomas",    LocalDate.of(1987, 12, 25),75, 229, "Montrose, GA",       88, "WR", "Georgia Tech",            8,  16, 83,  0,  949,   5,  1,  53, "40",   15, 1);      

        // Top 1 Tight Ends
        Offensive_NFL_Player TE1 = new Offensive_NFL_Player("Travis Kelce", LocalDate.of(1989, 10, 5), 79f, 260f, "Westlake, OH", 87, "TE", "Cincinnati", 5, 15,  83, 0,1038,  8, 0, 55,"44", 19, 1);
        
        // Top 1 Defensive Linemen
        Defensive_NFL_Player DL1 = new Defensive_NFL_Player("Khalil Mack", LocalDate.of(1991, 2, 22), 75f, 250f, "Fort Pierce, FL", 52, "DE", "Buffalo", 4, 16, 61, 17, 10.5f, 0, 0, 0, 0, 0, "0", 1, 1, 0);
        
        // Top 10 Offensive Linemen
        Offensive_NFL_Player OL1 = new Offensive_NFL_Player("Jason Kelce",          LocalDate.of(1987, 11, 5),      75, 295,    "Cleveland, OH",        62, "C",  "Cincinnati",     7, 16, 0, 0, 0, 0, 0, 0, "0", 0, 0);
        Offensive_NFL_Player OL2 = new Offensive_NFL_Player("David DeCastro",       LocalDate.of(1990, 1 ,11),      77, 316,    "Kirkland, WA",         66, "OG", "Stanford",       6, 15, 0, 0, 0, 0, 0, 0, "0", 0, 0);
        Offensive_NFL_Player OL3 = new Offensive_NFL_Player("Zack Martin",          LocalDate.of(1990, 11, 20),     76, 315,    "Indianapolis, IN",     70, "OG", "Notre Dame",     4, 16, 0, 0, 0, 0, 0, 0, "0", 0, 0);
        Offensive_NFL_Player OL4 = new Offensive_NFL_Player("Alex Mack",            LocalDate.of(1985, 11, 19),     76, 311,    "Los Angeles, CA",      51, "C",  "California",     9, 16, 0, 0, 0, 0, 0, 0, "0", 0, 0);
        Offensive_NFL_Player OL5 = new Offensive_NFL_Player("David Bakhtiari",      LocalDate.of(1991, 9, 30),      76, 310,    "San Mateo, CA",        69, "OT", "Colorado",       5, 12, 0, 0, 0, 0, 0, 0, "0", 0, 0);
        Offensive_NFL_Player OL6 = new Offensive_NFL_Player("Brandon Brooks",       LocalDate.of(1989, 8, 19),      77, 335,    "Milwaukee, WI",        79, "OG", "Miami (ohio)",   6, 16, 0, 0, 0, 0, 0, 0, "0", 0, 0);
        Offensive_NFL_Player OL7 = new Offensive_NFL_Player("Travis Frederick",     LocalDate.of(1991, 3, 18),      76, 320,    "Sharon, WI",           72, "C",  "Wisconsin",      5, 16, 0, 0, 0, 0, 0, 0, "0", 0, 0);
        Offensive_NFL_Player OL8 = new Offensive_NFL_Player("Daryl Williams",       LocalDate.of(1992, 8, 31),      78, 330,    "Newport News, VA",     60, "OT", "Oklahoma",       3, 16, 0, 0, 0, 0, 0, 0, "0", 0, 0);
        Offensive_NFL_Player OL9 = new Offensive_NFL_Player("Lane Johnson",         LocalDate.of(1990, 5, 8),       78, 317,    "Cleveland, TX",        65, "OT", "Oklahoma",       5, 15, 0, 0, 0, 0, 0, 0, "0", 0, 0);
        Offensive_NFL_Player OL10 = new Offensive_NFL_Player("Josh Sitton",         LocalDate.of(1986, 6, 16),      75, 320,    "Jacksonville, FL",     71, "OG", "Central Florida",10, 13, 0, 0, 0, 0, 0, 0, "0", 0, 0);

        // Top 1 Linebackers
        Defensive_NFL_Player LB1 = new Defensive_NFL_Player("Preston Brown", LocalDate.of(1992, 10, 27), 73f, 251f, "Cincinnati, OH", 52, "MLB", "Louisville", 4, 16, 84, 60, 0f, 0, 3, 0, 0, 0, "0", 0, 0, 0);
        
        // Top 5 Defensive Backs
        Defensive_NFL_Player DB1 = new Defensive_NFL_Player("Reshad Jones",     LocalDate.of(1988, 2, 25), 73, 223, "Atlanta, GA", 20, "FS", "Georgia", 8, 16,    94,     28,     1.5f,    0,      7,      2,      0,      15,     "15",   0,      3,      2);
        Defensive_NFL_Player DB2 = new Defensive_NFL_Player("Keanu Neal",       LocalDate.of(1995, 7, 26), 72, 211,  "Groveland, FL", 22, "SS", "Florida", 2, 16,  83,     33,	0,	0,	7,	1,	0,	19,	"19",	3,	2,	0);
        Defensive_NFL_Player DB3 = new Defensive_NFL_Player("Landon Collins",    LocalDate.of(1994, 1, 10), 72, 218, "New Orleans, LA", 21,"SS","Alabama",  3, 15,  78,	    26,0,	0,	8,	2,	0,	21,	"21",	1,	2,	0);
        Defensive_NFL_Player DB4 = new Defensive_NFL_Player("Matthias Farley",   LocalDate.of(1992, 7 ,15), 71, 209, "Charlotte, NC", 41,          "SS","Notre Dame", 2, 16,       60,	38,	0,	0,	9,	2,	0,	9,	"9",	1,	1,	0);
        Defensive_NFL_Player DB5 = new Defensive_NFL_Player("Devin McCourty",    LocalDate.of(1987,8,13), 70, 195, "Nyack, NY", 32,                    "FS","Rutgers",8,16,    80,	17,	1,	0,	6,	1,	0,	0,	"0",	0,	1,	0);
 
        
        avaliblePlayers.add(QB1);
        avaliblePlayers.add(QB2);
        avaliblePlayers.add(QB3);
        avaliblePlayers.add(QB4);
        avaliblePlayers.add(QB5);
        avaliblePlayers.add(QB6);
        avaliblePlayers.add(QB7);
        avaliblePlayers.add(QB8);
        avaliblePlayers.add(QB9);
        avaliblePlayers.add(QB10);

        avaliblePlayers.add(RB1);
        avaliblePlayers.add(RB2);
        avaliblePlayers.add(RB3);
        avaliblePlayers.add(RB4);
        avaliblePlayers.add(RB5);
        avaliblePlayers.add(RB6);
        avaliblePlayers.add(RB7);
        avaliblePlayers.add(RB8);
        avaliblePlayers.add(RB9);
        avaliblePlayers.add(RB10);

        avaliblePlayers.add(WR1);
        avaliblePlayers.add(WR2);
        avaliblePlayers.add(WR3);
        avaliblePlayers.add(WR4);
        avaliblePlayers.add(WR5);
        avaliblePlayers.add(WR6);
        avaliblePlayers.add(WR7);
        avaliblePlayers.add(WR8);
        avaliblePlayers.add(WR9);
        avaliblePlayers.add(WR10);

        avaliblePlayers.add(TE1);

        avaliblePlayers.add(DL1);

        avaliblePlayers.add(OL1);
        avaliblePlayers.add(OL2);
        avaliblePlayers.add(OL3);
        avaliblePlayers.add(OL4);
        avaliblePlayers.add(OL5);
        avaliblePlayers.add(OL6);
        avaliblePlayers.add(OL7);
        avaliblePlayers.add(OL8);
        avaliblePlayers.add(OL9);
        avaliblePlayers.add(OL10);

        avaliblePlayers.add(LB1);

        avaliblePlayers.add(DB1);
        avaliblePlayers.add(DB2);
        avaliblePlayers.add(DB3);
        avaliblePlayers.add(DB4);
        avaliblePlayers.add(DB5);

    }
    public void selectPlayer(String playersName) {
        NFL_Player player;
        for (int i = 0; i < avaliblePlayers.size(); i++) {
            player = (NFL_Player) avaliblePlayers.get(i);
            if ( player.getName().equals(playersName) ) {
                avaliblePlayers.remove(i);
                selectedPlayers.add(player);
                i--; //Decrement i to account for removed player
            }
        }
    }
    public void removePlayer(String playersName) {
        NFL_Player player;
        for (int i = 0; i < selectedPlayers.size(); i++) {
            player = (NFL_Player) selectedPlayers.get(i);
            if ( player.getName().equals(playersName) ) {
                selectedPlayers.remove(i);
                avaliblePlayers.add(player);
                i--; //Decrement i to account for removed player
            }
        }
    }
    public void removeFromAvalibility(NFL_Player selectedPlayer) {
        NFL_Player player;
        for (int i = 0; i < avaliblePlayers.size(); i++) {
            player = (NFL_Player) avaliblePlayers.get(i);
            if ( player.equals(selectedPlayer) ) {
                avaliblePlayers.remove(i);
                return;
            }
        }
    }
    public void filterAvaliblePlayers(int count) {
        
        NFL_Player player;
        
        // Reset filter by hiding all players and clearing avalible players list.
        filteredOutActivePlayers.addAll(avaliblePlayers);
        avaliblePlayers.clear();
        
        // do filtering for side of field selestion
        if (count <= 3 ) {
            switch (count) {
                case 1: 
                    for (int i = 0; i < filteredOutActivePlayers.size(); i++) {
                        if ( filteredOutActivePlayers.get(i) instanceof Offensive_NFL_Player ){
                            avaliblePlayers.add(filteredOutActivePlayers.get(i));
                            filteredOutActivePlayers.remove(i);
                            i--;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < filteredOutActivePlayers.size(); i++) {
                        if ( filteredOutActivePlayers.get(i) instanceof Defensive_NFL_Player ){
                            avaliblePlayers.add(filteredOutActivePlayers.get(i));
                            filteredOutActivePlayers.remove(i);
                            i--;
                        }
                    }
                    break;
                case 3:
                    avaliblePlayers.addAll(filteredOutActivePlayers);
                    filteredOutActivePlayers.clear();
                    break;                
            }
        }
        else {
            if ( count >= 512 ) {
                count -= 512;
                for ( int i = 0; i < filteredOutActivePlayers.size(); i++) {
                    player = (NFL_Player)filteredOutActivePlayers.get(i);
                    if ( player.getPlayersPosition().equalsIgnoreCase("FS") || 
                         player.getPlayersPosition().equalsIgnoreCase("SS") || 
                         player.getPlayersPosition().equalsIgnoreCase("CB") || 
                         player.getPlayersPosition().equalsIgnoreCase("DB") || 
                         player.getPlayersPosition().equalsIgnoreCase("SAF")   )
                    {
                        avaliblePlayers.add(filteredOutActivePlayers.get(i));
                        filteredOutActivePlayers.remove(i);
                        i--;                   
                    }
                }
            }
            if ( count >= 256 ) {
                count -= 256;
                for ( int i = 0; i < filteredOutActivePlayers.size(); i++) {
                    player = (NFL_Player)filteredOutActivePlayers.get(i);
                    if ( player.getPlayersPosition().equalsIgnoreCase("MLB") || 
                         player.getPlayersPosition().equalsIgnoreCase("ILB") || 
                         player.getPlayersPosition().equalsIgnoreCase("OLB")   )
                    {
                        avaliblePlayers.add(filteredOutActivePlayers.get(i));
                        filteredOutActivePlayers.remove(i);
                        i--;                   
                    }
                }
            }
             if ( count >= 128 ) {
                count -= 128;
                for ( int i = 0; i < filteredOutActivePlayers.size(); i++) {
                    player = (NFL_Player)filteredOutActivePlayers.get(i);
                    if ( player.getPlayersPosition().equalsIgnoreCase("DE") || 
                         player.getPlayersPosition().equalsIgnoreCase("DT") || 
                         player.getPlayersPosition().equalsIgnoreCase("NT")    )
                    {
                        avaliblePlayers.add(filteredOutActivePlayers.get(i));
                        filteredOutActivePlayers.remove(i);
                        i--;                   
                    }
                }
             }
            if ( count >= 64 ) {
                count -= 64;
                for ( int i = 0; i < filteredOutActivePlayers.size(); i++) {
                    player = (NFL_Player)filteredOutActivePlayers.get(i);
                    if ( player.getPlayersPosition().equalsIgnoreCase("C") || 
                         player.getPlayersPosition().equalsIgnoreCase("OG") || 
                         player.getPlayersPosition().equalsIgnoreCase("OT")    )
                    {
                        avaliblePlayers.add(filteredOutActivePlayers.get(i));
                        filteredOutActivePlayers.remove(i);
                        i--;                   
                    }
                }
            }
            if ( count >= 32 ) {
                count -= 32;
                for ( int i = 0; i < filteredOutActivePlayers.size(); i++) {
                    player = (NFL_Player)filteredOutActivePlayers.get(i);
                    if ( player.getPlayersPosition().equalsIgnoreCase("TE")    )
                    {
                        avaliblePlayers.add(filteredOutActivePlayers.get(i));
                        filteredOutActivePlayers.remove(i);
                        i--;                   
                    }
                }
            }
            if ( count >= 16 ) {
                count -= 16;
                for ( int i = 0; i < filteredOutActivePlayers.size(); i++) {
                    player = (NFL_Player)filteredOutActivePlayers.get(i);
                    if ( player.getPlayersPosition().equalsIgnoreCase("WR")    )
                    {
                        avaliblePlayers.add(filteredOutActivePlayers.get(i));
                        filteredOutActivePlayers.remove(i);
                        i--;                   
                    }
                }
            }
            if ( count >= 8 ) {
                count -= 8;
                for ( int i = 0; i < filteredOutActivePlayers.size(); i++) {
                    player = (NFL_Player)filteredOutActivePlayers.get(i);
                    if ( player.getPlayersPosition().equalsIgnoreCase("RB")    )
                    {
                        avaliblePlayers.add(filteredOutActivePlayers.get(i));
                        filteredOutActivePlayers.remove(i);
                        i--;                   
                    }
                }
            }
            if ( count >= 4 ) {
                count -= 4;
                for ( int i = 0; i < filteredOutActivePlayers.size(); i++) {
                    player = (NFL_Player)filteredOutActivePlayers.get(i);
                    if ( player.getPlayersPosition().equalsIgnoreCase("QB")    )
                    {
                        avaliblePlayers.add(filteredOutActivePlayers.get(i));
                        filteredOutActivePlayers.remove(i);
                        i--;                   
                    }
                }
            }
       }
    }
    public void filterSelectedPlayers (int count) {
        
        NFL_Player player;
        
        // Reset filter by hiding all players and clearing avalible players list.
        filteredOutSelectedPlayers.addAll(selectedPlayers);
        selectedPlayers.clear();
        
        // do filtering for side of field selestion
        if (count <= 3 ) {
            switch (count) {
                case 1: 
                    for (int i = 0; i < filteredOutSelectedPlayers.size(); i++) {
                        if ( filteredOutSelectedPlayers.get(i) instanceof Offensive_NFL_Player ){
                            selectedPlayers.add(filteredOutSelectedPlayers.get(i));
                            filteredOutSelectedPlayers.remove(i);
                            i--;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < filteredOutSelectedPlayers.size(); i++) {
                        if ( filteredOutSelectedPlayers.get(i) instanceof Defensive_NFL_Player ){
                            selectedPlayers.add(filteredOutSelectedPlayers.get(i));
                            filteredOutSelectedPlayers.remove(i);
                            i--;
                        }
                    }
                    break;
                case 3:
                    selectedPlayers.addAll(filteredOutSelectedPlayers);
                    filteredOutSelectedPlayers.clear();
                    break;                
            }
        }
        else {
            if ( count >= 512 ) {
                count -= 512;
                for ( int i = 0; i < filteredOutSelectedPlayers.size(); i++) {
                    player = (NFL_Player)filteredOutSelectedPlayers.get(i);
                    if ( player.getPlayersPosition().equalsIgnoreCase("FS") || 
                         player.getPlayersPosition().equalsIgnoreCase("SS") || 
                         player.getPlayersPosition().equalsIgnoreCase("CB") || 
                         player.getPlayersPosition().equalsIgnoreCase("DB") || 
                         player.getPlayersPosition().equalsIgnoreCase("SAF")   )
                    {
                        selectedPlayers.add(filteredOutSelectedPlayers.get(i));
                        filteredOutSelectedPlayers.remove(i);
                        i--;                   
                    }
                }
            }
            if ( count >= 256 ) {
                count -= 256;
                for ( int i = 0; i < filteredOutSelectedPlayers.size(); i++) {
                    player = (NFL_Player)filteredOutSelectedPlayers.get(i);
                    if ( player.getPlayersPosition().equalsIgnoreCase("MLB") || 
                         player.getPlayersPosition().equalsIgnoreCase("ILB") || 
                         player.getPlayersPosition().equalsIgnoreCase("OLB")   )
                    {
                        selectedPlayers.add(filteredOutSelectedPlayers.get(i));
                        filteredOutSelectedPlayers.remove(i);
                        i--;                   
                    }
                }
            }
             if ( count >= 128 ) {
                count -= 128;
                for ( int i = 0; i < filteredOutSelectedPlayers.size(); i++) {
                    player = (NFL_Player)filteredOutSelectedPlayers.get(i);
                    if ( player.getPlayersPosition().equalsIgnoreCase("DE") || 
                         player.getPlayersPosition().equalsIgnoreCase("DT") || 
                         player.getPlayersPosition().equalsIgnoreCase("NT")    )
                    {
                        selectedPlayers.add(filteredOutSelectedPlayers.get(i));
                        filteredOutSelectedPlayers.remove(i);
                        i--;                   
                    }
                }
             }
            if ( count >= 64 ) {
                count -= 64;
                for ( int i = 0; i < filteredOutSelectedPlayers.size(); i++) {
                    player = (NFL_Player)filteredOutSelectedPlayers.get(i);
                    if ( player.getPlayersPosition().equalsIgnoreCase("C") || 
                         player.getPlayersPosition().equalsIgnoreCase("OG") || 
                         player.getPlayersPosition().equalsIgnoreCase("OT")    )
                    {
                        selectedPlayers.add(filteredOutSelectedPlayers.get(i));
                        filteredOutSelectedPlayers.remove(i);
                        i--;                   
                    }
                }
            }
            if ( count >= 32 ) {
                count -= 32;
                for ( int i = 0; i < filteredOutSelectedPlayers.size(); i++) {
                    player = (NFL_Player)filteredOutSelectedPlayers.get(i);
                    if ( player.getPlayersPosition().equalsIgnoreCase("TE")    )
                    {
                        selectedPlayers.add(filteredOutSelectedPlayers.get(i));
                        filteredOutSelectedPlayers.remove(i);
                        i--;                   
                    }
                }
            }
            if ( count >= 16 ) {
                count -= 16;
                for ( int i = 0; i < filteredOutSelectedPlayers.size(); i++) {
                    player = (NFL_Player)filteredOutSelectedPlayers.get(i);
                    if ( player.getPlayersPosition().equalsIgnoreCase("WR")    )
                    {
                        selectedPlayers.add(filteredOutSelectedPlayers.get(i));
                        filteredOutSelectedPlayers.remove(i);
                        i--;                   
                    }
                }
            }
            if ( count >= 8 ) {
                count -= 8;
                for ( int i = 0; i < filteredOutSelectedPlayers.size(); i++) {
                    player = (NFL_Player)filteredOutSelectedPlayers.get(i);
                    if ( player.getPlayersPosition().equalsIgnoreCase("RB")    )
                    {
                        selectedPlayers.add(filteredOutSelectedPlayers.get(i));
                        filteredOutSelectedPlayers.remove(i);
                        i--;                   
                    }
                }
            }
            if ( count >= 4 ) {
                count -= 4;
                for ( int i = 0; i < filteredOutSelectedPlayers.size(); i++) {
                    player = (NFL_Player)filteredOutSelectedPlayers.get(i);
                    if ( player.getPlayersPosition().equalsIgnoreCase("QB")    )
                    {
                        selectedPlayers.add(filteredOutSelectedPlayers.get(i));
                        filteredOutSelectedPlayers.remove(i);
                        i--;                   
                    }
                }
            }
       }
    }
    public void sortPlayersByName () {
        avaliblePlayers.sort(Comparator.comparing(NFL_Player::getName));
    }
    public void sortPlayersByNumber () {
        avaliblePlayers.sort(Comparator.comparing(NFL_Player::getPlayersNumber));      
    }
    public void sortPlayersByPosition () {
        avaliblePlayers.sort(Comparator.comparing(NFL_Player::getPlayersPosition));        
    }
    public void viewPlayerStatDetails(NFL_Player player) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void raisePlayersPriority(String playersName) {
        NFL_Player player;
        for (int i = 0; i < selectedPlayers.size(); i++) {
            player = (NFL_Player) selectedPlayers.get(i);
            if ( player.getName().equals(playersName) && i != 0 ) {
                selectedPlayers.remove(i);
                selectedPlayers.add(i-1, player);
                return;
            }
        }
    }
    public void lowerPlayersPriority(String playersName) {
        NFL_Player player;
        for (int i = 0; i < selectedPlayers.size(); i++) {
            player = (NFL_Player) selectedPlayers.get(i);
            if ( player.getName().equals(playersName) ) {
                selectedPlayers.remove(i);
                selectedPlayers.add(i+1, player);
                return;
            }
        }
    }

    @Override
    public String toString() {
        NFL_Player player;
        String returnString = "";
        returnString += avaliblePlayers.size() + " total avalible players remaining.\n";
        for (int i = 0; i < avaliblePlayers.size(); i++) {
            player = (NFL_Player) avaliblePlayers.get(i);
            returnString += player.getPlayersNumber() + " " + player.getPlayersPosition() + " " + player.getName() + "\n";
        }
        returnString += "\n" + selectedPlayers.size() + " total players selected for the team.\n";
        for (int i = 0; i < selectedPlayers.size(); i++) {
            player = (NFL_Player) selectedPlayers.get(i);
            returnString += player.getPlayersNumber() + " " + player.getPlayersPosition() + " " + player.getName() + "\n";
        }
        return returnString;
    }


}
