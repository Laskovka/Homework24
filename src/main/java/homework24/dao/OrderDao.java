package homework24.dao;

import homework24.entities.Order;
import homework24.entities.User;
import homework24.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class OrderDao {
    private SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public void insertOrder(Order order) {
        try (Session session = sessionFactory.openSession()) {
            //Чтобы созранить объект в бд - нужно начать транзакцию
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        }
    }

    /*public void updateOrder(Order order, long id_order) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("UPDATE Order " +
                    "SET " +
                    "id_user =: id_user, " +
                    "id_product =: id_product, " +
                    "count =: count, " +
                    "status =: status, " +
                    "date_of_create =: date_of_create " +
                    "WHERE id_order =: id_order");
            query.setParameter("id_user", order.getId_user());
            query.setParameter("id_product", order.getId_product());
            query.setParameter("count", order.getCount());
            query.setParameter("status", order.getStatus());
            query.setParameter("date_of_create", order.getDate_of_create());
            query.setParameter("id_order", session.get(Order.class, id_order).getId_order());
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }*/
}
