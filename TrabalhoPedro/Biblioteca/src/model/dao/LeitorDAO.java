package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Leitor;

public class LeitorDAO {
	public boolean create(Leitor l) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO leitor(nome, sobrenome, cpf, sexo, dataNascimento, email) VALUES(?,?,?,?,?,?)");
			stmt.setString(1, l.getNome() );
			stmt.setString(2, l.getSobrenome() );
			stmt.setString(3, l.getCpf() );
			stmt.setString(4, l.getSexo() );
			stmt.setString(5, l.getDataNascimento());
			stmt.setString(6, l.getEmail());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar " + e);
			return false;
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
