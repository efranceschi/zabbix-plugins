package zabbixplugins.oracle;

import zabbixplugins.oracle.cmd.Command;
import zabbixplugins.oracle.cmd.CommandFactory;
import zabbixplugins.oracle.cmd.CommandFactoryImpl;
import zabbixplugins.oracle.cmd.Result;
import zabbixplugins.oracle.db.DBConnectionFactory;
import zabbixplugins.oracle.db.OracleConnectionFactoryImpl;

public class ZabbixOraclePluginImpl implements ZabbixOraclePlugin {

	private CommandFactory commandFactory = new CommandFactoryImpl();

	private DBConnectionFactory db = new OracleConnectionFactoryImpl();
	
	public Result execute(String key, String... params) {
		Command command = commandFactory.getCommand(key);
		Result result = db.execute(command, params);
		return result;
	}

}
