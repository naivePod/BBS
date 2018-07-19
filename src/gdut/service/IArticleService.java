package gdut.service;

import java.util.List;

import gdut.po.Article;
import gdut.po.Top;

public interface IArticleService {
	public void insert(Article article) ;
	public void update(Article article); 
	public void delete(Integer id) ;
	public Article findById(Integer id); 
	public List<Article> showArticles() ;
	/*
	 * œ‘ æ÷√∂•Ã˚◊”
	 * */
	public List<Top> showTopArticles() ;
	
	/*
	 * …æ≥˝÷√∂•
	 * */
	public  void deleteTop(Integer id) ;
	/*
	 *÷√∂• 
	 */
	public  void insertTop(Integer id) ;
}
