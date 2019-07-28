package io.github.crashgamescrmc.PhysicsEngine.shape;

import io.github.crashgamescrmc.PhysicsEngine.MassObject;
import io.github.crashgamescrmc.PhysicsEngine.math.vector.Vector;
import io.github.crashgamescrmc.PhysicsEngine.math.vector.Vector2d;

public class Shape2d extends Shape {

	public Vector2d[] verticies;
	public int[][] edges;

	@Override
	public <T extends Shape> EdgeIntersection Intersection(T shape) {
		Shape2d obj = (Shape2d) shape;
		for (int x = 0; x < edges.length; x++) {
			for (int y = 0; y < obj.edges.length; y++) {
				Vector2d b1 = verticies[edges[x][0]];
				Vector2d m1 = (Vector2d) Vector.Substract(verticies[edges[x][1]], verticies[edges[x][0]]);
				Vector2d b2 = obj.verticies[edges[y][0]];
				Vector2d m2 = (Vector2d) Vector.Substract(obj.verticies[edges[y][1]], obj.verticies[edges[y][0]]);

				double factor = m2.GetB() / m2.GetA();

				double a_m1 = m1.GetA() * factor;
				double a_b1 = b1.GetA() * factor;
				double a_m2 = m2.GetA() * factor;
				double a_b2 = b2.GetA() * factor;

				double difference = a_b2 - b2.GetB();

				a_b1 -= b1.GetB() + difference;

				a_m2 -= a_m1;

				double r = a_b1 / a_m2;

				double a_m1_copy = m1.GetA() * factor;
				double a_b1_copy = b1.GetA() * factor;
				double a_m2_copy = m2.GetA() * factor;
				double a_b2_copy = b2.GetA() * factor;

				double s = (a_m1_copy * r + a_b1_copy - a_b2_copy) / a_m2_copy;

				if (a_m1_copy == m1.GetB()) {
					continue;
				}

				return new EdgeIntersection(true, r, s, x, y);

			}
		}
		return new EdgeIntersection(false);
	}

	@Override
	public <VT extends Vector> void Collide(MassObject<VT> massObject, MassObject<VT> massObject2) {
		throw new Exception();
	}

}
