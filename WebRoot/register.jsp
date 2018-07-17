
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/11 0011
  Time: 下午 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="/images/css/bootstrap.min.css">
    <script language="JavaScript" type="text/javascript" src="/images/js/bootstrap.min.js"></script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/RegisterServlet" class="form-horizontal" method="post">
        <div class="form-group" style="margin-top:30px;">
            <label class="col-sm-offset-2 col-sm-10 "><h3>用户注册</h3></label>
        </div>
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-8">
                <input type="text" id="userName" name="userName" placeholder="用户名">
            </div>
        </div>
        <c:if test="${formBean.errors.userName != null}">
            <div class="form-group">
                <div class="col-md-offset-2 col-sm-2" >
                    <div class="alert alert-warning ">
                        <a href="#" class="close" data-dismiss="alert">
                            &times;
                        </a>
                        <strong><c:out value="${formBean.errors.userName}"></c:out></strong>
                    </div>
                </div>
            </div>
        </c:if>
        <div class="form-group">
            <label for="psw" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" id="psw" name="psw" placeholder="密码">
            </div>
        </div>
        <c:if test="${formBean.errors.psw != null}">
            <div class="form-group">
                <div class="col-md-offset-2 col-sm-2" >
                    <div class="alert alert-warning ">
                        <a href="#" class="close" data-dismiss="alert">
                            &times;
                        </a>
                        <strong><c:out value="${formBean.errors.psw}"></c:out></strong>
                    </div>
                </div>
            </div>
        </c:if>
        <div class="form-group">
            <label for="confirmPsw" class="col-sm-2 control-label">再次确认密码</label>
            <div class="col-sm-10">
                <input type="password" id="confirmPsw" name="confirmPsw" placeholder="再次确认密码">
            </div>
        </div>
        <c:if test="${formBean.errors.confirmPsw != null}">
            <div class="form-group">
                <div class="col-md-offset-2 col-sm-2" >
                    <div class="alert alert-warning ">
                        <a href="#" class="close" data-dismiss="alert">
                            &times;
                        </a>
                        <strong><c:out value="${formBean.errors.confirmPsw}"></c:out></strong>
                    </div>
                </div>
            </div>
        </c:if>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">邮箱</label>
            <div class="col-sm-10">
                <input type="text" id="email" name="email" placeholder="邮箱">
            </div>
        </div>
        <div class="form-group">
            <label for="birth" class="col-sm-2 control-label">出生日期</label>
            <div class="col-sm-10">
                <input type="text" id="birth" name="birth" placeholder="出生日期">
            </div>
        </div>
        <c:if test="${message!=null}">
            <div class="col-md-offset-2 col-sm-2" >
                <div class="alert alert-success ">
                    <a href="#" class="close" data-dismiss="alert">

                    </a>
                    <strong><c:out value="${message}"></c:out></strong>
                </div>
            </div>
            </div>
            ${str}
        </c:if>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <a role="button" href="${pageContext.request.contextPath}/login.jsp" class="btn btn-Warning">返回</a>
                <button type="submit" class="btn btn-primary">
                    注册
                </button></div>
        </div>

    </form>
</body>
</html>
