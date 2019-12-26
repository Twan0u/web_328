<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
</head>
<body>
User inscription :
<form:form
        id="userInscriptionForm"
        method="POST"
        action="/signUp/submit"
        modelAttribute="newUser">
    <form:label path="first_name">First Name</form:label>
    <form:input path="first_name"/>
    <form:errors path="first_name"/>
    <form:label path="last_name">Last Name</form:label>
    <form:input path="last_name"/>
    <form:errors path="last_name"/>
    <form:label path="login">Login</form:label>
    <form:input path="login"/>
    <form:errors path="login"/>
    <form:label path="password">Password</form:label>
    <form:input path="password"/>
    <form:errors path="password"/>
    <c:if test = "${passwordMatch !=NULL}">${passwordMatch}</c:if>
    <form:label path="passwordBis">Password</form:label>
    <form:input path="passwordBis"/>
    <form:errors path="passwordBis"/>

    <form:label path="email">E-Mail</form:label>
    <form:input path="email"/>
    <form:errors path="email"/>
    <form:label path="streetname">Street name</form:label>
    <form:input path="streetname"/>
    <form:errors path="streetname"/>
    <form:label path="streetnumber">Street number</form:label>
    <form:input path="streetnumber"/>
    <form:errors path="streetnumber"/>
    <form:label path="gender">gender</form:label>
    <form:input path="gender"/>
    <form:errors path="gender"/>
    <form:label path="phone_number">Phone number</form:label>
    <form:input path="phone_number"/>
    <form:errors path="phone_number"/>
    <form:button>Submit</form:button>
</form:form>
</body>
</html>
