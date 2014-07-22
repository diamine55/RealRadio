import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MusicListener implements KeyListener {

	private JMusicPanel MP = Main.getMusPan();

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("Moar FuckNuggets");
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Main.frame.remove(Main.frame.findComponentAt(10, 10));
			Main.mPanel.setBackground(Color.black);
			Main.frame.removeKeyListener(Main.NL);
			
			KeyListener musicLis = new MusicListener();	//Need to make new key listener
			Main.frame.addKeyListener(musicLis);	   	//
			Main.frame.add(Main.jmPanel);

			Main.frame.revalidate();
			Main.jmPanel.loadSong(null);
			System.out.println("worked");
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent f) {

	}

}