package gdut.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import gdut.dao.IArticleDao;
import gdut.po.Article;
import gdut.po.Top;
import gdut.po.User;

public class ArticleDaoImpl implements IArticleDao {

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
		Article article=(Article)this.getCurrentSession().get(Article.class, id);
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
		List<Article> list=null;
		
		Query query1 = getCurrentSession().createQuery("select articleId from Top t ");
		List<Integer> ids = query1.list();
		Query query = getCurrentSession().createQuery("from Article a where a.articleId not in (:a) order by a.titleTime desc ");
		query.setParameterList("a", ids) ;
		list=query.list();
			
		tx.commit();
		
		return list;
	}
	@Override
	public List<Top> showTopArticles() {
		// TODO Auto-generated method stub
		Transaction tx=getCurrentSession().beginTransaction();
		Query query1 = getCurrentSession().createQuery("from Top ");
		List<Top> list=query1.list();
		tx.commit();
		if(list==null||list.size()==0){
			return null;
		}
		else{
			return list;
		}
	
	}
	@Override
	public void deleteTop(Integer id) {
		// TODO Auto-generated method stub
		Transaction tx =sessionFactory.getCurrentSession().beginTransaction();
		Top t =(Top)this.getCurrentSession().get(Top.class, id);
		sessionFactory.getCurrentSession().delete(t);
		tx.commit();
	}

	@Override
	public void insertTop(Integer id) {
		// TODO Auto-generated method stub
		ActionContext context = ActionContext.getContext();
		User user = (User)context.getSession().get("current_user");
		Transaction tx =sessionFactory.getCurrentSession().beginTransaction();
		
		Top top =new Top();
		Article art =(Article)this.getCurrentSession().get(Article.class, id);
		top.setArticleId(id);
		top.setUser(user);
		top.setArticle(art);
		System.out.print("213123"+art+"12312412");
		sessionFactory.getCurrentSession().save(top);
		tx.commit();
	
	}

}
