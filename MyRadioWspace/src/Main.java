import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main {

	public static JFrame frame = new JFrame();

	public static JBackgroundPanel bPanel = new JBackgroundPanel();
	public static JMusicPanel mPanel = new JMusicPanel();

	public static KeyListener NL;

	private static DatabaseCreation DB;
	
	public static JMusicPanel getMusPan(){
		return mPanel;
	}

	public static void main(String[] args) {

		DatabaseCreation x = new DatabaseCreation();
		DB = x;

		KeyListener foo = new NeedleListener(bPanel);
		NL = foo;

		frame = new javax.swing.JFrame();
		frame.setSize(480, 272);
		frame.add(bPanel);
		frame.addKeyListener(NL);

		frame.setVisible(true);

	}

}
