package uom.team7;

import java.util.*;

public class World{

    public Player[] players;
    public Country[] countries;
    public int numOfTrades ;


    public World(int numPlayers) {
        numOfTrades = 6;
        players = initializePlayers(numPlayers);
        countries = initializeCountries();
        initializeCountryOwners(countries, players, numPlayers);
    }

    //create the players and initialize the unsedTroops
    public  Player[] initializePlayers(int numPlayers) {
        int unsedTroops;
        Player[] players = new Player[numPlayers];
        switch (numPlayers) {
            case 2:
                unsedTroops = 5;
                break;
            case 3:
                unsedTroops = 35;
                break;
            case 4:
                unsedTroops = 30;
                break;
            case 5:
                unsedTroops = 25;
                break;
            case 6:
                unsedTroops = 20;
                break;
            default : throw new IllegalStateException("Unexpected value: " + numPlayers);
        }
        String playerColor;
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player();
            players[i].setId(i);

            players[i].setUnsedTroops(unsedTroops);
            switch (i){
                case 0:
                    playerColor = "#1057c9";
                    break;
                case 1:
                    playerColor = "#c91010";
                    break;
                case 2:
                    playerColor = "#c9c910";
                    break;
                case 3:
                    playerColor = "#10c913";
                    break;
                case 4:
                    playerColor = "#c97310";
                    break;
                case 5:
                    playerColor = "#5d10c9";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + i);
            }
            players[i].setColor(playerColor);
        }

        return players;
    }

    //Create a list of countries and all the 42 countries
    public   Country[] initializeCountries(){
        Country[] countries = new Country[42];
        countries[0] = new Country("Alaska",0);
        countries[1] = new Country("Alberta",1 );
        countries[2] = new Country("CentralAmerica",2);
        countries[3] = new Country("EastUS",3);
        countries[4] = new Country("Greenland",4);
        countries[5] = new Country("NorthTerritory",5);
        countries[6] = new Country("Ontario",6);
        countries[7] = new Country("Quebec",7);
        countries[8] = new Country("WestUS",8);
        countries[9] = new Country("Venezuela",9);
        countries[10] = new Country("Brazil",10);
        countries[11] = new Country("Peru",11);
        countries[12] = new Country("Argentina",12);
        countries[13] = new Country("Britain",13);
        countries[14] = new Country("Iceland",14);
        countries[15] = new Country("NorthEurope",15);
        countries[16] = new Country("Scandinavia",16);
        countries[17] = new Country("Ukraine",17);
        countries[18] = new Country("SouthEurope",18);
        countries[19] = new Country("WestEurope",19);
        countries[20] = new Country("Madagascar",20);
        countries[21] = new Country("Egypt",21);
        countries[22] = new Country("NorthAfrica",22);
        countries[23] = new Country("EastAfrica",23);
        countries[24] = new Country("Congo",24);
        countries[25] = new Country("SouthAfrica",25);
        countries[26] = new Country("MiddleEast",26);
        countries[27] = new Country("Kazakhstan",27);
        countries[28] = new Country("Ural",28);
        countries[29] = new Country("India",29);
        countries[30] = new Country("China",30);
        countries[31] = new Country("Siberia",31);
        countries[32] = new Country("Siam",32);
        countries[33] = new Country("Mongolia",33);
        countries[34] = new Country("Irkutsk",34);
        countries[35] = new Country("Yakutsk",35);
        countries[36] = new Country("Kamchatka",36);
        countries[37] = new Country("Japan",37);
        countries[38] = new Country("Indonesia",38);
        countries[39] = new Country("WestAustralia",39);
        countries[40] = new Country("EastAustralia",40);
        countries[41] = new Country("NewGuinea",41);

        //Alaska
        countries[0].adjacentCountries = new LinkedList<>();
        countries[0].adjacentCountries.add(countries[1]);
        countries[0].adjacentCountries.add(countries[5]);
        countries[0].adjacentCountries.add(countries[36]);
        //Alberta
        countries[1].adjacentCountries = new LinkedList<>();
        countries[1].adjacentCountries.add(countries[0]);
        countries[1].adjacentCountries.add(countries[5]);
        countries[1].adjacentCountries.add(countries[6]);
        countries[1].adjacentCountries.add(countries[8]);

        //CentralAmerica
        countries[2].adjacentCountries = new LinkedList<>();
        countries[2].adjacentCountries.add(countries[3]);
        countries[2].adjacentCountries.add(countries[8]);
        countries[2].adjacentCountries.add(countries[9]);

        //EastUS
        countries[3].adjacentCountries = new LinkedList<>();
        countries[3].adjacentCountries.add(countries[2]);
        countries[3].adjacentCountries.add(countries[6]);
        countries[3].adjacentCountries.add(countries[7]);
        countries[3].adjacentCountries.add(countries[8]);

        //Greenland
        countries[4].adjacentCountries = new LinkedList<>();
        countries[4].adjacentCountries.add(countries[5]);
        countries[4].adjacentCountries.add(countries[6]);
        countries[4].adjacentCountries.add(countries[7]);
        countries[4].adjacentCountries.add(countries[14]);

        //NorthTerritory
        countries[5].adjacentCountries = new LinkedList<>();
        countries[5].adjacentCountries.add(countries[0]);
        countries[5].adjacentCountries.add(countries[1]);
        countries[5].adjacentCountries.add(countries[4]);
        countries[5].adjacentCountries.add(countries[6]);

        //Ontario
        countries[6].adjacentCountries = new LinkedList<>();
        countries[6].adjacentCountries.add(countries[1]);
        countries[6].adjacentCountries.add(countries[3]);
        countries[6].adjacentCountries.add(countries[4]);
        countries[6].adjacentCountries.add(countries[5]);
        countries[6].adjacentCountries.add(countries[7]);
        countries[6].adjacentCountries.add(countries[8]);
        //Quebec
        countries[7].adjacentCountries = new LinkedList<>();
        countries[7].adjacentCountries.add(countries[3]);
        countries[7].adjacentCountries.add(countries[4]);
        countries[7].adjacentCountries.add(countries[6]);

        //WestUS
        countries[8].adjacentCountries = new LinkedList<>();
        countries[8].adjacentCountries.add(countries[1]);
        countries[8].adjacentCountries.add(countries[2]);
        countries[8].adjacentCountries.add(countries[3]);
        countries[8].adjacentCountries.add(countries[6]);

        //Venezuela
        countries[9].adjacentCountries = new LinkedList<>();
        countries[9].adjacentCountries.add(countries[2]);
        countries[9].adjacentCountries.add(countries[10]);
        countries[9].adjacentCountries.add(countries[11]);


        //Brazil
        countries[10].adjacentCountries = new LinkedList<>();
        countries[10].adjacentCountries.add(countries[9]);
        countries[10].adjacentCountries.add(countries[11]);
        countries[10].adjacentCountries.add(countries[12]);
        countries[10].adjacentCountries.add(countries[22]);

        //Peru
        countries[11].adjacentCountries = new LinkedList<>();
        countries[11].adjacentCountries.add(countries[9]);
        countries[11].adjacentCountries.add(countries[10]);
        countries[11].adjacentCountries.add(countries[12]);


        //Argentina
        countries[12].adjacentCountries = new LinkedList<>();
        countries[12].adjacentCountries.add(countries[10]);
        countries[12].adjacentCountries.add(countries[11]);

        //Britain
        countries[13].adjacentCountries = new LinkedList<>();
        countries[13].adjacentCountries.add(countries[14]);
        countries[13].adjacentCountries.add(countries[15]);
        countries[13].adjacentCountries.add(countries[16]);
        countries[13].adjacentCountries.add(countries[19]);

        //Iceland
        countries[14].adjacentCountries = new LinkedList<>();
        countries[14].adjacentCountries.add(countries[4]);
        countries[14].adjacentCountries.add(countries[13]);
        countries[14].adjacentCountries.add(countries[16]);

        //NorthEurope
        countries[15].adjacentCountries = new LinkedList<>();
        countries[15].adjacentCountries.add(countries[13]);
        countries[15].adjacentCountries.add(countries[16]);
        countries[15].adjacentCountries.add(countries[17]);
        countries[15].adjacentCountries.add(countries[18]);
        countries[15].adjacentCountries.add(countries[19]);

        //Scandinavia
        countries[16].adjacentCountries = new LinkedList<>();
        countries[16].adjacentCountries.add(countries[13]);
        countries[16].adjacentCountries.add(countries[14]);
        countries[16].adjacentCountries.add(countries[15]);
        countries[16].adjacentCountries.add(countries[17]);

        //Ukraine
        countries[17].adjacentCountries = new LinkedList<>();
        countries[17].adjacentCountries.add(countries[15]);
        countries[17].adjacentCountries.add(countries[16]);
        countries[17].adjacentCountries.add(countries[18]);
        countries[17].adjacentCountries.add(countries[26]);
        countries[17].adjacentCountries.add(countries[27]);
        countries[17].adjacentCountries.add(countries[28]);


        //SouthEurope
        countries[18].adjacentCountries = new LinkedList<>();
        countries[18].adjacentCountries.add(countries[15]);
        countries[18].adjacentCountries.add(countries[19]);
        countries[18].adjacentCountries.add(countries[21]);
        countries[18].adjacentCountries.add(countries[22]);
        countries[18].adjacentCountries.add(countries[26]);

        //WestEurope
        countries[19].adjacentCountries = new LinkedList<>();
        countries[19].adjacentCountries.add(countries[13]);
        countries[19].adjacentCountries.add(countries[15]);
        countries[19].adjacentCountries.add(countries[18]);
        countries[19].adjacentCountries.add(countries[22]);

        //Madagascar
        countries[20].adjacentCountries = new LinkedList<>();
        countries[20].adjacentCountries.add(countries[23]);
        countries[20].adjacentCountries.add(countries[25]);

        //Egypt
        countries[21].adjacentCountries = new LinkedList<>();
        countries[21].adjacentCountries.add(countries[18]);
        countries[21].adjacentCountries.add(countries[22]);
        countries[21].adjacentCountries.add(countries[23]);
        countries[21].adjacentCountries.add(countries[26]);

        //NorthAfrica
        countries[22].adjacentCountries = new LinkedList<>();
        countries[22].adjacentCountries.add(countries[10]);
        countries[22].adjacentCountries.add(countries[19]);
        countries[22].adjacentCountries.add(countries[21]);
        countries[22].adjacentCountries.add(countries[23]);
        countries[22].adjacentCountries.add(countries[24]);

        //EastAfrica
        countries[23].adjacentCountries = new LinkedList<>();
        countries[23].adjacentCountries.add(countries[21]);
        countries[23].adjacentCountries.add(countries[22]);
        countries[23].adjacentCountries.add(countries[20]);
        countries[23].adjacentCountries.add(countries[24]);
        countries[23].adjacentCountries.add(countries[25]);
        countries[23].adjacentCountries.add(countries[26]);

        //Congo
        countries[24].adjacentCountries = new LinkedList<>();
        countries[24].adjacentCountries.add(countries[22]);
        countries[24].adjacentCountries.add(countries[23]);
        countries[24].adjacentCountries.add(countries[25]);

        //SouthAfrica
        countries[25].adjacentCountries = new LinkedList<>();
        countries[25].adjacentCountries.add(countries[20]);
        countries[25].adjacentCountries.add(countries[23]);
        countries[25].adjacentCountries.add(countries[24]);

        //MiddleEast
        countries[26].adjacentCountries = new LinkedList<>();
        countries[26].adjacentCountries.add(countries[17]);
        countries[26].adjacentCountries.add(countries[18]);
        countries[26].adjacentCountries.add(countries[21]);
        countries[26].adjacentCountries.add(countries[23]);
        countries[26].adjacentCountries.add(countries[27]);
        countries[26].adjacentCountries.add(countries[29]);

        //Kazakhstan
        countries[27].adjacentCountries = new LinkedList<>();
        countries[27].adjacentCountries.add(countries[17]);
        countries[27].adjacentCountries.add(countries[26]);
        countries[27].adjacentCountries.add(countries[28]);
        countries[27].adjacentCountries.add(countries[29]);
        countries[27].adjacentCountries.add(countries[30]);

        //Ural
        countries[28].adjacentCountries = new LinkedList<>();
        countries[28].adjacentCountries.add(countries[17]);
        countries[28].adjacentCountries.add(countries[27]);
        countries[28].adjacentCountries.add(countries[30]);
        countries[28].adjacentCountries.add(countries[31]);

        //India
        countries[29].adjacentCountries = new LinkedList<>();
        countries[29].adjacentCountries.add(countries[26]);
        countries[29].adjacentCountries.add(countries[27]);
        countries[29].adjacentCountries.add(countries[30]);
        countries[29].adjacentCountries.add(countries[32]);

        //China
        countries[30].adjacentCountries = new LinkedList<>();
        countries[30].adjacentCountries.add(countries[28]);
        countries[30].adjacentCountries.add(countries[27]);
        countries[30].adjacentCountries.add(countries[29]);
        countries[30].adjacentCountries.add(countries[31]);
        countries[30].adjacentCountries.add(countries[32]);
        countries[30].adjacentCountries.add(countries[33]);

        //Siberia
        countries[31].adjacentCountries = new LinkedList<>();
        countries[31].adjacentCountries.add(countries[28]);
        countries[31].adjacentCountries.add(countries[30]);
        countries[31].adjacentCountries.add(countries[33]);
        countries[31].adjacentCountries.add(countries[34]);
        countries[31].adjacentCountries.add(countries[35]);

        //Siam
        countries[32].adjacentCountries = new LinkedList<>();
        countries[32].adjacentCountries.add(countries[29]);
        countries[32].adjacentCountries.add(countries[30]);
        countries[32].adjacentCountries.add(countries[38]);

        //Mongolia
        countries[33].adjacentCountries = new LinkedList<>();
        countries[33].adjacentCountries.add(countries[30]);
        countries[33].adjacentCountries.add(countries[31]);
        countries[33].adjacentCountries.add(countries[34]);
        countries[33].adjacentCountries.add(countries[36]);
        countries[33].adjacentCountries.add(countries[37]);

        //Irkutsk
        countries[34].adjacentCountries = new LinkedList<>();
        countries[34].adjacentCountries.add(countries[31]);
        countries[34].adjacentCountries.add(countries[33]);
        countries[34].adjacentCountries.add(countries[35]);
        countries[34].adjacentCountries.add(countries[36]);

        //Yakutsk
        countries[35].adjacentCountries = new LinkedList<>();
        countries[35].adjacentCountries.add(countries[31]);
        countries[35].adjacentCountries.add(countries[34]);
        countries[35].adjacentCountries.add(countries[36]);

        //Kamchatka
        countries[36].adjacentCountries = new LinkedList<>();
        countries[36].adjacentCountries.add(countries[0]);
        countries[36].adjacentCountries.add(countries[34]);
        countries[36].adjacentCountries.add(countries[35]);
        countries[36].adjacentCountries.add(countries[37]);

        //Japan
        countries[37].adjacentCountries = new LinkedList<>();
        countries[37].adjacentCountries.add(countries[33]);
        countries[37].adjacentCountries.add(countries[36]);

        //Indonesia
        countries[38].adjacentCountries = new LinkedList<>();
        countries[38].adjacentCountries.add(countries[32]);
        countries[38].adjacentCountries.add(countries[39]);
        countries[38].adjacentCountries.add(countries[41]);

        //WestAustralia
        countries[39].adjacentCountries = new LinkedList<>();
        countries[39].adjacentCountries.add(countries[38]);
        countries[39].adjacentCountries.add(countries[40]);
        countries[39].adjacentCountries.add(countries[41]);

        //EastAustralia
        countries[40].adjacentCountries = new LinkedList<>();
        countries[40].adjacentCountries.add(countries[39]);
        countries[40].adjacentCountries.add(countries[41]);

        //NewGuinea
        countries[41].adjacentCountries = new LinkedList<>();
        countries[41].adjacentCountries.add(countries[38]);
        countries[41].adjacentCountries.add(countries[39]);
        countries[41].adjacentCountries.add(countries[40]);

        for (Country country : countries) {
            for (Country c : country.adjacentCountries) {

                System.out.println(c.toString() + "  :  " + c.getAdjacentCountries());
            }
        }

        return  countries;
    }
    public  boolean findPath(Country country,Country country2){
        for(Country c: country.getAdjacentCountries()){
            if(c.getOwner() == country.getOwner()) {
                if (c.getAdjacentCountries().contains(country2)){ return  true;}
                for (Country c1 : c.getAdjacentCountries()) {
                    if (c1.getAdjacentCountries().contains(country2) && c1.getOwner() == country.getOwner()) {
                        return true;
                    }
                    if(c1.equals(country2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //initialize country owners
    public  void initializeCountryOwners(Country[] countries, Player[] players, int numPlayers){
        Collections.shuffle(Arrays.asList(countries));
        int playerID = 0;
        for (Country country : countries) {
            players[playerID].countriesOwned.add(country);
            country.setOwner(players[playerID]);
            playerID = (playerID + 1) % numPlayers;
        }
    }

    //calculate the number of troops the player receives at the begging of the turn
    public  void updateUnsedTroops(Player player) {
        int numTroops = (player.countriesOwned.size() / 3); // + continent_bonus?
        player.setUnsedTroops(Math.max(3, numTroops));
    }

    //fortify one country only
    public void fortify(Country country, int numOfTroops){
        country.setNumTroops(numOfTroops);
        country.getOwner().removeTroops(numOfTroops);
    }

    //move a number of troops from a country to country2
    public void moveArmy(Country country,Country country2,int numOfTroops,Player player){
        if(moveArmyCheck(country,country2,player)){
            country2.setNumTroops(numOfTroops);
            country.removeNumTroops(numOfTroops);
        }
    }

    //Constrains for moveArmy
    public boolean moveArmyCheck(Country country,Country country2,Player player){
        return  player.countriesOwned.contains(country)  &&
                player.countriesOwned.contains(country2) &&
                country != country2  &&  country.getNumTroops()  > 1;
    }

    //Implementation of attack
    public boolean attack(Country own,Country enemy){
        Integer[] attacker = new Integer[3];
        Integer[] defender = new Integer[2];

        for(int i = 0; i < 3; i++){
            attacker[i] = roll();
        }
        for(int i = 0; i < 2; i++){
            defender[i] = roll();
        }

        Arrays.sort(attacker, Collections.reverseOrder());

        Arrays.sort(defender,Collections.reverseOrder());


        for(int i = 0; i < 2; i++) {
            if (attacker[i].equals(defender[i])) {
                System.out.println("Equals:attacker loose");
                own.removeNumTroops(1);
            } else if (attacker[i] > defender[i]) {
                System.out.println("Attacker win");
                enemy.removeNumTroops(1);
            } else {
                System.out.println("Attacker loose");
                own.removeNumTroops(1);
            }

        }
        return attackResult(own,enemy);
    }

    public Country findCountry(String country){
        for (Country c : countries) {
            if (country.equals(c.toString())) {
                return c;
            }
        }
        return null;
    }

    //Constrains for attack
    public boolean attackCheck(Country attacker,Country defender,Player player){
        return  player.countriesOwned.contains(attacker)  &&
                !player.countriesOwned.contains(defender) &&
                attacker.getNumTroops() >= 3;
    }

    //Calculate the attack result
    public boolean attackResult(Country own, Country enemy){
        if(enemy.numTroops <= 0) {
            if(!own.getOwner().isWonCard()){
                own.getOwner().setWonCard(true);
            }
            if(enemy.getOwner().isDead()){
                own.getOwner().cards.winnerTakesCards(enemy.getOwner().cards);
            }
            enemy.setNum(1);
            own.setNum(own.getNumTroops()-1);
            own.getOwner().countriesOwned.add(enemy);
            enemy.getOwner().countriesOwned.remove(enemy);
            enemy.setOwner(own.getOwner());
            return true;
        }
        return false;
    }

    //check win condition
    public boolean checkWin(Player [] players) {
        int countDead = 0;
        for (Player p : players) {
            if (p.isDead()) {
                countDead++;
            }
        }
        return players.length - 1 == countDead;
    }

    //Simulates the die roll.Returns a number 1-6.
    public static int roll(){
        return (int) Math.ceil(6 * Math.random());
    }

    public int getNumOfTrades() { return numOfTrades; }

    public Player[] getPlayers() { return players; }

    public void setNumOfTrades(int numOfTrades) {
        this.numOfTrades = numOfTrades;
    }

}
