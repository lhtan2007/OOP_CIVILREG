package civilreg;
import java.sql.*;
import java.math.BigInteger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.security.*;

public class Login extends JFrame implements ActionListener, ComponentListener{
	private String addr, usr, passwd;
	private Connection conn;
	private Calendar cal = Calendar.getInstance();
	private String role = "";
	private DefaultTableModel tm = new DefaultTableModel() {
		@Override
		public int getColumnCount() {
			return 2;
		}
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	};
	static ManagerInterface mi;
	JFrame edit_dialog;
	JTextField username_inp;
	JPasswordField passwd_inp, rpasswd_inp;
	JComboBox role_inp;
	public String getUsername() {
		return usr;
	}
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
			
			mi = new ManagerInterface("Chương trình quản lý CSDL hộ tịch");
			mi.setVisible(true);
			LoginUI l = Main.m;
			l.setVisible(false);
			
		}
		catch(Exception e) {
			//e.printStackTrace();
			JFrame fdlg = new JFrame();
			JOptionPane failDialog = new JOptionPane();
			JLabel msg = new JLabel("Không thể đăng nhập vào máy chủ. "
					+ "Vui lòng kiểm tra lại địa chỉ, tên người dùng và mật khẩu.");
			msg.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			failDialog.showMessageDialog(fdlg, msg, 
					"Đăng nhập thất bại", JOptionPane.ERROR_MESSAGE);
			failDialog.setVisible(true);
		}
	}
	public void displayTable(JTable inf, DefaultTableModel tm) {
		tm = this.tm;
		inf.setModel(tm);
		tm.setRowCount(0);
		String colsName_acc[] = {"Tên tài khoản", "Vai trò"};
		tm.setColumnIdentifiers(colsName_acc);
		try {
			ResultSet rs = conn.createStatement().executeQuery("select usr, role from user order by usr");
			while(rs.next()) {
				String rows[] = new String[2];
				rows[0] = rs.getString("usr");
				if(rs.getString("role").equals("admin")) rows[1] = "Quản trị hệ thống";
				else if(rs.getString("role").equals("user")) rows[1] = "Cán bộ hộ tịch";
				tm.addRow(rows);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void addAccount() {
		edit_dialog = new JFrame("Thêm tài khoản");
		edit_dialog.addComponentListener(this);
		edit_dialog.getContentPane().setPreferredSize(new Dimension(450, 100));
		edit_dialog.getContentPane().setLayout(new BorderLayout());
		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(3, 2));
		JLabel usr = new JLabel("Tên người dùng");
		JLabel passwd = new JLabel("Mật khẩu");
		JLabel role = new JLabel("Vai trò");
		username_inp = new JTextField();
		passwd_inp = new JPasswordField();
		role_inp = new JComboBox();
		role_inp.addItem("Quản trị hệ thống");
		role_inp.addItem("Cán bộ hộ tịch");
		fields.add(usr);
		fields.add(username_inp);
		fields.add(passwd);
		fields.add(passwd_inp);
		fields.add(role);
		fields.add(role_inp);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		JButton accept = new JButton("OK");
		accept.addActionListener(this);
		JButton cancel = new JButton("Hủy bỏ");
		cancel.addActionListener(this);
		buttons.add(accept);
		buttons.add(cancel);
		
		edit_dialog.getContentPane().add(fields, BorderLayout.CENTER);
		edit_dialog.getContentPane().add(buttons, BorderLayout.SOUTH);
		
		edit_dialog.setResizable(false);
		edit_dialog.setVisible(true);
		edit_dialog.pack();
		edit_dialog.setLocationRelativeTo(null);
	}
	public void changePassword() {
		edit_dialog = new JFrame("Đổi mật khẩu");
		edit_dialog.addComponentListener(this);
		edit_dialog.getContentPane().setPreferredSize(new Dimension(450, 100));
		edit_dialog.getContentPane().setLayout(new BorderLayout());
		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(3, 2));
		JLabel usr = new JLabel("Tên người dùng");
		JLabel passwd = new JLabel("Mật khẩu mới");
		JLabel rpasswd = new JLabel("Nhập lại mật khẩu mới");
		username_inp = new JTextField();
		passwd_inp = new JPasswordField();
		rpasswd_inp = new JPasswordField();
		fields.add(usr);
		fields.add(username_inp);
		fields.add(passwd);
		fields.add(passwd_inp);
		fields.add(rpasswd);
		fields.add(rpasswd_inp);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		JButton accept = new JButton("OK");
		accept.addActionListener(this);
		JButton cancel = new JButton("Hủy bỏ");
		cancel.addActionListener(this);
		buttons.add(accept);
		buttons.add(cancel);
		
		edit_dialog.getContentPane().add(fields, BorderLayout.CENTER);
		edit_dialog.getContentPane().add(buttons, BorderLayout.SOUTH);
		
		edit_dialog.setResizable(false);
		edit_dialog.setVisible(true);
		edit_dialog.pack();
		edit_dialog.setLocationRelativeTo(null);
	}
	public void changeRole() {
		edit_dialog = new JFrame("Đổi vai trò");
		edit_dialog.addComponentListener(this);
		edit_dialog.getContentPane().setPreferredSize(new Dimension(450, 80));
		edit_dialog.getContentPane().setLayout(new BorderLayout());
		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(2, 2));
		JLabel usr = new JLabel("Tên người dùng");
		JLabel role = new JLabel("Vai trò mới");
		username_inp = new JTextField();
		role_inp = new JComboBox();
		role_inp.addItem("Quản trị hệ thống");
		role_inp.addItem("Cán bộ hộ tịch");
		fields.add(usr);
		fields.add(username_inp);
		fields.add(role);
		fields.add(role_inp);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		JButton accept = new JButton("OK");
		accept.addActionListener(this);
		JButton cancel = new JButton("Hủy bỏ");
		cancel.addActionListener(this);
		buttons.add(accept);
		buttons.add(cancel);
		
		edit_dialog.getContentPane().add(fields, BorderLayout.CENTER);
		edit_dialog.getContentPane().add(buttons, BorderLayout.SOUTH);
		
		edit_dialog.setResizable(false);
		edit_dialog.setVisible(true);
		edit_dialog.pack();
		edit_dialog.setLocationRelativeTo(null);
	}
	public void removeAccount() {
		edit_dialog = new JFrame("Xóa tài khoản");
		edit_dialog.addComponentListener(this);
		edit_dialog.getContentPane().setPreferredSize(new Dimension(500, 60));
		edit_dialog.getContentPane().setLayout(new BorderLayout());
		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(1, 2));
		JLabel usr = new JLabel("Tên người dùng cần xóa");
		username_inp = new JTextField();
		fields.add(usr);
		fields.add(username_inp);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		JButton accept = new JButton("OK");
		accept.addActionListener(this);
		JButton cancel = new JButton("Hủy bỏ");
		cancel.addActionListener(this);
		buttons.add(accept);
		buttons.add(cancel);
		
		edit_dialog.getContentPane().add(fields, BorderLayout.CENTER);
		edit_dialog.getContentPane().add(buttons, BorderLayout.SOUTH);
		
		edit_dialog.setResizable(false);
		edit_dialog.setVisible(true);
		edit_dialog.pack();
		edit_dialog.setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case "OK":
			if(edit_dialog.getTitle().equals("Thêm tài khoản")) {
				try {
					PreparedStatement ps = conn.prepareStatement("insert into user (usr, passwd, role) values (?, ?, ?)");
					ps.setString(1, username_inp.getText());
					ps.setString(2, initPass(String.valueOf(passwd_inp.getPassword())));
					if(role_inp.getSelectedItem().toString().equals("Quản trị hệ thống")) ps.setString(3, "admin");
					else ps.setString(3, "user");
					ps.executeUpdate();
					JFrame modified = new JFrame();
					JOptionPane m = new JOptionPane();
					m.setVisible(true);
					m.showMessageDialog(modified, "Đã thêm tài khoản " + username_inp.getText() + " với vai trò " + role_inp.getSelectedItem().toString() + ".", "Thêm tài khoản thành công", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e1) {
					e1.printStackTrace();
					JFrame notModified = new JFrame();
					JOptionPane nm = new JOptionPane();
					nm.setVisible(true);
					nm.showMessageDialog(notModified, "Không thêm được tài khoản, vui lòng kiểm tra các trường thông tin.\n"
							+ "Lưu ý: tên các tài khoản không được trùng nhau.", "Thêm tài khoản thất bại", JOptionPane.ERROR_MESSAGE);
				}
				finally {
					edit_dialog.setVisible(false);
					break;
				}
			}
			else if(edit_dialog.getTitle().equals("Đổi mật khẩu")) {
				try {
					if(initPass(String.valueOf(passwd_inp.getPassword())).equals(initPass(String.valueOf(rpasswd_inp.getPassword())))) {
						PreparedStatement ps = conn.prepareStatement("update user set passwd = ? where usr = ?");
						ps.setString(1, initPass(String.valueOf(passwd_inp.getPassword())));
						ps.setString(2, username_inp.getText());
						if(ps.executeUpdate() == 1) {
							JFrame modified = new JFrame();
							JOptionPane m = new JOptionPane();
							m.setVisible(true);
							m.showMessageDialog(modified, "Đã đổi mật khẩu tài khoản " + username_inp.getText() + ".", "Đổi mật khẩu thành công", JOptionPane.INFORMATION_MESSAGE);

						}
						else {
							JFrame notModified = new JFrame();
							JOptionPane nm = new JOptionPane();
							nm.setVisible(true);
							nm.showMessageDialog(notModified, "Tài khoản không tồn tại, xin vui lòng kiểm tra lại.", "Đổi mật khẩu thất bại", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JFrame notModified = new JFrame();
						JOptionPane nm = new JOptionPane();
						nm.setVisible(true);
						nm.showMessageDialog(notModified, "Mật khẩu ở 2 ô \"mật khẩu mới\" và \"nhập lại mật khẩu mới\" không trùng khớp, xin vui lòng kiểm tra lại.", "Đổi mật khẩu thất bại", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				finally {
					edit_dialog.setVisible(false);
					break;
				}
			}
			else if(edit_dialog.getTitle().equals("Đổi vai trò")) {
				try {
					PreparedStatement ps = conn.prepareStatement("update user set role = ? where usr = ?");
					if(role_inp.getSelectedItem().toString().equals("Quản trị hệ thống")) ps.setString(1, "admin");
					else ps.setString(1, "user");
					ps.setString(2, username_inp.getText());
					if(ps.executeUpdate() == 1) {
						JFrame modified = new JFrame();
						JOptionPane m = new JOptionPane();
						m.setVisible(true);
						m.showMessageDialog(modified, "Đã đổi vai trò của tài khoản " + username_inp.getText() + " thành " + role_inp.getSelectedItem().toString() + ".", "Đổi vai trò thành công", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JFrame notModified = new JFrame();
						JOptionPane nm = new JOptionPane();
						nm.setVisible(true);
						nm.showMessageDialog(notModified, "Tài khoản không tồn tại, xin vui lòng kiểm tra lại.", "Đổi mật khẩu thất bại", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			else if(edit_dialog.getTitle().equals("Xóa tài khoản")) {
				try {
					PreparedStatement ps = conn.prepareStatement("delete from user where usr = ?");
					ps.setString(1, username_inp.getText());
					if(ps.executeUpdate() == 1) {
						JFrame modified = new JFrame();
						JOptionPane m = new JOptionPane();
						m.setVisible(true);
						m.showMessageDialog(modified, "Đã xóa thành công tài khoản có tên " + username_inp.getText() + ".", "Xóa tài khoản thành công", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JFrame notModified = new JFrame();
						JOptionPane nm = new JOptionPane();
						nm.setVisible(true);
						nm.showMessageDialog(notModified, "Tài khoản không tồn tại, xin vui lòng kiểm tra lại.", "Đổi mật khẩu thất bại", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		case "Hủy bỏ":
			edit_dialog.setVisible(false);
			break;
		}
	}
	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
}
