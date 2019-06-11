package io.github.crashgamescrmc.PhysicsEngine;

import io.github.crashgamescrmc.PhysicsEngine.math.vector.Vector2d;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		MassObject<Vector2d> m = new MassObject<Vector2d>(1, new Vector2d(0, 0), new Vector2d(0, 0));
		m.ApplyAcceleration(new Vector2d(0, 4));
		while (true) {
			m.Update(0.5);
			System.out.println("Pos: " + m.position + "; Speed: " + m.velocity);
			Thread.sleep(500);
		}
	}

}
