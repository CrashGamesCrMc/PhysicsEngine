package io.github.crashgamescrmc.PhysicsEngine.shape;

public class EdgeIntersection {

	public EdgeIntersection(boolean crosses, double r, double s, int faceR, int faceS) {
		this.crosses = crosses;
		this.r = r;
		this.s = s;
		this.faceR = faceR;
		this.faceS = faceS;
	}

	public EdgeIntersection(boolean b) {
		crosses = b;
	}

	public boolean crosses;
	public double r;
	public double s;
	public int faceR;
	public int faceS;

}
