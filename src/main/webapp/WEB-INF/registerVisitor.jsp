<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <style>
            table, th, td {
            border: 1px solid black;
            }

            th, td {
            padding: 10px;
            }
        </style>
    </head>
    <body> 
        <h1>Please register yourself.</h1>

        <p>
            <form:errors path="visitorObject.*"/>
        </p>

            <form:form action="/register" method="POST" modelAttribute="visitorObject">
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
                    <input type="submit" value="Register Visitor">
                </p>
            </form:form>

            <br>
        
        <a href="/visitorwelcomescreen">Welcome Page</a>

    </body>
    </html>