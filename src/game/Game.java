package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game.cards.Card;
import game.cards.Deck;
import game.cards.Foundation;
import game.cards.Tableau;
import game.io.GameMoveListener;
import game.main.Window;

public final class Game extends JPanel {

	private static final long serialVersionUID = -4557572784451893202L;

	private static final Dimension gameWindowDimension = new Dimension(600, 600);

	private static final Point FIRST_TABLEAU_POSITON = new Point(20, 150);
	private static final Point FIRST_FOUNDATION_POSITON = new Point(20, 20);
	private static final Point DECK_POSITON = new Point(380, 20);

	private static final Integer TABLEAU_OFFSET = 80;
	private static final Integer FOUNDATION_OFFSET = 80;

	private boolean bgImageError = false;

	private Foundation[] foundations;

	/**
	 * Instantiates a new game.
	 */
	public Game() {
		super();
		super.setLayout(null);
		super.setSize(Game.gameWindowDimension);
		super.setBackground(Color.BLACK);

		setUpGame(Game.FIRST_TABLEAU_POSITON, Game.FIRST_FOUNDATION_POSITON, Game.DECK_POSITON);

		final GameMoveListener l = new GameMoveListener();
		super.addMouseListener(l);
		super.addMouseMotionListener(l);
	}

	/**
	 * Sets the up game. Instanties a deck, 7 tableaus, and 4 foundations. Deals
	 * random cards to the tableaus accordingly. Puts all the components into their
	 * respective places so they can be drawn in such a way that it would look
	 * appealing.
	 *
	 * @param tableauPos the tableau position
	 * @param foundationPos the foundation position
	 * @param deckPos the deck position
	 */
	private void setUpGame(final Point tableauPos, final Point foundationPos, final Point deckPos) {
		Card.constructRandomDeck();

		final Tableau[] tableau = new Tableau[7];
		for (int tableauIndex = 1; tableauIndex <= tableau.length; tableauIndex++) {
			tableau[tableauIndex - 1] = new Tableau((int) tableauPos.getX() + Game.TABLEAU_OFFSET * (tableauIndex - 1), (int) tableauPos.getY());
			for (int numberOfCards = 0; numberOfCards < tableauIndex; numberOfCards++) {
				tableau[tableauIndex - 1].dealACard();
			}
			tableau[tableauIndex - 1].flipTopMost();
			super.add(tableau[tableauIndex - 1]);
		}

		foundations = new Foundation[4];
		for (int i = 0; i < foundations.length; i++) {
			foundations[i] = new Foundation((int) foundationPos.getX() + Game.FOUNDATION_OFFSET * i, (int) foundationPos.getY());
			super.add(foundations[i]);
		}

		final Deck deck = new Deck((int) deckPos.getX(), (int) deckPos.getY());
		deck.populate();
		super.add(deck);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics) */
	@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);

		if (!bgImageError) {
			try {
				g.drawImage(ImageIO.read(super.getClass().getResource("/bg.jpg")), 0, 0, super.getWidth(), super.getHeight(), this);
			} catch (final IOException | IllegalArgumentException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(Window.f, "Game's background image is missing. The game will start but won't look good. Re-download please.",
				        "Error with background image", JOptionPane.ERROR_MESSAGE);
				bgImageError = true;
			}
		}

		boolean isGameOver = true;
		for (int i = 0; i < foundations.length; i++) {
			if (!foundations[i].checkCompleteness()) {
				isGameOver = false;
			}
		}
		if (isGameOver) {
			g.setFont(new Font("Georgia", Font.BOLD, 42));
			g.setColor(Color.BLACK);
			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.drawString("YOU WIN!!!!!!!!", 130, 300);
		}
	}
}
