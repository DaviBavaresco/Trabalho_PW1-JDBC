
package pacote_VIEW;

import java.util.List;

import javax.swing.JOptionPane;

import pacote_DAO.ClienteDAO;
import pessoas.Cliente;
import pessoas.Pessoa;

public class Menu {
	public static void main(String[] args) {

		while (true) {
			switch (montaMenu()) {
			case 1:// Cadastrar Cliente
				String nome = JOptionPane.showInputDialog("Informe o nome da pessoa:");
				String endereco = JOptionPane.showInputDialog("Informe o endere�o:");
				String cpf = JOptionPane.showInputDialog("Informe o cpf:");
				String telefone = JOptionPane.showInputDialog("Informe o telefone:");
				Cliente cli = new Cliente(endereco,telefone,cpf,new Pessoa(nome) );
				if (cli.insert() == -1)
					JOptionPane.showMessageDialog(null, "Erro ao inserir cliente!");
				else
					JOptionPane.showMessageDialog(null, "Cliente inserida com sucesso!");
				break;
			case 2://pesquisar pelo nome
				String nomePesq = JOptionPane.showInputDialog("Informe o nome da pessoa:");
				Cliente clie= new Cliente();
				Pessoa pessoa = new Pessoa(nomePesq);
				clie.setPessoa(pessoa);
				clie.findByNome();
				JOptionPane.showMessageDialog(null, clie.toString());
				
				
				
				break;
			
			case 3://excluir cliente pelo cpf
				break;
				
			case 4://listar todos os clientes
				List<Cliente> lista = Cliente.listAll();
				if (lista != null) {
					String auxCliente = "";
					for (Cliente cliente : lista) {
						if (cliente != null)
							auxCliente += cliente.toString() + "\n";
					}
					JOptionPane.showMessageDialog(null, auxCliente);
				}
				break;
		
			case 5:
				System.exit(0);
				break;
			}
		}
	}

	




	public static int montaMenu() {
		String menu = "";
		menu += ("Escolha uma das seguintes op��es:\n");
		for (OpcoesMenu value : OpcoesMenu.values()) {
			menu += value.getDescricao() + "\n";
		}
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

}
