package civilreg;
import javax.swing.*;
import java.sql.*;

public class TKDKKS{
	private int id = 0;
	private Statement st;
	private String init = "create table TKDKKS ("
			+ "IDTK varchar(10), "
			+ "tenNYC varchar(50), "
			+ "ngaysinhNYC date, "
			+ "noicutruNYC varchar(255), "
			+ "gtttNYC varchar(50), "
			+ "qhvoiNDKS varchar(20), "
			+ "tenNDKS varchar(50), "
			+ "ngaysinhNDKS datetime, "
			+ "nsNDKSghibangchu varchar(255), "
			+ "gioitinhNDKS boolean, "
			+ "dantocNDKS varchar(20), "
			+ "quoctichNDKS varchar(20), "
			+ "noisinhNDKS varchar(255), "
			+ "quequanNDKS varchar(255), "
			+ "tenM varchar(50), "
			+ "ngaysinhM date, "
			+ "dantocM varchar(20), "
			+ "quoctichM varchar(20), "
			+ "noicutruM varchar(255), "
			+ "gtttM varchar(50), "
			+ "tenC varchar(50), "
			+ "ngaysinhC date, "
			+ "dantocC varchar(20), "
			+ "quoctichC varchar(20), "
			+ "noicutruC varchar(255), "
			+ "gtttC varchar(50), "
			+ "ngaydangky date, "
			+ "dncapBS boolean, "
			+ "primary key (IDTK))";
	public TKDKKS() {
		
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
	public Statement getStatement() {
		return st;
	}
}
