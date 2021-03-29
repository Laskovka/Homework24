package homework24.dao;

import homework24.entities.Product;
import homework24.entities.User;
import homework24.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class UserDao {
    private SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public void insertUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            //Чтобы созранить объект в бд - нужно начать транзакцию
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    public void updateUser(User user, long id_user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("UPDATE User " +
                    "SET " +
                    "name =: name, " +
                    "surname =: surname, " +
                    "address =: address, " +
                    "mail =: mail, " +
                    "phone =: phone " +
                    "WHERE id_user =: id_user");
            query.setParameter("name", user.getName());
            query.setParameter("surname", user.getSurname());
            query.setParameter("address", user.getAddress());
            query.setParameter("mail", user.getMail());
            query.setParameter("phone", user.getPhone());
            query.setParameter("id_user", session.get(User.class, id_user).getId_user());
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    public void deleteUser(long id_user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User " +
                    "WHERE id_user =: id_user");
            query.setParameter("id_user", session.get(User.class, id_user).getId_user());
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }
}
