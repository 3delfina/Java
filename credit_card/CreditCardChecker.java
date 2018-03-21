//Marija Mumm, 2232817m
package creditcard;

public class CreditCardChecker {

	public boolean validate(String creditCard) throws IllegalCardFormatException, IllegalCardLengthException {

		// if card number contains any characters other than digits throw exception
		for (int i = 0; i < creditCard.length(); i++)
			if (Character.isDigit(creditCard.charAt(i)) == false) {
				throw new IllegalCardFormatException(creditCard.charAt(i));
			}
		
		//throw exception if a card length is invalid
		if (creditCard.length() < 13 || creditCard.length() > 19) {
			throw new IllegalCardLengthException(creditCard.length());
		}

		// The card has a valid format -- now verify that it is actually a valid number
		int sum = 0;
		// Go through the characters one at a time from the end
		for (int i = 1; i <= creditCard.length(); i++) {
			// Get the character value
			int value = Character.getNumericValue(creditCard.charAt(creditCard.length() - i));

			// If it is an even position, it needs special treatment
			if (i % 2 == 0) {
				if (value <= 4) {
					sum += (value * 2);
				} else {
					sum += (value * 2 - 9);
				}
			} else {
				// Odd positions just get added to the sum directly
				sum += value;
			}
		}

		// The number is only valid if the final sum is a multiple of 10
		if (sum % 10 == 0) {
			// Card number is VALID
			return true;
		} else {
			// Card number is INVALID
			return false;
		}

	}
}
