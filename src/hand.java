public class hand {
    private card[] cards = new card[7]; // drawing 7 cards without bust is automatic win
    private int cursor = 0; // track cards in hand

    hand(){}

    public void hit(card card){ // add new card to hand
        cards[cursor++] = card;
    }

    public card[] get_hand(){
        return cards;
    }

    public card last_card(){
        return cards[cursor - 1];
    }

    public int score(){
        int value = 0;
        int aces = 0;

        for(card c : cards){
            if (c != null){
                if(c.get_rank() == 1){
                    aces++;
                    value = value + 1;
                }
                else if(c.get_rank() >= 10){
                    value = value + 10;
                }
                else {
                    value = value + c.get_rank();
                }
            }
        }

        if(aces > 0 && value + 10 <= 21){
            value = value + 10;
        }

        return value;
    }

    public boolean bust(){
        return score() > 21;
    }
}
