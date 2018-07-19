<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/14 0014
  Time: 下午 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改密码</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/images/css/bootstrap.min.css">
    <script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/images/js/bootstrap.min.js"></script>
</head>
<body>
    <form action="" class="form-horizontal">
        <div class="form-group" style="margin-top:30px;">
            <label class="col-sm-2 control-label"><h3>${user.userName}</h3></label>
        </div>
        <hr>
    </form>
    <form action="${pageContext.request.contextPath}/ChangePswServlet" class="form-horizontal" method="post">

        <div class="form-group">
            <label for="newPsw" class="col-sm-2 control-label">新密码</label>
            <div class="col-sm-10">
                <input type="password" id="newPsw" name="newPsw" placeholder="密码">
            </div>
        </div>
        <c:if test="${formBean.errors.newPsw != null}">
            <div class="form-group">
                <div class="col-md-offset-2 col-sm-2" >
                    <div class="alert alert-warning ">
                        <a href="#" class="close" data-dismiss="alert">
                            &times;
                        </a>
                        <strong><c:out value="${formBean.errors.newPsw}"></c:out></strong>
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
                <a role="button" href="${pageContext.request.contextPath}/DealArticlesServlet" class="btn btn-Warning">返回</a>
                <button type="submit" class="btn btn-primary">
                    修改密码
                </button></div>
        </div>

    </form>
</body>
</html>
