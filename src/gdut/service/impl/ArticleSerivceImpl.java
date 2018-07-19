package gdut.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gdut.dao.IArticleDao;
import gdut.dao.IReplyDao;
import gdut.po.Article;
import gdut.po.Reply;
import gdut.po.Top;
import gdut.po.User;
import gdut.service.IArticleService;

public class ArticleSerivceImpl implements IArticleService{

	IArticleDao articleDao;
	IReplyDao iReplyDao;
	
	public void setiReplyDao(IReplyDao iReplyDao) {
		this.iReplyDao = iReplyDao;
	}

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
	
	
	public boolean postArticle(String content,String title_content, User user) {
		
		Article article = new Article();
		article.setArticleContent(content);
		article.setUser(user);
		article.setTitleContent(title_content);
		Article newArticle = articleDao.insert(article);
		
		Reply reply = new Reply();
		reply.setUser(user);
		reply.setReplyContent(content);
		reply.setArticle(newArticle);
		reply.setFloor(1);
		iReplyDao.insert(reply);
		
		return true;
	}
}
