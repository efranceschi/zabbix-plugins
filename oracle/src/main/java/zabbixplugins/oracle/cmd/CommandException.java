package zabbixplugins.oracle.cmd;

public class CommandException extends RuntimeException {

	private static final long serialVersionUID = 3530785058460193855L;

	public CommandException() {
		super();
	}

	public CommandException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public CommandException(String message) {
		super(message);
	}

	public CommandException(Throwable throwable) {
		super(throwable);
	}

}
