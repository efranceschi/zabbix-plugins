package zabbixplugins.oracle.cmd;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;


public abstract class AbstractCommandImpl implements Command {

	private final String query;

	public final String getQuery() {
		return query;
	}
	
	public AbstractCommandImpl(String resource) throws CommandException {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
		InputStreamReader isr = new InputStreamReader(is);
		StringWriter sw = new StringWriter();
		char buffer[] = new char[8192];
		try {
			int count = isr.read(buffer);
			while (count > 0) {
				sw.write(buffer, 0, count);
				count = isr.read(buffer);
			}
		} catch (IOException e) {
			throw new CommandException("Error loading command from resource: " + resource, e);
		}
		query = sw.toString();
	}

}
