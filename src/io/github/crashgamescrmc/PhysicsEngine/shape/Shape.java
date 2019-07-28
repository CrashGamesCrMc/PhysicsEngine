package io.github.crashgamescrmc.PhysicsEngine.shape;

import io.github.crashgamescrmc.PhysicsEngine.MassObject;
import io.github.crashgamescrmc.PhysicsEngine.math.vector.Vector;

public abstract class Shape {

	public abstract <T extends Shape> EdgeIntersection Intersection(T shape);

	public abstract <VT extends Vector> void Collide(MassObject<VT> massObject, MassObject<VT> massObject2);

}
