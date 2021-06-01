package uom.team7;

import java.util.ArrayList;
import java.util.List;

/* Player object which represents the information pertaining to
 * a player in the game
 */

public class Player {
    int id;
    String color;
    Cards cards;
    int unsedTroops;

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    boolean dead;
    boolean wonCard;
    List<Country> countriesOwned;

    public Player(){
        cards = new Cards();
        unsedTroops = 0;
        dead = false;
        countriesOwned = new ArrayList<>();
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

    public void setWonCard(boolean wonCard) {
        this.wonCard = wonCard;
    }

    public void removeTroops(int numTroops){
        if(unsedTroops > 0){ unsedTroops -= numTroops; }
    }

    public void addCountry(Country country){
        countriesOwned.add(country);
    }

    public void removeCountry(Country country){
        countriesOwned.remove(country);
    }



                         /*Setters & Getters*/

    public int getUnsedTroops() { return unsedTroops; }

    public void setUnsedTroops(int unsedTroops) {
        this.unsedTroops += unsedTroops;
    }

    public boolean isOwned(Country country) { return countriesOwned.contains(country); }

    public boolean isWonCard() {
        return wonCard;
    }

    public void setColor(String color1){
        color = color1;
    }

    public String getColor(){
        return color;
    }

    public boolean isDead() { return dead; }

    public void setId(int i){
        this.id = i + 1;
    }
}
