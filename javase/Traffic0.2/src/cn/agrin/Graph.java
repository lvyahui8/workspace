package cn.agrin;

import java.awt.Graphics;
/**
 * 
 * @author Agrin
 * Graph接口。需要绘制到窗口的对象都应实现此接口
 */
public interface Graph {
	/**
	 * 
	 * @param g
	 * 绘制Graphics
	 */
	public void draw(Graphics g);
}
