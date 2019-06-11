package io.github.crashgamescrmc.PhysicsEngine;

import io.github.crashgamescrmc.PhysicsEngine.math.vector.Vector;
import io.github.crashgamescrmc.PhysicsEngine.shape.Shape;

public class MassObject<VT extends Vector> {

	@SuppressWarnings("unchecked")
	public MassObject(double mass, VT position, VT velocity) {
		this.mass = mass;
		this.position = position;
		this.velocity = velocity;

		acceleration = (VT) position.CreateClearVector();
		if (Settings.MassObject_collective_update) {
		}
	}

	protected double mass;
	protected VT position;
	protected VT velocity;
	protected VT acceleration;
	protected Shape shape;

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public VT getPosition() {
		return position;
	}

	public void setPosition(VT position) {
		this.position = position;
	}

	public VT getVelocity() {
		return velocity;
	}

	public void setVelocity(VT velocity) {
		this.velocity = velocity;
	}

	public void ApplyAcceleration(VT vector) {
		acceleration.Add(vector);
	}

	@SuppressWarnings("unchecked")
	public void Update(double time) {
		System.out.println("Begin update (speed " + velocity + ")");
		position.Add(Vector.Multiply(velocity, time));
		velocity.Add(Vector.Multiply(acceleration, time));
		position.Add(Vector.Multiply(Vector.Multiply(acceleration, 0.5), time * time));
		System.out.println("End update (speed " + velocity + ")");

		if (Settings.MassObject_clean_after_update) {
			acceleration = (VT) position.CreateClearVector();
		}
	}

	/**
	 * Collides two <b>MassObject</b>s. Only the object, on which the method is
	 * called, is accelerated.<br>
	 * Formula:<br>
	 * <img src=
	 * "https://wikimedia.org/api/rest_v1/media/math/render/svg/8703800c3e0f653458fc01982b475f4f51b26bca">
	 * 
	 * @param massObject
	 */
	@SuppressWarnings("unchecked")
	public void Collide(MassObject<VT> massObject) {
		velocity = (VT) Vector.Add(Vector.Multiply(velocity, (mass - massObject.mass) / (mass + massObject.mass)),
				Vector.Multiply(massObject.velocity, 2 * massObject.mass / (mass + massObject.mass)));
	}

	public boolean CollisionTest(MassObject<VT> massObject) {
		return shape.Intersection(massObject.shape).crosses;
	}

	/**
	 * Collides two <b>MassObject</b>s. Both are accelerated.<br>
	 * Formula:<br>
	 * <img src=
	 * "https://wikimedia.org/api/rest_v1/media/math/render/svg/8703800c3e0f653458fc01982b475f4f51b26bca">
	 * 
	 * @param massObject
	 */
	public void CollideBoth(MassObject<VT> massObject) {
		Collide(massObject);
		massObject.Collide(this);
	}

}
