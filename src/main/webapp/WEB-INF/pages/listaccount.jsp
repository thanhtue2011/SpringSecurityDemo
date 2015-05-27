<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring 3 MVC Series - Account Manager</title>
</head>
<body>
 
<h2>Account Manager</h2>
 
<form:form method="post" action="/Springexample/index" commandName="account">
 
    <table>
      <tr>
        <td><form:label path="id">Id</form:label></td>
        <td><form:input path="id" /></td>
    </tr>
     <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td> 
    </tr>
    <tr>
        <td><form:label path="firstname">FirstName</form:label></td>
        <td><form:input path="firstname" /></td> 
    </tr>
    <tr>
        <td><form:label path="lastname">Last Name</form:label></td>
        <td><form:input path="lastname" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="submit"/>
        </td>
    </tr>
</table>  
</form:form>
 
     
<h3>Accounts</h3>
<c:if  test="${!empty accountList}">
<table class="data">
<tr>
    <th>Id</th>
    <th>Name</th>
    <th>FirstName</th>
    <th>LastName</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${accountList}" var="contact">
    <tr>
        <td>${account.lastname}, ${account.firstname} </td>
        <td>${account.id}</td>
        <td><a href="delete/${account.id}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
 
</body>
</html>
