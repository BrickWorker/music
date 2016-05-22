package music.recommd.exception;


/**
 * Created by jaron on 15/10/7.
 */
public class UnauthorizedException extends RestException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6159322992269235584L;

	public UnauthorizedException(String message) {
		super(message, RestException.UNAUTHORIZED);
	}

	/**
	 * @param message
	 * @param status
	 */
	public UnauthorizedException(String message, Integer status) {
		super(message, status);
	}

}
