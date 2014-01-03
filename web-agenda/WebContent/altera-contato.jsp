<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="minhatag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Necessário informar endereço de bibliotecas Css e JQuery q vou usar -->
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	
	<h2>Formulário para alteração de contatos:</h2><br />
	
	<form action="mvc" method="POST">
	 Id: <input type="text" name="id" /><br />
	 Nome: <input type="text" name="nome" /><br />
	 E-mail: <input type="text" name="email" /><br />
	 Endereço: <input type="text" name="endereco" /><br />
	 Data Nascimento: <minhatag:campoData id="dataNascimento" /><br />
	 
	 <!-- passa "logica" como parametro e valor "AlteraContatologic" de forma oculta via request -->
	<input type="hidden" name="logica" value="AlteraContatoLogic" />
	
	<input type="submit" value="Enviar" />
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>