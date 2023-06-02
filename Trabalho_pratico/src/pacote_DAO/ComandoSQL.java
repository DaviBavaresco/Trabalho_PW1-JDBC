package pacote_DAO;

public enum ComandoSQL {
	INSERT_PESSOA("insert into pessoa(nome) values (?)"), 
    LISTALL_PESSOA("select * from pessoa"),
    FIND_BY_NOME_PESSOA("select * from pessoa where nome=?"),
    
    INSERT_CLIENTE("insert into cliente(endereco,telefone,cpf,idpessoa) values (? , ? , ? , ?)"),
    DELETE_CLIENTE("delete from cliente where cpf=? "),
    LISTALL_CLIENTE("select * from cliente"),
	FIND_BY_NOME_CLIENTE("select * from cliente inner join pessoa on pessoa.idpessoa=cliente.idPessoa where pessoa.nome=?");
    
	
	
	
    private final String sql;
    ComandoSQL(String sql){
        this.sql = sql; 
    
    }

    public String getSql() {
        return sql;
    }

}
