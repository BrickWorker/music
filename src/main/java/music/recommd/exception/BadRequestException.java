package music.recommd.exception;


/**
 * Created by jaron on 15/10/3.
 *  [POST/PUT/PATCH]用户发出的请求有错误，服务器没有进行新建或修改数据的操作
 */
public class BadRequestException extends RestException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7857210293202083498L;

	public BadRequestException(String message) {
        super(message, RestException.BAD_REQUEST);
    }

	/**
	 * @param message
	 * @param status
	 */
	public BadRequestException(String message, Integer status) {
		super(message, status);
	}
	
}
