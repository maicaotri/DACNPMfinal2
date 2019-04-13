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
${mess}
<h2>Chọn đợt tuyển và ứng viên</h2>
<a href="${pageContext.request.contextPath}/">Trở về</a>
<br>
<form action="${pageContext.request.contextPath}/addCanditateToRecruiment" method="get">
Chọn đợt tuyển:
<select name="idRecruiment">
<c:forEach items="${listrecruiment}" var="r">
  <option value="${r.recruitmentCode}">${r.recruitmentCode}-${r.position}-${r.numberOfCandidates}</option>
  </c:forEach>
</select>
<br>
Chọn ứng  viên:
<select name="idCanditate">
<c:forEach items="${listCandidate}" var="c">
  <option value="${c.id}">${c.firstName} ${c.lastName}-${c.typeOfCandidate}</option>
  </c:forEach>
</select>
<br>
<input type="submit" value="Submit">
</form>

</body>
</html>