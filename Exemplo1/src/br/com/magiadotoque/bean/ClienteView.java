package br.com.magiadotoque.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import br.com.magiadotoque.controller.ClienteController;
import br.com.magiadotoque.model.Cliente;

@ManagedBean(name = "clienteView")
@ViewScoped
public class ClienteView implements Serializable {

	private Cliente cliente;
	private String email;
	private String senha;

	private List<Cliente> clientes;
	ClienteController clienteController = new ClienteController();

	public void login(ActionEvent event) {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;

		boolean loggedIn = false;
		cliente = clienteController.validarLogin(getEmail(), getSenha());

		if (cliente.getEmail().equals(getEmail())
				&& cliente.getSenha().equals(getSenha())) {
			loggedIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Seja Bem Vindo", cliente.getNome());
		} else {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Login com Erro", "Usuário não encontrado");
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("loggedIn", loggedIn);

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("principal.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		cliente = new Cliente();
		setClientes(new ArrayList<Cliente>());
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String salvarCliente() {
		if (!clientes.contains(cliente)) {
			clientes.add(cliente);
		}

		return "pm:list?transition=flip";
	}

	public void deleteContact() {
		if (clientes.contains(cliente)) {
			clientes.remove(cliente);
		}
	}

	public String cadastrarNovoContato() {
		cliente = new Cliente();

		return "pm:edit?transition=flip";
	}

	/**
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes
	 *            the clientes to set
	 */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
