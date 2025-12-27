package civilreg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class GKS extends RegDataManipulator{
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
	@Override
	void setData() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void removeData() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void addData() {
		// TODO Auto-generated method stub
		
	}
}
