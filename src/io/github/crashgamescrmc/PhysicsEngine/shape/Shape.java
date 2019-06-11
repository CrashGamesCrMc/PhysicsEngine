package io.github.crashgamescrmc.PhysicsEngine.shape;

public abstract class Shape {

	public abstract <T extends Shape> EdgeIntersection Intersection(T shape);

}
