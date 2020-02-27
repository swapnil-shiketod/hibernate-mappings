package io.swapn.component;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	private static SessionFactory factory;
	static{
		Configuration cfg=null;
		StandardServiceRegistryBuilder builder = null;
		ServiceRegistry registry=null;
		
		//create SessionFactory object
		cfg=new Configuration().configure("io/swapn/component/hibernate.cfg.xml");
		builder=new StandardServiceRegistryBuilder();
		registry=builder.applySettings(cfg.getProperties()).build();
		factory=cfg.buildSessionFactory(registry);
		
	}
	
	public static Session getSession(){
		Session session=null;
		if(threadLocal.get()==null){
			session=factory.openSession();
			threadLocal.set(session);
		}
		
		session=threadLocal.get();
		return session;
	}
	public static void closeSession(){
		Session session=null;
		session=threadLocal.get();
		session.close();
		threadLocal.remove();
	}
	
	public static void closeSessionFactory(){
		factory.close();
	}
}
