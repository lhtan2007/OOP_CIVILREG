package civilreg;
import java.sql.*;

import javax.crypto.Cipher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.security.*;
import java.security.spec.*;

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
//	public Login() {
//		this.addr = "localhost";
//		this.usr = "root";
//		this.passwd = "craftwin10A$";
//	}
	public void test() {
		System.out.println(addr + ' ' + usr + ' ' + passwd);
	}
	private static File createKeyFile(File file) throws IOException {
		if (!file.exists()) {
			file.createNewFile();
		} else {
			file.delete();
			file.createNewFile();
		}
		return file;
	}
	public void init() {
		try {
			SecureRandom sr = new SecureRandom();
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(2048, sr);
			KeyPair kp = kpg.genKeyPair();
			PublicKey pbk = kp.getPublic();
			PrivateKey prk = kp.getPrivate();
			File pbkf = createKeyFile(new File("./publickey.rsa"));
			File prkf = createKeyFile(new File("./privatekey.rsa"));
			FileOutputStream fos = new FileOutputStream(pbkf);
			fos.write(pbk.getEncoded());
			fos.close();
			fos = new FileOutputStream(prkf);
			fos.write(prk.getEncoded());
			fos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	String initPass(String passwd) { //test purpose
		String pwdEncrypt = "";
		try {
			FileInputStream fis = new FileInputStream("./publickey.rsa");
			byte[] b = new byte[fis.available()];
			fis.read(b);
			fis.close();
			X509EncodedKeySpec sp = new X509EncodedKeySpec(b);
			KeyFactory factory = KeyFactory.getInstance("RSA");
			PublicKey pubKey = factory.generatePublic(sp);
			Cipher c = Cipher.getInstance("RSA");
			c.init(Cipher.ENCRYPT_MODE, pubKey);
			byte encryptOut[] = c.doFinal(passwd.getBytes());
			pwdEncrypt = Base64.getEncoder().encodeToString(encryptOut);
		}
		catch(Exception e) {
			
		}
		finally {
			return pwdEncrypt;
		}
	}
	public void signIn() {
		try {
			FileInputStream fis = new FileInputStream("./publickey.rsa");
			byte[] b = new byte[fis.available()];
			fis.read(b);
			fis.close();
			X509EncodedKeySpec sp = new X509EncodedKeySpec(b);
			KeyFactory factory = KeyFactory.getInstance("RSA");
			PublicKey pubKey = factory.generatePublic(sp);
			Cipher c = Cipher.getInstance("RSA");
			c.init(Cipher.ENCRYPT_MODE, pubKey);
			byte encryptOut[] = c.doFinal(passwd.getBytes());
			String pwdEncrypt = Base64.getEncoder().encodeToString(encryptOut);
			
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
				ee.printStackTrace();
			}
			
			ManagerInterface mi = new ManagerInterface("Chương trình quản lý CSDL hộ tịch");
			mi.setVisible(true);
			LoginUI l = Main.m;
			l.setVisible(false);
			
			PreparedStatement ps;
			String login = "select * from user where usr = ? and passwd = ?";
			ps = conn.prepareStatement(login);
			ps.setString(1, usr);
			ps.setString(2, pwdEncrypt);
			
		}
		catch(Exception e) {
			e.printStackTrace();
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
