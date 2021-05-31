package uom.team7;

import java.util.TreeSet;

public class Country implements Comparable<Country>{

    private final String name;
    int numTroops;
    private Player owner;
    TreeSet<Country> adjacentCountries;


    public Country (String name) {
        this.name = name;
        numTroops = 1;
    }

    public TreeSet<Country> getAdjacentCountries() {
        return adjacentCountries;
    }

    public boolean isAdjacent(Country country){
        return adjacentCountries.contains(country);
    }

    //Remove numTroops from the currently country after 1.fortify or 2.attack result
    public void removeNumTroops(int numTroops1){
        numTroops -= numTroops1;
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

    public void setNum(int num){ numTroops = num; }

    public String toString(){
        return  this.name ;
    }

    @Override
    public int compareTo(Country o) {
        return 0;
    }
}
