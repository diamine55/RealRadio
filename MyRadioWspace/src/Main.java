import java.awt.Color;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main {

	public static JFrame frame = new JFrame();

	public static JMainPanel firstPanel;
	public static JMusicPanel mPanel;
	public static JMusicScreenPanel jmPanel;

	public static KeyListener firstListener;

	@SuppressWarnings("unused")
	private static DatabaseCreation DB;

	public static JMusicPanel getMusPan() {
		return mPanel;
	}

	public static void main(String[] args) {
		System.out.println("first");
		DatabaseCreation x = new DatabaseCreation();
		DB = x;

		firstPanel = new JMainPanel();
		mPanel = new JMusicPanel();
		jmPanel = new JMusicScreenPanel();

		KeyListener firstListener = new NeedleListener(firstPanel);

		frame = new javax.swing.JFrame();
		frame.setSize(480, 272);
		frame.add(firstPanel);
		frame.addKeyListener(firstListener);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void MusicScreen() {
		frame.removeKeyListener(firstListener);
		
		frame.remove(firstPanel);
		mPanel.setBackground(Color.black);

		KeyListener musicLis = new MusicSelectListener();
		frame.addKeyListener(musicLis);
		
		frame.add(Main.mPanel);
		frame.revalidate();

	}

}
