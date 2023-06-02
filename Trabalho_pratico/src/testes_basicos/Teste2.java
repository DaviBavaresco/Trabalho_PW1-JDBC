package testes_basicos;

import java.sql.Connection;

import pacote_DAO.ConnectionFactory;



public class Teste2 {
	public static void main(String[] args) throws Exception{
	      Connection connection = 
	                   new ConnectionFactory().getConnection();
	      if(connection!=null)
	         System.out.println("Conex�o aberta!");
	      else
		   System.out.println("Conex�o com exce��o!");
	      connection.close();
	    }

}
