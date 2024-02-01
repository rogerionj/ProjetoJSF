package br.com.atos.projetojsf.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.atos.projetojsf.core.dao.conexao.ConexaoJDBC;
import br.com.atos.projetojsf.core.entity.UsuarioEntity;

public class UsuarioDAO {

	
	public void cadastrarUsuario(UsuarioEntity usuario) {
		
		String sql = "INSERT INTO USUARIO (NOME, LOGIN, SENHA, EMAIL) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = ConexaoJDBC.getConexao().prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getEmail());
			
			ps.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public List<UsuarioEntity> listarTodos(){
		
		String sql = "SELECT IDUSUARIO, NOME, LOGIN, SENHA, EMAIL FROM USUARIO";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = ConexaoJDBC.getConexao().prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			List<UsuarioEntity> usuarios = new ArrayList<UsuarioEntity>();
						
			while(rs.next()) {
				UsuarioEntity u = new UsuarioEntity();
				u.setId(rs.getLong("IDUSUARIO"));
				u.setNome(rs.getString("NOME"));
				u.setLogin(rs.getString("LOGIN"));
				u.setSenha(rs.getString("SENHA"));
				u.setEmail(rs.getString("EMAIL"));
				
				usuarios.add(u);
			}
			
			return usuarios;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public void excluir(Long id) {
		
		String sql = "DELETE FROM USUARIO WHERE IDUSUARIO = ?";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = ConexaoJDBC.getConexao().prepareStatement(sql);
			
			ps.setLong(1, id);
			
			ps.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void alterar(UsuarioEntity usuario) {
		
		String sql = "UPDATE USUARIO SET NOME = ?, LOGIN = ?, SENHA = ?, EMAIL = ? WHERE IDUSUARIO = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = ConexaoJDBC.getConexao().prepareStatement(sql);
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getEmail());
			ps.setLong(5, usuario.getId());
				
			ps.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
