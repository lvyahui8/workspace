import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Snake {

	private Node head = null;
	private Node tail = null;
	private int size = 0;
	private long speed = 300;

	public Snake() {
		Node node = new Node(20, 20, Dir.L);
		this.head = node;
		this.tail = node;
		size = 1;
		new Thread(new Move()).start();
	}

	public void addToTail() {
		Node node = null;
		switch (tail.dir) {
		case L: {
			node = new Node(tail.row, tail.col + 1, tail.dir);
			break;
		}
		case U: {
			node = new Node(tail.row + 1, tail.col, tail.dir);
			break;
		}
		case R: {
			node = new Node(tail.row, tail.col - 1, tail.dir);
			break;
		}
		case D: {
			node = new Node(tail.row - 1, tail.col, tail.dir);
			break;
		}
		default: {
			break;
		}
		}
		this.tail.next = node;
		node.pre = this.tail;
		this.tail = node;
		size++;
	}

	public void addToHead() {
		Node node = null;
		switch (tail.dir) {
		case L: {
			node = new Node(head.row, head.col - 1, head.dir);
			break;
		}
		case U: {
			node = new Node(head.row - 1, head.col, head.dir);
			break;
		}
		case R: {
			node = new Node(head.row, head.col + 1, head.dir);
			break;
		}
		case D: {
			node = new Node(head.row + 1, head.col, head.dir);
			break;
		}
		default: {
			break;
		}
		}
		node.next = head;
		head.pre = node;
		head = node;
		size++;
	}

	public void eat(Egg e) {
		if (this.getRect().contains(e.getRect())) {
			e.reAppear();
			this.addToTail();
			this.speedUp();
		}
	}

	private void speedUp() {
		// TODO 自动生成的方法存根
		if (this.speed >= 40)
			this.speed -= 40;
	}

	public Rectangle getRect() {
		return new Rectangle(head.col * Yard.BLOCK_SIZE, head.row
				* Yard.BLOCK_SIZE, Yard.BLOCK_SIZE, Yard.BLOCK_SIZE);
	}

	public void draw(Graphics g) {
		Node node = head;
		while (node != null) {
			// System.out.println("debug");
			node.draw(g);
			node = node.next;
		}
	}

	private class Node {
		int w = Yard.BLOCK_SIZE;
		int h = Yard.BLOCK_SIZE;
		int row, col;
		Dir dir;
		Node pre = null;
		Node next = null;

		Node(int row, int col, Dir dir) {
			this.row = row;
			this.col = col;
			this.dir = dir;
		}

		void draw(Graphics g) {
			Color oldC = g.getColor();
			g.setColor(Color.RED);
			// System.out.println("debug");
			// g.fillRect(12, 12, 12, 12);
			g.fillRect(col * w, row * h, w, h);
			g.setColor(oldC);
		}
	}

	public void move() {
		addToHead();
		deleteFromTail();
		checkDead();
	}

	private void checkDead() {
		// TODO 自动生成的方法存根
		if (head.row < 2 || head.row > Yard.ROWS || head.col < 0
				|| head.col > Yard.COLS) {
			System.exit(0);
		}
	}

	private void deleteFromTail() {
		// TODO 自动生成的方法存根
		this.tail = this.tail.pre;
		this.tail.next = null;
	}

	public void key(KeyEvent e) {
		// TODO 自动生成的方法存根
		// TODO 自动生成的方法存根
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT: {
			if (head.dir != Dir.R)
				head.dir = Dir.L;
			break;
		}
		case KeyEvent.VK_UP: {
			if (head.dir != Dir.D)
				head.dir = Dir.U;
			break;
		}
		case KeyEvent.VK_RIGHT: {
			if (head.dir != Dir.L)
				head.dir = Dir.R;
			break;
		}
		case KeyEvent.VK_DOWN: {
			if (head.dir != Dir.U)
				head.dir = Dir.D;
			break;
		}
		default:
			break;
		}
	}

	private class Move implements Runnable {

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			while (true) {
				try {
					Thread.sleep(speed);
					move();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}

	}
}
