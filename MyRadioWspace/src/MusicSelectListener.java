import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MusicSelectListener implements KeyListener {

	private JMusicPanel MP = Main.getMusPan();
	private static Connection c = null;
	private String artistDB;
	Statement stmt = null;
	private int artIndex;
	private ArrayList<String> listofArtists;

	public MusicSelectListener() {
		artIndex = 0; // currently selected artist
		artistDB = "";
		listofArtists = JMusicPanel.getArtists(); // //list of all artists
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN && MP.selectY < 203) {
			MP.line = 20; //resets variable to repaint words
			MP.selectY += 20; //changes rect position
			MP.repaint();
			
			artIndex += 1; 
			System.out.println(artIndex);
		}
		if (e.getKeyCode() == KeyEvent.VK_UP && MP.selectY > 3) {
			MP.line = 20;
			MP.selectY -= 20;
			MP.repaint();
			
			artIndex -= 1;
			System.out.println(artIndex);
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			artistDB = listofArtists.get(artIndex);
			System.out.println(artistDB);

		}

		/*
		 * if (e.getKeyCode() == KeyEvent.VK_SPACE) {
		 * Main.frame.remove(Main.frame.findComponentAt(10, 10));
		 * Main.mPanel.setBackground(Color.black);
		 * Main.frame.removeKeyListener(Main.firstListener);// removes wrong key
		 * // listener...
		 * 
		 * KeyListener musicLis = new MusicSelectListener(); // Need to make new
		 * key // listener
		 * 
		 * Main.frame.addKeyListener(musicLis); // Main.frame.add(Main.jmPanel);
		 * 
		 * Main.frame.revalidate(); Main.jmPanel.loadSong(null);
		 * System.out.println("worked"); }
		 */
	}

	public void getPath() {
		try {

			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");

			// System.out.println("Opened database succggggggessfully");

			stmt = c.createStatement();
			System.out.println(artistDB + "hugh");
			ResultSet rs = stmt
					.executeQuery("SELECT ARTIST FROM MUSIC WHERE ID = "
							+ artistDB);

			String artist = rs.getString("Artist");
			System.out.println(artist);

			rs.close();
			stmt.close();

			c.close();
			// System.out.println("Database Connection Closed");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent f) {

	}

}