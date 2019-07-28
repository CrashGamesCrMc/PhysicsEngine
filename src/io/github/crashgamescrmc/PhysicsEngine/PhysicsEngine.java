package io.github.crashgamescrmc.PhysicsEngine;

import io.github.crashgamescrmc.PhysicsEngine.math.vector.Vector;

public class PhysicsEngine<VT extends Vector> {

	private Settings settings = new Settings();
	private MassObjectRegistry<VT> massObjectRegistry = new MassObjectRegistry<VT>();

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	public MassObjectRegistry<VT> getMassObjectRegistry() {
		return massObjectRegistry;
	}

	public void setMassObjectRegistry(MassObjectRegistry<VT> massObjectRegistry) {
		this.massObjectRegistry = massObjectRegistry;
	}

}
