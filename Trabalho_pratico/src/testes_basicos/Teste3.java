package testes_basicos;

import java.sql.*;

import pacote_DAO.ConnectionFactory;

public class Teste3 {
	public static void main(String[] args) throws Exception{
		Connection connection = new ConnectionFactory().getConnection();
		String sql = "select * from cliente inner join pessoa on pessoa.idPessoa=cliente.idpessoa";
		     
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
		      int idCliente = rs.getInt("idCliente");
		      String nome = rs.getString("nome");
		      String telefone = rs.getString("telefone");
		      String endereco = rs.getString("endereco");
		      String cpf = rs.getString("cpf");
		      System.out.println("Dados = "+idCliente + " " + nome + " "+ telefone + " "+ endereco + " "+ cpf + " ");
		} 
		connection.close();
	}
}
