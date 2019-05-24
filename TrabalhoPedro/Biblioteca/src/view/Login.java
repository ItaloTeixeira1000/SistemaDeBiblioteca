package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.dao.FuncionarioDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/images/login.png")));
		label.setBounds(10, 48, 128, 147);
		contentPane.add(label);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLogin.setIcon(new ImageIcon(Login.class.getResource("/images/identificador.png")));
		lblLogin.setBounds(170, 25, 75, 30);
		contentPane.add(lblLogin);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(180, 66, 201, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSenha.setIcon(new ImageIcon(Login.class.getResource("/images/senha.png")));
		lblSenha.setBounds(170, 97, 75, 30);
		contentPane.add(lblSenha);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioDAO dao = new FuncionarioDAO();
				if(dao.checkLogin(txtUsuario.getText(), txtSenha.getText())) {
					
					new TelaPrincipal().setVisible(true);
					dispose();
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Dados incorretos");
					txtUsuario.setText("");
					txtSenha.setText("");
				}
				
			}
		});
		btnLogin.setBounds(180, 185, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblSeVoNo = new JLabel("Se vo\u00E7\u00EA n\u00E3o possui login ");
		lblSeVoNo.setForeground(new Color(0, 0, 128));
		lblSeVoNo.setBackground(SystemColor.textHighlight);
		lblSeVoNo.setBounds(135, 231, 175, 14);
		contentPane.add(lblSeVoNo);
		
		JButton btnCadastrese = new JButton("Cadastre-se");
		btnCadastrese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				new CadastroFuncionario().setVisible(true);
				dispose();
				
				
			}
		});
		btnCadastrese.setBounds(279, 227, 114, 23);
		contentPane.add(btnCadastrese);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(180, 138, 201, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
	}
}
