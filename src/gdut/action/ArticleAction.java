package gdut.action;

import java.util.List;
import java.util.Set;

import gdut.po.Article;
import gdut.po.Reply;
import gdut.po.Top;
import gdut.po.User;
import gdut.service.IArticleService;
import gdut.util.Const;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport{
	
	IArticleService articleService;
	
	private String content;
	private String title_content;
	
	
	
	public String getTitle_content() {
		return title_content;
	}
	public void setTitle_content(String title_content) {
		this.title_content = title_content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setArticleService(IArticleService articleService) {
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
	Top top;
	List<Top> topArticles;
	public List<Top> getTopArticles() {
		return topArticles;
	}
	public void setTopArticles(List<Top> topArticles) {
		this.topArticles = topArticles;
	}
	public Top getTops() {
		return top;
	}
	public void setTops(Top tops) {
		this.top = tops;
	}
	public String showArticles() {
		articles=articleService.showArticles();
		Article a = articles.get(0);
		
		topArticles=showTopArticle();

		
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
		User user = (User)context.getSession().get(Const.CURRENT_USER);
		//�ö�����
		
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
	public List<Top> showTopArticle(){
		List<Top> list=articleService.showTopArticles();
			if(list!=null){
				
				return list;
			}
			else
				return null;
			
	}
	public String deleteTop() {
		articleService.deleteTop(article_id);
		return SUCCESS;
	}
	public String Top() {
		ActionContext context = ActionContext.getContext();
		User user = (User)context.getSession().get(Const.CURRENT_USER);
		if(user != null && user.getRole()==1 ){
			articleService.insertTop(article_id);
		}
		return SUCCESS;
	}
	
	public String postArticle() {
		ActionContext context = ActionContext.getContext();
		User user = (User)context.getSession().get(Const.CURRENT_USER);
		articleService.postArticle(content,title_content, user);
		
		return SUCCESS;
		
	}

	
}
