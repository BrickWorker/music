package music.recommd.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jaron on 15/10/1.
 */
// @JsonIgnoreProperties({ "suppressed", "localizedMessage", "stackTrace",
// "cause" })
public class RestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2346497115055567708L;
	public static final Integer BAD_REQUEST = 100;
	public static final Integer CONFILCT = 101;
	public static final Integer NOT_FOUND = 102;
	public static final Integer UNAUTHORIZED = 103;
	public static final Integer INTERNAL = 104;

	private Integer status;

	public RestException() {
	}

	public RestException(String message, Integer status) {
		super(message);
		this.status = status;
	}

	@Override
	@JsonProperty("error")
	public String getMessage() {
		return super.getMessage();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
