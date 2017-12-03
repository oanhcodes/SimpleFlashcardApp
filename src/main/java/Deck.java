import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Deck {


    private Stack<Card> theDeck;

    public Deck() {
        theDeck= new Stack<Card>();

    }
    //add single card to the deck
    public void addCard(Card card){
        theDeck.push(card);
    }

    // add multiple cards to the deck
    public void addCards(ArrayList<Card> Cards){
        for(int i=0; i<Cards.size(); i++){
            addCard(Cards.get(i));
        }
    }

    //retrieve single card from deck
    public Card retrieveCard(){
        return theDeck.pop();
    }

    public int getSize(){
        return theDeck.size();
    }

    public Boolean checkComplete(){

    }


    public Card getCard(int index){
        return theDeck.get(index);
    }
}
