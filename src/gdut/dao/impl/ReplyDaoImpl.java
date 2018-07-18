package gdut.dao.impl;

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

}
