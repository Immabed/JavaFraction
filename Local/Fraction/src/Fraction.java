import java.util.Scanner;

/**
 * Stores a number as a fraction. Lab2 for CMPT 166.
 * @author Brady Coles
 */
public class Fraction {
	
	/**
	 * The upper number of a fraction
	 */
	private int numerator = 1;
	/**
	 * The lower portion of a fraction. Cannot be zero (divide by zero)
	 */
	private int denominator = 1;
	
	/**
	 * Creates a fraction with the inputed values. If 0 is entered in the
	 * denominator, the denominator is set to 1.
	 * @param numerator The upper number of a fraction
	 * @param denominator The lower portion of a fraction. Cannot be zero (divide by zero)
	 */
	public Fraction(int numerator, int denominator) {
		// Order is important because the denominator can affect the numerator
		setNumerator(numerator);
		setDenominator(denominator);
	}
	
	/**
	 * Sets the numerator, the upper part of a fraction.
	 * @param number The number to set the numerator to.
	 */
	public void setNumerator(int number) {
		numerator = number;
	}
	/**
	 * Sets the denominator, the lower part of a fraction. If zero is entered, 
	 * defaults to one. If a negative number is entered, the numerator's sign 
	 * is swapped.
	 * @param number The number to set the denominator to, must be non-zero
	 * (divide by zero). Zero is replaced by one.
	 */
	public void setDenominator(int number) {
		if (number < 0) {
			numerator = - numerator;
			denominator = - number;
		}
		else if (number == 0) {
			System.out.println("ERROR - Denominator cannot be zero. Setting "
					+ "denominator to 1.");
			denominator = 1;
		}
		else {
			denominator = number;
		}
	}
	
	/**
	 * Returns the fraction in the form "1/3". If the denominator is 1, returns
	 * only the numerator.
	 */
	public String toString() {
		if (denominator == 1) {
			return Integer.toString(numerator);
		}
		else {
			return (numerator + "/" + denominator);
		}
	}
	
	/**
	 * Returns the fraction as a numeric value for use in calculations.
	 * @return the decimal form of the fraction.
	 */
	public double toDouble() {
		return (double)numerator / (double)denominator;
	}
	
	/**
	 * Returns true if the fractions are numerically equal. (eg. 1/3 == 3/9)
	 * @param otherFraction A fraction to compare.
	 * @return Returns true for equality.
	 */
	public boolean equals(Fraction otherFraction) {
		return (this.numerator * otherFraction.denominator == 
				otherFraction.numerator * this.denominator);
	}
	
	/**
	 * Returns true if the calling fraction is greater numerically. (eg. 1/2 > 2/5)
	 * @param otherFraction A fraction to compare.
	 * @return Returns true if the calling fraction is greater.
	 */
	public boolean isGreaterThan(Fraction otherFraction) {
		return (this.numerator * otherFraction.denominator > 
				otherFraction.numerator * this.denominator);
	}
	
	/**
	 * Returns true if the calling fraction is less numerically. (eg. 1/3 < 2/5)
	 * @param otherFraction A fraction to compare.
	 * @return Returns true if the calling fraction is lesser.
	 */
	public boolean isLessThan(Fraction otherFraction) {
		return (this.numerator * otherFraction.denominator < 
				otherFraction.numerator * this.denominator);
	}
	
	
	
	
	/**
	 * Gets a integer input from the user, repeats until input is received.
	 * @param prompt A string of text to prompt the user for input.
	 * @param warning A string of text to warn the user that the input is wrong.
	 * @return The input the user enters as an integer.
	 */
	public static int intInput(String prompt, String warning, Scanner keyboard) {
		System.out.println(prompt);
		int inputNumber;
		if (keyboard.hasNextInt()) {
			inputNumber = keyboard.nextInt();
			// Skip any remaining input in the line.
			keyboard.nextLine();
		}
		else {
			// Skip non-integer input.
			keyboard.nextLine();
			System.out.println(warning);
			inputNumber = intInput(prompt, warning, keyboard);
		}
		return inputNumber;
	}
	
	
	/**
	 * Example program using Fraction. Lets user test if two fractions are equal.
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		while (true) {
			// Get Fractions
			System.out.println("Welcome to the Fraction Comparer.");
			int numerator = intInput("Enter the Numerator (top of fraction):",
									 "Warning, enter an integer.", keyboard);
			int denominator = intInput("Enter the Denominator (non-zero)(bottom of fraction):",
					 				   "Warning, enter an integer.", keyboard);
			Fraction myFraction = new Fraction(numerator, denominator);
			
			System.out.println("Now to compare fractions. Enter a new fraction.");
			int numerator2 = intInput("Enter the Numerator (top of fraction):",
					 				  "Warning, enter an integer.", keyboard);
			int denominator2 = intInput("Enter the Denominator (non-zero)(bottom of fraction):",
	 				   					"Warning, enter an integer.", keyboard);
			Fraction myFraction2 = new Fraction(numerator2, denominator2);
			
			// Compare Fractions
			if (myFraction.equals(myFraction2)) {
				System.out.println(myFraction + " is equal to " + myFraction2);
			}
			else {
				System.out.println(myFraction + " is not equal to " + myFraction2);
			}
			
			// Ask to continue
			System.out.println("Do you want to try another set of fractions? (y/n)");
			String command = keyboard.next();
			if (command.equalsIgnoreCase("n")) {
				System.out.println("Exiting.");
				break;
			}
			else if (command.equalsIgnoreCase("y")) {
				System.out.println("Continuing.");
			}
			else {
				System.out.println("Unknown command, continuing.");
			}
		}
		keyboard.close();

	}

}
