package br.com.magiadotoque.boundary;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean (name = "clienteview")
public class ClienteBoundary {

	public void cadastrarCliente(){
		
		
		
	}
	public void buscar(){
		
		
		
	}
public void listar(){
	try {
		FacesContext.getCurrentInstance().getExternalContext().redirect("cliente.xhtml");
	} catch (IOException e) {
		e.printStackTrace();
	}
		
		
	}
}
