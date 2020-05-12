package br.com.coti.persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import br.com.coti.dto.DtoClienteEndereco;
import br.com.coti.entity.Cliente;
import br.com.coti.entity.Endereco;

public class ClienteDao extends Dao {

	public void inserir(Cliente c, Endereco e) throws Exception {
		conectar();
		con.setAutoCommit(false);
		try {
			String sqlCliente = "insert into cliente values(null,?,?)";
			stmt = con.prepareStatement(sqlCliente, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEmail());
			stmt.execute();
			rs = stmt.getGeneratedKeys();
			rs.next();
			int chave = rs.getInt(1);
			String sqlEndereco = "insert into endereco values(null,?,?,?)";
			stmt = con.prepareStatement(sqlEndereco);
			stmt.setString(1, e.getBairro());
			stmt.setString(2, e.getCidade());
			stmt.setInt(3, chave);
			stmt.execute();
			con.commit();
		} catch (Exception ex) {
			con.rollback();
			ex.printStackTrace();
		} finally {
			con.setAutoCommit(true);
		}
	}

	public List<DtoClienteEndereco> buscarTodos() throws Exception {
		conectar();
		String sql = "select * from v$ClienteEndereco";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		List<DtoClienteEndereco> lista = new ArrayList<>();
		while (rs.next()) {
			Cliente c = new Cliente();
			c.setId(rs.getInt("id"));
			c.setNome(rs.getString("nome"));
			c.setEmail(rs.getString("email"));
			Endereco e = new Endereco();
			e.setId(rs.getInt("idEndereco"));
			e.setBairro(rs.getString("bairro"));
			e.setCidade(rs.getString("cidade"));
			e.setCliente(c);
			c.setEndereco(e);
			DtoClienteEndereco dto = new DtoClienteEndereco(c, e);
			lista.add(dto);
		}
		desconectar();
		return lista;
	}
	
	public DtoClienteEndereco buscarPorId(int id) throws Exception {
		conectar();
		String sql = "select * from v$ClienteEndereco where id = ?";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		Cliente cliente = null;
		Endereco endereco = null;
		DtoClienteEndereco dto = null;
		while(rs.next()) {
			cliente = new Cliente();
			cliente.setId(rs.getInt("id"));
			cliente.setNome(rs.getString("nome"));
			cliente.setEmail(rs.getString("email"));
			endereco = new Endereco();
			endereco.setId(rs.getInt("idEndereco"));
			endereco.setBairro(rs.getString("bairro"));
			endereco.setCidade(rs.getString("cidade"));
			endereco.setCliente(cliente);
			cliente.setEndereco(endereco);
			dto = new DtoClienteEndereco(cliente, endereco);
		}
		return dto;
	}
	
	public void alterarCliente(Cliente c, int id) throws Exception {
		conectar();
		String sql = "update cliente set nome = ?, email = ? where id = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getEmail());
		stmt.setInt(3, id);
		stmt.execute();		
	}
	
	public void alterarEndereco(Endereco e, Cliente c) throws Exception {
		conectar();
		String sql = "update endereco set bairro = ?, cidade = ? where id_cliente = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, e.getBairro());
		stmt.setString(2, e.getCidade());
		stmt.setInt(3, c.getId());
		stmt.execute();
	}
	
	public void excluir(int id) throws Exception {
		conectar();
		String sql = "delete from cliente where id = ?";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
	}

	public static void main(String[] args) throws Exception {

//		ClienteDao dao = new ClienteDao();
//		Cliente c = new Cliente(22, "Aline", "aline@gmail.com");
//		Endereco e = new Endereco(null, "Santa Tereza", "Rio de Janeiro", c);
//		Endereco e2 = new Endereco(null, "Botafogo", "Rio de Janeniro");
//		c.setEndereco(e);
//		dao.inserir(c, e);
		
//		dao.excluir(21);
//		System.out.println(dao.buscarPorId(22));
//		dao.alterarCliente(c, 22);
//		dao.alterarEndereco(e2, c);
//		System.out.println(dao.buscarTodos());

	}

}
