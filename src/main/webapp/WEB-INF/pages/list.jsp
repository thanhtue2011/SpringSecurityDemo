<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:url var="firstUrl" value="/list?page=1" />
<c:url var="lastUrl" value="/list?page=${iend}" />
<c:url var="prevUrl" value="/list?page=${page-1}" />
<c:url var="nextUrl" value="/list?page=${page+1}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>	
<head>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/css/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/css/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/css/messages_vi.js"></script>

	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Xoa dialog -->
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/dialog.js"/></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/format.js"/></script>
 <!-- Bootrasp --> 
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
	<!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>-->
  <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
	<script type="text/javascript" 
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" 
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>Spring Example</title>
</head>
<body>
         
        <!--  <h2>Tạo form login hoàn chỉnh bằng kỹ thuật Ajax và Validate jquery - 2CwebVN</h2>
        
         <div class="success" style=display:none;> sdsd  </div>
          <span class="span"></span>
<form id="tutorial" action="test.php" method="post">
<fieldset><legend> Member login </legend>
    <p><label for="name">Name:</label>
    <input type="text" name="name" id="name" class="required"  minlength="6"/></p>
    <p><label for="email">Email:</label>
    <input type="text" name="email" id="email" class="required email" /></p>
    <p class="submit"><input id="submit" type="submit" value="Send" /></p>
</fieldset>
</form> -->

         
         
          <div class="container"> 
          <h1 align="center">Account List</h1>
          
          <div align="right">
        <form:form action="/Springexample/searchAccount" method="Post" modelAttribute="account">
        <table>
            <tr>
               <td><input type="text" name="name"></td>
               <td><input type="submit" value="Search"></td>
                
            </tr>
        </table>
        </form:form>
        </div>
          
			<div class="row">
		      <div class="table-responsive">
            <table class="table table-hover">
             <thead>
                <th>Id</th>
                <th>Name</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th align="center">Options Get</th>
                 <th align="center">Options Post</th>
              </thead> 
                <tbody id="myTable">
                <c:forEach var="account" items="${listAccount}" varStatus="status">
                  
                 <tr class="tr${status.index%2}">
                    <td align="center">${account.id}</td>
                    <td>${account.name}</td>
                    <td>${account.firstname}</td>
                    <td>${account.lastname}</td>
                    <td>
                        <a href="/Springexample/editAccount?id=${account.id}&page=${page}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Springexample/deleteAccount?id=${account.id}&page=${page}" onclick="return confirm('Ban co muon xoa?')">Delete</a>
                    </td>
                    <td><form  action="/Springexample/delete" method="Post" modelAttribute="account" id="${account.id}" ><input type="hidden" name="id" value="${account.id}" /><input type="button" value="Del" onclick="Xoa('${account.id}');" /></form>
                         &nbsp;&nbsp;&nbsp;&nbsp;
                        <!--<sf:form  action="/Springexample/edit" method="Post" modelAttribute="account" ><sf:hidden path="id" value="${account.id}"/><input type="submit" value="Edit"></sf:form>--></td>
                </tr>
             
                </c:forEach>  
                 </tbody>         
            </table>
            
         
            </div>
            </div>
            
     <B>Totals record are ${iend}</B>
     <!--   <p class="success">Update success record<span style='color:blue' >${request.id}</span>-->
         
    </div>
    
       <div align="center">
      
        <h1>New Account</h1><br>
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
                <td colspan="2" align="center"><input type="submit" value="Add"  name="submit" id="submit" ></td>
            </tr>
        </table>
        </sf:form>
      
    </div>
    
                  
       <div class="col-md-12 text-center">
       <ul class="pagination pagination-lg pager" id="myPager">
        <c:choose>
            <c:when test="${page ==1 }">
                <li class="disabled"><a href="#">&lt;&lt;</a></li>
                <li class="disabled"><a href="#">&lt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${firstUrl}">&lt;&lt;</a></li>
                <li><a href="${prevUrl}">&lt;</a></li>
            </c:otherwise>
        </c:choose>
        <c:forEach var="i"  begin="${page}" end="${iend}">
            <c:url var="pageUrl" value="/list?page=${i}" />
            <c:choose>
                <c:when test="${i == page}">
                    <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${page==iend}">
                <li class="disabled"><a href="#">&gt;</a></li>
                <li class="disabled"><a href="#">&gt;&gt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${nextUrl}">&gt;</a></li>
                <li><a href="${lastUrl}">&gt;&gt;</a></li>
            </c:otherwise>
        </c:choose>
    </ul>				
</div>
</body>
</html>