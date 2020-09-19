package com.hack.dao;

import com.hack.models.Application;
import org.hibernate.cfg.Configuration;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ApplicationDao implements CrudDao<Application>{
    private Session session;

    public ApplicationDao(){
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://ec2-54-247-94-127.eu-west-1.compute.amazonaws.com:5432/d1lf9dse4hstsr?sslmode=require");
        configuration.setProperty("hibernate.connection.username", "gbvjvgtwthipcv");
        configuration.setProperty("hibernate.connection.password", "7146e797d2525f55966d79fd19faee8d41a83ca0a8ab12e029a3c6d7cf8b20c1");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.addAnnotatedClass(Application.class);
        configuration.setProperty("connection.pool_size", "10");
        configuration.setProperty("hibernate.show_sql", "true");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }
    public Application find(String id){
        Application application = (Application) session.createQuery("from Application application where application.id = :id", Application.class).setParameter("id", id).getSingleResult();
        return application;
    }
    public void save(Application application){
        session.beginTransaction();
        session.save(application);
        session.getTransaction().commit();
    }

    public void update(Application application){
        session.beginTransaction();
        session.update(application);
        session.getTransaction().commit();;
    }

    public void delete(Application application){
        session.beginTransaction();
        session.delete(application);
        session.getTransaction().commit();
    }
    
    public List<Application> findAllUser(String userId){
        return session.createQuery("from Application application where application.user_id = :userId", Application.class).setParameter("userId", userId).getResultList();
    }
}
