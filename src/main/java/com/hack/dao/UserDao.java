package com.hack.dao;

import org.hibernate.cfg.Configuration;
import java.util.Optional;
import java.util.List;
import com.hack.models.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDao implements CrudDao<User>{
    private Session session;

    public UserDao() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://ec2-54-247-94-127.eu-west-1.compute.amazonaws.com:5432/d1lf9dse4hstsr?sslmode=require");
        configuration.setProperty("hibernate.connection.username", "gbvjvgtwthipcv");
        configuration.setProperty("hibernate.connection.password", "7146e797d2525f55966d79fd19faee8d41a83ca0a8ab12e029a3c6d7cf8b20c1");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.addAnnotatedClass(User.class);
        configuration.setProperty("hibernate.show_sql", "true");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public Optional<User> find(String username){
        User user = (User) session.createQuery("from User user where user.username = :name", User.class).setParameter("name", username).getSingleResult();
        if(user!= null) return Optional.of(user);
        return Optional.empty();
    }

    public void save(User user){
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    public void update(User user){
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    public void delete(User user){
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();;
    }

    public List<User> findAll(){
        return session.createQuery("from User user", User.class).getResultList();
    }
    
}
