package trabalho_java;

import javax.swing.JOptionPane;

public class itemC {
	public static void main(String args[]) {
	
		double F;
		double C;
		
		F = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do grau Fahrenhait: "));
		C = ((F - 32) * 5)/9;
		
		JOptionPane.showMessageDialog(null,"A temperatura em grau Celsius: "+C);	
				
	}

}
