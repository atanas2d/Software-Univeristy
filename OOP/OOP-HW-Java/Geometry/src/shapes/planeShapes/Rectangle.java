package shapes.planeShapes;

import java.util.Arrays;

public class Rectangle extends PlaneShape {
	private double height;
	private double width;

	public Rectangle(double[] vertices, double height, double width)
			throws Exception {
		super(vertices);
		
	}
	
	public double getHeight() {
		return height;
	}


	public void setHeight(double height) throws Exception {
		if (height <= 0) {
			throw new Exception("Height should be positive.");
		}
		this.height = height;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) throws Exception {
		if (width <= 0) {
			throw new Exception("Width should be positive.");
		}
		this.width = width;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override 
	public String toString() {
		return "Rectangle with height: " + this.height 
				+ ", widht: " + this.width
				+ ", vertexCoordinates: " + Arrays.toString(this.vertices)
				+ ", Perimeter: " 	+ this.getPerimeter() 
				+ ", Area: " + this.getArea();
	}


}
