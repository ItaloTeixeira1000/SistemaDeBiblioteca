package trabalho_java;

import javax.swing.JOptionPane;

public class itemb {
	public static void main(String args[]) {
		
		int F;
		int C;
		
		C = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do grau Celsius:"));
		F = (9 * C + 160)/5;
		
		JOptionPane.showMessageDialog(null,"A temperatura em grau Fahrenheit: "+F);
		
		
	}
}