package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Fornecedor;
import model.dao.FornecedorDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConsultaFornecedor extends JInternalFrame {
	private JTable jTFornecedores;
	private JTextField txtNome;
	private JTextField txtTipo;
	private JTextField txtEndereco;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField txtUrl;
	private JTextField txtBuscaNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaFornecedor frame = new ConsultaFornecedor();
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
	public ConsultaFornecedor() {
		setTitle("Consulta de Fornecedores");
		setClosable(true);
		setBounds(100, 100, 941, 541);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 925, 210);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblNome.setBounds(10, 11, 74, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(20, 36, 168, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblTipoDeInstituio = new JLabel("Tipo de Institui\u00E7\u00E3o");
		lblTipoDeInstituio.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblTipoDeInstituio.setBounds(10, 86, 140, 14);
		panel.add(lblTipoDeInstituio);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(20, 111, 168, 20);
		panel.add(txtTipo);
		txtTipo.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblEndereo.setBounds(364, 11, 81, 14);
		panel.add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(374, 36, 193, 20);
		panel.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblTelefone.setBounds(364, 86, 81, 14);
		panel.add(lblTelefone);
		
		txtTel = new JTextField();
		txtTel.setBounds(374, 111, 193, 20);
		panel.add(txtTel);
		txtTel.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblEmail.setBounds(736, 11, 65, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(746, 36, 169, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblUrl.setBounds(736, 86, 65, 14);
		panel.add(lblUrl);
		
		txtUrl = new JTextField();
		txtUrl.setBounds(746, 111, 169, 20);
		panel.add(txtUrl);
		txtUrl.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(jTFornecedores.getSelectedRow()!=-1) {
					Fornecedor f = new Fornecedor();
					FornecedorDAO dao = new FornecedorDAO();
					
					f.setNome(txtNome.getText());
					f.setTipoDeInstituicao(txtTipo.getText());
					f.setEndereco(txtEndereco.getText());
					f.setTelefone(txtTel.getText());
					f.setEmail(txtEmail.getText());
					f.setUrl(txtUrl.getText());
					f.setIdFornecedor((int)jTFornecedores.getValueAt(jTFornecedores.getSelectedRow(), 0));
					
					dao.update(f);
					txtNome.setText("");
					txtTipo.setText("");
					txtEndereco.setText("");
					txtTel.setText("");
					txtEmail.setText("");
					txtUrl.setText("");
				
					readJTable();
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
				
			}
		});
		btnAtualizar.setBounds(228, 164, 89, 23);
		panel.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Deletar");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(jTFornecedores.getSelectedRow()!=-1) {
				
				Fornecedor f = new Fornecedor();
				FornecedorDAO dao = new FornecedorDAO();
				
				f.setNome(txtNome.getText());
				f.setTipoDeInstituicao(txtTipo.getText());
				f.setEndereco(txtEndereco.getText());
				f.setTelefone(txtTel.getText());
				f.setEmail(txtEmail.getText());
				f.setUrl(txtUrl.getText());
				f.setIdFornecedor((int)jTFornecedores.getValueAt(jTFornecedores.getSelectedRow(), 0));
				
				dao.delete(f);
				txtNome.setText("");
				txtTipo.setText("");
				txtEndereco.setText("");
				txtTel.setText("");
				txtEmail.setText("");
				txtUrl.setText("");
			
				readJTable();
				
				}else {
					JOptionPane.showMessageDialog(null, "Selecione ums linha");
				}
			}
		});
		btnExcluir.setBounds(356, 164, 89, 23);
		panel.add(btnExcluir);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Fornecedor f = new Fornecedor();
					FornecedorDAO dao = new FornecedorDAO();
					
					f.setNome(txtNome.getText());
					f.setTipoDeInstituicao(txtTipo.getText());
					f.setEndereco(txtEndereco.getText());
					f.setTelefone(txtTel.getText());
					f.setEmail(txtEmail.getText());
					f.setUrl(txtUrl.getText());
					
					dao.create(f);
					txtNome.setText("");
					txtTipo.setText("");
					txtEndereco.setText("");
					txtTel.setText("");
					txtEmail.setText("");
					txtUrl.setText("");
				
					readJTable();
						
					}
					
			
		});
		btnCadastrar.setBounds(86, 164, 102, 23);
		panel.add(btnCadastrar);
		
		txtBuscaNome = new JTextField();
		txtBuscaNome.setBounds(583, 165, 169, 22);
		panel.add(txtBuscaNome);
		txtBuscaNome.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				readJTableForName(txtBuscaNome.getText());
			}
		});
		btnBuscar.setBounds(777, 164, 89, 23);
		panel.add(btnBuscar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Suporte\\Desktop\\Trabalho\\TrabalhoPedro\\Biblioteca\\src\\images\\ca.jpg"));
		label.setBounds(0, 0, 925, 210);
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 211, 925, 289);
		getContentPane().add(scrollPane);
		
		jTFornecedores = new JTable();
		jTFornecedores.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(jTFornecedores.getSelectedRow() != -1) {
					txtNome.setText(jTFornecedores.getValueAt(jTFornecedores.getSelectedRow(),1).toString());
					txtTipo.setText(jTFornecedores.getValueAt(jTFornecedores.getSelectedRow(),2).toString());
					txtEndereco.setText(jTFornecedores.getValueAt(jTFornecedores.getSelectedRow(),3).toString());
					txtTel.setText(jTFornecedores.getValueAt(jTFornecedores.getSelectedRow(),4).toString());
					txtEmail.setText(jTFornecedores.getValueAt(jTFornecedores.getSelectedRow(),5).toString());
					txtUrl.setText(jTFornecedores.getValueAt(jTFornecedores.getSelectedRow(),6).toString());
				
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
				
			}
		});
		jTFornecedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(jTFornecedores.getSelectedRow() != -1) {
					txtNome.setText(jTFornecedores.getValueAt(jTFornecedores.getSelectedRow(),1).toString());
					txtTipo.setText(jTFornecedores.getValueAt(jTFornecedores.getSelectedRow(),2).toString());
					txtEndereco.setText(jTFornecedores.getValueAt(jTFornecedores.getSelectedRow(),3).toString());
					txtTel.setText(jTFornecedores.getValueAt(jTFornecedores.getSelectedRow(),4).toString());
					txtEmail.setText(jTFornecedores.getValueAt(jTFornecedores.getSelectedRow(),5).toString());
					txtUrl.setText(jTFornecedores.getValueAt(jTFornecedores.getSelectedRow(),6).toString());
				
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
				
			}
		});
		jTFornecedores.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Tipo de Institui\u00E7\u00E3o", "Endere\u00E7o", "Telefone", "Email", "URL"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jTFornecedores.getColumnModel().getColumn(1).setPreferredWidth(166);
		jTFornecedores.getColumnModel().getColumn(2).setPreferredWidth(175);
		jTFornecedores.getColumnModel().getColumn(3).setPreferredWidth(162);
		jTFornecedores.getColumnModel().getColumn(4).setPreferredWidth(108);
		jTFornecedores.getColumnModel().getColumn(5).setPreferredWidth(157);
		jTFornecedores.getColumnModel().getColumn(6).setPreferredWidth(107);
		scrollPane.setViewportView(jTFornecedores);
		
		readJTable();

	}
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jTFornecedores.getModel();
		FornecedorDAO fdao = new FornecedorDAO();
		modelo.setNumRows(0);
		for(Fornecedor f : fdao.read()) {
			modelo.addRow(new Object[] {
					f.getIdFornecedor(),
					f.getNome(),
					f.getTipoDeInstituicao(),
					f.getEndereco(),
					f.getTelefone(),
					f.getEmail(),
					f.getUrl()
					
			});
		}
	}
	
	public void readJTableForName(String nome) {
		DefaultTableModel modelo = (DefaultTableModel) jTFornecedores.getModel();
		FornecedorDAO fdao = new FornecedorDAO();
		modelo.setNumRows(0);
		for(Fornecedor f : fdao.readForNome(nome)) {
			modelo.addRow(new Object[] {
					f.getIdFornecedor(),
					f.getNome(),
					f.getTipoDeInstituicao(),
					f.getEndereco(),
					f.getTelefone(),
					f.getEmail(),
					f.getUrl()
					
			});
		}
	}
}
