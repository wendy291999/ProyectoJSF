/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;


import javax.faces.bean.ManagedBean;
import model.NewHibernateUtil;
import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author wenkary
 */
@ManagedBean(name = "userDAO")
public class UserDAO {
    
    
    public void register(User user){
        Transaction  transaction = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
        catch(Exception  e) {
            System.out.println(e.getMessage());
        }
        finally{
           session.close();
 
        }
    }
  
    public User login(String username, String password) {
        Transaction transaction = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        User user = null;
        try {
            Query query = session.createQuery("from credentials  where username = :username and password = :password");
            query.setParameter("username", username)
                 .setParameter("password", password);
            user = (User) query.uniqueResult();
            transaction.commit();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
           session.close();
 
        }
        return user;
    }
    
}
