package _05_Enum_Stuff;

import javax.swing.JOptionPane;

public class _00_Horoscope {
	// 1. Create an enum in a separate file called Zodiac that contains a category
	// for
	// all 12 zodiac signs.

	// 2. Write a method that takes in a Zodiac enum object and uses a JOPtionPane
	// to display
	// a different horoscope based on the Zodiac's state.
	public static void displayHoroscope(Zodiac zodiac) {
		switch (zodiac) {
		case ARIES: {
			JOptionPane.showMessageDialog(null, "Your horoscope is Today a deep concern for others' feelings could have you lending a sympathetic ear to those in need of some understanding. It's more important to listen than talk, Aries, even though your practicality might want to express itself. Your affairs should go smoothly, bringing you and those around you a lot of satisfaction. Don't be surprised if you shed a few tears of joy at some point.");
		break;
		}
		case TAURUS: {
			JOptionPane.showMessageDialog(null, "Your horoscope is It’s easy to get easily riled up today, Taurus. Your guiding planet, charming Venus, finds herself in a yelling match with aggressive Mars. You’re quick to encounter irritation and impatience stemming from within yourself today, so be mindful of lashing out or creating your own stress. Meanwhile, the expressive Gemini moon meets up with stable Saturn, providing ample stamina to handle matters on the career front.");
			break;
		}
		case GEMINI: {
			JOptionPane.showMessageDialog(null, "Your horoscope is A long-awaited social event, perhaps a wedding or christening, could move you to tears, Gemini. As you're naturally a person who doesn't like showing your feelings, you might feel the need to get away until the urge to cry has passed. This should be a very happy day for you as well. Your own contentment could seem almost too good to be true. It's real. Relax and enjoy it.");
			break;
		}
		default: {
			System.out.println("something went wrong.");
		}
		}
	}
	// 3. Make a main method to test your method
public static void main(String[] args) {
	displayHoroscope(Zodiac.GEMINI);
}
}
