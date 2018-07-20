<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Country Application</title>
</head>
<body>
    <center>
        
        <h2>
            <a href="/new">Add New Country</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Country</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Countries</h2></caption>
            <tr>
                <th>CountryID</th>
                <th>CountryName</th>
                <th>CountryAbbr</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="country" items="${listCountry}">
                <tr>
                    <td><c:out value="${country.country_id}" /></td>
                    <td><c:out value="${country.country_name}" /></td>
                    <td><c:out value="${country.country_abbr}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${country.country_id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${country.country_id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>
