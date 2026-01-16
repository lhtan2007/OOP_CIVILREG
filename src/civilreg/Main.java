package civilreg;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.UIDefaults;
import javax.swing.UIManager;

public class Main {
	public static LoginUI m;
	//public static Class<T> forName("com.mysql.cj.jdbc.Driver") throws ClassNotFoundException;
	public static void main(String[] args) throws ClassNotFoundException {
		Class c1 = Class.forName("com.mysql.cj.jdbc.Driver");
		m = new LoginUI("Chương trình quản lý CSDL hộ tịch");
	}
}
