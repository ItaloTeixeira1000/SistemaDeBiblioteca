package view;

import java.awt.EventQueue;
import connection.ConnectionFactory;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import model.bean.Funcionario;
import model.bean.Livro;
import model.dao.FuncionarioDAO;
import model.dao.LeitorDAO;
import model.dao.LivroDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConsultaLivro extends JInternalFrame {
	private JTable JTLivro;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtIsbn;
	private JTextField txtGenero;
	private JTextField txtDesc;
	private JTextField txtIdioma;
	private JTextField txtEditora;
	private JTextField txtData;
	private JTextField txtArea;
	private JTextField txtBuscaTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaLivro frame = new ConsultaLivro();
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
	public ConsultaLivro() {
		setTitle("Consulta de Livros");
		
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 1033, 610);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(4))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblTtulo.setBounds(10, 11, 46, 14);
		panel.add(lblTtulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(20, 36, 166, 20);
		panel.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblAutor.setBounds(10, 113, 46, 14);
		panel.add(lblAutor);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(20, 138, 156, 20);
		panel.add(txtAutor);
		txtAutor.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblIsbn.setBounds(302, 11, 46, 14);
		panel.add(lblIsbn);
		
		txtIsbn = new JTextField();
		txtIsbn.setBounds(312, 36, 156, 20);
		panel.add(txtIsbn);
		txtIsbn.setColumns(10);
		
		JLabel lblGnero = new JLabel("G\u00EAnero");
		lblGnero.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblGnero.setBounds(302, 113, 46, 14);
		panel.add(lblGnero);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(312, 138, 156, 20);
		panel.add(txtGenero);
		txtGenero.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblDescrio.setBounds(581, 11, 71, 14);
		panel.add(lblDescrio);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(581, 36, 155, 20);
		panel.add(txtDesc);
		txtDesc.setColumns(10);
		
		JLabel lblIdioma = new JLabel("Idioma");
		lblIdioma.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblIdioma.setBounds(581, 113, 46, 14);
		panel.add(lblIdioma);
		
		txtIdioma = new JTextField();
		txtIdioma.setBounds(581, 138, 155, 20);
		panel.add(txtIdioma);
		txtIdioma.setColumns(10);
		
		JLabel lblEditora = new JLabel("Editora");
		lblEditora.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblEditora.setBounds(839, 11, 46, 14);
		panel.add(lblEditora);
		
		txtEditora = new JTextField();
		txtEditora.setBounds(839, 36, 166, 20);
		panel.add(txtEditora);
		txtEditora.setColumns(10);
		
		JLabel lblDataDePublicao = new JLabel("Data de Publica\u00E7\u00E3o");
		lblDataDePublicao.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblDataDePublicao.setBounds(839, 113, 119, 14);
		panel.add(lblDataDePublicao);
		
		txtData = new JTextField();
		txtData.setBounds(839, 138, 166, 20);
		panel.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblrea = new JLabel("\u00C1rea");
		lblrea.setBounds(10, 182, 46, 14);
		panel.add(lblrea);
		lblrea.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		txtArea = new JTextField();
		txtArea.setBounds(30, 207, 156, 20);
		panel.add(txtArea);
		txtArea.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(54, 262, 126, 23);
		panel.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JTLivro.getSelectedRow()!= -1) {
					Livro l = new Livro();
					LivroDAO dao = new LivroDAO();
					l.setTitulo(txtTitulo.getText());
					l.setAutor(txtAutor.getText());
					l.setIsbn(Integer.parseInt(txtIsbn.getText()));
					l.setGenero(txtGenero.getText());
					l.setDescricao(txtDesc.getText());
					l.setIdioma(txtIdioma.getText());
					l.setEditora(txtEditora.getText());
					l.setDataDePublicacao(txtData.getText());
					l.setArea(txtArea.getText());
					l.setIdLivro((int)JTLivro.getValueAt(JTLivro.getSelectedRow(), 0));
					
					dao.update(l);
					
					txtTitulo.setText("");
					txtAutor.setText("");
					txtIsbn.setText("");
					txtGenero.setText("");
					txtDesc.setText("");
					txtIdioma.setText("");
					txtEditora.setText("");
					txtData.setText("");
					txtArea.setText("");
					
					readJTable();
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
			}
		});
		btnAtualizar.setBounds(229, 262, 89, 23);
		panel.add(btnAtualizar);
		
		JButton btnDelatar = new JButton("Deletar");
		btnDelatar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(JTLivro.getSelectedRow()!= -1) {
					Livro l = new Livro();
					LivroDAO dao = new LivroDAO();
					
					l.setIdLivro((int)JTLivro.getValueAt(JTLivro.getSelectedRow(), 0));
					
					dao.delete(l);
					
					txtTitulo.setText("");
					txtAutor.setText("");
					txtIsbn.setText("");
					txtGenero.setText("");
					txtDesc.setText("");
					txtIdioma.setText("");
					txtEditora.setText("");
					txtData.setText("");
					txtArea.setText("");
					
					readJTable();
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
				
				
			}
		});
		btnDelatar.setBounds(378, 262, 89, 23);
		panel.add(btnDelatar);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				readJTableForTitulo(txtBuscaTitulo.getText());
			}
		});
		btnNewButton.setBounds(796, 262, 89, 23);
		panel.add(btnNewButton);
		
		txtBuscaTitulo = new JTextField();
		txtBuscaTitulo.setBounds(617, 263, 156, 20);
		panel.add(txtBuscaTitulo);
		txtBuscaTitulo.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Suporte\\Desktop\\Trabalho\\TrabalhoPedro\\Biblioteca\\src\\images\\ca.jpg"));
		label.setBounds(0, 0, 1024, 296);
		panel.add(label);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Livro l = new Livro();
				LivroDAO dao = new LivroDAO();
				l.setTitulo(txtTitulo.getText());
				l.setAutor(txtAutor.getText());
				l.setIsbn(Integer.parseInt(txtIsbn.getText()));
				l.setGenero(txtGenero.getText());
				l.setDescricao(txtDesc.getText());
				l.setIdioma(txtIdioma.getText());
				l.setEditora(txtEditora.getText());
				l.setDataDePublicacao(txtData.getText());
				l.setArea(txtArea.getText());
				
				dao.create(l);
				txtTitulo.setText("");
				txtAutor.setText("");
				txtIsbn.setText("");
				txtGenero.setText("");
				txtDesc.setText("");
				txtIdioma.setText("");
				txtEditora.setText("");
				txtData.setText("");
				txtArea.setText("");
				readJTable();
				
			}
		});
		
		JTLivro = new JTable();
		JTLivro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if(JTLivro.getSelectedRow() != -1) {
					txtTitulo.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),1).toString());
					txtAutor.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),2).toString());
					txtIsbn.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),3).toString());
					txtGenero.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),4).toString());
					txtDesc.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),5).toString());
					txtIdioma.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),6).toString());
					txtEditora.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),7).toString());
					txtData.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),8).toString());
					txtArea.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),9).toString());
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
				
			}
		});
		JTLivro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(JTLivro.getSelectedRow() != -1) {
					txtTitulo.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),1).toString());
					txtAutor.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),2).toString());
					txtIsbn.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),3).toString());
					txtGenero.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),4).toString());
					txtDesc.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),5).toString());
					txtIdioma.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),6).toString());
					txtEditora.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),7).toString());
					txtData.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),8).toString());
					txtArea.setText(JTLivro.getValueAt(JTLivro.getSelectedRow(),9).toString());
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
				
				
			}
		});
		JTLivro.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "T\u00EDtulo", "Autor", "ISBN", "G\u00EAnero", "Descri\u00E7\u00E3o", "Idioma", "Editora", "Data de Publica\u00E7\u00E3o", "\u00C1rea"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		JTLivro.getColumnModel().getColumn(5).setPreferredWidth(184);
		JTLivro.getColumnModel().getColumn(7).setPreferredWidth(94);
		JTLivro.getColumnModel().getColumn(8).setPreferredWidth(115);
		scrollPane.setViewportView(JTLivro);
		getContentPane().setLayout(groupLayout);
		readJTable();

	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) JTLivro.getModel();
		modelo.setNumRows(0);
		LivroDAO ldao = new LivroDAO();
		
		for(Livro l: ldao.read()) {
			modelo.addRow(new Object[] {
				l.getIdLivro(),
				l.getTitulo(),
				l.getAutor(),
				l.getIsbn(),
				l.getGenero(),
				l.getDescricao(),
				l.getIdioma(),
				l.getEditora(),
				l.getDataDePublicacao(),
				l.getArea()
				
			});
		}
	}
	public void readJTableForTitulo(String titulo) {
		DefaultTableModel modelo = (DefaultTableModel) JTLivro.getModel();
		modelo.setNumRows(0);
		LivroDAO ldao = new LivroDAO();
		
		for(Livro l: ldao.readForTitulo(titulo)) {
			modelo.addRow(new Object[] {
				l.getIdLivro(),
				l.getTitulo(),
				l.getAutor(),
				l.getIsbn(),
				l.getGenero(),
				l.getDescricao(),
				l.getIdioma(),
				l.getEditora(),
				l.getDataDePublicacao(),
				l.getArea()
				
			});
		}
	}
}
