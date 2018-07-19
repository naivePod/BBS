package gdut.service.impl;

import java.util.List;

import gdut.dao.IArticleDao;
import gdut.po.Article;
import gdut.po.Top;
import gdut.service.IArticleService;

public class ArticleSerivceImpl implements IArticleService{

	IArticleDao articleDao;
	public void setArticleDao(IArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public void insert(Article article) {
		// TODO Auto-generated method stub
		articleDao.insert(article);
	}

	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub
		articleDao.update(article);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		articleDao.delete(id);
	}

	@Override
	public Article findById(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.findById(id);
	}

	@Override
	public List<Article> showArticles() {
		// TODO Auto-generated method stub
		return articleDao.showArticles();
	}

	@Override
	public List<Top> showTopArticles() {
		// TODO Auto-generated method stub
		return articleDao.showTopArticles();
	}

	@Override
	public void deleteTop(Integer id) {
		// TODO Auto-generated method stub
		articleDao.deleteTop(id);
	}

	@Override
	public void insertTop(Integer id) {
		// TODO Auto-generated method stub
		articleDao.insertTop(id);
	}
	
}
