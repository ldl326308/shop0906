<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品管理</title>
    <style>
        img{
            width:150px;
            height:150px;
        }
    </style>


    <link rel="stylesheet" href="../css/bootstrap4.min.css">
</head>
<body>

<input type="button" id="btn_add_product" data-toggle='modal' data-target='#exampleModal_add' value="添加商品" class="btn btn-success" style="margin:10px;" />

<table   style="line-height:30px;text-align:center;margin:auto;" class="table table-bordered">
    <thead>
    <tr>
        <th scope="col">序号</th>
        <th style="width:400px;" scope="col">商品名称</th>
        <th scope="col">商品类型</th>
        <th scope="col">商品价格</th>
        <th scope="col">图片展示</th>
        <th scope="col">商品状态</th>
        <th scope="col">操作</th>
    </tr>
    </thead>
    <tbody id="tbody_product">
    </tbody>
</table>

<jsp:include page="add_product.jsp"/>

<script src="../js/layui.js"></script>
<script src="../js/jquery-3.3.1.min.js" ></script>
<script src="../js/bootstrap4.min.js"></script>
<script>

    var imgAddSrc,imgUpdSrc ="";
    $(function () {
       startQuery();

       //添加点击事件
        $("#btn_product_addd").on("click",function () {
           //获得数据
            var p_name = $("#p_name").val();
            var t_id = $("#t_id option:selected").val();
            var p_photo = imgAddSrc;
            var p_price = $("#p_price").val();
            var p_state = document.getElementById("p_state").checked==true?0:1;

            if(p_photo ==""){
                alert("请选择商品图片！");
                return;
            }

            // console.log(p_name,t_id,p_photo,p_price,p_state);

            $.ajax({
                type:"get",
                data:{"action":"add","p_name":p_name,"t_id":t_id,"p_photo":p_photo,"p_price":p_price,"p_state":p_state},
                url:"/type_productServlet",
                success:function (data) {
                    alert(data.msg);
                    startQuery();  //重新渲染数据
                    $("#btn_product_add_colse").click();  //模拟点击关闭弹框
                    var p_name = $("#p_name").val("");
                    var p_photo = $("#p_photo").attr("src","");
                    var p_price = $("#p_price").val("");
                    var p_state = document.getElementById("p_state").checked==true;
                },
                error:function (xhl) {
                    console.log(xhl);
                }
            });
        });

        //修改商品点击事件
        $("#tbody_product").on("click",".upd",function () {
           var p_id = $(this).prop("id");
           //查询数据
           $.ajax({
              type:"get",
              data:{"action":"info","p_id":p_id},
              url:"/type_productServlet",
              success:function (data) {
                    //   int p_id,int t_id, String t_name, String p_name,
                  //    BigDecimal p_price, String p_photo, int p_state
                $("#p_name_upd").val(data.p_name);
                $("#t_id_upd option[value='"+data.t_id+"']").attr("selected","selected");
                $("#p_price_upd").val(data.p_price);
                $("#p_photo_upd").prop("src","../"+data.p_photo);
                imgUpdSrc = data.p_photo;
                $("#p_id").val(data.p_id);
                if(data.p_state == 0){
                    $("#p_state_upd").attr("checked","checked");
                }else{
                    $("#p_state_upd2").attr("checked","checked");
                }


              } ,
               error:function (xhl) {
                   console.log(xhl);
               }
           });
        });


        //点击保存事件
        $("#btn_product_upd").on("click",function () {
           //获得数据
           var p_id = $("#p_id").val();
           var p_name =  $("#p_name_upd").val();
           var t_id =  $("#t_id_upd option:checked").prop("value");
           var p_price = $("#p_price_upd").val();
           var p_photo = imgUpdSrc;
           var p_state = document.getElementById("p_state_upd").checked==true?0:1;
            $.ajax({
               type:"get",
               data:{"action":"upd","p_id":p_id,"p_name":p_name,
                   "t_id":t_id,"p_price":p_price,"p_photo":p_photo,"p_state":p_state},
                url:"/type_productServlet",
                success:function (data) {
                    alert(data.msg);
                    $("#btn_product_upd_colse").click();
                    startQuery();  //数据渲染
                },
                error:function (xhl) {
                    console.log(xhl);
                }
            });
        });


    });


    function  startQuery() {

        // int p_id, String t_name, String p_name, BigDecimal p_price, String p_photo, int p_state
        $.ajax({
            type:"get",
            data:{"action":"queryAll"},
            url:"/type_productServlet",
            success:function (data) {
                var html = "";
                // int p_id, String t_name, String p_name, BigDecimal p_price, String p_photo, int p_state
                $.each(data,function (index,obj) {
                       html += " <tr>";
                    html += " <td scope='col'>"+(index+1)+"</td>";
                    html += " <td style='text-align:left;' scope='col'>"+obj.p_name+"</td>";
                    html += " <td  scope='col'>"+obj.t_name+"</td>";
                    html += " <td scope='col'>"+obj.p_price+"</td>";
                    html += " <td style='width:100px;height:100px;' scope='col'>" +
                        "<img style='width:100px;height:100px;' src='../"+obj.p_photo+"' /></td>";
                    html += " <td scope='col'>"+(obj.p_state==0?"正常":"下架")+"</td>";
                    html += "  <td scope='col'>" +
                        "<input type='button'  data-toggle='modal' data-target='#exampleModal_upd'  id='"+obj.p_id+"' class='btn btn-secondary upd' value='修改' /> " +
                        "</td>";
                    html += "  </tr>";
                });

                $("#tbody_product").html(html);

            },
            error:function (xhl) {
                console.log(xhl);
            }
        });

        //下拉框渲染
        $.ajax({
           type:"get",
           data:{"action":"queryAll"} ,
            url:"/typeServlet",
            success:function (data) {
                html = "";
                $.each(data,function (index,obj) {
                    html += "<option value='"+obj.t_id+"'>"+obj.t_name+"</option>";
                });
                $("#t_id").html(html);
                $("#t_id_upd").html(html);
            },
            error:function (xhl) {
                console.log(xhl);
            }
        });
    }

    layui.use('upload', function(){
        var $ = layui.jquery
            ,upload = layui.upload;

         upload.render({
            elem: '#test2'
            ,url: '/UploadFile'
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#p_photo_upd').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code > 0){
                    return layer.msg('上传失败');
                }
                //上传成功
                layer.msg(res.msg);
                imgUpdSrc = res.data.src; //图片名
                // alert(imgAddSrc);
            }
            ,error: function(){
                alert("上传失败！")
            }
        });


        upload.render({
            elem: '#test1'
            ,url: '/UploadFile'
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#p_photo').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code > 0){
                    return layer.msg('上传失败');
                }
                //上传成功
                layer.msg(res.msg);
                imgAddSrc = res.data.src; //图片名
                // alert(imgAddSrc);
            }
            ,error: function(){
                alert("上传失败！")
            }
        });

    });


    $('#exampleModal_add').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var recipient = button.data('whatever')
        var modal = $(this)
        //modal.find('.modal-title').text('New message to ' + recipient)
        modal.find('.modal-body input').val(recipient)
    });

    $('#exampleModal_upd').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var recipient = button.data('whatever')
        var modal = $(this)
        //modal.find('.modal-title').text('New message to ' + recipient)
        modal.find('.modal-body input').val(recipient)
    });

</script>
</body>
</html>
