import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String [] args) throws FileNotFoundException{
        File movieFile = new File("movies.txt");
        Scanner fscanner = new Scanner(movieFile);
        Scanner in = new Scanner(System.in);
        String line = "";
        String letter;

        while(fscanner.hasNextLine()){
            line += fscanner.nextLine().toLowerCase() + "-";
        }
        String [] moviesList = line.split("-");

        Game game = new Game(moviesList);
        game.startNewGame();

        while(!game.hasWon() && game.getWrongLetters() < 10){
            System.out.println("You are guessing:" + game.getSecretTitle());
            System.out.println("You have guessed (" + game.getWrongLetters() + " wrong letters:" + game.getGuessedLetters());
            System.out.println("Guess a letter:");
            letter = in.nextLine();
            if(!letter.isEmpty()){
                letter = letter.substring(0, 1);
            }
            else{
                continue;
            }
            game.guessLetter(letter);
        }

        if(game.hasWon()){
            System.out.println("You found the movie!");
            System.out.println(game.getMovie());
        }
        else{
            System.out.println("Sorry you lost.");
        }
    }
}
