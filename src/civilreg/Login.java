package civilreg;
import java.sql.*;
import java.math.BigInteger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.security.*;

public class Login extends JFrame implements ActionListener{
	private String addr, usr, passwd;
	private Connection conn;
	private Calendar cal = Calendar.getInstance();
	private String role = "";
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
	public String getRole() {
		return role;
	}
	
//	private File createPublicKeyFile(File file, PublicKey pbk) throws IOException {
//		if (!file.exists()) {
//			file.createNewFile();
//			FileOutputStream fos = new FileOutputStream(file);
//			fos.write(pbk.getEncoded());
//			fos.close();
//		} 
//		else {
//			//file.delete();
//			//file.createNewFile();
//		}
//		return file;
//	}
//	private File createPrivateKeyFile(File file, PrivateKey prk) throws IOException {
//		if (!file.exists()) {
//			file.createNewFile();
//			FileOutputStream fos = new FileOutputStream(file);
//			fos.write(prk.getEncoded());
//			fos.close();
//		} 
//		else {
//			//file.delete();
//			//file.createNewFile();
//		}
//		return file;
//	}
	
//	public void init() {
//		try {
//			SecureRandom sr = new SecureRandom();
//			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
//			kpg.initialize(2048, sr);
//			KeyPair kp = kpg.genKeyPair();
//			PublicKey pbk = kp.getPublic();
//			PrivateKey prk = kp.getPrivate();
//			File pbkf = createPublicKeyFile(new File("./publickey.rsa"), pbk);
//			File prkf = createPrivateKeyFile(new File("./privatekey.rsa"), prk);
//		}
//		catch(Exception e) {
//			//e.printStackTrace();
//		}
//	}
	
	public void init() {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
		}
		catch(Exception e) {
			
		}
	}
	
	String initPass(String passwd) { //test purpose
		String pwdEncrypted = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] mD = md.digest(passwd.getBytes());
			BigInteger no = new BigInteger(1, mD);
			pwdEncrypted = no.toString(16);
			while(pwdEncrypted.length() < 40) pwdEncrypted = "0" + pwdEncrypted;
		}
		catch(Exception e) {
			
		}
		finally {
			return pwdEncrypted;
		}
	}
	public void signIn() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://" + addr + ":3306/CSDLHOTICH?createDatabaseIfNotExist=true", "root", "craftwin10A$");
			conn.setAutoCommit(true);
			
			try {
				Statement st = conn.createStatement();
				try {
					st.executeUpdate("create table user "
							+ "(usr varchar(50), "
							+ "passwd text, "
							+ "role varchar(50), "
							+ "primary key (usr))");
				}
				catch(Exception e) {
					
				}
				st.executeUpdate("insert into user (usr, passwd, role) values "
						+ "('admin', '" + initPass("admin") + "', 'admin'), "
						+ "('user1', '" + initPass("user1") + "', 'user')");
				System.out.println("COMPLETED");
			}
			catch(Exception ee) {
				//ee.printStackTrace();
			}
			
			String pwdEncrypted = "";
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-1");
				byte[] mD = md.digest(passwd.getBytes());
				BigInteger no = new BigInteger(1, mD);
				pwdEncrypted = no.toString(16);
				while(pwdEncrypted.length() < 40) pwdEncrypted = "0" + pwdEncrypted;
			}
			catch(Exception e) {
				
			}
			
			PreparedStatement ps;
			String login = "select * from user where usr = ? and passwd = ?";
			ps = conn.prepareStatement(login);
			ps.setString(1, usr);
			ps.setString(2, pwdEncrypted);
			ResultSet rs = ps.executeQuery();
			if(!rs.isBeforeFirst()) throw new SQLException ("Not found");
			else {
				rs.next();
				role = rs.getString(3);
			}
			
			ManagerInterface mi = new ManagerInterface("Chương trình quản lý CSDL hộ tịch");
			mi.setVisible(true);
			LoginUI l = Main.m;
			l.setVisible(false);
			
		}
		catch(Exception e) {
			//e.printStackTrace();
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
