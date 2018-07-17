<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/14 0014
  Time: 下午 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<html>
<head>
    <title>用户名单</title>
    <link rel="stylesheet" type="text/css" href="/images/css/bootstrap.min.css">
    <script language="JavaScript" type="text/javascript" src="/images/js/bootstrap.min.js"></script>
</head>
<body>
    <form class="form-horizontal">
        <div class="form-group" style="margin-top:30px;">
            <label class="col-sm-offset-2 col-sm-10 "><h3>${user.userName}</h3></label>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-4">
                <a role="button" href="${pageContext.request.contextPath}/DealArticlesServlet" class="btn btn-Warning">返回</a>
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
                <th>出生日期</th>
                <th>发帖数</th>
            </tr>
            </thead>
            <c:forEach items="${users}" var="user">
                <thead>
                <tr>
                    <th><c:out value="${user.user_id}"></c:out></th>
                    <th><c:out value="${user.userName}"></c:out></th>
                    <th><c:out value="${user.email}"></c:out></th>
                    <th><c:out value="${user.birth}"></c:out></th>
                    <th><c:out value="${user.article_count}"></c:out></th>
                </tr>
                </thead>
            </c:forEach>
        </table>
    </div>

</body>
</html>
