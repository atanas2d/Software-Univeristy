package shapes.planeShapes;

import java.util.Arrays;

public class Triangle extends PlaneShape {
	protected double[] secondPointVertices = new double[2];
	protected double[] thirdPointVertices = new double[2];

	public Triangle(double[] firstPointVertices, double[] secondPointVertices, double[] thirdPointVertices) {
		super(firstPointVertices);
		this.secondPointVertices = secondPointVertices;
		this.thirdPointVertices = thirdPointVertices;
	}

	@Override
	public double getPerimeter() {
		double[] sides = this.getSides();
		double perimeter = sides[0] + sides[1] + sides[2];
		return perimeter;
	}

	@Override
	public double getArea() {
		double[] sides = this.getSides();
		double halfPerimeter = this.getPerimeter() / 2;
		double area = Math.sqrt((halfPerimeter - sides[0])
				* (halfPerimeter - sides[1]) * (halfPerimeter - sides[2]));
		return area;
	}

	@Override
	public String toString() {
		return "Triangle [firstVertex = " + Arrays.toString(this.vertices) 
				+ ", secondVertex = " + Arrays.toString(this.secondPointVertices)
				+ ", thirdVertex = " + Arrays.toString(this.thirdPointVertices)
				+ ", Perimeter = " 	+ this.getPerimeter() 
				+ ", Area = " + this.getArea()
				+ "]";
	}

	private double[] getSides() {
		double firstSide = getDistanceBetweenTwoPoints(this.vertices,
				this.secondPointVertices);
		double secondSide = getDistanceBetweenTwoPoints(
				this.secondPointVertices, this.thirdPointVertices);
		double thirdSide = getDistanceBetweenTwoPoints(this.thirdPointVertices,
				this.vertices);
		double[] sides = { firstSide, secondSide, thirdSide };
		return sides;
	}

	private double getDistanceBetweenTwoPoints(double[] firstPoint,
			double[] secondPoint) {
		double deltaX = firstPoint[0] - secondPoint[0];
		double deltaY = firstPoint[1] - secondPoint[1];
		double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		return distance;
	}


}
