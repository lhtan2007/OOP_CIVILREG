package civilreg;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class LoginUI extends JFrame implements ActionListener, WindowListener{
	private JButton b1, b2;
	private JTextField tf1, tf2, tf3;
	private JLabel li, l0, l1, l2, l3;
	private JPanel p0, p1, p2, p3;
	private Login l;
	public Login getL() {
		return l;
	}
	public JTextField gettf1() {
		return tf1;
	}
	public LoginUI(String t) {
		b1 = new JButton("Đăng nhập");
		b2 = new JButton("Nhập lại");
		li = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ CSDL HỘ TỊCH");
		l0 = new JLabel("Kết nối với máy chủ chứa CSDL:");
		l1 = new JLabel("Địa chỉ máy chủ");
		l2 = new JLabel("Tên đăng nhập");
		l3 = new JLabel("Mật khẩu");
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JPasswordField();
		p0 = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		
		p0.setPreferredSize(new Dimension(1024, 150));
		p0.setBackground(Color.LIGHT_GRAY);
		p0.setLayout(new BorderLayout());
		li.setHorizontalAlignment(JLabel.CENTER);
		li.setFont(new Font("Segoe UI", Font.BOLD, 28));
		p0.add(li, BorderLayout.CENTER);
		
		p1.setPreferredSize(new Dimension(800,100));
		p1.setLayout(new BorderLayout());
		p1.add(l0, BorderLayout.SOUTH);
		l0.setFont(new Font("Segoe UI", Font.BOLD, 20));
		//p1.setBackground(Color.GREEN);
		
		p2.setPreferredSize(new Dimension(700,100));
		p2.setLayout(new GridLayout(3, 2));
		p2.add(l1);
		p2.add(tf1);
		p2.add(l2);
		p2.add(tf2);
		p2.add(l3);
		p2.add(tf3);
		l1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		l2.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		l3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		tf1.setFont(new Font("Consolas", Font.PLAIN, 20));
		tf2.setFont(new Font("Consolas", Font.PLAIN, 20));
		tf3.setFont(new Font("Consolas", Font.PLAIN, 20));
		b1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		b2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		p3.setPreferredSize(new Dimension(500, 50));
		GridLayout g_l = new GridLayout(2, 2);
		p3.setLayout(g_l);
		g_l.setHgap(20);
		//p3.setBackground(Color.RED);
		p3.add(new JLabel());
		p3.add(new JLabel());
		p3.add(b1);
		p3.add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		//this.getContentPane().add(p0, BorderLayout.NORTH);
		this.addWindowListener(this);
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(p0);
		this.getContentPane().add(p1);
		this.getContentPane().add(p2);
		this.getContentPane().add(p3);
		this.getContentPane().setPreferredSize(new Dimension(1024, 600));
		this.setTitle(t);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case "Đăng nhập":
			l = new Login(tf1.getText(), tf2.getText(), tf3.getText());
			l.test();
			l.signIn();
			break;
		case "Nhập lại":
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
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
