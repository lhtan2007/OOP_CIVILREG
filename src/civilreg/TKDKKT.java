package civilreg;
import javax.swing.*;
import java.sql.*;

public class TKDKKT{
	private int id = 0;
	private Statement st;
	private String init = "create table TKDKKT ("
			+ "IDTK varchar(10), "
			+ "tenNYC varchar(50), "
			+ "ngaysinhNYC date, "
			+ "noicutruNYC varchar(255), "
			+ "gtttNYC varchar(50), "
			+ "qhvoiNDKT varchar(20), "
			+ "tenNDKT varchar(50), "
			+ "ngaysinhNDKT datetime, "
			+ "nsNDKTghibangchu varchar(255), "
			+ "gioitinhNDKT boolean, "
			+ "dantocNDKT varchar(20), "
			+ "quoctichNDKT varchar(20), "
			+ "noicutruNDKT varchar(255), "
			+ "gtttNDKT varchar(50), "
			+ "thoigianchet datetime, "
			+ "noichet varchar(255), "
			+ "nguyennhanchet varchar(255), "
			+ "soGBT varchar(10), "
			+ "noicapGBT varchar(255), "
			+ "ngaycapGBT datetime, "
			+ "ngaydangky datetime, "
			+ "primary key (IDTK))";
	public TKDKKT() {
		
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
