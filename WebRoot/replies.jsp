<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/12 0012
  Time: 下午 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<html>
<head>
    <title>帖子</title>
    <link rel="stylesheet" type="text/css" href="/images/css/bootstrap.min.css">
    <script language="JavaScript" type="text/javascript" src="/images/js/jquery-3.2.1.min.js"></script>
    <script language="JavaScript" type="text/javascript" src="/images/js/bootstrap.min.js"></script>


</head>
<body>
    <form action="" class="form-horizontal">
        <div class="form-group" style="margin-top:30px;">
            <label class="col-sm-2 control-label"><h3>主题:${article.title_Content}</h3></label>
        </div>
        <hr>
    </form>
    <div class="table-responsive">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>楼层</th>
                <th>内容</th>
                <th>用户名</th>
                <th>回复时间</th>
            </tr>
            </thead>
            <c:forEach items="${replies}" var="reply">
                <thead>
                <tr>
                    <th><c:out value="${reply.floor}"/></th>
                    <th><c:out value="${reply.replyContent}"/></th>
                    <th><c:out value="${reply.userName}"/></th>
                    <th><c:out value="${reply.replyTime}"/></th>
                </tr>
                </thead>
            </c:forEach>
        </table>
    </div>
    <form action="${pageContext.request.contextPath}/DealSendReplyServlet" class="form-horizontal">
        <input type="hidden" name="article_id" value="${article.article_id}">
        <div class="form-group">
            <label for="replyContent" class="col-sm-2 control-label" >回复内容</label>
            <div class="col-sm-10">
                <textarea style="width:500px;height: 200px;" id="replyContent" name="replyContent"></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <a role="button" href="${pageContext.request.contextPath}/DealArticlesServlet" class="btn btn-Warning">返回</a>
                <button type="submit" class="btn btn-primary">
                    发表
                </button>
            </div>
        </div>
        <hr>
    </form>

</body>
</html>
