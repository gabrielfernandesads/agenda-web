package br.com.gabriel.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes  {

	public static Connection getConnection() {
		//problemao
		//nesse tomcat foi necessario registrar Driver, o parece já ser obsoleto..
		try{  
			//nesse tomcat foi necessario registrar Driver, o parece já ser obsoleto..
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //na pratica só seria necessario essa linha
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","cancer");  
              
        }catch(SQLException e){  
            throw new RuntimeException(e);  
        }  
		
	}
}
