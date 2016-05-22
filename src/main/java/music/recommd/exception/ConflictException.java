package music.recommd.exception;


/**
 * Created by jaron on 15/10/8.
 */
public class ConflictException extends RestException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7472748702044261316L;

	public ConflictException(String message) {
        super(message, 101);
    }

	/**
	 * @param message
	 * @param status
	 */
	public ConflictException(String message, Integer status) {
		super(message, status);
	}
	
	
}
