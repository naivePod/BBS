package gdut.action;

import java.util.List;
import java.util.Set;

import gdut.po.Article;
import gdut.po.Reply;
import gdut.po.User;
import gdut.service.ArticleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport{
	
	ArticleService articleService;
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	Article article;
	List<Article> articles;
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	
	Integer article_id;

	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	
	public String showArticles() {
		articles=articleService.showArticles();
		Article a = articles.get(0);
		
		return SUCCESS;
	}
	Set replies;

	public Set getReplies() {
		return replies;
	}
	public void setReplies(Set replies) {
		this.replies = replies;
	}
	public String deleteArticle() {
		
		ActionContext context = ActionContext.getContext();
		User user = (User)context.getSession().get("current_user");
		
		if(user != null && user.getRole()==1 ){
			articleService.delete(article_id);
		}
		return SUCCESS;
	}
	public String queryArticle(){
		article=articleService.findById(article_id);
		replies=article.getReplies();
		return SUCCESS;
	}
	
}
