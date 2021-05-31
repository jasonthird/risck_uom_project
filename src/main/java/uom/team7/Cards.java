package uom.team7;

import java.util.Arrays;
import java.util.Random;

public class Cards {
    private  int[] numberCards;

    public Cards(){
        // 0 = troop , 1 = cavalry , 2 = artillery
        numberCards = new int[3];
        Arrays.fill(numberCards,0);
    }


    //Add the defeated players cards to the winner(defPlayer = dead)
    public void winnerTakesCards(Cards defCards){
        for(int i = 0; i < this.numberCards.length; i++){
            this.numberCards[i] += defCards.getCards()[i];
        }
    }

    //Check if the player has more cards than limit
    public boolean fullHandCheck(){
        int sum = 0;
        for (int numberCard : numberCards) {
            sum += numberCard;
            if (sum >= 5) return true;
        }
        return false;
    }

    //The player takes only one card if he won until the end of attack phase
    public boolean winCard(boolean wonCard) {
        if ( wonCard ) {
            Random r = new Random();
            numberCards[r.nextInt(3)]++;
        }
        return false;
    }

    //Remove the selected amount of cards from players hand to redeem them
    public int redeemCards(int t, int c, int a, World world){
        int[] rCards = new int[3];
        rCards[0] = t;
        rCards[1] = c;
        rCards[2] = a;
        int total = 0;
        //trade cards one of each type,check if the player has that amount of cards
        if( (rCards[0] == rCards[1] ) && (rCards[0] == rCards[2]) && (rCards[0] > 0) ){
            if( (numberCards[0] >= rCards[0]) && (numberCards[1] >= rCards[0]) && (numberCards[2] >= rCards[0]) ){
                System.out.println("You Trade same:" + rCards[0] * 3 + " cards.");
                numberCards[0] -= rCards[0];
                numberCards[1] -= rCards[1];
                numberCards[2] -= rCards[2];
                for(int i=0; i < rCards[0]; i++) {
                    total += world.getNumOfTrades();
                    world.setNumOfTrades(world.numOfTrades + 2);
                }

                return  total ;
            }
        }

        //trade 3 cards of the same type,check if the player has that amount of cards
        for (int i = 0; i < 3; i++) {
            if ( (rCards[i] != 0) && (rCards[i] % 3) == 0 && (numberCards[i] >= 3)  ){
                    numberCards[i] -= rCards[i];
                    total += (world.getNumOfTrades() * (rCards[i] / 3) );
                    System.out.println("You Trade:" + rCards[i]  + " cards.");
                    world.setNumOfTrades(world.numOfTrades += 2 * (rCards[i] / 3));
            }
            if( i == 2 ){ return total; }
        }
        if((rCards[0] == rCards[1] ) && (rCards[0] == rCards[2]) && (rCards[0] ==0) ){
            return 0;
        }
        return  total;
    }

    public int[] getCards() {
        return numberCards;
    }

    public void addCards(int type,int num){ numberCards[type] += num; }

}