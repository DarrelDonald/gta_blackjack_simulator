public class dealer_hand extends hand{
    private card[] cards = new card[12]; // maximum of 12 cards are possible without 17 or higher
    private boolean soft = false;
    private int cursor = 0;


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
            soft = true;
            value = value + 10;
        }
        else{
            soft = false;
        }

        return value;
    }

    public boolean stop(){
        return score() >= 17;
    }

    public void hit(card card){ // add new card to hand
        cards[cursor++] = card;
    }

    public card last_card(){
        return cards[cursor - 1];
    }
}
