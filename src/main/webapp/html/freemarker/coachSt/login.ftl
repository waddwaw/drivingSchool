<@compress single_line=true>
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

        var account = $("#account").val();
        var password = $("#password").val();

        if(account.length <= 0){
            mui.alert("用户名不正确！","登录失败","确定",function(){},'div');
            return ;
        }

        if(password <= 0){
            mui.alert("密码不正确！","登录失败","确定",function(){},'div');
            return ;
        }

        mui.ajax('/coachstudent/loginPost',{
            data:{
                username:account,
                password:password
            },
            dataType:'json',
            type:'post',
            timeout:10000,
            headers:{'Content-Type':'application/json'},
            success:function(data){
                if(data.data === 1) {
                    window.location.href = '/coachstudent/coach/index';
                    return;
                } else if(data.data === 2) {
                    window.location.href = '/coachstudent/student/index';
                    return;
                }
                mui.alert(data.message,"登录失败","确定",function(){},'div');
            },
            error:function(xhr,type,errorThrown){
                console.log(type);
                mui.alert('登录失败，稍后重试',"登录失败","确定",function(){},'div');
            }
        });
    })
</script>

<#include "footer.ftl" />
</body>
</html>
</@compress>