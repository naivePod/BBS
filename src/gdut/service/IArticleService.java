package gdut.service;

import java.util.List;

import gdut.po.Article;
import gdut.po.Top;
import gdut.po.User;

public interface IArticleService {
	public void insert(Article article) ;
	public void update(Article article); 
	public void delete(Integer id) ;
	public Article findById(Integer id); 
	public List<Article> showArticles() ;
	/*
	 * ��ʾ�ö�����
	 * */
	public List<Top> showTopArticles() ;
	
	/*
	 * ɾ���ö�
	 * */
	public  void deleteTop(Integer id) ;
	/*
	 *�ö� 
	 */
	public  void insertTop(Integer id) ;
	public boolean postArticle(String content,String title_content,User user);
}
