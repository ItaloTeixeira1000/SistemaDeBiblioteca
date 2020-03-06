package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Leitor;
import model.bean.Livro;
import model.bean.ReservasBean;



public class ReservasDAO {
	
	public void create(ReservasBean r) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO emprestimoLivro(nomeLivro,nomeLeitor,  dataEmprestimo, dataDevolucao) VALUES(?,?,?,?)");
			stmt.setString(1, r.getNomeLivro() );
			stmt.setObject(2, r.getNomeLeitor() );
			stmt.setString(3, r.getDataEmprestimo() );
			stmt.setString(4, r.getDataDevolucao() );
		
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Reservado com sucesso");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao reservar " + e);
			
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void delete(ReservasBean r) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM emprestimoLivro WHERE idemprestimoLivro=?");
			stmt.setInt(1, r.getIdemprestimoLivro() );
			
		
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Devolução realizada com sucesso");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro na devolução " + e);
			
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<ReservasBean> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		List<ReservasBean> reservas = new ArrayList<ReservasBean>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM emprestimoLivro");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				ReservasBean reserva = new ReservasBean();
				reserva.setIdemprestimoLivro(rs.getInt("idemprestimoLivro"));
				reserva.setNomeLeitor(rs.getString("nomeLeitor"));
				reserva.setNomeLivro(rs.getString("nomeLivro"));
				reserva.setDataEmprestimo(rs.getString("dataEmprestimo"));
				reserva.setDataDevolucao(rs.getString("dataDevolucao"));

				
				reservas.add(reserva);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao ler " + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return reservas;
		
		
	}
	
	public List<ReservasBean> confirma(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		List<ReservasBean> reservas = new ArrayList<ReservasBean>();
		
		try {
			stmt = con.prepareStatement("SELECT nomeLivro FROM emprestimoLivro");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				ReservasBean reserva = new ReservasBean();
		
				reserva.setNomeLivro(rs.getString("nomeLivro"));
			

				
				reservas.add(reserva);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao ler " + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return reservas;
		
		
	}
	
	
	public List<Leitor> popularLeitor(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		List<Leitor> leitores = new ArrayList<Leitor>();
		
		try {
			stmt = con.prepareStatement("SELECT nome FROM leitor");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Leitor leitor = new Leitor();
			
				leitor.setNome(rs.getString("nome"));
				
				
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
	
	public List<Livro> popularLivro(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		List<Livro> livros= new ArrayList<Livro>();
		
		try {
			stmt = con.prepareStatement("SELECT titulo FROM livro");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Livro livro = new Livro();
			
				livro.setTitulo(rs.getString("titulo"));
				
				
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

}
