<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>柚飞约车系统</title>
<#include "headercss.ftl" />
    <style>
        .mui-input-group {
            margin-top: 10px;
        }

        .mui-input-group:first-child {
            margin-top: 20px;
        }

        .mui-input-group label {
            width: 22%;
        }

        .mui-input-row label~input,
        .mui-input-row label~select,
        .mui-input-row label~textarea {
            width: 78%;
        }

        .mui-checkbox input[type=checkbox],
        .mui-radio input[type=radio] {
            top: 6px;
        }

        .mui-content-padded {
            margin-top: 25px;
        }

        .mui-btn {
            padding: 10px;
        }

    </style>
</head>
<body>
<header class="mui-bar mui-bar-nav">
    <h1 class="mui-title">登录</h1>
</header>
<div class="mui-content">
    <form id='login-form' class="mui-input-group">
        <div class="mui-input-row">
            <label>账号</label>
            <input id='account' type="text" class="mui-input-clear mui-input" placeholder="请输入账号">
        </div>
        <div class="mui-input-row">
            <label>密码</label>
            <input id='password' type="password" class="mui-input-clear mui-input" placeholder="请输入密码">
        </div>
    </form>
    <#--<form class="mui-input-group">-->
        <#--<ul class="mui-table-view mui-table-view-chevron">-->
            <#--<li class="mui-table-view-cell">-->
                <#--自动登录-->
                <#--<div id="autoLogin" class="mui-switch">-->
                    <#--<div class="mui-switch-handle"></div>-->
                <#--</div>-->
            <#--</li>-->
        <#--</ul>-->
    <#--</form>-->
    <div class="mui-content-padded">
        <button id='login' class="mui-btn mui-btn-block mui-btn-primary">登录</button>
    </div>
</div>

<script>
    $("#login").click(function () {

        mui.ajax('/coachstudent/loginPost',{
            data:{
                username:'1',
                password:'admin'
            },
            dataType:'json',//服务器返回json格式数据
            type:'post',//HTTP请求类型
            timeout:10000,//超时时间设置为10秒；
            headers:{'Content-Type':'application/json'},
            success:function(data){
                console.log(data);
                mui.alert('登陆成功',"提示","确定",function(){},'div');
            },
            error:function(xhr,type,errorThrown){
                //异常处理；
                console.log(type);
            }
        });
    })
</script>

<#include "footer.ftl" />
</body>