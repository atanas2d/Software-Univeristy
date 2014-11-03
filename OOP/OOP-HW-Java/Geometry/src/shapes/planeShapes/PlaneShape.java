package shapes.planeShapes;

import shapes.Shape;
import shapes.AreaMeasurable;
import shapes.PerimeterMeasurable;

public abstract class PlaneShape extends Shape implements PerimeterMeasurable, 
		AreaMeasurable {
	
	public PlaneShape (double[] vertices) {
		this.vertices = new double[2];
		this.vertices = vertices;	
	}
}
