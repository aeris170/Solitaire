package game.io;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import game.main.Window;

public final class CardImages {

	private CardImages() {}

	public static BufferedImage[] images;

	private static BufferedImage back;
	private static BufferedImage ca, c2, c3, c4, c5, c6, c7, c8, c9, c10, cj, cq, ck;
	private static BufferedImage sa, s2, s3, s4, s5, s6, s7, s8, s9, s10, sj, sq, sk;
	private static BufferedImage ha, h2, h3, h4, h5, h6, h7, h8, h9, h10, hj, hq, hk;
	private static BufferedImage da, d2, d3, d4, d5, d6, d7, d8, d9, d10, dj, dq, dk;

	static {
		try {
			CardImages.back = ImageIO.read(CardImages.class.getResource("/cardBack.png"));

			final BufferedImage cardSpriteSheet = ImageIO.read(CardImages.class.getResource("/cards.png"));

			CardImages.ca = cardSpriteSheet.getSubimage(1, 1, 72, 96);
			CardImages.sa = cardSpriteSheet.getSubimage(1, 99, 72, 96);
			CardImages.c2 = cardSpriteSheet.getSubimage(74, 1, 72, 96);
			CardImages.s2 = cardSpriteSheet.getSubimage(74, 99, 72, 96);
			CardImages.c3 = cardSpriteSheet.getSubimage(147, 1, 72, 96);
			CardImages.s3 = cardSpriteSheet.getSubimage(147, 99, 72, 96);
			CardImages.c4 = cardSpriteSheet.getSubimage(220, 1, 72, 96);
			CardImages.s4 = cardSpriteSheet.getSubimage(220, 99, 72, 96);
			CardImages.c5 = cardSpriteSheet.getSubimage(293, 1, 72, 96);
			CardImages.s5 = cardSpriteSheet.getSubimage(293, 99, 72, 96);
			CardImages.c6 = cardSpriteSheet.getSubimage(366, 1, 72, 96);
			CardImages.s6 = cardSpriteSheet.getSubimage(366, 99, 72, 96);
			CardImages.c7 = cardSpriteSheet.getSubimage(439, 1, 72, 96);
			CardImages.s7 = cardSpriteSheet.getSubimage(439, 99, 72, 96);
			CardImages.c8 = cardSpriteSheet.getSubimage(512, 1, 72, 96);
			CardImages.s8 = cardSpriteSheet.getSubimage(512, 99, 72, 96);
			CardImages.c9 = cardSpriteSheet.getSubimage(585, 1, 72, 96);
			CardImages.s9 = cardSpriteSheet.getSubimage(585, 99, 72, 96);
			CardImages.c10 = cardSpriteSheet.getSubimage(658, 1, 72, 96);
			CardImages.s10 = cardSpriteSheet.getSubimage(658, 99, 72, 96);
			CardImages.cj = cardSpriteSheet.getSubimage(731, 1, 72, 96);
			CardImages.sj = cardSpriteSheet.getSubimage(731, 99, 72, 96);
			CardImages.cq = cardSpriteSheet.getSubimage(804, 1, 72, 96);
			CardImages.sq = cardSpriteSheet.getSubimage(804, 99, 72, 96);
			CardImages.ck = cardSpriteSheet.getSubimage(877, 1, 72, 96);
			CardImages.sk = cardSpriteSheet.getSubimage(877, 99, 72, 96);

			CardImages.ha = cardSpriteSheet.getSubimage(1, 197, 72, 96);
			CardImages.da = cardSpriteSheet.getSubimage(1, 295, 72, 96);
			CardImages.h2 = cardSpriteSheet.getSubimage(74, 197, 72, 96);
			CardImages.d2 = cardSpriteSheet.getSubimage(74, 295, 72, 96);
			CardImages.h3 = cardSpriteSheet.getSubimage(147, 197, 72, 96);
			CardImages.d3 = cardSpriteSheet.getSubimage(147, 295, 72, 96);
			CardImages.h4 = cardSpriteSheet.getSubimage(220, 197, 72, 96);
			CardImages.d4 = cardSpriteSheet.getSubimage(220, 295, 72, 96);
			CardImages.h5 = cardSpriteSheet.getSubimage(293, 197, 72, 96);
			CardImages.d5 = cardSpriteSheet.getSubimage(293, 295, 72, 96);
			CardImages.h6 = cardSpriteSheet.getSubimage(366, 197, 72, 96);
			CardImages.d6 = cardSpriteSheet.getSubimage(366, 295, 72, 96);
			CardImages.h7 = cardSpriteSheet.getSubimage(439, 197, 72, 96);
			CardImages.d7 = cardSpriteSheet.getSubimage(439, 295, 72, 96);
			CardImages.h8 = cardSpriteSheet.getSubimage(512, 197, 72, 96);
			CardImages.d8 = cardSpriteSheet.getSubimage(512, 295, 72, 96);
			CardImages.h9 = cardSpriteSheet.getSubimage(585, 197, 72, 96);
			CardImages.d9 = cardSpriteSheet.getSubimage(585, 295, 72, 96);
			CardImages.h10 = cardSpriteSheet.getSubimage(658, 197, 72, 96);
			CardImages.d10 = cardSpriteSheet.getSubimage(658, 295, 72, 96);
			CardImages.hj = cardSpriteSheet.getSubimage(731, 197, 72, 96);
			CardImages.dj = cardSpriteSheet.getSubimage(731, 295, 72, 96);
			CardImages.hq = cardSpriteSheet.getSubimage(804, 197, 72, 96);
			CardImages.dq = cardSpriteSheet.getSubimage(804, 295, 72, 96);
			CardImages.hk = cardSpriteSheet.getSubimage(877, 197, 72, 96);
			CardImages.dk = cardSpriteSheet.getSubimage(877, 295, 72, 96);

			CardImages.images = new BufferedImage[53];

			CardImages.images[0] = CardImages.ca;
			CardImages.images[13] = CardImages.sa;
			CardImages.images[26] = CardImages.ha;
			CardImages.images[39] = CardImages.da;
			CardImages.images[1] = CardImages.c2;
			CardImages.images[14] = CardImages.s2;
			CardImages.images[27] = CardImages.h2;
			CardImages.images[40] = CardImages.d2;
			CardImages.images[2] = CardImages.c3;
			CardImages.images[15] = CardImages.s3;
			CardImages.images[28] = CardImages.h3;
			CardImages.images[41] = CardImages.d3;
			CardImages.images[3] = CardImages.c4;
			CardImages.images[16] = CardImages.s4;
			CardImages.images[29] = CardImages.h4;
			CardImages.images[42] = CardImages.d4;
			CardImages.images[4] = CardImages.c5;
			CardImages.images[17] = CardImages.s5;
			CardImages.images[30] = CardImages.h5;
			CardImages.images[43] = CardImages.d5;
			CardImages.images[5] = CardImages.c6;
			CardImages.images[18] = CardImages.s6;
			CardImages.images[31] = CardImages.h6;
			CardImages.images[44] = CardImages.d6;
			CardImages.images[6] = CardImages.c7;
			CardImages.images[19] = CardImages.s7;
			CardImages.images[32] = CardImages.h7;
			CardImages.images[45] = CardImages.d7;
			CardImages.images[7] = CardImages.c8;
			CardImages.images[20] = CardImages.s8;
			CardImages.images[33] = CardImages.h8;
			CardImages.images[46] = CardImages.d8;
			CardImages.images[8] = CardImages.c9;
			CardImages.images[21] = CardImages.s9;
			CardImages.images[34] = CardImages.h9;
			CardImages.images[47] = CardImages.d9;
			CardImages.images[9] = CardImages.c10;
			CardImages.images[22] = CardImages.s10;
			CardImages.images[35] = CardImages.h10;
			CardImages.images[48] = CardImages.d10;
			CardImages.images[10] = CardImages.cj;
			CardImages.images[23] = CardImages.sj;
			CardImages.images[36] = CardImages.hj;
			CardImages.images[49] = CardImages.dj;
			CardImages.images[11] = CardImages.cq;
			CardImages.images[24] = CardImages.sq;
			CardImages.images[37] = CardImages.hq;
			CardImages.images[50] = CardImages.dq;
			CardImages.images[12] = CardImages.ck;
			CardImages.images[25] = CardImages.sk;
			CardImages.images[38] = CardImages.hk;
			CardImages.images[51] = CardImages.dk;

			CardImages.images[52] = CardImages.back;
		} catch (final IOException | IllegalArgumentException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(Window.f, "One or more of the card images are missing from the file. The game won't start. Re-download please.",
			        "Error with card images", JOptionPane.ERROR_MESSAGE);
			System.exit(-2);
		}
	}
}
