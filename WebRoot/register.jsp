

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script charset="utf-8" src="images/js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="images/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="css/regist.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    
    <script type="text/javascript">
		
		
		 $(function(){
            var isPwdSame = false;//密码是否相同
            var isUserNameAlreadyNotHas = false;//用户名是否已经被使用了
      		
            //两次输入的密码是否相同
            $("#confirmPsw").keyup(function(){
                //alert($(this).val());
                if( $(this).val() === ($("#psw").val()) ){
                    //aler("show");
                    $(".warning-pwd").hide();
                    isPwdSame = true;
                }else{
                    //alert("hide");
                    $(".warning-pwd").show();
                    isPwdSame = false;
                }
            });
            $("#submit").click(function(){
                if ($("#confirmPsw").val() == ($("#psw").val())) {
                     isPwdSame = true;
                } else {
                     isPwdSame = false;
                }
                console.log("isPwdSame"+isPwdSame);
                console.log("isUserNameAlreadyNotHas"+isUserNameAlreadyNotHas);	
                if(isPwdSame && isUserNameAlreadyNotHas){
                    $("form").submit();
                }else{
                    alert("请重新填写");
                    return false;
                }
                
            });
            /*
            $("#username").blur(function(){
                $.post("isAlreadyHas",{"u.username":$(this).val()},function(data){
                    alert(data.has);
                    if(data.isHas == true){
                        isSame = true;
                        $(".isHas").hide();
                    }else{
                        isSame = false;
                        $(".isHas").show();
                    }
                })
            });*/
            $('#username').blur(function() {
				if($(this).val()!="") {
					$.post('validateUserName', {"username":$(this).val()}, function(data) {
					
					if(data.info=="用户名已注册") {
						$('.warning-username').show();
						isUserNameAlreadyNotHas = false;
					} else {
						$('.warning-username').hide();
						isUserNameAlreadyNotHas = true;
					}
				});
				}
			});
        })
		
	</script>
</head>
<body>
<img id="body-bg" src="images/forest4.jpg" >
<div id="wrap">
    <form rm action="regist" method="post">
        <span class="icon-userBig icon-user"></span>
        <h1>用户注册</h1>
        <div class="input-wrap">
            <span class="icon icon-user"></span>
            <input  type="text" placeholder="请输入用户名" id="username" name="user.userName"></br>
            <p class="warning warning-username"><span class="icon-warning"></span>该用户名已被使用</p>
        </div>
        <div class="input-wrap">
            <span class="icon icon-key"></span>
            <input  type="password" placeholder="请输入密码" id="psw" name="user.psw"></br>
        </div>
        <div class="input-wrap">
            <span class="icon icon-key"></span>
            <input  type="password" placeholder="请再次确认密码" id="confirmPsw" name="confirmPsw"></br>
            <p class="warning warning-pwd"><span class="icon-warning"></span>两次输入密码不一致</p>
        </div>
         <div class="input-wrap">
            <span class="icon icon-envelop"></span>
            <input type="text" placeholder="请输入邮箱" id="email" name="user.email"></br>
        </div>
        <input id="submit" class="btn-submit" type="submit" value="立即注册">
    </form>
</div>
</body>
</html>
