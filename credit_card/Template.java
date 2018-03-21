//Marija Mumm, 2232817m
/**
 * Sample solution to JP2 Lab2, part 1.
 * 
 * @author Mary Ellen Foster
 *
 */
public class Template {
	
	public static void main(String[] args) {
		
		
		// Read the credit card number
		java.util.Scanner stdin = new java.util.Scanner(System.in);
		System.out.println("Enter the credit card number: ");
		String creditCard = stdin.next();

		// First check that the card has a known prefix and a valid length for that prefix
		boolean validLength = true;
		String cardType = null;
		if (creditCard.startsWith("34") || creditCard.startsWith("37")) {
			// American Express
			validLength = (creditCard.length() == 15);
			cardType = "American Express";
		} else if (creditCard.startsWith("4")) {
			// Visa
			validLength = (creditCard.length() == 13 || creditCard.length() == 16 || creditCard.length() == 19);
			cardType = "Visa";
		} else if (creditCard.startsWith("5")) {
			// MasterCard 
			int prefix = Integer.valueOf(creditCard.substring(0, 2));
			if (prefix >= 51 && prefix <= 55) {
				validLength = (creditCard.length() == 16);
				cardType = "MasterCard";
			}
		}

		// If card type is unknown, exit with no further checks
		if (cardType == null) {
			System.out.println("Unknown card type");
			System.exit(0);
		} 
		
		// Known card type -- print it out and check length
		System.out.println("Card type: " + cardType);
		if (!validLength) {
			System.out.println("Invalid length");
			System.exit(0);
		}


		
		stdin.close();
	}
}
