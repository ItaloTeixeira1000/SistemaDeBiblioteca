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
import model.bean.Livro;

public class LivroDAO {
	
	public void create(Livro l) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("INSERT INTO livro(titulo, autor,isbn, genero, descricao, idioma, editora, dataDePublicacao,area) VALUES (?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, l.getTitulo());
			stmt.setString(2, l.getAutor());
			stmt.setInt(3, l.getIsbn());
			stmt.setString(4, l.getGenero());
			stmt.setString(5, l.getDescricao());
			stmt.setString(6, l.getIdioma());
			stmt.setString(7, l.getEditora());
			stmt.setString(8, l.getDataDePublicacao());
			stmt.setString(9, l.getArea());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Livro> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		List<Livro> livros = new ArrayList<Livro>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM livro");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Livro livro = new Livro();
				livro.setIdLivro(rs.getInt("idLivro"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setIsbn(rs.getInt("isbn"));
				livro.setGenero(rs.getString("genero"));
				livro.setDescricao(rs.getString("descricao"));
				livro.setIdioma(rs.getString("idioma"));
				livro.setEditora(rs.getString("editora"));
				livro.setDataDePublicacao(rs.getString("dataDePublicacao"));
				livro.setArea(rs.getString("area"));
				
				livros.add(livro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao ler " + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return livros;
		
		
	}
	
	public List<Livro> readForTitulo(String titulo){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		List<Livro> livros = new ArrayList<Livro>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM livro WHERE titulo LIKE ?");
			stmt.setString(1, "%"+titulo+"%");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Livro livro = new Livro();
				livro.setIdLivro(rs.getInt("idLivro"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setIsbn(rs.getInt("isbn"));
				livro.setGenero(rs.getString("genero"));
				livro.setDescricao(rs.getString("descricao"));
				livro.setIdioma(rs.getString("idioma"));
				livro.setEditora(rs.getString("editora"));
				livro.setDataDePublicacao(rs.getString("dataDePublicacao"));
				livro.setArea(rs.getString("area"));
				
				livros.add(livro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao ler " + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return livros;
		
		
	}
	
		public void update(Livro l) {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement("UPDATE livro SET titulo=?, autor=?,isbn=?, genero=?, descricao=?, idioma=?, editora=?, dataDePublicacao=?,area=? WHERE idLivro=?");
				stmt.setString(1, l.getTitulo());
				stmt.setString(2, l.getAutor());
				stmt.setInt(3, l.getIsbn());
				stmt.setString(4, l.getGenero());
				stmt.setString(5, l.getDescricao());
				stmt.setString(6, l.getIdioma());
				stmt.setString(7, l.getEditora());
				stmt.setString(8, l.getDataDePublicacao());
				stmt.setString(9, l.getArea());
				stmt.setInt(10, l.getIdLivro());
				
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + e);
			}finally {
				ConnectionFactory.closeConnection(con, stmt);
			}
	}
		public void delete(Livro l) {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement("DELETE FROM livro WHERE idLivro=?");
				
				stmt.setInt(1, l.getIdLivro());
				
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Deletado com sucesso");
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro ao deletar : " + e);
			}finally {
				ConnectionFactory.closeConnection(con, stmt);
			}
	}

}
