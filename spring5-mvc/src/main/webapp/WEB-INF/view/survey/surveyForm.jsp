<%--
  Created by IntelliJ IDEA.
  User: hclee
  Date: 2022-01-05
  Time: 오후 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
    <title>설문조사</title>
</head>
<body>
    <h2>설문조사</h2>
    <form method="post">
        <c:forEach var="question" items="${questions}" varStatus="status">
            <p>
                ${status.index + 1}. ${question.title}<br/>
                <c:if test="${question.choice}">
                    <c:forEach var="option" items="${question.options}">
                        <label><input type="radio" name="responses[${status.index}]" value="${option}">${option}</label>
                    </c:forEach>
                </c:if>
            </p>
        </c:forEach>
        <p>
            <label>응답자 위치:<br/>
                <input type="text" name="res.location">
            </label>
        </p>
        <p>
            <label>응답자 나이:<br/>
                <input type="text" name="res.age">
            </label>
        </p>
        <input type="submit" value="전송">
    </form>
</body>
</html>
