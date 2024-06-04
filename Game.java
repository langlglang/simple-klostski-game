//this will probably be your Game class!
import java.util.Scanner;
import java.util.ArrayList;
public class Game {
  
  
    private GameBoard board;
    private int nRows;
    private int nCols;
    private ArrayList<Block> blocks;
    public static final String green = "🟩";
    public static final String king = "👑";
    public static final String blue = "🟦";
    public static final String yellow = "🟨";
    public static final String purple = "🟪";
    public static final String brown = "🟫";
    public static final String black = "⬛";
    public static final String orange = "🟧";
    public static final String white = "⬜";
    public static final String red = "🟥";

  

  Scanner scan = new Scanner(System.in);

  public Game(){

    //scan for 4 different options
    nRows = 5;
    nCols=4;
    board = new GameBoard(4,1,4,2);
    blocks = new ArrayList<Block>();
    setUp();
    board.populateBoard(blocks);

  }

  public void setUp(){
    blocks.add(new Block("green",2,1,0,0,green)); //1 by 2
    blocks.add(new Block("king",2,2,0,1,king)); //Trying to get this guy out
    blocks.add(new Block("blue",2,1,0,3,blue)); 
    blocks.add(new Block("yellow",2,1,2,0,yellow)); 
    blocks.add(new Block("purple",1,2,2,1,purple));
    blocks.add(new Block("orange",2,1,2,3,orange));
    blocks.add(new Block("black",1,1,4,0,black));
    blocks.add(new Block("brown",1,1,3,1,brown));
    blocks.add(new Block("white",1,1,3,2,white));
    blocks.add(new Block("red",1,1,4,3,red));

  
}




  public Block findBlockByName(ArrayList<Block> b, String name){
        for(Block blo : b){
          if(blo.getName().equals(name))
            return blo;
        }
        return null;

    }
  public int findBlockIndex(ArrayList<Block> b, String name){
      for(int i = 0; i<b.size(); i++){
        if(b.get(i).getName().equals(name))
          return i;
      }
      return -1;

  }

        
  
  public boolean hasWon(){
    Block block = findBlockByName(blocks, "king");
    if(block.getRow()==3&&block.getCol()==1){
      System.out.println("GG you won");
    return true;
    }
  return false;
  }


public void printBoard(){
  for(int row = 0; row<5; row++){
    for(int col = 0; col<4; col++){
      System.out.print(board.getBoard()[row][col]);
    }
  System.out.println();
  }


    
}


public void shiftLeft(Block b){
  int col = b.getCol();
  int row = b.getRow();
  int height = b.getHeight();
  int width = b.getWidth();
  if(col==0 || !board.isEmptyBlock(row, col-1) || (!board.isEmptyBlock(row + height-1,col-1))){
    System.out.println("Invalid Move");
    return;
  }
  b.left();
  if(height>1){
    board.setEmptyBlock1col(col+width-1);
    board.setEmptyBlock2col(col+width-1);

  }

  else{
    board.emptyLeft(col, width, row);
  }
}
  public void shiftRight(Block b){
    int col = b.getCol();
    int row = b.getRow();
    int height = b.getHeight();
    int width = b.getWidth();
    int index = findBlockIndex(blocks, b.getName());
    if(col+width>=4 || !board.isEmptyBlock(row,col+width) || (!board.isEmptyBlock(row+height-1, col+width))){
      System.out.println("Invalid Move");
      return;
    }
    b.right();
    if(height>1){
      board.setEmptyBlock1col(col);
      board.setEmptyBlock2col(col);

    }
    else{
      board.emptyRight(col, row, width);
    }
    blocks.set(index, b);
  }
  public void shiftUp(Block b){
    int col = b.getCol();
    int row = b.getRow();
    int height = b.getHeight();
    int width = b.getWidth();
    int index = findBlockIndex(blocks, b.getName());
    if(!board.isEmptyBlock(row-1,col) || !board.isEmptyBlock(row-1, col+width-1)){
    System.out.println("Invalid Move");
      return;
    }
    b.up();
    if(width>1){
      board.setEmptyBlock1row(row+height-1);
      board.setEmptyBlock2row(row+height-1);
    }
    else{
      board.emptyUp(col, row, height);
    }
    
  }
  public void shiftDown(Block b){
    int col = b.getCol();
    int row = b.getRow();
    int height = b.getHeight();
    int width = b.getWidth();
    int index = findBlockIndex(blocks, b.getName());
    if(!board.isEmptyBlock(row+height,col) || !board.isEmptyBlock(row+height,col+width-1)){
      System.out.println("Invalid Move");
      return;
        }
      b.down();
      blocks.set(index, b);
      if(width>1){
        board.setEmptyBlock1row(row);
        board.setEmptyBlock2row(row);
      }
      else{
        board.emptyDown(col, row, height);
      }
      return;
     
      
  }
  public void gamePlay(){
    
    
    String color = scan.nextLine();
    while(!(color.equals("green") || color.equals("king") || color.equals("blue") || color.equals("yellow") || color.equals("purple") || color.equals("orange") || color.equals("black") || color.equals("brown") || color.equals("red") || color.equals("white"))){
      System.out.println("Enter a valid color");
      color = scan.nextLine();
    }
    String direction = scan.nextLine();
    Block  b = findBlockByName(blocks, color);
    if(direction.equals("left")){
      shiftLeft(b);
    }
    else if(direction.equals("right")){
      shiftRight(b);
    }
    else if(direction.equals("up")){
      shiftUp(b);
    }
    else if(direction.equals("down")){
      shiftDown(b);
    }
    else{
      System.out.println("Enter a valid move");
    }
    board.populateBoard(blocks);
      
    }
}
  









