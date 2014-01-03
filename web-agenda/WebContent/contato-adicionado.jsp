<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- Capítulo-9 Mcv Essa página aparece para o Cliente após a AdicionaClienteServlet
    executar sua regra de negócio, nesta classe o método ".getRequestDispatcher" e
    ".forward" do objeto instanciado da clssse RequestDispatcher farão o direcionamento
    para está página (/contato-adicionado.jsp)-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Contato ${param.nome} adicionado com sucesso
</body>
</html>
