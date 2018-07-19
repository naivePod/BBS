<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/14 0014
  Time: 下午 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>用户名单</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/images/css/bootstrap.min.css">
    <script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/images/js/bootstrap.min.js"></script>
</head>
<body>
    <form class="form-horizontal">
        <div class="form-group" style="margin-top:30px;">
            <label class="col-sm-offset-2 col-sm-10 "><h3>${currentUser.userName}</h3></label>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-4">
                <a role="button" href="${pageContext.request.contextPath}/showArticles" class="btn btn-Warning">返回</a>
            </div>
        </div>
    </form>
    <hr>
    <div class="table-responsive">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>用户id</th>
                <th>用户名</th>
                <th>邮箱</th>
        
                <th>发帖数</th>
            </tr>
            </thead>
            <c:forEach items="${users}" var="user" varStatus="loop">
                <thead>
                <tr>
                    <th><c:out value="${user.userId}"></c:out></th>
                    <th><c:out value="${user.userName}"></c:out></th>
                    <th><c:out value="${user.email}"></c:out></th>
                    <th><c:out value="${userarticle_count[loop.count-1]}"></c:out></th>
                </tr>
                </thead>
            </c:forEach>
        </table>
    </div>

</body>
</html>
