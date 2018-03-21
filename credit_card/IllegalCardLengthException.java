//Marija Mumm, 2232817m
package creditcard;

public class IllegalCardLengthException extends Exception {
	// constructor
	public IllegalCardLengthException(int message) {
		super("Invalid card length: " + message);
	}

}
