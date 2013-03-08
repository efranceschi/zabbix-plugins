package zabbixplugins.oracle;

import java.util.Arrays;
import java.util.Date;

public class Main {
	public static void main(String[] args) throws Exception {
		System.err.println("START: " + new Date());
		if (args.length == 0) {
			System.err.println("You need to specify at least one argument");
			System.exit(1);
		}
		String key = args[0];
		String params[] = Arrays.copyOfRange(args, 1, args.length);
		ZabbixOraclePlugin zabbixOraclePlugin = new ZabbixOraclePluginImpl();
		System.out.println(zabbixOraclePlugin.execute(key, params));
		System.err.println("END: " + new Date());
	}
}
