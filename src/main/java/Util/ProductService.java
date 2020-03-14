package Util;

import Entity.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProductService {

    public List<Product> productStock () {
        Session session = HibernateUtil.getSession();

        Query<Product> productStockQuery = session.createQuery("Select u from Product p");

//        Select * from product p;
        return productStockQuery.getResultList();
    }
}
