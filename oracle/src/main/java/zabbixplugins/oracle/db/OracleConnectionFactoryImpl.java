package zabbixplugins.oracle.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import zabbixplugins.oracle.cmd.Command;
import zabbixplugins.oracle.cmd.CommandException;
import zabbixplugins.oracle.cmd.Result;

public class OracleConnectionFactoryImpl implements DBConnectionFactory {

	private Connection getConnection() throws Exception {
		Class.forName ("oracle.jdbc.OracleDriver");
		String username = System.getProperty("oracle.user");
		String password = System.getProperty("oracle.password");
		String host = System.getProperty("oracle.host");
		String port = System.getProperty("oracle.port");
		String sid = System.getProperty("oracle.sid");
		if (port == null) {
			port = "1521";
		}
		String url = "jdbc:oracle:thin:@" + host + ":" + port + ":" + sid;
		return DriverManager.getConnection(url, username, password);
	}

	@Override
	public Result execute(Command command, String... args) throws CommandException {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(command.getQuery());
			for (int i=0; i<args.length; i++) {
				stmt.setObject(i+1, args[i]);
			}
			ResultSet rs = stmt.executeQuery();
			return command.processResult(rs);
		} catch (Exception e) {
			throw new CommandException("Error executing command: " + command, e);
		}
	}

}
