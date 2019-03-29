<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


    <title>Votes</title>
</head>
<body>
<h1>Votes</h1>
<hr>

<table border="1" id="votes">
    <tr>
        <th>№</th>
        <th>Name</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${listVotes}" var="list">
        <tr>
            <td>${list.id}</td>
            <c:if test="${list.status == true}">
            <td><a href="/vote/${list.link}">${list.name}</a></td>
            <td>
                <a href="/${list.id}">View totals</a>
                <a href="/status/${list.id}">Stop</a>
            </td>
                </c:if>

                <c:if test="${list.status == false}">
            <td>${list.name}</td>
            <td>
                <a href="/${list.id}">View totals</a>
                <a href="/status/${list.id}">Start</a>
            </td>
                </c:if>

        </tr>
    </c:forEach>
</table>
<br/>
<br/>

<div class="form">


        Add voting:

        <form:form action="/add" id="form" modelAttribute="vote">
            <table>
                <tr>
                    <td>Name</td>

                    <td><form:input id="name" maxlength="25" required="1" path="name"></form:input>
                    <td></td>
                </tr>
                <tr>
                    <td>Question1:</td>

                    <td><input name="categogyName"/>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>Question2:</td>

                    <td><input name="categogyName"/>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>Question3:</td>

                    <td><input name="categogyName"/>
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td>Question4:</td>

                    <td><input name="categogyName"/>
                    </td>
                    <td></td>
                </tr>


                <td></td>
                <td></td>
                <td><input type="Submit" value="Submit" id="new"></td>
                </tr>


            </table>
        </form:form>
    

</div>


</body>
</html>

