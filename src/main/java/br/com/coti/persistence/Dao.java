package br.com.coti.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	static Connection con;
	static PreparedStatement stmt;
	static ResultSet rs;
	
	static String url = "jdbc:mysql://localhost:3306/bd_aula09?createDatabaseIfNotExist=true";
	static String usuario = "root";
	static String senha = "1234";
	
	public static void conectar() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, usuario, senha);
	}

	public static void desconectar() throws Exception {
		con.close();
	}
	
	public static void gerarTabelaCliente() throws Exception {
		conectar();
		String bd = "use bd_aula09";
		String sql = "create table cliente("
				+ "id int primary key auto_increment,"
				+ "nome varchar(50) not null,"
				+ "email varchar(50) not null unique"
				+ ")";
		stmt = con.prepareStatement(bd);
		stmt.execute();
		stmt = con.prepareStatement(sql);
		stmt.execute();
	}
	
	public static void gerarTabelaEndereco() throws Exception {
		conectar();
		String bd = "use bd_aula09";
		String sql = "create table endereco("
					+ "idEndereco int primary key auto_increment,"
					+ "bairro varchar(50) not null,"
					+ "cidade varchar(50) not null,"
					+ "id_cliente int, foreign key (id_cliente) references cliente(id) on delete cascade"
					+ ")";
		stmt = con.prepareStatement(bd);
		stmt.execute();
		stmt = con.prepareStatement(sql);
		stmt.execute();
		
		}
	public static void criarView() throws Exception {
		conectar();
		String sql = "create or replace view v$ClienteEndereco as select * from cliente c inner join endereco e on c.id = e.id_cliente";
		stmt = con.prepareStatement(sql);
		stmt.execute();
	}
	
	public static void main(String[] args) throws Exception {
		
//		conectar();
//		gerarTabelaCliente();
//		gerarTabelaEndereco();
//		criarView();
//		desconectar();
	}
}
