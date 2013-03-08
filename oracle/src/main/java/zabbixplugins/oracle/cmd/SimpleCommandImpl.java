package zabbixplugins.oracle.cmd;

import java.sql.ResultSet;

public class SimpleCommandImpl extends AbstractCommandImpl {
	
	public SimpleCommandImpl(String resource) throws CommandException {
		super(resource);
	}

	public String toString() {
		return getQuery();
	}

	public Result processResult(ResultSet rs) {
		return new SimpleResultImpl(rs);
	}

}
