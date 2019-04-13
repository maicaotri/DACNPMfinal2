<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Them ung vien</h2>
<form action="${pageContext.request.contextPath}/addCandidate" method="post">
firstName<input name="firstName" type="text"> <br>
lastName<input name="lastName" type="text"> <br>
birthDate<input name="birthDate" type="number"> <br>
address<input name="address" type="text"> <br>
phone<input name="phone" type="text"> <br>
email<input name="email" type="text"> <br>
<select name="typeOfCandidate">
  <option value="Experience_candidate">Experience_candidate</option>
  <option value="Fresher_candidate">Fresher_candidate</option>
  <option value="Intern_candidate">Intern_candidate</option>
</select>
expInYear<input name="expInYear" type="number"> <br>
proSkill<input name="proSkill" type="text"> <br>
graduationDate<input name="graduationDate" type="date"> <br>
graduationRank<input name="graduationRank" type="text"> <br>
<select name="graduationRank">
  <option value="1">Excellence</option>
  <option value="2">Good</option>
  <option value="3">Fair</option>
  <option value="4">Poor</option>
</select>
education<input name="education" type="text"> <br>
majors<input name="majors" type="text"> <br>
semester<input name="semester" type="number"> <br>
universityName<input name="universityName" type="text"> <br>
<input type="submit" value="Submit">
</form>
<a href="${pageContext.request.contextPath}/">Danh sach ung vien</a>
</body>
</html>