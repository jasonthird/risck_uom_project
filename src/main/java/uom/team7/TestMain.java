package uom.team7;
import java.util.*;


public class TestMain {

    public static void main(String[] args) {

        //Initialize game components
        int numPlayers = 2;
        int numOfTrades = 4;

        Player[] players = initializePlayers(numPlayers);
        Country[] countries = initializeCountries();
        initializeCountryOwners(countries,players,numPlayers);

        Cards redeemCards = new Cards();
        redeemCards.addCards(0,1);
        redeemCards.addCards(1,1);
        redeemCards.addCards(2,1);
        players[1].cards.addCards(0,0);
        players[1].cards.addCards(1,0);
        players[1].cards.addCards(2,0);
        numOfTrades = players[1].cards.redeemCards(redeemCards,numOfTrades);
        numOfTrades = players[1].cards.redeemCards(redeemCards,numOfTrades);




    }




    //initialize the players and their cards in hand
    public static Player[] initializePlayers(int numPlayers) {
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
                unsedTroops = 20;
                break;
            default : throw new IllegalStateException("Unexpected value: " + numPlayers);
        }
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player();
            players[i].setUnsedTroops(unsedTroops);
        }
        return players;
    }

    //Create a list of countries and all the 42 countries
    public  static Country[] initializeCountries(){
        Country[] countries = new Country[42];
        countries[0] = new Country("Alaska");
        countries[1] = new Country("Alberta" );
        countries[2] = new Country("Central America");
        countries[3] = new Country("Eastern United States");
        countries[4] = new Country("Greenland");
        countries[5] = new Country("Northwest Territory");
        countries[6] = new Country("Ontario");
        countries[7] = new Country("Quebec");
        countries[8] = new Country("Western United States");
        countries[9] = new Country("Venezuela");
        countries[10] = new Country("Brazil");
        countries[11] = new Country("Peru");
        countries[12] = new Country("Argentina");
        countries[13] = new Country("Great Britain");
        countries[14] = new Country("Iceland");
        countries[15] = new Country("Northern Europe");
        countries[16] = new Country("Scandinavia");
        countries[17] = new Country("Ukraine");
        countries[18] = new Country("Southern Europe");
        countries[19] = new Country("Western Europe");
        countries[20] = new Country("Madagascar");
        countries[21] = new Country("Egypt");
        countries[22] = new Country("North Africa");
        countries[23] = new Country("East Africa");
        countries[24] = new Country("Congo");
        countries[25] = new Country("South Africa");
        countries[26] = new Country("Middle East");
        countries[27] = new Country("Afghanistan");
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
        countries[39] = new Country("Western Australia");
        countries[40] = new Country("Eastern Australia");
        countries[41] = new Country("New Guinea");


        countries[0].adjacentCountries = new TreeSet<>();
        countries[0].adjacentCountries.add(countries[1]);
        countries[0].adjacentCountries.add(countries[5]);
        countries[0].adjacentCountries.add(countries[36]);

        countries[1].adjacentCountries = new TreeSet<>();
        countries[1].adjacentCountries.add(countries[5]);
        countries[1].adjacentCountries.add(countries[6]);
        countries[1].adjacentCountries.add(countries[8]);

        countries[2].adjacentCountries = new TreeSet<>();
        countries[2].adjacentCountries.add(countries[3]);
        countries[2].adjacentCountries.add(countries[8]);
        countries[2].adjacentCountries.add(countries[9]);

        countries[3].adjacentCountries = new TreeSet<>();
        countries[3].adjacentCountries.add(countries[6]);
        countries[3].adjacentCountries.add(countries[7]);
        countries[3].adjacentCountries.add(countries[8]);

        countries[4].adjacentCountries = new TreeSet<>();
        countries[4].adjacentCountries.add(countries[5]);
        countries[4].adjacentCountries.add(countries[6]);
        countries[4].adjacentCountries.add(countries[7]);
        countries[4].adjacentCountries.add(countries[14]);

        countries[5].adjacentCountries = new TreeSet<>();
        countries[5].adjacentCountries.add(countries[6]);

        countries[6].adjacentCountries = new TreeSet<>();
        countries[6].adjacentCountries.add(countries[7]);
        countries[6].adjacentCountries.add(countries[8]);

        countries[7].adjacentCountries = new TreeSet<>();

        countries[8].adjacentCountries = new TreeSet<>();

        countries[9].adjacentCountries = new TreeSet<>();
        countries[9].adjacentCountries.add(countries[10]);
        countries[9].adjacentCountries.add(countries[11]);

        countries[10].adjacentCountries = new TreeSet<>();
        countries[10].adjacentCountries.add(countries[11]);
        countries[10].adjacentCountries.add(countries[12]);
        countries[10].adjacentCountries.add(countries[22]);

        countries[11].adjacentCountries = new TreeSet<>();
        countries[11].adjacentCountries.add(countries[12]);

        countries[12].adjacentCountries = new TreeSet<>();

        countries[13].adjacentCountries = new TreeSet<>();
        countries[13].adjacentCountries.add(countries[14]);
        countries[13].adjacentCountries.add(countries[15]);
        countries[13].adjacentCountries.add(countries[16]);
        countries[13].adjacentCountries.add(countries[19]);

        countries[14].adjacentCountries = new TreeSet<>();

        countries[15].adjacentCountries = new TreeSet<>();
        countries[15].adjacentCountries.add(countries[16]);
        countries[15].adjacentCountries.add(countries[17]);
        countries[15].adjacentCountries.add(countries[18]);
        countries[15].adjacentCountries.add(countries[19]);

        countries[16].adjacentCountries = new TreeSet<>();
        countries[16].adjacentCountries.add(countries[17]);

        countries[17].adjacentCountries = new TreeSet<>();
        countries[17].adjacentCountries.add(countries[18]);
        countries[17].adjacentCountries.add(countries[26]);
        countries[17].adjacentCountries.add(countries[27]);
        countries[17].adjacentCountries.add(countries[28]);

        countries[18].adjacentCountries = new TreeSet<>();
        countries[18].adjacentCountries.add(countries[19]);
        countries[18].adjacentCountries.add(countries[21]);
        countries[18].adjacentCountries.add(countries[22]);
        countries[18].adjacentCountries.add(countries[26]);

        countries[19].adjacentCountries = new TreeSet<>();
        countries[19].adjacentCountries.add(countries[22]);

        countries[20].adjacentCountries = new TreeSet<>();
        countries[20].adjacentCountries.add(countries[23]);
        countries[20].adjacentCountries.add(countries[25]);

        countries[21].adjacentCountries = new TreeSet<>();
        countries[21].adjacentCountries.add(countries[22]);
        countries[21].adjacentCountries.add(countries[23]);
        countries[21].adjacentCountries.add(countries[26]);

        countries[22].adjacentCountries = new TreeSet<>();
        countries[22].adjacentCountries.add(countries[23]);
        countries[22].adjacentCountries.add(countries[24]);

        countries[23].adjacentCountries = new TreeSet<>();
        countries[23].adjacentCountries.add(countries[24]);
        countries[23].adjacentCountries.add(countries[25]);
        countries[23].adjacentCountries.add(countries[26]);

        countries[24].adjacentCountries = new TreeSet<>();
        countries[24].adjacentCountries.add(countries[25]);

        countries[25].adjacentCountries = new TreeSet<>();

        countries[26].adjacentCountries = new TreeSet<>();
        countries[26].adjacentCountries.add(countries[27]);
        countries[26].adjacentCountries.add(countries[29]);

        countries[27].adjacentCountries = new TreeSet<>();
        countries[27].adjacentCountries.add(countries[28]);
        countries[27].adjacentCountries.add(countries[29]);
        countries[27].adjacentCountries.add(countries[30]);

        countries[28].adjacentCountries = new TreeSet<>();
        countries[28].adjacentCountries.add(countries[30]);
        countries[28].adjacentCountries.add(countries[31]);

        countries[29].adjacentCountries = new TreeSet<>();
        countries[29].adjacentCountries.add(countries[30]);
        countries[29].adjacentCountries.add(countries[32]);

        countries[30].adjacentCountries = new TreeSet<>();
        countries[30].adjacentCountries.add(countries[31]);
        countries[30].adjacentCountries.add(countries[32]);
        countries[30].adjacentCountries.add(countries[33]);

        countries[31].adjacentCountries = new TreeSet<>();
        countries[31].adjacentCountries.add(countries[33]);
        countries[31].adjacentCountries.add(countries[34]);
        countries[31].adjacentCountries.add(countries[35]);

        countries[32].adjacentCountries = new TreeSet<>();
        countries[32].adjacentCountries.add(countries[38]);

        countries[33].adjacentCountries = new TreeSet<>();
        countries[33].adjacentCountries.add(countries[34]);
        countries[33].adjacentCountries.add(countries[36]);
        countries[33].adjacentCountries.add(countries[37]);

        countries[34].adjacentCountries = new TreeSet<>();
        countries[34].adjacentCountries.add(countries[35]);
        countries[34].adjacentCountries.add(countries[36]);

        countries[35].adjacentCountries = new TreeSet<>();
        countries[35].adjacentCountries.add(countries[36]);

        countries[36].adjacentCountries = new TreeSet<>();
        countries[36].adjacentCountries.add(countries[37]);

        countries[37].adjacentCountries = new TreeSet<>();

        countries[38].adjacentCountries = new TreeSet<>();
        countries[38].adjacentCountries.add(countries[39]);
        countries[38].adjacentCountries.add(countries[41]);

        countries[39].adjacentCountries = new TreeSet<>();
        countries[39].adjacentCountries.add(countries[40]);
        countries[39].adjacentCountries.add(countries[41]);

        countries[40].adjacentCountries = new TreeSet<>();
        countries[40].adjacentCountries.add(countries[41]);

        countries[41].adjacentCountries = new TreeSet<>();

        for (Country country : countries) {
            for (Country c : country.adjacentCountries) {
                c.adjacentCountries.add(country);
            }
        }

        return  countries;
    }

    //initialize country owners
    public static void initializeCountryOwners(Country[] countries, Player[] players, int numPlayers){
        Collections.shuffle(Arrays.asList(countries));
        int playerID = 0;
        for (Country country : countries) {
            players[playerID].countriesOwned.add(country);
            playerID = (playerID + 1) % numPlayers;
        }
    }

    //Implementation of attack*
    public void attack(Country own,Country enemy){
        int[] attacker = new int[3];
        int[] defender = new int[2];

        for(int i = 0; i < Math.min(attacker.length, own.numTroops - 1); i++){
            attacker[i] = roll();
        }
        for(int i = 0; i < Math.min(defender.length, enemy.numTroops - 1); i++){
            defender[i] = roll();
        }

        Arrays.sort(attacker);
        Arrays.sort(defender);

        for(int i = 0; i < 2; i++) {
            if (attacker[i] == defender[i]) {
                own.removeNumTroops(1);
            } else if (attacker[i] > defender[i]) {
                enemy.removeNumTroops(1);
            } else {
                own.removeNumTroops(1);
            }
            attackResult(own,enemy);
        }
    }

    //Calculate the attack result*
    public void attackResult(Country own,Country enemy){
        if(enemy.numTroops == 0) {
           // own.getOwner().winCard();
            own.getOwner().addCountry(enemy);
            enemy.getOwner().removeCountry(enemy);
        }
    }

    //check win condition
    public void checkWin(Player [] players) {
        int countDead = 0;
        for (Player p : players) {
            if (p.statusCheck()) {
                countDead++;
            }
        }
        if (players.length-1 == countDead) {
            System.exit(0);
        }
    }

    //calculate the number of troops the player receives at the begging of the turn
    public static void updateUnsedTroops(Player player) {
        int numTroops = (player.countriesOwned.size() / 3); // + continent_bonus?
        player.setUnsedTroops(Math.max(3, numTroops));

    }

    //Simulates the die roll.Returns a number 1-6.
    public static int roll(){
        return (int) Math.ceil(6 * Math.random());
    }

}

