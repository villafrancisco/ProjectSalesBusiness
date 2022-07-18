package SalesBusiness.web.repositorio.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import SalesBusiness.web.negocio.Category;
import SalesBusiness.web.negocio.Product;

public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
	return new Product(rs.getInt("pk_product"),rs.getString("name"),new Category(rs.getInt("fk_category"),rs.getString("name_category")),rs.getDouble("price"));
    }

}
