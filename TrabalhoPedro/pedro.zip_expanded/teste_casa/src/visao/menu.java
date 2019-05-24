package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 93, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JButton btnNewButton = new JButton("cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar frame = new cadastrar();
				 
				frame.setVisible(true);
			}
		});
		mnNewMenu.add(btnNewButton);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(98, 0, 93, 21);
		contentPane.add(menuBar_1);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		mnNewMenu_1.setBounds(98, 2, 83, 19);
		contentPane.add(mnNewMenu_1);
	}
}
