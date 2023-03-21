<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" href="https://salespoint.com.ng/app/images/logo.png">
    <title>Jackson Store</title>
    <link rel="stylesheet" href="css/mystyle.css" />
    <link rel="stylesheet" href="css/all.css" />
    <link rel="stylesheet" href="css/style.css" />
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/main.js"></script>
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>

   <div id="app" class="app-main display justify-content align-items flex-direction">
       <div class="wi-100 display he-100 display justify-space-around">
           <img src="https://salespoint.com.ng/app/images/logo.png" width="100" />
           <nav class=" display justify-space-around  align-items he-100">
               <a href="">Home</a>
               <a href="${pageContext.request.contextPath}/register.jsp">Register</a>
           </nav>


       </div>
       <div class="wi-100 app display justify-content align-items">

           <div class="app-design flex-direction display justify-content align-items">

           </div>
       </div>

   </div>

</body>
</html>