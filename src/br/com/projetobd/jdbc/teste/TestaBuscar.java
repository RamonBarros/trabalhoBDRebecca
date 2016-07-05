package br.com.projetobd.jdbc.teste;

import java.util.List;

import br.com.projetobd.DAO.CidadeDAO;
import br.com.projetobd.model.Cidade;

public class TestaBuscar {
	public static void main(String[] args) {
		
		Cidade c  = new Cidade();
		
		c.setNomeCidade("Rio de Janeiro");
		
		CidadeDAO dao = new CidadeDAO();
		
		List<Cidade> cidades = dao.getBuscar(c);
		
		for (Cidade cidade : cidades) {
			System.out.println("->Nome: " + cidade.getNomeCidade());
			System.out.println("->Sigla do Estado: " + cidade.getSiglaEstado());
		}
	}
}
