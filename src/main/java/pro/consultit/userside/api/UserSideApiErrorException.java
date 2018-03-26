package pro.consultit.userside.api;

public class UserSideApiErrorException extends Exception {

	public UserSideApiErrorException() {
	}

	public UserSideApiErrorException(String message) {
		super(message);
	}

	public UserSideApiErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserSideApiErrorException(Throwable cause) {
		super(cause);
	}

	public UserSideApiErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
