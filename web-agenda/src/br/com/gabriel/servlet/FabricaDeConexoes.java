package br.com.gabriel.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Capítulo-2 Conectar Java com Banco de Dados
public class FabricaDeConexoes {

	public static Connection getConnection() {
		//DriverManager, classe que posssui os métodos p/se conectar ao Banco
		//como: .getConnection e .registerDriver
		try{  
			//Use esse método p/ registrar o nome do Banco se a versão do Tomcat exigir
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //Esse método acessa o banco passando como parametro:
            //("jdbc:nomedobanco://local:porta/bancocriado","user","senha")
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","cancer");  
              
        }catch(SQLException e){  
            throw new RuntimeException(e);  
        }  
		
	}
}
