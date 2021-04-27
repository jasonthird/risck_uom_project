package uom.team7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/* Player object which represents the information pertaining to
 * a player in the game
 */

public class Player {
    Cards cards;
    int unsedTroops;
    boolean dead;
    boolean won;
    List<Country> countriesOwned;

    public Player(){
        cards = new Cards();
        unsedTroops = 0;
        dead = false;
        won = false;
        countriesOwned = new ArrayList<Country>();
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
    public int getUnsedTroops() {
        return unsedTroops;
    }

    public void setUnsedTroops(int unsedTroops) {
        this.unsedTroops = unsedTroops;
    }

}
