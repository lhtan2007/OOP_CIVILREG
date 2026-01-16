package civilreg;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ManagerInterface extends JFrame implements ActionListener, WindowListener, ChangeListener{
	private JPanel p1, p2, p3, p4, p5, p6;
	private JPanel bstat, status, lg;
	private JTable inf, inf1, inf2;
	private DefaultTableModel tm;
	private JScrollPane scr, scr1, scr2;
	private JButton b1, b2, b3, b4, b1a, b2a, rf, rf1, rf2;
	private JButton addacc, changepw, changerole, deleteacc;
	private JTabbedPane tp;
	private JLabel l1, cb, cd, cm, ncb, ncd, ncm, l2, login, cb1, cd1, cm1, ncb1, ncd1, ncm1, usr; 
	private JPanel buttons, buttons1, admincpb;
	private JComboBox list_reg, list_reg1;
	private GKS gks;
	private TLKT tlkt;
	private GCNKH gcnkh;
	private TKDKKS dkks;
	private TKDKKT dkkt;
	private TKDKKH dkkh;
	public JTable getTable() {
		if(tp.getSelectedIndex() == 0) return inf;
		else if(tp.getSelectedIndex() == 1) return inf1;
		else return inf2;
	}
	public ManagerInterface(String s) {
		UIManager.put("Button.font", new FontUIResource(new Font("Segoe UI", Font.BOLD, 12)));
		UIManager.put("Label.font", new FontUIResource(new Font("Segoe UI", Font.ITALIC, 12)));
		UIManager.put("Table.font", new FontUIResource(new Font("Segoe UI", Font.PLAIN, 12)));
		UIManager.put("TextField.font", new FontUIResource(new Font("Segoe UI", Font.PLAIN, 12)));
		UIManager.put("TableHeader.font", new FontUIResource(new Font("Segoe UI", Font.BOLD, 14)));
		UIManager.put("Table.font", new FontUIResource(new Font("Segoe UI", Font.PLAIN, 13)));
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Segoe UI", Font.PLAIN, 14)));
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Segoe UI", Font.BOLD, 12)));
		UIManager.put("TabbedPane.font", new FontUIResource(new Font("Segoe UI", Font.BOLD, 12)));
		UIManager.put("ComboBox.font", new FontUIResource(new Font("Segoe UI", Font.BOLD, 12)));
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		inf = new JTable();
		inf1 = new JTable();
		inf2 = new JTable();
		b1 = new JButton("Thêm tờ khai");
		b1a = new JButton("Xem chi tiết");
		b2 = new JButton("Sửa tờ khai");
		b2a = new JButton("Xóa đăng ký");
		b3 = new JButton("Xóa tờ khai");
		b4 = new JButton("Duyệt tờ khai");
		rf = new JButton("Tải lại danh sách");
		rf1 = new JButton("Tải lại danh sách");
		rf2 = new JButton("Tải lại danh sách");
		b1.addActionListener(this);
		b1a.addActionListener(this);
		b2.addActionListener(this);
		b2a.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		rf.addActionListener(this);
		rf1.addActionListener(this);
		rf2.addActionListener(this);
		tp = new JTabbedPane();
		status = new JPanel();
		lg = new JPanel();
		usr = new JLabel();
		
		l1 = new JLabel("Thống kê cơ bản:");
		bstat = new JPanel();
		cb = new JLabel("Đăng ký khai sinh:");
		cb.setFont(new Font("Segoe UI", Font.BOLD + Font.ITALIC, 12));
		cd = new JLabel("Đăng ký khai tử:");
		cd.setFont(new Font("Segoe UI", Font.BOLD + Font.ITALIC, 12));
		cm = new JLabel("Đăng ký kết hôn:");
		cm.setFont(new Font("Segoe UI", Font.BOLD + Font.ITALIC, 12));
		cb1 = new JLabel("Giấy khai sinh:");
		cb1.setFont(new Font("Segoe UI", Font.BOLD + Font.ITALIC, 12));
		cd1 = new JLabel("Trích lục khai tử:");
		cd1.setFont(new Font("Segoe UI", Font.BOLD + Font.ITALIC, 12));
		cm1 = new JLabel("Giấy chứng nhận kết hôn:");
		cm1.setFont(new Font("Segoe UI", Font.BOLD + Font.ITALIC, 12));
		l2 = new JLabel("Bạn đang đăng nhập với tư cách: ");
		login = new JLabel();

		ncb = new JLabel();
		ncd = new JLabel();
		ncm = new JLabel();
		ncb1 = new JLabel();
		ncd1 = new JLabel();
		ncm1 = new JLabel();
		
		scr = new JScrollPane();
		scr1 = new JScrollPane();
		buttons = new JPanel();
		buttons1 = new JPanel();
		list_reg = new JComboBox();
		list_reg1 = new JComboBox();
		
		scr2 = new JScrollPane();
		admincpb = new JPanel();
		admincpb.setLayout(new FlowLayout());
		addacc = new JButton("Thêm tài khoản");
		addacc.addActionListener(this);
		changepw = new JButton("Đổi mật khẩu");
		changepw.addActionListener(this);
		changerole = new JButton("Đổi vai trò");
		changerole.addActionListener(this);
		deleteacc = new JButton("Xóa tài khoản");
		deleteacc.addActionListener(this);
		admincpb.add(addacc);
		admincpb.add(changepw);
		admincpb.add(changerole);
		admincpb.add(deleteacc);
		admincpb.add(rf2);
		inf2.setVisible(true);
		inf2.getTableHeader().setReorderingAllowed(false);
		scr2.setViewportView(inf2);
		scr2.setVisible(true);
		
		dkks = new TKDKKS();
		dkks.init();
		dkkt = new TKDKKT();
		dkkt.init();
		dkkh = new TKDKKH();
		dkkh.init();
		gks = new GKS();
		gks.init();
		tlkt = new TLKT();
		tlkt.init();
		gcnkh = new GCNKH();
		gcnkh.init();
		
		bstat.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 5));
		bstat.add(cb);
		bstat.add(ncb);
		bstat.add(cd);
		bstat.add(ncd);
		bstat.add(cm);
		bstat.add(ncm);
		bstat.add(cb1);
		bstat.add(ncb1);
		bstat.add(cd1);
		bstat.add(ncd1);
		bstat.add(cm1);
		bstat.add(ncm1);
		
		ncb.setText(String.valueOf(dkks.countData()));
		ncd.setText(String.valueOf(dkkt.countData()));
		ncm.setText(String.valueOf(dkkh.countData()));
		ncb1.setText(String.valueOf(gks.countData()));
		ncd1.setText(String.valueOf(tlkt.countData()));
		ncm1.setText(String.valueOf(gcnkh.countData()));
		
		lg.setLayout(new FlowLayout());
		lg.add(l2);
		lg.add(login);
		lg.add(usr);
		
		if(Main.m.getL().getRole().equals("admin")) login.setText("Quản trị hệ thống");
		else if(Main.m.getL().getRole().equals("user")) login.setText("Cán bộ hộ tịch");
		usr.setText("(" + Main.m.getL().getUsername() + ")");
		
		status.setPreferredSize(new Dimension(p3.getWidth(), 75));
		status.setLayout(new BorderLayout());
		status.add(l1, BorderLayout.NORTH);
		status.add(bstat, BorderLayout.CENTER);
		status.add(lg, BorderLayout.SOUTH);
		
		inf.setVisible(true);
		inf.getTableHeader().setReorderingAllowed(false);
		scr.setViewportView(inf);
		scr.setVisible(true);
		
		inf1.setVisible(true);
		inf1.getTableHeader().setReorderingAllowed(false);
		scr1.setViewportView(inf1);
		scr1.setVisible(true);
		
		
		list_reg.addItem("Tờ khai đăng ký khai sinh");
		list_reg.addItem("Tờ khai đăng ký khai tử");
		list_reg.addItem("Tờ khai đăng ký kết hôn");
		list_reg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox list = (JComboBox)e.getSource();
				switch((String)list.getSelectedItem()) {
				case "Tờ khai đăng ký khai sinh":
					dkks.displayTable(inf, tm);
					break;
				case "Tờ khai đăng ký khai tử":
					dkkt.displayTable(inf, tm);
					break;
				case "Tờ khai đăng ký kết hôn":
					dkkh.displayTable(inf, tm);
					break;
				}
			}
		});
		
		list_reg1.addItem("Sổ đăng ký khai sinh");
		list_reg1.addItem("Sổ đăng ký khai tử");
		list_reg1.addItem("Sổ đăng ký kết hôn");
		list_reg1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox list = (JComboBox)e.getSource();
				switch((String)list.getSelectedItem()) {
				case "Sổ đăng ký khai sinh":
					gks.displayTable(inf1, tm);
					break;
				case "Sổ đăng ký khai tử":
					tlkt.displayTable(inf1, tm);
					break;
				case "Sổ đăng ký kết hôn":
					gcnkh.displayTable(inf1, tm);
					break;
				}
			}	
		});
		
		buttons.add(list_reg);
		buttons1.add(list_reg1);
		buttons.add(b1);
		buttons.add(b2);
		if(Main.m.getL().getRole().equals("admin")) {
			buttons.add(b3);
			buttons.add(b4);
		}
		buttons.add(rf);
		buttons1.add(b1a);
		buttons1.add(b2a);
		buttons1.add(rf1);
		
		p4.setLayout(new BorderLayout());
		p4.add(scr, BorderLayout.CENTER);
		p4.add(buttons, BorderLayout.NORTH);
		
		p5.setLayout(new BorderLayout());
		p5.add(scr1, BorderLayout.CENTER);
		p5.add(buttons1, BorderLayout.NORTH);
		
		p6.setLayout(new BorderLayout());
		p6.add(scr2, BorderLayout.CENTER);
		p6.add(admincpb, BorderLayout.NORTH);
		
		System.out.println(Main.m.getL().getRole());
		tp.add(p4);
		tp.setTitleAt(0, "Danh sách tờ khai đăng ký hộ tịch");
		if(Main.m.getL().getRole().equals("admin")) {
			tp.add(p5);
			tp.setTitleAt(1, "Danh sách các việc hộ tịch được đăng ký");
			tp.add(p6);
			tp.setTitleAt(2, "Quản lý tài khoản");
		}
		
		tp.addChangeListener(this);
		this.dkks.displayTable(inf, tm);
		
		this.getContentPane().setPreferredSize(new Dimension(1280, 720));
		this.getContentPane().add(tp, BorderLayout.CENTER);
		this.getContentPane().add(status, BorderLayout.SOUTH);
		this.setTitle(s);
		this.addWindowListener(this);
		this.pack();
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case "Sửa tờ khai":
			if(list_reg.getSelectedIndex() == 0) this.dkks.setData();
			else if(list_reg.getSelectedIndex() == 1) this.dkkt.setData();
			else if(list_reg.getSelectedIndex() == 2) this.dkkh.setData();
			break;
		case "Thêm tờ khai":
			if(list_reg.getSelectedIndex() == 0) this.dkks.addData();
			else if(list_reg.getSelectedIndex() == 1) this.dkkt.addData();
			else if(list_reg.getSelectedIndex() == 2) this.dkkh.addData();
			break;
		case "Xóa tờ khai":
			if(list_reg.getSelectedIndex() == 0) this.dkks.removeData();
			else if(list_reg.getSelectedIndex() == 1) this.dkkt.removeData();
			else if(list_reg.getSelectedIndex() == 2) this.dkkh.removeData();
			break;
		case "Duyệt tờ khai":
			if(list_reg.getSelectedIndex() == 0) this.dkks.approveData();
			else if(list_reg.getSelectedIndex() == 1) this.dkkt.approveData();
			else if(list_reg.getSelectedIndex() == 2) this.dkkh.approveData();
			break;
		case "Xem chi tiết":
			if(list_reg1.getSelectedIndex() == 0) this.gks.viewData();
			else if(list_reg1.getSelectedIndex() == 1) this.tlkt.viewData();
			else if(list_reg1.getSelectedIndex() == 2) this.gcnkh.viewData();
			break;
		case "Xóa đăng ký":
			if(list_reg1.getSelectedIndex() == 0) this.gks.removeData();
			else if(list_reg1.getSelectedIndex() == 1) this.tlkt.removeData();
			else if(list_reg1.getSelectedIndex() == 2) this.gcnkh.removeData();
			break;
		case "Tải lại danh sách":
			if(tp.getSelectedIndex() == 0) {
				switch (list_reg.getSelectedIndex()) {
				case 0:
					this.dkks.displayTable(inf, tm);
					ncb.setText(String.valueOf(dkks.countData()));
					break;
				case 1:
					this.dkkt.displayTable(inf, tm);
					ncd.setText(String.valueOf(dkkt.countData()));
					break;
				case 2:
					this.dkkh.displayTable(inf, tm);
					ncm.setText(String.valueOf(dkkh.countData()));
					break;
				}
			}
			else if(tp.getSelectedIndex() == 1) {
				switch (list_reg1.getSelectedIndex()) {
				case 0:
					this.gks.displayTable(inf1, tm);
					ncb1.setText(String.valueOf(gks.countData()));
					break;
				case 1:
					this.tlkt.displayTable(inf1, tm);
					ncd1.setText(String.valueOf(tlkt.countData()));
					break;
				case 2:
					this.gcnkh.displayTable(inf1, tm);
					ncm1.setText(String.valueOf(gcnkh.countData()));
					break;
				}
			}
			else if(tp.getSelectedIndex() == 2) {
				Main.m.getL().displayTable(inf2, tm);
			}
			break;
		case "Thêm tài khoản":
			Main.m.getL().addAccount();
			break;
		case "Đổi mật khẩu":
			Main.m.getL().changePassword();
			break;
		case "Đổi vai trò":
			Main.m.getL().changeRole();
			break;
		case "Xóa tài khoản":
			Main.m.getL().removeAccount();
			break;
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		Main.m.setVisible(true);
		try {
			Main.m.getL().getConn().close();
			System.out.println("Closing connection");
		}
		catch(Exception e1) {
			
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JTabbedPane tp = (JTabbedPane)e.getSource();
		if(tp.getSelectedIndex() == 0) {
			dkks.displayTable(inf, tm);
		}
		else if(tp.getSelectedIndex() == 1) {
			gks.displayTable(inf1, tm);
		}
		else if(tp.getSelectedIndex() == 2) {
			Main.m.getL().displayTable(inf2, tm);
		}
	}
}
