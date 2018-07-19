package gdut.dao.impl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import gdut.dao.IReplyDao;
import gdut.po.Reply;

public class ReplyDaoImpl implements IReplyDao{
	private SessionFactory sessionFactory;
    
	public void setSessionFactory(SessionFactory sessionFactory){
	       this.sessionFactory=sessionFactory;
	   }
	public SessionFactory getSessionFactory(){
	       return this.sessionFactory;
	   }

	public Session getCurrentSession(){
	       return this.sessionFactory.getCurrentSession();
	   }
	@Override
	public void insert(Reply reply) {
		Transaction tx=this.getCurrentSession().beginTransaction();
		this.getCurrentSession().save(reply);
		tx.commit();
		
	}

	@Override
	public void update(Reply reply) {
		Transaction tx=this.getCurrentSession().beginTransaction();
		this.getCurrentSession().merge(reply);
		tx.commit();
		
	}

	@Override
	public void delete(Reply reply) {
		Transaction tx=this.getCurrentSession().beginTransaction();
		
		this.getCurrentSession().delete(reply);
		
		tx.commit();
		
	}

	@Override
	public Reply findById(Integer id) {
		Transaction tx=this.getCurrentSession().beginTransaction();
		
		return null;
	}
	public int findFloor(Integer articleId) {
		Transaction tx=this.getCurrentSession().beginTransaction();
		Query query = this.getCurrentSession().createQuery("select max(floor) from Reply r where r.article.articleId = ?");
		query.setParameter(0, articleId);
		List res = query.list();
		tx.commit();
		
		return (Integer) res.get(0);
		
	}
}
