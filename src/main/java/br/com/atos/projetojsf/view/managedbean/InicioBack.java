package br.com.atos.projetojsf.view.managedbean;


import javax.faces.bean.ManagedBean;

@ManagedBean(name = "inicio")
public class InicioBack {

	private String mensagem;
	
	
	public InicioBack() {
		this.mensagem = "Olá Managed Bean";
	}
	
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
	
