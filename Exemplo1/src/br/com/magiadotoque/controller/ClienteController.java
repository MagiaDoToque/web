package br.com.magiadotoque.controller;

import br.com.magiadotoque.DAO.ClienteDAO;
import br.com.magiadotoque.model.Cliente;

public class ClienteController {
	ClienteDAO clienteDao = new ClienteDAO();
	Cliente clienteBean;

	public void salvar(Cliente cliente){
		clienteDao.salvar(cliente);
		
	}

	public Cliente validarLogin(String email, String senha) {

	return clienteBean = clienteDao.buscarLogin(email, senha);

	}
}
