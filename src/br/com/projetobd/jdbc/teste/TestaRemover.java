package br.com.projetobd.jdbc.teste;

import java.util.List;

import br.com.projetobd.DAO.CidadeDAO;
import br.com.projetobd.model.Cidade;


public class TestaRemover {
public static void main(String[] args) {
		
		Cidade cidade1 = new Cidade();
		
		cidade1.setId((long) 2);
		
		CidadeDAO dao = new CidadeDAO();
		
		cidade1.getId();
		
		dao.remove(cidade1);
		
		List<Cidade> cidades = dao.getLista();
		
		for (Cidade cidade : cidades) {
			System.out.println("->Nome: " + cidade.getNomeCidade());
			System.out.println("->Sigla do Estado: " + cidade.getSiglaEstado());
		}
	}
}
