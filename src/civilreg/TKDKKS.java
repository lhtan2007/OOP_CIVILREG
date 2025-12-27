package civilreg;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class TKDKKS extends RegDataManipulator implements ActionListener{
	private int id = 0;
	private Statement st;
	private String init = "create table TKDKKS ("
			+ "IDTK varchar(10), "
			+ "tenNYC varchar(50), "
			+ "ngaysinhNYC date, "
			+ "noicutruNYC varchar(255), "
			+ "gtttNYC varchar(50), "
			+ "qhvoiNDKS varchar(20), "
			+ "tenNDKS varchar(50), "
			+ "ngaysinhNDKS datetime, "
			+ "nsNDKSghibangchu varchar(255), "
			+ "gioitinhNDKS boolean, "
			+ "dantocNDKS varchar(20), "
			+ "quoctichNDKS varchar(20), "
			+ "noisinhNDKS varchar(255), "
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
			+ "pheduyet boolean"
			+ "primary key (IDTK))";
	JTextField tenNYC_inp, ngsinhNYC_inp, nctNYC_inp, gtttNYC_inp, qhvoiNDKS_inp;
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
	public void init() {
		try {
			st = Main.m.getL().getConn().createStatement();
			try {
				System.out.println(init);
				st.executeUpdate(init);
			}
			catch(Exception e1) {
				
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
	void addData() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void setData() {
		// TODO Auto-generated method stub
		JFrame edit_dialog = new JFrame("Sửa tờ khai");
		edit_dialog.getContentPane().setPreferredSize(new Dimension(1200, 600));
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
		JLabel qhvoiNDKS = new JLabel("Quan hệ với người được khai sinh");
		qhvoiNDKS_inp = new JTextField();
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
		edit_dialog.getContentPane().add(qhvoiNDKS);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(qhvoiNDKS_inp);
		edit_dialog.getContentPane().add(new JLabel());
		edit_dialog.getContentPane().add(new JLabel());
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
		
		edit_dialog.setResizable(false);
		edit_dialog.setVisible(true);
		edit_dialog.pack();
		
	}
	@Override
	void removeData() {
		// TODO Auto-generated method stub
		
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
						+ "dncapBS from TKDKKS where IDTK = " + this.num_inp.getText());
				rs.next();
				tenNYC_inp.setText(rs.getString("tenNYC"));
				ngsinhNYC_inp.setText(rs.getString("ngaysinhNYC"));
				gtttNYC_inp.setText(rs.getString("gtttNYC"));
				qhvoiNDKS_inp.setText(rs.getString("qhvoiNDKS"));
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
				e1.printStackTrace();
			}
		}	
	}
}
