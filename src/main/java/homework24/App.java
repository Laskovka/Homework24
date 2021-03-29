package homework24;


import homework24.dao.CategoryDao;
import homework24.dao.OrderDao;
import homework24.dao.ProductDao;
import homework24.dao.UserDao;
import homework24.entities.Category;
import homework24.entities.Order;
import homework24.entities.Product;
import homework24.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        /*insert product*/
        /*Category category = new Category("Some category");
        Product product = new Product("Phone", category, 77.7);
        ProductDao productDao = new ProductDao();
        productDao.insertProduct(product);*/

        /*update product*/
        /*Category category = new Category("Some category7");
        Product product = new Product("Phone", category, 77.7);
        ProductDao productDao = new ProductDao();
        productDao.updateProduct(product, 1);*/


        /*insert user*/
        /*User user = new User(
                "Alex",
                "Laskovskyi",
                "prospect",
                "laskovskiu2017@gmail.com",
                "0975104513");
        UserDao userDao = new UserDao();
        userDao.insertUser(user);*/

        /*update user*/
        /*User user = new User(
                "Alexander",
                "Laskovskyi",
                "prospect",
                "laskovskiu2017@gmail.com",
                "0975104513");
        UserDao userDao = new UserDao();
        userDao.updateUser(user, 1);*/

        /*delete user*/
        /*UserDao userDao = new UserDao();
        userDao.deleteUser(4);*/

        /*insert oder*/
        /*Order order = new Order(
                1,
                1,
                50,
                "Good",
                Timestamp.valueOf(LocalDateTime.now()));
        OrderDao orderDao = new OrderDao();
        orderDao.insertOrder(order);*/

        /*update oder*//*
        Order order = new Order(
                1,
                1,
                500,
                "Good",
                Timestamp.valueOf(LocalDateTime.now()));
        OrderDao orderDao = new OrderDao();
        orderDao.updateOrder(order, 1);*/
    }
}
