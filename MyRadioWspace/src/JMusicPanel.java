import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JPanel;

public class JMusicPanel extends JPanel {

	private static Connection c = null;
	Statement stmt = null;
	public String words = "fucknuggets";
	public int line = 20;
	public ArrayList<String> manywords;

	public JMusicPanel() {
		manywords = new ArrayList<String>();
		listArts();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		for (String i : manywords) {
			g.drawString(i, 10, line);
			line += 12;
		}
	}

	public void listArts() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");

			System.out.println("Opened database successfully");

			stmt = c.createStatement();

			ResultSet rs = stmt
					.executeQuery("SELECT DISTINCT ARTIST FROM MUSIC;");
			while (rs.next()) {
				String artist = rs.getString("Artist");

				System.out.println("ARTIST = " + artist);

				System.out.println();

				manywords.add(artist);
				System.out.println(line);

			}
			rs.close();
			stmt.close();

			c.close();
			System.out.println("Database Connection Closed");
			repaint();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
}