package uom.team7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/* Player object which represents the information pertaining to
 * a player in the game
 */

public class Player {

    int[] cards;
    int unsedTroops;
    boolean dead;
    boolean wonCard;
    List<Country> countriesOwned;

    public Player(){
        cards = new int[3];
        unsedTroops = 0;
        dead = false;
        wonCard = false;
        countriesOwned = new ArrayList<Country>();
    }

    // 0 = troop , 1 = cavalary , 2 = artilery
    public void initialHand(){
        for (int i=0; i < cards.length; i++){
            cards[i] = 0;
        }
    }

    //Add the defeated players cards to the winner(defPlayer = dead)
    public void addCards(Player defPLayer){
        for(int i = 0; i < defPLayer.cards.length; i++){
            cards[i] += defPLayer.cards[i];

        }
    }

    //Remove the selected ammount of cards from players hand to redeem them *
    public void redeemCards(int i){

        cards[i] += 1;

    }

    //Check if the player has more cards than limit
    public boolean fullHandCheck(){
        int sum = 0;
        for (int i = 0; i < cards.length; i++) {
            sum += cards[i];
            if (sum >= 5)  return true;
        }
        return false;
    }

    //Check if the player has no owned countries left(dead)
    public boolean statusCheck(){
        if(countriesOwned.isEmpty()){
            return  dead = true;
        }
        else{
            return  dead = false;
        }
    }

    //The player takes only one card if he won until the end of attack phase
    public void winCard() {
        if (!wonCard) {
            Random r = new Random();
            cards[r.nextInt(3)]++;
            wonCard = true;
        }
    }

    public void removeTroops(int numTroops){
        unsedTroops -= numTroops;
    }

    public void addCountry(Country country){
        countriesOwned.add(country);
    }

    public void removeCountry(Country country){
        countriesOwned.remove(country);
    }



    /*Setters & Getters*/
    public int[] getCards() {
        return cards;
    }

    public boolean isWonCard() {
        return wonCard;
    }

    public int getUnsedTroops() {
        return unsedTroops;
    }

    public void setUnsedTroops(int unsedTroops) {
        this.unsedTroops = unsedTroops;
    }

    public String toString() {
        return Integer.toString(cards[0])+Integer.toString(cards[1])+Integer.toString(cards[2]);

    }
}
