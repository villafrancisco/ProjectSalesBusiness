package SalesBusiness.web.repositorio.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SalesBusiness.web.negocio.Product;
import SalesBusiness.web.repositorio.ProductRepository;
import SalesBusiness.web.repositorio.jdbc.mapper.ProductMapper;

@Repository
public class ProductRepositoryJDBC implements ProductRepository {
    
    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public void update(Product product, int pk_product) {
	plantilla.update("update product set pk_product=?, name=? , fk_category=?, price=? where pk_product=?",product.getPk_product(),product.getName(),product.getCategory().getPk_category(),product.getPrice(),pk_product);

    }

    @Override
    public void insert(Product product) {
	plantilla.update("insert into product (pk_product,name,fk_category, price) values (?,?,?,?)",product.getPk_product(),product.getName(),product.getCategory().getPk_category(),product.getPrice());

    }

    @Override
    public void delete(Product product) {
	plantilla.update("delete from product where pk_product =?",product.getPk_product());

    }

    @Override
    public List<Product> findAll() {
	return plantilla.query("select *, c.name as name_category from product as p INNER JOIN category as c ON p.fk_category=c.pk_category ", new ProductMapper());
    }

    @Override
    public Product findOne(int pk_product) {
	return plantilla.queryForObject("select *, c.name as name_category from product as p INNER JOIN category as c ON p.fk_category=c.pk_category where pk_product=?",new ProductMapper(),pk_product);
    }

    

}
