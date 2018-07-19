package gdut.service.impl;

import java.util.List;

import gdut.dao.ArticleDao;
import gdut.po.Article;
import gdut.service.ArticleService;

public class ArticleSerivceImp implements ArticleService{

	ArticleDao articleDao;
	public void setArticleDao(ArticleDao articleDao) {
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
	
}
