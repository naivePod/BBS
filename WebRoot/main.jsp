<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/11 0011
  Time: 下午 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<html>
<head>
    <title>帖子展示</title>
    <link rel="stylesheet" type="text/css" href="/images/css/bootstrap.min.css">
    <script language="JavaScript" type="text/javascript" src="/images/js/bootstrap.min.js"></script>

</head>
<body>
    <form action="sendArticle.jsp" class="form-horizontal">
        <div class="form-group" style="margin-top:30px;">
            <label class="col-sm-offset-2 col-sm-10 "><h3>${user.userName}</h3></label>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">
                    发帖
                </button>
                <c:if test="${user.isAdmin==0}">
                    <a role="button" href="${pageContext.request.contextPath}/updateInfo.jsp" class="btn btn-success">修改密码</a>
                </c:if>
                <c:if test="${user.isAdmin==1}">
                    <a role="button" href="${pageContext.request.contextPath}/QueryUsersServlet" class="btn btn-success">用户情况</a>
                </c:if>
                <%--<a role="button" href="${pageContext.request.contextPath}/updateInfo.jsp" class="btn btn-success">修改密码</a>--%>
                <a role="button" href="${pageContext.request.contextPath}/LogoutServlet" class="btn btn-danger">注销</a>
            </div>
        </div>
        <hr>
    </form>
    <div class="table-responsive">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>标题</th>
                <th>内容</th>
                <th>作者</th>
                <th>上次回复时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <c:forEach items="${topArticles}" var="article">
                <thead>
                <tr class="danger">
                    <th><a href="${pageContext.request.contextPath}/DealReplyServlet?article_id=${article.article_id}"><c:out value="${article.title_Content}"/></a></th>
                    <th><c:out value="${article.article_Content}"/></th>
                    <th><c:out value="${article.userName}"/></th>
                    <th><c:out value="${article.title_time}"/></th>
                    <th>
                        <a role="button" href="${pageContext.request.contextPath}/DealReplyServlet?article_id=${article.article_id}" class="btn btn-primary btn-sm">查看</a>
                        <c:if test="${user.isAdmin==1}">
                            <a role="button" href="${pageContext.request.contextPath}/DealTopArticlesServlet?article_id=${article.article_id}&choice=0" class="btn btn-danger btn-sm">取消置顶</a>
                        </c:if>
                    </th>
                </tr>
                </thead>
            </c:forEach>
            <c:forEach items="${articles}" var="article">
                <thead>
                <tr>
                    <th><a href="${pageContext.request.contextPath}/DealReplyServlet?article_id=${article.article_id}"><c:out value="${article.title_Content}"/></a></th>
                    <th><c:out value="${article.article_Content}"/></th>
                    <th><c:out value="${article.userName}"/></th>
                    <th><c:out value="${article.title_time}"/></th>
                    <th>
                        <a role="button" href="${pageContext.request.contextPath}/DealReplyServlet?article_id=${article.article_id}" class="btn btn-primary btn-sm">查看</a>
                        <c:if test="${user.isAdmin==1}">
                            <a role="button" href="${pageContext.request.contextPath}/DealTopArticlesServlet?article_id=${article.article_id}&choice=1" class="btn btn-success btn-sm">置顶</a>
                            <a role="button" href="${pageContext.request.contextPath}/DeleteArticleServlet?article_id=${article.article_id}" class="btn btn-danger btn-sm">删帖</a>
                        </c:if>
                    </th>
                </tr>
                </thead>
            </c:forEach>
        </table>
    </div>
</body>
</html>
