package testes_basicos;

import java.sql.*;



public class Teste1 {
	 public static void main(String[] args) throws Exception{ 
	     Class.forName("com.mysql.jdbc.Driver");
	     String urlBD="jdbc:mysql://localhost:3306/bd";
	     Connection connection = 
	     DriverManager.getConnection(urlBD, "root", "");            
	     System.out.println("Conectou!"); 
	     connection.close(); 
	   }

}
