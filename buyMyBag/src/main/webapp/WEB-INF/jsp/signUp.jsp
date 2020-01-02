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
    <form:label path="username">Username</form:label>
    <form:input path="username"/>
    <form:errors path="username"/>
    <form:label path="password">Password</form:label>
    <form:input path="password"/>
    <form:errors path="password"/>
    <form:label path="validationPassword">Password</form:label>
    <form:input path="validationPassword"/>
    <form:errors path="validationPassword"/>
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
    <form:label path="locality">Locality</form:label>
    <form:input path="locality"/>
    <form:errors path="locality"/>
    <form:label path="postal_code">Postal code</form:label>
    <form:input path="postal_code"/>
    <form:errors path="postal_code"/>
    <form:button>Submit</form:button>
</form:form>
</body>
</html>
