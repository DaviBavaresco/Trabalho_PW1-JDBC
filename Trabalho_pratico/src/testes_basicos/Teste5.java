package testes_basicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import pacote_DAO.ComandoSQL;
import pacote_DAO.ConnectionFactory;
import pessoas.Cliente;
import pessoas.Pessoa;

public class Teste5 {
	public static void main(String[] args) {
		
		String nom = JOptionPane.showInputDialog("Informe o nome da pessoa:");
		Cliente c = new Cliente();
		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(ComandoSQL.FIND_BY_NOME_CLIENTE.getSql())){
			stmt.setString(1, nom);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int idCliente = rs.getInt("idCliente");
			      String nome = rs.getString("nome");
			      String telefone = rs.getString("telefone");
			      String endereco = rs.getString("endereco");
			      String cpf = rs.getString("cpf");
				c=new Cliente(endereco,telefone,cpf,new Pessoa(nome));
				c.setIdCliente(idCliente);
				JOptionPane.showMessageDialog(null, c.toString());
			}
		}catch(SQLException e){ System.out.println("Exce��o SQL - findByNome Cliente");
		}catch(Exception e){  System.out.println("Exce��o no c�digo - findByNome Cliente");
		}
            
            
        
	
	}
}
