package zabbixplugins.oracle.db;

import zabbixplugins.oracle.cmd.Command;
import zabbixplugins.oracle.cmd.Result;

public interface DBConnectionFactory {

	Result execute(Command command, String... args);
	
}
