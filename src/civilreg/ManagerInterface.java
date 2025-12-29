package civilreg;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ManagerInterface extends JFrame implements ActionListener, WindowListener {
	private JPanel p1, p2, p3, p4, p5;
	private JPanel bstat;
	//private DefaultTreeModel t;
	private JTable inf;
	private JScrollPane scr;
	private JButton b1, b2, b3;
	private JTabbedPane tp;
	private JLabel l1, cb, cd, cm, cc, ncb, ncd, ncm, ncc; 
	private JPanel buttons;
	private JComboBox list_reg;
	private GKS gks;
	private TKDKKS dkks;
	private TKDKKT dkkt;
	private TKDKKH dkkh;
	//private DefaultTableModel tm;
	public ManagerInterface(String s) {
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		inf = new JTable();
		b1 = new JButton("Thêm tờ khai");
		b2 = new JButton("Sửa tờ khai");
		b3 = new JButton("Xóa tờ khai");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		tp = new JTabbedPane();
		RegCategoryTree t = new RegCategoryTree();
		l1 = new JLabel("Thống kê cơ bản:");
		bstat = new JPanel();
		cb = new JLabel("Khai sinh:");
		cd = new JLabel("Khai tử:");
		cm = new JLabel("Kết hôn:");
		cc = new JLabel("Bản sao:");
		ncb = new JLabel();
		ncd = new JLabel();
		ncm = new JLabel();
		ncc = new JLabel();
		scr = new JScrollPane();
		buttons = new JPanel();
		list_reg = new JComboBox();
		
		dkks = new TKDKKS();
		dkks.init();
		gks = new GKS();
		gks.init();
		dkkt = new TKDKKT();
		dkkt.init();
		dkkh = new TKDKKH();
		dkkh.init();
		
		t.setBackground(Color.LIGHT_GRAY);
		
		bstat.setPreferredSize(new Dimension(p3.getWidth(), 75));
		bstat.setLayout(new GridLayout(2, 4));
		bstat.add(cb);
		bstat.add(ncb);
		bstat.add(cd);
		bstat.add(ncd);
		bstat.add(cm);
		bstat.add(ncm);
		bstat.add(cc);
		bstat.add(ncc);
		
		
		inf.setVisible(true);
		inf.setSize(new Dimension(800, 600));
		inf.getTableHeader().setReorderingAllowed(false);
		scr.setViewportView(inf);
		scr.setVisible(true);
		
		list_reg.addItem("Tờ khai đăng ký khai sinh");
		list_reg.addItem("Tờ khai đăng ký khai tử");
		list_reg.addItem("Tờ khai đăng ký kết hôn");
		list_reg.addItem("Tờ khai đề nghị cấp bản sao trích lục hộ tịch");
		list_reg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox list = (JComboBox)e.getSource();
				switch((String)list.getSelectedItem()) {
				case "Tờ khai đăng ký khai sinh":
					DefaultTableModel tm = new DefaultTableModel() {
						@Override
						public int getColumnCount() {
							return 5;
						}
						public boolean isCellEditable(int row, int col) {
							return false;
						}
					};
					inf.setModel(tm);
					String colsName_tkks[] = {"Số tờ khai", "Họ và tên", "Ngày sinh", "Giới tính", "Ngày đăng ký khai sinh"};
					tm.setColumnIdentifiers(colsName_tkks);
					try {
						ResultSet rs = dkks.getStatement().executeQuery("select IDTK, tenNDKS, ngaysinhNDKS, gioitinhNDKS, ngaydangky from TKDKKS order by IDTK");
						while(rs.next()) {
							String rows[] = new String[5];
							rows[0] = rs.getString("IDTK");
							rows[1] = rs.getString("tenNDKS");
							rows[2] = rs.getString("ngaysinhNDKS");
							rows[3] = rs.getString("gioitinhNDKS");
							rows[4] = rs.getString("ngaydangky");
							tm.addRow(rows);
						}
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					break;
				case "Tờ khai đăng ký khai tử":
					DefaultTableModel tm1 = new DefaultTableModel() {
						@Override
						public int getColumnCount() {
							return 6;
						}
						public boolean isCellEditable(int row, int col) {
							return false;
						}
					};
					inf.setModel(tm1);
					String colsName_tkkt[] = {"Số tờ khai", "Họ và tên", "Giới tính", "Ngày sinh", "Ngày mất", "Ngày đăng ký khai tử"};
					tm1.setColumnIdentifiers(colsName_tkkt);
					try {
						ResultSet rs = dkkt.getStatement().executeQuery("select IDTK, tenNDKT, gioitinhNDKT, ngaysinhNDKT, date(thoigianchet) as ngaymat, ngaydangky from TKDKKT order by IDTK");
						while(rs.next()) {
							String rows[] = new String[6];
							rows[0] = rs.getString("IDTK");
							rows[1] = rs.getString("tenNDKT");
							rows[2] = rs.getString("gioitinhNDKT");
							rows[3] = rs.getString("ngaysinhNDKT");
							rows[4] = rs.getString("ngaymat");
							rows[5] = rs.getString("ngaydangky");
							tm1.addRow(rows);
						}
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					break;
				case "Tờ khai đăng ký kết hôn":
					DefaultTableModel tm2 = new DefaultTableModel() {
						@Override
						public int getColumnCount() {
							return 6;
						}
						public boolean isCellEditable(int row, int col) {
							return false;
						}
					};
					inf.setModel(tm2);
					String colsName_tkkh[] = {"Số tờ khai", "Họ và tên bên nam", "Ngày sinh bên nam", "Họ và tên bên nữ", "Ngày sinh bên nữ", "Ngày đăng ký kết hôn"};
					tm2.setColumnIdentifiers(colsName_tkkh);
					try {
						ResultSet rs = dkkh.getStatement().executeQuery("select IDTK, tenNam, ngaysinhNam, tenNu, ngaysinhNu, ngaydangky from TKDKKH order by IDTK");
						while(rs.next()) {
							String rows[] = new String[6];
							rows[0] = rs.getString("IDTK");
							rows[1] = rs.getString("tenNam");
							rows[2] = rs.getString("ngaysinhNam");
							rows[3] = rs.getString("tenNu");
							rows[4] = rs.getString("ngaysinhNu");
							rows[5] = rs.getString("ngaydangky");
							tm2.addRow(rows);
						}
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					break;
				case "Tờ khai đề nghị cấp bản sao trích lục hộ tịch":
					
					break;
				}
			}
		});
		
		buttons.add(list_reg);
		buttons.add(b1);
		buttons.add(b2);
		buttons.add(b3);
		
		p4.setLayout(new BorderLayout());
		p4.add(scr, BorderLayout.CENTER);
		p4.add(buttons, BorderLayout.NORTH);
		
		//p5
		
		tp.add(p4);
		tp.add(p5);
		tp.setTitleAt(0, "Danh sách");
		tp.setTitleAt(1, "Thống kê");
		
		
		this.getContentPane().setPreferredSize(new Dimension(1280, 720));
		//this.getContentPane().add(p1, BorderLayout.WEST);
		this.getContentPane().add(tp, BorderLayout.CENTER);
		this.setTitle(s);
		this.addWindowListener(this);
		this.pack();
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
}
