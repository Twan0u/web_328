<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form" %>
<%@ include file="include/importTags.jsp" %>
<html>
<head>
    <style>
        :root {
            --input-padding-x: 1.5rem;
            --input-padding-y: .75rem;
        }

        body {
            background: #007bff;
            background: linear-gradient(to right, #0062E6, #33AEFF);
        }

        .card-signin {
            border: 0;
            border-radius: 1rem;
            box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }

        .card-signin .card-title {
            margin-bottom: 2rem;
            font-weight: 300;
            font-size: 1.5rem;
        }

        .card-signin .card-img-left {
            width: 45%;
            /* Link to your background image using in the property below! */
            background: scroll center url('https://source.unsplash.com/WEQbe2jBg40/414x512');
            background-size: cover;
        }

        .card-signin .card-body {
            padding: 2rem;
        }

        .form-signin {
            width: 100%;
        }

        .form-signin .btn {
            font-size: 80%;
            border-radius: 5rem;
            letter-spacing: .1rem;
            font-weight: bold;
            padding: 1rem;
            transition: all 0.2s;
        }

        .form-label-group {
            position: relative;
            margin-bottom: 1rem;
        }

        .form-label-group input {
            height: auto;
            border-radius: 2rem;
        }

        .form-label-group>input,
        .form-label-group>label {
            padding: var(--input-padding-y) var(--input-padding-x);
        }

        .form-label-group>label {
            position: absolute;
            top: 0;
            left: 0;
            display: block;
            width: 100%;
            margin-bottom: 0;
            /* Override default `<label>` margin */
            line-height: 1.5;
            color: #495057;
            border: 1px solid transparent;
            border-radius: .25rem;
            transition: all .1s ease-in-out;
        }

        .form-label-group input::-webkit-input-placeholder {
            color: transparent;
        }

        .form-label-group input:-ms-input-placeholder {
            color: transparent;
        }

        .form-label-group input::-ms-input-placeholder {
            color: transparent;
        }

        .form-label-group input::-moz-placeholder {
            color: transparent;
        }

        .form-label-group input::placeholder {
            color: transparent;
        }

        .form-label-group input:not(:placeholder-shown) {
            padding-top: calc(var(--input-padding-y) + var(--input-padding-y) * (2 / 3));
            padding-bottom: calc(var(--input-padding-y) / 3);
        }

        .form-label-group input:not(:placeholder-shown)~label {
            padding-top: calc(var(--input-padding-y) / 3);
            padding-bottom: calc(var(--input-padding-y) / 3);
            font-size: 12px;
            color: #777;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-10 col-xl-9 mx-auto">
            <div class="card card-signin flex-row my-5">
                <div class="card-img-left d-none d-md-flex">
                    <!-- Background image for card set in CSS! -->
                </div>
                <div class="card-body">
                    <h5 class="card-title text-center"><spring:message code="signUp"/></h5>
                    <form:form
                            id="userInscriptionForm"
                            method="POST"
                            action="/signUp/submit"
                            modelAttribute="newUser"
                            class="form-signin">

                    <div class="form-label-group">
                        <form:input path="first_name" type="text" class="form-control" required="required"/>
                        <form:errors path="first_name"/>
                        <label><spring:message code="firstName"/></label>
                    </div>
                    <div class="form-label-group">
                        <form:input path="last_name" type="text" class="form-control" required="required"/>
                        <form:errors path="last_name"/>
                        <label><spring:message code="lastName"/></label>
                    </div>
                    <div class="form-label-group">
                        <form:input path="username" type="text" class="form-control" required="required"/>
                        <form:errors path="username"/>
                        <label><spring:message code="username"/></label>
                    </div>
                    <div class="form-label-group">
                        <form:input path="email" id="mail" type="email" class="form-control" required="required"/>
                        <form:errors path="email"/>
                        <label>E-mail</label>
                        <script>
                            var email = document.getElementById("mail");
                            email.addEventListener("keyup",function (event) {
                                if (email.validity.typeMismatch){
                                    email.setCustomValidity("<spring:message code="EmailFormatError"/>")
                                }else{
                                    email.setCustomValidity("");
                                }
                            })
                        </script>
                    </div>

                        <hr>

                        <div class="form-label-group">
                            <form:input path="password" type="password" class="form-control" required="required"/>
                            <form:errors path="password"/>
                            <label><spring:message code="password"/></label>
                        </div>

                        <div class="form-label-group">
                            <form:input path="validationPassword" type="password" class="form-control" required="required"/>
                            <form:errors path="validationPassword"/>
                            <label><spring:message code="confirmPassword"/></label>
                        </div>

                        <hr>

                        <div class="form-label-group">
                            <form:input path="streetname" type="text" class="form-control" required="required"/>

                            <label><spring:message code="streetName"/></label>
                        </div>
                        <div class="form-label-group">
                            <form:input path="streetnumber" type="text" class="form-control" required="required"/>
                            <form:errors path="streetnumber"/>
                            <label><spring:message code="streetNumber"/></label>
                        </div>
                        <div class="form-label-group">
                            <form:input path="gender" type="text" class="form-control"/>
                            <form:errors path="gender"/>
                            <label><spring:message code="gender"/></label>
                        </div>
                        <div class="form-label-group">
                            <form:input path="phone_number" type="text" class="form-control" required="required"/>
                            <form:errors path="phone_number"/>
                            <label><spring:message code="phoneNumber"/></label>
                        </div>
                        <div class="form-label-group">
                            <form:input path="locality" type="text" class="form-control" required="required"/>
                            <form:errors path="locality"/>
                            <label><spring:message code="locality"/></label>
                        </div>
                        <div class="form-label-group">
                            <form:input path="postal_code" type="text" class="form-control" required="required"/>
                            <form:errors path="postal_code"/>
                            <label><spring:message code="postalCode"/></label>
                        </div>
                        <form:button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit"><spring:message code="signUp"/></form:button>
                      </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
