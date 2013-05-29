
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <meta charset=utf-8>
    <title>Wannaride</title>
</head>
<body>
<jsp:include page="includes/style.jsp" />
<nav>
    <jsp:include page="includes/menu.jsp" />
</nav>
<article>
    Registration form<br/>
    <sf:form method="POST" commandName="client">
        <table cellspacing="0">
            <tr>
                <th><sf:label path="firstName" >First name:</sf:label></th>
                <td><sf:input path="firstName" size="15"/><br/>
                    <sf:errors path="firstName" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th><sf:label path="lastName">Last name:</sf:label></th>
                <td><sf:input path="lastName" size="15"/><br/>
                    <sf:errors path="lastName" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th><sf:label path="user.login">Login:</sf:label></th>
                <td><sf:input path="user.login" size="15"/><br/>
                    <sf:errors path="user.login" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th><sf:label path="user.password">Password:</sf:label></th>
                <td><sf:input path="user.password" size="15"/><br/>
                    <sf:errors path="user.password" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th><sf:label path="user.email">Email:</sf:label></th>
                <td><sf:input path="user.email" size="15"/><br/>
                    <sf:errors path="user.email" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th><sf:label path="user.cell">Cell:</sf:label></th>
                <td><sf:input path="user.cell" size="15"/><br/>
                    <sf:errors path="user.cell" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th>ROLE</th>
                <td> ${client.user.role.roleName}<br/></td>
            </tr>
            <tr>
            <tr>
                <th></th>
                <td><input name="commit" type="submit" value="I accept.Create my account."/></td>
            </tr>

        </table>
    </sf:form>
    ${client.user.role}<br/>
</article>
</body>
</html>
