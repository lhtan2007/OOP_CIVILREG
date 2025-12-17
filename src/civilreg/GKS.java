package civilreg;
import javax.swing.*;
import java.sql.*;

public class GKS{
	private Statement st;
	private String init = "create table GKS ("
			+ "SoGKS varchar(10), "
			+ "IDTK varchar(10), "
			+ "primary key (SoGKS), "
			+ "foreign key (IDTK) references TKDKKS(IDTK))";
	public GKS() {
		
	}
	public void init() {
		try {
			st = Main.m.getL().getConn().createStatement();
			try {
				System.out.println(init);
				st.executeUpdate(init);
			}
			catch(Exception e1) {
				e1.printStackTrace();
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
