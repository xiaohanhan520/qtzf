<%--
  Created by IntelliJ IDEA.
  User: h
  Date: 2019/7/15
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!-- Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop -->
<div class="tab-content tab-addtabs">
    <div id="content">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                <!-- END RIBBON -->
                <div class="content">
                    <div class="panel panel-default panel-intro">
                        <div class="panel-heading">
                            <div class="panel-lead">常规管理</div>
                        </div>
                        <div class="panel-body">
                            <div>
                                <!-- Nav tabs -->
                                <ul class="nav nav-tabs" role="tablist">
                                    <li role="presentation" class="active"><a class="btn btn-info" href="#home" aria-controls="home"
                                                                              role="tab" data-toggle="tab">ISV设置</a></li>
                                    <li role="presentation"><a class="btn btn-info" href="#profile" aria-controls="profile" role="tab"
                                                               data-toggle="tab">提现设置</a></li>
                                    <li role="presentation"><a class="btn btn-info" href="#messages" aria-controls="messages" role="tab"
                                                               data-toggle="tab">支付宝设置</a></li>
                                    <li role="presentation"><a class="btn btn-info" href="#settings" aria-controls="settings" role="tab"
                                                               data-toggle="tab">分佣设置</a></li>
                                </ul>

                                <!-- Tab panes -->
                                <div class="tab-content">
                                    <div role="tabpanel" class="tab-pane active" id="home">
                                        <div class="row">
                                            <div class="col-md-1">
                                            <br>
                                            </div>
                                        </div>
                                        <div class="row">

                                            <div class="col-md-6">
                                                <form class="form-horizontal" method="post" action="#">
                                                    <div class="form-group">
                                                        <label for="pid" class="col-sm-2 control-label">pid</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="pid" placeholder="pid">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-offset-2 col-sm-10">
                                                            <button type="submit" class="btn btn-info">提交</button>
                                                            <button type="reset" class="btn btn-warning">重置</button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>

                                        </div>

                                    </div>


                                    <div role="tabpanel" class="tab-pane" id="profile">

                                        <div class="row">
                                            <div class="col-md-1">
                                                <br>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-8">

                                                <form class="form-horizontal" method="post" action="#">
                                                    <div class="form-group">
                                                        <label for="tmin" class="col-sm-2 control-label">提现最小值</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="tmin" placeholder="100">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="tmax" class="col-sm-2 control-label">提现最大值</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="tmax"
                                                                   placeholder="1000">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="sc" class="col-sm-2 control-label">手续费</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="sc" placeholder="8">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-offset-2 col-sm-10">
                                                            <button type="submit" class="btn btn-info">提交</button>
                                                            <button type="reset" class="btn btn-warning">重置</button>
                                                        </div>
                                                    </div>
                                                </form>

                                            </div>
                                        </div>
                                    </div>


                                    <div role="tabpanel" class="tab-pane" id="messages">

                                        <div class="row">
                                            <div class="col-md-1">
                                                <br>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-8">

                                                <form class="form-horizontal" method="post" action="#">
                                                    <div class="form-group">
                                                        <label for="appid" class="col-sm-2 control-label">app_id</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="appid"
                                                                   placeholder="90121002161722">
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label for="gy" class="col-sm-2 control-label">支付宝公钥</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="gy"
                                                                   placeholder="AQEFAAOCAQ8AMIIBCgK">
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label for="sy" class="col-sm-2 control-label">支付宝私钥</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="sy"
                                                                   placeholder="MIIBIjANBgkqhki">
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <div class="col-sm-offset-2 col-sm-10">
                                                            <button type="submit" class="btn btn-info">提交</button>
                                                            <button type="reset" class="btn btn-warning">重置</button>
                                                        </div>
                                                    </div>
                                                </form>

                                            </div>
                                        </div>
                                    </div>


                                    <div role="tabpanel" class="tab-pane" id="settings">

                                        <div class="row">
                                            <div class="col-md-1">
                                                <br>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-9">
                                                <form class="form-horizontal" method="post" action="#">
                                                    <div class="form-group">
                                                        <label for="dls" class="col-sm-2 control-label">代理商比例%</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="dls" placeholder="30">
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label for="ywy" class="col-sm-2 control-label">业务员比例%</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="ywy" placeholder="20">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="bb" class="col-sm-2 control-label">佣金拨比%</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="bb" placeholder="0.15">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-offset-2 col-sm-10">
                                                            <button type="submit" class="btn btn-info">提交</button>
                                                            <button type="reset" class="btn btn-warning">重置</button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
































