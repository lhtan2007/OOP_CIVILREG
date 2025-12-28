package civilreg;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class Login extends JFrame implements ActionListener{
	private String addr, usr, passwd;
	private Connection conn;
	private Calendar cal = Calendar.getInstance();
	public Calendar getCal() {
		return cal;
	}
	public Connection getConn() {
		return conn;
	}
	public Login(String addr, String usr, String passwd) {
		this.addr = addr;
		this.usr = usr;
		this.passwd = passwd;
	}
	public void test() {
		System.out.println(addr + ' ' + usr + ' ' + passwd);
	}
	public void signIn() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://" + addr + ":3306/CSDLHOTICH?createDatabaseIfNotExist=true", usr, passwd);
			conn.setAutoCommit(true);
			ManagerInterface mi = new ManagerInterface("Chương trình quản lý CSDL hộ tịch");
			mi.setVisible(true);
			LoginUI l = Main.m;
			l.setVisible(false);
		}
		catch(Exception e) {
			JFrame fdlg = new JFrame();
			JOptionPane failDialog = new JOptionPane();
			failDialog.setVisible(true);
			failDialog.showMessageDialog(fdlg, "Không thể đăng nhập vào máy chủ. "
					+ "Vui lòng kiểm tra lại địa chỉ, tên người dùng và mật khẩu.", 
					"Đăng nhập thất bại", JOptionPane.ERROR_MESSAGE);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
