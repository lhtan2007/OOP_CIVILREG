package civilreg;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;

public class GCNKH extends RegDataManipulator implements ActionListener, ComponentListener{
	private Statement st;
	private PreparedStatement ps;
	private DefaultTableModel tm = new DefaultTableModel() {
		@Override
		public int getColumnCount() {
			return 6;
		}
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	};
	private String init = "create table GCNKH ("
			+ "SoGCNKH int auto_increment, "
			+ "IDTK int, "
			+ "primary key (SoGCNKH), "
			+ "foreign key (IDTK) references TKDKKH(IDTK))";
	JFrame edit_dialog;
	JTextField num_inp, tenNu_inp, ngsinhNu_inp, dtNu_inp, qtNu_inp, nctNu_inp, gtttNu_inp, slKHNu_inp;
	JTextField tenNam_inp, ngsinhNam_inp, dtNam_inp, qtNam_inp, nctNam_inp, gtttNam_inp, slKHNam_inp;
	JTextField dncapBS_inp;
	public GCNKH() {
		
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
		edit_dialog = new JFrame("Xóa giấy chứng nhận kết hôn");
		edit_dialog.addComponentListener(this);
		edit_dialog.getContentPane().setPreferredSize(new Dimension(500, 60));
		edit_dialog.getContentPane().setLayout(new BorderLayout());
		
		JLabel num = new JLabel("Nhập số hiệu của GCN kết hôn cần xóa: ");
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
		edit_dialog = new JFrame("Chi tiết giấy chứng nhận kết hôn");
		edit_dialog.addComponentListener(this);
		edit_dialog.getContentPane().setPreferredSize(new Dimension(1200, 550));
		edit_dialog.getContentPane().setLayout(new GridLayout(17, 3));
		JLabel num = new JLabel("Số");
		num_inp = new JTextField();
		JButton check = new JButton("Kiểm tra");
		check.addActionListener(this);
		JLabel bn1 = new JLabel("Thông tin về bên nữ");
		JLabel tenNu = new JLabel("Họ, chữ đệm và tên");
		tenNu_inp = new JTextField();
		JLabel ngsinhNu = new JLabel("Ngày sinh (yyyy-mm-dd)");
		ngsinhNu_inp = new JTextField();
		JLabel dtNu = new JLabel("Dân tộc");
		dtNu_inp = new JTextField();
		JLabel qtNu = new JLabel("Quốc tịch");
		qtNu_inp = new JTextField();
		JLabel nctNu = new JLabel("Nơi cư trú");
		nctNu_inp = new JTextField();
		JLabel gtttNu = new JLabel("Giấy tờ tùy thân");
		gtttNu_inp = new JTextField();
		JLabel slKHNu = new JLabel("Kết hôn lần thứ mấy");
		slKHNu_inp = new JTextField();
		JLabel bn2 = new JLabel("Thông tin về bên nam");
		JLabel tenNam = new JLabel("Họ, chữ đệm và tên");
		tenNam_inp = new JTextField();
		JLabel ngsinhNam = new JLabel("Ngày sinh (yyyy-mm-dd)");
		ngsinhNam_inp = new JTextField();
		JLabel dtNam = new JLabel("Dân tộc");
		dtNam_inp = new JTextField();
		JLabel qtNam = new JLabel("Quốc tịch");
		qtNam_inp = new JTextField();
		JLabel nctNam = new JLabel("Nơi cư trú");
		nctNam_inp = new JTextField();
		JLabel gtttNam = new JLabel("Giấy tờ tùy thân");
		gtttNam_inp = new JTextField();
		JLabel slKHNam = new JLabel("Kết hôn lần thứ mấy");
		slKHNam_inp = new JTextField();
		JLabel dncapBS = new JLabel("Số bản sao đề nghị cấp");
		dncapBS_inp = new JTextField();
		
		tenNu_inp.setEditable(false);
		ngsinhNu_inp.setEditable(false);
		dtNu_inp.setEditable(false);
		qtNu_inp.setEditable(false);
		nctNu_inp.setEditable(false);
		gtttNu_inp.setEditable(false);
		slKHNu_inp.setEditable(false);
		tenNam_inp.setEditable(false);
		ngsinhNam_inp.setEditable(false);
		dtNam_inp.setEditable(false);
		qtNam_inp.setEditable(false);
		nctNam_inp.setEditable(false);
		gtttNam_inp.setEditable(false);
		slKHNam_inp.setEditable(false);
		dncapBS_inp.setEditable(false);
		
		JButton accept = new JButton("OK");
		accept.addActionListener(this);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.add(accept);
		
		edit_dialog.getContentPane().add(num);
		edit_dialog.getContentPane().add(num_inp);
		edit_dialog.getContentPane().add(check);
		edit_dialog.getContentPane().add(dncapBS);
		edit_dialog.getContentPane().add(dncapBS_inp);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(bn1);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(tenNu);
		edit_dialog.getContentPane().add(ngsinhNu);
		edit_dialog.getContentPane().add(dtNu);
		edit_dialog.getContentPane().add(tenNu_inp);
		edit_dialog.getContentPane().add(ngsinhNu_inp);
		edit_dialog.getContentPane().add(dtNu_inp);
		edit_dialog.getContentPane().add(qtNu);
		edit_dialog.getContentPane().add(nctNu);
		edit_dialog.getContentPane().add(gtttNu);
		edit_dialog.getContentPane().add(qtNu_inp);
		edit_dialog.getContentPane().add(nctNu_inp);
		edit_dialog.getContentPane().add(gtttNu_inp);
		edit_dialog.getContentPane().add(slKHNu);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(slKHNu_inp);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(bn2);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(tenNam);
		edit_dialog.getContentPane().add(ngsinhNam);
		edit_dialog.getContentPane().add(dtNam);
		edit_dialog.getContentPane().add(tenNam_inp);
		edit_dialog.getContentPane().add(ngsinhNam_inp);
		edit_dialog.getContentPane().add(dtNam_inp);
		edit_dialog.getContentPane().add(qtNam);
		edit_dialog.getContentPane().add(nctNam);
		edit_dialog.getContentPane().add(gtttNam);
		edit_dialog.getContentPane().add(qtNam_inp);
		edit_dialog.getContentPane().add(nctNam_inp);
		edit_dialog.getContentPane().add(gtttNam_inp);
		edit_dialog.getContentPane().add(slKHNam);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(slKHNam_inp);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(new JLabel());
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
				ResultSet rs = st.executeQuery(
						"select tenNu, ngaysinhNu, dantocNu, quoctichNu, noicutruNu, gtttNu, solanKHNu, "
						+ "tenNam, ngaysinhNam, dantocNam, quoctichNam, noicutruNam, gtttNam, solanKHNam, "
						+ "dncapBS from GCNKH inner join TKDKKH on GCNKH.IDTK = TKDKKH.IDTK where SoGCNKH = " + num_inp.getText());
				rs.next();
				tenNu_inp.setText(rs.getString("tenNu"));
				ngsinhNu_inp.setText(rs.getString("ngaysinhNu"));
				dtNu_inp.setText(rs.getString("dantocNu"));
				qtNu_inp.setText(rs.getString("quoctichNu"));
				nctNu_inp.setText(rs.getString("noicutruNu"));
				gtttNu_inp.setText(rs.getString("gtttNu"));
				slKHNu_inp.setText(rs.getString("solanKHNu"));
				tenNam_inp.setText(rs.getString("tenNam"));
				ngsinhNam_inp.setText(rs.getString("ngaysinhNam"));
				dtNam_inp.setText(rs.getString("dantocNam"));
				qtNam_inp.setText(rs.getString("quoctichNam"));
				nctNam_inp.setText(rs.getString("noicutruNam"));
				gtttNam_inp.setText(rs.getString("gtttNam"));
				slKHNam_inp.setText(rs.getString("solanKHNam"));
				dncapBS_inp.setText(rs.getString("dncapBS"));
			}
			catch(Exception e2) {
				JFrame notFound = new JFrame();
				JOptionPane nf = new JOptionPane();
				nf.setVisible(true);
				nf.showMessageDialog(notFound, "Không tìm thấy giấy chứng nhận kết hôn số " + num_inp.getText() + " trong CSDL.", 
						"Tìm kiếm thất bại", JOptionPane.ERROR_MESSAGE);
			}
			finally {
				break;
			}
		case "OK":
			if(edit_dialog.getTitle().equals("Chi tiết giấy chứng nhận kết hôn")) {
				edit_dialog.setVisible(false);
				break;
			}
			else if(edit_dialog.getTitle().equals("Xóa giấy chứng nhận kết hôn")) {
				try {
					ps = Main.m.getL().getConn().prepareStatement("delete from GCNKH where SoGCNKH = ?");
					ps.setString(1, num_inp.getText());
					ResultSet rs = st.executeQuery("select IDTK from GCNKH where SoGCNKH = " + num_inp.getText());
					if(ps.executeUpdate() == 1 && rs.next() == true) {
						JFrame modified = new JFrame();
						JOptionPane m = new JOptionPane();
						m.setVisible(true);
						m.showMessageDialog(modified, "Đã xóa thành công giấy chứng nhận kết hôn số " + num_inp.getText() + ".", "Xóa thành công", JOptionPane.INFORMATION_MESSAGE);
						st.executeUpdate("update TKDKKH set pheduyet = 0 where IDTK = " + rs.getString("IDTK"));
						num_inp.setText("");
						edit_dialog.setVisible(false);
					}
					else {
						JFrame notModified = new JFrame();
						JOptionPane nm = new JOptionPane();
						nm.setVisible(true);
						nm.showMessageDialog(notModified, "Không có giấy chứng nhận kết hôn số " + num_inp.getText() + " trong CSDL.", "Xóa hồ sơ thất bại", JOptionPane.ERROR_MESSAGE);
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
			ResultSet rs = st.executeQuery("select count(SoGCNKH) from GCNKH");
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
		String colsName_tkkh[] = {"Số GCNKH", "Họ và tên bên nam", "Ngày sinh bên nam", "Họ và tên bên nữ", "Ngày sinh bên nữ", "Ngày đăng ký kết hôn"};
		tm.setColumnIdentifiers(colsName_tkkh);
		try {
			ResultSet rs = st.executeQuery("select SoGCNKH, tenNam, ngaysinhNam, tenNu, ngaysinhNu, ngaydangky from GCNKH inner join TKDKKH on GCNKH.IDTK = TKDKKH.IDTK order by SoGCNKH");
			while(rs.next()) {
				String rows[] = new String[6];
				rows[0] = rs.getString("SoGCNKH");
				rows[1] = rs.getString("tenNam");
				rows[2] = rs.getString("ngaysinhNam");
				rows[3] = rs.getString("tenNu");
				rows[4] = rs.getString("ngaysinhNu");
				rows[5] = rs.getString("ngaydangky");
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
