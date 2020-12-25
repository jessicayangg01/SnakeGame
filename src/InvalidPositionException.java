/**
 * Class: InvalidPositionException
 * Description: Exception thrown when the Position given is out of bounds.
 * @author Jessica yang
 *
 */
public class InvalidPositionException extends RuntimeException {
	public InvalidPositionException(String msg) {
		super(msg);
	}
}