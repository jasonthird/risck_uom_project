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
    public int redeemCards(Cards givenCards, int numOfTrades){
        int[] rCards = givenCards.getCards();

        //trade 3 cards of the same type,check if the player has that amount of cards
        for (int i = 0; i < 3; i++) {
            if ( (rCards[i] == 3) && (numberCards[i] >= 3) ){
                    numberCards[i] -= rCards[i];
                    return  numOfTrades += 2;
            }
        }

        //trade cards one of each type,check if the player has that amount of cards
        if( (rCards[0] == rCards[1] ) && (rCards[0] == rCards[2]) && (rCards[0] > 0) ){
            if( (numberCards[0] >= rCards[0]) && (numberCards[1] >= rCards[0]) && (numberCards[2] >= rCards[0]) ){
                 numberCards[0] -= rCards[0];
                 numberCards[1] -= rCards[1];
                 numberCards[2] -= rCards[2];
                 return  numOfTrades += 2 * rCards[0];
            }
        }
        //invalid trade
        else{ return 0; }

        return  numOfTrades;
    }

    public int[] getCards() {
        return numberCards;
    }

    public void addCards(int i,int num){ numberCards[i] += num; }

}