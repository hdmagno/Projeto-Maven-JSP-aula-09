package br.com.coti.entity;

import java.io.Serializable;

public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idEndereco;
	private String bairro;
	private String cidade;
	
	private Cliente cliente;
	
	public Endereco() {
	}

	public Endereco(Integer idEndereco, String bairro, String cidade) {
		this.idEndereco = idEndereco;
		this.bairro = bairro;
		this.cidade = cidade;
	}
	
	public Endereco(Integer idEndereco, String bairro, String cidade, Cliente cliente) {
		this.idEndereco = idEndereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cliente = cliente;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}
	
	public void setId(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "[idEndereco: " + idEndereco + ", Bairro: " + bairro + ", Cidade: " + cidade + "]";
	}
	
}
