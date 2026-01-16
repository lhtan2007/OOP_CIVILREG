package civilreg;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;

public class GKS extends RegDataManipulator implements ActionListener, ComponentListener{
	private Statement st;
	private PreparedStatement ps;
	private DefaultTableModel tm = new DefaultTableModel() {
		@Override
		public int getColumnCount() {
			return 5;
		}
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	};
	private String init = "create table GKS ("
			+ "SoGKS int auto_increment, "
			+ "IDTK int, "
			+ "primary key (SoGKS), "
			+ "foreign key (IDTK) references TKDKKS(IDTK))";
	JFrame edit_dialog;
	JTextField tenNYC_inp, ngsinhNYC_inp, nctNYC_inp, gtttNYC_inp, qhvoiNDKS_inp, dncapBS_inp;
	JTextField num_inp;
	JTextField tenNDKS_inp;
	JTextField ngsinhNDKS_inp;
	JTextField nsNDKSgbc_inp;
	JComboBox gtNDKS_inp;
	JTextField dtNDKS_inp;
	JTextField qtNDKS_inp;
	JTextField nsNDKS_inp;
	JTextField qqNDKS_inp;
	JTextField tenM_inp;
	JTextField ngsinhM_inp;
	JTextField dtM_inp;
	JTextField qtM_inp;
	JTextField nctM_inp;
	JTextField gtttM_inp;
	JTextField tenC_inp;
	JTextField ngsinhC_inp;
	JTextField dtC_inp;
	JTextField qtC_inp;
	JTextField nctC_inp;
	JTextField gtttC_inp;
	public GKS() {
		
	}
	public void init() {
		try {
			st = Main.m.getL().getConn().createStatement();
			try {
				//System.out.println(init);
				st.executeUpdate(init);
			}
			catch(Exception e1) {
				//e1.printStackTrace();
			}
		}
		catch(Exception e) {
			//e.printStackTrace();
		}
	}
	public Statement getStatement() {
		return st;
	}
	@Override
	void setData() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void removeData() {
		// TODO Auto-generated method stub
		edit_dialog = new JFrame("Xóa giấy khai sinh");
		edit_dialog.addComponentListener(this);
		edit_dialog.getContentPane().setPreferredSize(new Dimension(500, 60));
		edit_dialog.getContentPane().setLayout(new BorderLayout());
		
		JLabel num = new JLabel("Nhập số hiệu của giấy khai sinh cần xóa: ");
		num_inp = new JTextField();
		
		JButton accept = new JButton("OK");
		JButton cancel = new JButton("Hủy bỏ");
		accept.addActionListener(this);
		cancel.addActionListener(this);
		
		JPanel fields = new JPanel();
		fields.setLayout(new GridLayout(1, 2));
		fields.add(num);
		fields.add(num_inp);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
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
	void addData() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void approveData() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void viewData() {
		// TODO Auto-generated method stub
		edit_dialog = new JFrame("Chi tiết giấy khai sinh");
		edit_dialog.addComponentListener(this);
		edit_dialog.getContentPane().setPreferredSize(new Dimension(1200, 750));
		edit_dialog.getContentPane().setLayout(new GridLayout(25, 3));
		JLabel num = new JLabel("Số");
		num_inp = new JTextField();
		JButton check = new JButton("Kiểm tra");
		check.addActionListener(this);
		JLabel nyc = new JLabel("Thông tin về người yêu cầu");
		JLabel tenNYC = new JLabel("Họ, chữ đệm và tên");
		tenNYC_inp = new JTextField();
		JLabel ngsinhNYC = new JLabel("Ngày sinh");
		ngsinhNYC_inp = new JTextField();
		JLabel gtttNYC = new JLabel("Giấy tờ tùy thân");
		gtttNYC_inp = new JTextField();
		JLabel nctNYC = new JLabel("Nơi cư trú");
		nctNYC_inp = new JTextField();
		JLabel qhvoiNDKS = new JLabel("Quan hệ với người được khai sinh");
		qhvoiNDKS_inp = new JTextField();
		JLabel dncapBS = new JLabel("Số lượng bản sao đề nghị cấp");
		dncapBS_inp = new JTextField();
		JLabel ndks = new JLabel("Thông tin về người được khai sinh");
		JLabel tenNDKS = new JLabel("Họ, chữ đệm và tên");
		tenNDKS_inp = new JTextField();
		JLabel ngaysinhNDKS = new JLabel("Ngày sinh");
		ngsinhNDKS_inp = new JTextField();
		JLabel nsNDKSghibangchu = new JLabel("ghi bằng chữ");
		nsNDKSgbc_inp = new JTextField();
		JLabel gtNDKS = new JLabel("Giới tính");
		gtNDKS_inp = new JComboBox();
		gtNDKS_inp.addItem("Nam");
		gtNDKS_inp.addItem("Nữ");
		JLabel dtNDKS = new JLabel("Dân tộc");
		dtNDKS_inp = new JTextField();
		JLabel qtNDKS = new JLabel("Quốc tịch");
		qtNDKS_inp = new JTextField();
		JLabel nsNDKS = new JLabel("Nơi sinh");
		nsNDKS_inp = new JTextField();
		JLabel qqNDKS = new JLabel("Quê quán");
		qqNDKS_inp = new JTextField();
		JLabel m = new JLabel("Thông tin về người mẹ");
		JLabel tenM = new JLabel("Họ, chữ đệm và tên");
		tenM_inp = new JTextField();
		JLabel ngaysinhM = new JLabel("Ngày sinh");
		ngsinhM_inp = new JTextField();
		JLabel dtM = new JLabel("Dân tộc");
		dtM_inp = new JTextField();
		JLabel qtM = new JLabel("Quốc tịch");
		qtM_inp = new JTextField();
		JLabel nctM = new JLabel("Nơi cư trú");
		nctM_inp = new JTextField();
		JLabel gtttM = new JLabel("Giấy tờ tùy thân");
		gtttM_inp = new JTextField();
		JLabel c = new JLabel("Thông tin về người cha");
		JLabel tenC = new JLabel("Họ, chữ đệm và tên");
		tenC_inp = new JTextField();
		JLabel ngaysinhC = new JLabel("Ngày sinh");
		ngsinhC_inp = new JTextField();
		JLabel dtC = new JLabel("Dân tộc");
		dtC_inp = new JTextField();
		JLabel qtC = new JLabel("Quốc tịch");
		qtC_inp = new JTextField();
		JLabel nctC = new JLabel("Nơi cư trú");
		nctC_inp = new JTextField();
		JLabel gtttC = new JLabel("Giấy tờ tùy thân");
		gtttC_inp = new JTextField();
		
		tenNYC_inp.setEditable(false);
		ngsinhNYC_inp.setEditable(false);
		gtttNYC_inp.setEditable(false);
		nctNYC_inp.setEditable(false);
		qhvoiNDKS_inp.setEditable(false);
		dncapBS_inp.setEditable(false);
		tenNDKS_inp.setEditable(false);
		ngsinhNDKS_inp.setEditable(false);
		nsNDKSgbc_inp.setEditable(false);
		gtNDKS_inp.setEditable(false);
		gtNDKS_inp.setEnabled(false);
		dtNDKS_inp.setEditable(false);
		qtNDKS_inp.setEditable(false);
		nsNDKS_inp.setEditable(false);
		qqNDKS_inp.setEditable(false);
		tenM_inp.setEditable(false);
		ngsinhM_inp.setEditable(false);
		dtM_inp.setEditable(false);
		qtM_inp.setEditable(false);
		nctM_inp.setEditable(false);
		gtttM_inp.setEditable(false);
		tenC_inp.setEditable(false);
		ngsinhC_inp.setEditable(false);
		dtC_inp.setEditable(false);
		qtC_inp.setEditable(false);
		nctC_inp.setEditable(false);
		gtttC_inp.setEditable(false);
		
		JButton accept = new JButton("OK");
		JButton cancel = new JButton("Hủy bỏ");
		accept.addActionListener(this);
		cancel.addActionListener(this);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.add(accept);
		//buttons.add(cancel);
		
		edit_dialog.getContentPane().add(num);
		edit_dialog.getContentPane().add(num_inp);
		edit_dialog.getContentPane().add(check);
		edit_dialog.getContentPane().add(nyc);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(tenNYC);
		edit_dialog.getContentPane().add(ngsinhNYC);
		edit_dialog.getContentPane().add(gtttNYC);
		edit_dialog.getContentPane().add(tenNYC_inp);
		edit_dialog.getContentPane().add(ngsinhNYC_inp);
		edit_dialog.getContentPane().add(gtttNYC_inp);
		edit_dialog.getContentPane().add(nctNYC);
		edit_dialog.getContentPane().add(qhvoiNDKS);
		edit_dialog.getContentPane().add(dncapBS);
		edit_dialog.getContentPane().add(nctNYC_inp);
		edit_dialog.getContentPane().add(qhvoiNDKS_inp);
		edit_dialog.getContentPane().add(dncapBS_inp);
		edit_dialog.getContentPane().add(ndks);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(tenNDKS);
		edit_dialog.getContentPane().add(ngaysinhNDKS);
		edit_dialog.getContentPane().add(nsNDKSghibangchu);
		edit_dialog.getContentPane().add(tenNDKS_inp);
		edit_dialog.getContentPane().add(ngsinhNDKS_inp);
		edit_dialog.getContentPane().add(nsNDKSgbc_inp);
		edit_dialog.getContentPane().add(gtNDKS);
		edit_dialog.getContentPane().add(dtNDKS);
		edit_dialog.getContentPane().add(qtNDKS);
		edit_dialog.getContentPane().add(gtNDKS_inp);
		edit_dialog.getContentPane().add(dtNDKS_inp);
		edit_dialog.getContentPane().add(qtNDKS_inp);
		edit_dialog.getContentPane().add(nsNDKS);
		edit_dialog.getContentPane().add(qqNDKS);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(nsNDKS_inp);
		edit_dialog.getContentPane().add(qqNDKS_inp);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(m);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(tenM);
		edit_dialog.getContentPane().add(ngaysinhM);
		edit_dialog.getContentPane().add(dtM);
		edit_dialog.getContentPane().add(tenM_inp);
		edit_dialog.getContentPane().add(ngsinhM_inp);
		edit_dialog.getContentPane().add(dtM_inp);
		edit_dialog.getContentPane().add(qtM);
		edit_dialog.getContentPane().add(nctM);
		edit_dialog.getContentPane().add(gtttM);
		edit_dialog.getContentPane().add(qtM_inp);
		edit_dialog.getContentPane().add(nctM_inp);
		edit_dialog.getContentPane().add(gtttM_inp);
		edit_dialog.getContentPane().add(c);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(tenC);
		edit_dialog.getContentPane().add(ngaysinhC);
		edit_dialog.getContentPane().add(dtC);
		edit_dialog.getContentPane().add(tenC_inp);
		edit_dialog.getContentPane().add(ngsinhC_inp);
		edit_dialog.getContentPane().add(dtC_inp);
		edit_dialog.getContentPane().add(qtC);
		edit_dialog.getContentPane().add(nctC);
		edit_dialog.getContentPane().add(gtttC);
		edit_dialog.getContentPane().add(qtC_inp);
		edit_dialog.getContentPane().add(nctC_inp);
		edit_dialog.getContentPane().add(gtttC_inp);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(buttons);
		edit_dialog.getContentPane().add(new JLabel());
		
		edit_dialog.setResizable(false);
		edit_dialog.setVisible(true);
		edit_dialog.pack();
		edit_dialog.setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case "Kiểm tra":
			try {
				st = Main.m.getL().getConn().createStatement();
				ResultSet rs = st.executeQuery("select tenNYC, ngaysinhNYC, noicutruNYC, gtttNYC, qhvoiNDKS, "
						+ "tenNDKS, date(ngaysinhNDKS) as ngsinhNDKS, nsNDKSghibangchu, gioitinhNDKS, dantocNDKS, quoctichNDKS, noisinhNDKS, quequanNDKS, "
						+ "tenM, date(ngaysinhM) as ngsinhM, dantocM, quoctichM, noicutruM, gtttM, "
						+ "tenC, date(ngaysinhC) as ngsinhC, dantocC, quoctichC, noicutruC, gtttC, "
						+ "dncapBS from GKS inner join TKDKKS on GKS.IDTK = TKDKKS.IDTK where SoGKS = " + this.num_inp.getText());
				rs.next();
				tenNYC_inp.setText(rs.getString("tenNYC"));
				ngsinhNYC_inp.setText(rs.getString("ngaysinhNYC"));
				nctNYC_inp.setText(rs.getString("noicutruNYC"));
				gtttNYC_inp.setText(rs.getString("gtttNYC"));
				qhvoiNDKS_inp.setText(rs.getString("qhvoiNDKS"));
				dncapBS_inp.setText(rs.getString("dncapBS"));
				tenNDKS_inp.setText(rs.getString("tenNDKS"));
				ngsinhNDKS_inp.setText(rs.getString("ngsinhNDKS"));
				nsNDKSgbc_inp.setText(rs.getString("nsNDKSghibangchu"));
				if(rs.getBoolean("gioitinhNDKS") == false) gtNDKS_inp.setSelectedIndex(0);
				else gtNDKS_inp.setSelectedIndex(1);
				dtNDKS_inp.setText(rs.getString("dantocNDKS"));
				qtNDKS_inp.setText(rs.getString("quoctichNDKS"));
				nsNDKS_inp.setText(rs.getString("noisinhNDKS"));
				qqNDKS_inp.setText(rs.getString("quequanNDKS"));
				tenM_inp.setText(rs.getString("tenM"));
				ngsinhM_inp.setText(rs.getString("ngsinhM"));
				dtM_inp.setText(rs.getString("dantocM"));
				qtM_inp.setText(rs.getString("quoctichM"));
				nctM_inp.setText(rs.getString("noicutruM"));
				gtttM_inp.setText(rs.getString("gtttM"));
				tenC_inp.setText(rs.getString("tenC"));
				ngsinhC_inp.setText(rs.getString("ngsinhC"));
				dtC_inp.setText(rs.getString("dantocC"));
				qtC_inp.setText(rs.getString("quoctichC"));
				nctC_inp.setText(rs.getString("noicutruC"));
				gtttC_inp.setText(rs.getString("gtttC"));
				
			}
			catch(Exception e1) {
				JFrame notFound = new JFrame();
				JOptionPane nf = new JOptionPane();
				nf.setVisible(true);
				nf.showMessageDialog(notFound, "Không tìm thấy giấy khai sinh số " + num_inp.getText() + " trong CSDL.", 
						"Tìm kiếm thất bại", JOptionPane.ERROR_MESSAGE);
			}
			finally {
				break;
			}
		case "OK":
			if(edit_dialog.getTitle().equals("Chi tiết giấy khai sinh")) {
				edit_dialog.setVisible(false);
				break;
			}
			else if(edit_dialog.getTitle().equals("Xóa giấy khai sinh")) {
				try {
					ps = Main.m.getL().getConn().prepareStatement("delete from GKS where SoGKS = ?");
					ps.setString(1, num_inp.getText());
					if(ps.executeUpdate() == 1) {
						JFrame modified = new JFrame();
						JOptionPane m = new JOptionPane();
						m.setVisible(true);
						m.showMessageDialog(modified, "Đã xóa thành công giấy khai sinh số " + num_inp.getText() + ".", "Xóa thành công", JOptionPane.INFORMATION_MESSAGE);
						num_inp.setText("");
						edit_dialog.setVisible(false);
					}
					else {
						JFrame notModified = new JFrame();
						JOptionPane nm = new JOptionPane();
						nm.setVisible(true);
						nm.showMessageDialog(notModified, "Không có giấy khai sinh số " + num_inp.getText() + " trong CSDL.", "Xóa hồ sơ thất bại", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				catch(Exception e2) {
					e2.printStackTrace();
					JFrame notModified = new JFrame();
					JOptionPane nm = new JOptionPane();
					nm.setVisible(true);
					nm.showMessageDialog(notModified, "Dữ liệu nhập vào không hợp lệ.", "Xóa hồ sơ thất bại", JOptionPane.ERROR_MESSAGE);
				}
				finally {
					edit_dialog.setVisible(false);
					break;
				}
			}
		case "Hủy bỏ":
			edit_dialog.setVisible(false);
			break;
		}	
	}
	@Override
	int countData() {
		int cnt = 0;
		try {
			ResultSet rs = st.executeQuery("select count(SoGKS) from GKS");
			if(rs.next()) cnt = rs.getInt(1);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	void displayTable(JTable inf, DefaultTableModel tm) {
		tm = this.tm;
		inf.setModel(tm);
		tm.setRowCount(0);
		String colsName_tkks[] = {"Số GKS", "Họ và tên", "Ngày sinh", "Giới tính", "Ngày đăng ký khai sinh"};
		tm.setColumnIdentifiers(colsName_tkks);
		try {
			ResultSet rs = st.executeQuery("select SoGKS, tenNDKS, ngaysinhNDKS, gioitinhNDKS, ngaydangky from GKS inner join TKDKKS on GKS.IDTK = TKDKKS.IDTK order by SoGKS");
			while(rs.next()) {
				String rows[] = new String[5];
				rows[0] = rs.getString("SoGKS");
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
		tm.setRowCount(0);
		this.displayTable(Main.m.getL().mi.getTable(), tm);
	}
}
