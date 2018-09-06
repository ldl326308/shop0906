<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
        <table style="text-align:center;" class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">序号</th>
                <th scope="col">账号</th>
                <th scope="col">密码</th>
                <th scope="col">电话</th>
                <th scope="col">邮箱</th>
            </tr>
            </thead>
            <tbody id="tbody_user">
            </tbody>
        </table>

<script src="../js/jquery-3.3.1.min.js" ></script>
<script>

    //数据渲染
    $(function () {
        $.ajax({
            type:"post",
            data:{"action":"queryAll"},
            url:"/userServlet",
            success:function (data) {
                // int u_id, String user_id, String user_pwd, String user_phone, String user_email
                var html = "";
                $.each(data,function (index,obj) {
                    html += "<tr>";
                    html += "<th scope='row'>"+(index+1)+"</th>";
                    html += "<td >"+obj.user_id+"</td>";
                    html += "<td>"+obj.user_pwd+"</td>";
                    html += "<td>"+obj.user_phone+"</td>";
                    html += "<td>"+obj.user_email+"</td>";
                    html += " </tr>";
                });
                $("#tbody_user").html(html);
            },
            error:function (xhl) {
                console.log(xhl);
            }
        });
    });


</script>
</body>
</html>
