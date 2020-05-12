package br.com.coti.manager;

import java.util.List;

import br.com.coti.dto.DtoClienteEndereco;
import br.com.coti.persistence.ClienteDao;

public class ManagerBean {
	
	private List<DtoClienteEndereco> dto;

	public List<DtoClienteEndereco> getDto() {
		try {
			dto = new ClienteDao().buscarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public void setDto(List<DtoClienteEndereco> dto) {
		this.dto = dto;
	}
	
	

}
