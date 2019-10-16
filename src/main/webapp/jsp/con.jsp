<%--
  Created by IntelliJ IDEA.
  User: h
  Date: 2019/7/15
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

    <div class="tab-content tab-addtabs">
        <div id="content">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <section class="content-header hide">
                        <h1>
                            控制台
                        </h1>
                    </section>
                    <!-- END RIBBON -->
                    <div class="content">
                        <style type="text/css">

                            .sm-st {
                                background:#fff;
                                padding:20px;
                                -webkit-border-radius:3px;
                                -moz-border-radius:3px;
                                border-radius:3px;
                                margin-bottom:20px;
                                -webkit-box-shadow: 0 1px 0px rgba(0,0,0,0.05);
                                box-shadow: 0 1px 0px rgba(0,0,0,0.05);
                            }

                            .sm-st-icon {
                                width:60px;
                                height:60px;
                                display:inline-block;
                                line-height:60px;
                                text-align:center;
                                font-size:30px;
                                background:#eee;
                                -webkit-border-radius:5px;
                                -moz-border-radius:5px;
                                border-radius:5px;
                                float:left;
                                margin-right:10px;
                                color:#fff;
                            }
                            .sm-st-info {
                                font-size:12px;
                                padding-top:2px;
                            }
                            .sm-st-info span {
                                display:block;
                                font-size:24px;
                                font-weight:600;
                            }

                            .st-red {
                                background-color: #F05050;
                            }
                            .st-green {
                                background-color: #27C24C;
                            }
                            .st-violet {
                                background-color: #7266ba;
                            }
                            .st-blue {
                                background-color: #23b7e5;
                            }
                            .st-yellow{
                                background: yellow;
                            }



                        </style>
                        <div class="panel panel-default panel-intro">

                            <div class="panel-heading">
                                <div class="panel-lead">控制台</div>
                            </div>

                            <div class="panel-body">
                                <div id="myTabContent" class="tab-content">
                                    <div class="tab-pane fade active in" id="one">

                                        <div class="row">

                                            <div class="col-sm-3 col-xs-6">
                                                <div class="sm-st clearfix">
                                                    <span class="sm-st-icon st-red"><i class="glyphicon glyphicon-user"></i></span>
                                                    <div class="sm-st-info">
                                                        <span>5000</span>
                                                        商家总数                            </div>
                                                </div>
                                            </div>

                                            <div class="col-sm-3 col-xs-6">
                                                <div class="sm-st clearfix">
                                                    <span class="sm-st-icon st-violet"><i class="glyphicon glyphicon-user"></i></span>
                                                    <div class="sm-st-info">
                                                        <span>219390</span>
                                                        业务员总数                            </div>
                                                </div>
                                            </div>

                                            <div class="col-sm-3 col-xs-6">
                                                <div class="sm-st clearfix">
                                                    <span class="sm-st-icon st-blue"><i class="glyphicon glyphicon-shopping-cart"></i></span>
                                                    <div class="sm-st-info">
                                                        <span>32143</span>
                                                        总订单数                            </div>
                                                </div>
                                            </div>


                                            <div class="col-sm-3 col-xs-6">
                                                <div class="sm-st clearfix">
                                                    <span class="sm-st-icon st-green"><i class="glyphicon glyphicon-usd"></i></span>
                                                    <div class="sm-st-info">
                                                        <span>174800</span>
                                                        总金额
                                                    </div>

                                                </div>
                                            </div>

                                        </div>

                                        <div class="row">

                                            <div class="col-sm-3 col-xs-6">
                                                <div class="sm-st clearfix">
                                                    <span class="sm-st-icon st-blue"><i class="glyphicon glyphicon-shopping-cart"></i></span>
                                                    <div class="sm-st-info">
                                                        <span>35200</span>
                                                        当月订单数                            </div>
                                                </div>
                                            </div>

                                            <div class="col-sm-3 col-xs-6">
                                                <div class="sm-st clearfix">
                                                    <span class="sm-st-icon st-green"><i class="glyphicon glyphicon-usd"></i></span>
                                                    <div class="sm-st-info">
                                                        <span>219390</span>
                                                        当月订单金额                           </div>
                                                </div>
                                            </div>

                                            <div class="col-sm-3 col-xs-6">
                                                <div class="sm-st clearfix">
                                                    <span class="sm-st-icon st-blue"><i class="glyphicon glyphicon-ok-sign"></i></span>
                                                    <div class="sm-st-info">
                                                        <span>32143</span>
                                                        当月已审核商家                            </div>
                                                </div>
                                            </div>


                                            <div class="col-sm-3 col-xs-6">
                                                <div class="sm-st clearfix">
                                                    <span class="sm-st-icon st-yellow"><i class="glyphicon glyphicon-question-sign"></i></span>
                                                    <div class="sm-st-info">
                                                        <span>174800</span>
                                                        当月待审核商家
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
    </div>



