package game;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import game.main.Window;

public final class CustomMenuBar extends JMenuBar {

	private static final long serialVersionUID = 2774672228439655429L;

	private JMenu menu;
	private JMenu options;

	private JMenuItem newGame;
	private JMenuItem exitGame;
	private JMenuItem about;

	private JCheckBoxMenuItem deal3CardOption;

	/**
	 * Instantiates a new custom menu bar.
	 */
	public CustomMenuBar() {
		super();

		menu = new JMenu("Menu");
		options = new JMenu("Options");

		newGame = new JMenuItem("New Game");
		exitGame = new JMenuItem("Exit Game");
		about = new JMenuItem("About");

		deal3CardOption = new JCheckBoxMenuItem("Deal 3 cards from deck instead of 1");

		newGame.addActionListener(e -> Window.restartGame());
		exitGame.addActionListener(e -> System.exit(0));
		about.addActionListener(
		        e -> JOptionPane.showMessageDialog(Window.f, "Solitaire: Written in two days, by Doða Oruç. skype: resarf13", "About", JOptionPane.INFORMATION_MESSAGE));

		menu.add(newGame);
		menu.add(exitGame);
		menu.addSeparator();
		menu.add(about);

		options.add(deal3CardOption);

		super.add(menu);
		super.add(options);
	}

	/**
	 * Checks if deal 3 card selected.
	 *
	 * @return true, if deal 3 card selected
	 */
	public boolean isDeal3CardSelected() {
		return deal3CardOption.isSelected();
	}
}
