package civilreg;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;


import java.awt.*;
import java.awt.event.*;


public class ManagerInterface extends JFrame implements ActionListener, WindowListener {
	private JPanel p1, p2, p3, p4, p5;
	//private DefaultTreeModel t;
	private JTable inf;
	private JButton b1, b2, b3;
	private JTabbedPane tp;
	private JLabel l1; 
	public ManagerInterface(String s) {
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		inf = new JTable();
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		tp = new JTabbedPane();
		RegCategoryTree t = new RegCategoryTree();
		l1 = new JLabel("Thống kê cơ bản:");
		
		t.setBackground(Color.LIGHT_GRAY);
		
		p1.setPreferredSize(new Dimension(300, 720));
		p1.setLayout(new BorderLayout());
		p1.add(p2, BorderLayout.CENTER);
		p1.add(p3, BorderLayout.SOUTH);
		p1.setBackground(Color.GRAY);
		
		p2.setLayout(new BorderLayout());
		p2.add(t, BorderLayout.CENTER);
		
		
		
		p3.setPreferredSize(new Dimension(p1.getWidth(), 200));
		p3.setBackground(Color.GREEN);
		p3.add(l1);
		
		l1.setSize(200, 100);
		//p4
		
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
