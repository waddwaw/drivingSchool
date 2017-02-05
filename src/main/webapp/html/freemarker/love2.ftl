<!DOCTYPE HTML>

<head><meta content="IE=11.0000" http-equiv="X-UA-Compatible">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="keywords" content="本表白网页在线生成来自 柚飞科技" />
    <meta name="description" content="你的出现，占满了我的视线，我愿跟随你永远" />
    <title> ${love.lovetitle} </title>
<body>
<link href="http://i.51bbw.cn/zxsc/1314/shuju/default.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="http://i.51bbw.cn/mp3/css/cuplayer.css">
<link rel="icon" href="http://www.51bbw.cn/images/favicon.ico">
<script src="http://i.51bbw.cn/zxsc/1314/shuju/jquery.min.js" type="text/javascript"></script>
<script src="http://i.51bbw.cn/zxsc/1314/shuju/jscex.min.js" type="text/javascript"></script>
<script src="http://i.51bbw.cn/zxsc/1314/shuju/jscex-parser.js" type="text/javascript"></script>
<script src="http://i.51bbw.cn/zxsc/1314/shuju/jscex-jit.js" type="text/javascript"></script>
<script src="http://i.51bbw.cn/zxsc/1314/shuju/jscex-builderbase.min.js" type="text/javascript"></script>
<script src="http://i.51bbw.cn/zxsc/1314/shuju/jscex-async.min.js" type="text/javascript"></script>
<script src="http://i.51bbw.cn/zxsc/1314/shuju/jscex-async-powerpack.min.js" type="text/javascript"></script>
<script src="http://i.51bbw.cn/zxsc/1314/shuju/functions.js" type="text/javascript" charset="utf-8"></script>
<script src="http://i.51bbw.cn/zxsc/1314/shuju/love.js" type="text/javascript" charset="utf-8"></script>

