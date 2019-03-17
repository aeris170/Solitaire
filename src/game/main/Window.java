package game.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import game.CustomMenuBar;
import game.Game;
import game.io.CardImages;

public final class Window {

	public static JFrame f;
	public static Game g;
	public static CustomMenuBar cmb;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(() -> {
			f = new JFrame("Solitaire");
			createAndShowGUI();
		});
	}

	/**
	 * Restart game.
	 */
	public static void restartGame() {
		SwingUtilities.invokeLater(() -> {
			f.remove(g);
			f.remove(cmb);
			createAndShowGUI();
			f.revalidate();
			f.repaint();
		});
	}

	/**
	 * Creates a GUI on EDT.
	 */
	private static void createAndShowGUI() {
		System.out.println("Created GUI on EDT? " + EventQueue.isDispatchThread());
		g = new Game();
		cmb = new CustomMenuBar();
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setIconImage(CardImages.images[39]);
		f.add(g);
		f.setJMenuBar(cmb);
		if (!f.isVisible()) {
			f.setResizable(false);
			f.setSize(600, 600);
			f.setLocationByPlatform(true);
			f.setVisible(true);
		}
	}
}
