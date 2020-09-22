public class gta_blackjack_simulator {
    public static int NUM_OF_CARDS = 52 * 4; // uses 4 decks with 52 card each
    public static void main(String[] args) {
        int card_cursor = 0; // tracks the current card
        deck deck = new deck();
        deck.shuffle();
        System.out.println("The players first card is a ");
    }
}
