package br.com.gabriel.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FiltroTempoDeExecucao implements Filter{

	@Override
	public void doFilter(ServletRequest requisicao, ServletResponse resposta,
			FilterChain chain) throws IOException, ServletException {
		long tempoInicial = System.currentTimeMillis();
		
		chain.doFilter(requisicao, resposta);
		
		long tempoFinal = System.currentTimeMillis();
		
		String uri = ((HttpServletRequest)requisicao).getRequestURI();
		System.out.println("Tempo da requisição de " +
		uri + " demourou (ms): " + (tempoFinal - tempoInicial));
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
