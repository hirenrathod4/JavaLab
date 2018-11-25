import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class App extends JFrame 
{
	private JPanel mainPanel = new JPanel();	
	private JPanel welcomePanel = new JPanel();
	private JPanel beginPanel = new JPanel();
	
	private JLabel welcomeLabel;
	
	private JButton beginButton;
	
	public final int WIDTH = 400;				
	public final int HEIGHT = 200;				
	
	public App()
	{
		super("Alphabet Game");
		
		buildWelcomePanel();
		buildBeginPanel();
		
//		mainPanel.add(welcomePanel);
//		mainPanel.add(beginPanel);
		
		setSize(WIDTH, HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		   
		
		setLayout(new FlowLayout((FlowLayout.CENTER))); //mainPanel.setLayout().....
		
		add(welcomePanel);
		add(beginPanel);
		
		setLocationRelativeTo(null); 			
		setVisible(true);
	}
	
	
	private void buildWelcomePanel()
	{
		welcomeLabel = new JLabel("Welcome to the alphabet learning game for kids!");
		welcomePanel.add(welcomeLabel);
	}
	
	private void buildBeginPanel()
	{
		beginButton = new JButton("Begin");
		beginButton.addActionListener(new BeginButtonListener());
		
		beginPanel.add(beginButton);
	}

	private class BeginButtonListener implements ActionListener
	{											
												
		public void actionPerformed(ActionEvent e)
		{
			new startGameApplet();
			dispose();
		}
	}  







} // End Applet class
