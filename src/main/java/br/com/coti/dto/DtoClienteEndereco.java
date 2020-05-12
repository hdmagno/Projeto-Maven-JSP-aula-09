package br.com.coti.dto;

import br.com.coti.entity.Cliente;
import br.com.coti.entity.Endereco;

public class DtoClienteEndereco {
	
	private Cliente cliente;
	private Endereco endereco;
	
	public DtoClienteEndereco() {
	}

	public DtoClienteEndereco(Cliente cliente, Endereco endereco) {
		this.cliente = cliente;
		this.endereco = endereco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Dto: " + cliente;
	}

}
