package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Funcionario;
import model.dao.FuncionarioDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class CadastroFuncionario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtSexo;
	private JTextField txtDataNasc;
	private JTextField txtCpf;
	private JTextField txtTel;
	private JTextField txtAcesso;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario frame = new CadastroFuncionario();
			
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
	public CadastroFuncionario() {
		setBackground(Color.CYAN);
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 730);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblNome.setBounds(42, 11, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Segoe Print", Font.PLAIN, 13));
		txtNome.setBackground(new Color(248, 248, 255));
		txtNome.setForeground(new Color(0, 0, 0));
		txtNome.setBounds(61, 36, 167, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblSobrenome.setBounds(312, 11, 95, 14);
		contentPane.add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		txtSobrenome.setBounds(348, 36, 177, 20);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblSexo.setBounds(42, 77, 46, 14);
		contentPane.add(lblSexo);
		
		txtSexo = new JTextField();
		txtSexo.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		txtSexo.setBounds(61, 102, 167, 20);
		contentPane.add(txtSexo);
		txtSexo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Data de Nascimento");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblNewLabel.setBounds(312, 77, 146, 14);
		contentPane.add(lblNewLabel);
		
		txtDataNasc = new JTextField();
		txtDataNasc.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		txtDataNasc.setBounds(348, 102, 177, 20);
		contentPane.add(txtDataNasc);
		txtDataNasc.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblCpf.setBounds(42, 144, 46, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		txtCpf.setBounds(61, 169, 167, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblTelefone.setBounds(312, 144, 61, 14);
		contentPane.add(lblTelefone);
		
		txtTel = new JTextField();
		txtTel.setDisabledTextColor(new Color(0, 0, 0));
		txtTel.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		txtTel.setBounds(347, 169, 178, 20);
		contentPane.add(txtTel);
		txtTel.setColumns(10);
		
		JLabel lblAcesso = new JLabel("Acesso");
		lblAcesso.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblAcesso.setBounds(651, 11, 46, 14);
		contentPane.add(lblAcesso);
		
		txtAcesso = new JTextField();
		txtAcesso.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		txtAcesso.setBounds(695, 36, 167, 20);
		contentPane.add(txtAcesso);
		txtAcesso.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblUsuario.setBounds(651, 144, 46, 14);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		txtUsuario.setBounds(695, 169, 167, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblSenha.setBounds(651, 77, 46, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		txtSenha.setForeground(new Color(0, 128, 128));
		txtSenha.setBackground(new Color(255, 255, 255));
		txtSenha.setBounds(695, 102, 167, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnCadastrar = new JButton("OK");
		btnCadastrar.setBackground(new Color(102, 153, 255));
		btnCadastrar.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario f = new Funcionario();
				FuncionarioDAO dao = new FuncionarioDAO();
				f.setNome(txtNome.getText());
				f.setSobrenome(txtSobrenome.getText());
				f.setSexo(txtSexo.getText());
				f.setDataDeNascimento(txtDataNasc.getText());
				f.setCpf(txtCpf.getText());
				f.setTelefone(txtTel.getText());
				f.setAcesso(txtAcesso.getText());
				f.setUsuario(txtUsuario.getText());
				f.setSenha(txtSenha.getText());
				
				txtNome.setText("");
				txtSobrenome.setText("");
				txtSexo.setText("");
				txtDataNasc.setText("");
				txtCpf.setText("");
				txtTel.setText("");
				txtAcesso.setText("");
				txtUsuario.setText("");
				txtSenha.setText("");
				
				dao.create(f);
				dispose();
				
				new Login().setVisible(true);
			}
		});
		btnCadastrar.setBounds(245, 297, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(new Color(102, 153, 255));
		btnVoltar.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		btnVoltar.setBounds(587, 297, 89, 23);
		contentPane.add(btnVoltar);
	}
}
