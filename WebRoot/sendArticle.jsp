<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/12 0012
  Time: 下午 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发帖</title>
    <link rel="stylesheet" type="text/css" href="/images/css/bootstrap.min.css">
    <script language="JavaScript" type="text/javascript" src="/images/js/bootstrap.min.js"></script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/DealSendArticleServlet" class="form-horizontal" method="get">
        <div class="form-group" style="margin-top:30px;">
            <label class="col-sm-offset-2 col-sm-10 "><h3>${user.userName}</h3></label>
        </div>
        <div class="form-group">
            <label for="title_content" class="col-sm-2 control-label">标题</label>
            <div class="col-sm-10">
                <input id="title_content" name="title_content" type="text" placeholder="标题"/>
            </div>
        </div>
        <div class="form-group">
            <label for="article_content" class="col-sm-2 control-label" >内容</label>
            <div class="col-sm-10">
                <textarea style="width:200px;height: 300px;" id="article_content" name="article_content"></textarea>
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
    </form>
</body>
</html>
