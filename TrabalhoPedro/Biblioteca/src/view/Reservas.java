package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import connection.ConnectionFactory;
import model.bean.Leitor;
import model.bean.Livro;
import model.bean.ReservasBean;
import model.dao.LeitorDAO;
import model.dao.LivroDAO;
import model.dao.ReservasDAO;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Reservas extends JInternalFrame {
	private JTable JTReserva;
	private JTextField txtDataE;
	private JTextField txtDataD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservas frame = new Reservas();
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
	public Reservas() {
		setClosable(true);
		setBounds(100, 100, 800, 619);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 204, 764, 385);
		getContentPane().add(scrollPane);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 764, 182);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox cbLeitor = new JComboBox();
		cbLeitor.setToolTipText("<String>");
		cbLeitor.setBounds(20, 57, 155, 20);
		panel.add(cbLeitor);
		ReservasDAO dao = new ReservasDAO();
		 DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(dao.popularLeitor().toArray());
		 cbLeitor.setModel(defaultComboBox);
		
	
		
		JComboBox cbLivro = new JComboBox();
		cbLivro.setToolTipText("<String>");
		cbLivro.setBounds(221, 56, 155, 23);
		panel.add(cbLivro);
		cbLivro.setModel(defaultComboBox);
		 DefaultComboBoxModel defaultComboBox2 = new DefaultComboBoxModel(dao.popularLivro().toArray());
		 cbLivro.setModel(defaultComboBox2);
		
		JButton btnResservar = new JButton("Reservar");
		btnResservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReservasBean r = new ReservasBean();
				ReservasDAO dao = new ReservasDAO();
				r.setNomeLeitor(cbLeitor.getSelectedItem().toString());
				r.setNomeLivro(cbLivro.getSelectedItem().toString());
				r.setDataEmprestimo(txtDataE.getText());
				r.setDataDevolucao(txtDataD.getText());
				int c = 0;
				for(int i = 0; i < JTReserva.getRowCount(); i++){ 
					if(JTReserva.getModel().getValueAt(i,2).toString() == r.getNomeLivro()) {
						c = 1;
					}
					
				}
				if(c == 0) {
					dao.create(r);
					readJTable();
					
				}else {
					JOptionPane.showMessageDialog(null, "Livro já reservado");
					readJTable();
				}
				
				
				
			}
		});
		btnResservar.setBounds(166, 148, 89, 23);
		panel.add(btnResservar);
		
		JLabel lblLeitor = new JLabel("Leitor");
		lblLeitor.setBounds(10, 32, 46, 14);
		panel.add(lblLeitor);
		
		JLabel lblLivro = new JLabel("Livro");
		lblLivro.setBounds(211, 32, 46, 14);
		panel.add(lblLivro);
		
	
		
		JLabel lblDataDeEmprstimo = new JLabel("Data de Empr\u00E9stimo");
		lblDataDeEmprstimo.setBounds(408, 32, 127, 14);
		panel.add(lblDataDeEmprstimo);
		
		txtDataE = new JTextField();
		txtDataE.setBounds(418, 57, 141, 20);
		panel.add(txtDataE);
		txtDataE.setColumns(10);
		
		JLabel lblDataDeDevoluo = new JLabel("Data de Devolu\u00E7\u00E3o");
		lblDataDeDevoluo.setBounds(592, 32, 134, 14);
		panel.add(lblDataDeDevoluo);
		
		txtDataD = new JTextField();
		txtDataD.setBounds(602, 57, 138, 20);
		panel.add(txtDataD);
		txtDataD.setColumns(10);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservasBean r = new ReservasBean();
				ReservasDAO dao = new ReservasDAO();
				r.setIdemprestimoLivro((int)JTReserva.getValueAt(JTReserva.getSelectedRow(),0) );

			
				dao.delete(r);
				readJTable();
				
				
			}
		});
		btnDevolver.setBounds(408, 148, 89, 23);
		panel.add(btnDevolver);
		
		JTReserva = new JTable();
		JTReserva.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String leitor = (String) JTReserva.getValueAt(JTReserva.getSelectedRow(),1).toString();
				String livro = (String) JTReserva.getValueAt(JTReserva.getSelectedRow(),2).toString();
				txtDataD.setText(JTReserva.getValueAt(JTReserva.getSelectedRow(),4).toString());
				txtDataE.setText(JTReserva.getValueAt(JTReserva.getSelectedRow(),3).toString());
				
				cbLeitor.setModel(new DefaultComboBoxModel(new String[] {JTReserva.getValueAt(JTReserva.getSelectedRow(),0).toString()}));;
				cbLivro.setModel(new DefaultComboBoxModel(new String[] {JTReserva.getValueAt(JTReserva.getSelectedRow(),1).toString()}));;
				
			}
		});
		JTReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JTReserva.getSelectedRow() != -1) {
					String leitor = (String) JTReserva.getValueAt(JTReserva.getSelectedRow(),1).toString();
					String livro = (String) JTReserva.getValueAt(JTReserva.getSelectedRow(),2).toString();
					txtDataD.setText(JTReserva.getValueAt(JTReserva.getSelectedRow(),4).toString());
					txtDataE.setText(JTReserva.getValueAt(JTReserva.getSelectedRow(),3).toString());
					
					cbLeitor.setModel(new DefaultComboBoxModel(new String[] {JTReserva.getValueAt(JTReserva.getSelectedRow(),0).toString()}));;
					cbLivro.setModel(new DefaultComboBoxModel(new String[] {JTReserva.getValueAt(JTReserva.getSelectedRow(),1).toString()}));;
					
					
//					if(tSexo == "M") {
//						txtSexo.setModel(new DefaultComboBoxModel(new String[] {tSexo,"M"}));;
//					}else {
//						txtSexo.setModel(new DefaultComboBoxModel(new String[] {tSexo,"F"}));;
//					}
					//(JTLeitor.getValueAt(JTLeitor.getSelectedRow(),4).toString());
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
			}
		});
		JTReserva.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id do Empr\u00E9stimo", "Leitor", "Livro", "Data do Empr\u00E9stimo", "Data de Devolu\u00E7\u00E3o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		JTReserva.getColumnModel().getColumn(1).setPreferredWidth(134);
		JTReserva.getColumnModel().getColumn(2).setPreferredWidth(164);
		JTReserva.getColumnModel().getColumn(3).setPreferredWidth(121);
		JTReserva.getColumnModel().getColumn(4).setPreferredWidth(163);
		scrollPane.setViewportView(JTReserva);
		
		readJTable();
		
//		LeitorDAO dao = new LeitorDAO();
//		for(Leitor l: dao.read()) {
//			cbLeitor.addItem(l);
//		}
//		
//		LivroDAO livro = new LivroDAO();
//		for(Livro li: livro.read()) {
//			cbLivro.addItem(li);
//		}

	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) JTReserva.getModel();
		modelo.setNumRows(0);
		ReservasDAO rdao = new ReservasDAO();
		
		for(ReservasBean r: rdao.read()) {
			modelo.addRow(new Object[] {
				r.getIdemprestimoLivro(),
				r.getNomeLeitor(),
				r.getNomeLivro(),
				r.getDataEmprestimo(),
				r.getDataDevolucao()
				
			});
		}
	}
}
