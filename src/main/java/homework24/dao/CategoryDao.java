package homework24.dao;

import homework24.entities.Category;
import homework24.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDao {
    private SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public Category selectOrInsertCategory(Category category) {
        if(selectCategory(category).size() == 0) {
            try (Session session = sessionFactory.openSession()) {
                //Чтобы созранить объект в бд - нужно начать транзакцию
                session.beginTransaction();
                session.save(category);
                session.getTransaction().commit();
            }
        }
        return (Category) selectCategory(category).get(0);
    }

    public List selectCategory(Category category) {
        try (Session session = sessionFactory.openSession()) {
            //Чтобы созранить объект в бд - нужно начать транзакцию
            session.beginTransaction();
            Query query = session.createQuery("FROM Category WHERE name =: name");
            query.setParameter("name", category.getName());
            List list = query.list();
            return list;
        }
    }
}
