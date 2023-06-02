package testes_basicos;
import java.sql.*;

import pacote_DAO.ConnectionFactory;

public class Teste4 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		
		Connection connection = new ConnectionFactory().getConnection();

		String sql = "select * from cliente inner join pessoa on pessoa.idpessoa=cliente.idPessoa where nome=?";

		PreparedStatement stmt = connection.prepareStatement(sql);
		// preenche os valores das ?
		stmt.setString(1, "davi");

		// executa
		stmt.execute();
		
		stmt.close();
		connection.close();
		System.out.println("Dados Gravados!");

}

}
