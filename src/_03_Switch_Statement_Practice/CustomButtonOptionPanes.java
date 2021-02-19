package _03_Switch_Statement_Practice;

import javax.swing.JOptionPane;

public class CustomButtonOptionPanes {
	public static void main(String[] args) {
		String[] options = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		int input = JOptionPane.showOptionDialog(null, "Choose a day of the week", "Custom Buttons", 0, -1, null,
				options, 0);

		String choice = options[input];
		
		//use a switch statement to do something cool for each option
		switch(choice) {
		case "Sunday": 
			JOptionPane.showMessageDialog(null, "Happy sunday!!!");
			break;
		case "Monday": 
			JOptionPane.showMessageDialog(null, "Happy monday!!!");
			break;
		case "Tuesday": 
			JOptionPane.showMessageDialog(null, "Happy tuesday!!!");
			break;
		case "Wednesday":
			JOptionPane.showMessageDialog(null, "Happy wednesday!!!");
			break;
		case "Thursday":
			JOptionPane.showMessageDialog(null, "Happy thursday!!!");
			break;
		case "Friday":
			JOptionPane.showMessageDialog(null, "Happy friday!!!");
			break;
		case "Saturday":
			JOptionPane.showMessageDialog(null, "Happy saturday!!!");
			break;
		default: 
			System.out.println("Something went wrong :(");
			break;
		}
	}
}
