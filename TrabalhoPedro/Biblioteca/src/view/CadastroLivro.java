package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CadastroLivro extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

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
		setClosable(true);
		setBounds(100, 100, 501, 426);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 485, 396);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setBounds(10, 8, 65, 14);
		panel.add(lblTtulo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(20, 30, 194, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(268, 8, 65, 14);
		panel.add(lblAutor);
		
		textField_5 = new JTextField();
		textField_5.setBounds(278, 30, 194, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(10, 68, 65, 14);
		panel.add(lblIsbn);
		
		textField = new JTextField();
		textField.setBounds(20, 93, 194, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblGnero = new JLabel("G\u00EAnero");
		lblGnero.setBounds(268, 68, 82, 14);
		panel.add(lblGnero);
		
		textField_3 = new JTextField();
		textField_3.setBounds(278, 93, 194, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 134, 82, 14);
		panel.add(lblDescrio);
		
		textField_7 = new JTextField();
		textField_7.setBounds(20, 159, 194, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblIdioma = new JLabel("Idioma");
		lblIdioma.setBounds(268, 134, 82, 14);
		panel.add(lblIdioma);
		
		textField_4 = new JTextField();
		textField_4.setBounds(278, 159, 194, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDataDePulblicao = new JLabel("Data de Pulblica\u00E7\u00E3o");
		lblDataDePulblicao.setBounds(10, 200, 204, 14);
		panel.add(lblDataDePulblicao);
		
		textField_8 = new JTextField();
		textField_8.setBounds(20, 225, 194, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setBounds(268, 200, 75, 14);
		panel.add(lblEditora);
		
		textField_2 = new JTextField();
		textField_2.setBounds(278, 225, 194, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblrea = new JLabel("\u00C1rea");
		lblrea.setBounds(10, 256, 65, 14);
		panel.add(lblrea);
		
		textField_6 = new JTextField();
		textField_6.setBounds(20, 281, 194, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(125, 349, 65, 23);
		panel.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(268, 349, 103, 23);
		panel.add(btnCancelar);

	}
}
