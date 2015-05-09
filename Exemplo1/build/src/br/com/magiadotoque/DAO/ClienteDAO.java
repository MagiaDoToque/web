package br.com.magiadotoque.DAO;

import br.com.magiadotoque.model.Cliente;

public class ClienteDAO {

	Cliente clienteBean;
	
	public void salvar(Cliente cliente){
		
		
		
		
		
	}
	
	
	public Cliente buscarLogin(String email, String senha){
		String nome = "Kelly Martinez";
		String emailc = "Kelly";
		String senhac = "210586";
		clienteBean = new Cliente(nome,emailc,senhac);
		
		return clienteBean;
	}

}
