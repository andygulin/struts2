<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title }</title>
</head>
<body>
<table border="1" width="50%"><tr><td>编号</td><td>姓名</td><td>年龄</td><td>生日</td></tr>
<c:forEach var="item" items="${users }">
<tr><td>${item.id }</td><td>${item.name }</td><td>${item.age }</td>
<td><fmt:formatDate value="${item.birthday }" pattern="yyyy-MM-dd"/></td>
</c:forEach>
</table>
</body>
</html>