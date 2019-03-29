<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


    <title>VoteS</title>
</head>
<body>
<c:if test="${polling != null}">
<h1>Polling</h1>
<h3>${polling.name}</h3>
<hr>

<table border="1" id="votes">

    <tr>
        <th>Name</th>
        <th>Action</th>

    </tr>

    <c:forEach items="${polling.list}" var="category">


        <tr>

            <td>${category.name}</td>
            <td><a href="/vote/${polling.link}/${category.id}">Vote</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="../../">Back</a>
</c:if>


<c:if test="${browse != null}">

<h1>Result of voting</h1>
<h3>${browse.name}</h3>
<hr>

<table border="1" id="votes">
        <tr>
            <th>Name</th>
            <th>Number of voices</th>
        </tr>

    <c:forEach items="${browse.list}" var="category">
        <tr>
            <td>${category.name}</td>
            <td>${category.count}</td>
        </tr>
    </c:forEach>
</table>
<c:if test="${browse.status == false}"><h2 style="color: red">Voting is over</h2></c:if>

<br>
<a href="../../">Back</a>
</c:if>

<br/>
<br/>