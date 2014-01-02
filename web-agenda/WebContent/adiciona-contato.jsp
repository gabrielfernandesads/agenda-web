<!-- TagLib abre jsp seguido de "@" e indica o endere�o da biblioteca -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="minhatag" %>

<!-- Cap�tulo-6 Jsp -->
<!DOCTYPE html>
<html>
<head>
<!-- Necess�rio informar endere�o de bibliotecas Css e JQuery q vou usar -->
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
</head>
<body>
<!-- Taglib "c:import" carrega fragmentos de outras p�ginas em uma �nica p�gina-->
<c:import url="cabecalho.jsp"></c:import>

<!-- tag "<form>" criando um formul�rio-->
<form action="adicionaContato" method="post">
Nome: <input type="text" name="nome" /><br />
E-mail: <input type="text" name="email" /><br />
Endereco: <input type="text" name="endereco" /><br />

<!-- Usando minha pr�pria tag que possui um script Jquery,
 localizado na pasta "tags",arquivo"campoData.tag" -->
Data Nascimento: <minhatag:campoData id="dataNascimento" /><br />
<input type="submit" value="Gravar" />
</form>

<c:import url="rodape.jsp"></c:import>
</body>
</html>