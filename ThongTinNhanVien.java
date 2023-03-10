package tranLeThienTri_21001781;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ThongTinNhanVien extends JFrame implements ActionListener {

	JTextField txtMaNv, txtHo, txtTenNv, txtTuoi, txtTienLuong;
	JTextField txtTimKiem;
	JLabel title,lbMaNv, lbHo, lbTenNv, lbTuoi,lbPhai, lbTienLuong;
	JRadioButton rNam,rNu;
	JButton btnTim,btnThem,btnXoaTrang,btnXoa,btnLuu;
	Box b = Box.createVerticalBox();
	Box b1,b2,b3,b4,b5;
	DanhSachNhanVien ds = new DanhSachNhanVien();
	String[] colnames = { "Mã Nhân Viên", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương" };
	DefaultTableModel tbModel = new DefaultTableModel(colnames,0);
	JTable table =new JTable(tbModel);
	JScrollPane pane = new JScrollPane(table);

	public ThongTinNhanVien() {
		// TODO Auto-generated constructor stub
		setTitle("Thông Tin Nhân Viên");
		setSize(700, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GUI();
		setVisible(true);
	}

	public void GUI() {
		//Title
		JPanel pnTitle;
		add(pnTitle = new JPanel(),BorderLayout.NORTH);
		Box bTitle = Box.createHorizontalBox();
		bTitle.add(title = new JLabel("Thông Tin nhân Viên"));
		pnTitle.add(bTitle);
		title.setFont(new Font("Arial", Font.BOLD, 40));
		title.setForeground(Color.blue);
		
		//Panel Center
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		add(pnCenter,BorderLayout.CENTER);
		
		b.add(b1  = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(lbMaNv = new JLabel("Mã nhân viên:"));
		b1.add(txtMaNv = new JTextField());
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b2.add(lbHo = new JLabel("Họ:"));
		b2.add(txtHo = new JTextField());
		
		b2.add(lbTenNv = new JLabel("Tên nhân viên:"));
		b2.add(txtTenNv = new JTextField());
		
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(lbTuoi = new JLabel("Tuổi:"));
		b3.add(txtTuoi = new JTextField());
		
		ButtonGroup gr = new ButtonGroup();
		b3.add(lbPhai = new JLabel("Phái:"));
		b3.add(rNam = new JRadioButton("Nam"));
		b3.add(rNu = new JRadioButton("Nữ"));
		gr.add(rNam);
		gr.add(rNu);
		
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(lbTienLuong = new JLabel("Tiền lương:"));
		b4.add(txtTienLuong = new JTextField());
		
		lbHo.setPreferredSize(lbMaNv.getPreferredSize());
		lbPhai.setPreferredSize(lbMaNv.getPreferredSize());
		lbTienLuong.setPreferredSize(lbMaNv.getPreferredSize());
		lbTuoi.setPreferredSize(lbMaNv.getPreferredSize());
		
		pnCenter.add(b);
		taobang();
		
		
		//footer
		
		JPanel bFooter;
		
		add(bFooter = new JPanel(),BorderLayout.SOUTH);
		JLabel lbTimKiem;
		Box bxFt1 = Box.createHorizontalBox();
		
		Border bdTimKiem = BorderFactory.createEtchedBorder();
		bxFt1.setBorder(bdTimKiem);
		bxFt1.add(lbTimKiem = new JLabel("Nhập mã số cần tìm:"));
		
		bxFt1.add(txtTimKiem = new JTextField());
		txtTimKiem.setPreferredSize(new Dimension(200,0));
		bFooter.add(bxFt1);
		
		bxFt1.add(btnTim = new JButton("Tìm"));
		//
		Border grBtn = BorderFactory.createBevelBorder(0);
		Box bxFt2 = Box.createHorizontalBox();
		bxFt2.setBorder(grBtn);
		bxFt2.add(btnThem = new JButton("Thêm"));
		bxFt2.add(btnXoa = new JButton("Xoá"));
		bxFt2.add(btnXoaTrang = new JButton("Xoá Trắng"));
		bxFt2.add(btnLuu = new JButton("Lưu"));
		bFooter.add(bxFt2);
		
//		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
//		add(split, BorderLayout.NORTH);
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
	}

	public static void main(String[] args) {
		new ThongTinNhanVien();

	}
	
	public void taobang() {
		
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b5.add(pane);
//		pane.setPreferredSize(new Dimension(600,250));
		TableColumn column = new TableColumn();
		TableColumn columnPhai  = table.getColumnModel().getColumn(3);
		JComboBox comboBox = new JComboBox(); 
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		columnPhai.setCellEditor(new DefaultCellEditor(comboBox));
		column.setPreferredWidth(100);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		
		//data
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnThem)) {
			if(btnThem.getText().equals("Thêm")) {
				xoaTrang();
				txtMaNv.requestFocus();
				btnXoa.setEnabled(false);
				btnThem.setText("Huỷ");				
			}else if(btnThem.getText().equals("Huỷ")) {
				btnXoa.setEnabled(true);
				btnThem.setText("Thêm");	
			}
		}
		else if (e.getSource().equals(btnXoaTrang)) {
			xoaTrang();
		}else if(e.getSource().equals(btnLuu)) {
			if(txtMaNv.getText().equals("") || txtHo.getText().equals("") || txtTenNv.getText().equals("") || txtTienLuong.getText().equals("") || txtTuoi.getText().equals("") || !rNam.isSelected() && !rNu.isSelected()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
			}else {
				try {
					luu();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}else if(e.getSource().equals(btnTim)) {
			if(txtTimKiem.getText().equals(txtMaNv.getText())) {
				
			}
		}
	}
	
	public void luu() {
		String gt = "";
		String ma = txtMaNv.getText();
		String ten = txtTenNv.getText();
		String tuoi = txtTuoi.getText();
		
		String luong = txtTienLuong.getText();
		String ho = txtHo.getText();
		if(rNam.isSelected()) {
			gt = rNam.getText();
		}else {
			gt = rNu.getText();
		}
		
		NhanVien nv = new NhanVien(ma, ho, ten, gt, Integer.parseInt(tuoi), Double.parseDouble(luong));
		if(ds.themNv(nv)) {
			JOptionPane.showMessageDialog(null,"Thêm thành công!");
			String [] row = { ma, ho, ten, gt, tuoi, luong };
			tbModel.addRow(row);
		} else {
			JOptionPane.showMessageDialog(this, "ID này đã tồn tại");
			txtMaNv.setText("");
			txtMaNv.requestFocus();
		}
	}
	
	public void xoaTrang() {
		txtMaNv.setText("");
		txtHo.setText("");
		txtTenNv.setText("");
		txtTienLuong.setText("");
		txtTuoi.setText("");
		rNam.setSelected(false);
		rNu.setSelected(false);
		txtMaNv.requestFocus();
	}
	
}
