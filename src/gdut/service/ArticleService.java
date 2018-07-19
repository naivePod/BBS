package gdut.service;

import java.util.List;

import gdut.po.Article;

public interface ArticleService {
	public void insert(Article article) ;
	public void update(Article article); 
	public void delete(Integer id) ;
	public Article findById(Integer id); 
	public List<Article> showArticles() ;
}
