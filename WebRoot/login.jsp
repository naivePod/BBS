
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/login.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    
    <script language="JavaScript" type="text/javascript" src="/images/js/jquery-3.2.1.min.js"></script>
    

</head>
<body>
	<img id="body-bg" src="images/forest3.jpg" >
	<div id="wrap">
		<form action="login" method="post">
            <span class="icon-userBig icon-user"></span>
			<h1>用户登录</h1>
            <div class="input-wrap">
                <span class="icon icon-user"></span>
                <input  type="text" placeholder="请输入用户名" id="userName" name="user.userName"></br>
            </div>
            <div class="input-wrap">
                <span class="icon icon-key"></span>
                <input  type="password" placeholder="请输入密码" id="psw" name="user.psw"></br>
                <span class="warning"><s:property value="errorInfo"/></span>
            </div>
           
             <div class="radio-box">
                <label>
                    <input type="radio" name="role" value="0" checked>用户&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </label>
                <label>
                    <input type="radio" name="role" value="1">管理员
                </label>
            </div>
            <input class="btn-submit" type="submit" value="登录">
            <a class="btn-regist" href="register.jsp">没有账号？点击注册</a>
		</form>
		
	</div>
	
</body>
</html>
