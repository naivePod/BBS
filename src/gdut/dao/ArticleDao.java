package gdut.dao;

import java.util.List;

import gdut.po.Article;

public interface ArticleDao {
	public void insert(Article article) ;
	public void update(Article article); 
	public void delete(Integer id) ;
	public Article findById(Integer id); 
	public List<Article> showArticles() ;
		
}
