package civilreg;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class RegDataManipulator {
	public void RegDataManipulator() {
		
	}
	abstract void displayTable(JTable inf, DefaultTableModel tm);
	abstract void addData();
	abstract void setData();
	abstract void removeData();
	abstract void approveData();
	abstract void viewData();
	abstract int countData();
}
