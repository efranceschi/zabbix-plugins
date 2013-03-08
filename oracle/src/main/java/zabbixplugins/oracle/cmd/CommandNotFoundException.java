package zabbixplugins.oracle.cmd;

public class CommandNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3530785058460193855L;

	public CommandNotFoundException() {
		super();
	}

	public CommandNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public CommandNotFoundException(String message) {
		super(message);
	}

	public CommandNotFoundException(Throwable throwable) {
		super(throwable);
	}

}
