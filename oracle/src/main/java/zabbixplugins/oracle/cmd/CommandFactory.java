package zabbixplugins.oracle.cmd;

public interface CommandFactory {
	
	Command getCommand(String key);

}
