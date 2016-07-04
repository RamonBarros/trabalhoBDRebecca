package br.com.projetobd.jdbc.teste;

import java.sql.SQLException;
import java.util.List;

import br.com.projetobd.DAO.CidadeDAO;
import br.com.projetobd.model.Cidade;


public class TestaAltera {
public static void main(String[] args) throws SQLException {
		
		Cidade cidade1 = new Cidade();
		
		cidade1.setId((long) 1);
		cidade1.setNomeCidade("Pirituba");
		cidade1.setSiglaEstado("SP");
		
		//System.out.println("Nm:" + cidade1.getNomeCidade());
		
		CidadeDAO dao = new CidadeDAO();

		dao.altera(cidade1);
		
		List<Cidade> cidades = dao.getLista();
		
		for (Cidade cidade : cidades) {
			System.out.println("->Nome: " + cidade.getNomeCidade());
			System.out.println("->Sigla do Estado: " + cidade.getSiglaEstado());
		}
	}
}
