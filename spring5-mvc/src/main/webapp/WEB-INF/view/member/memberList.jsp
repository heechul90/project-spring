<%--
  Created by IntelliJ IDEA.
  User: hclee
  Date: 2022-01-31
  Time: 오후 4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<head>
    <title>회원 조회</title>
</head>
<body>
    <form:form modelAttribute="cmd">
        <p>
            <label>from: <form:input path="from" /></label>
            ~
            <label>to: <form:input path="to" /></label>
            <input type="submit" value="조회">
        </p>
    </form:form>

    <c:if test="${!empty members }">
        <table>
            <tr>
                <th>아이디</th>
                <th>이메일</th>
                <th>이름</th>
                <th>가입일</th>
            </tr>
            <c:forEach var="member" items="${members}">
                <tr>
                    <td>${member.id}</td>
                    <td><a href="<c:url value="/members/${member.id}"/>">${member.email}</a></td>
                    <td>${member.name}</td>
                    <td><tf:formatDateTime value="${member.registerDateTime}" pattern="yyyy-MM-dd" /></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
