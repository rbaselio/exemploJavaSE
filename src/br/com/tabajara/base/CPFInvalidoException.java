package br.com.tabajara.base;

@SuppressWarnings("serial")
public class CPFInvalidoException extends Exception {

	public CPFInvalidoException() {
		super();
	}

	public CPFInvalidoException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CPFInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public CPFInvalidoException(String message) {
		super(message);
	}

	public CPFInvalidoException(Throwable cause) {
		super(cause);
	}

}
