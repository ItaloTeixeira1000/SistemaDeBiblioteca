package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
	
	private static String caminho = "jdbc:mysql://localhost/dbbiblioteca";
	private static String usuario = "root";
	private static String senha = "master450";
	
	public static Connection criarConexao() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager .getConnection(caminho, usuario, senha);
		}catch(ClassNotFoundException e){
			throw new SQLException(e.getException());
			
		}
	}

}
