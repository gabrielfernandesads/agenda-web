package br.com.gabriel.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Capítulo-5 Servlets
public class OlaMundoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest requisicao, HttpServletResponse resposta)
			throws ServletException, IOException {
		PrintWriter out = resposta.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Ola Mundo: primeiro Servlet!!");
		out.println("</body>");
		out.println("</html>");
	}
}
