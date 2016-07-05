package br.com.projetobd.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.projetobd.jdbc.ConnectionFactory;
import br.com.projetobd.model.Cidade;

public class CidadeDAO {
private Connection connection;
	
	public CidadeDAO() {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Cidade cidade) throws SQLException {
		String sql = "insert into cidade" +
				"(nome_cidade, sigla_estado)" + "values (?,?)";
		
		try {
			//prepared statement para inserção
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			
			//seta os valores
			stmt.setString(1,cidade.getNomeCidade());
			stmt.setString(2,cidade.getSiglaEstado());
			
			stmt.execute();
			stmt.close();
		}  catch (SQLException e) {
			throw new SQLException(e);
		}
	}
	
	public List<Cidade> getLista() {
		try {
			List<Cidade> cidades = new ArrayList<Cidade>();
			PreparedStatement stmt = (PreparedStatement) this.connection.
					prepareStatement("select * from cidade");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				//criando o objeto Cidade
				Cidade cidade = new Cidade();
				cidade.setId(rs.getLong("id"));
				cidade.setNomeCidade(rs.getString("nome_cidade"));
				cidade.setSiglaEstado(rs.getString("sigla_estado"));
				
				//adiciona o objeto a lista
				cidades.add(cidade);
			}
			rs.close();
			stmt.close();
			return cidades;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Cidade> getBuscar(Cidade cidade) {
        String sql = "select * from cidade where nome_cidade like ? ";
        try {
            List<Cidade> cidades = new ArrayList<Cidade>();
            PreparedStatement stmt = (PreparedStatement) this.connection.
                    prepareStatement(sql);
            stmt.setString(1, "%" +cidade.getNomeCidade()+ "%");
            ResultSet rs = stmt.executeQuery();
           
            while (rs.next()) {
                //criando o objeto Cidade
                //Cidade cidade = new Cidade();
                cidade.setId(rs.getLong("id"));
                cidade.setNomeCidade(rs.getString("nome_cidade"));
                cidade.setSiglaEstado(rs.getString("sigla_estado"));
               
                //adiciona o objeto a lista
                cidades.add(cidade);
            }
            rs.close();
            stmt.close();
            return cidades;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void altera(Cidade cidade) {
		String sql = "update cidade set nome_cidade=?, sigla_estado=? where id=? ";
		try {
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);
			stmt.setString(1, cidade.getNomeCidade());
			stmt.setString(2, cidade.getSiglaEstado());
			stmt.setLong(3, cidade.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Cidade cidade) {
		String sql = "delete from cidade where id=?";
		try {
			/*PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);*/
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement("delete from cidade where id=?");
			stmt.setLong(1, cidade.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}