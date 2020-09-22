public class deck {
    private card[] cards = new card[gta_blackjack_simulator.NUM_OF_CARDS];
    private int cursor = 0;
    deck(){
        for(int i = 0; i < gta_blackjack_simulator.NUM_OF_CARDS; i++){
            cards[i] = new card(i % 13);  // there are 13 ranks
        }
    }
    public void shuffle(){
        deck shuffled_deck = new deck();
        for(int i = 0; i < gta_blackjack_simulator.NUM_OF_CARDS; i++){
            int rand = (int)(Math.random() * 52);
            while(cards[rand].get_rank() > 12){
                rand = (int)(Math.random() * 52);
            }
            shuffled_deck.cards[i] = cards[rand];
            cards[rand] = new card(13);
        }
        cards = shuffled_deck.cards;
    }
    public card mill(){
        return cards[cursor++];
    }
}
