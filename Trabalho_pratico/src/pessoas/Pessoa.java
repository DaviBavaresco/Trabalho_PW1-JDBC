package pessoas;

import pacote_DAO.PessoaDAO;

public class Pessoa {
	private int idPessoa;
	private String nome;
	
	
	

	
	public Pessoa(String nome) {
		this(-1, nome);
		
	}

	

	public Pessoa(int idPessoa, String nome) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome ;
	}
	
	public int insert() {
    	return new PessoaDAO().insert(this);
    }
	
	
	

}
