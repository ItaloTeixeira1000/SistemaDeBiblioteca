package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroLivro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroLivro frame = new CadastroLivro();
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
	public CadastroLivro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EDtulo");
		lblNewLabel.setBounds(33, 25, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(43, 50, 249, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(33, 85, 46, 14);
		contentPane.add(lblAutor);
		
		textField_1 = new JTextField();
		textField_1.setBounds(43, 110, 249, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(325, 25, 46, 14);
		contentPane.add(lblData);
		
		textField_2 = new JTextField();
		textField_2.setBounds(325, 50, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblGnero = new JLabel("G\u00EAnero");
		lblGnero.setBounds(33, 141, 46, 14);
		contentPane.add(lblGnero);
		
		textField_3 = new JTextField();
		textField_3.setBounds(43, 166, 249, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(325, 85, 46, 14);
		contentPane.add(lblIsbn);
		
		textField_4 = new JTextField();
		textField_4.setBounds(325, 110, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblIdioma = new JLabel("Idioma");
		lblIdioma.setBounds(325, 141, 46, 14);
		contentPane.add(lblIdioma);
		
		textField_5 = new JTextField();
		textField_5.setBounds(325, 166, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setBounds(33, 197, 46, 14);
		contentPane.add(lblEditora);
		
		textField_6 = new JTextField();
		textField_6.setBounds(43, 222, 249, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblrea = new JLabel("\u00C1rea");
		lblrea.setBounds(325, 197, 46, 14);
		contentPane.add(lblrea);
		
		textField_7 = new JTextField();
		textField_7.setBounds(325, 222, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(76, 282, 96, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(282, 282, 89, 23);
		contentPane.add(btnCancelar);
	}
}
