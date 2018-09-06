<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>类型信息</title>
    <style>

    </style>
</head>
<body>
<table style="text-align:center;" class="table table-bordered">
    <thead>
    <tr>
        <th scope="col">编号</th>
        <th scope="col">名称</th>
        <%--<th scope="col">操作</th>--%>
        <th style="text-align:left;" scope="col">
            <input type="button"  data-toggle='modal' data-target='#exampleModal_add' id="btn_type_add"  class="btn btn-success"  value="添加类型" />
        </th>
    </tr>
    </thead>
    <tbody id="tbody_type">
    </tbody>
</table>

<div class="modal fade" id="exampleModal_upd" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div style="width:650px;" class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">类型信息修改</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                    <div class="form-group row">
                        <label for="id_upd" class="col-sm-2 col-form-label">类型编号</label>
                        <div class="col-sm-10">
                            <input type="text" readonly class="form-control" id="id_upd">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="name_upd" class="col-sm-2 col-form-label">类型名称</label>
                        <div class="col-sm-10">
                            <input type="text" autocomplete="off" class="form-control" id="name_upd" placeholder="类型名称">
                        </div>
                    </div>

            </div>
            <div class="modal-footer">
                <button type="button" id="btn_type_Upd" class="btn btn-primary">修改</button>
                <button type="button" id="btn_type_close" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="exampleModal_add" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel2" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div style="width:650px;" class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel2">添加类型</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <div class="form-group row">
                    <label for="tname" class="col-sm-2 col-form-label">类型名称</label>
                    <div class="col-sm-10">
                        <input type="text" autocomplete="off" class="form-control" id="tname" placeholder="类型名称">
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" id="btn_type_addd" class="btn btn-primary">添加</button>
                <button type="button" id="btn_type_add_colse" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>



<script src="../js/jquery-3.3.1.min.js" ></script>
<script src="../js/bootstrap4.min.js"></script>
<script>

    //数据渲染
    $(function () {
        startQuery();  //渲染

        //删除点击事件绑定
        $("#tbody_type").on("click",".del",function () {
            var t_id = $(this).attr("data-id");  //获得id
            if(!window.confirm("确认删除吗？")){
                return false;
            }
            $.ajax({
                type:"get",
                data:{"action":"del","t_id":t_id},
                url:"/typeServlet",
                success:function (data) {
                    alert(data.msg);
                    startQuery();
                } ,
                error:function (xhl) {
                    console.log(xhl)
                }
            });
        });


        //修改点击事件绑定
        $("#tbody_type").on("click",".upd",function () {
            var t_id = $(this).attr("data-id");  //获得id

            $.ajax({
               type:"get",
               data:{"action":"info","t_id":t_id},
                url:"/typeServlet",
               success:function (data) {
                       console.log(data);
                      $("#id_upd").val(data.t_id);
                      $("#name_upd").val(data.t_name);
               } ,
                error:function (xhl) {
                    console.log(xhl)
                }
            });
        });

        //保存修改点击事件
        $("#btn_type_Upd").on("click",function () {
            var t_id = $("#id_upd").val();  //获得id
            var t_name = $("#name_upd").val();  //获得类型名称
            console.log(t_id+"   "+t_name);
            $.ajax({
                type:"get",
                data:{"action":"upd","t_id":t_id,"t_name":t_name},
                url:"/typeServlet",
                success:function (data) {
                    alert(data.msg);
                    //渲染
                    startQuery();
                    $("#btn_type_close").click(); //模拟点击事件

                } ,
                error:function (xhl) {
                    console.log(xhl)
                }
            });
        });

        //添加按钮点击事件
        $("#btn_type_addd").on("click",function () {
           var t_name = $("#tname").val();
           console.log(t_name);
           $.ajax({
              type:"get",
              data:{"action":"add","t_name":t_name},
               url:"/typeServlet",
               success:function (data) {
                   alert(data.msg);
                   $("#btn_type_add_colse").click();
                   startQuery();
               },
               error:function (xhl) {
                   console.log(xhl);
               }
           });
        });


    });

    $('#exampleModal_upd').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var recipient = button.data('whatever')
        var modal = $(this)
        //modal.find('.modal-title').text('New message to ' + recipient)
        modal.find('.modal-body input').val(recipient)
    })

    $('#exampleModal_add').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var recipient = button.data('whatever')
        var modal = $(this)
        //modal.find('.modal-title').text('New message to ' + recipient)
        modal.find('.modal-body input').val(recipient)
    })

    function startQuery(){
        $.ajax({
            type:"get",
            data:{"action":"queryAll"},
            url:"/typeServlet",
            success:function (data) {
                // int t_id,String t_name
                var html = "";
                $.each(data,function (index,obj) {
                    html += "<tr>";
                    html += "<td >"+obj.t_id+"</td>";
                    html += "<td>"+obj.t_name+"</td>";
                    // html += "<td><input type='button' data-toggle='modal' data-target='#exampleModal_upd' data-id='"+obj.t_id+"'  class='btn btn-dark upd' value='修改'/>" +
                    //     "<input type='button' style='margin-left:15px'  data-id='"+obj.t_id+"' class='btn btn-danger del' value='删除'/></td>";
                    html += " </tr>";
                });
                $("#tbody_type").html(html);
            },
            error:function (xhl) {
                console.log(xhl);
            }
        });
    }


</script>
</body>
</html>

