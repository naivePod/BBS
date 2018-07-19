<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/11 0011
  Time: 下午 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>帖子展示</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/images/css/bootstrap.min.css">
    <script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/images/js/bootstrap.min.js"></script>
	
</head>
<body>
    <form action="sendArticle.jsp" class="form-horizontal">
        <div class="form-group" style="margin-top:30px;">
            <label class="col-sm-offset-2 col-sm-10 "><h3>${currentUser.userName}</h3></label>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">
                    发帖
                </button>
                <c:if test="${currentUser.role==0}">
                    <a role="button" href="${pageContext.request.contextPath}/updateInfo.jsp" class="btn btn-success">修改密码</a>
                </c:if>
                    <a role="button" href="${pageContext.request.contextPath}/QueryUsers" class="btn btn-success">用户情况</a>
                <c:if test="${currentUser.role==1}">
                </c:if>
                <%--<a role="button" href="${pageContext.request.contextPath}/updateInfo.jsp" class="btn btn-success">修改密码</a>--%>
                <a role="button" href="${pageContext.request.contextPath}/logout" class="btn btn-danger">注销</a>
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
            <c:forEach items="${topArticles}" var="top">
                <thead>
                <tr class="danger">
                    <th><a href="${pageContext.request.contextPath}/DealReply?article_id=${top.articleId}">
                    <c:out value="${top.article.titleContent}"/></a></th>
                    <th><c:out value="${top.article.articleContent}"/></th>
                    <th><c:out value="${top.user.userName}"/></th>
                    <th><c:out value="${top.ttime}"/></th>
                    <th>
                        <a role="button" href="${pageContext.request.contextPath}/DealReply?article_id=${top.articleId}" class="btn btn-primary btn-sm">查看</a>
                        <c:if test="${currentUser.role==1}">
                            <a role="button" href="${pageContext.request.contextPath}/DealTopArticles?article_id=${top.articleId}&choice=0" class="btn btn-danger btn-sm">取消置顶</a>
                        </c:if>
                    </th>
                </tr>
                </thead>
            </c:forEach>
            <c:forEach items="${articles}" var="article">
                <thead>
                <tr>
                    <th><a href="${pageContext.request.contextPath}/DealReply?article_id=${article.articleId}"><c:out value="${article.titleContent}"/></a></th>
                    <th><c:out value="${article.articleContent}"/></th>
                    <th><c:out value="${article.user.userName}"/></th>
                    <th><c:out value="${article.titleTime}"/></th>
                    <th>
                        <a role="button" href="${pageContext.request.contextPath}/DealReply?article_id=${article.articleId}" class="btn btn-primary btn-sm">查看</a>
                        <c:if test="${currentUser.role==1}">
                            <a role="button" href="${pageContext.request.contextPath}/TopArticles?article_id=${article.articleId}&choice=1" class="btn btn-success btn-sm">置顶</a>
                            <a role="button" href="${pageContext.request.contextPath}/DeleteArticle?article_id=${article.articleId}" class="btn btn-danger btn-sm">删帖</a>
                            
                        </c:if>
                    </th>
                </tr>
                </thead>
            </c:forEach>
        </table>
    </div>
</body>
</html>
