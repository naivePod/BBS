package gdut.service.impl;

import java.util.List;

import gdut.dao.IArticleDao;
import gdut.dao.IReplyDao;
import gdut.po.Article;
import gdut.po.Reply;
import gdut.po.User;
import gdut.service.IReplyService;

public class ReplyServiceImpl implements IReplyService{
	private IReplyDao iReplyDao;
	private IArticleDao iArticleDao;
	

	public IArticleDao getiArticleDao() {
		return iArticleDao;
	}

	public void setiArticleDao(IArticleDao iArticleDao) {
		this.iArticleDao = iArticleDao;
	}

	public IReplyDao getiReplyDao() {
		return iReplyDao;
	}

	public void setiReplyDao(IReplyDao iReplyDao) {
		this.iReplyDao = iReplyDao;
	}
	
	public boolean post(Integer article_id, String replyContent, User user) {
		Reply reply = new Reply();
		System.out.println("articleid"+article_id);
		Article article = iArticleDao.findById(article_id);
		int floor = iReplyDao.findFloor(article_id);
		if(article == null || replyContent == null) {
			return false;
		}
		reply.setFloor(floor+1);
		reply.setUser(user);
		reply.setArticle(article);
		reply.setReplyContent(replyContent);
		iReplyDao.update(reply);
		return true;
	}
}
