<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

 <script>
    $(function () {
	var flag = true;
	var yzm = null;
        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.registerErrorMessageDiv").css("visibility", "visible");
        </c:if>

        $(".registerForm").submit(function () {
        	if (0 == $("#email").val().length) {
                $("span.errorMessage").html("请输入邮箱");
                $("div.registerErrorMessageDiv").css("visibility", "visible");
                return false;
            }
        	if (0 == $("#yzm").val().length) {
                $("span.errorMessage").html("请输入验证码");
                $("div.registerErrorMessageDiv").css("visibility", "visible");
                return false;
            }
        	if(yzm!=$("#yzm").val()){
           	 $("span.errorMessage").html("验证码错误");
                $("div.registerErrorMessageDiv").css("visibility", "visible");
                $("#submit").attr("disable","disable");
           	 return false;}
            if (0 == $("#password").val().length) {
                $("span.errorMessage").html("请输入新密码");
                $("div.registerErrorMessageDiv").css("visibility", "visible");
                return false;
            }
            if (0 == $("#repeatpassword").val().length) {
                $("span.errorMessage").html("请输入确认密码");
                $("div.registerErrorMessageDiv").css("visibility", "visible");
                return false;
            }
            if ($("#password").val() != $("#repeatpassword").val()) {
                $("span.errorMessage").html("重复密码不一致");
                $("div.registerErrorMessageDiv").css("visibility", "visible");
                return false;
            }

            return flag;
        });
        /* 先判断邮箱能不能查出来用户，没有表示邮箱不存在 */
        $("#email").blur(function(){
        	
        	if (0 != $("#email").val().length) {
        	$.post("/fore/quertUserByEmail.action",{email:$("#email").val()},function(result){
               if(result=="emailNotFound"){
            	   $("span.errorMessage").html("此邮箱未注册");
                   $("div.registerErrorMessageDiv").css("visibility", "visible");
                   $("#sendyzm").attr("disabled","disabled");
               }else{
            	   $("span.errorMessage").html("此邮箱已注册,已为你查出对应的用户名");
                   $("div.registerErrorMessageDiv").css("visibility", "visible");
                   $("#sendyzm").attr("disabled",false);
                   $("#username").val(result);
               }
            });
        	}
       	});
        
        
        
        
        
        $("#sendyzm").click(function() {
        	if(0 == $("#email").val().length){
        	 $("span.errorMessage").html("请输入邮箱");
             $("div.registerErrorMessageDiv").css("visibility", "visible");
             return false;
        	}
        	
			$("#sendyzm").val("验证码已发送,如未收到检查邮箱");
			$("#sendyzm").attr("disabled","disabled");
			var email = $("#email").val();
			
			$.ajax({
				url:"/fore/updatePasswordEmailCheck.action",
				type:"POST",
				anync:false,
				cache:false,
				data:{
					email:email//与后端请求方法sendemail()的参数名称一致，否则后端接收不到email参数
				},
				dataType:"json",
				success:function(data){
					yzm=data;
				}
			});
		});
        
        
        
       /*  $("#yzm").blur(function(){
        	 if(yzm!=$("#yzm").val()){
            	 $("span.errorMessage").html("验证码错误");
                 $("div.registerErrorMessageDiv").css("visibility", "visible");
                 $("#submit").attr("disable","disable");
            	 return false;
            }else{
            	
            	
            }
        	});
         */
        
       
    })
</script> 

<form method="post" action="/fore/updatePassword.action"
	class="registerForm">

	<div class="registerDiv">
		<div class="registerErrorMessageDiv">
			<div id="msg" class="alert alert-danger" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close"></button>
				<span class="errorMessage"></span>
			</div>
		</div>

		<table class="registerTable" align="center">
			<tr>
				<td class="registerTip registerTableLeftTD">验证邮箱</td>
				<td></td>
			</tr>

			<tr>
				<td class="registerTableLeftTD">邮箱(注册时的邮箱)</td>
				<td class="registerTableRightTD"><input id="email" type="email"
					name="email" placeholder="请准确输入你的邮箱"></td>
			</tr>
			<tr>
				<td class="registerTableLeftTD"></td>
				<td class="registerTableRightTD"><input id="sendyzm"
					value="发送验证码" type="button" class="btn btn-primary  btn-sm"
					size="10px"></td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">验证码</td>
				<td class="registerTableRightTD"><input id="yzm" type="text"
					placeholder="请输入你的收到验证码"></td>
			</tr>



			<tr>
				<td class="registerTableLeftTD">登陆名</td>
				<td class="registerTableRightTD"><input disabled="disabled"
					id="username" name="username" placeholder="会员名一旦设置成功，无法修改"></td>
			</tr>
			<tr>
				<td class="registerTip registerTableLeftTD">修改密码</td>
				<td class="registerTableRightTD">登陆时验证，保护账号信息</td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">新密码</td>
				<td class="registerTableRightTD"><input id="password"
					name="password" type="password" placeholder="设置你的新密码"></td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">密码确认</td>
				<td class="registerTableRightTD"><input id="repeatpassword"
					type="password" placeholder="请再次输入你的密码"></td>
			</tr>


			<tr>
				<td colspan="2" class="registerButtonTD">
						<button id="submit">提 交</button>
				</td>
			</tr>
		</table>
	</div>
</form>