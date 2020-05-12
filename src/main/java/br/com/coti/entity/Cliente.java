package br.com.coti.entity;

import java.io.Serializable;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String email;
	
	private Endereco endereco;

	public Cliente() {
	}

	public Cliente(Integer id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public Cliente(Integer id, String nome, String email, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [id: " + id + ", Nome: " + nome + ", Email: " + email + ", Endereco: " + endereco + "]";
	}

}
