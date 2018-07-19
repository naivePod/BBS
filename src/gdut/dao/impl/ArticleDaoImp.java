package gdut.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import gdut.dao.ArticleDao;
import gdut.po.Article;

public class ArticleDaoImp implements ArticleDao {

	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory(){
	     return this.sessionFactory;
	   }

	public Session getCurrentSession(){
	     return this.sessionFactory.getCurrentSession();
	   }

	@Override
	public void insert(Article article) {
		// TODO Auto-generated method stub
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(article);
		tx.commit();
	}

	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub
		Transaction tx =sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().merge(article);
		tx.commit();
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Transaction tx =sessionFactory.getCurrentSession().beginTransaction();
		Article article=(Article)this.getCurrentSession().get(getClass(), id);
		sessionFactory.getCurrentSession().delete(article);
		tx.commit();
	}



	@Override
	public Article findById(Integer id) {
		// TODO Auto-generated method stub
		Transaction tx =getCurrentSession().beginTransaction();
		Query query =getCurrentSession().createQuery("from Article article where article.articleId=?");
		query.setParameter(0, id);
		List<Article> list=query.list();
		tx.commit();
		if(list==null||list.size()==0){
			return null;
		}
		else {
			return  list.get(0);
		}	
	}
	@Override
	public List<Article> showArticles() {
		// TODO Auto-generated method stub
		Transaction tx=getCurrentSession().beginTransaction();
		Query query1 = getCurrentSession().createQuery("select articleId from Top t ");
		List<Integer> ids = query1.list();
		
		Query query = getCurrentSession().createQuery("from Article a where a.articleId not in (:a) order by a.titleTime desc ");
		query.setParameterList("a", ids) ;
		List<Article> list=query.list();
		
		tx.commit();
		return list;
	}

}
