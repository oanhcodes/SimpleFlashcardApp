import java.util.ArrayList;
import java.util.List;

public class Deck {


    private List<Card> theDeck;
    private List<Card> incorrect;

    public Deck() {
        theDeck= new ArrayList<Card>();
        incorrect= new ArrayList<Card>();
    }
    //add single card to the deck
    public void addCard(Card card){
        theDeck.add(card);

    }
    // add multiple cards to the deck
    public void addCards(ArrayList<Card> Cards){
        for(int i=0; i<Cards.size(); i++){
            addCard(Cards.get(i));
        }
    }
    //remove single card from deck
    public Card removeCard(int index){
        return theDeck.remove(index);
    }

    public int getSize(){
        return theDeck.size();
    }

    public Card getCard(int index){
        return theDeck.get(index);
    }
}
