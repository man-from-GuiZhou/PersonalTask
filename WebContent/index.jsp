<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>
<script src="js/index.js"></script>
<title>首页</title>
</head>
<body>
<table>
	<caption>库文件全貌</caption>
	<thead>
		<tr>
			<th>PlayerID</th><th>PlayerName</th><th>密码</th><th>exp</th><th>用户功能</th>
		</tr>   
	</thead>
	<tbody> 
		<c:forEach var="profile" items="${profileList}">
			<tr>
				<td>${profile.playerId}</td><td>${profile.playerName}</td><td>${profile.password}</td><td>${profile.exp}</td>
				<td>
				<span><!-- <a href="PlayerEdit?operate='remove'&PlayerId=${profile.playerId}">删除这个用户</a> -->
				<a href="" class="remove">删除这个用户</a>
				</span>
				<span><a href="PlayerEdit?operate='updatePage'&Player=${profile}">修改这个用户</a></span>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="PlayerEdit.jsp">增加用户</a>
</body>
</html>