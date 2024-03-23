package Stack;

public class StackFullException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackFullException(String err) {
		super(err);
	}
}
