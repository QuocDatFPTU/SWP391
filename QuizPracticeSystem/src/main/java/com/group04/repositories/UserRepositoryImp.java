/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.email.MailConfig;
import com.group04.entities.Role;
import com.group04.entities.User;
import com.group04.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.hibernate.query.NativeQuery;

/**
 *
 * @author HP
 */
public class UserRepositoryImp implements UserRepository {

    @Override
    public boolean checkLogin(String username, String password) {
        Transaction transaction = null;
        User user = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            user = (User) session.createQuery("FROM User U WHERE U.username = :username").setParameter("username", username)
                    .uniqueResult();
            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

    @Override
    public User login(String username, String password) {
        Transaction transaction = null;
        User user = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            user = (User) session.createQuery("FROM User U WHERE U.username = :username").setParameter("username", username)
                    .uniqueResult();
            if (user != null && user.getPassword().equals(password)) {
                return user;
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public void register(User user) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();        
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println(e);
                transaction.rollback();
            }
        }
    }

    @Override
    public List<User> getAllUser() {
        Transaction transaction = null;
        List<User> listOfUser = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfUser = session.createQuery("from User").getResultList();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return listOfUser;
    }

    @Override
    public Role getRole(String name) {
        Transaction transaction = null;
        Role Role = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Role = (Role) session.createQuery("FROM Role R WHERE R.name = :name").setParameter("name", name)
                    .uniqueResult();
            if (Role != null) {
                return Role;
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Loop Function");
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public User getUserById(Long userID) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            User user = (User) session.createQuery("FROM User U WHERE U.userID = :userID").setParameter("userID",userID)
                    .getSingleResult();
            transaction.commit();
            return user;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateUser(User user) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.evict(user);
            session.merge(user);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void deleteUser(Long userID) {
        User user = this.getUserById(userID);
        user.setActive(false);
        this.updateUser(user);
    }

    @Override
    public void updatePassword(String password, String newpassword) {
        Transaction transaction = null;

        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery(" FROM User u WHERE u.password = :password");
            query.setParameter("password", password);

            User user = (User) query.getSingleResult();
            user.setPassword(newpassword);
            session.merge(user);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("error : " +e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void SendMail(String string) {
        // Tạo đối tượng Email

        Email email = new SimpleEmail();
        email.setHostName(MailConfig.HOST_NAME);
        email.setSmtpPort(MailConfig.SSL_PORT);
        email.setAuthenticator(new DefaultAuthenticator("quizpracticesystem@gmail.com", "QuizPracticeSystem"));
        email.setSSLOnConnect(true);
        try {
            email.setFrom("quizpracticesystem@gmail.com");
            email.addTo("quizpracticesystem@gmail.com");
            email.setSubject("Testing Subject");
            email.setMsg("Code reset password : 1234");
            email.send();
        } catch (EmailException Em) {

        } finally {
            System.out.println("Message sent successfully");
        }

    }

    @Override
    public void resetPassword(String usermail, String newpassword) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT u FROM User u WHERE u.email = :mail");
            query.setParameter("mail", usermail);

            User user = (User) query.getSingleResult();
            user.setPassword(newpassword);
            session.persist(user);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public boolean checkUsernameExist(String username) {
        Transaction transaction = null;
        User user = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Check UsernameExist");
            transaction = session.beginTransaction();
            user = (User) session.createQuery("FROM User U WHERE U.username = :username").setParameter("username", username)
                    .uniqueResult();
            if (user != null) {
                System.out.println("Done check");
                return true;
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("Logging: " + e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

    @Override
    public User getOldPassword(Long userID) {
Transaction transaction = null;
        User user = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            user = (User) session.createQuery("FROM User U WHERE U.userID = :userID").setParameter("userID", userID)
                    .uniqueResult();
            if (user != null) {
                return user;
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("dont work");
                transaction.rollback();
            }
        }
        return null;
    }

    
  
}

    

    
