package blackjack;

import java.util.Locale;
import java.util.Scanner;

public class BlackJack {

    static Game game = new Game();

    public static void main(String[] args) {
        GUI gui = new GUI();
        game.generate();
        game.setInfo();
        gui.runGUI(game.deck,
                game.players[0].getHand(),
                game.players[1].getHand(),
                game.players[2].getHand(),
                game.players[3].getHand());

        playersTurn(gui);
        game.updateGameScore();
        addCardToDealer(gui);
       if (checkGame()==-1){
           System.out.println("push");
       }
       else  {
           System.out.println(game.players[checkGame()]);
       }
    }


    public static void playersTurn(GUI gui) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        for (int i = 0; i < 3; i++) {

            while (!input.toLowerCase().equals("stand")&& game.players[i].score<21) {
                System.out.println("player no." + (i + 1) + "{Hit/Stand}");
                input = scanner.next();
                if (input.toLowerCase().equals("hit")) {
                    addCardToPlayer(i, gui);
                }
            }
        }

    }

    public static void addCardToPlayer(int index, GUI gui) {

        Card card = game.draw();
        game.players[index].addCard(card);
        gui.updatePlayerHand(card, index);

    }



    public static void addCardToDealer(GUI gui) {
        while (game.players[3].score < game.highScores ) {
            Card card = game.draw();
            game.players[3].addCard(card);
            gui.updateDealerHand(card, game.deck);
        }
        }
        public static int checkGame(){
         if (game.players[3].score > game.highScores ) {
             return 3 ;
         }
             int highscore =0 ;
        int winner = -1 ;
        for (int i =0 ; i<3; i++)
        {
            if (game.players[i].score== game.highScores){
                highscore++ ;
                winner= i ;

            }


        }
            if (highscore >1){
                return -1 ;
            }

            return winner ;

        }

}