<STYLE type="text/css">
    <!--
    .STYLE1 {color: #666666;font-family:"微软雅黑"}
    -->
</STYLE>

<style>
    body{
        color:#ff0000;
    }
    *{font-family: "微软雅黑";}
    #code {font-size: 14px; display: none;}
    .divcss5{width:0px;height:0px;line-height:0px; overflow:hidden;}
    body{
        background: !important;
        color: !important;
    }
</style>

<div id="main">

    <div id="error">本页面采用HTML5编辑，目前您的浏览器无法显示，请换成谷歌(<a href="http://www.google.cn/chrome/intl/zh-CN/landing_chrome.html?hl=zh-CN&brand=CHMI">Chrome</a>)或者火狐(<a href="http://firefox.com.cn/download/">Firefox</a>)浏览器，或者其他游览器的最新版本。</div>

    <div id="wrap">

        <div id="text">

            <div id="code">


                <font color=""><span class="say">${love.youname},${love.showmian}</span><br/>
                    <span class="say"></span><br/><span class="say">${love.showmian2}</span><br/><br/>
                    <span class="say"></span><br/><span class="say">${love.showmian3}</span><br/><br/>
                    <span class="say"></span><br/><span class="say">${love.showmian4}</span><br/><br/>
                    <span class="say"></span><br/><span class="say">${love.showmian5}</span><br/><br/>
                    <span class="say"></span><br/><span class="say">${love.showmian6}</span><br/><br/>
                    <span class="say"></span><br/><span class="say">${love.showmian7}</span><br/><br/>
                    <span class="say"></span><br/><span class="say">${love.showmian8}</span><br/><br/>
                    <span class="say"></span><br/><span class="say">${love.showmian9}</span><br/><br/>
                    <span class="say"></span><br/><span class="say">${love.me}</span>
                </font>
            </div></div>







        <div id="xy">
            <div id="clock-box">
                <div id="clock"></div>
            </div>
        </div>






        <CANVAS width="1100" height="680" id="canvas"></CANVAS>  </div></div>

<script></script>


<script>
    (function(){
        var canvas = $('#canvas');

        if (!canvas[0].getContext) {
            $("#error").show();
            return false;
        }


        var width = canvas.width();
        var height = canvas.height();

        canvas.attr("width", width);
        canvas.attr("height", height);


        var opts = {
            seed: {
                x: width / 2 - 20,
                color: "rgb(190, 26, 37)",
                scale: 2
            },
            branch: [
                [535, 680, 570, 250, 500, 200, 30, 100, [
                    [540, 500, 455, 417, 340, 400, 13, 100, [
                        [450, 435, 434, 430, 394, 395, 2, 40]
                    ]],
                    [550, 445, 600, 356, 680, 345, 12, 100, [
                        [578, 400, 648, 409, 661, 426, 3, 80]
                    ]],
                    [539, 281, 537, 248, 534, 217, 3, 40],
                    [546, 397, 413, 247, 328, 244, 9, 80, [
                        [427, 286, 383, 253, 371, 205, 2, 40],
                        [498, 345, 435, 315, 395, 330, 4, 60]
                    ]],
                    [546, 357, 608, 252, 678, 221, 6, 100, [
                        [590, 293, 646, 277, 648, 271, 2, 80]
                    ]]
                ]]
            ],
            bloom: {
                num: 700,
                width: 1080,
                height: 650,
            },
            footer: {
                width: 1200,
                height: 5,
                speed: 10,
            }
        }


        var tree = new Tree(canvas[0], width, height, opts);
        var seed = tree.seed;
        var foot = tree.footer;
        var hold = 1;


        canvas.click(function(e) {
            var offset = canvas.offset(), x, y;
            x = e.pageX - offset.left;
            y = e.pageY - offset.top;
            if (seed.hover(x, y)) {
                hold = 0;
                canvas.unbind("click");
                canvas.unbind("mousemove");
                canvas.removeClass('hand');
            }
        }).mousemove(function(e){
            var offset = canvas.offset(), x, y;
            x = e.pageX - offset.left;
            y = e.pageY - offset.top;
            canvas.toggleClass('hand', seed.hover(x, y));
        });


        var seedAnimate = eval(Jscex.compile("async", function () {
            seed.draw();
            while (hold) {
                $await(Jscex.Async.sleep(10));
            }
            while (seed.canScale()) {
                seed.scale(0.95);
                $await(Jscex.Async.sleep(10));
            }
            while (seed.canMove()) {
                seed.move(0, 2);
                foot.draw();
                $await(Jscex.Async.sleep(10));
            }
        }));


        var growAnimate = eval(Jscex.compile("async", function () {
            do {
                tree.grow();
                $await(Jscex.Async.sleep(10));
            } while (tree.canGrow());
        }));


        var flowAnimate = eval(Jscex.compile("async", function () {
            do {
                tree.flower(2);
                $await(Jscex.Async.sleep(10));
            } while (tree.canFlower());
        }));

        var moveAnimate = eval(Jscex.compile("async", function () {
            tree.snapshot("p1", 240, 0, 610, 680);
            while (tree.move("p1", 500, 0)) {
                foot.draw();
                $await(Jscex.Async.sleep(10));
            }
            foot.draw();
            tree.snapshot("p2", 500, 0, 610, 680);

            // 会有闪烁不得意这样做, (＞﹏＜)
            canvas.parent().css("background", "url(" + tree.toDataURL('image/png') + ")");
            canvas.css("background", "#ffe");
            $await(Jscex.Async.sleep(300));
            canvas.css("background", "none");
        }));

        var jumpAnimate = eval(Jscex.compile("async", function () {
            var ctx = tree.ctx;
            while (true) {
                tree.ctx.clearRect(0, 0, width, height);
                tree.jump();
                foot.draw();
                $await(Jscex.Async.sleep(25));
            }
        }));

        var textAnimate = eval(Jscex.compile("async", function () {
            var together = new Date();
            var strs ="${love.time} 00:00:00";
            var nowTime=new Date();
            var together = new Date(strs.replace(/-/g,"/"));

            $("#code").show().typewriter();
            $("#clock-box").fadeIn(500);
            while (true) {
                timeElapse(together);
                $await(Jscex.Async.sleep(1000));
            }
        }));

        var runAsync = eval(Jscex.compile("async", function () {
            $await(seedAnimate());
            $await(growAnimate());
            $await(flowAnimate());
            $await(moveAnimate());
            textAnimate().start();
            $await(jumpAnimate());
        }));

        runAsync().start();
    })();
</script>



</embed>
</div>

</div>

<div class="bg1">
    <div class="main">
        <footer style="line-height:20px">
            <div id="copyright">
                <p align="center">

                <#--<div style="position:absolute; top:50px; right:50px;">-->
                    <#--<audio id="main_audio" autoplay="autoplay" preload="auto" loop>-->
                        <#--<source src="http://i.51bbw.cn/mp3/mp3.php?id=http://music.163.com/outchain/player?type=2&amp;id=30070700&amp;auto=1&amp;height=66" type="audio/mpeg" />-->
                        <#--<embed id="main_audio_ie8" hidden="true" autostart="true" height="0" width=0 loop="true" src="http://i.51bbw.cn/mp3/mp3.php?id=http://music.163.com/outchain/player?type=2&amp;id=30070700&amp;auto=1&amp;height=66" autoplay="autoplay"/>-->
                    <#--</audio>-->
                    <#--<a class="c-white fs-12 icon-play rotate" id="btn-play" href="javascript:void(0);"></a>-->
                <#--</div>-->

                <#--<script type="text/javascript">-->
                    <#--//获取picid函数-->
                    <#--$(function(){-->
                        <#--$("area").click(function(){-->
                            <#--var  picId=$(this).attr("data-id");-->
                            <#--var picSrc="images/img_big/"+picId+".jpg"-->
                            <#--$(".modal-content>.pic-box>img").attr("src",picSrc);-->
                        <#--})-->
                        <#--var isPlaying = function(audio) {return !audio.paused;}-->
                        <#--var a = document.getElementById('main_audio');-->
                        <#--if(!(a.play instanceof Function)){-->
                            <#--a = document.getElementById('main_audio_ie8');-->
                            <#--isPlaying = function(audio) {return audio.playState==2;}-->
                        <#--}-->
                        <#--$('#btn-play').on('click', function() {-->
                            <#--if($(this).hasClass('rotate')) {-->
                                <#--a.pause();-->
                                <#--$(this).removeClass('rotate');-->
                            <#--} else {-->
                                <#--a.play();-->
                                <#--$(this).addClass('rotate');-->
                            <#--}-->
                        <#--});-->

                    <#--})-->
                <#--</script>-->


            </div>
    </div>
</div>
</div>
</div>
<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?ca0086535dd1af181953e3d585ca7306";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>
<iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=330 height=86
        src="//music.163.com/outchain/player?type=2&id=${love.mp3}&auto=1&height=66"></iframe>
网易云音乐提供技术支持
</html>