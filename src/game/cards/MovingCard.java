package game.cards;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public final class MovingCard extends JPanel {

	private static final long serialVersionUID = 6429285670468437814L;

	private Card movingCard;

	/**
	 * Instantiates a new moving card.
	 *
	 * @param c the card that will be drawn
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 */
	public MovingCard(final Card c, final int x, final int y) {
		super();
		super.setSize(80, 104);
		super.setLocation(x - 36, y - 48);
		super.setVisible(true);
		movingCard = c;
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics) */
	@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);
		final Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.MAGENTA);
		g2d.drawRect(0, 0, 72, 96);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(5, 5, 72, 96);
		g.drawImage(movingCard.getCardImage(), 5, 5, 72, 96, this);
	}
}