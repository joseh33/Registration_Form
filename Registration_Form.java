import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Registration_Form extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtmobile;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration_Form frame = new Registration_Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration_Form() {
		setTitle("Registration Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(29, 24, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mobile");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(29, 88, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(29, 155, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtname.setBounds(144, 21, 195, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtmobile = new JTextField();
		txtmobile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtmobile.setBounds(144, 85, 195, 20);
		contentPane.add(txtmobile);
		txtmobile.setColumns(10);
		
		JRadioButton rbMale = new JRadioButton("Male");
		buttonGroup.add(rbMale);
		rbMale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbMale.setBounds(165, 151, 109, 23);
		contentPane.add(rbMale);
		
		JRadioButton rbFemale = new JRadioButton("Female");
		buttonGroup.add(rbFemale);
		rbFemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbFemale.setBounds(350, 151, 109, 23);
		contentPane.add(rbFemale);
		
		JButton ButtonSubmit = new JButton("Submit");
		ButtonSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration_form","root","20202020Mjk");
				String query="insert into registration values(?,?,?,?)";
				PreparedStatement  ps=con.prepareStatement(query);
				ps.setString(1, txtname.getText());
				ps.setInt(2, Integer.parseInt(txtmobile.getText()));
				if(rbMale.isSelected())
					ps.setString(3, rbMale.getText());
				else
					ps.setString(3, rbFemale.getText());
				ps.setString(4, txtA.getText());
				
				int i=ps.executeUpdate();
				JOptionPane.showMessageDialog(ButtonSubmit, i+ "Record added successfully");
				ps.close();
				con.close();
				
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		ButtonSubmit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ButtonSubmit.setBounds(181, 386, 89, 23);
		contentPane.add(ButtonSubmit);
		
		JButton ButtonReset = new JButton("Reset");
		ButtonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtname.setText("");
				txtmobile.setText("");
				txtA.setText("");
	
			}
		});
		ButtonReset.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ButtonReset.setBounds(386, 386, 89, 23);
		contentPane.add(ButtonReset);
		
		JCheckBox checkterms = new JCheckBox("Accept terms and conditions");
		checkterms.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkterms.setBounds(165, 317, 260, 23);
		contentPane.add(checkterms);
		
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(29, 271, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtA = new JTextField();
		txtA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtA.setBounds(144, 268, 195, 23);
		contentPane.add(txtA);
		txtA.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("D.O.B");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(29, 211, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JComboBox txtcBox = new JComboBox();
		txtcBox.setModel(new DefaultComboBoxModel(new String[] {"Day"}));
		for (int i = 1; i < 32; i++) {
			txtcBox.addItem(String.valueOf(i));
		    }  
		txtcBox.setBounds(144, 208, 53, 22);
		contentPane.add(txtcBox);
		
		JComboBox txtcBox_1 = new JComboBox();
		txtcBox_1.setModel(new DefaultComboBoxModel(new String[] {"Month"}));
		String[] months = {
	            "January", "February", "March", "April", "May", "June",
	            "July", "August", "September", "October", "November", "December"
	        };
		 for (String month : months) {
	            txtcBox_1.addItem(month); 
	        }
		txtcBox_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtcBox_1.setBounds(207, 207, 63, 22);
		contentPane.add(txtcBox_1);
		
		JComboBox txtcBox_2 = new JComboBox();
		txtcBox_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtcBox_2.setModel(new DefaultComboBoxModel(new String[] {"Year"}));
		for (int i = 2024; i >=1900; i--) {
			txtcBox_2.addItem(String.valueOf(i));
		    }  
		txtcBox_2.setBounds(282, 207, 57, 22);
		contentPane.add(txtcBox_2);
		
		
	}
}
