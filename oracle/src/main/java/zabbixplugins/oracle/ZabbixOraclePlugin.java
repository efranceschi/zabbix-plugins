package zabbixplugins.oracle;

import zabbixplugins.oracle.cmd.Result;

public interface ZabbixOraclePlugin {
	
	Result execute(String key, String... args);

}
