
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
    <meta charset=utf-8>
    <title>Wannaride</title>
</head>
<body>
   Wannaride welcomes you!!! <br/>

   username <security:authentication property="principal.username"/><br/>
   authorities <security:authentication property="authorities"/><br/>
   credentials <security:authentication property="credentials"/><br/>
   details <security:authentication property="details"/><br/>


   <security:authorize access="isAuthenticated()">
       <s:url value="/j_spring_security_logout" var="logout_url"/>
       <br/><a href="${logout_url}">logout</a>
   </security:authorize>

this page is secured


</body>
</html>
