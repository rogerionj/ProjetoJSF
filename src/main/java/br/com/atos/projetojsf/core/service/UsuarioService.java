package br.com.atos.projetojsf.core.service;

import java.util.List;

import br.com.atos.projetojsf.core.dao.UsuarioDAO;
import br.com.atos.projetojsf.core.entity.UsuarioEntity;

public class UsuarioService {

	public void cadastrarUsuario(UsuarioEntity usuario) {
		new UsuarioDAO().cadastrarUsuario(usuario);
	}
	
	public List<UsuarioEntity> listarTodos(){
		return new UsuarioDAO().listarTodos();
	}
	
	public void excluir(Long id) {
		new UsuarioDAO().excluir(id);
	}
	
	public void alterar(UsuarioEntity usuario) {
		new UsuarioDAO().alterar(usuario);
	}
}
