<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/11 0011
  Time: 上午 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/images/css/bootstrap.min.css">
    <script language="JavaScript" type="text/javascript" src="/images/js/jquery-3.2.1.min.js"></script>
    <script language="JavaScript" type="text/javascript" src="/images/js/bootstrap.min.js"></script>

</head>
<body>

    <form action="${pageContext.request.contextPath}/LoginServlet" class="form-horizontal" method="post">
      <div class="form-group" style="margin-top:30px;">
        <label class="col-sm-offset-2 col-sm-10 "><h3>用户登录</h3></label>
      </div>
      <div class="form-group">
        <label for="username" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
          <input type="text" id="userName" name="userName" placeholder="用户名">
        </div>
      </div>
      <div class="form-group">
        <label for="psw" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
          <input type="password" id="psw" name="psw" placeholder="密码">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="radio">
              <label class="radio-inline"><input type="radio" name="inlineRadioOptions" id="radiooption1" value="ordinaryuser" checked>用户</label>
              <label class="radio-inline"><input type="radio" name="inlineRadioOptions" id="radiooption2"value="admin">管理员</label>
            </div>
        </div>
      </div>
        <c:if test="${message != null}">
            <div class="form-group">
                <div class="alert alert-warning col-sm-offset-2 col-sm-2">
                    <a href="#" class="close" data-dismiss="alert">
                        &times;
                    </a>
                    <strong>警告！</strong>${message}
                </div>
            </div>
        </c:if>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-primary">
            登录
          </button></div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <hr>
          <a href="${pageContext.request.contextPath}/register.jsp" id="register_btn">没有账号？注册</a>
        </div>
      </div>
    </form>
</body>
</html>
