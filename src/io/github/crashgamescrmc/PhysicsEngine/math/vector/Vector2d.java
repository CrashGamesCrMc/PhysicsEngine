package io.github.crashgamescrmc.PhysicsEngine.math.vector;

public class Vector2d extends Vector {

	public Vector2d(double a, double b) {
		values = new double[] { a, b };
	}

	public Vector2d(double[] values) {
		this.values = values;
	}

	@Override
	public Vector DeepCopy() {
		return new Vector2d(values[0], values[1]);
	}

	public double GetA() {
		return values[0];
	}

	public void SetA(double a) {
		values[0] = a;
	}

	public double GetB() {
		return values[1];
	}

	public void SetB(double b) {
		values[1] = b;
	}

	@Override
	public Vector CreateClearVector() {
		return new Vector2d(0, 0);
	}

}
