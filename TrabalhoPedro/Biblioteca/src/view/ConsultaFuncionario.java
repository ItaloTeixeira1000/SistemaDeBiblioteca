package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Funcionario;
import model.dao.FuncionarioDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ConsultaFuncionario extends JInternalFrame {
	private JTable JTFuncionario;
	private JTextField txtNome;
	private JTextField txtTel;
	private JTextField txtSobrenome;
	
	private JTextField txtAcesso;
	private JTextField txtSenha;
	private JTextField txtData;
	private JTextField txtUsuario;
	private JTextField txtCpf;
	private JTextField txtBuscaNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaFuncionario frame = new ConsultaFuncionario();
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
	public ConsultaFuncionario() {
		setTitle("Consulta de Funcion\u00E1rios");
		
		setClosable(true);
		setBounds(100, 100, 879, 633);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 339, 861, 264);
		getContentPane().add(scrollPane);
		
		JTFuncionario = new JTable();
		
		JTFuncionario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Sobrenome", "Sexo", "Data de Nascimento", "CPF", "Telefone", "Acesso", "Usu\u00E1rio", "Senha"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(JTFuncionario);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 871, 328);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblNome.setBounds(10, 11, 46, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(20, 36, 174, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		try {
			javax.swing.text.MaskFormatter cpf= new javax.swing.text.MaskFormatter("###.###.###-##");
			JFormattedTextField txtCpf = new JFormattedTextField();
		}catch (Exception e) {
			
		}	
		
		JComboBox txtSexo = new JComboBox();
		txtSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione o sexo", "M", "F"}));
		txtSexo.setBounds(20, 184, 145, 20);
		panel.add(txtSexo);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblTelefone.setBounds(397, 82, 102, 14);
		panel.add(lblTelefone);
		
		txtTel = new JTextField();
		txtTel.setBounds(407, 107, 174, 20);
		panel.add(txtTel);
		txtTel.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Funcionario f = new Funcionario();
				FuncionarioDAO dao = new FuncionarioDAO();
				f.setNome(txtNome.getText());
				f.setSobrenome(txtSobrenome.getText());
				f.setSexo(txtSexo.getSelectedItem().toString());
				f.setDataDeNascimento(txtData.getText());
				f.setCpf(txtCpf.getText());
				f.setTelefone(txtTel.getText());
				f.setAcesso(txtAcesso.getText());
				f.setUsuario(txtAcesso.getText());
				f.setSenha(txtSenha.getText());
				
				dao.create(f);
				readJTable();
				
				txtNome.setText("");
				txtSobrenome.setText("");
				txtSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione o sexo", "M", "F"}));;
				txtData.setText("");
				txtCpf.setText("");
				txtTel.setText("");
				txtAcesso.setText("");
				txtAcesso.setText("");
				txtSenha.setText("");
				txtUsuario.setText("");
				
				
				
				
				
			}
			
		});
		btnCadastrar.setBounds(38, 279, 121, 23);
		panel.add(btnCadastrar);
		
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setBounds(397, 13, 46, 14);
		panel.add(lblCpf);
		

		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(10, 159, 46, 14);
		panel.add(lblSexo);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setBounds(10, 84, 86, 14);
		panel.add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(20, 107, 174, 20);
		panel.add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
	
		
		JLabel lblAcesso = new JLabel("Acesso");
		lblAcesso.setBounds(691, 13, 46, 14);
		panel.add(lblAcesso);
		
		txtAcesso = new JTextField();
		txtAcesso.setBounds(701, 36, 108, 20);
		panel.add(txtAcesso);
		txtAcesso.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(691, 84, 46, 14);
		panel.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(701, 107, 108, 20);
		panel.add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(397, 159, 121, 14);
		panel.add(lblDataDeNascimento);
		
		txtData = new JTextField();
		txtData.setBounds(407, 185, 132, 20);
		panel.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(691, 159, 46, 14);
		panel.add(lblUsurio);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(701, 185, 86, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JTFuncionario.getSelectedRow() != -1) {
					Funcionario f = new Funcionario();
					FuncionarioDAO dao = new FuncionarioDAO();
					f.setNome(txtNome.getText());
					f.setSobrenome(txtSobrenome.getText());
					f.setSexo(txtSexo.getSelectedItem().toString());
					f.setDataDeNascimento(txtData.getText());
					f.setCpf(txtCpf.getText());
					f.setTelefone(txtTel.getText());
					f.setAcesso(txtAcesso.getText());
					f.setUsuario(txtAcesso.getText());
					f.setSenha(txtSenha.getText());
					f.setIdFuncionario((int)JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(), 0));
					
					dao.update(f);
					readJTable();
					
					txtNome.setText("");
					txtSobrenome.setText("");
					txtSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione o sexo", "M", "F"}));;
					txtData.setText("");
					txtCpf.setText("");
					txtTel.setText("");
					txtAcesso.setText("");
					txtAcesso.setText("");
					txtSenha.setText("");
					txtUsuario.setText("");
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
				
			}
		});
		btnAtualizar.setBounds(188, 279, 89, 23);
		panel.add(btnAtualizar);
		
	
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JTFuncionario.getSelectedRow() != -1) {
					Funcionario f = new Funcionario();
					FuncionarioDAO dao = new FuncionarioDAO();
					f.setIdFuncionario((int)JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(), 0));
					
					dao.delete(f);
					readJTable();
					
					txtNome.setText("");
					txtSobrenome.setText("");
					txtSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione o sexo", "M", "F"}));;
					txtData.setText("");
					txtCpf.setText("");
					txtTel.setText("");
					txtAcesso.setText("");
					txtAcesso.setText("");
					txtSenha.setText("");
					txtUsuario.setText("");
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
			}
		});
		btnDeletar.setBounds(307, 279, 89, 23);
		panel.add(btnDeletar);
		
		JTFuncionario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if(JTFuncionario.getSelectedRow() != -1) {
					String tSexo = (String) JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),3).toString();
					txtNome.setText(JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),1).toString());
					txtSobrenome.setText(JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),2).toString());
					if(tSexo == "M") {
						txtSexo.setModel(new DefaultComboBoxModel(new String[] {tSexo,"M","F"}));;
					}else {
						txtSexo.setModel(new DefaultComboBoxModel(new String[] {tSexo,"F","M"}));;
					}
					
					txtData.setText(JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),4).toString());
					txtCpf.setText(JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),5).toString());
					txtTel.setText(JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),6).toString());
					txtAcesso.setText(JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),7).toString());
					txtUsuario.setText(JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),8).toString());
					txtSenha.setText(JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),9).toString());
				}
				
			}
		});
		JTFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JTFuncionario.getSelectedRow() != -1) {
					String tSexo = (String) JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),3).toString();
					txtNome.setText(JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),1).toString());
					txtSobrenome.setText(JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),2).toString());
					if(tSexo == "M") {
						txtSexo.setModel(new DefaultComboBoxModel(new String[] {tSexo,"M","F"}));;
					}else {
						txtSexo.setModel(new DefaultComboBoxModel(new String[] {tSexo,"F","M"}));;
					}
					
					txtData.setText(JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),4).toString());
					
					txtTel.setText(JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),6).toString());
					txtAcesso.setText(JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),7).toString());
					txtUsuario.setText(JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),8).toString());
					txtSenha.setText(JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),9).toString());
					txtCpf.setText(JTFuncionario.getValueAt(JTFuncionario.getSelectedRow(),5).toString());
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
			}
		});
		
		txtCpf = new JTextField();
		txtCpf.setBounds(407, 36, 174, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtBuscaNome = new JTextField();
		txtBuscaNome.setBounds(532, 280, 178, 20);
		panel.add(txtBuscaNome);
		txtBuscaNome.setColumns(10);
		
		JButton btnPesquisar = new JButton("Buscar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				readJTableForName(txtBuscaNome.getText());
			}
		});
		btnPesquisar.setBounds(720, 279, 89, 23);
		panel.add(btnPesquisar);
		
	
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Suporte\\Desktop\\Trabalho\\TrabalhoPedro\\Biblioteca\\src\\images\\ca.jpg"));
		label.setBounds(0, 0, 861, 328);
		panel.add(label);
		readJTable();

	}
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) JTFuncionario.getModel();
		modelo.setNumRows(0);
		FuncionarioDAO fdao = new FuncionarioDAO();
		
		for(Funcionario f: fdao.read()) {
			modelo.addRow(new Object[] {
				f.getIdFuncionario(),
				f.getNome(),
				f.getSobrenome(),
				f.getSexo(),
				f.getDataDeNascimento(),
				f.getCpf(),
				f.getTelefone(),
				f.getAcesso(),
				f.getUsuario(),
				f.getSenha()
				
			});
		}
	}
	
	public void readJTableForName(String nome) {
		DefaultTableModel modelo = (DefaultTableModel) JTFuncionario.getModel();
		modelo.setNumRows(0);
		FuncionarioDAO fdao = new FuncionarioDAO();
		
		for(Funcionario f: fdao.readForName(nome)) {
			modelo.addRow(new Object[] {
				f.getIdFuncionario(),
				f.getNome(),
				f.getSobrenome(),
				f.getSexo(),
				f.getDataDeNascimento(),
				f.getCpf(),
				f.getTelefone(),
				f.getAcesso(),
				f.getUsuario(),
				f.getSenha()
				
			});
		}
	}
}
