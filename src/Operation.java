import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Operation 
{
	String value1 = "", 
			prompt1 = "", prompt2 = "", prompt3 = "",
			word = "",
			something = "";
	int level = 0, lineNum = 0;
	boolean b;
	
	public void increaseLevel()
	{
		level++;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public String prompt() // finds text at given line number - indexes starting at 0. 
	{
		lineNum = generateRandomNumber(0,2);
		
	try
	{
	File file = new File("words.txt");
	Scanner words = new Scanner(file);
		
	word = Files.readAllLines(Paths.get("words.txt")).get(lineNum);
	} // end try
		catch(Exception e)
	{
		System.out.println(e.getMessage());
	}	
	
	setPrompt1(word);
	
	return word;
			
	} // end prompt()
		
	public void setValue1(String value1)
	{	
		this.value1 = value1;
	}
	
	public String getValue1()
	{
		return value1;
	}
	
	void setPrompt1(String prompt1)
	{
		this.prompt1 = prompt1;
	}
	
	String getPrompt1()
	{
		return prompt1;
	}
	
	public void validateInput1() // Call setValue1() before calling this method. 
	{
		//this.value1 = value1;
		String prompt = getPrompt1();
		
		validateWithChar(value1, prompt);
		
		if(getValidationBoolean())	// if this flag is true, there was an incorrect input.
			JOptionPane.showMessageDialog(null, "INCORRECT ANSWER after validation!");
		if(!(getValidationBoolean()))
			JOptionPane.showMessageDialog(null, "CORRECT ANSWER after validation!");
		
	}
	
	public void validateWithChar(String value1, String prompt1) // Recieves user entry (value) and the prompt.
	{
		this.value1 = value1;
		this.prompt1 = prompt1;
	
		boolean someBool = false;
		
		this.value1 = value1;
		this.prompt1 = prompt1;
		
		if(value1.length() == prompt1.length())
		{
			someBool = true;
			JOptionPane.showMessageDialog(null, "Correct length!");
		}
		if(!(value1.length() == prompt1.length()))
		{
			JOptionPane.showMessageDialog(null, "Incorrect length!");
			setValidationBoolean(true); // set as true --> there is an error
			someBool = false;
		}
		
		if(someBool) // if the value and prompt are the same length
			for(int i = 0; i < prompt1.length(); i++)
			{
				if(value1.charAt(i) == prompt1.charAt(i))
				{
					//bool1 = true;
					JOptionPane.showMessageDialog(null, "Equal! value1[ " + i + "]:" + value1.charAt(i) + 
							"\nprompt1[ " + i +"]:" + prompt1.charAt(i));
				}
				
				if(!(value1.charAt(i) == prompt1.charAt(i)))
					{
					setValidationBoolean(true);
					JOptionPane.showMessageDialog(null, "NOT Equal! value1[ " + i + "]:" + value1.charAt(i) + 
							"\nprompt1[ " + i +"]:" + prompt1.charAt(i));
					}
			}
			
	} // end validateWithChar()
		
//	public void incrementLevel()
//	{
//		level++;
//	}
	public void setValidationBoolean(boolean b)
	{
		this.b = b;
	}
	
	public boolean getValidationBoolean()
	{
		if(b)
			return true;
		else
			return false;
	}
	
	public int generateRandomNumber(int min, int max) 
	{
		if (min >= max) 
		{
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}
	
//	public void checkIncorrectness(String something)	// checks if a fruit is even entered. For validation requirement.
//	{
//		this.something = something;
//		try
//		{
//		if((something != "apple") && (something != "orange") && (something != "grape"))
//			throw new Exception();
//		}
//		catch(Exception e)
//		{
//			JOptionPane.showMessageDialog(null, "That isn't even a fruit!");
//			// Play bad video/graphics.
//			// Call startGameApplet() again to prompt again.
//			// Increment the loss counter.
//		}
//			
//	}
	
//	void setCounter()
//	{
//		int set = 1; // set 1-3
//		
//		switch(set)
//		{
//		case 1: 
//			text = "easy.txt";
//			break;
//		
//		case 2: 
//			text = "medium.txt";
//			break;
//			
//		case 3: 
//			text = "hard.txt";
//			break;
//		} // End Switch 
//	} // End setCounter()

} // End Operation Class
