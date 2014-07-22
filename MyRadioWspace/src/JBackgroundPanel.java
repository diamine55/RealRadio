import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JBackgroundPanel extends JPanel {
	public BufferedImage backG;
	public BufferedImage needle;
	public BufferedImage music;
	public BufferedImage other;

	public BufferedImage section;
	public int nx = 0;

	public JBackgroundPanel() {
		try {
			backG = ImageIO.read(new File(
					"C:\\Users\\Matt\\Desktop\\RadImg\\tuner.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			needle = ImageIO.read(new File(
					"C:\\Users\\Matt\\Desktop\\RadImg\\needle.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			music = ImageIO.read(new File(
					"C:\\Users\\Matt\\Desktop\\RadImg\\music.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			other = ImageIO.read(new File(
					"C:\\Users\\Matt\\Desktop\\RadImg\\othershit.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		section = music;

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backG, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(section, 90, 10, getWidth() / 2, getHeight() / 2, this);
		g.drawImage(needle, nx, 80, getWidth() / 2, getHeight() / 2, this);

	}

}
