package zabbixplugins.oracle.cmd;

import java.sql.ResultSet;


public interface Command {

	public String getQuery();
	
	public String toString();

	public Result processResult(ResultSet rs); 
}
