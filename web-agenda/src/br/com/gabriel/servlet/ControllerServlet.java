package br.com.gabriel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.mvc.logica.Logica;

public class ControllerServlet extends HttpServlet {
	protected void service(HttpServletRequest requisicao,
			HttpServletResponse resposta) throws ServletException, IOException {
		String parametro = requisicao.getParameter("logica");
		String nomeDaClasse="br.com.gabriel.mvc.logica."+parametro;
		
		
		try {
			Class classe = Class.forName(nomeDaClasse);
		
		Logica logica = (Logica) classe.newInstance();
		logica.executa(requisicao, resposta);
		
		} catch (Exception e) {
			throw new ServletException("A lógica de negocios causou uma exceçao",e);
		}

	}

}
