package civilreg;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.Calendar;

public class TKDKKS extends RegDataManipulator implements ActionListener, ComponentListener{
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
	private String init = "create table TKDKKS ("
			+ "IDTK int auto_increment, "
			+ "tenNYC varchar(50) not null, "
			+ "ngaysinhNYC date not null, "
			+ "noicutruNYC varchar(255) not null, "
			+ "gtttNYC varchar(50) not null, "
			+ "qhvoiNDKS varchar(20) not null, "
			+ "tenNDKS varchar(50) not null, "
			+ "ngaysinhNDKS date not null, "
			+ "nsNDKSghibangchu varchar(255) not null, "
			+ "gioitinhNDKS boolean not null, "
			+ "dantocNDKS varchar(20) not null, "
			+ "quoctichNDKS varchar(20) not null, "
			+ "noisinhNDKS varchar(255) not null, "
			+ "quequanNDKS varchar(255), "
			+ "tenM varchar(50), "
			+ "ngaysinhM date, "
			+ "dantocM varchar(20), "
			+ "quoctichM varchar(20), "
			+ "noicutruM varchar(255), "
			+ "gtttM varchar(50), "
			+ "tenC varchar(50), "
			+ "ngaysinhC date, "
			+ "dantocC varchar(20), "
			+ "quoctichC varchar(20), "
			+ "noicutruC varchar(255), "
			+ "gtttC varchar(50), "
			+ "ngaydangky date, "
			+ "dncapBS int, "
			+ "pheduyet boolean default 0, "
			+ "nguoinhapTK varchar(255) not null, "
			+ "primary key (IDTK))";
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

