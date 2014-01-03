package br.com.gabriel.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	void executa(HttpServletRequest requisicao,HttpServletResponse resposta)throws Exception;
	
}
