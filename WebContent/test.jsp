<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<form action="#" method="post">
		<label>用户邮箱：</label>
		<input id="email" type="text" placeholder="输入邮箱">
		
		<input type="button" value="获取验证码" onclick="getCode();">
		<br>
		<label>获取到的验证码：</label>
		<input id="code" type="text" >
	</form>
	<script type="text/javascript" src="/js/jquery.js" ></script>
	<script type="text/javascript">
		function getCode(){
			var email = $("#email").val();
			
			$.ajax({
				url:"/fore/sendemail.action",
				type:"POST",
				anync:false,
				cache:false,
				data:{
					email:email//与后端请求方法sendemail()的参数名称一致，否则后端接收不到email参数
				},
				dataType:"json",
				success:function(data){
					if(data!=null){
						console.log(data);
						$("#code").val(data);
					}else{
						alert("获取验证码失败！");
					}
					
				}
				
				
			});
		}
	</script>
</body>
</body>
</html>