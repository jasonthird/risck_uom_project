package uom.team7;


import java.util.Arrays;
import java.util.Random;

public class Cards {
    private int[] numberCards;

    public Cards(){
        // 0 = troop , 1 = cavalary , 2 = artilery
        int[] numberCards = new int[3];
        Arrays.fill(numberCards,0);
    }

    //Add the defeated players cards to the winner(defPlayer = dead)
    public void winnerTakesCards(Cards DefCards){
        for(int i = 0; i < this.numberCards.length; i++){
            this.numberCards[i] += DefCards.getCards()[i];
        }
    }

    //Check if the player has more cards than limit
    public boolean fullHandCheck(){
        int sum = 0;
        for (int i = 0; i < numberCards.length; i++) {
            sum += numberCards[i];
            if (sum >= 5)  return true;
        }
        return false;
    }

    //The player takes only one card if he won until the end of attack phase
    public void winCard(boolean wonCard) {
        if (!wonCard) {
            Random r = new Random();
            numberCards[r.nextInt(3)]++;
            wonCard = true;
        }
    }

    //Remove the selected ammount of cards from players hand to redeem them *
    //If it returns -1 it means that it failed
    public int redeemCards(Cards givenCards, int numOfTrades){
        int RCards[] = givenCards.getCards();
        for (int i=0;i<3;i++){
            if(RCards[i]==3){
                if((numberCards[i]-RCards[i])>=3){
                    numberCards[i]==numberCards[i]-RCards[i];
                    return true;
                }


            }
        }
    }


    //Gets cards xd
    public int[] getCards() {
        return numberCards;
    }
}