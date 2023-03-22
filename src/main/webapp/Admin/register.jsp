<%
    if(session.getAttribute("email") != null){
        response.sendRedirect("User/index.jsp");
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" href="https://salespoint.com.ng/app/images/logo.png">
    <title>Login - Store</title>
    <link rel="stylesheet" href="css/mystyle.css" />
    <link rel="stylesheet" href="css/all.css" />
    <link rel="stylesheet" href="css/style.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js" integrity="sha512-AA1Bzp5Q0K1KanKKmvN/4d3IRKVlv9PYgwFPvm32nPO6QS8yH1HO7LbgB1pgiOxPtfeg5zEn2ba64MUcqJx6CA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/main.js"></script>
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>

<div id="app" class="app-main display justify-content align-items flex-direction">

    <div class="wi-100 app display justify-content align-items">

        <form action="${pageContext.request.contextPath}/RegisterController" method="POST" id="signup" class="login-form flex-direction display justify-content">
            <div class="wi-100 display he-100 display justify-space-around">
                <img src="https://salespoint.com.ng/app/images/logo.png" width="100" />

            </div>
            <label class="goldenrod">Username</label>
            <div class="form-row">
                <span class="fa fa-user f17 goldenrod"></span>
                <label>
                    <input type="text" id="username" name="username" placeholder="Enter your Username" />
                </label>
            </div>
            <label class="goldenrod">Email</label>
            <div class="form-row">
                <span class="fa fa-envelope f17 goldenrod"></span>
                <label>
                    <input type="email" id="email" name="email" placeholder="Enter your Email" />
                </label>
            </div>
            <label class="goldenrod">Password</label>
            <div class="form-row">
                <span class="fa fa-lock f17 goldenrod"></span>
                <label>
                    <input type="password" id="password" name="password" placeholder="Enter your Password" />
                </label>
            </div>
            <label class="goldenrod">Confirm Password</label>
            <div class="form-row">
                <span class="fa fa-lock f17 goldenrod"></span>
                <label>
                    <input type="password" id="confirm_password" name="confirm_password" placeholder="Re Enter Password" />
                </label>
            </div>
            <button type="submit" name="submit">Create Account</button>
            <div class="display wi-100 ">
                <span class="pad-10 goldenrod">Already have an Account <a class="pad-left-10 goldenrod cursor" id="login_user">Sign In</a></span>
            </div>
        </form>



        <form action="${pageContext.request.contextPath}/LoginController" method="post" id="login" class="login-form flex-direction display justify-content" style="display:none">
            <div class="wi-100 display he-100 display justify-space-around">
                <img src="https://salespoint.com.ng/app/images/logo.png" width="100" />

            </div>

            <label class="goldenrod">Email</label>
            <div class="form-row">
                <span class="fa fa-envelope f17 goldenrod"></span>
                <label>
                    <input type="email" id="email_user" name="email" placeholder="Enter your Email" />
                </label>
            </div>
            <label class="goldenrod">Password</label>
            <div class="form-row">
                <span class="fa fa-lock f17 goldenrod"></span>
                <label>
                    <input type="password" id="password_lock" name="password" placeholder="Enter your Password" />
                </label>
            </div>

            <button type="submit" name="submit">Login</button>
            <div class="display wi-100 ">
                <span class="pad-10 goldenrod">Don't have an Account <a class="pad-left-10 goldenrod cursor" id="signin_user">Signup</a></span>
            </div>
        </form>
    </div>
    <div class="rgb justify-content align-items">
        <img src="images/preloader-white.png" id="img" width="100"/>
    </div>
</div>


</body>
</html>
