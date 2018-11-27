package test02;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Register extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel lbl_name;
	private JLabel lbl_birth;
	private JLabel lbl_phone;
	private JLabel lbl_addr;
	private JTextField tf_name;
	private JTextField tf_birth;
	private JTextField tf_phone;
	private JTextField tf_addr;
	private JSplitPane splitPane_1;
	private JScrollPane scrollPane;
	private JTextArea ta;
	private JPanel panel_1;
	private JComboBox cb;
	private JTextField tf_search;
	private JButton btn_seaa;
	private JButton btn_insert;
	private JButton btn_all;
	
	RegisterDBA dba = new RegisterDBA();

	public Register() { //생성자 메소드
		setTitle("제출");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}
	

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setDividerLocation(220);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 200, 0)), "\uAC1C\uC778\uC815\uBCF4\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setLayout(null);
			panel.add(getLbl_name());
			panel.add(getLbl_birth());
			panel.add(getLbl_phone());
			panel.add(getLbl_addr());
			panel.add(getTf_name());
			panel.add(getTf_birth());
			panel.add(getTf_phone());
			panel.add(getTf_addr());
			panel.add(getBtn_insert());
			panel.add(getBtn_all());
		}
		return panel;
	}
	private JLabel getLbl_name() {
		if (lbl_name == null) {
			lbl_name = new JLabel("\uC774\uB984");
			lbl_name.setBounds(12, 21, 57, 15);
		}
		return lbl_name;
	}
	private JLabel getLbl_birth() {
		if (lbl_birth == null) {
			lbl_birth = new JLabel("\uC0DD\uC77C");
			lbl_birth.setBounds(12, 57, 57, 15);
		}
		return lbl_birth;
	}
	private JLabel getLbl_phone() {
		if (lbl_phone == null) {
			lbl_phone = new JLabel("\uC804\uD654\uBC88\uD638");
			lbl_phone.setBounds(12, 100, 57, 15);
		}
		return lbl_phone;
	}
	private JLabel getLbl_addr() {
		if (lbl_addr == null) {
			lbl_addr = new JLabel("\uC8FC\uC18C");
			lbl_addr.setBounds(12, 138, 57, 15);
		}
		return lbl_addr;
	}
	private JTextField getTf_name() {
		if (tf_name == null) {
			tf_name = new JTextField();
			tf_name.setBounds(78, 18, 116, 21);
			tf_name.setColumns(10);
		}
		return tf_name;
	}
	private JTextField getTf_birth() {
		if (tf_birth == null) {
			tf_birth = new JTextField();
			tf_birth.setBounds(78, 54, 116, 21);
			tf_birth.setColumns(10);
		}
		return tf_birth;
	}
	private JTextField getTf_phone() {
		if (tf_phone == null) {
			tf_phone = new JTextField();
			tf_phone.setBounds(78, 97, 116, 21);
			tf_phone.setColumns(10);
		}
		return tf_phone;
	}
	private JTextField getTf_addr() {
		if (tf_addr == null) {
			tf_addr = new JTextField();
			tf_addr.setBounds(81, 135, 116, 21);
			tf_addr.setColumns(10);
		}
		return tf_addr;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setLeftComponent(getScrollPane());
			splitPane_1.setRightComponent(getPanel_1());
			splitPane_1.setDividerLocation(240);
		}
		return splitPane_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTa());
		}
		return scrollPane;
	}
	private JTextArea getTa() {
		if (ta == null) {
			ta = new JTextArea();
			ta.setBorder(new TitledBorder(null, "\uC804\uCCB4\uBCF4\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}
		return ta;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getCb());
			panel_1.add(getTf_search());
			panel_1.add(getBtn_seaa());
		}
		return panel_1;
	}
	private JComboBox getCb() {
		if (cb == null) {
			cb = new JComboBox(new String[] {"선택..","이름", "주소"});
			cb.setBounds(0, 21, 57, 21);
		}
		return cb;
	}
	private JTextField getTf_search() {
		if (tf_search == null) {
			tf_search = new JTextField();
			tf_search.setBounds(63, 21, 116, 21);
			tf_search.setColumns(10);
		}
		return tf_search;
	}
	
	//상세보기
	private JButton getBtn_seaa() {
		if (btn_seaa == null) {
			btn_seaa = new JButton("\uCC3E\uAE30");
			btn_seaa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ta.setText("");
					String str = "";
					if(cb.getSelectedIndex() == 1) {
						str = "name";
					}else if(cb.getSelectedIndex() == 2) {
						str = "addr";
					}else {
						tf_search.setText("콤보박스를 선택해주세요.");
					}
					ArrayList<RegisterBean> arr = dba.friendSearch(str, tf_search.getText());
					for(RegisterBean b : arr) {
						ta.append("번호 : " + b.getNum() + "\n");
						ta.append("이름 : " + b.getName() + "\n");
						ta.append("생일 : " + b.getBirth() + "\n");
						ta.append("전화번호 : " + b.getPhone() + "\n");
						ta.append("주소 : " + b.getAddr() + "\n\n");
					}
					
				}
			});
			btn_seaa.setBounds(181, 20, 63, 23);
		}
		return btn_seaa;
	}
	
	//추가하기버튼
	private JButton getBtn_insert() {
		if (btn_insert == null) {
			btn_insert = new JButton("\uCD94\uAC00");
			btn_insert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					RegisterBean bean = new RegisterBean();
					bean.setName(tf_name.getText());
					bean.setBirth(tf_birth.getText());
					bean.setPhone(tf_phone.getText());
					bean.setAddr(tf_addr.getText());
					dba.infoInsert(bean);
					
				}
			});
			btn_insert.setBounds(12, 210, 97, 23);
		}
		return btn_insert;
	}
	
	//전체보기
	private JButton getBtn_all() {
		if (btn_all == null) {
			btn_all = new JButton("\uC804\uCCB4\uBCF4\uAE30");
			btn_all.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ta.setText("");
					ArrayList<RegisterBean> arr1 = dba.infoSee(); //전체보기
					for(int i=0; i<arr1.size(); i++) {
						ta.append("번호" + arr1.get(i).getNum() + "\n");
						ta.append(arr1.get(i).getName() + "\n");
						ta.append(arr1.get(i).getBirth() + "\n");
						ta.append(arr1.get(i).getPhone() + "\n");
						ta.append(arr1.get(i).getAddr() + "\n\n");
					}
					
					
				}
			});
			btn_all.setBounds(121, 210, 97, 23);
		}
		return btn_all;
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
