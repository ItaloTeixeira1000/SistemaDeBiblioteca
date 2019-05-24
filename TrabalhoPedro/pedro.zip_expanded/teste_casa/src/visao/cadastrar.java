package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class cadastrar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastrar frame = new cadastrar();
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
	public cadastrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigiteSeuNome = new JLabel("digite seu nome");
		lblDigiteSeuNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDigiteSeuNome.setBounds(133, 32, 132, 30);
		contentPane.add(lblDigiteSeuNome);
		
		textField = new JTextField();
		textField.setBounds(98, 73, 224, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDigiteSuaSenha = new JLabel("digite sua senha");
		lblDigiteSuaSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDigiteSuaSenha.setBounds(133, 142, 132, 14);
		contentPane.add(lblDigiteSuaSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 167, 224, 38);
		contentPane.add(passwordField);
		
		JButton btnCadastrar = new JButton("cadastrar");
		btnCadastrar.setBounds(156, 216, 91, 23);
		contentPane.add(btnCadastrar);
	}
}
