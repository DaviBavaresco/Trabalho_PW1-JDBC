package pessoas;
import java.util.List;

import pacote_DAO.ClienteDAO;

public class Cliente {
	private int idCliente;
	
	private String endereco;
	private String telefone;
	private String cpf;
	private static int numero=0;
	private Pessoa pessoa;
	
	

	


	public Cliente(int idCliente, String endereco, String telefone, String cpf, Pessoa pessoa) {
		super();
		this.idCliente = idCliente;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
		this.pessoa = pessoa;
		numero++;
	}





	public Cliente( String endereco, String telefone, String cpf, Pessoa pessoa) {
		this(-1,endereco,telefone,cpf,pessoa);
		numero++;
	}





	public Cliente() {
		super();
	}





	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public static int getNumero() {
		return numero;
	}

	public static void setNumero(int numero) {
		Cliente.numero = numero;
	}

	
	
	
	@Override
	public String toString() {
		return "Cliente [endereco=" + endereco + ", telefone=" + telefone + ", cpf=" + cpf + ", idCliente=" + idCliente
				+ ", pessoa=" + pessoa + ", numero= "+numero;
	}


	public int insert() {
        return new ClienteDAO().insert(this);
    }
	public static List<Cliente> listAll(){
		return ClienteDAO.listAll();
	}
	public int delete(){
		return new ClienteDAO().delete(this);
	}
	public  Cliente findByNome(){
		return new ClienteDAO().findByNome(getPessoa().getNome());
		
		
	}
	
	

}
