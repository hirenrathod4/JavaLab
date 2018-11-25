import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class startGameApplet extends JFrame
{
	Operation o = new Operation();
	
	private JPanel displayPanel = new JPanel();	
	private JPanel inputPanel = new JPanel();
	private JPanel submitPanel = new JPanel();
	
	private JLabel displayLabel;
	private JLabel inputLabel;
	
	private JTextField prompt1TextField ;
	
	private JButton submitButton;
	
	public final int WIDTH = 400;				
	public final int HEIGHT = 200;	
	
	public startGameApplet()
	{
		super("Game in progress");
		buildDisplayPanel();
		buildInputPanel();
		buildSubmitPanel();
		
		add(displayPanel);
		add(inputPanel);
		add(submitPanel);
		
		setSize(WIDTH, HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		   
		setLayout(new FlowLayout((FlowLayout.CENTER)));
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void buildDisplayPanel()
	{
		displayLabel = new JLabel("Some interactive content would go here.");
		displayPanel.add(displayLabel);
	}

	private void buildInputPanel()
	{
		// attaching image with prompt
		o.prompt();
		String p = o.getPrompt1();
		
		System.out.println("Prompt is: " + p);
		
		inputLabel = new JLabel("Enter " + p); 
		prompt1TextField = new JTextField(7);
		
		inputPanel.add(inputLabel);
		inputPanel.add(prompt1TextField );
	}
	
	private void buildSubmitPanel()
	{
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new SubmitButtonListener());
		
		submitPanel.add(submitButton);
	}
	
	private class SubmitButtonListener implements ActionListener
	{											
		public void actionPerformed(ActionEvent e)
		{
			String value = prompt1TextField.getText();
			System.out.println("prompt1TextField.getText():" + value);
			try
			{
			o.setValue1(value);
			o.validateInput1();
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, "ERROR: " + e1.getMessage());
			}
			
			dispose();
			//new Start()
			// incrementLevel();
			//System.out.println(o.getPrompt1());
		}
	}

} // end startGameApplet class.

