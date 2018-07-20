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
        <c:if test="${country != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${country == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${country != null}">
                        Edit Country
                    </c:if>
                    <c:if test="${country == null}">
                        Add New Country
                    </c:if>
                </h2>
            </caption>
                <c:if test="${country != null}">
                    <input type="hidden" name="country_id" value="<c:out value='${country.country_id}' />" />
                </c:if>           
            <tr>
                <th>CountryName: </th>
                <td>
                    <input type="text" name="country_name" size="45"
                            value="<c:out value='${country.country_name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>CountryAbbr: </th>
                <td>
                    <input type="text" name="country_abbr" size="45"
                            value="<c:out value='${country.country_abbr}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>