package zabbixplugins.oracle.cmd;

import java.util.HashMap;
import java.util.Map;


public class CommandFactoryImpl implements CommandFactory {

	private Map<String, Command> commands = new HashMap<String, Command>();
	
	public CommandFactoryImpl() {
		commands.put("oracle.flashrecovery.pct.used", new SimpleCommandImpl("flashrecovery_pct_used.sql"));
		commands.put("oracle.invalid.system.objects", new SimpleCommandImpl("invalid_system_objects.sql"));
		commands.put("oracle.invalid.user.objects", new SimpleCommandImpl("invalid_user_objects.sql"));
		commands.put("oracle.open.mode", new SimpleCommandImpl("open_mode.sql"));
		commands.put("oracle.opened.sessions", new SimpleCommandImpl("opened_sessions.sql"));
		commands.put("oracle.tablespace.discovery", new JsonCommandImpl("tablespace_discovery.sql"));
		commands.put("oracle.tablespace.pct.used", new SimpleCommandImpl("tablespace_pct_used.sql"));
	}
	
	@Override
	public Command getCommand(String key) {
		Command result = commands.get(key);
		if (result == null) throw new CommandNotFoundException("Command not found for key: " + key);
		return result;
	}

}
