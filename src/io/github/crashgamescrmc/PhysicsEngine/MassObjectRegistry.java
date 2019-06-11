package io.github.crashgamescrmc.PhysicsEngine;

import java.util.ArrayList;
import java.util.List;

import io.github.crashgamescrmc.PhysicsEngine.math.vector.Vector;

@SuppressWarnings("rawtypes")
public class MassObjectRegistry {

	private List<MassObject> massObjects = new ArrayList<MassObject>();

	public void CollectiveUpdate(double time) {
		for (MassObject obj : massObjects) {
			obj.Update(time);
		}
	}

	public List<MassObject> getMassObjects() {
		return massObjects;
	}

	public void setMassObjects(List<MassObject> massObjects) {
		this.massObjects = massObjects;
	}

	@SuppressWarnings("unchecked")
	public void ApplyUniversalAcceleration(Vector vector) {
		for (MassObject obj : massObjects) {
			obj.ApplyAcceleration(vector);
		}
	}

}
