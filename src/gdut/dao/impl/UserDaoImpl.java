package gdut.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import gdut.dao.IUserDao;
import gdut.po.User;


public class UserDaoImpl implements IUserDao {
	
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
	public void insert(User user) {
		
		
	}

	@Override
	public void update(User user) {
		
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findById(Integer id) {
		
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User selectByUsernameAndPassword(String username, String password) {
		Transaction tx=this.getCurrentSession().beginTransaction();
		Query query = getCurrentSession().createQuery("from User u where u.userName =? and u.psw =?");
		query.setParameter(0, username);
		query.setParameter(1, password);
		List res = query.list();
		tx.commit();
		if(res.size() == 0) {
			return null;
		}
		return (User)res.get(0);
	}
	@Override
	public boolean registUser(User user)
	{
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try
		{
			session.save(user);
			tx.commit();
			
		} catch (Exception e)
		{
			tx.rollback();
			return false;
		}
		return true;
	}
	
	public int selectByUserName(String username) {
		Transaction tx=this.getCurrentSession().beginTransaction();
		Query query = getCurrentSession().createQuery("from User u where u.userName =?");
		query.setParameter(0, username);
		List res = query.list();
		tx.commit();
		
		return res.size();
	}
	
	
	
}
