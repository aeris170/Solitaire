/*
 *
 */
package game.cards;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

import javax.swing.JPanel;

public final class Tableau extends JPanel {

	private static final long serialVersionUID = -7449715331508415442L;

	private transient Stack<Card> cards;

	/**
	 * Instantiates a new tableau.
	 *
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 */
	public Tableau(final int x, final int y) {
		super();
		super.setLocation(x, y);
		super.setSize(72, 450);
		super.setOpaque(false);
		cards = new Stack<>();
	}

	/**
	 * Gets the cards.
	 *
	 * @return the cards in the tableau
	 */
	public Stack<Card> getCards() {
		return cards;
	}

	/**
	 * Flip top most card.
	 */
	public void flipTopMost() {
		cards.peek().flip();
	}

	/**
	 * Check if there is no face up cards, if so flip top most.
	 */
	private void flipFaceDownCard() {
		if (!cards.isEmpty() && !cards.peek().isFaceUp()) {
			cards.peek().flip();
		}
	}

	/**
	 * Deal A card to this tableau.
	 */
	public void dealACard() {
		cards.push(Card.deck.pop());
	}

	/**
	 * Move from this tableau to another tableau.
	 *
	 * @param destination the destination tableau
	 * @param c the card to move
	 */
	public void moveTo(final Tableau destination, final Card c) {
		final Stack<Card> destinationStack = destination.cards;
		if (!destinationStack.isEmpty()) {
			if (destinationStack.peek().checkTableauCompatibility(c)) {
				final Deque<Card> toBeMovedCards = new ArrayDeque<>();
				while (!cards.isEmpty()) {
					final Card tmp = cards.pop();
					toBeMovedCards.push(tmp);
					if (tmp.equals(c)) {
						break;
					}
				}
				while (!toBeMovedCards.isEmpty()) {
					destinationStack.push(toBeMovedCards.pop());
				}
			}
		} else {
			if (c.getRank() == 13) {
				final Deque<Card> toBeMovedCards = new ArrayDeque<>();
				while (!cards.isEmpty()) {
					final Card tmp = cards.pop();
					toBeMovedCards.push(tmp);
					if (tmp.equals(c)) {
						break;
					}
				}
				while (!toBeMovedCards.isEmpty()) {
					destinationStack.push(toBeMovedCards.pop());
				}
			}
		}
		flipFaceDownCard();
	}

	/**
	 * Move from this tableau to a foundation.
	 *
	 * @param destination the destination foundation
	 * @param c the card to move
	 */
	public void moveTo(final Foundation destination, final Card c) {
		final Stack<Card> destinationStack = destination.getCards();
		if (!destinationStack.isEmpty()) {
			if (destinationStack.peek().checkFoundationCompatibility(c) && c == cards.peek()) {
				destinationStack.push(cards.pop());
			}
		} else if (c.getRank() == 1) {
			destinationStack.push(cards.pop());
		}
		flipFaceDownCard();
	}

	/**
	 * Move from deck.
	 *
	 * @param deck the deck
	 * @param c the card to move
	 */
	public void moveFromDeck(final Deck deck, final Card c) {
		if (!cards.isEmpty()) {
			if (cards.peek().checkTableauCompatibility(c)) {
				cards.push(deck.popWasteTopCard());
			}
		} else if (c.getRank() == 13) {
			cards.push(deck.popWasteTopCard());
		}
	}

	/**
	 * Find clicked card.
	 *
	 * @param y the y-coordinate
	 * @return the clicked card
	 */
	public Card findClickedCard(final int y) {
		final int index = y / 20;
		if (index < cards.toArray().length) {
			final Card returnMe = (Card) cards.toArray()[index];
			if (returnMe.isFaceUp()) {
				return returnMe;
			}
			return (Card) cards.toArray()[cards.toArray().length - 1];
		}
		return (Card) cards.toArray()[cards.toArray().length - 1];
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics) */
	@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);

		final Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.WHITE);
		g2d.drawLine(0, 0, getWidth(), 0);
		g2d.drawLine(0, 0, 0, 96);
		g2d.drawLine(getWidth() - 1, 0, getWidth() - 1, 96);

		g2d.setPaint(new GradientPaint(36, 0, new Color(255, 255, 255, 160), 36, 60, new Color(0, 0, 0, 0)));
		g2d.fillRect(0, 0, getWidth(), getHeight());

		final List<Card> handler = new ArrayList<>(cards);
		int cardYPos = 0;
		for (final Card c : handler) {
			g.drawImage(c.getCardImage(), 0, cardYPos, 72, 96, this);
			cardYPos += 20;
		}
	}
}