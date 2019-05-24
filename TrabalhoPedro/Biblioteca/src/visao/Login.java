package visao;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfusuario;
	private JPasswordField tfsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNome = new JLabel("Nome:");
			lblNome.setBounds(42, 32, 46, 14);
			contentPanel.add(lblNome);
		}
		{
			tfusuario = new JTextField();
			tfusuario.setBounds(52, 57, 328, 20);
			contentPanel.add(tfusuario);
			tfusuario.setColumns(10);
		}
		{
			JLabel lblSenha = new JLabel("Senha");
			lblSenha.setBounds(42, 108, 46, 14);
			contentPanel.add(lblSenha);
		}
		
		tfsenha = new JPasswordField();
		tfsenha.setBounds(52, 133, 328, 20);
		contentPanel.add(tfsenha);
		
		JButton usuario = new JButton("Entrar");
		usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conn = controle.Conexao.criarConexao();			
					String sql = "select * from funcionario where usuario =? and senha =?";
					
			
						
				}catch(Exception e) {
					
				}
			}
		});
		usuario.setBounds(94, 193, 89, 23);
		contentPanel.add(usuario);
		
		JButton sair = new JButton("Sair");
		sair.setBounds(237, 193, 89, 23);
		contentPanel.add(sair);
	}
}
