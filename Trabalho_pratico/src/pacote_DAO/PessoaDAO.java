package pacote_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import pessoas.Pessoa;

public class PessoaDAO implements GenericaDAO<Pessoa> {

	@Override
	public int insert(Pessoa p) {
		int chavePrimaria = -1;
		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(ComandoSQL.INSERT_PESSOA.getSql(),
						Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, p.getNome());
			stmt.execute();
			ResultSet chaves = stmt.getGeneratedKeys();
			if (chaves.next())
				chavePrimaria = chaves.getInt(1);
		} catch (SQLException e) {
			System.out.println("Exce��o no c�digo - Pessoa insert");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Classe n�o encontrada - Pessoa insert!");
		}
		return chavePrimaria;
	}

	@Override
	public int update(Pessoa obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Pessoa obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pessoa findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public Pessoa find (Connection con, int idPessoa){
		try{
			PreparedStatement stmt = 
					con.prepareStatement("select * from pessoa where idPessoa=?");
			stmt.setInt(1, idPessoa);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String nome = rs.getString("nome");
				return new Pessoa(nome);
			}
		}catch(SQLException e){
			System.out.println("Exce��o find PessoaDAO");
		}
		return null;
	}
	
	public  List<Pessoa> listAll() {
		List<Pessoa> lista = new LinkedList<>();
		try(Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(ComandoSQL.LISTALL_PESSOA.getSql())){
			System.out.println("Conex�o aberta!");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				int idPessoa = rs.getInt("idPessoa");
				String nome = rs.getString("nome");
				lista.add(new Pessoa(nome));
			}
			return lista;
		}catch(SQLException e){ System.out.println("Exce��o SQL - listAll Pessoa");
		}catch(ClassNotFoundException e){
			System.out.println("Classe n�o encontrada - listAll Pessoa!");
		}catch(Exception e){  System.out.println("Exce��o no c�digo - listAll Pessoa!");
		}
		return null;
	}

}
