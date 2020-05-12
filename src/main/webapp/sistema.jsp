<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="mb" class="br.com.coti.manager.ManagerBean" scope="request"/>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema Listagem</title>
</head>
<body>
<h2>Projeto Listagem</h2>
<hr>
<c:forEach items="${mb.dto}" var="linha">
<li>${linha.cliente.nome}, ${linha.endereco.bairro}, ${linha.endereco.cidade}</li>
</c:forEach>
</body>
</html>