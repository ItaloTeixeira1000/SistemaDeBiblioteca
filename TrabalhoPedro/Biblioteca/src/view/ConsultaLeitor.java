package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.table.TableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class ConsultaLeitor extends JInternalFrame {
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtCpf;
	private JTextField txtSexo;
	private JTextField txtData;
	private JTable jTLeitores;
	private JTextField txtEmail;

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
		setClosable(true);
		setTitle("Consulta de Leitores Cadastrados");
		setBounds(100, 100, 885, 495);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 869, 169);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblNome.setBackground(new Color(240, 240, 240));
		lblNome.setBounds(10, 11, 46, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		txtNome.setBounds(20, 36, 163, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblSobrenome.setBounds(10, 67, 91, 14);
		panel.add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		txtSobrenome.setBounds(20, 92, 163, 20);
		panel.add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblCpf.setBounds(314, 11, 46, 14);
		panel.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		txtCpf.setBounds(324, 36, 163, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblSexo.setBounds(314, 67, 46, 14);
		panel.add(lblSexo);
		
		txtSexo = new JTextField();
		txtSexo.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		txtSexo.setBounds(324, 92, 163, 20);
		panel.add(txtSexo);
		txtSexo.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblDataDeNascimento.setBounds(605, 11, 134, 14);
		panel.add(lblDataDeNascimento);
		
		txtData = new JTextField();
		txtData.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		txtData.setBounds(615, 36, 217, 20);
		panel.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		lblEmail.setBounds(605, 67, 46, 14);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		txtEmail.setBounds(615, 92, 217, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(new Color(153, 153, 255));
		btnAtualizar.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(jTLeitores.getSelectedRow() != -1) {
					jTLeitores.setValueAt(txtNome.getText(), jTLeitores.getSelectedRow(), 0);
					jTLeitores.setValueAt(txtSobrenome.getText(), jTLeitores.getSelectedRow(), 1);
					jTLeitores.setValueAt(txtCpf.getText(), jTLeitores.getSelectedRow(), 2);
					jTLeitores.setValueAt(txtSexo.getText(), jTLeitores.getSelectedRow(), 3);
					jTLeitores.setValueAt(txtEmail.getText(), jTLeitores.getSelectedRow(), 4);
					jTLeitores.setValueAt(txtData.getText(), jTLeitores.getSelectedRow(), 5);
				}
			}
		});
		btnAtualizar.setBounds(387, 135, 89, 23);
		panel.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBackground(new Color(153, 153, 255));
		btnDeletar.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				System.out.println("Linha selecionada " + jTLeitores.getSelectedRow());
				if(jTLeitores.getSelectedRow() != -1) {
					DefaultTableModel dtmLeitores = (DefaultTableModel) jTLeitores.getModel();
					dtmLeitores.removeRow(jTLeitores.getSelectedRow());
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um leitor cadastrado para excluir");
				}
			}
		});
		btnDeletar.setBounds(698, 135, 89, 23);
		panel.add(btnDeletar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color(153, 153, 255));
		btnCadastrar.setFont(new Font("Segoe Print", Font.PLAIN, 10));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtmLeitores = (DefaultTableModel)jTLeitores.getModel();
				Object[] dados = {txtNome.getText(), txtSobrenome.getText(),txtCpf.getText(), txtSexo.getText(), txtData.getText(), txtEmail.getText()};
				dtmLeitores.addRow(dados);
			}
		});
		btnCadastrar.setBounds(83, 135, 89, 23);
		panel.add(btnCadastrar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 168, 869, 292);
		getContentPane().add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		jTLeitores = new JTable();
		jTLeitores.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if(jTLeitores.getSelectedRow() != -1) {
					txtNome.setText(jTLeitores.getValueAt(jTLeitores.getSelectedRow(), 0).toString());
					txtSobrenome.setText(jTLeitores.getValueAt(jTLeitores.getSelectedRow(), 1).toString());
					txtCpf.setText(jTLeitores.getValueAt(jTLeitores.getSelectedRow(), 2).toString());
					txtSexo.setText(jTLeitores.getValueAt(jTLeitores.getSelectedRow(), 3).toString());
					txtEmail.setText(jTLeitores.getValueAt(jTLeitores.getSelectedRow(), 4).toString());
					txtData.setText(jTLeitores.getValueAt(jTLeitores.getSelectedRow(), 5).toString());
				}
			}
		});
		jTLeitores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(jTLeitores.getSelectedRow() != -1) {
					txtNome.setText(jTLeitores.getValueAt(jTLeitores.getSelectedRow(), 0).toString());
					txtSobrenome.setText(jTLeitores.getValueAt(jTLeitores.getSelectedRow(), 1).toString());
					txtCpf.setText(jTLeitores.getValueAt(jTLeitores.getSelectedRow(), 2).toString());
					txtSexo.setText(jTLeitores.getValueAt(jTLeitores.getSelectedRow(), 3).toString());
					txtEmail.setText(jTLeitores.getValueAt(jTLeitores.getSelectedRow(), 4).toString());
					txtData.setText(jTLeitores.getValueAt(jTLeitores.getSelectedRow(), 5).toString());
				}
			}
		});
		jTLeitores.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Sobrenome", "CPF", "Sexo", "Email", "Data de Nascimento"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		jTLeitores.getColumnModel().getColumn(0).setPreferredWidth(115);
		jTLeitores.getColumnModel().getColumn(1).setPreferredWidth(132);
		jTLeitores.getColumnModel().getColumn(2).setPreferredWidth(86);
		jTLeitores.getColumnModel().getColumn(4).setPreferredWidth(105);
		jTLeitores.getColumnModel().getColumn(5).setPreferredWidth(116);
		scrollPane.setViewportView(jTLeitores);
		panel_1.setLayout(gl_panel_1);

	}
	public TableModel getTableModel() {
		return jTLeitores.getModel();
	}
	public void setTableModel(TableModel model) {
		jTLeitores.setModel(model);
	}
}
