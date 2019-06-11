package io.github.crashgamescrmc.PhysicsEngine.math.vector;

public class Vector3d extends Vector2d {

	public Vector3d(double a, double b, double c) {
		super(new double[] { a, b, c });
	}

	public Vector3d(double[] values) {
		super(values);
	}

	public Vector DeepCopy() {
		return new Vector3d(values[0], values[1], values[2]);
	}

	public double GetC() {
		return values[2];
	}

	public void SetC(double c) {
		values[2] = c;
	}

	@Override
	public Vector CreateClearVector() {
		return new Vector3d(0, 0, 0);
	}

}
