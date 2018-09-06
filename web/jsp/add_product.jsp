<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../css/bootstrap4.min.css" >
<div class="modal fade" id="exampleModal_add" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel2" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div style="width:750px;" class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel2">添加商品</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <div class="form-group row">
                    <label for="p_name" class="col-sm-2 col-form-label">商品描述</label>
                    <div class="col-sm-10">
                    <textarea id="p_name" class="form-control"  rows="3"></textarea>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="t_id" class="col-sm-2 col-form-label">商品类型</label>
                    <div class="col-sm-10">
                        <select id="t_id" class="form-control">
                        </select>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="p_price" class="col-sm-2 col-form-label">商品价格</label>
                    <div class="col-sm-10">
                        <input type="number" autocomplete="off" class="form-control" id="p_price" placeholder="商品价格">
                    </div>
                </div>



                <div class="form-group row">
                    <label for="p_photo" class="col-sm-2 col-form-label">图片上传</label>
                    <div class="col-sm-10">
                        <button type="button" class="btn btn-success" id="test1">图片上传</button>
                        <div>
                            <img style="margin-left:130px;margin-top:-35px;width:100px;height:100px;" id="p_photo">
                        </div>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="s" class="col-sm-2 col-form-label">商品状态</label>
                    <div id="s" class="col-sm-10">
                        <input name="state" id="p_state" type="radio" checked  value="0" />上架
                        <input name="state" type="radio" value="1" />下架
                    </div>
                </div>


            </div>
            <div class="modal-footer">
                <button type="button" id="btn_product_addd" class="btn btn-primary">添加</button>
                <button type="button" id="btn_product_add_colse" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>



<div class="modal fade" id="exampleModal_upd" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel3" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div style="width:750px;" class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel3">商品信息修改</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <div class="form-group row">
                    <label for="p_name_upd" class="col-sm-2 col-form-label">商品描述</label>
                    <div class="col-sm-10">
                        <textarea id="p_name_upd" class="form-control" rows="3"></textarea>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="t_id_upd" class="col-sm-2 col-form-label">商品类型</label>
                    <div class="col-sm-10">
                        <select id="t_id_upd" class="form-control">
                        </select>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="p_price_upd" class="col-sm-2 col-form-label">商品价格</label>
                    <div class="col-sm-10">
                        <input type="number" autocomplete="off" class="form-control" id="p_price_upd" placeholder="商品价格">
                    </div>
                </div>



                <div class="form-group row">
                    <label for="p_photo_upd" class="col-sm-2 col-form-label">图片上传</label>
                    <div class="col-sm-10">
                        <button type="button" class="btn btn-success" id="test2">图片上传</button>
                        <div>
                            <img style="margin-left:130px;margin-top:-35px;width:100px;height:100px;" id="p_photo_upd">
                        </div>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="ss" class="col-sm-2 col-form-label">商品状态</label>
                    <div id="ss" class="col-sm-10">
                        <input name="state" id="p_state_upd"  type="radio" value="0" />上架
                        <input id="p_state_upd2" name="state" type="radio" value="1" />下架
                    </div>
                </div>

                <input type="hidden" id="p_id" />

            </div>
            <div class="modal-footer">
                <button type="button" id="btn_product_upd" class="btn btn-primary">保存</button>
                <button type="button" id="btn_product_upd_colse" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

