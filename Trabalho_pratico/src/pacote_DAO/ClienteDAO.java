package pacote_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import pessoas.Cliente;
import pessoas.Pessoa;

public class ClienteDAO implements GenericaDAO<Cliente> {

	@Override
	public int insert(Cliente cli) {
		int chavePrimaria = -1;
		int idPessoa = new PessoaDAO().insert(cli.getPessoa());
		if (idPessoa == -1)
			return -1;
		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(ComandoSQL.INSERT_CLIENTE.getSql(),
						Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, cli.getEndereco());
			stmt.setString(2, cli.getTelefone());
			stmt.setString(3, cli.getCpf());
			stmt.setInt(4, idPessoa);
			stmt.execute();
			ResultSet chaves = stmt.getGeneratedKeys();
			if (chaves.next())
				chavePrimaria = chaves.getInt(1);
		} catch (SQLException e) {
			System.out.println("Exce��o - insert Cliente");
		} catch (ClassNotFoundException e) {
			System.out.println("Classe n�o encontrada - insert Cliente!");
		}
		if (chavePrimaria == -1)
			new PessoaDAO().delete(cli.getPessoa());
		return chavePrimaria;
	}

	@Override
	public int update(Cliente obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Cliente obj) {
		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(ComandoSQL.DELETE_CLIENTE.getSql())) {
			stmt.setString(1, obj.getCpf());
			System.out.println("Conex�o aberta!");
			if (stmt.execute())
				return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exce��o SQL - delete Cliente");
		} catch (Exception e) {
			System.out.println("Exce��o no c�digo - delete Cliente");
		}
		return -1;
	}

	@Override
	public Cliente findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Cliente> listAll() {
		List<Cliente> lista = new LinkedList<>();
		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(ComandoSQL.LISTALL_CLIENTE.getSql())) {
			System.out.println("Conex�o aberta!");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String endereco = rs.getString("endereco");
				String telefone = rs.getString("telefone");
				String cpf = rs.getString("cpf");
				Pessoa pessoa = new PessoaDAO().find(connection, rs.getInt("idPessoa"));
				lista.add(new Cliente(endereco, telefone, cpf, pessoa));
			}
			return lista;
		} catch (SQLException e) {
			System.out.println("Exce��o SQL - listAll Cliente");
		} catch (Exception e) {
			System.out.println("Exce��o no c�digo - listAll Cliente");
		}
		return null;
	}
	public Cliente findByNome(String nom){
		Cliente c = null;
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
				
			}
		}catch(SQLException e){ System.out.println("Exce��o SQL - findByNome Cliente");
		}catch(Exception e){  System.out.println("Exce��o no c�digo - findByNome Cliente");
		}
		return c;        
	}


	
	

}
