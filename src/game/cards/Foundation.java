package game.cards;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Stack;

import javax.swing.JPanel;

public final class Foundation extends JPanel {

	private static final long serialVersionUID = 2443727268387798262L;

	private transient Stack<Card> cards;

	/**
	 * Instantiates a new foundation.
	 *
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 */
	public Foundation(final int x, final int y) {
		super();
		super.setLocation(x, y);
		super.setSize(72, 96);
		cards = new Stack<>();
	}

	/**
	 * Gets the cards.
	 *
	 * @return the cards in the foundation
	 */
	public Stack<Card> getCards() {
		return cards;
	}

	/**
	 * Gets the top card.
	 *
	 * @return the top card
	 */
	public Card getTopCard() {
		if (!cards.isEmpty()) {
			return cards.peek();
		}
		return null;
	}

	/**
	 * Check completeness.
	 *
	 * @return true, if the tableau has a king
	 */
	public boolean checkCompleteness() {
		return !cards.isEmpty() && cards.peek().getRank() == 13;
	}

	/**
	 * Move from this foundation to another foundation.
	 *
	 * @param destination the destination foundation
	 * @param c the card to move
	 */
	public void moveTo(final Foundation destination, final Card c) {
		final Stack<Card> destinationStack = destination.cards;
		if (!destinationStack.isEmpty()) {
			if (destinationStack.peek().checkFoundationCompatibility(c)) {
				destinationStack.push(cards.pop());
			}
		} else {
			if (c.getRank() == 1) {
				destinationStack.push(cards.pop());
			}
		}
	}

	/**
	 * Move from this foundation to a tableau.
	 *
	 * @param destination the destination tableau
	 * @param c the card to move
	 */
	public void moveTo(final Tableau destination, final Card c) {
		final Stack<Card> destinationStack = destination.getCards();
		if (!destinationStack.isEmpty()) {
			if (destinationStack.peek().checkTableauCompatibility(c)) {
				destinationStack.push(cards.pop());
			}
		} else {
			if (c.getRank() == 13) {
				destinationStack.push(cards.pop());
			}
		}
	}

	/**
	 * Move from deck.
	 *
	 * @param deck the deck
	 * @param c the card to move
	 */
	public void moveFromDeck(final Deck deck, final Card c) {
		if (!cards.isEmpty()) {
			if (cards.peek().checkFoundationCompatibility(c)) {
				cards.push(deck.popWasteTopCard());
			}
		} else if (c.getRank() == 1) {
			cards.push(deck.popWasteTopCard());
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics) */
	@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);

		final Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(8));
		g2.setFont(new Font("Georgia", Font.PLAIN, 45));
		g2.setColor(new Color(200, 200, 200, 200));
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.setColor(Color.WHITE);
		g2.drawRect(0, 0, getWidth(), getHeight());
		g2.setColor(Color.GREEN.darker().darker().darker());
		g2.drawString("A", 20, 60);

		if (!cards.isEmpty()) {
			g.drawImage(cards.peek().getCardImage(), 0, 0, getWidth(), getHeight(), this);
		}
	}
}
