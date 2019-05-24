package controle;

public class exec {
	public static void main(String [] args) {
		 ConexaoMySQL.getConexaoMySQL();
	   System.out.println(ConexaoMySQL.statusConection());
	 
	 
	}
}
