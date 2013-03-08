package zabbixplugins.oracle.cmd;

import java.sql.ResultSet;
import java.sql.SQLException;


public class SimpleResultImpl implements Result {
	
	private ResultSet rs;
	
	public SimpleResultImpl(ResultSet rs) {
		this.rs = rs;
	}
	
	public String toString() {
		try {
			return rs.next() ? rs.getObject(1).toString() : "ZBX_NOTSUPPORTED";
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
