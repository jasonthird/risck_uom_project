package uom.team7;

import java.util.*;

public class Country {

    private final String name;
    int numTroops;
    private Player owner;
    Set<Country> adjacentCountries; //*


    public Country (String name) {
        this.name = name;
        numTroops = 1;
    }


    //Add numTroops to the currently country(fortify)
    public void addNumTroops(int numTroops){
        numTroops += numTroops;
    }

    //Remove numTroops from the currently country after 1.fortify or 2.attack result
    public void removeNumTroops(int numTroops){
        numTroops -= numTroops;
    }

    /*Setters & Getters*/
    public String getName() {
        return name;
    }

    public int getNumTroops() {
        return numTroops;
    }

    public void setNumTroops(int numSoldiers) {
        this.numTroops += numSoldiers;
    }

    public void setOwner(Player owner){
        this.owner = owner;
    }

    public Player getOwner(){
        return owner;
    }

    public String toString(){
        return  this.name ;
    }
}
