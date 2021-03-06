package br.com.gabriel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Capítulo-5 Servlets
	public class AdicionaContatoServlet extends HttpServlet {
		protected void service(HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException{
		// busca o writer
			
		PrintWriter out = response.getWriter();
		
		// buscando os parâmetros no request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request
		.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		// fazendo a conversão da data
		try {
		Date date =
		new SimpleDateFormat("dd/MM/yyyy")
		.parse(dataEmTexto);
		dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(date);
		} catch (ParseException e) {
		out.println("Erro de conversão da data");
		return; //para a execução do método
		}
		// monta um objeto contato
	    Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		// salva o contato
		ContatoDao dao = null;
		try {
			dao = new ContatoDao();
		} catch (Exception e) {
		}
		dao.adiciona(contato);
		
		// imprime o nome do contato que foi adicionado
		/*out.println("<html>");
		out.println("<body>");
		out.println("Contato " + contato.getNome() +
				" adicionado com sucesso!");
		out.println("</body>");
		out.println("</html>");*/
		
		//Capítulo-9 Mcv
		//RequestDispatcher retira todo o código html dessa página
		RequestDispatcher rd = request
		.getRequestDispatcher("/contato-adicionado.jsp");//direciona p/pagina q contem a resposta html
		rd.forward(request,response);
		
		}
		}
