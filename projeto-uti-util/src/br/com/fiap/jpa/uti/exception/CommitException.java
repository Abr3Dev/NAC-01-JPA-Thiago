package br.com.fiap.jpa.uti.exception;

@SuppressWarnings("serial")
public class CommitException extends Exception {

	public CommitException() {
		super();
	}

	public CommitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CommitException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommitException(String message) {
		super(message);
	}

	public CommitException(Throwable cause) {
		super(cause);
	}
}
