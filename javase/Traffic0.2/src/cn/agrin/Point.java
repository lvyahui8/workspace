/**
 * 
 */
package cn.agrin;

/**
 * @author Agrin
 *
 */
public class Point {
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Point(int x,int y){
		moveTo(x, y);
	}
	/**
	 * @param x
	 * @param y
	 * ÒÆ¶¯µãµ½£¨x£¬y£©
	 */
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
