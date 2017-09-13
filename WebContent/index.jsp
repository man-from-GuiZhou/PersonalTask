<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
test hello world
<table>
	<caption>库文件全貌</caption>
	<thead>
		<tr>
			<th>PlayerID</th><th>PlayerName</th><th>exp</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="profile" items="${profileList}">
			<tr>
				<td>${profile.playerId}</td><td>${profile.playerName}</td><td>${profile.Exp}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>