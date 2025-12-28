package civilreg;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.Calendar;

public class TKDKKT extends RegDataManipulator implements ActionListener{
	private Statement st;
	private PreparedStatement ps;
	private String init = "create table TKDKKT ("
			+ "IDTK int auto_increment, "
			+ "tenNYC varchar(50) not null, "
			+ "ngaysinhNYC date not null, "
			+ "noicutruNYC varchar(255) not null, "
			+ "gtttNYC varchar(50) not null, "
			+ "qhvoiNDKT varchar(20) not null, "
			+ "tenNDKT varchar(50) not null, "
			+ "ngaysinhNDKT datetime not null, "
			+ "gioitinhNDKT boolean not null, "
			+ "dantocNDKT varchar(20) not null, "
			+ "quoctichNDKT varchar(20) not null, "
			+ "noicutruNDKT varchar(255) not null, "
			+ "gtttNDKT varchar(50) not null, "
			+ "thoigianchet datetime not null, "
			+ "noichet varchar(255) not null, "
			+ "nguyennhanchet varchar(255) not null, "
			+ "soGBT varchar(20) not null, "
			+ "noicapGBT varchar(255) not null, "
			+ "ngaycapGBT date not null, "
			+ "ngaydangky datetime, "
			+ "dncapBS int not null, "
			+ "pheduyet boolean, "
			+ "primary key (IDTK))";
	JFrame edit_dialog;
	JTextField num_inp, tenNYC_inp, ngsinhNYC_inp, nctNYC_inp, gtttNYC_inp, qhvoiNDKT_inp;
	JTextField tenNDKT_inp, ngsinhNDKT_inp;
	JComboBox gtNDKT_inp;
	JTextField dtNDKT_inp, qtNDKT_inp, nctNDKT_inp, gtttNDKT_inp, tgchet_inp, noichet_inp, nnchet_inp;
	JTextField soGBT_inp, ncGBT_inp, ngcapGBT_inp, dncapBS_inp;
	
