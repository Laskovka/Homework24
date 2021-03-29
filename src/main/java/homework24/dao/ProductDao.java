package homework24.dao;

import homework24.entities.Category;
import homework24.entities.Product;
import homework24.entities.User;
import homework24.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class ProductDao {
    private SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
//    private static final String INSERT_PRODUCT = "INSERT INTO products (name, id_category, price) VALUES (?, ?, ?)";
//    private static final String UPDATE_PRODUCT = "UPDATE products SET name = ?, id_category = ?, price = ? WHERE id_product = ?";
//    private static final String SELECT_ID_OF_PRODUCT = "SELECT id_product FROM products WHERE name = ? AND id_category = ? AND price = ?";

    public void insertProduct(Product product) {
        try (Session session = sessionFactory.openSession()) {
            //Чтобы созранить объект в бд - нужно начать транзакцию
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    public void updateProduct(Product product, long id_product) {
        CategoryDao categoryDao = new CategoryDao();

        try (Session session = sessionFactory.openSession()) {
            //Чтобы созранить объект в бд - нужно начать транзакцию
            session.beginTransaction();
            Query query = session.createQuery("UPDATE Product " +
                    "SET name =: name, category =: category, price =: price " +
                    "WHERE id_product =: id_product");
            query.setParameter("name", product.getName());
            query.setParameter("category", categoryDao.selectOrInsertCategory(product.getCategory()));
            query.setParameter("price", product.getPrice());
            query.setParameter("id_product", session.get(Product.class, id_product).getId_product());
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }
}
