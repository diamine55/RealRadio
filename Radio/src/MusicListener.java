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
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			System.out.println("worked");
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent f) {

	}

}