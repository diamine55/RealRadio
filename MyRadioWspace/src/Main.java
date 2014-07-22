import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main {

	public static JFrame frame = new JFrame();

	public static JBackgroundPanel bPanel;
	public static JMusicPanel mPanel;
	public static JMusicScreenPanel jmPanel;

	public static KeyListener NL;

	private static DatabaseCreation DB;

	public static JMusicPanel getMusPan() {
		return mPanel;
	}

	public static void main(String[] args) {
		System.out.println("first");
		DatabaseCreation x = new DatabaseCreation();
		DB = x;

		bPanel = new JBackgroundPanel();
		mPanel = new JMusicPanel();
		jmPanel = new JMusicScreenPanel();

		KeyListener foo = new NeedleListener(bPanel);
		NL = foo;

		frame = new javax.swing.JFrame();
		frame.setSize(480, 272);
		frame.add(bPanel);
		frame.addKeyListener(NL);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
