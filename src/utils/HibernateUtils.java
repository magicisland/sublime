package utils;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	
	public static SessionFactory sessionFactory = null;
	public static Session session=null;
	public Transaction tx=null;
	
	public HibernateUtils(){
		
		sessionFactory=new Configuration().configure().buildSessionFactory();
		
	}
	
	protected void begin(){
		
		session=sessionFactory.openSession();
		tx= session.beginTransaction();
		
	}
	
	protected void commit(){
		
		session.getTransaction().commit();

	}
	
	public void save(Object o){
		
		begin();
		session.save(o);
		commit();
	}
	

	public List<Object[]> get(String sql){
		
		begin();
		List<Object[]> response=null;
		
	 	SQLQuery query= session.createSQLQuery(sql);
		response = query.list();
		
		commit();
		return response;
		
	}
}
