public class dealer_hand {
    private card[] cards = new card[17]; // maximum of 11 cards are possible without bust
    private int cursor = 0; // track cards in hand
    dealer_hand(){}
    public void hit(card card){ // add new card to hand
        cards[cursor++] = card;
    }
    public card[] get_player_hand(){
        return cards;
    }
}
