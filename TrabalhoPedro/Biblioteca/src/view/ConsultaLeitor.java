package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import model.bean.Funcionario;
import model.bean.Leitor;
import model.dao.FuncionarioDAO;
import model.dao.LeitorDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ConsultaLeitor extends JInternalFrame {
	private JTable JTLeitor;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtEmail;
	private JTextField txtData;
	private JTextField txtCpf;
	private JTextField txtBuscaNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaLeitor frame = new ConsultaLeitor();
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
	public ConsultaLeitor() {
		setTitle("Consulta de Leitores");
		
		setClosable(true);
		setBounds(100, 100, 797, 461);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 781, 193);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblNome.setBounds(10, 11, 46, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(20, 36, 180, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JComboBox txtSexo = new JComboBox();
		txtSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione o sexo", "M", "F"}));
		txtSexo.setBounds(347, 90, 147, 20);
		panel.add(txtSexo);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblSobrenome.setBounds(10, 67, 105, 14);
		panel.add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(20, 90, 180, 20);
		panel.add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblEmail.setBounds(337, 11, 46, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(347, 36, 180, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblSexo.setBounds(337, 67, 46, 14);
		panel.add(lblSexo);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblDataDeNascimento.setBounds(602, 11, 157, 14);
		panel.add(lblDataDeNascimento);
		
		txtData = new JTextField();
		txtData.setBounds(612, 36, 119, 20);
		panel.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblCpf.setBounds(602, 67, 46, 14);
		panel.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(612, 90, 147, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Leitor l = new Leitor();
				LeitorDAO dao = new LeitorDAO();
				
				l.setNome(txtNome.getText());
				l.setSobrenome(txtSobrenome.getText());
				l.setCpf(txtCpf.getText());
				
				l.setSexo(txtSexo.getSelectedItem().toString());
				l.setDataNascimento(txtData.getText());
				l.setEmail(txtEmail.getText());
				
				dao.create(l);
				
				txtNome.setText("");
				txtSobrenome.setText("");
				txtCpf.setText("");
				
				txtSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione o sexo", "M", "F"}));;
				txtData.setText("");
				txtEmail.setText("");
				
				readJTable();
				
			
			
			}
		});
		btnNewButton.setBounds(20, 159, 111, 23);
		panel.add(btnNewButton);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JTLeitor.getSelectedRow()!=-1) {
					Leitor l = new Leitor();
					LeitorDAO dao = new LeitorDAO();
					
					l.setNome(txtNome.getText());
					l.setSobrenome(txtSobrenome.getText());
					l.setCpf(txtCpf.getText());
					l.setSexo(txtSexo.getSelectedItem().toString());
					l.setDataNascimento(txtData.getText());
					l.setEmail(txtEmail.getText());
					l.setIdLeitor((int)JTLeitor.getValueAt(JTLeitor.getSelectedRow(), 0));
					
					dao.update(l);
					
					txtNome.setText("");
					txtSobrenome.setText("");
					txtCpf.setText("");
					txtSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione o sexo", "M", "F"}));;
					txtData.setText("");
					txtEmail.setText("");
					
					readJTable();
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
			}
		});
		btnAtualizar.setBounds(170, 159, 89, 23);
		panel.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JTLeitor.getSelectedRow()!=-1) {
					Leitor l = new Leitor();
					LeitorDAO dao = new LeitorDAO();
					
					l.setNome(txtNome.getText());
					l.setSobrenome(txtSobrenome.getText());
					l.setCpf(txtCpf.getText());
					l.setSexo(txtSexo.getSelectedItem().toString());
					l.setDataNascimento(txtData.getText());
					l.setEmail(txtEmail.getText());
					l.setIdLeitor((int)JTLeitor.getValueAt(JTLeitor.getSelectedRow(), 0));
					
					dao.delete(l);
					
					txtNome.setText("");
					txtSobrenome.setText("");
					txtCpf.setText("");
					txtSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione o sexo", "M", "F"}));;
					txtData.setText("");
					txtEmail.setText("");
					
					readJTable();
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
				
			}
		});
		btnDeletar.setBounds(294, 159, 89, 23);
		panel.add(btnDeletar);
		
		txtBuscaNome = new JTextField();
		txtBuscaNome.setBounds(493, 159, 157, 22);
		panel.add(txtBuscaNome);
		txtBuscaNome.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				readJTableForName(txtBuscaNome.getText());
			}
		});
		btnBuscar.setBounds(660, 159, 89, 23);
		panel.add(btnBuscar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Suporte\\Desktop\\Trabalho\\TrabalhoPedro\\Biblioteca\\src\\images\\ca.jpg"));
		label.setBounds(0, 0, 781, 192);
		panel.add(label);
		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 192, 781, 239);
		getContentPane().add(scrollPane);
		
		JTLeitor = new JTable();
		JTLeitor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(JTLeitor.getSelectedRow() != -1) {
					String tSexo = (String) JTLeitor.getValueAt(JTLeitor.getSelectedRow(),4).toString();
					txtNome.setText(JTLeitor.getValueAt(JTLeitor.getSelectedRow(),1).toString());
					txtSobrenome.setText(JTLeitor.getValueAt(JTLeitor.getSelectedRow(),2).toString());
					txtCpf.setText(JTLeitor.getValueAt(JTLeitor.getSelectedRow(),3).toString());
					if(tSexo == "M") {
						txtSexo.setModel(new DefaultComboBoxModel(new String[] {tSexo,"M"}));;
					}else {
						txtSexo.setModel(new DefaultComboBoxModel(new String[] {tSexo,"F"}));;
					}
					//(JTLeitor.getValueAt(JTLeitor.getSelectedRow(),4).toString());
					txtData.setText(JTLeitor.getValueAt(JTLeitor.getSelectedRow(),5).toString());
					txtEmail.setText(JTLeitor.getValueAt(JTLeitor.getSelectedRow(),6).toString());
				
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
				
				
			}
		});
		JTLeitor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(JTLeitor.getSelectedRow() != -1) {
					String tSexo = (String) JTLeitor.getValueAt(JTLeitor.getSelectedRow(),4).toString();
					txtNome.setText(JTLeitor.getValueAt(JTLeitor.getSelectedRow(),1).toString());
					txtSobrenome.setText(JTLeitor.getValueAt(JTLeitor.getSelectedRow(),2).toString());
					txtCpf.setText(JTLeitor.getValueAt(JTLeitor.getSelectedRow(),3).toString());
					if(tSexo == "M") {
						txtSexo.setModel(new DefaultComboBoxModel(new String[] {tSexo,"M"}));;
					}else {
						txtSexo.setModel(new DefaultComboBoxModel(new String[] {tSexo,"F"}));;
					}
					//(JTLeitor.getValueAt(JTLeitor.getSelectedRow(),4).toString());
					txtData.setText(JTLeitor.getValueAt(JTLeitor.getSelectedRow(),5).toString());
					txtEmail.setText(JTLeitor.getValueAt(JTLeitor.getSelectedRow(),6).toString());
				
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
				
			}
		});
		JTLeitor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Sobrenome", "CPF", "Sexo", "Data de Nascimento", "Email"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		JTLeitor.getColumnModel().getColumn(5).setPreferredWidth(153);
		scrollPane.setViewportView(JTLeitor);
		readJTable();

	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) JTLeitor.getModel();
		modelo.setNumRows(0);
		LeitorDAO ldao = new LeitorDAO();
		
		for(Leitor l: ldao.read()) {
			modelo.addRow(new Object[] {
				l.getIdLeitor(),
				l.getNome(),
				l.getSobrenome(),
				l.getCpf(),
				l.getSexo(),
				l.getDataNascimento(),
				l.getEmail()
				
			});
		}
	}
	
	public void readJTableForName(String nome) {
		DefaultTableModel modelo = (DefaultTableModel) JTLeitor.getModel();
		modelo.setNumRows(0);
		LeitorDAO ldao = new LeitorDAO();
		
		for(Leitor l: ldao.readForName(nome)) {
			modelo.addRow(new Object[] {
				l.getIdLeitor(),
				l.getNome(),
				l.getSobrenome(),
				l.getCpf(),
				l.getSexo(),
				l.getDataNascimento(),
				l.getEmail()
				
			});
		}
	}
}
