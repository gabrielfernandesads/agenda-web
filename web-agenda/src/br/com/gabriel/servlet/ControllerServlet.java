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
		
		//Na barra de endereço pegue o valor do paremetro "logica"
		String parametro = requisicao.getParameter("logica");
		
		//será passado um valor "NomedeClassedeLogica" da aplicação(uma servlet)e concatenado
		//para obter o nome do pacote
		String nomeDaClasse="br.com.gabriel.mvc.logica."+parametro;
		
		
		try {
			//cria um objeto do tipo Class através do nome do pacote
			Class classe = Class.forName(nomeDaClasse);
		
	    //cria uma instancia do objeto classe e converte para o tipo(Logica)para atribuir
		// a um objeto do tipo Logica e usar seu metodo .executa()
		Logica logica = (Logica) classe.newInstance();
		logica.executa(requisicao, resposta);
		
		} catch (Exception e) {
			throw new ServletException("A lógica de negocios causou uma exceçao",e);
		}

	}

}
