package pacote_VIEW;

public enum OpcoesMenu {
	CADASTRAR_CLIENTE(1, "1 - Cadastrar Cliente"),
	PESQUISAR_CLIENTE(2, "2 - Pesquisar Cliente usando nome "),
	EXCLUIR_CLIENTE(3, "3 - Excluir Cliente usando cpf"),
	LISTAR_CLIENTE(4, "4 - Listar todos os Clientes"),
	SAIR(5, "5 - Sair");
	
	

	private final int identificador;
	  private final String descricao;

	  OpcoesMenu(final int identificador,
	              final String descricao) {
	    this.identificador = identificador;
	    this.descricao = descricao;
	  }

	  public int getIdentificador() {
	    return identificador;
	  }

	  public String getDescricao() {
	    return descricao;
	  }
}
