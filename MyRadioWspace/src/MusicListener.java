import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class MusicListener implements KeyListener {

	private JMusicPanel MP = Main.getMusPan();

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN && MP.selectY < 203) {
			// System.out.println("Moar FuckNuggets");
			MP.line = 20;
			MP.selectY += 20;
			MP.repaint();
			// System.out.println(MP.selectY);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP && MP.selectY > 3) {
			// System.out.println("Mas FuckNugatos");
			MP.line = 20;
			MP.selectY -= 20;
			MP.repaint();
			// System.out.println(MP.selectY);
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			int whattt = (MP.selectY - 3) / 20;
			System.out.println(whattt);
			// / System.out
			// / .println("Bet you expected fucknuggets...Nope. Chuck Testa");
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Main.frame.remove(Main.frame.findComponentAt(10, 10));
			Main.mPanel.setBackground(Color.black);
			Main.frame.removeKeyListener(Main.NL);// removes wrong key listener...

			KeyListener musicLis = new MusicListener(); // Need to make new key
														// listener

			Main.frame.addKeyListener(musicLis); //
			Main.frame.add(Main.jmPanel);

			Main.frame.revalidate();
			Main.jmPanel.loadSong(null);
			System.out.println("worked");
		}

	}

	public void getPath(){
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");

			System.out.println("Opened database succggggggessfully");

			stmt = c.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT DISTINCT ARTIST FROM MUSIC;");
			while (rs.next()) {
				String artist = rs.getString("Artist");

				System.out.println("ARTIST = " + artist);

				// System.out.println();

				manywords.add(artist);

			}
			rs.close();
			stmt.close();

			c.close();
			System.out.println("Database Connection Closed");
		}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent f) {

	}

}