<%--
  Created by IntelliJ IDEA.
  User: hclee
  Date: 2022-01-01
  Time: 오후 6:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<head>
    <title><spring:message code="member.register"/></title>
</head>
<body>
    <h2><spring:message code="member.info"/></h2>
    <form:form modelAttribute="registerRequest" action="step3" method="post">
        <p>
            <label><spring:message code="email"/>:<br/>
                <form:input path="email"/>
            </label>
        </p>
        <p>
            <label><spring:message code="name"/>:<br/>
                <form:input path="name"/>
            </label>
        </p>
        <p>
            <label><spring:message code="password"/>:<br/>
                <form:password path="password"/>
            </label>
        </p>
        <p>
            <label><spring:message code="password.confirm"/>:<br/>
                <form:password path="confirmPassword"/>
            </label>
        </p>
        <input type="submit" value="<spring:message code="register.btn"/>">
    </form:form>

</body>
</html>
