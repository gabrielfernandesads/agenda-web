package br.com.gabriel.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.com.gabriel.servlet.FabricaDeConexoes;

public class FiltroConexao implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest requisicao, ServletResponse resposta,
			FilterChain chain) throws IOException, ServletException {
		try {
			new FabricaDeConexoes();
			Connection connection = FabricaDeConexoes.getConnection();
			
			//pendurando a connection na requisição
			requisicao.setAttribute("conexao", connection);
			
			//Continua com a requisição
			chain.doFilter(requisicao, resposta);
			
			//Fecha conexão após requisição
			connection.close();
			} catch (SQLException e) {
			throw new ServletException(e);
			}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	

}
