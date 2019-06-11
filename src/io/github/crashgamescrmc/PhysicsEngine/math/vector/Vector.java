package io.github.crashgamescrmc.PhysicsEngine.math.vector;

public abstract class Vector implements DeepCopyable<Vector> {

	public double[] values;

	public abstract Vector CreateClearVector();

	public void Add(Vector vector) {
		int size = values.length >= vector.values.length ? vector.values.length : values.length;
		for (int i = 0; i < size; i++) {
			values[i] += vector.values[i];
		}
	}

	public static Vector Add(Vector vector, Vector vector2) {
		Vector out = vector.DeepCopy();
		out.Add(vector2);
		return out;
	}

	public void Substract(Vector vector) {
		int size = values.length >= vector.values.length ? vector.values.length : values.length;
		for (int i = 0; i < size; i++) {
			values[i] -= vector.values[i];
		}
	}

	public static Vector Substract(Vector vector, Vector vector2) {
		Vector out = vector.DeepCopy();
		out.Substract(vector2);
		return out;
	}

	public void Multiply(Vector vector) {
		int size = values.length >= vector.values.length ? vector.values.length : values.length;
		for (int i = 0; i < size; i++) {
			values[i] *= vector.values[i];
		}
	}

	public static Vector Multiply(Vector vector, Vector vector2) {
		Vector out = vector.DeepCopy();
		out.Multiply(vector2);
		return out;
	}

	public void Multiply(double time) {
		for (int i = 0; i < values.length; i++) {
			values[i] *= time;
		}
	}

	public static Vector Multiply(Vector velocity, double time) {
		Vector out = velocity.DeepCopy();
		out.Multiply(time);
		return out;
	}

	public void Divide(Vector vector) {
		int size = values.length >= vector.values.length ? vector.values.length : values.length;
		for (int i = 0; i < size; i++) {
			values[i] /= vector.values[i];
		}
	}

	public static Vector Divide(Vector vector, Vector vector2) {
		Vector out = vector.DeepCopy();
		out.Divide(vector2);
		return out;
	}

	public void Pow(Vector vector) {
		int size = values.length >= vector.values.length ? vector.values.length : values.length;
		for (int i = 0; i < size; i++) {
			values[i] = Math.pow(values[i], vector.values[i]);
		}
	}

	public static Vector Pow(Vector vector, Vector vector2) {
		Vector out = vector.DeepCopy();
		out.Pow(vector2);
		return out;
	}

	public void Sqrt() {
		for (int i = 0; i < values.length; i++) {
			values[i] = Math.sqrt(values[i]);
		}
	}

	public static Vector Sqrt(Vector vector) {
		Vector out = vector.DeepCopy();
		out.Sqrt();
		return out;
	}

	public String toString() {
		String out = "(";
		for (int i = 0; i < values.length - 1; i++) {
			out += String.valueOf(values[i]) + ",";
		}
		if (values.length != 0) {
			out += String.valueOf(values[values.length - 1]);
		}
		out += ")";
		return out;
	}

}
