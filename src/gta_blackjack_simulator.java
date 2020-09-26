import java.util.Scanner;

public class gta_blackjack_simulator {
    static int NUM_OF_CARDS = 52 * 4; // uses 4 decks with 52 card each

    private static void loss(int bet){
        System.out.print("Player has lost ");
        System.out.print(bet);
        System.out.print(" dollars.");
    }

    private static void win(int bet){
        System.out.print("Player has won ");
        System.out.print(bet);
        System.out.print(" dollars.");
    }

    public static void main(String[] args) {
        int money = 1000;
        boolean playing = true;
        Scanner input = new Scanner(System.in);
        int bet;


        while(playing){
            deck deck = new deck();
            deck.shuffle();
            hand player = new hand();
            dealer_hand dealer = new dealer_hand();

            System.out.println("Enter your bet: ");
            while(true){
                try{
                    bet = input.nextInt();
                    break;
                }catch(Exception e){
                    System.out.println("enter an integer: ");
                }
            }

            System.out.print("The players first card is a ");
            player.hit(deck.mill());
            System.out.print(player.last_card().get_rank());
            System.out.print("\nThe players second card is a ");
            player.hit(deck.mill());
            System.out.print(player.last_card().get_rank());

            System.out.print("\nThe dealers first card is a ");
            dealer.hit(deck.mill());
            System.out.print(dealer.last_card().get_rank());
            dealer.hit(deck.mill());

            boolean stand = false;

            do {
                System.out.println("\nhit, stand, double, or split?");
                Player_Action:
                while (true) {
                    String action = input.next();
                    switch (action) {
                        case "hit":
                            player.hit(deck.mill());
                            System.out.print("Your card is a ");
                            System.out.print(player.last_card().get_rank());
                            break Player_Action;
                        case "stand":
                            stand = true;
                            break Player_Action;
                        case "double":
                            bet = bet * 2;
                            player.hit(deck.mill());
                            System.out.print("Your card is a ");
                            System.out.print(player.last_card().get_rank());
                            stand = true;
                            break Player_Action;
                        case "split":
                            //split
                            break Player_Action;
                        default:
                            System.out.println("enter hit, stand, double, or split");
                            break;
                    }
                }
            // post game
            } while (!player.bust() && !stand);
            if (player.bust()){
                money = money - bet;
                System.out.println("\nBUST!");
                loss(bet);
            }
            else{
                while(!dealer.stop()){
                    dealer.hit(deck.mill());
                    System.out.print("Dealer draws a ");
                    System.out.print(dealer.last_card().get_rank());
                    System.out.print("\n");
                }
                System.out.print("Dealer total: ");
                System.out.print(dealer.score());

                if (dealer.bust()){
                    System.out.println("\nDealer Busts!");
                    win(bet);
                }
                else if (player.score() > dealer.score()){
                    System.out.println("\nPlayer wins!");
                    win(bet);
                }
                else if (player.score() == dealer.score()){
                    System.out.println("\nTie! No money exchanged");
                }
                else{
                    System.out.println("\nDealer wins!");
                    loss(bet);
                }
            }

            System.out.println("\nPlay again? (yes/no): ");
            Play_Again:
            while(true){
                String action = input.next();
                switch (action){
                    case "yes":
                        break Play_Again;
                    case "no":
                        playing = false;
                        System.out.println("Thanks for playing!");
                        break Play_Again;
                    default:
                        System.out.println("Enter yes or no: ");
                }
            }
        }
    }
}
