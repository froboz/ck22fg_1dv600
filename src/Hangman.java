		/*
		==============+
		|| //      |
		||//       O
		||/      >---<
		||         |
	    ||     | _/ \_
		+------|======-+
	    |_|====|_______|
		|\|====|\/|/\|\|
		*/
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;
    public class Hangman {
      final static int MAX_TRIES = 6;
      public static void main(String[] args) {
        renderMenu();
      }
      
      private static void renderMenu() {
    
        System.out.println("*********************** ( HANGMAN ) ************************");
        System.out.println("*                                                          *");
        System.out.println("*                    1. Start New Game                     *");
        System.out.println("*                                                          *");
        System.out.println("*                    ==============+                       *");
        System.out.println("*                    || //      |                          *");
        System.out.println("*                    ||//       0                          *");
        System.out.println("*                    ||/                                   *");
        System.out.println("*                    ||                                    *");
        System.out.println("*                    ||     |                              *");
        System.out.println("*                    +------|======-+                      *");
        System.out.println("*                    |_|====|_______|                      *");
        System.out.println("*                    |\\|====|\\/|/\\|\\|                      *");
        System.out.println("*                                                          *");
        System.out.println("************************* ( DEMO ) *************************");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        if (option == 1) {
          startNewGame();
        }
      }
      private static void startNewGame() {
        String sentence = "hello world";
        String revealed = "h e l l o | w o r l d";
        StringBuilder hidden = new StringBuilder("_ _ _ _ _ | _ _ _ _ _");
        /*
        sentence.replaceAll("[a-zA-Z]", "_ ");
        sentence.replaceAll(" ", " | ");
        */
        int tries = 0;
        int guesses = 0;
        boolean game = true;
        do {
          if (tries < MAX_TRIES) {
            System.out.println("Guess "+guesses+": ");
            System.out.println(hidden);						
            Scanner input = new Scanner(System.in);
            String guess = input.nextLine();
            guesses++;
            if (guess.equals(sentence)) {
              game = false;
              win();
            } else {	
              String result = reveal(guess.charAt(0), hidden.toString(), revealed);
              if (!result.equals(hidden)) {
                tries++;					
              }					
              hidden.replace(0, hidden.length(), result);
              if (hidden.toString().equals(revealed)) {
                game = false;
                win();	
              }
            }				
          } else {
            game = false;
            lose();				
          }			
        } while (game && tries < MAX_TRIES);
        if (tries >= MAX_TRIES) {
          lose();
        }
      }
      private static void win() {
        System.out.println("You win!");
      }
      private static void lose() {
        System.out.println("You lose!");
      }	
      
      private static String reveal(Character guess, String hidden, String revealed) {
        StringBuilder result = new StringBuilder(hidden); 
        for (int i = 0; i < revealed.length(); i++ ) {
          if (revealed.charAt(i) == guess) {
            result.setCharAt(i, guess);
          }
        }		
        return result.toString();
      }
    }
    
    