package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import connection.ConnectionFactory;
import model.bean.ReservasBean;

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
import java.awt.Color;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(0, 30, 1600, 900);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		mnNewMenu.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/page.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		mntmSair.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/door_out.png")));
		mnNewMenu.add(mntmSair);
		
		JMenu mnReservas = new JMenu("Reservas");
		mnReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnReservas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/package.png")));
		menuBar.add(mnReservas);
		
		JMenuItem mntmLivros = new JMenuItem("Livros");
		mntmLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservas r = new Reservas();
				desktopPane.add(r);
				r.setVisible(true);
			}
		});
		mnReservas.add(mntmLivros);
		
		JMenu mnConsultas = new JMenu("Consultas");
		mnConsultas.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/zoom.png")));
		menuBar.add(mnConsultas);
		
		JMenuItem mntmUsurios_1 = new JMenuItem("Funcion\u00E1rios");
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
		mntmLeitores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaLeitor clei = new ConsultaLeitor();
				desktopPane.add(clei);
				clei.setVisible(true);
			}
		});
		mnConsultas.add(mntmLeitores);
		
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/information.png")));
		menuBar.add(mnSobre);
	}
}
