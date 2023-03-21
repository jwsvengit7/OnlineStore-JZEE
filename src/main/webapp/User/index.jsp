<%
    if(session.getAttribute("email") == null){
       response.sendRedirect("../register.jsp");
}

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link rel="icon" href="https://salespoint.com.ng/app/images/logo.png">
<title>Dashboard</title>
<link rel="stylesheet" href="../css/mystyle.css" />
<link rel="stylesheet" href="../css/all.css" />
<link rel="stylesheet" href="../css/style.css" />
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"
        integrity="sha512-AA1Bzp5Q0K1KanKKmvN/4d3IRKVlv9PYgwFPvm32nPO6QS8yH1HO7LbgB1pgiOxPtfeg5zEn2ba64MUcqJx6CA=="
        crossorigin="anonymous"
        referrerpolicy="no-referrer"></script>
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/main.js"></script>
</head>
<body>

<div>
    <header class="header-dashboard display justify-space-around">
        <div class="img-div">
            <img src="https://salespoint.com.ng/app/images/logo.png" width="100" />
        </div>
        <div class="row-nav display justify-content align-items">
            <a>Home</a>
            <a>Cart</a>
            <a>Product</a>
        </div>
    </header>
    <main class="main">

    </main>
</div>

</body>
</html>
