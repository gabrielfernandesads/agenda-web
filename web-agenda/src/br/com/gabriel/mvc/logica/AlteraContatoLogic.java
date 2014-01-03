package br.com.gabriel.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gabriel.servlet.Contato;
import br.com.gabriel.servlet.ContatoDao;
//Implementa um contrato da interface Logica
public class AlteraContatoLogic implements Logica{

	@Override
	public void executa(HttpServletRequest requisicao,
			HttpServletResponse resposta) throws Exception {
		
		//pega os valores passados no formulario "altera-contato.jsp" e seta no objeto "contato"
		Contato contato = new Contato();
		long id = Long.parseLong(requisicao.getParameter("id"));
		contato.setId(id);
		contato.setNome(requisicao.getParameter("nome"));
		contato.setEndereco(requisicao.getParameter("endereco"));
		contato.setEmail(requisicao.getParameter("email"));
		
		//Converte a data de String para Calendar
		String dataTexto=requisicao.getParameter("dataNascimento");
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
		Calendar dataNascimento= Calendar.getInstance();
		dataNascimento.setTime(date);
		contato.setDataNascimento(dataNascimento);
		
		//intancia um objeto "dao" e passa como parametro o novo contato setado para alterar
		//ContatoDao dao= new ContatoDao();
		// ....
		// ....
		// (procure o ContatoDao no código existente)
		// busca a conexão pendurada na requisição
		Connection connection = (Connection) requisicao
		.getAttribute("conexao");
		//passe a conexão no construtor
		ContatoDao dao = new ContatoDao(connection);
		// ....
		// ....
		dao.altera(contato);
		
		//direciona para a pagina jsp de listagem
		RequestDispatcher rd = requisicao.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(requisicao, resposta);
		
		System.out.println("Alterando contato..."+contato.getNome());
	}

}
