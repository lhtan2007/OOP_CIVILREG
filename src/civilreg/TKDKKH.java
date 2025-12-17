package civilreg;
import javax.swing.*;
import java.sql.*;

public class TKDKKH{
	private int id = 0;
	private Statement st;
	private String init = "create table TKDKKH ("
			+ "IDTK varchar(10), "
			+ "tenNu varchar(50), "
			+ "ngaysinhNu datetime, "
			+ "dantocNu varchar(20), "
			+ "quoctichNu varchar(20), "
			+ "noicutruNu varchar(255), "
			+ "gtttNu varchar(50), "
			+ "solanKHNu tinyint, "
			+ "tenNam varchar(50), "
			+ "ngaysinhNam datetime, "
			+ "dantocNam varchar(20), "
			+ "quoctichNam varchar(20), "
			+ "noicutruNam varchar(255), "
			+ "gtttNam varchar(50), "
			+ "solanKHNam tinyint, "
			+ "ngaydangky datetime, "
			+ "primary key (IDTK))";
	public TKDKKH() {
		
	}
	public void init() {
		try {
			st = Main.m.getL().getConn().createStatement();
			try {
				System.out.println(init);
				st.executeUpdate(init);
			}
			catch(Exception e1) {
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
