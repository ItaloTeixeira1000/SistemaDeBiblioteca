package model.dao;

import java.sql.Connection;
import view.ConsultaFornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Fornecedor;
import model.bean.Funcionario;

public class FornecedorDAO {
	
	public boolean create(Fornecedor f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		boolean r = false;
		try {
			stmt = con.prepareStatement("INSERT INTO fornecedor(nome, tipo_instituicao, endereco, telefone, email, url) VALUES(?,?,?,?,?,?)");
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getTipoDeInstituicao());
			stmt.setString(3, f.getEndereco());
			stmt.setString(4, f.getTelefone());
			stmt.setString(5, f.getEmail());
			stmt.setString(6, f.getUrl());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
			r = true;
			return r;
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao salvar " + e);
			r = false;
			return r;
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	
		
		
	}
	
	public List<Fornecedor> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM fornecedor");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Fornecedor fornecedor = new Fornecedor();
				
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setTipoDeInstituicao(rs.getString("tipo_instituicao"));
				fornecedor.setEndereco(rs.getString("endereco"));
				fornecedor.setTelefone(rs.getString("telefone"));
				fornecedor.setEmail(rs.getString("email"));
				fornecedor.setUrl(rs.getString("url"));
				fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
				
				fornecedores.add(fornecedor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao mostrar dados: " + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return fornecedores;
		
		
	}
	
	public List<Fornecedor> readForNome(String nome){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM fornecedor WHERE nome LIKE ?");
			stmt.setString(1, "%"+nome+"%");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Fornecedor fornecedor = new Fornecedor();
				
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setTipoDeInstituicao(rs.getString("tipo_instituicao"));
				fornecedor.setEndereco(rs.getString("endereco"));
				fornecedor.setTelefone(rs.getString("telefone"));
				fornecedor.setEmail(rs.getString("email"));
				fornecedor.setUrl(rs.getString("url"));
				fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
				
				fornecedores.add(fornecedor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao mostrar dados: " + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return fornecedores;
		
		
	}
	
	public boolean update(Fornecedor f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		boolean r = false;
		try {
			stmt = con.prepareStatement("UPDATE fornecedor SET nome=?, tipo_instituicao=?, endereco=?, telefone=?, email=?, url=? WHERE idFornecedor=?");
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getTipoDeInstituicao());
			stmt.setString(3, f.getEndereco());
			stmt.setString(4, f.getTelefone());
			stmt.setString(5, f.getEmail());
			stmt.setString(6, f.getUrl());
			stmt.setInt(7, f.getIdFornecedor());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
			r = true;
			return r;
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao atualizar " + e);
			r = false;
			return r;
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	
		
		
	}
	
	public boolean delete(Fornecedor f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		boolean r = false;
		try {
			stmt = con.prepareStatement("DELETE FROM fornecedor WHERE idFornecedor=?");
		
			stmt.setInt(1, f.getIdFornecedor());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Deletado com sucesso");
			r = true;
			return r;
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao deletar " + e);
			r = false;
			return r;
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	
		
		
	}
	
}
