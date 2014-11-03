import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Apple {
	public static Random RandomGenerator;
	private Point appleLocation;
	private Color appleColor;
	
	public Apple(Snake s) {
		appleLocation = createApple(s);
		appleColor = Color.RED;		
	}
	
	private Point createApple(Snake s) {
		RandomGenerator = new Random();
		int x = RandomGenerator.nextInt(30) * 20; 
		int y = RandomGenerator.nextInt(30) * 20;
		for (Point snakePoint : s.snakeBody) {
			if (x == snakePoint.getX() || y == snakePoint.getY()) {
				return createApple(s);				
			}
		}
		return new Point(x, y);
	}
	
	public void drawApple(Graphics g){
		appleLocation.drawSnake(g, appleColor);
	}	
	
	public Point getPoint(){
		return appleLocation;
	}
}
