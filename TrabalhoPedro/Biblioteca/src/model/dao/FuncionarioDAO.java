package model.dao;

import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import model.bean.Fornecedor;
import model.bean.Funcionario;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;


public class FuncionarioDAO {
	
	public void create(Funcionario f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		
		try {
			stmt = con.prepareStatement("INSERT INTO funcionario(nome,sobrenome,sexo,data_nascimento,cpf,telefone,acesso,usuario,senha) VALUES (?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getSobrenome());
			stmt.setString(3, f.getSexo());
			stmt.setString(4, f.getDataDeNascimento());
			stmt.setString(5, f.getCpf());
			stmt.setString(6, f.getTelefone());
			stmt.setString(7, f.getAcesso());
			stmt.setString(8, f.getUsuario());
			stmt.setString(9, f.getSenha());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, " Erro no cadastro! " + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public boolean checkLogin(String usuario, String senha){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario WHERE usuario = ? AND senha = ?");
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                check = true;
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível consultar dados: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return check;
    }
	
	public List<Funcionario> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM funcionario");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setSobrenome(rs.getString("sobrenome"));
				funcionario.setSexo(rs.getString("sexo"));
				funcionario.setDataDeNascimento(rs.getString("data_nascimento"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setAcesso(rs.getString("acesso"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
				
				funcionarios.add(funcionario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao ler " + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return funcionarios;
		
		
	}
	
	public List<Funcionario> readForName(String nome){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM funcionario WHERE nome LIKE ?");
			stmt.setString(1, "%"+nome+"%");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setSobrenome(rs.getString("sobrenome"));
				funcionario.setSexo(rs.getString("sexo"));
				funcionario.setDataDeNascimento(rs.getString("data_nascimento"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setAcesso(rs.getString("acesso"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));
				
				funcionarios.add(funcionario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao ler " + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return funcionarios;
		
		
	}
	
	public void update(Funcionario f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		
		try {
			stmt = con.prepareStatement("UPDATE funcionario SET nome=?,sobrenome=?,sexo=?,data_nascimento=?,cpf=?,telefone=?,acesso=?,usuario=?,senha=? WHERE idFuncionario=?");
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getSobrenome());
			stmt.setString(3, f.getSexo());
			stmt.setString(4, f.getDataDeNascimento());
			stmt.setString(5, f.getCpf());
			stmt.setString(6, f.getTelefone());
			stmt.setString(7, f.getAcesso());
			stmt.setString(8, f.getUsuario());
			stmt.setString(9, f.getSenha());
			stmt.setInt(10, f.getIdFuncionario());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, " Erro na atualização! " + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void delete(Funcionario f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		
		try {
			stmt = con.prepareStatement("DELETE FROM funcionario WHERE idFuncionario=?");
		
			stmt.setInt(1, f.getIdFuncionario());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, " Erro na deleção! " + e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}
