import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Egg {
	private int row , col;//行，列
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	private static Random r = new Random();
	public Egg(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public Egg(){
		this.reAppear();
	}
	
	public void reAppear(){
		this.setCol(r.nextInt(Yard.COLS));
		this.setRow(r.nextInt(Yard.ROWS-4)+4);//防止出现在标题栏内
	}
	public Rectangle getRect(){
		return new Rectangle(col* Yard.BLOCK_SIZE, row * Yard.BLOCK_SIZE, Yard.BLOCK_SIZE, Yard.BLOCK_SIZE);
	}
	public void draw(Graphics g){
		g.fillOval( col* Yard.BLOCK_SIZE, row * Yard.BLOCK_SIZE, Yard.BLOCK_SIZE, Yard.BLOCK_SIZE);
	}
}
