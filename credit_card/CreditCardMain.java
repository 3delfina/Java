//Marija Mumm, 2232817m
package creditcard;

public class CreditCardMain {

	public static void main(String[] args) {

		// Create a CreditCardChecker object to be used for validation
		CreditCardChecker creditCardChecker = new CreditCardChecker();

		// Read the credit card number
		java.util.Scanner stdin = new java.util.Scanner(System.in);
		System.out.println("Enter the credit card number: ");
		String creditCard = stdin.next();

		// Call the validate() method of the credit card checker and print an
		// appropriate result
		try {

			if (creditCardChecker.validate(creditCard)) {
				System.out.println("Card number is valid");
			} else {
				System.out.println("Card number is invalid");
			}
		}
		// If an exception is thrown, catch it and print the details of the exception
		catch (IllegalCardLengthException | IllegalCardFormatException e) {
			System.out.println(e.getMessage());
		}

		stdin.close();
	}
}
