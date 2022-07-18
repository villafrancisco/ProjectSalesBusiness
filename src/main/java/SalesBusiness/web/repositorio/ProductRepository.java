package SalesBusiness.web.repositorio;

import java.util.List;

import SalesBusiness.web.negocio.Product;

public interface ProductRepository {
    
    void update(Product product, int pk_product);

    void insert(Product product);

    void delete(Product product);

    List<Product> findAll();

    Product findOne(int pk_product);

    


}
