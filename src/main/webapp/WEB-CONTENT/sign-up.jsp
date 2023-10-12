<%--
  Created by IntelliJ IDEA.
  User: caomi
  Date: 10/10/2023
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register ExaQ Acoount</title>
    <%@include file="header.jsp" %>

</head>
<body>
<section class="vh-100" style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

                                <form class="form mx-1 mx-md-4" id="register" name="register" method="post" action="./register">

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <div class="row">
                                                <div class="col-4 form-outline">
                                                    <input name="firstName" type="text" id="firstName"
                                                           class="form-control" placeholder="First Name"  autocomplete="off"/>
                                                    <label class="form-label" for="firstName">First Name</label>
                                                    <small></small>
                                                </div>
                                                <div class="col-8 form-outline">
                                                    <input name="lastName" type="text" id="lastName"
                                                           class="form-control" placeholder="Last Name"  autocomplete="off"/>
                                                    <label class="form-label" for="lastName">Last Name</label>
                                                    <small></small>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input name="username" type="username" id="username" class="form-control" autocomplete="off"/>
                                            <label class="form-label" for="username">Your Username</label>
                                            <small></small>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input name="password" type="password" id="password" class="form-control" autocomplete="off"/>
                                            <label class="form-label" for="password">Password</label>
                                            <small></small>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input name="confirmPassword" type="password" id="confirmPassword"
                                                   class="form-control" autocomplete="off"/>
                                            <label class="form-label" for="confirmPassword">Confirm your
                                                password</label>
                                            <small></small>
                                        </div>
                                    </div>

                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="submit" class="btn btn-primary btn-lg" value="Sign up">Register</button>
                                    </div>

                                </form>

                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                                     class="img-fluid" alt="Sample image">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script>
    const firstName = document.querySelector('#firstName');
    const lastName = document.querySelector('#lastName');
    const usernameEl  = document.querySelector('#username');
    const passwordEl  = document.querySelector('#password');
    const passwordLength = password.length;
    const confirmPasswordEl  = document.querySelector('#confirmPassword');
    const form = document.querySelector('#register');


    form.addEventListener('submit', function (e) {
        // prevent the form from submitting
        e.preventDefault();

    });

    const isRequired = value => value === '' ? false : true;
    const isBetween = (length, min, max) => length < min || length > max ? false : true;

    const isEmailValid = (email) => {
        const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(email);
    };

    const isPasswordSecure = (password) => {
        const re = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
        return re.test(password);
    };

    const showError = (input, message) => {
        // get the form-field element
        const formField = input.parentElement;
        // add the error class
        formField.classList.remove('success');
        formField.classList.add('error');

        // show the error message
        const error = formField.querySelector('small');
        error.textContent = message;
    };


    const showSuccess = (input) => {
        // get the form-field element
        const formField = input.parentElement;

        // remove the error class
        formField.classList.remove('error');
        formField.classList.add('success');

        // hide the error message
        const error = formField.querySelector('small');
        error.textContent = '';
    }

    const checkUsername = () => {

        let valid = false;
        const min = 3,
            max = 25;
        const username = usernameEl.value.trim();

        if (!isRequired(username)) {
            showError(usernameEl, 'Username cannot be blank.');
        } else if (!isBetween(username.length, min, max)) {
            showError(usernameEl, `Username must be between ${min} and ${max} characters.`)
        } else {
            showSuccess(usernameEl);
            valid = true;
        }
        return valid;
    }

    const checkPassword = () => {

        let valid = false;

        const password = passwordEl.value.trim();

        if (!isRequired(password)) {
            showError(passwordEl, 'Password cannot be blank.');
        } else if (!isPasswordSecure(password)) {
            showError(passwordEl, 'Password must has at least 8 characters that include at least 1 lowercase character, 1 uppercase characters, 1 number, and 1 special character in (!@#$%^&*)');
        } else {
            showSuccess(passwordEl);
            valid = true;
        }

        return valid;
    };


    const checkConfirmPassword = () => {
        let valid = false;
        // check confirm password
        const confirmPassword = confirmPasswordEl.value.trim();
        const password = passwordEl.value.trim();

        if (!isRequired(confirmPassword)) {
            showError(confirmPasswordEl, 'Please enter the password again');
        } else if (password !== confirmPassword) {
            showError(confirmPasswordEl, 'Confirm password does not match');
        } else {
            showSuccess(confirmPasswordEl);
            valid = true;
        }

        return valid;
    };


    form.addEventListener('submit', function (e) {
        // prevent the form from submitting
        e.preventDefault();

        // validate forms
        let isUsernameValid = checkUsername(),
            isPasswordValid = checkPassword(),
            isConfirmPasswordValid = checkConfirmPassword();

        let isFormValid = isUsernameValid &&
            isPasswordValid &&
            isConfirmPasswordValid;

        // submit to the server if the form is valid
        if (isFormValid) {
        //
        form.submit();
        }

    });

    form.addEventListener('input', function (e) {
        switch (e.target.id) {
            case 'username':
                checkUsername();
                break;
            case 'password':
                checkPassword();
                break;
            case 'confirm-password':
                checkConfirmPassword();
                break;
        }
    });

    const debounce = (fn, delay = 500) => {
        let timeoutId;
        return (...args) => {
            // cancel the previous timer
            if (timeoutId) {
                clearTimeout(timeoutId);
            }
            // setup a new timer
            timeoutId = setTimeout(() => {
                fn.apply(null, args)
            }, delay);
        };
    };

    form.addEventListener('input', debounce(function (e) {
        switch (e.target.id) {
            case 'username':
                checkUsername();
                break;
            case 'password':
                checkPassword();
                break;
            case 'confirm-password':
                checkConfirmPassword();
                break;
        }
    }));


</script>

</body>
</html>
