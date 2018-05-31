package game.io;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import game.main.Window;

public final class CardImages {

	public static BufferedImage[] images;
	
	private static BufferedImage back;
	private static BufferedImage ca, c2, c3, c4, c5, c6, c7, c8, c9, c10, cj, cq, ck;
	private static BufferedImage sa, s2, s3, s4, s5, s6, s7, s8, s9, s10, sj, sq, sk;
	private static BufferedImage ha, h2, h3, h4, h5, h6, h7, h8, h9, h10, hj, hq, hk;
	private static BufferedImage da, d2, d3, d4, d5, d6, d7, d8, d9, d10, dj, dq, dk;
	
	static {
		try {
			back = ImageIO.read(CardImages.class.getResource("/cardBack.png"));
			
			BufferedImage cardSpriteSheet = ImageIO.read(CardImages.class.getResource("/cards.png"));
			
			ca  = cardSpriteSheet.getSubimage(1  , 1, 72, 96);    sa = cardSpriteSheet.getSubimage(1  , 99, 72, 96);
			c2  = cardSpriteSheet.getSubimage(74 , 1, 72, 96);    s2 = cardSpriteSheet.getSubimage(74 , 99, 72, 96);
			c3  = cardSpriteSheet.getSubimage(147, 1, 72, 96);    s3 = cardSpriteSheet.getSubimage(147, 99, 72, 96);
			c4  = cardSpriteSheet.getSubimage(220, 1, 72, 96);    s4 = cardSpriteSheet.getSubimage(220, 99, 72, 96);
			c5  = cardSpriteSheet.getSubimage(293, 1, 72, 96);    s5 = cardSpriteSheet.getSubimage(293, 99, 72, 96);
			c6  = cardSpriteSheet.getSubimage(366, 1, 72, 96);    s6 = cardSpriteSheet.getSubimage(366, 99, 72, 96);
			c7  = cardSpriteSheet.getSubimage(439, 1, 72, 96);    s7 = cardSpriteSheet.getSubimage(439, 99, 72, 96);
			c8  = cardSpriteSheet.getSubimage(512, 1, 72, 96);    s8 = cardSpriteSheet.getSubimage(512, 99, 72, 96);
			c9  = cardSpriteSheet.getSubimage(585, 1, 72, 96);    s9 = cardSpriteSheet.getSubimage(585, 99, 72, 96);
			c10 = cardSpriteSheet.getSubimage(658, 1, 72, 96);   s10 = cardSpriteSheet.getSubimage(658, 99, 72, 96);
			cj  = cardSpriteSheet.getSubimage(731, 1, 72, 96);    sj = cardSpriteSheet.getSubimage(731, 99, 72, 96);
			cq  = cardSpriteSheet.getSubimage(804, 1, 72, 96);    sq = cardSpriteSheet.getSubimage(804, 99, 72, 96);
			ck  = cardSpriteSheet.getSubimage(877, 1, 72, 96);    sk = cardSpriteSheet.getSubimage(877, 99, 72, 96);

			ha  = cardSpriteSheet.getSubimage(1  , 197, 72, 96);  da = cardSpriteSheet.getSubimage(1  , 295, 72, 96);
			h2  = cardSpriteSheet.getSubimage(74 , 197, 72, 96);  d2 = cardSpriteSheet.getSubimage(74 , 295, 72, 96);
			h3  = cardSpriteSheet.getSubimage(147, 197, 72, 96);  d3 = cardSpriteSheet.getSubimage(147, 295, 72, 96);
			h4  = cardSpriteSheet.getSubimage(220, 197, 72, 96);  d4 = cardSpriteSheet.getSubimage(220, 295, 72, 96);
			h5  = cardSpriteSheet.getSubimage(293, 197, 72, 96);  d5 = cardSpriteSheet.getSubimage(293, 295, 72, 96);
			h6  = cardSpriteSheet.getSubimage(366, 197, 72, 96);  d6 = cardSpriteSheet.getSubimage(366, 295, 72, 96);
			h7  = cardSpriteSheet.getSubimage(439, 197, 72, 96);  d7 = cardSpriteSheet.getSubimage(439, 295, 72, 96);
			h8  = cardSpriteSheet.getSubimage(512, 197, 72, 96);  d8 = cardSpriteSheet.getSubimage(512, 295, 72, 96);
			h9  = cardSpriteSheet.getSubimage(585, 197, 72, 96);  d9 = cardSpriteSheet.getSubimage(585, 295, 72, 96);
			h10 = cardSpriteSheet.getSubimage(658, 197, 72, 96); d10 = cardSpriteSheet.getSubimage(658, 295, 72, 96);
			hj  = cardSpriteSheet.getSubimage(731, 197, 72, 96);  dj = cardSpriteSheet.getSubimage(731, 295, 72, 96);
			hq  = cardSpriteSheet.getSubimage(804, 197, 72, 96);  dq = cardSpriteSheet.getSubimage(804, 295, 72, 96);
			hk  = cardSpriteSheet.getSubimage(877, 197, 72, 96);  dk = cardSpriteSheet.getSubimage(877, 295, 72, 96);
			
			images = new BufferedImage[53];
			
			images[0]  = ca;  images[13] = sa;  images[26] = ha;  images[39] = da;
			images[1]  = c2;  images[14] = s2;  images[27] = h2;  images[40] = d2;
			images[2]  = c3;  images[15] = s3;  images[28] = h3;  images[41] = d3;
			images[3]  = c4;  images[16] = s4;  images[29] = h4;  images[42] = d4;
			images[4]  = c5;  images[17] = s5;  images[30] = h5;  images[43] = d5;
			images[5]  = c6;  images[18] = s6;  images[31] = h6;  images[44] = d6;
			images[6]  = c7;  images[19] = s7;  images[32] = h7;  images[45] = d7;
			images[7]  = c8;  images[20] = s8;  images[33] = h8;  images[46] = d8;
			images[8]  = c9;  images[21] = s9;  images[34] = h9;  images[47] = d9;
			images[9]  = c10; images[22] = s10; images[35] = h10; images[48] = d10;
			images[10] = cj;  images[23] = sj;  images[36] = hj;  images[49] = dj;
			images[11] = cq;  images[24] = sq;  images[37] = hq;  images[50] = dq;
			images[12] = ck;  images[25] = sk;  images[38] = hk;  images[51] = dk;
                                                 
			images[52] = back;
		} catch(final IOException | IllegalArgumentException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(Window.f, "One or more of the card images are missing from the file. The game won't start. Re-download please.", "Error with card images", JOptionPane.ERROR_MESSAGE);
			System.exit(-2);
		}
	}
}
