package music.recommd.exception;


/**
 * Created by jaron on 15/10/1. [*]用户发出的请求针对的是不存在的记录，服务器没有进行操作
 */
public class NotFoundException extends RestException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9177870139243304856L;

	public NotFoundException() {
		super("Not found", RestException.NOT_FOUND);
	}

	public NotFoundException(String message) {
		super(message, RestException.NOT_FOUND);
	}

	/**
	 * @param message
	 * @param status
	 */
	public NotFoundException(String message, Integer status) {
		super(message, status);
	}

}
