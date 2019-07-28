package io.github.crashgamescrmc.PhysicsEngine;

import java.awt.Graphics;

import javax.swing.JFrame;

import io.github.crashgamescrmc.PhysicsEngine.math.vector.Vector2d;
import javax.swing.JPanel;

public class PhysicsEngine2dGui extends JFrame {
	JPanel panel;

	public PhysicsEngine2dGui() throws InterruptedException {
		PhysicsEngine<Vector2d> engine = new PhysicsEngine<Vector2d>();

		getContentPane().setLayout(null);
		setSize(800, 600);

		panel = new JPanel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 5786015325543308450L;

			public void paint(Graphics g) {
				System.out.println("hi");
			}
		};
		panel.setBounds(0, 0, getSize().width, getSize().height);
		getContentPane().add(panel);

		setVisible(true);

		double fps = 20;
		double frame_time = 1 / 20;
		while (true) {
			long start = System.nanoTime();
			long end = System.nanoTime();
			repaint();
			long taken = end - start;
			if (taken < frame_time) {
				Thread.sleep(0, (int) (frame_time - taken));
			}
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1460291456747820719L;
}