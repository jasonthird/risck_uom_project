package uom.team7;

import java.util.*;

public class Country implements Comparable<Country>{

    private final String name;
    int numTroops,id;
    private Player owner;
    LinkedList<Country> adjacentCountries;

    public int getId() {
        return id;
    }

    public Country (String name, int id) {
        this.name = name;
        numTroops = 1;
        this.id = id;
    }

    //Remove numTroops from the currently country after 1.fortify or 2.attack result
    public void removeNumTroops(int numTroops1){
        numTroops -= numTroops1;
    }

                                  /*Setters & Getters*/
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

    public void setNum(int num){ numTroops = num; }

    public LinkedList<Country> getAdjacentCountries() {
        return adjacentCountries;
    }

    public String toString(){
        return  this.name ;
    }

    @Override
    public int compareTo(Country o) {
        return 0;
    }
}
