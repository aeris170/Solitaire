package game.main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import game.Game;
import game.CustomMenuBar;

public final class Window {

	public static JFrame f;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(() -> {
			createAndShowGUI();
		});
	}

	/**
	 * Restart game.
	 */
	public static void restartGame() {
		f.dispose();
		SwingUtilities.invokeLater(() -> {
			createAndShowGUI();
		});
	}

	/**
	 * Creates a GUI on EDT.
	 */
	private static void createAndShowGUI() {
		System.out.println("Created GUI on EDT? " + SwingUtilities.isEventDispatchThread());
		f = new JFrame("Solitaire");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// TODO f.setIconImage(icon);
		f.add(Game.getInstance());
		f.setJMenuBar(new CustomMenuBar());
		f.setResizable(false);
		f.setSize(600, 600);
		f.setLocationByPlatform(true);
		f.setVisible(true);
	}
}
