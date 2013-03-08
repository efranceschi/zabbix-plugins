package zabbixplugins.oracle.cmd;

import java.sql.ResultSet;


public class JsonCommandImpl extends AbstractCommandImpl {

	public JsonCommandImpl(String resource) throws CommandException {
		super(resource);
	}

	@Override
	public Result processResult(ResultSet rs) {
		return new JsonResultImpl(rs);
	}

}
