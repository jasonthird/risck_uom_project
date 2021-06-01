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
    public void connectedCountries(Country country,Player player, ArrayList<Country> connectedCountryList) {
        for (Country c : country.getAdjacentCountries()) {
            System.out.println(c.toString());
            if (!connectedCountryList.contains(c) && c.getOwner() == player) {
                connectedCountryList.add(c);
                connectedCountries(c,player,connectedCountryList);
            }
        }
    }


    public ArrayList<Country> listOfConnectedCountries(Country country,Player player) {
        ArrayList<Country> listConnectedCountries = new ArrayList<>();
        connectedCountries(country,player, listConnectedCountries);
        return listConnectedCountries;
    }




    //create the players and initialize the unsedTroops
    public  Player[] initializePlayers(int numPlayers) {
        int unsedTroops;
        Player[] players = new Player[numPlayers];
        switch (numPlayers) {
            case 2:
                unsedTroops = 50;
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
                unsedTroops = 5;
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
        countries[0] = new Country("Alaska");
        countries[1] = new Country("Alberta" );
        countries[2] = new Country("CentralAmerica");
        countries[3] = new Country("EastUS");
        countries[4] = new Country("Greenland");
        countries[5] = new Country("NorthTerritory");
        countries[6] = new Country("Ontario");
        countries[7] = new Country("Quebec");
        countries[8] = new Country("WestUS");
        countries[9] = new Country("Venezuela");
        countries[10] = new Country("Brazil");
        countries[11] = new Country("Peru");
        countries[12] = new Country("Argentina");
        countries[13] = new Country("Britain");
        countries[14] = new Country("Iceland");
        countries[15] = new Country("NorthEurope");
        countries[16] = new Country("Scandinavia");
        countries[17] = new Country("Ukraine");
        countries[18] = new Country("SouthEurope");
        countries[19] = new Country("WestEurope");
        countries[20] = new Country("Madagascar");
        countries[21] = new Country("Egypt");
        countries[22] = new Country("NorthAfrica");
        countries[23] = new Country("EastAfrica");
        countries[24] = new Country("Congo");
        countries[25] = new Country("SouthAfrica");
        countries[26] = new Country("MiddleEast");
        countries[27] = new Country("Kazakhstan");
        countries[28] = new Country("Ural");
        countries[29] = new Country("India");
        countries[30] = new Country("China");
        countries[31] = new Country("Siberia");
        countries[32] = new Country("Siam");
        countries[33] = new Country("Mongolia");
        countries[34] = new Country("Irkutsk");
        countries[35] = new Country("Yakutsk");
        countries[36] = new Country("Kamchatka");
        countries[37] = new Country("Japan");
        countries[38] = new Country("Indonesia");
        countries[39] = new Country("WestAustralia");
        countries[40] = new Country("EastAustralia");
        countries[41] = new Country("NewGuinea");


        countries[0].adjacentCountries = new TreeSet<>();
        countries[0].adjacentCountries.add(countries[1]);
        countries[0].adjacentCountries.add(countries[5]);
        countries[0].adjacentCountries.add(countries[36]);

        countries[1].adjacentCountries = new TreeSet<>();
        countries[1].adjacentCountries.add(countries[5]);
        countries[1].adjacentCountries.add(countries[6]);
        countries[1].adjacentCountries.add(countries[8]);

        countries[2].adjacentCountries = new TreeSet<Country>();
        countries[2].adjacentCountries.add(countries[3]);
        countries[2].adjacentCountries.add(countries[8]);
        countries[2].adjacentCountries.add(countries[9]);

        countries[3].adjacentCountries = new TreeSet<Country>();
        countries[3].adjacentCountries.add(countries[6]);
        countries[3].adjacentCountries.add(countries[7]);
        countries[3].adjacentCountries.add(countries[8]);

        countries[4].adjacentCountries = new TreeSet<Country>();
        countries[4].adjacentCountries.add(countries[5]);
        countries[4].adjacentCountries.add(countries[6]);
        countries[4].adjacentCountries.add(countries[7]);
        countries[4].adjacentCountries.add(countries[14]);

        countries[5].adjacentCountries = new TreeSet<Country>();
        countries[5].adjacentCountries.add(countries[6]);

        countries[6].adjacentCountries = new TreeSet<Country>();
        countries[6].adjacentCountries.add(countries[7]);
        countries[6].adjacentCountries.add(countries[8]);

        countries[7].adjacentCountries = new TreeSet<Country>();

        countries[8].adjacentCountries = new TreeSet<Country>();

        countries[9].adjacentCountries = new TreeSet<Country>();
        countries[9].adjacentCountries.add(countries[10]);
        countries[9].adjacentCountries.add(countries[11]);

        countries[10].adjacentCountries = new TreeSet<Country>();
        countries[10].adjacentCountries.add(countries[11]);
        countries[10].adjacentCountries.add(countries[12]);
        countries[10].adjacentCountries.add(countries[22]);

        countries[11].adjacentCountries = new TreeSet<Country>();
        countries[11].adjacentCountries.add(countries[12]);

        countries[12].adjacentCountries = new TreeSet<Country>();

        countries[13].adjacentCountries = new TreeSet<Country>();
        countries[13].adjacentCountries.add(countries[14]);
        countries[13].adjacentCountries.add(countries[15]);
        countries[13].adjacentCountries.add(countries[16]);
        countries[13].adjacentCountries.add(countries[19]);

        countries[14].adjacentCountries = new TreeSet<Country>();

        countries[15].adjacentCountries = new TreeSet<Country>();
        countries[15].adjacentCountries.add(countries[16]);
        countries[15].adjacentCountries.add(countries[17]);
        countries[15].adjacentCountries.add(countries[18]);
        countries[15].adjacentCountries.add(countries[19]);

        countries[16].adjacentCountries = new TreeSet<Country>();
        countries[16].adjacentCountries.add(countries[17]);

        countries[17].adjacentCountries = new TreeSet<Country>();
        countries[17].adjacentCountries.add(countries[18]);
        countries[17].adjacentCountries.add(countries[26]);
        countries[17].adjacentCountries.add(countries[27]);
        countries[17].adjacentCountries.add(countries[28]);

        countries[18].adjacentCountries = new TreeSet<Country>();
        countries[18].adjacentCountries.add(countries[19]);
        countries[18].adjacentCountries.add(countries[21]);
        countries[18].adjacentCountries.add(countries[22]);
        countries[18].adjacentCountries.add(countries[26]);

        countries[19].adjacentCountries = new TreeSet<Country>();
        countries[19].adjacentCountries.add(countries[22]);

        countries[20].adjacentCountries = new TreeSet<Country>();
        countries[20].adjacentCountries.add(countries[23]);
        countries[20].adjacentCountries.add(countries[25]);

        countries[21].adjacentCountries = new TreeSet<Country>();
        countries[21].adjacentCountries.add(countries[22]);
        countries[21].adjacentCountries.add(countries[23]);
        countries[21].adjacentCountries.add(countries[26]);

        countries[22].adjacentCountries = new TreeSet<Country>();
        countries[22].adjacentCountries.add(countries[23]);
        countries[22].adjacentCountries.add(countries[24]);

        countries[23].adjacentCountries = new TreeSet<Country>();
        countries[23].adjacentCountries.add(countries[24]);
        countries[23].adjacentCountries.add(countries[25]);
        countries[23].adjacentCountries.add(countries[26]);

        countries[24].adjacentCountries = new TreeSet<Country>();
        countries[24].adjacentCountries.add(countries[25]);

        countries[25].adjacentCountries = new TreeSet<Country>();

        countries[26].adjacentCountries = new TreeSet<Country>();
        countries[26].adjacentCountries.add(countries[27]);
        countries[26].adjacentCountries.add(countries[29]);

        countries[27].adjacentCountries = new TreeSet<Country>();
        countries[27].adjacentCountries.add(countries[28]);
        countries[27].adjacentCountries.add(countries[29]);
        countries[27].adjacentCountries.add(countries[30]);

        countries[28].adjacentCountries = new TreeSet<Country>();
        countries[28].adjacentCountries.add(countries[30]);
        countries[28].adjacentCountries.add(countries[31]);

        countries[29].adjacentCountries = new TreeSet<Country>();
        countries[29].adjacentCountries.add(countries[30]);
        countries[29].adjacentCountries.add(countries[32]);

        countries[30].adjacentCountries = new TreeSet<Country>();
        countries[30].adjacentCountries.add(countries[31]);
        countries[30].adjacentCountries.add(countries[32]);
        countries[30].adjacentCountries.add(countries[33]);

        countries[31].adjacentCountries = new TreeSet<Country>();
        countries[31].adjacentCountries.add(countries[33]);
        countries[31].adjacentCountries.add(countries[34]);
        countries[31].adjacentCountries.add(countries[35]);

        countries[32].adjacentCountries = new TreeSet<Country>();
        countries[32].adjacentCountries.add(countries[38]);

        countries[33].adjacentCountries = new TreeSet<Country>();
        countries[33].adjacentCountries.add(countries[34]);
        countries[33].adjacentCountries.add(countries[36]);
        countries[33].adjacentCountries.add(countries[37]);

        countries[34].adjacentCountries = new TreeSet<Country>();
        countries[34].adjacentCountries.add(countries[35]);
        countries[34].adjacentCountries.add(countries[36]);

        countries[35].adjacentCountries = new TreeSet<Country>();
        countries[35].adjacentCountries.add(countries[36]);

        countries[36].adjacentCountries = new TreeSet<Country>();
        countries[36].adjacentCountries.add(countries[37]);

        countries[37].adjacentCountries = new TreeSet<Country>();

        countries[38].adjacentCountries = new TreeSet<Country>();
        countries[38].adjacentCountries.add(countries[39]);
        countries[38].adjacentCountries.add(countries[41]);

        countries[39].adjacentCountries = new TreeSet<Country>();
        countries[39].adjacentCountries.add(countries[40]);
        countries[39].adjacentCountries.add(countries[41]);

        countries[40].adjacentCountries = new TreeSet<Country>();
        countries[40].adjacentCountries.add(countries[41]);

        countries[41].adjacentCountries = new TreeSet<Country>();

        for (Country country : countries) {
            for (Country c : country.adjacentCountries) {
                c.adjacentCountries.add(country);
            }

        }

        return  countries;
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