	public TKDKKS() {
		
	}
	public DefaultTableModel getTM() {
		return tm;
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
	void addData() {
		// TODO Auto-generated method stub
		edit_dialog = new JFrame("Thêm tờ khai");
		edit_dialog.addComponentListener(this);
		edit_dialog.getContentPane().setPreferredSize(new Dimension(1200, 720));
		edit_dialog.getContentPane().setLayout(new GridLayout(24, 3));
		JLabel nyc = new JLabel("Thông tin về người yêu cầu");
		JLabel tenNYC = new JLabel("Họ, chữ đệm và tên");
		tenNYC_inp = new JTextField();
		JLabel ngsinhNYC = new JLabel("Ngày sinh (yyyy-mm-dd)");
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
		JLabel ngaysinhNDKS = new JLabel("Ngày sinh (yyyy-mm-dd)");
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
	void setData() {
		// TODO Auto-generated method stub
		edit_dialog = new JFrame("Sửa tờ khai");
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
		qhvoiNDKS_inp.setEditable(false);
		
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
	void removeData() {
		// TODO Auto-generated method stub
		edit_dialog = new JFrame("Xóa tờ khai");
		edit_dialog.addComponentListener(this);
		edit_dialog.getContentPane().setPreferredSize(new Dimension(400, 60));
		edit_dialog.getContentPane().setLayout(new BorderLayout());
		
		JLabel num = new JLabel("Nhập số hiệu của tờ khai cần xóa: ");
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
	void approveData() {
		edit_dialog = new JFrame("Duyệt tờ khai");
		edit_dialog.addComponentListener(this);
		edit_dialog.getContentPane().setPreferredSize(new Dimension(500, 60));
		edit_dialog.getContentPane().setLayout(new BorderLayout());
		
		JLabel num = new JLabel("Nhập số hiệu của tờ khai cần duyệt: ");
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
	void viewData() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case "Kiểm tra":
			try {
				st = Main.m.getL().getConn().createStatement();
				ResultSet rs;
				if(Main.m.getL().getRole().equals("admin")) {
					rs = st.executeQuery("select tenNYC, ngaysinhNYC, noicutruNYC, gtttNYC, qhvoiNDKS, "
							+ "tenNDKS, date(ngaysinhNDKS) as ngsinhNDKS, nsNDKSghibangchu, gioitinhNDKS, dantocNDKS, quoctichNDKS, noisinhNDKS, quequanNDKS, "
							+ "tenM, date(ngaysinhM) as ngsinhM, dantocM, quoctichM, noicutruM, gtttM, "
							+ "tenC, date(ngaysinhC) as ngsinhC, dantocC, quoctichC, noicutruC, gtttC, "
							+ "dncapBS from TKDKKS where IDTK = " + this.num_inp.getText());
				}
				else {
					rs = st.executeQuery("select tenNYC, ngaysinhNYC, noicutruNYC, gtttNYC, qhvoiNDKS, "
							+ "tenNDKS, date(ngaysinhNDKS) as ngsinhNDKS, nsNDKSghibangchu, gioitinhNDKS, dantocNDKS, quoctichNDKS, noisinhNDKS, quequanNDKS, "
							+ "tenM, date(ngaysinhM) as ngsinhM, dantocM, quoctichM, noicutruM, gtttM, "
							+ "tenC, date(ngaysinhC) as ngsinhC, dantocC, quoctichC, noicutruC, gtttC, "
							+ "dncapBS from TKDKKS where IDTK = " + this.num_inp.getText() + " and nguoinhapTK = \'" + Main.m.getL().getUsername() + "\'");
				}
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
				nf.showMessageDialog(notFound, "Không tìm thấy tờ khai số " + num_inp.getText() + " trong CSDL.", 
						"Tìm kiếm thất bại", JOptionPane.ERROR_MESSAGE);
			}
			finally {
				break;
			}
		case "OK":
			if(edit_dialog.getTitle().equals("Sửa tờ khai")) {
				try {
					if(Main.m.getL().getRole().equals("admin")) {
						ps = Main.m.getL().getConn().prepareStatement("update TKDKKS set tenNDKS = ?, ngaysinhNDKS = ?, nsNDKSghibangchu = ?, gioitinhNDKS = ?, dantocNDKS = ?, quoctichNDKS = ?, "
								+ "noisinhNDKS = ?, quequanNDKS = ?, tenM = ?, ngaysinhM = ?, dantocM = ?, quoctichM = ?, noicutruM = ?, gtttM = ?, "
								+ "tenC = ?, ngaysinhC = ?, dantocC = ?, quoctichC = ?, noicutruC = ?, gtttC = ?, dncapBS = ? where IDTK = ?");
						ps.setString(22, num_inp.getText());
					}
					else {
						ps = Main.m.getL().getConn().prepareStatement("update TKDKKS set tenNDKS = ?, ngaysinhNDKS = ?, nsNDKSghibangchu = ?, gioitinhNDKS = ?, dantocNDKS = ?, quoctichNDKS = ?, "
								+ "noisinhNDKS = ?, quequanNDKS = ?, tenM = ?, ngaysinhM = ?, dantocM = ?, quoctichM = ?, noicutruM = ?, gtttM = ?, "
								+ "tenC = ?, ngaysinhC = ?, dantocC = ?, quoctichC = ?, noicutruC = ?, gtttC = ?, dncapBS = ?, nguoinhapTK = ? where IDTK = ?");
						ps.setString(22, Main.m.getL().getUsername());
						ps.setString(23, num_inp.getText());
					}
					ps.setString(1, tenNDKS_inp.getText().toUpperCase());
					ps.setString(2, ngsinhNDKS_inp.getText().strip().replaceAll("\\s+", ""));
					ps.setString(3, nsNDKSgbc_inp.getText());
					if(gtNDKS_inp.getSelectedItem().toString().equals("Nam")) ps.setBoolean(4, false); 
					else ps.setBoolean(4, true);
					ps.setString(5, dtNDKS_inp.getText());
					ps.setString(6, qtNDKS_inp.getText());
					ps.setString(7, nsNDKS_inp.getText());
					ps.setString(8, qqNDKS_inp.getText());
					ps.setString(9, tenM_inp.getText().toUpperCase());
					ps.setString(10, ngsinhM_inp.getText().strip().replaceAll("\\s+", ""));
					ps.setString(11, dtM_inp.getText());
					ps.setString(12, qtM_inp.getText());
					ps.setString(13, nctM_inp.getText());
					ps.setString(14, gtttM_inp.getText());
					ps.setString(15, tenC_inp.getText().toUpperCase());
					ps.setString(16, ngsinhC_inp.getText().strip().replaceAll("\\s+", ""));
					ps.setString(17, dtC_inp.getText());
					ps.setString(18, qtC_inp.getText());
					ps.setString(19, nctC_inp.getText());
					ps.setString(20, gtttC_inp.getText());
					ps.setInt(21, Integer.valueOf(dncapBS_inp.getText()));
					ps.executeUpdate();
					JFrame modified = new JFrame();
					JOptionPane m = new JOptionPane();
					m.setVisible(true);
					m.showMessageDialog(modified, "Đã chỉnh sửa thành công tờ khai số " + num_inp.getText(), "Chỉnh sửa thành công", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e2) {
					JFrame notModified = new JFrame();
					JOptionPane nm = new JOptionPane();
					nm.setVisible(true);
					nm.showMessageDialog(notModified, "Không chỉnh sửa được tờ khai. Xin vui lòng kiểm tra lại dữ liệu đầu vào.\n"
							+ "Lưu ý: họ và tên, ngày sinh, giới tính, dân tộc, nơi sinh, quốc tịch của người được khai sinh không được để trống.\n"
							+ "Ngày sinh nhập theo định dạng \"năm - tháng - ngày\".", 
							"Lỗi chỉnh sửa", JOptionPane.ERROR_MESSAGE);
				}
				finally {
					edit_dialog.setVisible(false);
					break;
				}
			}
			else if(edit_dialog.getTitle().equals("Thêm tờ khai")) {
				JOptionPane m;
				try {
					ps = Main.m.getL().getConn().prepareStatement("insert into TKDKKS (tenNDKS, ngaysinhNDKS, nsNDKSghibangchu, gioitinhNDKS, dantocNDKS, quoctichNDKS, "
							+ "noisinhNDKS, quequanNDKS, tenM, ngaysinhM, dantocM, quoctichM, noicutruM, gtttM, "
							+ "tenC, ngaysinhC, dantocC, quoctichC, noicutruC, gtttC, tenNYC, ngaysinhNYC, gtttNYC, noicutruNYC, qhvoiNDKS, dncapBS, ngaydangky, nguoinhapTK) "
							+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" );
					ps.setString(1, tenNDKS_inp.getText().toUpperCase());
					ps.setString(2, ngsinhNDKS_inp.getText().strip().replaceAll("\\s+", ""));
					ps.setString(3, nsNDKSgbc_inp.getText());
					if(gtNDKS_inp.getSelectedItem().toString().equals("Nam")) ps.setBoolean(4, false); 
					else ps.setBoolean(4, true);
					ps.setString(5, dtNDKS_inp.getText());
					ps.setString(6, qtNDKS_inp.getText());
					ps.setString(7, nsNDKS_inp.getText());
					ps.setString(8, qqNDKS_inp.getText());
					ps.setString(9, tenM_inp.getText().toUpperCase());
					ps.setString(10, ngsinhM_inp.getText().strip().replaceAll("\\s+", ""));
					ps.setString(11, dtM_inp.getText());
					ps.setString(12, qtM_inp.getText());
					ps.setString(13, nctM_inp.getText());
					ps.setString(14, gtttM_inp.getText());
					ps.setString(15, tenC_inp.getText().toUpperCase());
					ps.setString(16, ngsinhC_inp.getText().strip().replaceAll("\\s+", ""));
					ps.setString(17, dtC_inp.getText());
					ps.setString(18, qtC_inp.getText());
					ps.setString(19, nctC_inp.getText());
					ps.setString(20, gtttC_inp.getText());
					ps.setString(21, tenNYC_inp.getText().toUpperCase());
					ps.setString(22, ngsinhNYC_inp.getText().replaceAll("\\s+", ""));
					ps.setString(23, gtttNYC_inp.getText());
					ps.setString(24, nctNYC_inp.getText());
					ps.setString(25, qhvoiNDKS_inp.getText());
					ps.setInt(26, Integer.valueOf(dncapBS_inp.getText()));
					ps.setString(27, Main.m.getL().getCal().get(Calendar.YEAR) + "-" 
							+ String.valueOf(Integer.valueOf(Main.m.getL().getCal().get(Calendar.MONTH)) + 1) 
							+ "-" + Main.m.getL().getCal().get(Calendar.DATE));
					ps.setString(28, Main.m.getL().getUsername());
					ps.executeUpdate();
					Statement ps1 = Main.m.getL().getConn().createStatement();
					ResultSet rs1 = ps1.executeQuery("select IDTK from TKDKKS order by IDTK desc limit 1");
					rs1.next();
					
					JFrame modified = new JFrame();
					m = new JOptionPane();
					m.setVisible(true);
					m.showMessageDialog(modified, "Đã thêm thành công tờ khai số " + rs1.getString(1), "Thêm thành công", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e2) {
					e2.printStackTrace();
					JFrame notModified = new JFrame();
					JOptionPane nm = new JOptionPane();
					nm.setVisible(true);
					nm.showMessageDialog(notModified, "Không thêm được tờ khai. Xin vui lòng kiểm tra lại dữ liệu đầu vào.\n"
							+ "Lưu ý: họ và tên, ngày sinh, giới tính, dân tộc, nơi sinh, quốc tịch của người được khai sinh không được để trống.\n"
							+ "Ngày sinh nhập theo định dạng \"năm - tháng - ngày\".", 
							"Lỗi dữ liệu", JOptionPane.ERROR_MESSAGE);
				}
				finally {
					edit_dialog.setVisible(false);
					break;
				}
			}
			else if(edit_dialog.getTitle().equals("Xóa tờ khai")) {
				try {
					if(Main.m.getL().getRole().equals("admin")) ps = Main.m.getL().getConn().prepareStatement("delete from TKDKKS where IDTK = ?");
					else ps = Main.m.getL().getConn().prepareStatement("delete from TKDKKS where IDTK = ? and nguoinhapTK = " + Main.m.getL().getUsername());
					ps.setString(1, num_inp.getText());
					if(ps.executeUpdate() == 1) {
						JFrame modified = new JFrame();
						JOptionPane m = new JOptionPane();
						m.setVisible(true);
						m.showMessageDialog(modified, "Đã xóa thành công tờ khai số " + num_inp.getText() + ".", "Xóa thành công", JOptionPane.INFORMATION_MESSAGE);
						num_inp.setText("");
						edit_dialog.setVisible(false);
					}
					else {
						JFrame notModified = new JFrame();
						JOptionPane nm = new JOptionPane();
						nm.setVisible(true);
						nm.showMessageDialog(notModified, "Không có tờ khai số " + num_inp.getText() + " trong CSDL.", "Xóa hồ sơ thất bại", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				catch(Exception e2) {
					e2.printStackTrace();
					JFrame notModified = new JFrame();
					JOptionPane nm = new JOptionPane();
					nm.setVisible(true);
					if(e2.getClass().getSimpleName().equals("SQLIntegrityConstraintViolationException")) {
						nm.showMessageDialog(notModified, "Giấy tờ hộ tịch tương ứng phải được xóa đăng ký trước khi xóa tờ khai này.", "Xóa hồ sơ thất bại", JOptionPane.ERROR_MESSAGE);
					}
					else {
						nm.showMessageDialog(notModified, "Dữ liệu nhập vào không hợp lệ.", "Xóa hồ sơ thất bại", JOptionPane.ERROR_MESSAGE);
					}
				}
				finally {
					edit_dialog.setVisible(false);
					break;
				}
			}
			else if(edit_dialog.getTitle().equals("Duyệt tờ khai")) {
				try {
					ps = Main.m.getL().getConn().prepareStatement("update TKDKKS set pheduyet = 1 where IDTK = ?");
					ps.setString(1, num_inp.getText());
					if(ps.executeUpdate() == 1) {
						JFrame modified = new JFrame();
						JOptionPane m = new JOptionPane();
						m.setVisible(true);
						m.showMessageDialog(modified, "Đã duyệt thành công tờ khai số " + num_inp.getText() + ".", "Duyệt thành công", JOptionPane.INFORMATION_MESSAGE);
						Statement st = Main.m.getL().getConn().createStatement();
						//System.out.println("insert into GKS (IDTK) values (" + num_inp.getText() + ")");
						st.executeUpdate("insert into GKS (IDTK) values (" + num_inp.getText() + ")");
						num_inp.setText("");
						edit_dialog.setVisible(false);
					}
					else {
						JFrame notModified = new JFrame();
						JOptionPane nm = new JOptionPane();
						nm.setVisible(true);
						nm.showMessageDialog(notModified, "Không có tờ khai số " + num_inp.getText() + " trong CSDL.", "Duyệt hồ sơ thất bại", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception e2) {
					e2.printStackTrace();
					JFrame notModified = new JFrame();
					JOptionPane nm = new JOptionPane();
					nm.setVisible(true);
					nm.showMessageDialog(notModified, "Dữ liệu nhập vào không hợp lệ.", "Duyệt hồ sơ thất bại", JOptionPane.ERROR_MESSAGE);
				}
				finally {
					edit_dialog.setVisible(false);
					break;
				}
			}
			//Main.m.getL().mi.getTM().setRowCount(0);
		case "Hủy bỏ":
			edit_dialog.setVisible(false);
			break;
		}	
	}
	@Override
	int countData() {
		int cnt = 0;
		try {
			ResultSet rs = st.executeQuery("select count(IDTK) from TKDKKS");
			if(rs.next()) cnt = rs.getInt(1);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	void displayTable(JTable inf, DefaultTableModel tm) {
		// TODO Auto-generated method stub
		tm = this.tm;
		inf.setModel(tm);
		tm.setRowCount(0);
		String colsName_tkks[] = {"Số tờ khai", "Họ và tên", "Ngày sinh", "Giới tính", "Ngày đăng ký khai sinh", "Trạng thái duyệt tờ khai"};
		tm.setColumnIdentifiers(colsName_tkks);
		try {
			ResultSet rs = null;
			if(Main.m.getL().getRole().equals("admin")) {
				rs = st.executeQuery("select IDTK, tenNDKS, ngaysinhNDKS, gioitinhNDKS, ngaydangky, pheduyet from TKDKKS order by IDTK");
			}
			else {
				rs = st.executeQuery("select IDTK, tenNDKS, ngaysinhNDKS, gioitinhNDKS, ngaydangky, pheduyet from TKDKKS where nguoinhapTK = \'" + Main.m.getL().getUsername() + "\' order by IDTK");
			}
			while(rs.next()) {
				String rows[] = new String[6];
				rows[0] = rs.getString("IDTK");
				rows[1] = rs.getString("tenNDKS");
				rows[2] = rs.getString("ngaysinhNDKS");
				if(rs.getString("gioitinhNDKS").equals("0")) rows[3] = "Nam";
				else rows[3] = "Nữ";
				rows[4] = rs.getString("ngaydangky");
				if(rs.getString("pheduyet").equals("1")) rows[5] = "Đã duyệt";
				else rows[5] = "Chưa duyệt";
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
