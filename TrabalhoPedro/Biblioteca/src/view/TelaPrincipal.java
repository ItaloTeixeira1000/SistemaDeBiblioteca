package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(153, 180, 209));
		desktopPane.setBounds(0, 22, 1400, 1000);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/fundoProjeto.jpg")));
		label.setBounds(86, 11, 260, 225);
		desktopPane.add(label);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		mnNewMenu.setBackground(SystemColor.activeCaption);
		mnNewMenu.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		mnNewMenu.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/page.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		mntmSair.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/door_out.png")));
		mnNewMenu.add(mntmSair);
		
		JMenu mnNewMenu_1 = new JMenu("Cadastro");
		mnNewMenu_1.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		mnNewMenu_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/group_add.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmUsurios = new JMenuItem("Leitores");
		mntmUsurios.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		mntmUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroLeitor cl = new CadastroLeitor();
				desktopPane.add(cl);
				cl.setVisible(true);
			}
		});
		mntmUsurios.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/user_add.png")));
		mnNewMenu_1.add(mntmUsurios);
		
	
		
		JMenuItem mntmFornecedor = new JMenuItem("Fornecedores");
		mntmFornecedor.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		mntmFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroFornecedor cf = new CadastroFornecedor();
				desktopPane.add(cf);
				cf.setVisible(true);
				
			}
		});
		mntmFornecedor.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/lorry.png")));
		mnNewMenu_1.add(mntmFornecedor);
		
		JMenu mnReservas = new JMenu("Reservas");
		mnReservas.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		mnReservas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/package.png")));
		menuBar.add(mnReservas);
		
		JMenu mnConsultas = new JMenu("Consultas");
		mnConsultas.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		mnConsultas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/zoom.png")));
		menuBar.add(mnConsultas);
		
		JMenuItem mntmUsurios_1 = new JMenuItem("Funcion\u00E1rios");
		mntmUsurios_1.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		mntmUsurios_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaFuncionario cf = new ConsultaFuncionario();
				desktopPane.add(cf);
				cf.setVisible(true);
			}
		});
		mntmUsurios_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/user_suit.png")));
		mnConsultas.add(mntmUsurios_1);
		
		JMenuItem mntmLivros_1 = new JMenuItem("Livros");
		mntmLivros_1.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		mntmLivros_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ConsultaLivro cl = new ConsultaLivro();
				 desktopPane.add(cl);
				 cl.setVisible(true);
			}
		});
		mntmLivros_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/book_go.png")));
		mnConsultas.add(mntmLivros_1);
		
		JMenuItem mntmFornecedores = new JMenuItem("Fornecedores");
		mntmFornecedores.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		mntmFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaFornecedor cf = new ConsultaFornecedor();
				desktopPane.add(cf);
				cf.setVisible(true);
				
			}
		});
		mntmFornecedores.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/lorry_go.png")));
		mnConsultas.add(mntmFornecedores);
		
		JMenuItem mntmLeitores = new JMenuItem("Leitores");
		mntmLeitores.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		mntmLeitores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaLeitor cl = new ConsultaLeitor();
				desktopPane.add(cl);
				cl.setVisible(true);
			}
		});
		mnConsultas.add(mntmLeitores);
		
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		mnSobre.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/information.png")));
		menuBar.add(mnSobre);
		
		
		
		JMenuItem mntmLivros = new JMenuItem("Livros");
		mntmLivros.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		mntmLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroLivro cl = new CadastroLivro();
				desktopPane.add(cl);
				cl.setVisible(true);
				
				
			}
		});
		mntmLivros.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/book.png")));
		mnNewMenu_1.add(mntmLivros);
	}
}
