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
	public ManagerInterface(String s) {
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		inf = new JTable();
		b1 = new JButton("Thêm tờ khai");
		b2 = new JButton("Sửa hồ sơ");
		b3 = new JButton("Xóa hồ sơ");
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
		DefaultTableModel tm = new DefaultTableModel() {
			@Override
			public int getColumnCount() {
				return 5;
			}
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		buttons = new JPanel();
		
		TKDKKS dkks = new TKDKKS();
		dkks.init();
		GKS gks = new GKS();
		gks.init();
		
		
		t.setBackground(Color.LIGHT_GRAY);
		
		p1.setPreferredSize(new Dimension(300, 720));
		p1.setLayout(new BorderLayout());
		p1.add(p2, BorderLayout.CENTER);
		p1.add(p3, BorderLayout.SOUTH);
		p1.setBackground(Color.GRAY);
		
		p2.setLayout(new BorderLayout());
		p2.add(t, BorderLayout.CENTER);
		
		
		
		p3.setPreferredSize(new Dimension(p1.getWidth(), 100));
		p3.setBackground(Color.GREEN);
		p3.setLayout(new BorderLayout());
		p3.add(l1, BorderLayout.NORTH);
		p3.add(bstat, BorderLayout.CENTER);
		
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
		//l1.setSize(200, 100);
		
		inf.setModel(tm);
		String colsName[] = {"Số hiệu", "Họ và tên", "Ngày sinh", "Giới tính", "Ngày đăng ký"};
		tm.setColumnIdentifiers(colsName);
		try {
			ResultSet rs = dkks.getStatement().executeQuery("select TKDKKS.IDTK, tenNDKS, ngaysinhNDKS, gioitinhNDKS, ngaydangky from TKDKKS order by IDTK");
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
		catch(Exception e) {
			e.printStackTrace();
		}
		
		inf.setVisible(true);
		inf.setSize(new Dimension(800, 600));
		scr.setViewportView(inf);;
		scr.setVisible(true);
		//scr.setLayout(new BorderLayout());
		
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
		this.getContentPane().add(p1, BorderLayout.WEST);
		this.getContentPane().add(tp, BorderLayout.CENTER);
		this.setTitle(s);
		this.addWindowListener(this);
		this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		Main.m.setVisible(true);
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
