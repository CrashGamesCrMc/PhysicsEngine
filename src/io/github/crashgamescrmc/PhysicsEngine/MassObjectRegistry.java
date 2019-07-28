package io.github.crashgamescrmc.PhysicsEngine;

import java.util.ArrayList;
import java.util.List;

import io.github.crashgamescrmc.PhysicsEngine.math.vector.Vector;

public class MassObjectRegistry<VT extends Vector> {

	private List<MassObject<VT>> massObjects = new ArrayList<MassObject<VT>>();

	public void UpdateMassObjects(double time) {
		for (MassObject<VT> obj : massObjects) {
			obj.Update(time);
		}
	}

	public void CollisionTests() {
		for (MassObject<VT> obj : massObjects) {
			for (MassObject<VT> obj2 : massObjects) {
				if (obj == obj2) {
					continue;
				}
				obj.CollisionTest(obj2);
			}
		}
	}

	public void ApplyUniversalAcceleration(VT vector) {
		for (MassObject<VT> obj : massObjects) {
			obj.ApplyAcceleration(vector);
		}
	}

	public void Register(MassObject<VT> massObject) {
		massObjects.add(massObject);
	}

	public List<MassObject<VT>> getMassObjects() {
		return massObjects;
	}

	public void setMassObjects(List<MassObject<VT>> massObjects) {
		this.massObjects = massObjects;
	}

}
