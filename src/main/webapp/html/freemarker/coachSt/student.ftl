<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学员预约</title>
<#include "headercss.ftl" />
    <script src="https://cdn.bootcss.com/vue/2.1.7/vue.js"></script>
    <link href="/html/css/student.css" rel="stylesheet"/>
</head>
<body>
<div style="width: 95vw; margin: 3vw auto">
    <div class="mui-content dsInfo" id="dsapp" style=" background-color: white">
        <div style="width: 30%; height: 30vw;  float: left; text-align: center">
            <img src="/html/img/aaa.jpg" style="width: 60%; height: 60%; margin: 22% auto"/>
        </div>
        <div style="width: 70%; height: 100%;  float: right; font-size: 10px ; padding-left:2vw ">
            <div style="text-align: center; margin-top: 2.5vw; margin-left: -10vw; font-size: 14px">
                <span style="margin: 0 auto" v-text="dsName"></span>
            </div>
            <div style=" margin-top: 0.7vw; width: 40%; float: left">
                <span style="margin: 0 auto">姓名：{{myCoach}}</span>
            </div>
            <div style=" margin-top: 0.7vw; width: 60%; float: right">
                <span style="margin: 0 auto">电话：{{phone}}</span>
            </div>
            <div style=" margin-top: 0.7vw; width: 40%; float: left">
                <span style="margin: 0 auto">等级：{{level}}</span>
            </div>
            <div style=" margin-top: 0.7vw; width: 60%; float: right">
                <span style="margin: 0 auto">好评率：{{comments}}</span>
            </div>
            <div style=" margin-top: 0.7vw; width: 100%; float: left; color:red">
                <span style="margin: 0 auto">通知：{{announcement}}</span>
            </div>
        </div>
    </div>

    <div class="mui-content">
        <div class="mui-row">
            <div class="mui-col-sm-6 mui-col-xs-6">
                <li class="mui-table-view-cell">
                    14:00 - 15:00
                </li>
            </div>
            <div class="mui-col-sm-6 mui-col-xs-6">
                <li class="mui-table-view-cell">
                    14:00 - 15:00
                </li>
            </div>
        </div>
    </div>
</div>
<#--<div id="app">-->
<#--{{ dsName }}-->
<#--</div>-->
<#--<div id="app-2">-->
<#--<span v-text="message">-->
<#--</span>-->
<#--</div>-->

<script>
    var studentModel = ${studentModel};
    <#--var student = ${student};-->
    <#--var appointment = ${appointment};-->

        var dsapp = new Vue({
            el: '#dsapp',
            data: studentModel
        })

    //
    //    var app2 = new Vue({
    //        el: '#app-2',
    //        data: {
    //            message: 'You loaded this page on ' + new Date()
    //        }
    //    })

</script>
<#include "footer.ftl" />
</body>