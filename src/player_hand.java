public class player_hand {
    private card[] cards = new card[7]; // drawing 7 cards without bust is automatic win
    private int cursor = 0; // track cards in hand
    player_hand(){}
    public void hit(card card){ // add new card to hand
        cards[cursor++] = card;
    }
    public card[] get_player_hand(){
        return cards;
    }
}
