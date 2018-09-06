<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>

    <title><sitemesh:title/></title>
    <link rel="stylesheet" href="../css/layui.css" media="all">
    <link href="../css/bootstrap4.min.css" rel="stylesheet">
    <link href="../css/offcanvas.css" rel="stylesheet">
</head>

<body class="bg-light">

    <%@include file="product_head_nva.jsp"%>

    <%@include file="product_body_nva.jsp"%>


    <main role="main" style="margin-top:0em;">
            <!--  这里会把要修饰的页面的body部分引入 -->
            <sitemesh:body></sitemesh:body>
    </main>

    <%@include file="product_footer.jsp"%>

</body>
</html>
