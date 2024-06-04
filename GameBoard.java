import java.util.ArrayList;
public class GameBoard{
  private String[][] board;
  private int emptyBlock1row;
  private int emptyBlock1col;
  private int emptyBlock2row;
  private int emptyBlock2col;

  public GameBoard(int row1, int col1, int row2, int col2){
    board = new String[5][4];
    
    emptyBlock1row=row1;
    emptyBlock1col=col1;
    emptyBlock2row=row2;
    emptyBlock2col=col2;
  }
  public int getEmptyBlock1row(){
    return emptyBlock1row;
  }
  public int getEmptyBlock1col(){
    return emptyBlock1col;
  }
  public int getEmptyBlock2row(){
    return emptyBlock2row;
  }
  public int getEmptyBlock2col(){
    return emptyBlock2col;
  }
  public void setEmptyBlock1row(int x){
    emptyBlock1row=x;
  }
  public void setEmptyBlock1col(int x){
    emptyBlock1col=x;
  }
  public void setEmptyBlock2row(int x){
    emptyBlock2row=x;
  }
  public void setEmptyBlock2col(int x){
    emptyBlock2col=x;
  }
  public String[][] getBoard(){
    return board;
  }
  public void emptyRight(int col, int row,int width){
    if(emptyBlock1col==col+width && emptyBlock1row==row)
      emptyBlock1col=col;
    else
      emptyBlock2col=col;
  }
  public void emptyDown(int col, int row, int height){
    if(emptyBlock1col==col &&emptyBlock1row==row+height)
      emptyBlock1row=row;
    else
      emptyBlock2row=row;
  }
  public void emptyUp(int col, int row, int height){
    if(emptyBlock1col==col && emptyBlock1row==row-1)
      emptyBlock1row=row+height-1;
    else
      emptyBlock2row=row+height-1;
  }
  public void emptyLeft(int col, int width, int row){
    if(emptyBlock1col==col-1 && emptyBlock1row==row)
      emptyBlock1col=col+width-1;
    else
      emptyBlock2col=col+width-1;
  }
  public boolean isEmptyBlock(int row, int col){
    if((row<0||row>4)||(col<0||col>3)){
      return false;
    }
    return ((row==emptyBlock1row&&col==emptyBlock1col)||(row==emptyBlock2row&&col==emptyBlock2col));
  }

  public void populateBoard(ArrayList<Block> boards){
    board[emptyBlock1row][emptyBlock1col]= "⭕";
    board[emptyBlock2row][emptyBlock2col]="⭕";
    for (Block block: boards){
      for (int r = block.getRow();r<block.getRow()+block.getHeight();r++){
        for (int c = block.getCol();c<block.getCol()+block.getWidth();c++){
          board[r][c]=block.getColor();
        }
        
      }
    
    }


    
    
  }
 
  




  
}