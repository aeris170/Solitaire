package game.main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import game.CustomMenuBar;
import game.Game;

public final class Window {

	public static JFrame f;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(() -> {
			Window.createAndShowGUI();
		});
	}

	/**
	 * Restart game.
	 */
	public static void restartGame() {
		Window.f.dispose();
		SwingUtilities.invokeLater(() -> {
			Window.createAndShowGUI();
		});
	}

	/**
	 * Creates a GUI on EDT.
	 */
	private static void createAndShowGUI() {
		System.out.println("Created GUI on EDT? " + SwingUtilities.isEventDispatchThread());
		Window.f = new JFrame("Solitaire");
		Window.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// TODO f.setIconImage(icon);
		Window.f.add(Game.getInstance());
		Window.f.setJMenuBar(new CustomMenuBar());
		Window.f.setResizable(false);
		Window.f.setSize(600, 600);
		Window.f.setLocationByPlatform(true);
		Window.f.setVisible(true);
	}
}
