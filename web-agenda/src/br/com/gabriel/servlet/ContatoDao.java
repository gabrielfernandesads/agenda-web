package br.com.gabriel.servlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
//Capítulo-2 Dao
//Métodos típicos que interagem com o banco de dados
//famoso CRUD..adiciona,pesquisa,atualiza,deleta

public class ContatoDao {
	Connection conexao;

	private Connection connection;

	public ContatoDao(Connection connection) {
		this.connection = connection;
	}

	// Construtor: sempre que Contato Dao for instanciado é construído uma
	// conexão com o Banco
	// E atribuido a váriavel "conexao", que deve ser do tipo Connection
	public ContatoDao() {
		new FabricaDeConexoes();
		this.conexao = FabricaDeConexoes.getConnection();
	}

	// metodos que vão interagir com o banco
	// Passo como parametro o objeto que desejo add no Banco
	public void adiciona(Contato contato) {
		// comando sql
		String sql = "insert into contatos"
				+ "(nome,email,endereco,dataNascimento)" + "values(?,?,?,?)";
		// crio um objeto do tipo PreparedStatement para receber o comando sql
		// desejado
		// e setar os valores passados no formulário
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			// método set exige como parameto(indice,atributo do objeto)
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));

			// executa ação no Banco
			stmt.execute();
			// fecha conexão com Banco
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista() {
		try {
			List<Contato> listadecontatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.conexao
					.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// Criando o objeto contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				// adicionando objeto a lista
				listadecontatos.add(contato);
			}
			rs.close();
			stmt.close();
			return listadecontatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Contato contato) {

		String sql = "update contatos set nome=?,email=?,"
				+ "endereco=?,dataNascimento=? where id=?";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Contato contato) {
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
