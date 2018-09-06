<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有收货地址信息</title>
</head>
<body>

<table style="text-align: center;" class="table table-bordered">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">用户id</th>
        <th scope="col">收货人姓名</th>
        <th scope="col">电话</th>
        <th scope="col">收货地址</th>
    </tr>
    </thead>
    <tbody id="tbody_address">
    </tbody>
</table>

    <script src="../js/jquery-3.3.1.min.js"></script>
    <script>

        //数据渲染
        $(function () {
            $.ajax({
                type:"get",
                data:{"action":"all"},
                url:"/addressServlet",
                success:function (data) {
                    var html = "";
                    $.each(data,function (index,obj) {
                        html += " <tr> ";
                        html += " <td scope='col'>"+obj.a_id+"</td>";
                        html += " <td scope='col'>"+obj.a_u_id+"</td>";
                        html += "  <td scope='col'>"+obj.a_name+"</td>";
                        html += "  <td scope='col'>"+obj.a_phone+"</td>";
                        html += "  <td scope='col'>"+obj.a_address+"</td>";
                        html += "  </tr>";
                    });
                    $("#tbody_address").html(html);
                } ,
                error:function (xhl) {
                    console.log(xhl);
                }
            });
        });

    </script>
</body>
</html>
