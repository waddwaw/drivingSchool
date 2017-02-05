<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <meta name="renderer" content="webkit">
    <meta name="applicable-device" content="pc,mobile">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta http-equiv="Cache-Control" content="no-transform"/>
    <meta name="format-detection" content="telephone=no,email=no,adress=no"/>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <link rel="icon" href="http://www.51bbw.cn/images/favicon.ico">
    <title>爱情树表白网页 -- 柚飞科技</title>
    <link rel="stylesheet" href="http://cdn.amazeui.org/amazeui/2.7.2/css/amazeui.min.css" type="text/css"/>
    <link rel="stylesheet" href="http://www.51bbw.cn/wp-content/themes/51bbw/style.css" type="text/css"/>
    <#--<script src="http://www.51bbw.cn/wp-content/themes/51bbw/js/jquery.min.js"></script>-->
    <script type="text/javascript" src="/html/js/jquery-1.11.1.min.js"></script>
    <script src="//cdn.bootcss.com/amazeui/2.7.2/js/amazeui.js"></script>
    <#--<script src="http://www.51bbw.cn/wp-content/themes/51bbw/js/index.js"></script>-->
    <#--<script type='text/javascript' src='http://www.51bbw.cn/wp-includes/js/jquery/jquery.js?ver=1.12.4'></script>-->
    <#--<script type='text/javascript'-->
            <#--src='http://www.51bbw.cn/wp-includes/js/jquery/jquery-migrate.min.js?ver=1.4.1'></script>-->
    <#--<link rel="canonical" href="http://www.51bbw.cn/show/130.html"/>-->
    <style>.nmsingle-container, .nms-list, .nmhotcom {
        max-width: 15 pxpx
    }</style>
    <style>.am-alert p {
        color: #fff
    }

    .single-content strong {
        margin-top: 0;
        color: #606060;
        font-size: 16px;
        font-weight: 700;
        border-left: 0;
        padding-left: 0;
        display: initial;
    }
    </style>
