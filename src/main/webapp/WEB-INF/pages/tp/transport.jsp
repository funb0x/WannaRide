
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

    Create new transport</br>
    <sf:form method="POST" commandName="transport">
        <table cellspacing="0">
            <tr>
                <th><sf:label path="seatsNumber" >Seats number:</sf:label></th>
                <td><sf:input path="seatsNumber" size="15"/><br/>
                    <sf:errors path="seatsNumber" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th><sf:label path="description" >Description:</sf:label></th>
                <td><sf:input path="description" size="15"/><br/>
                    <sf:errors path="description" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th></th>
                <td><input name="commit" type="submit" value="Add new transport"/></td>
            </tr>
        </table>
    </sf:form>
    </br>
    Your transports</br>

    <c:forEach var = "transport" items = "${transports}">
        <li>
             <span class="">
                 ${transport.tripProvider}
             </span>
                    <span class="">
                        ${transport.seatsNumber}
                    </span>
             <span class="">
                 ${transport.description}
             </span>
        </li>
    </c:forEach>



</article>
</body>
</html>
