package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblUsurio.setBounds(30, 43, 112, 33);
		contentPane.add(lblUsurio);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(82, 161, 277, 20);
		contentPane.add(formattedTextField);
		
		textField = new JTextField();
		textField.setBounds(82, 76, 279, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Senha\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(30, 125, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.setBounds(270, 215, 89, 23);
		contentPane.add(btnEntrar);
	}
}
