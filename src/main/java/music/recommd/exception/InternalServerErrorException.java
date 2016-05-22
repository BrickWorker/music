package music.recommd.exception;


/**
 * Created by jaron on 15/10/3. [POST/PUT/PATCH]用户发出的请求有错误，服务器没有进行新建或修改数据的操作
 */
public class InternalServerErrorException extends RestException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7857210293202083498L;

	public InternalServerErrorException(String message) {
		super(message, RestException.INTERNAL);
	}

	/**
	 * @param message
	 * @param status
	 */
	public InternalServerErrorException(String message, Integer status) {
		super(message, status);
	}

}
