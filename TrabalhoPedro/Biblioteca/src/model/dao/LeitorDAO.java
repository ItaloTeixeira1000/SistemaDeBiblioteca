package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Funcionario;
import model.bean.Leitor;

public class LeitorDAO {
	public void create(Leitor l) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO leitor(nome, sobrenome, cpf, sexo, data_nascimento, email) VALUES(?,?,?,?,?,?)");
			stmt.setString(1, l.getNome() );
			stmt.setString(2, l.getSobrenome() );
			stmt.setString(3, l.getCpf() );
			stmt.setString(4, l.getSexo() );
			stmt.setString(5, l.getDataNascimento());
			stmt.setString(6, l.getEmail());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar " + e);
			
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Leitor> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		List<Leitor> leitores = new ArrayList<Leitor>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM leitor");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Leitor leitor = new Leitor();
				leitor.setIdLeitor(rs.getInt("idLeitor"));
				leitor.setNome(rs.getString("nome"));
				leitor.setSobrenome(rs.getString("sobrenome"));
				leitor.setCpf(rs.getString("cpf"));
				leitor.setSexo(rs.getString("sexo"));
				leitor.setDataNascimento(rs.getString("data_nascimento"));
				leitor.setEmail(rs.getString("email"));
				
				leitores.add(leitor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao ler " + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return leitores;
		
		
	}
	
	public List<Leitor> readForName(String nome){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		List<Leitor> leitores = new ArrayList<Leitor>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM leitor WHERE nome LIKE ?");
			stmt.setString(1, "%"+nome+"%");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Leitor leitor = new Leitor();
				leitor.setIdLeitor(rs.getInt("idLeitor"));
				leitor.setNome(rs.getString("nome"));
				leitor.setSobrenome(rs.getString("sobrenome"));
				leitor.setCpf(rs.getString("cpf"));
				leitor.setSexo(rs.getString("sexo"));
				leitor.setDataNascimento(rs.getString("data_nascimento"));
				leitor.setEmail(rs.getString("email"));
				
				leitores.add(leitor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao ler " + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return leitores;
		
		
	}
	
	public void update(Leitor l) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE leitor SET nome=?, sobrenome=?, cpf=?, sexo=?, data_nascimento=?, email=? WHERE idLeitor=?");
			stmt.setString(1, l.getNome() );
			stmt.setString(2, l.getSobrenome() );
			stmt.setString(3, l.getCpf() );
			stmt.setString(4, l.getSexo() );
			stmt.setString(5, l.getDataNascimento());
			stmt.setString(6, l.getEmail());
			stmt.setInt(7, l.getIdLeitor());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao atualizar " + e);
			
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void delete(Leitor l) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM leitor WHERE idLeitor=?");

			stmt.setInt(1, l.getIdLeitor());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Deletado com sucesso");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao deletar " + e);
			
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}


}
