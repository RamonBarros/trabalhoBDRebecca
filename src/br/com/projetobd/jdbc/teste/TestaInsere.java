package br.com.projetobd.jdbc.teste;

import java.sql.SQLException;

import br.com.projetobd.DAO.CidadeDAO;
import br.com.projetobd.model.Cidade;

public class TestaInsere {
public static void main(String[] args) throws SQLException {
		
		Cidade cidade1 = new Cidade();
		
		cidade1.setNomeCidade("São Paulo");
		cidade1.setSiglaEstado("SP");
		
		Cidade cidade2 = new Cidade();
		
		cidade2.setNomeCidade("Rio de Janeiro");
		cidade2.setSiglaEstado("RJ");
		
		CidadeDAO dao = new CidadeDAO();
		
		dao.adiciona(cidade1);
		dao.adiciona(cidade2);
		
		System.out.println("Gravado!");
		
	}
}
