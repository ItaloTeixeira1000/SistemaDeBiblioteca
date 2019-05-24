package trabalho_java;

import javax.swing.JOptionPane;

public class itemE {
	public static void main(String args[]) {
		
		double C;
		double K;
		
		K = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do grau Kelvin: "));
		C = K - 273.15;
		
		JOptionPane.showMessageDialog(null,"A temperatura em graus Celsius é: "+C);
	}

}
