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
		return faceUp == true;
	}

	/**
	 * Check tableau compatibility.
	 *
	 * @param c the card in the tableau
	 * @return true, if card is compatible with the top card in tableau
	 */
	public boolean checkTableauCompatibility(final Card c) {
		return (rank == (c.rank + 1)) && !getColor().equals(c.getColor());
	}

	/**
	 * Check foundation compatibility.
	 *
	 * @param c the card in the foundation
	 * @return true, if card is compatible with the top card in foundation
	 */
	public boolean checkFoundationCompatibility(final Card c) {
		return (rank == (c.rank - 1)) && suit.equals(c.suit);
	}

	/**
	 * Construct random deck.
	 */
	public static void constructRandomDeck() {
		Card.deck = new Stack<>();

		Card.deck.add(new Card(1, "h"));
		Card.deck.add(new Card(1, "d"));
		Card.deck.add(new Card(1, "c"));
		Card.deck.add(new Card(1, "s"));
		Card.deck.add(new Card(2, "h"));
		Card.deck.add(new Card(2, "d"));
		Card.deck.add(new Card(2, "c"));
		Card.deck.add(new Card(2, "s"));
		Card.deck.add(new Card(3, "h"));
		Card.deck.add(new Card(3, "d"));
		Card.deck.add(new Card(3, "c"));
		Card.deck.add(new Card(3, "s"));
		Card.deck.add(new Card(4, "h"));
		Card.deck.add(new Card(4, "d"));
		Card.deck.add(new Card(4, "c"));
		Card.deck.add(new Card(4, "s"));
		Card.deck.add(new Card(5, "h"));
		Card.deck.add(new Card(5, "d"));
		Card.deck.add(new Card(5, "c"));
		Card.deck.add(new Card(5, "s"));
		Card.deck.add(new Card(6, "h"));
		Card.deck.add(new Card(6, "d"));
		Card.deck.add(new Card(6, "c"));
		Card.deck.add(new Card(6, "s"));
		Card.deck.add(new Card(7, "h"));
		Card.deck.add(new Card(7, "d"));
		Card.deck.add(new Card(7, "c"));
		Card.deck.add(new Card(7, "s"));
		Card.deck.add(new Card(8, "h"));
		Card.deck.add(new Card(8, "d"));
		Card.deck.add(new Card(8, "c"));
		Card.deck.add(new Card(8, "s"));
		Card.deck.add(new Card(9, "h"));
		Card.deck.add(new Card(9, "d"));
		Card.deck.add(new Card(9, "c"));
		Card.deck.add(new Card(9, "s"));
		Card.deck.add(new Card(10, "h"));
		Card.deck.add(new Card(10, "d"));
		Card.deck.add(new Card(10, "c"));
		Card.deck.add(new Card(10, "s"));
		Card.deck.add(new Card(11, "h"));
		Card.deck.add(new Card(11, "d"));
		Card.deck.add(new Card(11, "c"));
		Card.deck.add(new Card(11, "s"));
		Card.deck.add(new Card(12, "h"));
		Card.deck.add(new Card(12, "d"));
		Card.deck.add(new Card(12, "c"));
		Card.deck.add(new Card(12, "s"));
		Card.deck.add(new Card(13, "h"));
		Card.deck.add(new Card(13, "d"));
		Card.deck.add(new Card(13, "c"));
		Card.deck.add(new Card(13, "s"));

		Collections.shuffle(Card.deck);
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
		if(faceUp) {
			int suitInteger = -10;
			if(suit.equals("c")) {
				suitInteger = 0;
			} else if(suit.equals("s")) {
				suitInteger = 1;
			} else if(suit.equals("h")) {
				suitInteger = 2;
			} else if(suit.equals("d")) {
				suitInteger = 3;
			}
			return CardImages.images[((suitInteger * 13) + rank) - 1];
		}
		return CardImages.images[CardImages.images.length - 1];
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return rank + suit;
	}
}