</head>
<body>
<div class="single-content">
    <form id="form" method="post" action="/lovePost">
        <input name="action" type="hidden" value="post"/>
        <input name="diyid" type="hidden" value="1"/>
        <input name="do" type="hidden" value="2"/>
        <!--/************你的名字S*****************/-->
        <div style="width:48%;float: left">
            <p class="input-t">你自己的名字 *</p>
            <input id="me" name="me" type="text" value="" maxlength="4" placeholder="" class="kuang"
                   required="required"/>
        </div>
        <!--/************你的名字E*****************/-->
        <!--/************ta的名字S*****************/-->
        <div style="width:48%;float: right">
            <p class="input-t">对方的名字 *</p>
            <input id="youname" name="youname" type="text" value="" maxlength="4" placeholder="" class="kuang"
                   required="required"/>
        </div>
        <!--/************ta的名字E*****************/-->
        <div class="am-cf"></div>
        <!--/************背景音乐S*****************/-->
        <p class="input-t">背景音乐</p>
        <input id="mp3" type="text" name="mp3" value="" maxlength="15" placeholder="从右侧下拉框中选择或输入网易云音乐ID"
               class="kuang bgfile"/>
        <select onchange="document.getElementById('mp3').value = '' + this.options[this.selectedIndex].value"
                class="bgselect">
            <option value="">表白页面背景音乐</option>
            <option value="165237">《丫头》----------------【王童语】</option>
            <option value="254141">《暖暖》----------------【梁静茹】</option>
            <option value="423226">《里山》------------【羽毛田丈史】</option>
            <option value="227958">《你就是》----------------【丁娜】</option>
            <option value="35847037">《多幸运》--------------【韩安旭】</option>
            <option value="35470197">《一次就好》------------【杨宗纬】</option>
            <option value="150430">《就是爱你》--------------【陶喆】</option>
            <option value="121165">《美丽女人》------------【刘嘉亮】</option>
            <option value="247512">《星月神话》--------------【金沙】</option>
            <option value="27836853">《因为爱情》------------【弗雷德】</option>
            <option value="2006865">《Only Love》------【Trademark】</option>
            <option value="34916642">《夏洛特烦恼》----------【金志文】</option>
            <option value="28029509">《咱们结婚吧》------------【齐晨】</option>
            <option value="27836179">《终于等到你》----------【张靓颖】</option>
            <option value="186197">《至少还有你》----------【周华健】</option>
            <option value="4877758">《真爱你的云》----------【黄国俊】</option>
            <option value="31168319">《一直在等你》------------【唐古】</option>
            <option value="33544372">《最想念的夏天》--------【白若溪】</option>
            <option value="213737">《Love Paradise》-------【陈慧琳】</option>
            <option value="5242432">《做我老婆好不好》--------【群星】</option>
            <option value="28306314">《全世界宣布爱你》--------【孙露】</option>
            <option value="97355">《人海中海遇见你》------【林育群】</option>
            <option value="403710391">《每次都想呼喊你的名字》--【赵传】</option>
            <option value="21116721">《Love To Be Loved By You》</option>
        </select>
        <!--/************背景音乐E*****************/-->
        <div class="am-cf"></div>
        <!--/************认识的时间S*****************/-->
        <p class="input-t">你们认识的大致时间 *</p>
        <input class="am-form-field" data-am-datepicker="{theme: 'success'}" id="time" name="time" placeholder="点击选择时间"
               class="kuang" readonly="readonly"/>
        <!--/************认识的时间E*****************/-->
        <!--/************说的话S*****************/-->
        <p class="input-t">对Ta说的第一句话 *</p>
        <input id="loveyi" name="showmian" type="text" value="" maxlength="200" placeholder="" class="kuang"
               required="required"/>
        <p class="input-t">第二句话 *</p>
        <input id="loveer" name="showmian2" type="text" value="" maxlength="200" placeholder="" class="kuang"
               required="required"/>
        <p class="input-t">第三句话 *</p>
        <input id="lovesan" name="showmian3" type="text" value="" maxlength="200" placeholder="" class="kuang"
               required="required"/>
        <p class="input-t">第四句话</p>
        <input id="lovesi" name="showmian4" type="text" value="" maxlength="200" placeholder="" class="kuang"/>
        <p class="input-t">第五句话</p>
        <input id="lovewu" name="showmian5" type="text" value="" maxlength="200" placeholder="" class="kuang"/>
        <p class="input-t">第六句话</p>
        <input id="loveliu" name="showmian6" type="text" value="" maxlength="200" placeholder="" class="kuang"/>
        <p class="input-t">第七句话</p>
        <input id="loveqi" name="showmian7" type="text" value="" maxlength="200" placeholder="" class="kuang"/>
        <p class="input-t">第八句话</p>
        <input id="loveba" name="showmian8" type="text" value="" maxlength="200" placeholder="" class="kuang"/>
        <p class="input-t">第九句话</p>
        <input id="lovejiu" name="showmian9" type="text" value="" maxlength="200" placeholder="" class="kuang"/>
        <!--/************说的话E*****************/-->
        <div class="am-cf"></div>
        <br/>
        <button type="button" class="am-btn am-btn-default am-btn-block" onclick="shuru()">我要使用默认文字</button>
        <script>
            function shuru() {
                var one = document.getElementById('loveyi');
                var two = document.getElementById('loveer');
                var three = document.getElementById('lovesan');
                var seven = document.getElementById('lovesi');
                var four = document.getElementById('lovewu');
                var five = document.getElementById('loveliu');
                var six = document.getElementById('loveqi');
                var eight = document.getElementById('loveba');
                var nine = document.getElementById('lovejiu');
                one.value = '你的出现，占满了我的视线，我愿跟随你永远';
                two.value = '自从遇见你那天开始，我的心就像跌进深深的湖水，推不开躲不掉，心一直想往你身上靠';
                three.value = '只要你愿意，当你失落失意的时候，需要一个肩膊的时候，告诉我，我会立即出现';
                seven.value = '之前我不相信一见钟情，但是见到你的那一刻，我否定了我的看法。我的心为你沦陷，从此只为你跳动';
                four.value = '有一种爱的感觉，叫感同身受。有一种爱的默契，叫心有灵犀。有一种爱的承诺，叫天长地久';
                five.value = '有一种爱的方式，是执子之手,与子携老';
                six.value = '莎士比亚说过：爱情是一种甜蜜的痛苦，但是我愿意忍受这种痛苦';
                eight.value = '莎士比亚还说过，世界上没有比服侍爱情更快乐的了，你愿不愿意享受这种快乐？';
                nine.value = 'I LOVE YOU';
            }
        </script>
        <!--/************网站标题S*****************/-->
        <p class="input-t">网站标题 *</p>
        <input id="lovetitle" name="lovetitle" type="text" value="" maxlength="14" placeholder="" class="kuang"
               required="required"/>
        <!--/************网站标题E*****************/-->
        <#--<input name="dede_fields" type="hidden"-->
               <#--value="me,text;youname,text;time,text;mp3,text;lovetitle,text;showmian,text;showmian2,text;showmian3,text;showmian4,text;showmian5,text;showmian6,text;showmian7,text;showmian8,text;showmian9,text;xabb,radio"/>-->
        <#--<input name="dede_fieldshash" type="hidden" value="2f36b90e8dd3bd197afeda8e8da3c152"/>-->
        <hr data-am-widget="divider" style="" class="am-divider am-divider-dashed"/>
        <div align="center">
            <p>
                <input class="am-btn am-btn-default" id="qingkong" name="qingkong" type="reset" value="清空重填"/>
                &nbsp;&nbsp;&nbsp;
                <input class="am-btn am-btn-secondary" name="submit" type="submit" value="数据提交"/></p>
        </div>
    </form>
</div>

</body>