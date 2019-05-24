package trabalho_java;

import javax.swing.JOptionPane;

public class itemD {
	public static void main(String args[]) {
		
		float C;
		float K;
		
		C = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do grau Celsius: "));
		K = C + 273.15f;
		
		JOptionPane.showMessageDialog(null,"A temperatura em Kelvin é: "+K);
	}
}
