package shapes.planeShapes;

import java.util.Arrays;

public class Circle extends PlaneShape {
	
	private double radius;
	
	public Circle(double[] vertices, double radius) throws Exception {
		super(vertices);
		this.setRadius(radius);
	}
	
	public void setRadius(double radius) throws Exception {
		if (radius <= 0) {
			throw new Exception("Radius should be positive.");			
		}
		
		this.radius = radius;
	}

	@Override
	public double getPerimeter() {
		double perimeter = 2 * Math.PI * this.radius;
		return perimeter;
	}

	@Override
	public double getArea() {
		double area = Math.PI * this.radius * this.radius;
		return area;
	}
	
	@Override
	public String toString() {
		return "Circle with radius " + this.radius 
				+ ", vertices: " + Arrays.toString(this.vertices)
				+ ", Perimeter: " + this.getPerimeter() 
				+ ", Area: " + this.getArea()
				+ "]";
	}
}
