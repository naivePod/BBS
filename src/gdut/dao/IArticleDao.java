package gdut.dao;

import gdut.po.Article;



public interface IArticleDao {
	public void insert(Article article);
	public void update(Article article);
	public void delete(Article article);
	public Article findById(Integer id);
}
