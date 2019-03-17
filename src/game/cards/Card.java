package game.cards;

import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.Stack;

import game.io.CardImages;

public final class Card {

	public static Stack<Card> deck;

	private int rank;
	private String suit;
	private boolean faceUp = false;

	/**
	 * Instantiates a new card.
	 *
	 * @param rank the rank of the card
	 * @param suit the suit of the card
	 */
	private Card(final int rank, final String suit) {
		this.rank = rank;
		this.suit = suit;
	}

	/**
	 * Gets the rank of the card.
	 *
	 * @return the rank of the card
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Gets the suit of the card.
	 *
	 * @return the suit of the card
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * Gets the color of the card.
	 *
	 * @return the color of the card
	 */
	public String getColor() {
		// not very good, but i'm lazy. USE ENUMS NEXT TIME!
		return suit.equals("h") || suit.equals("d") ? "Red" : "Black";
	}

	/**
	 * Flip this card.
	 */
	public void flip() {
		faceUp = !faceUp;
	}

	/**
	 * Checks if is face up.
	 *
	 * @return true, if the card is face up
	 */
	public boolean isFaceUp() {
		return faceUp;
	}

	/**
	 * Check tableau compatibility.
	 *
	 * @param c the card in the tableau
	 * @return true, if card is compatible with the top card in tableau
	 */
	public boolean checkTableauCompatibility(final Card c) {
		return rank == c.rank + 1 && !getColor().equals(c.getColor());
	}

	/**
	 * Check foundation compatibility.
	 *
	 * @param c the card in the foundation
	 * @return true, if card is compatible with the top card in foundation
	 */
	public boolean checkFoundationCompatibility(final Card c) {
		return rank == c.rank - 1 && suit.equals(c.suit);
	}

	/**
	 * Construct random deck.
	 */
	public static void constructRandomDeck() {
		deck = new Stack<>();

		deck.add(new Card(1, "h"));
		deck.add(new Card(1, "d"));
		deck.add(new Card(1, "c"));
		deck.add(new Card(1, "s"));
		deck.add(new Card(2, "h"));
		deck.add(new Card(2, "d"));
		deck.add(new Card(2, "c"));
		deck.add(new Card(2, "s"));
		deck.add(new Card(3, "h"));
		deck.add(new Card(3, "d"));
		deck.add(new Card(3, "c"));
		deck.add(new Card(3, "s"));
		deck.add(new Card(4, "h"));
		deck.add(new Card(4, "d"));
		deck.add(new Card(4, "c"));
		deck.add(new Card(4, "s"));
		deck.add(new Card(5, "h"));
		deck.add(new Card(5, "d"));
		deck.add(new Card(5, "c"));
		deck.add(new Card(5, "s"));
		deck.add(new Card(6, "h"));
		deck.add(new Card(6, "d"));
		deck.add(new Card(6, "c"));
		deck.add(new Card(6, "s"));
		deck.add(new Card(7, "h"));
		deck.add(new Card(7, "d"));
		deck.add(new Card(7, "c"));
		deck.add(new Card(7, "s"));
		deck.add(new Card(8, "h"));
		deck.add(new Card(8, "d"));
		deck.add(new Card(8, "c"));
		deck.add(new Card(8, "s"));
		deck.add(new Card(9, "h"));
		deck.add(new Card(9, "d"));
		deck.add(new Card(9, "c"));
		deck.add(new Card(9, "s"));
		deck.add(new Card(10, "h"));
		deck.add(new Card(10, "d"));
		deck.add(new Card(10, "c"));
		deck.add(new Card(10, "s"));
		deck.add(new Card(11, "h"));
		deck.add(new Card(11, "d"));
		deck.add(new Card(11, "c"));
		deck.add(new Card(11, "s"));
		deck.add(new Card(12, "h"));
		deck.add(new Card(12, "d"));
		deck.add(new Card(12, "c"));
		deck.add(new Card(12, "s"));
		deck.add(new Card(13, "h"));
		deck.add(new Card(13, "d"));
		deck.add(new Card(13, "c"));
		deck.add(new Card(13, "s"));

		Collections.shuffle(deck);
	}

	/**
	 * Pop.
	 *
	 * @return the card
	 */
	public static Card pop() {
		return Card.deck.pop();
	}

	/**
	 * Gets the card image.
	 *
	 * @return the card image
	 */
	public BufferedImage getCardImage() {
		if (faceUp) {
			int suitInteger = -10;
			if (suit.equals("c")) {
				suitInteger = 0;
			} else if (suit.equals("s")) {
				suitInteger = 1;
			} else if (suit.equals("h")) {
				suitInteger = 2;
			} else if (suit.equals("d")) {
				suitInteger = 3;
			}
			return CardImages.images[suitInteger * 13 + rank - 1];
		}
		return CardImages.images[CardImages.images.length - 1];
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return rank + suit;
	}
}
