<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<head>
    <title>Edit Visitor's Information</title>
</head>
<body>
    <h1>Please make corrections!</h1>
    
    <p>
        <form:errors path="aSingleVisitor.*"/>
    </p>

    <form:form action="/edit/${aSingleVisitor.id}" method="POST" modelAttribute="aSingleVisitor">
        <p>
            <form:label path="firstName">First Name: </form:label>
            <form:input path="firstName"/>
        </p>
        <p>
            <form:label path="lastName">Last Name: </form:label>
            <form:input path="lastName"/>
        </p>
        <p>
            <form:label path="invitationNumber">Invitation Number: </form:label>
            <form:input path="invitationNumber"/>
        </p>
        <p>
            <input type="submit" value="Update Visitor">
        </p>
    </form:form>

    <form action="/remove/${aSingleVisitor.id}" method="POST">
        <input type="submit" value="Delete">
    </form>

    <a href="/visitorwelcomescreen">Welcome Page</a>
</body>
</html>