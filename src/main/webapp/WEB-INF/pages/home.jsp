<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    <style>
    .table-responsive {height:200px;}
    #myTable1 th {
	    font-size: 1.1em;
	    text-align: center;
	    padding-top: 5px;
	    padding-bottom: 4px;
	    background-color: #A7C942;
	    color: #ffffff;
	}
    </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Manager Home</title>
        <link type="text/css" rel="stylesheet" 
        href="<c:url value="/resources/css/styles.css" /> " />
        
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
	<script type="text/javascript" 
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" 
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
               <div align="center">
            <h1>Account List</h1>
            <h3><a href="/Springexample/addAccount">New Account</a></h3>
            <div class="container">
			<div class="row">
		      <div class="table-responsive">
            <table id="myTable">
             <thead >
                <th >Id</th>
                <th>Name</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Options</th>
              </thead> 
                <tbody id="myTable">
                <c:forEach var="account" items="${listAccount}" varStatus="status">
                  
                 <tr class="tr${status.index%2}">
                    <td align="center">${status.index + 1}</td>
                    <td>${account.name}</td>
                    <td>${account.firstname}</td>
                    <td>${account.lastname}</td>
                    <td align="center">
                        <a href="/Springexample/editAccount?id=${account.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Springexample/deleteAccount?id=${account.id}  "onclick="return confirm('Ban co muon xoa?')">Delete</a>
                    </td>
                             
                </tr>
             
                </c:forEach>  
                 </tbody>         
            </table>
             </div>
      <div class="col-md-12 text-center">
      <ul class="pagination pagination-lg pager" id="myPager"></ul>
      </div>
	</div>
    </div>
    </div>
         <div align="center">
        <h1>New/Edit Contact</h1>
        <form:form action="/Springexample/saveAccount" method="Post" modelAttribute="account" name="account" onSubmit="return validateForm(account);">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstname" /></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastname"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
 
</body>
   
<script language="javascript" 
  type="text/javascript">

function validateForm(account)
{

if(""==document.forms.account.name.value)
{
alert("Please enter your name.");
document.forms.account.name.focus();
return false;
}
		
if(""==document.forms.account.firstname.value)
{
alert("Please enter your firstname.");
document.forms.account.firstname.focus();
return false;
}

if(""==document.forms.account.lastname.value)
{
alert("Please enter your last name.");
document.forms.account.lastname.focus();
return false;
}

}
</script>
 <div class="container"> 
          <h1 align="center">Account List</h1>
          
          <div align="right">
        <form:form action="/Springexample/saveAccount" method="Post" modelAttribute="account"  onSubmit="return validateForm(account);">
        <table>
            <tr>
               <td><form:input path="name" /></td>
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
                    <td><sf:form  action="/Springexample/delete" method="Post" modelAttribute="account" ><sf:hidden path="id" value="${account.id}"/><input type="submit" value="Del" ></sf:form>
                         &nbsp;&nbsp;&nbsp;&nbsp;
                        <!--<sf:form  action="/Springexample/edit" method="Post" modelAttribute="account" ><sf:hidden path="id" value="${account.id}"/><input type="submit" value="Edit"></sf:form>--></td>
                </tr>
             
                </c:forEach>  
                 </tbody>         
            </table>
            </div>
            </div>
     <B>Totals record are ${iend}</B>
         
    </div>
    
       <div align="center">
      
        <h1>New Account</h1><br>
        <sf:form action="/Springexample/saveAccount" method="Post"  modelAttribute="account" enctype="multipart/form-data">
        <table>				
            <sf:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><sf:input path="name" name="name" id="name" class="required" minlength="6"/><sf:errors path="name" /></td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td><sf:input path="firstname" name="firstname" id="firstname" /><sf:errors  path="firstname" /></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><sf:input path="lastname" name="lastname" id="lastname"/><sf:errors  path="lastname" /></td>
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

</html>
