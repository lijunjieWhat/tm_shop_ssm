<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<script>

    $(function () {
    	
    	 var num ;//定义容器接收验证码
     	var canvas = document.getElementById("canvas");//获取对象
         var context = canvas.getContext("2d");//，getContext() 方法可返回一个对象，该对象提供了用于在画布上绘图的方法和属性。
         var input = document.getElementById("text");//获取输入框
         draw();
         canvas.onclick = function () {
             context.clearRect(0, 0, 100, 30);//在给定的矩形内清除指定的像素
             draw();
         }
         // 随机颜色函数
         function getColor() {
             var r = Math.floor(Math.random() * 256);
             var g = Math.floor(Math.random() * 256);
             var b = Math.floor(Math.random() * 256);
             return "rgb(" + r + "," + g + "," + b + ")";
         }
     	
     	function draw() {
             context.strokeRect(0, 0, 100, 30);//绘制矩形（无填充）
          // 绘制字母
             var aCode = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c',
     				'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
     				'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A',
     				'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
     				'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
             
             var arr = [] //定义一个数组用来接收产生的随机数
            
             for (var i = 0; i < 4; i++) {
                 var x = 15 + i * 20;//每个字母之间间隔20
                 var y = 10 + 10 * Math.random();//y轴方向位置为20-30随机
                 var index = Math.floor(Math.random() * aCode.length);//随机索引值
                 var txt = aCode[index];
                 context.font = "bold 20px 微软雅黑";//设置或返回文本内容的当前字体属性
                 context.fillStyle=getColor();//设置或返回用于填充绘画的颜色、渐变或模式，随机
                 context.translate(x,y);//重新映射画布上的 (0,0) 位置，字母不可以旋转移动，所以移动容器
                 var deg=90*Math.random()*Math.PI/180;//0-90度随机旋转
                 context.rotate(deg);// 	旋转当前绘图
                 context.fillText(txt, 0, 0);//在画布上绘制“被填充的”文本
                 context.rotate(-deg);//将画布旋转回初始状态
                 context.translate(-x,-y);//将画布移动回初始状态
                 arr[i] = txt //接收产生的随机数
             }
             num = arr[0] + arr[1] + arr[2] + arr[3] //将产生的验证码放入num
             // 绘制干扰线条
             for (var i = 0; i < 8; i++) {
                 context.beginPath();//起始一条路径，或重置当前路径
                 context.moveTo(Math.random() * 100, Math.random() * 30);//把路径移动到画布中的随机点，不创建线条
                 context.lineTo(Math.random() * 100, Math.random() * 30);//添加一个新点，然后在画布中创建从该点到最后指定点的线条
                 context.strokeStyle=getColor();//随机线条颜色
                 context.stroke();// 	绘制已定义的路径
             }
             // 绘制干扰点，和上述步骤一样，此处用长度为1的线代替点
             for (var i = 0; i < 20; i++) {
                 context.beginPath();
                 var x = Math.random() * 100;
                 var y = Math.random() * 30;
                 context.moveTo(x, y);
                 context.lineTo(x + 1, y + 1);
                 context.strokeStyle=getColor();
                 context.stroke();
             }
     	}
     	
     
         
         
    	
    	
    	
        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.loginErrorMessageDiv").show();
        </c:if>

        $("form.loginForm").submit(function () {
            if (0 == $("#name").val().length || 0 == $("#password").val().length) {
                $("span.errorMessage").html("请输入账号密码");
                $("div.loginErrorMessageDiv").show();
                return false;
            }else if(0 == $("#inputyzm").val().length){
            	$("span.errorMessage").html("请输入验证码");
                $("div.loginErrorMessageDiv").show();
                return false;
            }
            if($("#inputyzm").val().toLowerCase() != num.toLowerCase()){
            	$("span.errorMessage").html("验证码错误");
                $("div.loginErrorMessageDiv").show();
                context.clearRect(0, 0, 100, 30);
                draw();
                return false;
            }
          
           
         
            
            return true;
        });
        

        $("form.loginForm input").keyup(function () {
            $("div.loginErrorMessageDiv").hide();
        });

        var left = window.innerWidth / 2 + 162;
        $("div.loginSmallDiv").css("left", left);
        
        
       
        
    })
</script>

<div id="loginDiv" style="position: relative">

    <div class="simpleLogo">
        <a><img src="/img/site/simpleLogo.png"></a>
    </div>

    <img id="loginBackgroundImg" class="loginBackgroundImg" src="/img/site/loginBackground.png">

    <form class="loginForm" action="/fore/login.action" method="post">
        <div id="loginSmallDiv" class="loginSmallDiv" style="height: 450px">
            <div class="loginErrorMessageDiv">
                <div class="alert alert-danger">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
                    <span class="errorMessage"></span>
                </div>
            </div>

            <div class="login_acount_text">账户登录</div>
            <div class="loginInput ">
                <span class="loginInputIcon ">
                    <span class=" glyphicon glyphicon-user"></span>
                </span>
                <input id="name" name="username" placeholder="手机/会员名/邮箱" type="text">
            </div>

            <div class="loginInput ">
                <span class="loginInputIcon ">
                    <span class=" glyphicon glyphicon-lock"></span>
                </span>
                <input id="password" name="password" type="password" placeholder="密码" type="text">
            </div>
            
             <div  class="loginInput ">
                <span class="loginInputIcon ">
                    <span class=" glyphicon glyphicon-envelope"></span>
                </span>
                <input id="inputyzm" size="20px"   name="yzm" type="text" placeholder="验证码" >
            </div>
            
            
            
            <span class="text-danger">不要输入真实的天猫账号密码  <canvas style="margin-left: 40px" id="canvas" width="100" height="30"></canvas></span><br><br>
			
            <div>
                <a href="/fore/updatePasswordPage.action">忘记登录密码</a>
                <a href="/fore/registerPage.action" class="pull-right">免费注册</a>
            </div>
            <div style="margin-top:20px">
                <button class="btn btn-block redButton" type="submit">登录</button>
            </div>
        </div>
    </form>

</div>