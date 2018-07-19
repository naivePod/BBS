package gdut.dao;

import java.util.List;

import gdut.po.Article;
import gdut.po.Top;

public interface IArticleDao {
	/*
	 * ����Article
	 * */
	public Article insert(Article article) ;
	/*
	 * ����Article
	 * */
	public void update(Article article); 
	/*
	 * ɾ������
	 * */
	public void delete(Integer id) ;
	/*
	 * �鿴������Ϣ
	 * */
	public Article findById(Integer id); 
	/*
	 * ��ʾȫ������
	 * */
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
	
}
