<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<title>Licencia</title>
</head>
<body>
  <div class="container-fluid">
        <div class="d-flex flex-row col-3 mx-auto my-5 bg bg-warning border border-dark rounded text-center justify-content-center text-light">
	<form:form action="/licencia/licencia" method="post" modelAttribute="licenciaValida">
           <h1>Agregar Licencia</h1>
            <div class="form-group">
                <form:label path="state">Persona: </form:label>
                
					<form:select path="person">
					<c:forEach items="${personas}" var="person">
						<option value="<c:out value="${person.getId()}"/>"> <c:out value="${person.firstName }"/>  </option>
						</c:forEach>
					</form:select>
                
            </div>
              <div class="form-group">
                <form:label path="state">Estado: </form:label>
                <form:errors class="text-danger" path="state"/>
                <form:input placeholder="Estado" path="state"/>
            </div>
            <div class="form-group">
                <form:label path="expirationDate">Fecha Expiracion: </form:label>
                <form:errors class="text-danger" path="expirationDate"/>
                <form:input type="date" placeholder="" path="expirationDate"/>
            </div> 
            <form:input type="hidden" path="number" value="0100"/>                
			<input type="submit" class="btn btn-dark" value="Crear">
        	<a href="/index" class="btn btn-success">Volver</a>
	</form:form>
	</div>
</div>
</body>
</html>