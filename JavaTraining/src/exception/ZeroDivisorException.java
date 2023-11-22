package exception;

public class ZeroDivisorException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ZeroDivisorException(Exception exception) {
		super(exception);
	}
	
	public ZeroDivisorException(String message) {
		super(message);
	}
}