	public TKDKKT() {
		
	}
	public void init() {
		try {
			st = Main.m.getL().getConn().createStatement();
			try {
				System.out.println(init);
				st.executeUpdate(init);
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Statement getStatement() {
		return st;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case "Kiểm tra":
			try {
				st = Main.m.getL().getConn().createStatement();
				ResultSet rs = st.executeQuery(
						"select tenNYC, ngaysinhNYC, noicutruNYC, gtttNYC, qhvoiNDKT, dncapBS, "
						+ "tenNDKT, date(ngaysinhNDKT) as ngsinhNDKT, gioitinhNDKT, dantocNDKT, quoctichNDKT, "
						+ "noicutruNDKT, gtttNDKT, thoigianchet, noichet, nguyennhanchet, "
						+ "soGBT, noicapGBT, ngaycapGBT "
						+ "from TKDKKT where IDTK = " + this.num_inp.getText());
				rs.next();
				tenNYC_inp.setText(rs.getString("tenNYC"));
				ngsinhNYC_inp.setText(rs.getString("ngaysinhNYC"));
				nctNYC_inp.setText(rs.getString("noicutruNYC"));
				gtttNYC_inp.setText(rs.getString("gtttNYC"));
				qhvoiNDKT_inp.setText(rs.getString("qhvoiNDKT"));
				dncapBS_inp.setText(rs.getString("dncapBS"));
				tenNDKT_inp.setText(rs.getString("tenNDKT"));
				ngsinhNDKT_inp.setText(rs.getString("ngsinhNDKT"));
				if(rs.getBoolean("gioitinhNDKT") == false) gtNDKT_inp.setSelectedIndex(0);
				else gtNDKT_inp.setSelectedIndex(1);
				dtNDKT_inp.setText(rs.getString("dantocNDKT"));
				qtNDKT_inp.setText(rs.getString("quoctichNDKT"));
				nctNDKT_inp.setText(rs.getString("noicutruNDKT"));
				gtttNDKT_inp.setText(rs.getString("gtttNDKT"));
				tgchet_inp.setText(rs.getString("thoigianchet"));
				noichet_inp.setText(rs.getString("noichet"));
				nnchet_inp.setText(rs.getString("nguyennhanchet"));
				soGBT_inp.setText(rs.getString("soGBT"));
				ncGBT_inp.setText(rs.getString("noicapGBT"));
				ngcapGBT_inp.setText(rs.getString("ngaycapGBT"));
			}
			catch(Exception e2) {
				JFrame notFound = new JFrame();
				JOptionPane nf = new JOptionPane();
				nf.setVisible(true);
				nf.showMessageDialog(notFound, "Không tìm thấy tờ khai số " + num_inp.getText() + " trong CSDL.", 
						"Tìm kiếm thất bại", JOptionPane.ERROR_MESSAGE);
			}
			finally {
				break;
			}
		case "OK":
			if(edit_dialog.getTitle().equals("Sửa tờ khai")) {
				try {
					ps = Main.m.getL().getConn().prepareStatement(
							"update TKDKKT set "
							+ "tenNYC = ?, ngaysinhNYC = ?, noicutruNYC = ?, gtttNYC = ?, qhvoiNDKT = ?, dncapBS = ?, "
							+ "tenNDKT = ?, ngaysinhNDKT = ?, gioitinhNDKT = ?, dantocNDKT = ?, quoctichNDKT = ?, "
							+ "noicutruNDKT = ?, gtttNDKT = ?, thoigianchet = ?, noichet = ?, nguyennhanchet = ?, "
							+ "soGBT = ?, noicapGBT = ?, ngaycapGBT = ? where IDTK = ?");
					ps.setString(1, tenNYC_inp.getText().toUpperCase());
					ps.setString(2, ngsinhNYC_inp.getText().strip().replaceAll("\\s+", ""));
					ps.setString(3, nctNYC_inp.getText());
					ps.setString(4, gtttNYC_inp.getText());
					ps.setString(5, qhvoiNDKT_inp.getText());
					ps.setInt(6, Integer.valueOf(dncapBS_inp.getText()));
					ps.setString(7, tenNDKT_inp.getText().toUpperCase());
					ps.setString(8, ngsinhNDKT_inp.getText().strip().replaceAll("\\s+", ""));
					if(gtNDKT_inp.getSelectedItem().toString().equals("Nam")) ps.setBoolean(9, false);
					else ps.setBoolean(9, true);
					ps.setString(10, dtNDKT_inp.getText());
					ps.setString(11, qtNDKT_inp.getText());
					ps.setString(12, nctNDKT_inp.getText());
					ps.setString(13, gtttNDKT_inp.getText());
					ps.setString(14, tgchet_inp.getText());
					ps.setString(15, noichet_inp.getText());
					ps.setString(16, nnchet_inp.getText());
					ps.setString(17, soGBT_inp.getText());
					ps.setString(18, ncGBT_inp.getText());
					ps.setString(19, ngcapGBT_inp.getText());
					ps.setString(20, num_inp.getText());
					ps.executeUpdate();
					
					JFrame modified = new JFrame();
					JOptionPane m = new JOptionPane();
					m.setVisible(true);
					m.showMessageDialog(modified, "Đã chỉnh sửa thành công tờ khai số " + num_inp.getText(), "Chỉnh sửa thành công", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e2) {
					e2.printStackTrace();
					JFrame notModified = new JFrame();
					JOptionPane nm = new JOptionPane();
					nm.setVisible(true);
					nm.showMessageDialog(notModified, "Không chỉnh sửa được tờ khai. Xin vui lòng kiểm tra lại dữ liệu đầu vào.\n"
							+ "Lưu ý: thông tin về người đã chết không được để trống.\n"
							+ "Các trường thông tin ghi ngày nhập theo định dạng \"năm - tháng - ngày\".", 
							"Lỗi chỉnh sửa", JOptionPane.ERROR_MESSAGE);
				}
				finally {
					break;
				}
			}
			else if(edit_dialog.getTitle().equals("Thêm tờ khai")) {
				try {
					ps = Main.m.getL().getConn().prepareStatement(
							"insert into TKDKKT ("
							+ "tenNYC, ngaysinhNYC, noicutruNYC, gtttNYC, qhvoiNDKT, dncapBS, "
							+ "tenNDKT, ngaysinhNDKT, gioitinhNDKT, dantocNDKT, quoctichNDKT, "
							+ "noicutruNDKT, gtttNDKT, thoigianchet, noichet, nguyennhanchet, "
							+ "soGBT, noicapGBT, ngaycapGBT, ngaydangky) "
							+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					ps.setString(1, tenNYC_inp.getText().toUpperCase());
					ps.setString(2, ngsinhNYC_inp.getText().strip().replaceAll("\\s+", ""));
					ps.setString(3, nctNYC_inp.getText());
					ps.setString(4, gtttNYC_inp.getText());
					ps.setString(5, qhvoiNDKT_inp.getText());
					ps.setInt(6, Integer.valueOf(dncapBS_inp.getText()));
					ps.setString(7, tenNDKT_inp.getText().toUpperCase());
					ps.setString(8, ngsinhNDKT_inp.getText().strip().replaceAll("\\s+", ""));
					if(gtNDKT_inp.getSelectedItem().toString().equals("Nam")) ps.setBoolean(9, false);
					else ps.setBoolean(9, true);
					ps.setString(10, dtNDKT_inp.getText());
					ps.setString(11, qtNDKT_inp.getText());
					ps.setString(12, nctNDKT_inp.getText());
					ps.setString(13, gtttNDKT_inp.getText());
					ps.setString(14, tgchet_inp.getText());
					ps.setString(15, noichet_inp.getText());
					ps.setString(16, nnchet_inp.getText());
					ps.setString(17, soGBT_inp.getText());
					ps.setString(18, ncGBT_inp.getText());
					ps.setString(19, ngcapGBT_inp.getText());
					ps.setString(20, num_inp.getText());
					ps.executeUpdate();
					Statement ps1 = Main.m.getL().getConn().createStatement();
					ResultSet rs1 = ps1.executeQuery("select IDTK from TKDKKT order by IDTK desc limit 1");
					rs1.next();
					
					JFrame modified = new JFrame();
					JOptionPane m = new JOptionPane();
					m.setVisible(true);
					m.showMessageDialog(modified, "Đã thêm thành công tờ khai số " + rs1.getString(1), "Chỉnh sửa thành công", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e2) {
					e2.printStackTrace();
					JFrame notModified = new JFrame();
					JOptionPane nm = new JOptionPane();
					nm.setVisible(true);
					nm.showMessageDialog(notModified, "Không thêm được tờ khai. Xin vui lòng kiểm tra lại dữ liệu đầu vào.\n"
							+ "Lưu ý: thông tin về người đã chết không được để trống.\n"
							+ "Các trường thông tin ghi ngày nhập theo định dạng \"năm - tháng - ngày\".", 
							"Lỗi dữ liệu", JOptionPane.ERROR_MESSAGE);
				}
				finally {
					break;
				}
			}
		case "Hủy bỏ":
			edit_dialog.setVisible(false);
			break;
		}
	}
	@Override
	void addData() {
		// TODO Auto-generated method stub
		edit_dialog = new JFrame("Thêm tờ khai");
		edit_dialog.getContentPane().setPreferredSize(new Dimension(1200, 550));
		edit_dialog.getContentPane().setLayout(new GridLayout(17, 3));
		JLabel nyc = new JLabel("Thông tin về người yêu cầu");
		JLabel tenNYC = new JLabel("Họ, chữ đệm và tên");
		tenNYC_inp = new JTextField();
		JLabel ngsinhNYC = new JLabel("Ngày sinh (yyyy-mm-dd)");
		ngsinhNYC_inp = new JTextField();
		JLabel gtttNYC = new JLabel("Giấy tờ tùy thân");
		gtttNYC_inp = new JTextField();
		JLabel nctNYC = new JLabel("Nơi cư trú");
		nctNYC_inp = new JTextField();
		JLabel qhvoiNDKT = new JLabel("Quan hệ với người đã chết");
		qhvoiNDKT_inp = new JTextField();
		JLabel dncapBS = new JLabel("Số lượng bản sao đề nghị cấp");
		dncapBS_inp = new JTextField();
		JLabel ndkt = new JLabel("Thông tin về người đã chết");
		JLabel tenNDKT = new JLabel("Họ, chữ đệm và tên");
		tenNDKT_inp = new JTextField();
		JLabel ngaysinhNDKT = new JLabel("Ngày sinh (yyyy-mm-dd)");
		ngsinhNDKT_inp = new JTextField();
		JLabel gtNDKT = new JLabel("Giới tính");
		gtNDKT_inp = new JComboBox();
		gtNDKT_inp.addItem("Nam");
		gtNDKT_inp.addItem("Nữ");
		JLabel dtNDKT = new JLabel("Dân tộc");
		dtNDKT_inp = new JTextField();
		JLabel qtNDKT = new JLabel("Quốc tịch");
		qtNDKT_inp = new JTextField();
		JLabel nctNDKT = new JLabel("Nơi cư trú cuối cùng");
		nctNDKT_inp = new JTextField();
		JLabel gtttNDKT = new JLabel("Giấy tờ tùy thân");
		gtttNDKT_inp = new JTextField();
		JLabel thoigianchet = new JLabel("Thời gian chết (yyyy-mm-dd hh:mm:ss)");
		tgchet_inp = new JTextField();
		JLabel noichet = new JLabel("Nơi chết");
		noichet_inp = new JTextField();
		JLabel nguyennhanchet = new JLabel("Nguyên nhân chết");
		nnchet_inp = new JTextField();
		JLabel soGBT = new JLabel("Số Giấy báo tử/Giấy tờ thay thế Giấy báo tử");
		soGBT_inp = new JTextField();
		JLabel noicapGBT = new JLabel("Nơi cấp");
		ncGBT_inp = new JTextField();
		JLabel ngaycapGBT = new JLabel("Ngày cấp (yyyy-mm-dd)");
		ngcapGBT_inp = new JTextField();
		
		JButton accept = new JButton("OK");
		JButton cancel = new JButton("Hủy bỏ");
		accept.addActionListener(this);
		cancel.addActionListener(this);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.add(accept);
		buttons.add(cancel);
		
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
		edit_dialog.getContentPane().add(qhvoiNDKT);
		edit_dialog.getContentPane().add(dncapBS);
		edit_dialog.getContentPane().add(nctNYC_inp);
		edit_dialog.getContentPane().add(qhvoiNDKT_inp);
		edit_dialog.getContentPane().add(dncapBS_inp);
		edit_dialog.getContentPane().add(ndkt);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(tenNDKT);
		edit_dialog.getContentPane().add(ngaysinhNDKT);
		edit_dialog.getContentPane().add(gtNDKT);
		edit_dialog.getContentPane().add(tenNDKT_inp);
		edit_dialog.getContentPane().add(ngsinhNDKT_inp);
		edit_dialog.getContentPane().add(gtNDKT_inp);
		edit_dialog.getContentPane().add(dtNDKT);
		edit_dialog.getContentPane().add(qtNDKT);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(dtNDKT_inp);
		edit_dialog.getContentPane().add(qtNDKT_inp);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(nctNDKT);
		edit_dialog.getContentPane().add(gtttNDKT);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(nctNDKT_inp);
		edit_dialog.getContentPane().add(gtttNDKT_inp);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(thoigianchet);
		edit_dialog.getContentPane().add(noichet);
		edit_dialog.getContentPane().add(nguyennhanchet);
		edit_dialog.getContentPane().add(tgchet_inp);
		edit_dialog.getContentPane().add(noichet_inp);
		edit_dialog.getContentPane().add(nnchet_inp);
		edit_dialog.getContentPane().add(soGBT);
		edit_dialog.getContentPane().add(noicapGBT);
		edit_dialog.getContentPane().add(ngaycapGBT);
		edit_dialog.getContentPane().add(soGBT_inp);
		edit_dialog.getContentPane().add(ncGBT_inp);
		edit_dialog.getContentPane().add(ngcapGBT_inp);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(buttons);
		edit_dialog.getContentPane().add(new JLabel());
		
		edit_dialog.setResizable(false);
		edit_dialog.setVisible(true);
		edit_dialog.pack();
	}
	@Override
	void setData() {
		// TODO Auto-generated method stub
		edit_dialog = new JFrame("Sửa tờ khai");
		edit_dialog.getContentPane().setPreferredSize(new Dimension(1200, 550));
		edit_dialog.getContentPane().setLayout(new GridLayout(18, 3));
		JLabel num = new JLabel("Số");
		num_inp = new JTextField();
		JButton check = new JButton("Kiểm tra");
		check.addActionListener(this);
		JLabel nyc = new JLabel("Thông tin về người yêu cầu");
		JLabel tenNYC = new JLabel("Họ, chữ đệm và tên");
		tenNYC_inp = new JTextField();
		JLabel ngsinhNYC = new JLabel("Ngày sinh (yyyy-mm-dd)");
		ngsinhNYC_inp = new JTextField();
		JLabel gtttNYC = new JLabel("Giấy tờ tùy thân");
		gtttNYC_inp = new JTextField();
		JLabel nctNYC = new JLabel("Nơi cư trú");
		nctNYC_inp = new JTextField();
		JLabel qhvoiNDKT = new JLabel("Quan hệ với người đã chết");
		qhvoiNDKT_inp = new JTextField();
		JLabel dncapBS = new JLabel("Số lượng bản sao đề nghị cấp");
		dncapBS_inp = new JTextField();
		JLabel ndkt = new JLabel("Thông tin về người đã chết");
		JLabel tenNDKT = new JLabel("Họ, chữ đệm và tên");
		tenNDKT_inp = new JTextField();
		JLabel ngaysinhNDKT = new JLabel("Ngày sinh (yyyy-mm-dd)");
		ngsinhNDKT_inp = new JTextField();
		JLabel gtNDKT = new JLabel("Giới tính");
		gtNDKT_inp = new JComboBox();
		gtNDKT_inp.addItem("Nam");
		gtNDKT_inp.addItem("Nữ");
		JLabel dtNDKT = new JLabel("Dân tộc");
		dtNDKT_inp = new JTextField();
		JLabel qtNDKT = new JLabel("Quốc tịch");
		qtNDKT_inp = new JTextField();
		JLabel nctNDKT = new JLabel("Nơi cư trú cuối cùng");
		nctNDKT_inp = new JTextField();
		JLabel gtttNDKT = new JLabel("Giấy tờ tùy thân");
		gtttNDKT_inp = new JTextField();
		JLabel thoigianchet = new JLabel("Thời gian chết (yyyy-mm-dd hh:mm:ss)");
		tgchet_inp = new JTextField();
		JLabel noichet = new JLabel("Nơi chết");
		noichet_inp = new JTextField();
		JLabel nguyennhanchet = new JLabel("Nguyên nhân chết");
		nnchet_inp = new JTextField();
		JLabel soGBT = new JLabel("Số Giấy báo tử/Giấy tờ thay thế Giấy báo tử");
		soGBT_inp = new JTextField();
		JLabel noicapGBT = new JLabel("Nơi cấp");
		ncGBT_inp = new JTextField();
		JLabel ngaycapGBT = new JLabel("Ngày cấp (yyyy-mm-dd)");
		ngcapGBT_inp = new JTextField();
		
		JButton accept = new JButton("OK");
		JButton cancel = new JButton("Hủy bỏ");
		accept.addActionListener(this);
		cancel.addActionListener(this);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.add(accept);
		buttons.add(cancel);
		
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
		edit_dialog.getContentPane().add(qhvoiNDKT);
		edit_dialog.getContentPane().add(dncapBS);
		edit_dialog.getContentPane().add(nctNYC_inp);
		edit_dialog.getContentPane().add(qhvoiNDKT_inp);
		edit_dialog.getContentPane().add(dncapBS_inp);
		edit_dialog.getContentPane().add(ndkt);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(tenNDKT);
		edit_dialog.getContentPane().add(ngaysinhNDKT);
		edit_dialog.getContentPane().add(gtNDKT);
		edit_dialog.getContentPane().add(tenNDKT_inp);
		edit_dialog.getContentPane().add(ngsinhNDKT_inp);
		edit_dialog.getContentPane().add(gtNDKT_inp);
		edit_dialog.getContentPane().add(dtNDKT);
		edit_dialog.getContentPane().add(qtNDKT);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(dtNDKT_inp);
		edit_dialog.getContentPane().add(qtNDKT_inp);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(nctNDKT);
		edit_dialog.getContentPane().add(gtttNDKT);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(nctNDKT_inp);
		edit_dialog.getContentPane().add(gtttNDKT_inp);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(thoigianchet);
		edit_dialog.getContentPane().add(noichet);
		edit_dialog.getContentPane().add(nguyennhanchet);
		edit_dialog.getContentPane().add(tgchet_inp);
		edit_dialog.getContentPane().add(noichet_inp);
		edit_dialog.getContentPane().add(nnchet_inp);
		edit_dialog.getContentPane().add(soGBT);
		edit_dialog.getContentPane().add(noicapGBT);
		edit_dialog.getContentPane().add(ngaycapGBT);
		edit_dialog.getContentPane().add(soGBT_inp);
		edit_dialog.getContentPane().add(ncGBT_inp);
		edit_dialog.getContentPane().add(ngcapGBT_inp);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(buttons);
		edit_dialog.getContentPane().add(new JLabel());
		
		tenNYC_inp.setEditable(false);
		ngsinhNYC_inp.setEditable(false);
		gtttNYC_inp.setEditable(false);
		qhvoiNDKT_inp.setEditable(false);
		
		edit_dialog.setResizable(false);
		edit_dialog.setVisible(true);
		edit_dialog.pack();
	}
	@Override
	void removeData() {
		// TODO Auto-generated method stub
		
	}
	
}
