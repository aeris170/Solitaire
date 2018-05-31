package game.io;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import game.CustomMenuBar;
import game.cards.Card;
import game.cards.Deck;
import game.cards.Foundation;
import game.cards.MovingCard;
import game.cards.Tableau;
import game.main.Window;

public class GameMoveListener extends MouseInputAdapter {

	private Point location;
	private MouseEvent pressed;

	private MovingCard movingCard = null;

	private Foundation selectedFoundation = null;
	private Tableau selectedTableau = null;
	private Deck selectedDeck = null;
	private Card selectedCard = null;

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		pressed = e;
		Component pressedComponent = e.getComponent().getComponentAt(e.getPoint());
		if (pressedComponent instanceof Foundation) {
			selectedFoundation = (Foundation) pressedComponent;
			selectedTableau = null;
			selectedDeck = null;
			selectedCard = selectedFoundation.getTopCard();
			movingCard = new MovingCard(selectedCard, e.getX(), e.getY());
			((JPanel) e.getComponent()).add(movingCard, 0);
		} else if (pressedComponent instanceof Tableau) {
			selectedTableau = (Tableau) pressedComponent;
			selectedFoundation = null;
			selectedDeck = null;
			// FIXME error check arrayindexoutofbounds array is empty
			selectedCard = selectedTableau.findClickedCard(e.getY() - 150);
			movingCard = new MovingCard(selectedCard, e.getX(), e.getY());
			((JPanel) e.getComponent()).add(movingCard, 0);
		} else if (pressedComponent instanceof Deck) {
			selectedDeck = (Deck) pressedComponent;
			selectedFoundation = null;
			selectedTableau = null;
			int clickX = e.getX();
			if (clickX > 380 && clickX < 476) {
				selectedCard = selectedDeck.getWasteTopCard();
				movingCard = new MovingCard(selectedCard, e.getX(), e.getY());
				((JPanel) e.getComponent()).add(movingCard, 0);
			} else if (clickX > 488 && clickX < 560) {
				if (((CustomMenuBar) Window.f.getJMenuBar()).isDeal3CardSelected()) {
					selectedDeck.dealTopThreeCards();
				} else {
					selectedDeck.dealTopCard();
				}
			}
		}
		e.getComponent().repaint();
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if (selectedCard != null) {
			((JPanel) e.getComponent()).remove(movingCard);// TODO WOW, PUT THIS
															// LINE AT THE END
															// OF THIS METHOD,
															// AND NO CARD CAN
															// BE
			// MOVEDDDDDD. skype: resarf13 add me for any questions about why.
			// hahahahaha
			Component releasedComponent = e.getComponent().getComponentAt(e.getPoint());
			if (releasedComponent instanceof Foundation) {
				if (selectedTableau != null) {
					// MOVING FROM TABLEAU TO FOUNDATION
					Tableau source = selectedTableau;
					Foundation destination = (Foundation) releasedComponent;
					source.moveTo(destination, selectedCard);
					source.repaint();
					destination.repaint();
				} else if (selectedDeck != null) {
					// MOVING FROM DECK TO FOUNDATION
					Deck source = selectedDeck;
					Foundation destination = (Foundation) releasedComponent;
					destination.moveFromDeck(source, selectedCard);
					source.repaint();
					destination.repaint();
				} else if (selectedFoundation != null) {
					// MOVING FROM FOUNDATION TO FOUNDATION
					Foundation source = selectedFoundation;
					Foundation destination = (Foundation) releasedComponent;
					source.moveTo(destination, selectedCard);
					source.repaint();
					destination.repaint();
				}
			} else if (releasedComponent instanceof Tableau) {
				if (selectedTableau != null) {
					// MOVING FROM TABLEAU TO TABLEAU
					Tableau source = selectedTableau;
					Tableau destination = (Tableau) releasedComponent;
					source.moveTo(destination, selectedCard);
					source.repaint();
					destination.repaint();
				} else if (selectedDeck != null) {
					// MOVING FROM DECK TO TABLEAU
					System.out.println(selectedCard);
					Deck source = selectedDeck;
					Tableau destination = (Tableau) releasedComponent;
					destination.moveFromDeck(source, selectedCard);
					source.repaint();
					destination.repaint();
				} else if (selectedFoundation != null) {
					// MOVING FROM FOUNDATION TO TABLEAU
					Foundation source = selectedFoundation;
					Tableau destination = (Tableau) releasedComponent;
					source.moveTo(destination, selectedCard);
					source.repaint();
					destination.repaint();
				}
			}
			e.getComponent().repaint();
			selectedCard = null;
			movingCard = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if (selectedCard != null && movingCard != null) {
			location = movingCard.getLocation(location);
			movingCard.setLocation(location.x - pressed.getX() + e.getX(), location.y - pressed.getY() + e.getY());
			pressed = e;
		}
	}
}
