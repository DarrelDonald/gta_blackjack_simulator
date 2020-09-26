public class deck {
    private card[] cards = new card[gta_blackjack_simulator.NUM_OF_CARDS];
    private int cursor = 0;

    deck(){
        for(int i = 0; i < gta_blackjack_simulator.NUM_OF_CARDS; i++){
            cards[i] = new card((i % 13) + 1);  // there are 13 ranks, minimum 1
        }
    }

    public void shuffle(){
        deck shuffled_deck = new deck();
        for(int i = 0; i < gta_blackjack_simulator.NUM_OF_CARDS; i++){
            int rand = (int)(Math.random() * gta_blackjack_simulator.NUM_OF_CARDS);
            while(cards[rand].get_rank() > 13){ // skip cards that have been seen
                rand = (int)(Math.random() * gta_blackjack_simulator.NUM_OF_CARDS);
            }
            shuffled_deck.cards[i] = cards[rand];
            cards[rand] = new card(14); // seen cards have rank greater than highest valid rank
        }
        cards = shuffled_deck.cards;
    }

    public card mill(){
        return cards[cursor++];
    }
}
