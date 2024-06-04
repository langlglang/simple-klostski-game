public class Block {
  private String color;
  private String name;
  private int height;
  private int width;
  private int col;
  private int row;
  public Block(String name, int height, int width, int row, int col, String color){
    this.color = color;
    this.name = name;
    this.height = height;
    this.width = width;
    this.col = col;
    this.row = row;
  }
  public int getCol(){
    return col;
  }
  public int getRow(){
    return row;
  }
  public void right(){
    col++; 
  } 
  public void left(){
    col--;
  }
  public void down(){
    row++;
  }
  public void up(){
    row--;
  }
  public int getHeight(){
    return height;
  }
  public int getWidth(){
    return width;
  }
  public String getColor(){
    return color;
  }
  public String getName(){
    return name;
  }
 
      
}