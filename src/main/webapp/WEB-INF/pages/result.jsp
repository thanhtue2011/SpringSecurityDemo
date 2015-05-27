<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted Account Information</h2>
   <table>
   <tr>
        <td>ID</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>First name</td>
        <td>${firstname}</td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td>${lastname}</td>
    </tr>
    
</table>  
</body>
</html>