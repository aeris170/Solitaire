package game.cards;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Stack;

import javax.swing.JPanel;

import game.io.CardImages;

public final class Deck extends JPanel {

	private static final long serialVersionUID = 6977871711729878032L;

	private Stack<Card> deck;
	private Stack<Card> waste;

	/**
	 * Instantiates a new deck.
	 *
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 */
	public Deck(final int x, final int y) {
		super();
		super.setLocation(x, y);
		super.setSize(180, 96);
		super.setOpaque(false);
		deck = new Stack<>();
		waste = new Stack<>();
	}

	/**
	 * Populate the deck. After dealing the cards to all tableaus, put all
	 * remaning cards in a full deck to this class's cards.
	 */
	public void populate() {
		while(!Card.deck.empty()) {
			deck.push(Card.pop());
		}
	}

	/**
	 * Deal the top card to the waste.
	 */
	public void dealTopCard() {
		if(!deck.empty()) {
			waste.push(deck.pop());
			waste.peek().flip();
		} else {
			while(!waste.empty()) {
				deck.push(waste.pop());
				deck.peek().flip();
			}
		}
	}

	/**
	 * Deal the top three cards to the waste.
	 */
	public void dealTopThreeCards() {
		Card topMost = null;
		Card secondMost = null;
		Card thirdMost = null;
		if(!deck.empty()) {
			topMost = deck.pop();
			topMost.flip();
			waste.push(topMost);
			if(!deck.empty()) {
				secondMost = deck.pop();
				secondMost.flip();
				waste.push(secondMost);
			}
			if(!deck.empty()) {
				thirdMost = deck.pop();
				thirdMost.flip();
				waste.push(thirdMost);
			}
		} else {
			while(!waste.empty()) {
				deck.push(waste.pop());
				System.out.println(deck.peek());
				deck.peek().flip();
			}
		}
	}

	/**
	 * Gets the wastes top card.
	 *
	 * @return the waste top card
	 */
	public Card getWasteTopCard() {
		if(!waste.empty()) {
			return waste.peek();
		} else {
			return null;
		}
	}

	/**
	 * Pop wastes top card.
	 *
	 * @return the waste top card
	 */
	public Card popWasteTopCard() {
		if(!waste.empty()) {
			return waste.pop();
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);
		final Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.WHITE);
		g2d.drawRect(108, 0, 72, getHeight());
		g2d.setColor(new Color(255, 255, 255, 160));
		g2d.fillRect(108, 0, 72, getHeight());
		if(!deck.empty()) {
			g.drawImage(CardImages.images[CardImages.images.length - 1], 108, 0, 72, getHeight(), this);
		}
		Card topMost = null;
		Card secondMost = null;
		Card thirdMost = null;
		if(!waste.empty()) {
			topMost = waste.pop();
		}
		if(!waste.empty()) {
			secondMost = waste.pop();
		}
		if(!waste.empty()) {
			thirdMost = waste.pop();
		}
		if(thirdMost != null) {
			g.drawImage(thirdMost.getCardImage(), 0, 0, 72, getHeight(), this);
			waste.push(thirdMost);
		}
		if(secondMost != null) {
			g.drawImage(secondMost.getCardImage(), 12, 0, 72, getHeight(), this);
			waste.push(secondMost);
		}
		if(topMost != null) {
			g.drawImage(topMost.getCardImage(), 24, 0, 72, getHeight(), this);
			waste.push(topMost);
		}
	}
}
