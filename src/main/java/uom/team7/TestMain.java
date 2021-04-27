package uom.team7;
import java.util.Arrays;
import java.util.Collections;


public class TestMain {

    public static void main(String[] args) {

        //Initialize game components
        int numPlayers = 6;// User.getSelectedValue
        Player[] players = initializePlayers(numPlayers);
        Country[] countries = initializeCountries();
        initializeCountryOwners(countries,players,numPlayers);


        for (int i = 0; i <numPlayers; i++){
            System.out.println("Player "+ i+ players[i].countriesOwned.toString() + " Troops to place " + players[1].toString());

        }

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
        };
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player();
            players[i].initialHand();
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
        return  countries;
    }

    //initialize country owners
    public static void initializeCountryOwners(Country[] countries, Player[] players, int numPlayers){
        Collections.shuffle(Arrays.asList(countries));
        int playerID = 0;
        for (Country country : countries) {
            players[playerID].countriesOwned.add(country);// πρεπει να δινουμε τυχαια τις περιοχες
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
            own.getOwner().winCard();
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
        int numTroops;
        numTroops = (player.countriesOwned.size() / 3); // + continent_bonus?
        player.setUnsedTroops(Math.max(3, numTroops));

    }

    //Simulates the die roll.Returns a number 1-6.
    public static int roll(){
        return (int) Math.ceil(6 * Math.random());
    }

}

