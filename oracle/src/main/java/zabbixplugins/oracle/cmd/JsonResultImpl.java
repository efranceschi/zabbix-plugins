package zabbixplugins.oracle.cmd;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JsonResultImpl implements Result {

	private final String result;
	
	public JsonResultImpl(ResultSet rs) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		pw.println("{");
		pw.println("  \"data\": [");
		try {
			boolean first = true;
			while (rs.next()) {
				if (first) {
					first = false;
				} else {
					pw.println(",");
				}
				pw.println("    {");
				int count = rs.getMetaData().getColumnCount();
				for (int i=1; i<=count; i++) {
					pw.printf("      \"{#%s}\": \"%s\"%s\n", rs.getMetaData().getColumnName(i), rs.getObject(i).toString(), (i==count ? "" : ","));
				}
				pw.print("    }");
			}
			pw.println();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		pw.println("  ]");
		pw.println("}");
		this.result = sw.toString();
	}

	public String toString() {
		return result;
	}
	
}
