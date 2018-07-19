package gdut.dao;

import java.util.List;

import gdut.po.Article;
import gdut.po.Top;

public interface IArticleDao {
	/*
	 * 插入Article
	 * */
	public void insert(Article article) ;
	/*
	 * 更新Article
	 * */
	public void update(Article article); 
	/*
	 * 删除帖子
	 * */
	public void delete(Integer id) ;
	/*
	 * 查看帖子信息
	 * */
	public Article findById(Integer id); 
	/*
	 * 显示全部帖子
	 * */
	public List<Article> showArticles() ;
	/*
	 * 显示置顶帖子
	 * */
	public List<Top> showTopArticles() ;
	
	/*
	 * 删除置顶
	 * */
	public  void deleteTop(Integer id) ;
	/*
	 *置顶 
	 */
	public  void insertTop(Integer id) ;
	
}
