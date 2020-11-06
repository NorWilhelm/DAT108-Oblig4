<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 05.11.2020
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet"
          href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
    <title>Deltagerliste</title>
</head>
<body>
<h2>Deltagerliste</h2>
<table class="pure-table">
    <tr bgcolor="#cccccc">
        <th>Kjønn</th>
        <th align="left">Navn</th>
        <th align="left">Mobil</th>
    </tr>
    <tr bgcolor="#aaffaa">
        <td align="center">&#9792;</td>
        <td>Anne Annesen</td>
        <td>445 54 455</td>
    </tr>
    <tr bgcolor="#ffffff">
        <td align="center">&#9794;</td>
        <td>Arne Arnesen</td>
        <td>901 23 456</td>
    </tr>
    <tr bgcolor="#ffffff">
        <td align="center">&#9794;</td>
        <td>Per Viskeler</td>
        <td>112 23 344</td>
    </tr>
</table>
<c:forEach var="row" value="${deltaker}">
    <h1>${deltaker.getFornavn}</h1>
</c:forEach>
<p>
    <a href="loggut">Ferdig</a>
</p>
</body>
</html>
