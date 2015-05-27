<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/css/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/css/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/css/messages_vi.js"></script>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/format.js"/></script>
<title>Edit Account</title>
</head>
<body>
    <div align="center">
        <h1>Edit Contact</h1>
         <div class="success" style=display:none;> sdsd  </div>
          <span class="span"></span>
        <sf:form id="tutorial" action="/Springexample/saveAccount" method="Post"  modelAttribute="account" enctype="multipart/form-data">
        <table>				
            <sf:hidden path="id" name="id" id="id"/>
            <tr>
                <td>Name:</td>
                <td><sf:input path="name" name="name" id="name" class="required"  minlength="2"/><sf:errors path="name" /></td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td><sf:input path="firstname" name="firstname" id="firstname" class="required"  minlength="2"/><sf:errors  path="firstname" /></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><sf:input path="lastname" name="lastname" id="lastname" class="required"  minlength="2"/><sf:errors  path="lastname" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Edit"  name="submit" id="submit" ></td>
            </tr>
        </table>
        </sf:form>
    </div>
   
</body>
</html>