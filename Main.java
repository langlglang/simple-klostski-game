import java.util.Scanner; 
import java.util.ArrayList;
public class Main{
  public static void main(String[] args) {
    Game game = new Game();
    System.out.println("Welcome to our Game!\nThe Goal is to move the king piece out of the board by sliding it to the bottom.\nSlide the other pieces out of the way to make way to win!\nTo choose the piece you want to move, type in the color of the peice you want to move(\"green\", \"red\", \"blue\", \"yellow\", \"purple\", \"brown\", \"black\", \"orange\", \"white\", or \"king\" and on the next line type \"left\", \"right\", \"up\", or \"down\" to make the cooresponding move.\nYou win by getting the king to the middle of the bottom row.\nGood Luck! (You will need it)");
    int movesLeft =600;
    Scanner scan = new Scanner(System.in);
    while(!game.hasWon()){
      if(movesLeft<1){
        System.out.println("You Lose :(");
        break;
      }
      System.out.println("you have " +movesLeft+" moves left");
      game.printBoard();
      game.gamePlay();  
      movesLeft--;
    }
    System.out.println("Congrats!!");
  }
}
    
    









    
  