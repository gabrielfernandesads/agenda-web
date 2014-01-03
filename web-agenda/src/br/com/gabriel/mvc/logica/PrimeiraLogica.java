package br.com.gabriel.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica{

	@Override
	public void executa(HttpServletRequest requisicao,
			HttpServletResponse resposta) throws Exception {
		System.out.println("Executando a lógica e redirecionando");
		RequestDispatcher rd = requisicao.getRequestDispatcher("/primeira-logica.jsp");
		rd.forward(requisicao, resposta);
		
	}

}
