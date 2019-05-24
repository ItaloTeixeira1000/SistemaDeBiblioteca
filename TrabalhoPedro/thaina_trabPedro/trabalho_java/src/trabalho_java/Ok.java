package trabalho_java;
import javax.swing.JOptionPane;

public class Ok {
	public static void main(String [] args) { 
		int i = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
		
			if(i == 1) {
				 JOptionPane.showMessageDialog(null, "Você clicou em Ok?");
		}
	
	}
	

}
