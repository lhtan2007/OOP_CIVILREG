package civilreg;
import java.sql.*;
public abstract class RegDataManipulator {
	static int regnum;
	public void RegDataManipulator() {
		
	}
	abstract void addData();
	abstract void setData();
	abstract void removeData();
}
