<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Danh sach ung vien</h2>
<a href="${pageContext.request.contextPath}/addCandidate">Them ung vien</a>
<br>
<table>
<tr>
<th>FirstName</th>
<th>LastName</th>
<th>BirthDate</th>
<th>Address</th>
<th>Phone</th>
<th>Email</th>
<th>typeOfCandidate</th>
</tr>
<c:forEach items="${list}" var="c">
<tr>
<td>${c.firstName}</td>
<td>${c.lastName}</td>
<td>${c.birthDate}</td>
<td>${c.address}</td>
<td>${c.phone}</td>
<td>${c.email}</td>
<td>${c.typeOfCandidate}</td>
</tr>
</c:forEach>
</table>

</body>
</html>