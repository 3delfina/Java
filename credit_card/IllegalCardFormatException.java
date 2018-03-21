//Marija Mumm, 2232817m
package creditcard;

public class IllegalCardFormatException extends Exception {
	// constructor
	public IllegalCardFormatException(char message) {
		super("Illegal character: " + message);
	}
}
